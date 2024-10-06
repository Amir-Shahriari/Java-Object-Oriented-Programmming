/*
 *
 * Reads in the input configuration file, setting up and returning an App instance.
 * This file does not need to be modified, and is here if you wish to look around.
 * 
 * File format:
 * 
 * - base items
 * {NAME}, {DESCRIPTION}, {WEIGHT}
 * 
 * - craftable items
 * {NAME}, {DESCRIPTION}, {COMPONENT 1}, {COMPONENT 2}, ...
 * 
 * - store
 * {STORAGE NAME}
 * {ITEM NAME}, {QTY}
 * {ITEM NAME}, {QTY}
 * ...
 * 
 * - player
 * {WEIGHT CAPACITY}
 * {ITEM NAME}, {QTY}
 * {ITEM NAME}, {QTY}
 * ...
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Reader {
    private static boolean baseItemsRead;
    private static boolean craftableItemsRead;
    private static boolean storeRead;
    private static boolean playerRead;

    static {
        baseItemsRead = false;
        craftableItemsRead = false;
        storeRead = false;
        playerRead = false;
    }

    public static App read(String filePath)
            throws BadStartingItemException, DuplicateItemNameException, craftableItemsReadException,
            ItemDefinedMultipleTimesException {
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

        ArrayList<ItemDefinition> itemDefinitions = ItemDictionary.get().getDefs();
        Storage store = null;
        Player player = null;

        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (!line.isEmpty() && line.charAt(0) == '-') {
                if (line.endsWith("base items")) {
                    readBaseItemDefinitions(scanner, itemDefinitions);
                } else if (line.endsWith("craftable items")) {
                    readCraftableItemDefinitions(scanner, itemDefinitions);
                } else if (line.endsWith("store")) {
                    store = readStorage(scanner, itemDefinitions);
                } else if (line.endsWith("player")) {
                    player = readPlayer(scanner, itemDefinitions);
                }
            }
        }

        return new App(player, store);
    }

    private static boolean duplicateItemName(String name, ArrayList<ItemDefinition> defs) {
        for (ItemDefinition def : defs) {
            if (def.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private static Optional<ItemDefinition> getItemDef(String itemName, ArrayList<ItemDefinition> defs) {
        Optional<ItemDefinition> result = Optional.empty();
        for (ItemDefinition def : defs) {
            if (def.getName().equals(itemName)) {
                result = Optional.of(def);
                break;
            }
        }
        return result;
    }

    // line format
    // {NAME}, {DESCRIPTION}, {WEIGHT}, ...
    private static void readBaseItemDefinitions(Scanner sc, ArrayList<ItemDefinition> defs)
            throws BadStartingItemException, DuplicateItemNameException {
        if (Reader.baseItemsRead) {
            throw new BadStartingItemException("Base Items in data file are not stored together");

        }
        Reader.baseItemsRead = true;

        String itemLine = sc.nextLine();
        do {
            String[] parts = itemLine.split(",");

            String name = parts[0].trim();
            // Disallow duplicate item names
            if (Reader.duplicateItemName(name, defs)) {
                throw new DuplicateItemNameException("The item name '%s' is used multiple times");

            }
            String description = parts[1].trim();
            double weight = Double.valueOf(parts[2].trim());

            ItemDefinition def = new ItemDefinition(name, description, Optional.of(weight), new String[0]);
            defs.add(def);
            itemLine = sc.nextLine();
        } while (sc.hasNextLine() && !itemLine.isEmpty());

    }

    // line format
    // {NAME}, {DESCRIPTION}, {COMPONENT 1}, {COMPONENT 2}, ...
    private static void readCraftableItemDefinitions(Scanner sc, ArrayList<ItemDefinition> defs)
            throws craftableItemsReadException, ItemDefinedMultipleTimesException {
        if (Reader.craftableItemsRead) {
            throw new craftableItemsReadException("Craftable Items in data file are not stored together");

        }
        Reader.craftableItemsRead = true;

        String itemLine = sc.nextLine();
        do {
            String[] parts = itemLine.split(",");

            String name = parts[0].trim();
            // Disallow duplicate item names
            if (Reader.duplicateItemName(name, defs)) {
                throw new ItemDefinedMultipleTimesException("The item is defined multiple times");

            }
            String description = parts[1].trim();

            //

            String[] components = new String[parts.length - 2];
            for (int i = 2; i < parts.length; i++) {
                components[i - 2] = parts[i].trim();
            }

            ItemDefinition itemDefinition = new ItemDefinition(name, description, Optional.empty(), components);

            defs.add(itemDefinition);
            itemLine = sc.nextLine();
        } while (sc.hasNextLine() && !itemLine.isEmpty());

    }

    // line format: {STORAGE NAME}, {ITEM NAME}, {QTY}, {ITEM NAME}, {QTY}, ...
    private static Storage readStorage(Scanner sc, ArrayList<ItemDefinition> itemDefinitions)
            throws BadStartingItemException {
        if (Reader.storeRead) {
            System.err.println("Store written twice or more in data file");
            System.exit(0);
        }
        Reader.storeRead = true;

        String name = sc.nextLine().trim();
        Inventory startingInventory = readStartingItems(sc, itemDefinitions);
        Storage storage = new Storage(name, startingInventory);
        return storage;
    }

    // line format; {WEIGHT CAPACITY}, {ITEM NAME}, {QTY}, {ITEM NAME}, {QTY}, ...
    private static Player readPlayer(Scanner sc, ArrayList<ItemDefinition> items) throws BadStartingItemException {
        if (Reader.playerRead) {
            System.err.println("Player written twice or more in data file");
            System.exit(0);
        }
        Reader.playerRead = true;

        String name = System.getProperty("user.name");
        double carryCapacity = Double.valueOf(sc.nextLine());
        Inventory startingInventory = readStartingItems(sc, items);
        return new Player(name, carryCapacity, startingInventory);
    }

    /**
     * Line format:
     * {NAME | WEIGHT CAPACITY}, {ITEM NAME}, {QTY}, {ITEM NAME}, {QTY}, ...
     * 
     * @param data - The result of splitting the `player` or `store` line of the
     *             config by ","
     * @return
     * @throws BadStartingItemException
     */
    private static Inventory readStartingItems(Scanner sc, ArrayList<ItemDefinition> itemDefinitions)
            throws BadStartingItemException {
        Inventory startingInventory = new Inventory();

        String line = sc.nextLine();
        while (!line.isEmpty() && sc.hasNextLine()) {
            String[] data = line.split(",");
            String name = data[0].trim();
            int qty = Integer.valueOf(data[1].trim());

            Optional<ItemDefinition> optDef = getItemDef(name, itemDefinitions);
            if (optDef.isPresent()) {
                ItemDefinition def = optDef.get();
                if (def.isBaseItemDef()) {
                    for (int i = 0; i < qty; i++) {
                        startingInventory.addOne(def.create());
                    }
                } else {

                    for (int i = 0; i < qty; i++) {
                        Item craftedItem = def.create();
                        for (String componentName : def.componentsString().split(", ")) {
                            Optional<ItemDefinition> componentDefOpt = getItemDef(componentName, itemDefinitions);
                            if (componentDefOpt.isPresent()) {
                                craftedItem.getComponents().add(componentDefOpt.get().create());
                            }
                        }
                        startingInventory.addOne(craftedItem);
                    }
                }
            } else {
                throw new BadStartingItemException("Bad starting item '" + name + "' was read. Exiting early");
            }
            line = sc.nextLine();
        }
        // One left behind
        String[] data = line.split(",");
        if (!line.isBlank()) {
            int qty = Integer.valueOf(data[1].trim());
            getItemDef(data[0], itemDefinitions).ifPresentOrElse(
                    (def) -> {
                        for (int i = 0; i < qty; i++) {
                            startingInventory.addOne(def.create());
                        }
                    },
                    () -> {
                        System.err.println("Bad starting item '" + data[0] + "' was read. Exiting early");
                        System.exit(0);
                    });
        }

        return startingInventory;
    }
}

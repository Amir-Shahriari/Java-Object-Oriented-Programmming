import java.util.Arrays;

import java.util.List;

import javax.swing.JFrame;

public class App {
    private Player player;
    private Storage storage;
    private JFrame frame;
    private PageManager manager;

    public App(Player p, Storage s) {
        player = p;
        storage = s;
        storage.addObserver(player);
        player.update(storage);
        manager = new PageManager(player, storage);

        // Setup of sorting
        setupSearching((InventoryPage) manager.findPage("Player Inventory"));
        setupSearching((InventoryPage) manager.findPage("Storage"));

        // Setup of craftng
        setupCrafting((ItemCraftPage) manager.findPage("Item Crafting"), player);
        setupUncrafting((ProductPage) manager.findPage("Product Page"), player);

        // Window creation
        manager.refresh();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(manager.getJPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Task 1: Defining what each button in the UI will do.
    void setupSearching(InventoryPage page) {
        page.addSearchByButton(new SearchByButton("All", () -> {
            player.getInventory().setSearch(new AllSearchStrategy()); ////
            player.getStorageView().setSearch(new AllSearchStrategy());////
        }));

        page.addSearchByButton(new SearchByButton("Name", () -> {
            player.getInventory().setSearch(new NameSearchStrategy());/////
            player.getStorageView().setSearch(new NameSearchStrategy());////
        }));

        page.addSearchByButton(new SearchByButton("Description", () -> {
            player.getInventory().setSearch(new DescriptionSearchStrategy());///
            player.getStorageView().setSearch(new DescriptionSearchStrategy());///
        }));
    }

    void setupCrafting(ItemCraftPage page, Player player) {
        page.setCraftAction((def) -> {

            List<String> requiredComponents = Arrays.asList(def.componentsString().split(", "));

            boolean hasAllComponents = requiredComponents.stream()
                    .allMatch(componentName -> player.getInventory()
                            .qtyOf(ItemDictionary.get().defByName(componentName).get()) > 0);

            if (hasAllComponents) {
                Item craftedItem = new Item(def);
                for (String componentName : requiredComponents) {
                    Item componentItem = (Item) ItemDictionary.get().defByName(componentName).get().create();
                    player.getInventory().removeOne(ItemDictionary.get().defByName(componentName).get());
                    craftedItem.addComponent(componentItem);
                }
                player.getInventory().addOne(craftedItem);
                System.out.println("Crafted " + craftedItem.getName());
            } else {

                System.out.println("Missing required components for crafting.");
            }

        });
    }

    void setupUncrafting(ProductPage page, Player player) {
        page.setUncraftAction((item) -> {

            if (!item.getComponents().isEmpty()) {
                for (ItemInterface component : item.getComponents()) {
                    player.getInventory().addOne(component);
                }
                player.getInventory().remove(item);
                System.out.println("Removed crafted item from inventory: " + item.getName());

            } else {
                System.out.println("Item is not a craftable item: " + item.getName());
            }

        });
    }

}


public class Player implements Observer {
    private String name;
    private Inventory inventory;
    private double carryWeightCapacity;
    private Inventory storageView = new Inventory();

    public Player(String playerName, double carryCapacity, Inventory sInventory) {
        name = playerName;
        carryWeightCapacity = carryCapacity;
        inventory = sInventory;
    }

    public Inventory getStorageView() {
        return storageView;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public double getCarryCapacity() {
        return carryWeightCapacity;
    }

    public double getCurrentWeight() {
        double carrying = 0;
        for (ItemInterface item : getInventory().searchItems("")) {
            carrying += item.getWeight();
        }
        return carrying;
    }

    public void store(ItemInterface item, Storage storage) throws ItemNotAvailableException {
        // Check if the player's inventory contains the item
        if (!inventory.contains(item)) {
            throw new ItemNotAvailableException(item.getDefinition());///////
        }

        storage.store(item);
        inventory.remove(item);

    }

    public void retrieve(ItemInterface item, Storage storage) throws ItemNotAvailableException, ExceedWeightCapacity {
        // Check if the storage contains the item
        if (!storage.getInventory().contains(item)) {
            throw new ItemNotAvailableException(item.getDefinition());//////
        }

        if (getCurrentWeight() + item.getWeight() > getCarryCapacity()) {
            throw new ExceedWeightCapacity(this, item);///////
        }

        storage.retrieve(item);
        inventory.addOne(item);
    }

    @Override
    public void update(Storage storage) {
        this.storageView = new Inventory(storage.getInventory().searchItems(""));
        System.out.println("player view updated");
    }
}

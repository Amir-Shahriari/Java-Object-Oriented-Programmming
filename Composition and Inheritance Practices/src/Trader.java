import java.util.Optional;

public class Trader {
    protected String name;
    protected Inventory inventory;

    public Trader(String traderName, Inventory startingInventory) {
        name = traderName;
        inventory = startingInventory;
    }

    public void addItem(ItemInterface item) {
        inventory.addOne(item);
    }

    public Optional<ItemInterface> removeItem(String itemName) {
        return inventory.removeOne(itemName);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public Optional<ItemInterface> sell(String itemName) {
        Optional<ItemInterface> result = removeItem(itemName);
        if (result != null) {
            return result;
        }
        return Optional.empty();
    }

    public void buy(ItemInterface item) {
        inventory.addOne(item);
    }

}


public class Wand implements ItemInterface {
    private Item item;

    public Wand(int expiry) {
        this.item = new Item("Wand", "A magic wand!", 100.0, expiry == -1 ? "NO_EXPIRY" : String.valueOf(expiry));
    }

    @Override
    public InventoryTableRow getInventoryTableRow() {
        return item.getInventoryTableRow();
    }

    @Override
    public CartTableRow getCartRow(String column3) {
        return item.getCartRow(column3);
    }
}

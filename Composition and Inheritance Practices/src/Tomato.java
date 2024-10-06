
public class Tomato implements ItemInterface {
    private Item item;

    public Tomato(int expiry) {
        this.item = new Item("Tomato", "Red and round", 15.0, expiry == -1 ? "NO_EXPIRY" : String.valueOf(expiry));
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

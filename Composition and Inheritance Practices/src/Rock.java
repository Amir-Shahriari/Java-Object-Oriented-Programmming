
public class Rock implements ItemInterface {
    private Item item;

    public Rock(int expiry) {
        this.item = new Item("Rock", "Rock :D", 5.0, expiry == -1 ? "NO_EXPIRY" : String.valueOf(expiry));
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

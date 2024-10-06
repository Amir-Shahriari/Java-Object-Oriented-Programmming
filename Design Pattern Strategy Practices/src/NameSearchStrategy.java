import java.util.ArrayList;

public class NameSearchStrategy implements SearchStrategy {
    @Override
    public ArrayList<ItemInterface> search(ArrayList<ItemInterface> stock, String term) {
        ArrayList<ItemInterface> result = new ArrayList<>();
        for (ItemInterface item : stock) {
            if (item.getName().toLowerCase().contains(term.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }
}
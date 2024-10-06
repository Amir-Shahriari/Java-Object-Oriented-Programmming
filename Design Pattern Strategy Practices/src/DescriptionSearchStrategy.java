import java.util.ArrayList;

public class DescriptionSearchStrategy implements SearchStrategy {
    @Override
    public ArrayList<ItemInterface> search(ArrayList<ItemInterface> stock, String term) {
        ArrayList<ItemInterface> result = new ArrayList<>();
        for (ItemInterface item : stock) {
            if (item.getDescription().toLowerCase().contains(term.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }
}
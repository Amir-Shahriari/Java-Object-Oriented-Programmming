import java.util.ArrayList;
import java.util.List;

public class Storage implements Observable {
    private String storageName;
    private Inventory items;
    private List<Observer> observers = new ArrayList<>();

    public Storage(String name, Inventory startingInventory) {
        storageName = name;
        items = startingInventory;
    }

    public Inventory getInventory() {
        return items;
    }

    public String getName() {
        return storageName;
    }

    public void store(ItemInterface item) {
        items.addOne(item);
        for (Observer observer : observers) {
            observer.update(this);
        }

    }

    public ItemInterface retrieve(ItemInterface item) throws ItemNotAvailableException {
        if (!items.contains(item)) {
            throw new ItemNotAvailableException(item.getDefinition());///////
        }
        ItemInterface removed = items.remove(item);
        for (Observer observer : observers) {
            observer.update(this);
        }

        return removed;
    }

    @Override
    public void notifyObservers(Observable observable) {
        for (Observer observer : observers) {

            observer.update(this);
        }
    }

    @Override
    public void addObserver(Observer observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

}

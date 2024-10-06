import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Item implements ItemInterface {
    private ItemDefinition definition;
    private List<ItemInterface> components; // This would be non-empty only for crafted items

    /**
     * Creates an Item instance with a set definition.
     * The composition list is (created but) left empty. For composite items, the
     * sub-components
     * should be retrieved/removed from some item source, and added with
     * Item::Add(ItemInterface).
     * 
     * @param def
     */
    public Item(ItemDefinition def) {
        definition = def;
        components = new ArrayList<>();
    }

    public void addComponent(Item component) {
        components.add(component);
    }

    public void removeComponent(Item component) {
        components.remove(component);
    }

    public Item getComponent(int index) {
        return (Item) components.get(index);
    }

    @Override
    public double getWeight() {
        String[] componentNames = getDefinition().componentsString().split(", ");
        double componentWeight = Arrays.stream(componentNames)
                .mapToDouble(name -> {
                    Optional<ItemDefinition> componentDef = ItemDictionary.get().defByName(name);
                    return componentDef.map(ItemDefinition::getWeight).orElse(Optional.of(0.0)).get();
                })
                .sum();

        return componentWeight + getDefinition().getWeight().orElse(0.0);
    }

    public List<ItemInterface> getComponents() {
        return components;
    }

    public boolean isCraftedItem() {
        return !components.isEmpty();
    }

    @Override
    public String getName() {
        return definition.getName();
    }

    @Override
    public String getDescription() {
        return definition.getDescription();
    }

    @Override
    public ItemDefinition getDefinition() {
        return definition;
    }

    @Override
    public String getCompositionDescription() {
        if (isCraftedItem()) {
            StringBuilder description = new StringBuilder();
            for (int i = 0; i < components.size(); i++) {
                description.append(components.get(i).getName());
                if (i < components.size() - 1) {
                    description.append(", ");
                }
            }
            return description.toString();
        }
        return "";
    }

    @Override
    public boolean equals(ItemInterface other) {
        return isOf(other.getDefinition());
    }

    @Override
    public boolean isOf(ItemDefinition def) {
        return getName().equals(def.getName());
    }

    @Override
    public String toString() {
        String output = String.format("Item: %s\nDescription: %s\nWeight: %.2f",
                getName(), getDescription(), getWeight());
        output += "\nHashCode: " + Integer.toHexString(this.hashCode());
        return output;
    }

}
public class Main {
    public static void main(String[] args)
            throws BadStartingItemException, DuplicateItemNameException, craftableItemsReadException,
            ItemDefinedMultipleTimesException {
        Reader.read("./data/config.txt");
    }
}

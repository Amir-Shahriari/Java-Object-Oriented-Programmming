# Task 1
Behavioural pattern - Options: *Strategy* or *Observer* pattern.
You chose: <Strategy Pattern>

## Itemise changes made (which class files were modified)
1. Firstly i had to create the SearchStrategy.java interface for the concrete strategies so i can use them interchangeable, then i created the classes for Name, All, Description search strategies (NameSearchStrategy.java, AllSearchStrategy.java, DescriptionSearchStrategy.java). Then i modified the Inventory.java class as needed,firstly i initialize an object of the SearchStrategy and then set Default to AllSearchStrategy, then i modified the public void setSearch(String strategy) to setSearch(SearchStrategy strategy) so we can pass an object of SearchStrategy to it rather than a string which was the main problem we wanted to solve, then i modified the  public ArrayList<ItemInterface> searchItems(String searchTerm) so the method uses the SearchStrategy that has been set by setSearch method, the implementation of each strategy is now inside each of their respective classes rather than being all in one place. Lastly, i modified the void setupSearching(InventoryPage page) in App.java class so it follows the right implementation of setSearch(SearchStrategy strategy) rather than taking a string.

# Task 2
Structural pattern - *Composite* pattern.

## Itemise changes made (which class files were modified)
1. My first approach to implement the composition pattern was to create a new class CraftableItem.java which will implement the ItemInterface but unfortunately the UI button wouldn't appear unless the crafteditem is a type of Item not an object of ItemInterface. So, to make the setCraft and setUncraft button work i needed to modify the Item.java, so i added a field 'private List<Item> components' which is only non-empty for the crafted items and also added two new methods, public boolean isCraftedItem() and public List<Item> getComponents() then i modified public String getCompositionDescription() which was returning an empty string before, but now it will return the list of components for the composite items only and return an empty string for the base Items. I also added methods such as public void removeComponent(Item component), public void addComponent(Item component) and public Item getComponent(int index) which can be useful to manipulate the composite item. After implementation of the composite pattern i added the logic of crafting and uncrafting to the App.java so when the buttons are clicked the the crafting and uncrafting happens. this had almost covered the whole task but there was one crafted item that is created when the config file is read at the run time which didnt have any list of components or a composite description so the uncraft button was not appearing for it. to address this issue i had to make a change to the method private static Inventory readStartingItems(Scanner sc, ArrayList<ItemDefinition> itemDefinitions) in Reader.java to make sure that the Reader file will create the crafted item according to the conditions that can make the uncraft button appear which is the item should have a list of components(a non empty CompositionDescription).

# Task 3

## Itemised changes or new files
1. for the first improvement i decided to implement Observer pattern for task 1 option two, so i created two new interfaces(Observable.java and Observer.java) i also modified the Storage.java, Player.java and App.java to follow the implementation of Observer pattern.

## What was changed
1. i have added the methods defined in the Observer and Observable interface to implement the Observer pattern on the player and storage so the player would be an Observer of the Storage, i added the method  public void update(Storage storage) from the Observer interface to Player.java and added the methods void addObserver(Observer observer) void removeObserver(Observer observer) void notifyObservers(Observable observable) from the Observable interface to Storage.java so i can manipulate the observers of the storage whenever i need, then i removed the part of the code from App.java when it was giving a hard copy of the storage to the player and now it is adding the player to the list of observers defined for the storage instead, then i used the Update method so the storage view will be fetched to the player storage for the first time and ready to see.

## Why it was changed
1. the program was initially passing a hard copy of the storage to the player and it was indeed a bad practice specially when the game is going to be multiplayer later and we want all the players have their own view of the storage without having a hard copy passed at the start of the program.

## The benefits of the change
1. well this can be very beneficial It allows for easy addition or removal of observers without modifying the subject. You can introduce new observers or change existing ones without affecting the rest of the system, making it highly extensible.

# Task 3

## Itemised changes or new files
2. for the second improvement i decided to complete the exception handling implementation for already existing custom exceptions and then i created few other custom exceptions to use in Reader.java since there were many cases in the code when it was just printing out the error and then exiting the program which is not ideal, i created new custom exceptions craftableItemsReadException.java, BadStartingItemException.java, ItemDefinedMultipleTimesException.java and DuplicateItemNameException.java and added the throw declartion to the methods that are going to use the exceptions in Reader.java, i also modified some of the methods in the Storage.java and Player.java so they directly throw and exception if the Item is not available or the player exceed the weight capacity.
## Why it was changed
2. the initial method in Reader.java when encountering an exception was to print out an error in the console but this is not the proper way of exception handling.
## The benefits of the change
2. the benefits of the change is that now we can handle each of the exceptions differently and can have different implementation in each of them rather than only printing out the error message, the custom exception classes now can carry on other tasks if needed and the process of exception handling can be changed in anyway we might need in the future.
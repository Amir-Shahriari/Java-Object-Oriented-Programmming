# Inventory System Refactor

## Overview

This repository contains a refactored inventory management system designed to be used in game development. The system includes a set of classes and interfaces responsible for managing game items, user transactions, and inventory operations. The code has been structured to ensure modularity, maintainability, and ease of future extension.

## Code Breakdown

### 1. Handling Return Values

The system was originally implemented using "magic numbers" and null values to indicate different return statuses, which made it error-prone and hard to debug. The current implementation refactors these methods by replacing the magic numbers and null values with more appropriate return mechanisms.

- **Enums**: Used to represent status codes for success, failure, or error conditions, providing a more readable and maintainable approach.
- **Exception Handling**: Used in scenarios where failures are exceptional and need explicit handling by the calling code.

### 2. Transaction Management

The system manages user transactions, particularly purchasing and selling of in-game items, through the `Player` and `Seller` classes. Redundant code between these classes has been minimized by introducing inheritance in a more structured manner.

- **Inheritance**: Key functionality that is common between `Player` and `Seller` has been refactored into a parent class, allowing both classes to share methods related to transactions.
- **Specialized Methods**: Each class retains methods for operations that are unique to either the player or the seller, ensuring flexibility where needed.

### 3. Item Management Using Composition

Previously, the system relied heavily on inheritance for managing different types of items, which created a rigid and inflexible structure. The refactor transitions to a composition-based approach for handling item behaviors.

- **Composition over Inheritance**: Item functionality is now broken into smaller, reusable components, allowing for more flexible item creation and behavior extension.
- **Static Item Creation**: The `ItemReader` class contains a method responsible for creating instances of items. This method has been modified to support the composition-based item creation.
- **Interfaces**: The `ItemInterface` and `BasketInterface` have been retained to ensure compatibility with the user interface. The method signatures remain unchanged, but their implementations have been updated to work with the new composition-based design.

### 4. Data Models

The system uses two main data models, `InventoryTableRow` and `CartTableRow`, to represent the structure of the inventory and the transaction cart, respectively. These models are used to store and display data related to items and transactions.

- **InventoryTableRow**: Represents individual items stored in a player’s inventory or available for sale.
- **CartTableRow**: Represents items currently added to the player’s purchase or sale cart, along with relevant transaction information.

### 5. User Interface Integration

The inventory system has been integrated with a basic user interface that allows users to interact with the inventory and transaction components. The UI remains largely unchanged, but is designed to work seamlessly with the refactored system.

---

## Key Characteristics

- **Modular Design**: The refactored codebase follows best practices for modularity, making it easy to extend and maintain in the future.
- **Error Handling**: Replacing magic numbers and null values with enums and exceptions ensures clearer error handling.
- **Flexible Item Management**: The switch to composition for items makes it easier to introduce new item types and behaviors without modifying core classes.
- **Inheritance and Composition**: Used judiciously to reduce redundancy and ensure the system is flexible without overcomplicating the code structure.



# 🛒 Shopping Cart System (JavaFX & Custom HashMap)
This project is a fully functional desktop shopping cart application built with JavaFX. Its core data structure is a custom-built generic HashMap created from scratch, demonstrating a practical application of data structures in a real-world scenario.

This application was developed as a solution for an assignment in CSC329: Data Structures and Algorithms II, which required implementing a generic HashMap and using it to build a complete application.



# ✨ Features
Customer Selection: Choose from a pre-populated list of customers to manage individual shopping carts.

Store Catalog: View a list of available items in the store.

Add & Remove: Easily add items to a customer's cart or remove them.

Dynamic Total: The cart total updates in real-time as items are added or removed.

Checkout: Finalize a purchase, which displays a success message with the total and clears the customer's cart.

Interactive GUI: A clean and intuitive user interface built with JavaFX and FXML.



# 🛠️ Technical Highlights
Custom Generic HashMap (MyHashMap.java):

The entire backend is powered by a MyHashMap<K, V> class built from the ground up.

Implements put, get, remove, containsKey, keys, values, and entrySet.

Uses separate chaining (via java.util.LinkedList) to handle hash collisions.

Fulfills the assignment constraint of not using java.util.HashMap or HashTable.

Data Structure Design (ShoppingCartSystem.java):

The main data structure is MyHashMap<Customer, ArrayList<Item>>.

This maps a Customer object (key) to a list of Item objects (value), fulfilling the project requirement for the value to be a list of objects.

Object-Oriented Data Models:

Customer.java: Custom class for customers with customerId, name, and email.

Item.java: Custom class for items with sku, name, and price.

Both models correctly implement equals() and hashCode() based on their unique IDs (customerId, sku) for proper HashMap functionality.

MVC Architecture:

Model: Customer.java, Item.java, ShoppingCartSystem.java

View: ShoppingCart.fxml

Controller: ShoppingCartController.java



# 🚀 How to Run
Clone the repository:

Bash

git clone [Your-Repo-URL]
Open in your IDE:

Open the project as a Maven project in an IDE like IntelliJ IDEA or Eclipse.

Run the application:

Navigate to src/main/java/com/shoppingcart/shoppingcarthashmap/Launcher.java.

Run the main method.

or

Run with Maven:

Use the provided Maven wrapper to run the JavaFX application:

Bash

# On macOS/Linux
./mvnw clean javafx:run

# On Windows
./mvnw.cmd clean javafx:run
📋 How to Use
Select a Customer: Choose a customer (e.g., "Alice") from the dropdown menu.

Add Items: Click an item in the "Store Items" list (left) and then click the "--> Add to Cart -->" button.

Remove Items: Click an item in the "Shopping Cart" list (right) and then click the "<-- Remove from Cart <--" button.

View Total: Observe the "Total: $X.XX" label at the bottom update automatically.

Checkout: When finished, click the "Checkout" button. A confirmation alert will show the final total, and the cart will be cleared.

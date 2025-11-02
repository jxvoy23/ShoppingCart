package com.shoppingcart.shoppingcarthashmap;// File: ShoppingCartController.java
// Name: Joel Rodriguez
// RAM ID: R02192039
// I certify that this submission is my own individual work, with
// the assistance of Google Gemini (AI tool).

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.util.ArrayList;

public class ShoppingCartController {

    private ShoppingCartSystem system = new ShoppingCartSystem();
    private Customer currentCustomer;
    private ObservableList<Customer> customerList = FXCollections.observableArrayList();
    private ObservableList<Item> storeItemList = FXCollections.observableArrayList();
    private ObservableList<Item> cartItemList = FXCollections.observableArrayList();

    @FXML private ComboBox<Customer> customerComboBox;
    @FXML private ListView<Item> storeListView;
    @FXML private ListView<Item> cartListView;
    @FXML private Label totalLabel;
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private Button checkoutButton;

    @FXML
    public void initialize() {
        initializeData();

        customerComboBox.setItems(customerList);
        storeListView.setItems(storeItemList);
        cartListView.setItems(cartItemList);

        customerComboBox.setOnAction(e -> {
            currentCustomer = customerComboBox.getValue();
            updateCartView();
        });
    }

    @FXML
    private void onAddButton() {
        Item selectedItem = storeListView.getSelectionModel().getSelectedItem();
        if (currentCustomer == null) {
            showAlert("No Customer", "Please select a customer first.");
        } else if (selectedItem == null) {
            showAlert("No Item", "Please select an item from the store to add.");
        } else {
            system.addItem(currentCustomer, selectedItem);
            updateCartView();
        }
    }

    @FXML
    private void onRemoveButton() {
        Item selectedItem = cartListView.getSelectionModel().getSelectedItem();
        if (currentCustomer == null) {
            showAlert("No Customer", "Please select a customer first.");
        } else if (selectedItem == null) {
            showAlert("No Item", "Please select an item from your cart to remove.");
        } else {
            system.removeItem(currentCustomer, selectedItem);
            updateCartView();
        }
    }

    @FXML
    private void onCheckoutButton() {
        if (currentCustomer == null) {
            showAlert("No Customer", "Please select a customer first.");
        } else if (system.getCart(currentCustomer).isEmpty()) {
            showAlert("Empty Cart", "Your cart is empty.");
        } else {
            double total = system.checkout(currentCustomer);
            showAlert("Checkout Successful",
                    "Thank you for shopping, " + currentCustomer.getName() + "!\n" +
                            "Your total is $" + String.format("%.2f", total) + ".\n" +
                            "Your cart has been cleared.");
            updateCartView();
        }
    }

    private void updateCartView() {
        if (currentCustomer == null) {
            cartItemList.clear();
            totalLabel.setText("Total: $0.00");
            return;
        }

        ArrayList<Item> cart = system.getCart(currentCustomer);
        cartItemList.setAll(cart);

        double total = 0.0;
        for (Item item : cart) {
            total += item.getPrice();
        }
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void initializeData() {
        customerList.add(new Customer("c123", "Alice", "alice@example.com"));
        customerList.add(new Customer("c456", "Bob", "bob@example.com"));
        customerList.add(new Customer("c789", "Charlie", "charlie@example.com"));

        storeItemList.add(new Item("i001", "Apple", 0.99));
        storeItemList.add(new Item("i002", "Bread", 3.49));
        storeItemList.add(new Item("i003", "Milk (1 Gallon)", 2.79));
        storeItemList.add(new Item("i004", "Coffee (Bag)", 8.99));
        storeItemList.add(new Item("i005", "Banana (Bunch)", 1.89));
        storeItemList.add(new Item("i006", "Cereal", 4.29));
        storeItemList.add(new Item("i007", "Chicken Breast", 9.50));
        storeItemList.add(new Item("i008", "Eggs (Dozen)", 3.19));
        storeItemList.add(new Item("i009", "Orange Juice", 3.79));
        storeItemList.add(new Item("i010", "Pasta", 1.50));
        storeItemList.add(new Item("i011", "Pasta Sauce", 2.50));
        storeItemList.add(new Item("i012", "Ground Beef", 5.49));
        storeItemList.add(new Item("i013", "Lettuce", 1.99));
        storeItemList.add(new Item("i014", "Tomatoes (Vine)", 2.99));
        storeItemList.add(new Item("i015", "Yogurt", 0.89));
        storeItemList.add(new Item("i016", "Soap (Bar)", 1.29));
        storeItemList.add(new Item("i017", "Shampoo", 6.99));
        storeItemList.add(new Item("i018", "Paper Towels", 12.99));
        storeItemList.add(new Item("i019", "Frozen Pizza", 5.99));
        storeItemList.add(new Item("i020", "Ice Cream", 4.99));
    }
}
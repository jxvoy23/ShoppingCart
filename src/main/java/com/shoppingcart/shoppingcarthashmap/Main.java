package com.shoppingcart.shoppingcarthashmap;// File: Main.java
// Name: [Your Name]
// RAM ID: [Your RAM ID]
// I certify that this submission is my own individual work, with
// the assistance of Google Gemini (AI tool).

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Main application class. This class only loads the FXML file
 * and sets up the stage, as required for a Scene Builder application.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ShoppingCart.fxml")));

        // Set up the scene and stage
        primaryStage.setTitle("Shopping Cart System (FXML)");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

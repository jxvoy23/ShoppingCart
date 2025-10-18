module com.shoppingcart.shoppingcarthashmap {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.shoppingcart.shoppingcarthashmap to javafx.fxml;
    exports com.shoppingcart.shoppingcarthashmap;
}
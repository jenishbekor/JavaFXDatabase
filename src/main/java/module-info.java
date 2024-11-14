module com.example.demo1gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.demo1gui to javafx.fxml;
    exports com.example.demo1gui;
}
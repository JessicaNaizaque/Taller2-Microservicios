module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.ws.rs;

    opens org.example to javafx.fxml;

    exports org.example.trips;
    exports org.example;
}

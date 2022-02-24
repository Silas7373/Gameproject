module com.example.idleplanet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.idleplanet to javafx.fxml;
    exports com.example.idleplanet;
}
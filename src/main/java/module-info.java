module com.example.baza {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.baza to javafx.fxml;
    exports com.example.baza;
}
package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class SprzedawcaUsuwanie {

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Sprzedawca.fxml");
    }

    @FXML
    void btnConfirm(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Sprzedawca.fxml");
    }

}

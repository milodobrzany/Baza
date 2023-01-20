package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Klient {

    @FXML
    void btnDeleteAcc(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("KlientUsuwanie.fxml");
    }

    @FXML
    void btnHistory(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Historia.fxml");
    }

    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Niezarejestrowany.fxml");
    }

    @FXML
    void btnProducts(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Przegladanie.fxml");
    }

}

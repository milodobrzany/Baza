package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Niezarejestrowany {

    @FXML
    void btnLogowanie(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Login.fxml");
    }

    @FXML
    void btnPrzegladanie(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Przegladanie.fxml");
    }

    @FXML
    void btnRejestracja(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Rejestracja.fxml");
    }

}

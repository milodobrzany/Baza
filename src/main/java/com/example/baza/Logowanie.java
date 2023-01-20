package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Logowanie {

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfEmail;

    @FXML
    void btnLogin(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Sprzedawca.fxml");
    }

    @FXML
    void btnZmiana(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Niezarejestrowany.fxml");
    }

}

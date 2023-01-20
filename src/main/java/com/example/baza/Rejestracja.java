package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Rejestracja {

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfFlatNumber;

    @FXML
    private TextField tfHomeNumber;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfPostalCode;

    @FXML
    private TextField tfStreet;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Niezarejestrowany.fxml");
    }

    @FXML
    void btnRegister(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Klient.fxml");
    }

}

package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Sprzedawca {


    @FXML
    void btnAddProducts(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Dodawanie.fxml");
    }

    @FXML
    void btnDeleteAcc(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("SprzedawcaUsuwanie.fxml");
    }

    @FXML
    void btnDeletionFullfilment(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Usuwanie.fxml");
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
    void btnOrderFullfilment(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Zamowienie.fxml");
    }

    @FXML
    void btnProducts(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Przegladanie.fxml");
    }

}

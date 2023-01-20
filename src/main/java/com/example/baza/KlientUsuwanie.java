package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class KlientUsuwanie {

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Klient.fxml");
    }

    @FXML
    void btnConfirm(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Klient.fxml");
    }

}

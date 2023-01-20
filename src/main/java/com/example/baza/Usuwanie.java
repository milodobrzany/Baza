package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Usuwanie {

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Sprzedawca.fxml");
    }

}

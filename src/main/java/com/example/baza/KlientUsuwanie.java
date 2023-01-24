package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KlientUsuwanie {

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Klient.fxml");
    }

    @FXML
    void btnConfirm(ActionEvent event) throws IOException, SQLException {
        connection = DBConnector.connect();
        query = "SELECT * FROM LOGED";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        resultSet.next();
        query = "UPDATE KLIENCI SET DO_USUNIĘCIA = 1 WHERE OSOBA_ID ="+"'"+resultSet.getString("OSOBA_ID")+"'";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        HelloApplication m = new HelloApplication();
        m.changeScene("Niezarejestrowany.fxml");
    }

}

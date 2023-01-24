package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuwanie {
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    @FXML
    void btnBack(ActionEvent event) throws IOException, SQLException {
        connection = DBConnector.connect();
        query = "SELECT * FROM LOGED";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
        {
            query = "SELECT * FROM PRACOWNICY WHERE OSOBA_ID ="+"'"+resultSet.getString("OSOBA_ID")+"'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                connection.close();
                HelloApplication m = new HelloApplication();
                m.changeScene("Sprzedawca.fxml");
            }
            else
            {
                connection.close();
                HelloApplication m = new HelloApplication();
                m.changeScene("Klient.fxml");
            }

        }
        else
        {
            connection.close();
            HelloApplication m = new HelloApplication();
            m.changeScene("Niezarejestrowany.fxml");
        }

    }

}

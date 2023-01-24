package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logowanie {


    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    String email;
    String haslo;
    String idOs;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfEmail;

    @FXML
    void btnLogin(ActionEvent event) throws IOException, SQLException {

        connection = DBConnector.connect();

        email = tfEmail.getText();


        if(email == null)
            email="blank";

        query = "SELECT * FROM DANE_OSOBOWE WHERE EMAIL ="+"'"+email+"'";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
        {
            //System.out.println("Dobry email");
            haslo = resultSet.getString("HASLO");
            idOs = resultSet.getString("OSOBA_ID");
        }
        else
        {
            //System.out.println("zly email");
            connection.close();
            HelloApplication m = new HelloApplication();
            m.changeScene("Niezarejestrowany.fxml");

            return;
        }


        query = "SELECT * FROM PRACOWNICY WHERE OSOBA_ID ="+"'"+idOs+"'";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();


        if(!resultSet.next() && haslo.equals(tfPassword.getText()))
        {
            query ="INSERT INTO LOGED(email, osoba_id) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, idOs);
            preparedStatement.execute();
            //System.out.println("dobre haslo klient");
            connection.close();
            HelloApplication m = new HelloApplication();
            m.changeScene("Klient.fxml");
        }
        else if(haslo.equals(tfPassword.getText()))
        {
            query ="INSERT INTO LOGED(email, osoba_id) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, idOs);
            preparedStatement.execute();
           // System.out.println("dobre haslo sprzedawca");
            connection.close();
            HelloApplication m = new HelloApplication();
            m.changeScene("Sprzedawca.fxml");
        }
        else
        {
            System.out.println(haslo);
            System.out.println(tfPassword.getText());
          //  System.out.println("zle haslo");
            connection.close();
            HelloApplication m = new HelloApplication();
            m.changeScene("Niezarejestrowany.fxml");
        }

    }

    @FXML
    void btnZmiana(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Niezarejestrowany.fxml");
    }

}

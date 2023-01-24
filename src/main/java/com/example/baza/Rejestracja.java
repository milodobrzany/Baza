package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Rejestracja {

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

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

    String imie;
    String nazwisko;
    String email;
    String haslo;
    String telefon;
    String kodP;
    String miasto;
    String ulica;
    String nrD;
    String nrM;
    String idA;
    String idOs;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Niezarejestrowany.fxml");
    }

    @FXML
    void btnRegister(ActionEvent event) throws IOException, SQLException {
        connection=DBConnector.connect();

        imie = tfFirstName.getText();
        nazwisko = tfName.getText();
        email= tfEmail.getText();
        haslo=tfPassword.getText();
        telefon=tfPhone.getText();
        kodP= tfPostalCode.getText();
        miasto=tfCity.getText();
        ulica= tfStreet.getText();
        nrD=tfHomeNumber.getText();
        nrM=tfFlatNumber.getText();

        query = "INSERT INTO ADRESY (adres_id, miasto, kod_pocztowy, ulica, numer_lokalu, numer_mieszkania) VALUES (1, ?, ?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, miasto);
        preparedStatement.setString(2, kodP);
        preparedStatement.setString(3, ulica);
        preparedStatement.setString(4, nrD);
        preparedStatement.setString(5, nrM);
        preparedStatement.execute();

        query = "SELECT ADRES_ID from ADRESY";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            idA =resultSet.getString("ADRES_ID");
        }

        query = "INSERT INTO DANE_OSOBOWE (OSOBA_ID, NAZWISKO, IMIE, EMAIL, NR_TELEFONU, HASLO, ADRES_ID) VALUES (1, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nazwisko);
        preparedStatement.setString(2, imie);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, telefon);
        preparedStatement.setString(5, haslo);
        preparedStatement.setString(6, idA);
        preparedStatement.execute();

        query = "SELECT OSOBA_ID from DANE_OSOBOWE";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            idOs =resultSet.getString("OSOBA_ID");
        }

        query = "INSERT INTO KLIENCI (KLIENT_ID, OSOBA_ID, DATA_REJESTRACJI) VALUES (1, ?, ?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, idOs);
        preparedStatement.setString(2, String.valueOf(LocalDate.now()));
        preparedStatement.execute();


        HelloApplication m = new HelloApplication();
        m.changeScene("Klient.fxml");
    }

}

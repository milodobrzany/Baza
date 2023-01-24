package com.example.baza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dodawanie {

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @FXML
    private TextField nazwaTex;
    @FXML
    private TextField cenaTX;
    @FXML
    private TextField iloscTex;
    @FXML
    private TextField obudowaTex;
    @FXML
    private TextField produkowanyTx;
    @FXML
    private TextField idProdTex;


    String nazwa;
    String ilosc;
    String cena;
    String obudowa;
    String produkwany;
    String idProducenta;

    @FXML
    void add(ActionEvent event) throws IOException, SQLException {
         connection=DBConnector.connect();
         nazwa = nazwaTex.getText();
         ilosc = iloscTex.getText();
         cena = cenaTX.getText();
         obudowa = obudowaTex.getText();
         produkwany = produkowanyTx.getText();
         idProducenta= idProdTex.getText();

        getQuery();
        insert();
        clean();
    }

    void getQuery() throws SQLException{
        query = "INSERT INTO UKLADY_SCALONE (PRODUKT_ID, NAZWA, ILOSC, CENA, OBUDOWA, CZY_PRODUKOWANY, PRODUCENT_ID) VALUES (1, ?, ?, ?, ?, ?, ?)";
    }

    void insert() throws SQLException {

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nazwa);
        preparedStatement.setString(2, ilosc);
        preparedStatement.setString(3, cena);
        preparedStatement.setString(4, obudowa);
        preparedStatement.setString(5, produkwany);
        preparedStatement.setString(6, idProducenta);
        preparedStatement.execute();
    }

    @FXML
    void clean()
    {
        nazwaTex.setText(null);
        iloscTex.setText(null);
        cenaTX.setText(null);
        obudowaTex.setText(null);
        produkowanyTx.setText(null);
        idProdTex.setText(null);
    }


    @FXML
    void btnBack(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Sprzedawca.fxml");
    }

}

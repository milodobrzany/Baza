package com.example.baza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Przegladanie {

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Układy układy = null;

    String query2 = null;
    PreparedStatement preparedStatement2 = null;
    ResultSet resultSet2 = null;

    ObservableList<Układy> UkladList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws SQLException {
        loadData();
    }
    @FXML
    private TableView<Układy> ukladyTabela;
    @FXML
    private TableColumn<Układy, String> nazwaCol;
    @FXML
    private TableColumn<Układy, String> producentCol;
    @FXML
    private TableColumn<Układy, String> obudowaCol;
    @FXML
    private TableColumn<Układy, String> produkowanyCol;
    @FXML
    private TableColumn<Układy, String> cenaCol;
    @FXML
    private TableColumn<Układy, String> sztCol;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Klient.fxml");
    }


    void refreshTable() throws SQLException {
        UkladList.clear();

        query = "SELECT UKLADY_SCALONE.PRODUKT_ID as \"PRODUKT_ID\", UKLADY_SCALONE.NAZWA AS \"NAZWA\", PRODUCENCI.NAZWA AS \"NAZWA_PRODUCENTA\", UKLADY_SCALONE.ILOSC AS \"ILOSC\", UKLADY_SCALONE.CENA AS \"CENA\", UKLADY_SCALONE.OBUDOWA AS \"OBUDOWA\", UKLADY_SCALONE.CZY_PRODUKOWANY AS \"CZY_PRODUKOWANY\", UKLADY_SCALONE.PRODUCENT_ID AS \"PRODUCENT_ID\" From UKLADY_SCALONE INNER JOIN PRODUCENCI ON UKLADY_SCALONE.PRODUCENT_ID=PRODUCENCI.PRODUCENT_ID";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while(resultSet.next())
        {
            UkladList.add(new Układy(
                    resultSet.getInt("PRODUKT_ID"),
                    resultSet.getString("NAZWA"),
                    resultSet.getInt("ILOSC"),
                    resultSet.getFloat("CENA"),
                    resultSet.getString("OBUDOWA"),
                    resultSet.getString("CZY_PRODUKOWANY"),
                    resultSet.getInt("PRODUCENT_ID"),
                    resultSet.getString("NAZWA_PRODUCENTA")
            ));


            ukladyTabela.setItems(UkladList);
        }
    }

    public void loadData() throws SQLException {
        connection = DBConnector.connect();

        refreshTable();

        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        producentCol.setCellValueFactory(new PropertyValueFactory<>("nazwaProducenta"));
        obudowaCol.setCellValueFactory(new PropertyValueFactory<>("obudowa"));
        produkowanyCol.setCellValueFactory(new PropertyValueFactory<>("produkwany"));
        cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        sztCol.setCellValueFactory(new PropertyValueFactory<>("ilosc"));

        connection.close();
    }

}

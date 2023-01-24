package com.example.baza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloApplication extends Application {

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Niezarejestrowany.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Baza!");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() throws SQLException {
        connection = DBConnector.connect();
        query = "TRUNCATE TABLE LOGED";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeQuery();
        connection.close();
    }
    public void changeScene(String fxml) throws IOException{

        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);

    }

    public static void main(String[] args) {

        launch();
    }
}
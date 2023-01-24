package com.example.baza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {

    public ResultSet executeSelect(String selectQuery) throws SQLException {
        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        return statement.executeQuery((selectQuery));
    }

    public void executeQuery(String query) throws SQLException {
        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        statement.execute(query);
    }
}

package com.example.baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String URL="jdbc:oracle:thin:@localhost:1521:XE";

    private static String USER="BazaProjekt";

    private static String PASSWORD="hasło";

    public static Connection connect(){
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("YEA");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }
}

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL {
    private static Connection connection;

    private static Statement createConnection() throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/viva", "root", "Watchdogs09");
        }
        return connection.createStatement();
    }

    public static void iud(String query) {
        try {
            createConnection().executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ResultSet search(String query) throws Exception {

        return createConnection().executeQuery(query);
    }

}

package soapapi;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";
    private static final String USER = "dan";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

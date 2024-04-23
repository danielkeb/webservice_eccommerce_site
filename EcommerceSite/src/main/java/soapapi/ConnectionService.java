package soapapi;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebService(serviceName="ConnectionService")
public class ConnectionService {

    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "dan";
    private static final String PASSWORD = "1234";

    /** This is a sample web service operation */
    @WebMethod(operationName="hello")
    public String hello(@WebParam(name="name") String txt) {
        return "Hello "+txt+" !";
    }

    /** This method returns a database connection */
//    @WebMethod(operationName="getConnection")
//    public Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
}

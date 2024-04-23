package soapapi;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@WebService(serviceName="OrderService")
public class OrderService {

    // Add your database table name here
    private static final String TABLE_NAME = "orders";

    // Method to create a new order
    @WebMethod(operationName="createOrder")
    public String createOrder(@WebParam(name="orderId") String orderId,
                              @WebParam(name="orderDetails") String orderDetails) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO " + TABLE_NAME + " (order_id, order_details) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, orderId);
                    statement.setString(2, orderDetails);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        return "Order created successfully!";
                    } else {
                        return "Failed to create order.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to update order status
    @WebMethod(operationName="updateOrderStatus")
    public String updateOrderStatus(@WebParam(name="orderId") String orderId,
                                    @WebParam(name="newStatus") String newStatus) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "UPDATE " + TABLE_NAME + " SET order_details = ? WHERE order_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, newStatus);
                    statement.setString(2, orderId);
                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        return "Order details updated successfully!";
                    } else {
                        return "Failed to update order status.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to cancel an order
    @WebMethod(operationName="cancelOrder")
    public String cancelOrder(@WebParam(name="orderId") String orderId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM " + TABLE_NAME + " WHERE order_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, orderId);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        return "Order cancelled successfully!";
                    } else {
                        return "Failed to cancel order.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to retrieve order details
    @WebMethod(operationName="getOrderDetails")
    public String getOrderDetails(@WebParam(name="orderId") String orderId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT order_details FROM " + TABLE_NAME + " WHERE order_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, orderId);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        return resultSet.getString("order_details");
                    } else {
                        return "Order ID not found!";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}

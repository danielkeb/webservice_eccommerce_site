package soapapi;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebService(serviceName="PaymentService")
public class PaymentService {

    // Method for creating a payment
    @WebMethod(operationName="createPayment")
    public String createPayment(@WebParam(name="amount") double amount,
                                @WebParam(name="customerId") String customerId,
                                @WebParam(name="paymentMethod") String paymentMethod) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO payments (amount, customer_id, payment_method) VALUES (?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setDouble(1, amount);
                    statement.setString(2, customerId);
                    statement.setString(3, paymentMethod);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        return "Payment created successfully. Amount: " + amount + ", Customer ID: " + customerId + ", Payment Method: " + paymentMethod;
                    } else {
                        return "Failed to create payment.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method for retrieving payment details
    @WebMethod(operationName="getPaymentDetails")
    public String getPaymentDetails(@WebParam(name="paymentId") String paymentId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT * FROM payments WHERE customer_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, paymentId);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        double amount = resultSet.getDouble("amount");
                        String customerId = resultSet.getString("customer_id");
                        String paymentMethod = resultSet.getString("payment_method");
                        return "Payment details for payment ID: " + paymentId + ", Amount: " + amount + ", Customer ID: " + customerId + ", Payment Method: " + paymentMethod;
                    } else {
                        return "Payment with ID " + paymentId + " not found.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method for updating a payment
    @WebMethod(operationName="updatePayment")
    public String updatePayment(@WebParam(name="paymentId") String paymentId,
                                @WebParam(name="newAmount") double newAmount) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "UPDATE payments SET amount = ? WHERE customer_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setDouble(1, newAmount);
                    statement.setString(2, paymentId);
                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        return "Payment with ID " + paymentId + " updated successfully. New amount: " + newAmount;
                    } else {
                        return "Failed to update payment.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method for deleting a payment
    @WebMethod(operationName="deletePayment")
    public String deletePayment(@WebParam(name="paymentId") String paymentId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM payments WHERE customer_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, paymentId);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        return "Payment with ID " + paymentId + " deleted successfully.";
                    } else {
                        return "Failed to delete payment.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

//@WebMethod(operationName="processPayment")
//public String processPayment(@WebParam(name="paymentDetails") String paymentDetails) {
//    try {
//        // Implement logic to process the payment in the database
//        // For example, you might update the payment status in the database
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            String sql = "UPDATE payments SET status = 'Processed' WHERE payment_method = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, paymentDetails);
//                int rowsUpdated = statement.executeUpdate();
//                if (rowsUpdated > 0) {
//                    return "Payment processed successfully!";
//                } else {
//                    return "Failed to process payment.";
//                }
//            }
//        }
//    } catch (ClassNotFoundException | SQLException e) {
//        e.printStackTrace();
//        return "Error: " + e.getMessage();
//    }
//}

// Method for refunding a payment
//@WebMethod(operationName="refundPayment")
//public String refundPayment(@WebParam(name="paymentId") String paymentId,
//                            @WebParam(name="refundAmount") double refundAmount) {
//    try {
//        // Implement logic to refund the payment in the database
//        // For example, you might update the payment status and refund amount in the database
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            String sql = "UPDATE payments SET status = 'Refunded', refund_amount = ? WHERE payment_id = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setDouble(1, refundAmount);
//                statement.setString(2, paymentId);
//                int rowsUpdated = statement.executeUpdate();
//                if (rowsUpdated > 0) {
//                    return "Payment with ID " + paymentId + " refunded successfully. Refund amount: " + refundAmount;
//                } else {
//                    return "Failed to refund payment.";
//                }
//            }
//        }
//    } catch (ClassNotFoundException | SQLException e) {
//        e.printStackTrace();
//        return "Error: " + e.getMessage();
//    }
//}
}

package soapapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CartService")
public class CartService {

@WebMethod(operationName = "addItemToCart")
public String addItemToCart(@WebParam(name = "productId") String productId,
                            @WebParam(name = "quantity") int quantity,
                            @WebParam(name = "productName") String productName) {
    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the database connection
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO cart (productId, quantity, product_name) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, productId);
                statement.setInt(2, quantity);
                statement.setString(3, productName);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return "Item added to cart successfully!";
                } else {
                    return "Failed to add item to cart.";
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}

@WebMethod(operationName = "updateCartItemQuantity")
public String updateCartItemQuantity(@WebParam(name = "productId") String productId,
                                      @WebParam(name = "newQuantity") int newQuantity) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE cart SET quantity = ? WHERE productId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, newQuantity);
                statement.setString(2, productId);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    return "Cart item quantity updated successfully!";
                } else {
                    return "Failed to update cart item quantity: Product ID not found or no rows updated.";
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}


   @WebMethod(operationName = "removeItemFromCart")
public String removeItemFromCart(@WebParam(name = "productId") String productId) {
    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish the database connection
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM cart WHERE productId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, productId);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    return "Item removed from cart successfully!";
                } else {
                    return "Failed to remove item from cart.";
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}
@WebMethod(operationName = "getCartDetails")
public List<String> getCartDetails() {
    List<String> cartDetails = new ArrayList<>();
    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the database connection
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT productId, quantity, product_name FROM cart";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String productId = resultSet.getString("productId");
                    int quantity = resultSet.getInt("quantity");
                    String product_name=resultSet.getString("product_name");
                    String cartItem = "Product ID: " + productId + ", Quantity: " + quantity + ", product name: " + product_name;
                    cartDetails.add(cartItem);
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        cartDetails.add("Error: " + e.getMessage());
    }
    return cartDetails;
}

//    @WebMethod(operationName = "clearCart")
//public String clearCart() {
//    try {
//        // Load the MySQL JDBC driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        // Establish the database connection
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            String sql = "DELETE FROM cart";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                int rowsDeleted = statement.executeUpdate();
//                if (rowsDeleted > 0) {
//                    return "Cart cleared successfully!";
//                } else {
//                    return "Failed to clear the cart.";
//                }
//            }
//        }
//    } catch (ClassNotFoundException | SQLException e) {
//        e.printStackTrace();
//        return "Error: " + e.getMessage();
//    }
//}

}

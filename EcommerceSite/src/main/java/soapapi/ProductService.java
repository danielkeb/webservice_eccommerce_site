package soapapi;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ProductService")
public class ProductService {
    
    // Add your database table name here
    private static final String TABLE_NAME = "product";

    // Method to add a new product to the database
    @WebMethod(operationName = "addProduct")
    public String addProduct(@WebParam(name = "productName") String productName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO " + TABLE_NAME + " (name) VALUES (?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, productName);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        return "Product added successfully!";
                    } else {
                        return "Failed to add product.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to update an existing product in the database
    @WebMethod(operationName = "updateProduct")
    public String updateProduct(@WebParam(name = "oldProductName") String oldProductName,
                                @WebParam(name = "newProductName") String newProductName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "UPDATE " + TABLE_NAME + " SET name = ? WHERE name = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, newProductName);
                    statement.setString(2, oldProductName);
                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        return "Product updated successfully!";
                    } else {
                        return "Failed to update product.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to delete a product from the database
    @WebMethod(operationName = "deleteProduct")
    public String deleteProduct(@WebParam(name = "productName") String productName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM " + TABLE_NAME + " WHERE name = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, productName);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        return "Product deleted successfully!";
                    } else {
                        return "Failed to delete product.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to search for a product in the database
    @WebMethod(operationName = "searchProduct")
    public String searchProduct(@WebParam(name = "productName") String productName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, productName);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        return "Product found!";
                    } else {
                        return "Product not found!";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to get all products from the database
    @WebMethod(operationName = "getAllProducts")
    public ArrayList<String> getAllProducts() {
        ArrayList<String> products = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT * FROM " + TABLE_NAME;
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        String productName = resultSet.getString("name");
                        products.add(productName);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

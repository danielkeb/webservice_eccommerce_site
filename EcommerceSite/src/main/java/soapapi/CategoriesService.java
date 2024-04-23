package soapapi;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebService(serviceName="CategoriesService")
public class CategoriesService {

    // Add your database table name here
    private static final String TABLE_NAME = "categories";

    private ArrayList<String> categories;

    public CategoriesService() {
        categories = new ArrayList<>();
        // You can remove the initial categories here as they will be fetched from the database
        // Adding initial categories
        // categories.add("Electronics");
        // categories.add("Bags, Shoes & Accessories");
        // categories.add("Apparel, Textiles & Accessories");
        // categories.add("Agriculture & Food");
        // categories.add("Home and Furniture");
        // categories.add("Health & Beauty");
        // ...
        // You can remove or keep these based on your preference
        // The actual categories will be fetched from the database
    }

    // Method to add a new category to the database
    @WebMethod(operationName="addCategory")
    public String addCategory(@WebParam(name="categoryName") String categoryName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO " + TABLE_NAME + " (category_name) VALUES (?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, categoryName);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        return "Category added successfully!";
                    } else {
                        return "Failed to add category.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to update an existing category in the database
    @WebMethod(operationName="updateCategory")
    public String updateCategory(@WebParam(name="oldCategoryName") String oldCategoryName,
                                 @WebParam(name="newCategoryName") String newCategoryName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "UPDATE " + TABLE_NAME + " SET category_name = ? WHERE category_name = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, newCategoryName);
                    statement.setString(2, oldCategoryName);
                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        return "Category updated successfully!";
                    } else {
                        return "Failed to update category.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to delete a category from the database
    @WebMethod(operationName="deleteCategory")
    public String deleteCategory(@WebParam(name="categoryName") String categoryName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM " + TABLE_NAME + " WHERE category_name = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, categoryName);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        return "Category deleted successfully!";
                    } else {
                        return "Failed to delete category.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to search for a category in the database
    @WebMethod(operationName="searchCategory")
    public String searchCategory(@WebParam(name="categoryName") String categoryName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT * FROM " + TABLE_NAME + " WHERE category_name = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, categoryName);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        return "Category found!";
                    } else {
                        return "Category not found!";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Method to get all categories from the database
    @WebMethod(operationName="getAllCategories")
    public ArrayList<String> getAllCategories() {
        ArrayList<String> categories = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT category_name FROM " + TABLE_NAME;
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        String categoryName = resultSet.getString("category_name");
                        categories.add(categoryName);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}

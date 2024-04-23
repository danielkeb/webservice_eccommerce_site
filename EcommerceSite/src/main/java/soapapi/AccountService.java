package soapapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID; // Add import statement for UUID
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "AccountService")
public class AccountService {

    @WebMethod(operationName = "registerUser")
    public String registerUser(@WebParam(name = "username") String username,
                               @WebParam(name = "password") String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO accounts (username, password) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, username);
                    statement.setString(2, password);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        return "User registered successfully!";
                    } else {
                        return "Failed to register user.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "login")
public String login(@WebParam(name = "username") String username,
                    @WebParam(name = "password") String password) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT password FROM accounts WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    if (storedPassword.equals(password)) {
                        // Generate session token
                        String sessionToken = generateSessionToken();
                        // Store session token in sessions table
                        storeSession(username, sessionToken);
                        return "Login successful!";
                    } else {
                        return "Incorrect password!";
                    }
                } else {
                    return "Username not found!";
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}


    @WebMethod(operationName = "logout")
    public String logout(@WebParam(name = "username") String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM sessions WHERE username = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, username);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        return "Logout successful!";
                    } else {
                        return "Failed to logout.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Logout failed.";
        }
    }
    
    // Helper method to generate a session token
    private String generateSessionToken() {
        // Implement your session token generation logic here
        // For example, you can use UUID.randomUUID() to generate a random token
        return UUID.randomUUID().toString();
    }
    
    // Helper method to store session in the database
    private void storeSession(String username, String sessionToken) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO sessions (username, session_token) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, sessionToken);
                statement.executeUpdate();
            }
        }
    }

    @WebMethod(operationName = "updateProfile")
    public String updateProfile(@WebParam(name = "username") String username,
                                @WebParam(name = "newPassword") String newPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "UPDATE accounts SET password = ? WHERE username = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, newPassword);
                    statement.setString(2, username);
                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        return "Profile updated successfully!";
                    } else {
                        return "Failed to update profile.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @WebMethod(operationName = "deleteAccount")
    public String deleteAccount(@WebParam(name = "username") String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM accounts WHERE username = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, username);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        return "Account deleted successfully!";
                    } else {
                        return "Failed to delete account.";
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}


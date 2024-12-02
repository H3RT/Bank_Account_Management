package org.example;

import java.sql.*;

public class UserAuth {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/users"; // Update this with your DB details
    private static final String DB_USERNAME = "root"; // Your DB username
    private static final String DB_PASSWORD = "password"; // Your DB password

    // Establish a database connection
    private static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    // Method to handle user signup
    public static boolean signup(String username, String password, String accountType) {
        Connection conn = connect();
        if (conn == null) {
            return false;
        }

        try {
            // Check if the username already exists
            String checkUserQuery = "SELECT COUNT(*) FROM user WHERE username = ?";
            try (PreparedStatement ps = conn.prepareStatement(checkUserQuery)) {
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    System.out.println("Username already taken. Please try another one.");
                    return false; // Username already exists
                }
            }

            // Insert new user into the user table
            String insertUserQuery = "INSERT INTO user (username, password, account_type) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertUserQuery)) {
                ps.setString(1, username);
                ps.setString(2, password); // Ideally, hash the password before saving
                ps.setString(3, accountType);
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0; // Return true if the insert was successful
            }
        } catch (SQLException e) {
            System.out.println("Signup failed: " + e.getMessage());
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // Method to handle user login
    public static Account login(String username, String password) {
        Connection conn = connect();
        if (conn == null) {
            return null;
        }

        try {
            // Check if the username and password match
            String loginQuery = "SELECT account_type FROM user WHERE username = ? AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(loginQuery)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String accountType = rs.getString("account_type");
                    if (accountType.equalsIgnoreCase("Savings")) {
                        return new Savings(0); // Create and return a new Savings account
                    } else if (accountType.equalsIgnoreCase("Cheque")) {
                        return new ChequeAccount(0); // Create and return a new Cheque account
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return null; // Return null if login fails
    }
}

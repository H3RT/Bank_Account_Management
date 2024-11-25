import java.sql.*;
import java.util.Scanner;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
            // Connect to SQLite database
            connection = DriverManager.getConnection("jdbc:sqlite:bank.db");
            System.out.println("Database successfuly connected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Register a new user
    public boolean registerUser(String username, String password) {
        try {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); 
            stmt.executeUpdate();
            System.out.println("User registered successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error: Username already exists.");
            return false;
        }
    }

    // Login user
    public boolean loginUser(String username, String password) {
        try {
            String sql = "SELECT user_id FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful. Welcome :), " + username + "!");
                return true;
            } else {
                System.out.println("Invalid username or password :(");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection successfuly closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BankDatabaseManager dbManager = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (option == 1) {
            // Register a new user
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            dbManager.registerUser(username, password);
        } else if (option == 2) {
            // Login an existing user
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            dbManager.loginUser(username, password);
        } else {
            System.out.println("Invalid option.");
        }

        dbManager.closeConnection();
        scanner.close();
    }
}

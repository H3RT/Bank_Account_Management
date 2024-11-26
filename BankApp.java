import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApp extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    public BankApp() {
        setTitle("Bank System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Add pages to the card layout
        mainPanel.add(createLoginPage(), "Login");
        mainPanel.add(createWelcomePage(), "Welcome");
        mainPanel.add(createDepositPage(), "Deposit");
        mainPanel.add(createWithdrawPage(), "Withdraw");
        mainPanel.add(createTransferPage(), "Transfer");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login"); // Start with the login page
    }

    // Login Page
    private JPanel createLoginPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Login", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel()); // Spacer
        formPanel.add(loginButton);

        panel.add(label, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Dummy login check for now
            if (username.equals("user") && password.equals("pass")) {
                cardLayout.show(mainPanel, "Welcome");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    // Welcome Page
    private JPanel createWelcomePage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Welcome to the Bank!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Transfer");

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(transferButton);

        panel.add(label, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Navigation buttons
        depositButton.addActionListener(e -> cardLayout.show(mainPanel, "Deposit"));
        withdrawButton.addActionListener(e -> cardLayout.show(mainPanel, "Withdraw"));
        transferButton.addActionListener(e -> cardLayout.show(mainPanel, "Transfer"));

        return panel;
    }

    // Deposit Page
    private JPanel createDepositPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Deposit Money", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField amountField = new JTextField();
        JButton depositButton = new JButton("Deposit");

        formPanel.add(new JLabel("Amount:"));
        formPanel.add(amountField);
        formPanel.add(new JLabel()); // Spacer
        formPanel.add(depositButton);

        panel.add(label, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);

        depositButton.addActionListener(e -> {
            String amountText = amountField.getText();
            // Dummy deposit action
            JOptionPane.showMessageDialog(this, "You deposited: " + amountText, "Success", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(mainPanel, "Welcome");
        });

        return panel;
    }

    // Withdraw Page
    private JPanel createWithdrawPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Withdraw Money", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField amountField = new JTextField();
        JButton withdrawButton = new JButton("Withdraw");

        formPanel.add(new JLabel("Amount:"));
        formPanel.add(amountField);
        formPanel.add(new JLabel()); // Spacer
        formPanel.add(withdrawButton);

        panel.add(label, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);

        withdrawButton.addActionListener(e -> {
            String amountText = amountField.getText();
            // Dummy withdraw action
            JOptionPane.showMessageDialog(this, "You withdrew: " + amountText, "Success", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(mainPanel, "Welcome");
        });

        return panel;
    }

    // Transfer Page
    private JPanel createTransferPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Transfer Money", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField toUserField = new JTextField();
        JTextField amountField = new JTextField();
        JButton transferButton = new JButton("Transfer");

        formPanel.add(new JLabel("To User:"));
        formPanel.add(toUserField);
        formPanel.add(new JLabel("Amount:"));
        formPanel.add(amountField);
        formPanel.add(new JLabel()); // Spacer
        formPanel.add(transferButton);

        panel.add(label, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);

        transferButton.addActionListener(e -> {
            String toUser = toUserField.getText();
            String amountText = amountField.getText();
            // Dummy transfer action
            JOptionPane.showMessageDialog(this, "You transferred: " + amountText + " to " + toUser, "Success", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(mainPanel, "Welcome");
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankApp app = new BankApp();
            app.setVisible(true);
        });
    }
}

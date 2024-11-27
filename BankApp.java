import java.awt.*;
import javax.swing.*;

public class BankApp extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);

    public BankApp() {
        setTitle("Banking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Adding pages to the card layout
        mainPanel.add(createLoginPage(), "Login");
        mainPanel.add(createWelcomePage(), "Welcome");
        mainPanel.add(createDepositPage(), "Deposit");
        mainPanel.add(createWithdrawPage(), "Withdraw");
        mainPanel.add(createTransferPage(), "Transfer");
        mainPanel.add(createBalancePage(), "CheckBalance");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login"); 
    }

    // Login Page
    private JPanel createLoginPage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(200, 230, 250));

        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(50, 70, 120));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.setOpaque(false);

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(50, 150, 90));
        loginButton.setForeground(Color.WHITE);

        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel()); 
        formPanel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());


            //dummy log in. Username: user and Password: pass
            if (username.equals("user") && password.equals("pass")) { 
                //to take user to the welcome page after loggin in
                cardLayout.show(mainPanel, "Welcome");
            } else {

                //if log in credentials are wrong it should handle this error
                JOptionPane.showMessageDialog(this, "Invalid login credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(title, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);
        return panel;
    }

    // Welcome Page
    private JPanel createWelcomePage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 250, 255));

        JLabel title = new JLabel("Welcome to the Bank System!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(40, 80, 130));

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        buttonPanel.setOpaque(false);

        //buttons
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Transfer");
        JButton balanceButton = new JButton("Check Balance");
        JButton logoutButton = new JButton("Logout");

        for (JButton button : new JButton[]{depositButton, withdrawButton, transferButton, balanceButton, logoutButton}) {
            button.setBackground(new Color(60, 140, 200));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
        }

        depositButton.addActionListener(e -> cardLayout.show(mainPanel, "Deposit"));
        withdrawButton.addActionListener(e -> cardLayout.show(mainPanel, "Withdraw"));
        transferButton.addActionListener(e -> cardLayout.show(mainPanel, "Transfer"));
        balanceButton.addActionListener(e -> cardLayout.show(mainPanel, "CheckBalance"));
        logoutButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(transferButton);
        buttonPanel.add(balanceButton);
        buttonPanel.add(logoutButton);

        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        return panel;
    }

    // Deposit Page
    private JPanel createDepositPage() {
        return createTransactionPage("Deposit Money", "Deposit", "Welcome");
    }

    // Withdraw Page
    private JPanel createWithdrawPage() {
        return createTransactionPage("Withdraw Money", "Withdraw", "Welcome");
    }

    // Transfer Page
    private JPanel createTransferPage() {
        JPanel panel = createTransactionPage("Transfer Money", "Transfer", "Welcome");
        JLabel toLabel = new JLabel("Recipient Username:");
        JTextField toField = new JTextField();
        ((JPanel) panel.getComponent(1)).add(toLabel, 0);
        ((JPanel) panel.getComponent(1)).add(toField, 1);
        return panel;
    }

    // Check Balance Page
    private JPanel createBalancePage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(230, 240, 255));

        //a dummy balance of R500 displayed
        JLabel label = new JLabel("Your Balance: R500.0", SwingConstants.CENTER); 
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(50, 100, 150));

        //for going back
        JButton backButton = new JButton("Back to Menu");
        backButton.setBackground(new Color(60, 140, 200));
        backButton.setForeground(Color.WHITE);

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        panel.add(label, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);
        return panel;
    }

    // Helper Method for Transaction Pages
    private JPanel createTransactionPage(String titleText, String buttonText, String backPage) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(230, 240, 255));

        JLabel label = new JLabel(titleText, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(50, 100, 150));

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.setOpaque(false);

        JTextField amountField = new JTextField();
        JButton actionButton = new JButton(buttonText);
        actionButton.setBackground(new Color(50, 150, 90));
        actionButton.setForeground(Color.WHITE);

        formPanel.add(new JLabel("Amount:"));
        formPanel.add(amountField);
        formPanel.add(new JLabel()); 
        formPanel.add(actionButton);

        actionButton.addActionListener(e -> {
            String amountText = amountField.getText();
            JOptionPane.showMessageDialog(this, buttonText + " Successful: R" + amountText, "Success", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(mainPanel, backPage);
        });

        panel.add(label, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankApp app = new BankApp();
            app.setVisible(true);
        });
    }
}

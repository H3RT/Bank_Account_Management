package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        Account currentAccount = null;

        System.out.println("Welcome to the Banking System!");
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.println("3. Exit");
        int actionChoice = scan.nextInt();
        scan.nextLine();  // Consume the newline

        if (actionChoice == 1) {
            // Login
            System.out.print("Enter Username: ");
            String username = scan.nextLine();
            System.out.print("Enter Password: ");
            String password = scan.nextLine();
            currentAccount = UserAuth.login(username, password);

            if (currentAccount == null) {
                System.out.println("Login failed. Exiting...");
                return;  // Exit if login failed
            }
        } else if (actionChoice == 2) {
            // Signup
            System.out.print("Enter Username: ");
            String username = scan.nextLine();
            System.out.print("Enter Password: ");
            String password = scan.nextLine();
            System.out.print("Enter Account Type (Savings or Cheque): ");
            String accountType = scan.nextLine();
            boolean signupSuccess = UserAuth.signup(username, password, accountType);

            if (signupSuccess) {
                currentAccount = accountType.equalsIgnoreCase("Savings") ? new Savings(0) : new ChequeAccount(0);
                System.out.println("Signup successful! Please log in.");
            } else {
                System.out.println("Signup failed. Please try again.");
                return;  // Exit if signup fails
            }
        } else {
            System.out.println("Invalid option. Exiting...");
            return;  // Exit if invalid option
        }

        // Once logged in, show the transaction options
        if (currentAccount == null) {
            System.out.println("No account found. Exiting...");
            return;  // Exit if no account was created or login failed
        }

        while (true) {
            System.out.println("Which transaction do you want to do?");
            System.out.println("=================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. View Balance");
            System.out.println("5. Logout");
            System.out.println("================");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    currentAccount.deposit(scan);
                    break;
                case 2:
                    currentAccount.withdraw(scan);
                    break;
                case 3:
                    currentAccount.transfer(scan);
                    break;
                case 4:
                    currentAccount.viewBalance();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;  // Exit and log out the user
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

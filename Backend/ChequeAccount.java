package org.example;

import java.util.Scanner;

public class ChequeAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 1000.00; // Allow overdraft up to R1000

    public ChequeAccount(double balance) {
        super(balance);
    }


    @Override
    public double withdraw(Scanner inp) {
        double withd;
        System.out.println("Enter the amount you want to withdraw from Cheque Account: R");
        withd = inp.nextDouble();

        // Allow withdrawal even if the balance goes below zero, as long as it doesn't exceed the overdraft limit
        while (withd > (mainBalance + OVERDRAFT_LIMIT)) {
            System.out.println("You cannot withdraw more than your balance + overdraft limit.");
            System.out.println("Enter the amount you want to withdraw: R");
            withd = inp.nextDouble();
        }
        mainBalance -= withd;
        System.out.println("Withdrawal successful! Your new balance is: R" + String.format("%.2f", mainBalance));
        return mainBalance;
    }

    
    @Override
    public double deposit(Scanner inp) {
        System.out.println("Depositing into Cheque Account...");
        return super.deposit(inp);
    }

 
    @Override
    public void viewBalance() {
        System.out.println("Your Cheque Account balance is: R" + String.format("%.2f", mainBalance));
    }
}

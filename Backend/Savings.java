package org.example;

import java.util.*;
public class Savings extends Account {
    private static final double INTEREST_RATE = 0.03; 

    public Savings(double balance) {
        super(balance);
    }

    
    public void addInterest() {
        double interest = mainBalance * INTEREST_RATE;
        mainBalance += interest;
        System.out.println("Interest of R" + String.format("%.2f", interest) + " has been added to your savings account.");
    }

    
    @Override
    public double deposit(Scanner inp) {
        System.out.println("Depositing into Savings Account...");
        return super.deposit(inp);
    }

    
    @Override
    public double withdraw(Scanner inp) {
        System.out.println("Withdrawing from Savings Account...");
        return super.withdraw(inp);
    }

    
    @Override
    public void viewBalance() {
        System.out.println("Your Savings Account balance is: R" + String.format("%.2f", mainBalance));
    }
}

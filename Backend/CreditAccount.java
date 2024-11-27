public class CreditAccount extends Account {
    private final double creditLimit;
    private final double interestRate;

    // Constructor
    public CreditAccount(String accountHolderName, String accountNumber, double creditLimit, double interestRate) {
        super(accountHolderName, accountNumber);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    // Withdraw money from the account
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return false;
        }
        if (balance - amount < -creditLimit) {
            System.out.println("Transaction declined! Exceeds credit limit.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew (in Rands): " + amount + ". Current balance (in Rands): " + balance);
        return true;
    }

    // Apply interest to the account
    public void applyInterest() {
        if (balance < 0) {
            double interest = (-balance) * (interestRate / 100);
            balance -= interest;
            System.out.println("Interest of (in Rands) " + interest + " applied. Current balance (in Rands): " + balance);
        } else {
            System.out.println("No interest applied as the account balance is positive.");
        }
    }

    // Display account details
    @Override
    public void accountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance (in Rands): " + balance);
        System.out.println("Credit Limit (in Rands): " + creditLimit);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

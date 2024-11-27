public abstract class Account {
    protected String accountHolderName;
    protected String accountNumber;
    protected double balance;

    // Constructor
    public Account(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Default balance is 0
    }

    // Common methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " successfully.");
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }

      // method to send money to another account 
      public boolean sendMoney(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            recipient.balance += amount;
            System.out.println("Successfully sent " + amount + " to " + recipient.getAccountHolderName());
            return true;
        } else {
            System.out.println("Failed to send money. Insufficient balance or invalid amount.");
            return false;
        }
    }



    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public abstract void accountDetails(); 
}
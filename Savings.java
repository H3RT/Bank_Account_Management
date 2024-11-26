public class Savings extends Account {
    public Savings(String accountHolderName, String accountNumber) {
        super(accountHolderName,accountNumber);
    }
    // Common methods
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " successfully.");
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }
    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void accountDetails(){
    System.out.println(accountHolderName);
    System.out.println(accountNumber);
    System.out.println(balance);
    }
}


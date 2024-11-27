import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        Savings with = new Savings(2000);
        //int total = with.balance;
        double defAmnt;
        System.out.println("Give the account a default balance.");
        System.out.println("Enter the account default amount: R");
        defAmnt = scan.nextDouble();
        Account acc = new Account(defAmnt);
        while(true) {
            System.out.println("Which transaction do you want to do? press 1,2,3,4 or 5");
            System.out.println("=================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.println("================");
            choice = scan.nextInt();


            switch (choice) {
                case 1:
                    System.out.println(acc.deposit(scan));
                    break;
                case 2:
                    System.out.println(acc.withdraw(scan));
                    break;
                case 3:
                    System.out.println(acc.transfer(scan));
                    break;
                case 4:
                    acc.viewBalance();
                    break;
                case 5:
                    System.out.println("Terminating program");
                    scan.close();
                    return;
                default:
                    System.out.println("invalid choice");
                    break;
            }

        }


    }
}
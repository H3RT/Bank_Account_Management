package Backend;

import java.util.Scanner;

public class Account {
    public double mainBalance;


    public Account (double balance){
        this.mainBalance = balance;
    }

    public double deposit(Scanner inp){
        double amnt;
        System.out.println("Enter the amount you want deposit: R");
        amnt = inp.nextDouble();
        while (amnt <= 0){
            System.out.println("You cannot deposit an amount of 0 or below");
            System.out.println("Enter the amount you want deposit: R");
            amnt = inp.nextDouble();
            return mainBalance += amnt;
            //return  mainBalance;
        }


        return mainBalance += amnt;
    }

    public double withdraw(Scanner inp){
        double withd;
        System.out.println("Enter the amount you want to withdraw: R");
        withd = inp.nextDouble();
        while(withd > mainBalance){
            System.out.println("You cannot withdraw an amount that is greater than your balance.");
            System.out.println("Enter the amount you want to withdraw: R");
            withd = inp.nextDouble();
            return mainBalance-=withd;
        }
        return mainBalance-=withd;
    }

    public double transfer(Scanner inp){
        double transf;
        int opt;
        System.out.println("To which account do you want to transfer the money to?");
        System.out.println("===================");
        System.out.println("1. Savings");
        System.out.println("2. Cheque");
        System.out.println("====================");
        opt = inp.nextInt();
        while(opt < 1 || opt > 2){
            System.out.println("Invalid option...try again");
            System.out.println("To which account do you want to transfer the money to?");
            System.out.println("===================");
            System.out.println("1. Savings");
            System.out.println("2. Cheque");
            System.out.println("====================");
            opt = inp.nextInt();
        }

        if(opt == 1){
            //Operations for savings account


        } else if (opt == 2) {
            //Operations for cheque account


        }else {
            System.out.println("Invalid choice");
        }
        System.out.println("Enter the amount you want to transfer: R");
        transf = inp.nextDouble();
        while(transf > mainBalance){
            System.out.println("You cannot transfer an amount that is greater than your balance.");
            System.out.println("Enter the amount you want to withdraw: R");
            transf = inp.nextDouble();
            return mainBalance-=transf;
        }

        return mainBalance-=transf;
    }

    public void viewBalance(){
        System.out.println("Your current balance is: R"+String.format("%.2f",mainBalance));
    }

}

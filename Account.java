import java.util.*;


public class Account {
    private double mainBalance;


    public Account (double balance){
        this.mainBalance = balance;
    }

    public double deposit(Scanner inp){
        double amnt = 0;
        boolean validInput = false;


        while (!validInput) {
            try {
                System.out.println("Enter the amount you want to deposit: R");
                amnt = inp.nextDouble();

                while(amnt < 1){
                    System.out.println("Amount has to be greater than 0");
                    System.out.println("Enter the amount you want to deposit: R");
                    amnt = inp.nextDouble();
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input... Enter a valid number.");
                inp.nextLine();
            }
        }

        mainBalance += amnt;
        return mainBalance;
    }



    public double withdraw(Scanner inp){
        double withd = 0;
        boolean validInput = false;

        while(!validInput){
            try{
                System.out.println("Enter the amount you want to withdraw: R");
                withd = inp.nextDouble();

                while(withd > mainBalance){
                    System.out.println("You cannot withdraw an amount that is greater than your balance.");
                    System.out.println("Enter the amount you want to withdraw: R");
                    withd = inp.nextDouble();
                }
                validInput = true;
            } catch(InputMismatchException e){
                System.out.println("Invalid input...Enter a digit");
                System.out.println("Enter the amount you want to deposit: R");
                inp.nextLine();
            }
        }

        return mainBalance-=withd;
    }

    public double transfer(Scanner inp){
        double transf = 0;
        boolean validInput = false;
        int opt;

        while(!validInput) {
            try {
                System.out.println("To which account do you want to transfer the money to?");
                System.out.println("===================");
                System.out.println("1. Savings");
                System.out.println("2. Cheque");
                System.out.println("3. Credit");
                System.out.println("====================");
                opt = inp.nextInt();

                switch (opt){
                    case 1:
                    case 2:
                    case 3:
                    default:
                }
                validInput = true;
            }catch (InputMismatchException e){
                System.out.println("Invalid selection...Choose the correct option(1 or 2): ");
                inp.nextLine();
            }
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

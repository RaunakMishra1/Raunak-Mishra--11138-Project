import java.util.Scanner;


class Account {

    // private variable for encapsulation
    private double balance = 2000;

    // method to withdraw money
    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount");
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance");
        }
        else {
            balance = balance - amount;
            System.out.println("Transaction Successful");
        }
    }

    // method to check balance
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class ATM {

    // static PIN
    static int PIN = 1234;

    // method for PIN checking
    boolean authenticate(int enteredPin) {

        if (enteredPin == PIN) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM();
        Account acc = new Account();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        // checking PIN
        if (atm.authenticate(pin)) {

            int choice;

            while (true) {

                System.out.println("\n----- ATM MENU -----");
                System.out.println("1. Withdraw Money");
                System.out.println("2. Check Balance");
                System.out.println("3. Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                if (choice == 1) {

                    try {
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();

                        acc.withdraw(amount);

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        break;
                    }

                }
                else if (choice == 2) {
                    acc.checkBalance();
                }
                else if (choice == 3) {
                    System.out.println("Thank you for using ATM");
                    break;
                }
                else {
                    System.out.println("Invalid Choice");
                }
            }

        }
        else {
            System.out.println("Wrong PIN");
        }
    }
}
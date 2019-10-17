/*
 Implement a simple banking system in Java. Your application should demonstrate the following.
Upon running the java code, first the application should welcome the user, then ask the user to
give one of the options: 1) display the balance summary, 2) withdraw money, or 3) deposit
money.
Based on the options your code should perform the following operations such as 1) read the
transaction details from a file and display them on the screen. 2) ask the user to enter the amount
he wants to withdraw and debit the withdrawal amount from the balance amount. It has to update
the file and display the transaction summary. The system should not allow an attempt to
withdraw an amount greater than the balance. 3) ask the user to enter the amount he wants to
deposit, credit the balance and update the file. It should display the transaction summary.
The records in the file should contain transaction number, transaction type, amount withdrawn,
or amount deposited, and balance.
Example:
1 Deposit 100.0$ 1100.0$
2 Withdraw 50.0$ 1050.0$
The welcome screen should look like:
Welcome to CIS-2348 Banking System!
Enter your Option in a number: 1. Display balance 2. Deposit amount 3. Withdraw amount
We assume that there is an opening balance of 1000 available in the system (Assign
balance=1000.0 in the beginning of the code). Also, while running first start by choosing deposit
option or withdraw option.
*/

import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        double balance = 1000;
        int userChoice;
        boolean isValid = false;
        int[] validChoices = new int[]{1, 2, 3, 4};
        String spacer = "--------------------------------------------";
        int transactionCount = 1;

        System.out.printf("%s\nWelcome to the CIS-2348 Banking System!\n%s\n", spacer, spacer);
        while (true) {
            do {
                System.out.println("Please choose from the following options:\n" +
                        "1. Display Transactions and Balance\n" +
                        "2. Withdraw Money\n" +
                        "3. Deposit Money\n" +
                        "4. Exit");
                userChoice = input.nextInt();
                for (int i : validChoices) {
                    if (i == userChoice) {
                        isValid = true;
                        break;
                    }
                }
            } while (!isValid);
            if (userChoice == 1) {
                if (transactionCount == 1) {
                    System.out.println(spacer);
                    System.out.println("You do not have any transactions yet.");
                    System.out.printf("Your current balance is: $%.2f\n", balance);
                    System.out.println(spacer + "\n");
                }else {
                    printTransactions();
                }
            } else if (userChoice == 2) {
                System.out.println("How much would you like to withdraw?");
                double withdrawAmount = input.nextDouble();
                while (withdrawAmount > balance) {
                    System.out.printf("You cannot withdraw more than your current balance of $%.2f! Please enter a valid amount.\n", balance);
                    withdrawAmount = input.nextDouble();
                }
                balance -= withdrawAmount;
                System.out.println(spacer);
                System.out.printf("You have successfully withdrawn $%.2f from your account!\n", withdrawAmount);
                System.out.println(spacer + "\n");
                appendWithdraw(transactionCount, withdrawAmount, balance);
                transactionCount++;
            } else if (userChoice == 3) {
                System.out.println("How much would you like to desposit?");
                double depositAmount = input.nextDouble();
                balance += depositAmount;
                System.out.println(spacer);
                System.out.printf("You have successfully deposited $%.2f into your account!\n", depositAmount);
                System.out.println(spacer + "\n");
                appendDeposit(transactionCount, depositAmount, balance);
                transactionCount++;
            } else if (userChoice == 4) {
                System.out.println(spacer);
                System.out.println("Thank you for banking with us!");
                System.out.println(spacer);
                break;
            }
        }
    }

    private static void printTransactions() throws IOException{
        File infile = new File("transactions.txt");
        Scanner reader = new Scanner(infile);
        System.out.println("\n--------------------------TRANSACTIONS--------------------------\n");
        while(reader.hasNext()) {
            String details = reader.nextLine();
            System.out.println(details);
        }
        System.out.println("\n-----------------------END OF TRANSACTIONS----------------------\n");
    }

    private static void appendDeposit(int transcount, double amount, double bal) throws IOException {
        FileWriter fw = new FileWriter("transactions.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.printf("%d. Deposit  | Amount:  $%.2f | New Balance: $%.2f \n", transcount, amount, bal);
        pw.close();
    }

    private static void appendWithdraw(int transcount, double amount, double bal) throws IOException {
        FileWriter fw = new FileWriter("transactions.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.printf("%d. Withdraw | Amount: -($%.2f) | New Balance: $%.2f \n", transcount, amount, bal);
        pw.close();
    }
}
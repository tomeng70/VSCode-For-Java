/*
 * Thomas Eng
 * SW Design with Java
 * 
 * This program  for the account ID and the account balance for 3 users:
 * Account ID ranges from 1 to 99999.
 * Account balances range from 
 * 999,999,999.99.
 * Print out account ID and balance info to screen.
 * Pad ID’s with zeros.
 * Print out account balances to two decimal places.
 * Print out account balances so they are aligned the same from row to row 
 */

// import the Scanner class so we can use it to get input.
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        // create a Scanner object that we can use to get keyboard input.
        Scanner in = new Scanner(System.in);

        // prompt user for first ID.
        System.out.print("Enter the first account ID: ");
        int id1 = in.nextInt();

        // prompt user for first balance.
        System.out.printf("Enter the account balance for ID = %06d: ", id1);
        double bal1 = in.nextDouble();

        // prompt user for second ID.
        System.out.print("Enter the second account ID: ");
        int id2 = in.nextInt();

        // prompt user for first balance.
        System.out.printf("Enter the account balance for ID = %06d: ", id2);
        double bal2 = in.nextDouble();

        // prompt user for second ID.
        System.out.print("Enter the third account ID: ");
        int id3 = in.nextInt();

        // prompt user for first balance.
        System.out.printf("Enter the account balance for ID = %06d: ", id3);
        double bal3 = in.nextDouble();

        // print formatted account info.
        // don't forget the newline (%n) at the end of each statement.
        System.out.printf("Account #%06d has a balance of $%12.2f%n", id1, bal1);
        System.out.printf("Account #%06d has a balance of $%12.2f%n", id2, bal2);
        System.out.printf("Account #%06d has a balance of $%12.2f%n", id3, bal3);
    }
}
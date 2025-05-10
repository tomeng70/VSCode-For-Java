import java.util.Scanner;

/*
 * This program uses the 1913 tax schedule to calculate the total tax amount for an individual:
 *   1 percent on the first $50,000.
 *   2 percent on the amount over $50,000 up to $75,000.
 *   3 percent on the amount over $75,000 up to $100,000.
 *   4 percent on the amount over $100,000 up to $250,000.
 *   5 percent on the amount over $250,000 up to $500,000.
 *   6 percent on the amount over $500,000.
 */
public class CalculateTaxAnotherWay {
    public static void main(String[] args) {
        // create a Scanner object to use to get input from user.
        Scanner in = new Scanner(System.in);

        // prompt the user for their income.
        System.out.print ("Enter your income ($): ");
        double income = in.nextDouble();

        // use conditional statements to calculate the total tax.
        
        // tax amount starts at 0.
        double tax = 0;

        // initialize the income amount as the "leftover" amount of money.
        double leftover = income;

        // how much should they pay at 1% tax rate?
        if (leftover > 50000) {
            tax = tax + 50000 * 0.01;
            leftover = leftover - 50000;
        } else {
            tax = tax + leftover * 0.01;
            leftover = 0;
        }

        // how much should they pay at 2% tax rate?
        if (leftover > 25000) {
            tax = tax + 25000 * 0.02;
            leftover = leftover - 25000;
        } else {
            tax = tax + leftover * 0.02;
            leftover = 0;
        }

        // how much should they pay at 3% tax rate?
        if (leftover > 25000) {
            tax = tax + 25000 * 0.03;
            leftover = leftover - 25000;
        } else {
            tax = tax + leftover * 0.03;
            leftover = 0;
        }

        // how much should they pay at 4% tax rate?
        if (leftover > 150000) {
            tax = tax + 150000 * 0.04;
            leftover = leftover - 150000;
        } else {
            tax = tax + leftover * 0.04;
            leftover = 0;
        }

        // how much should they pay at 5% tax rate?
        if (leftover > 250000) {
            tax = tax + 250000 * 0.05;
            leftover = leftover - 250000;
        } else {
            tax = tax + leftover * 0.05;
            leftover = 0;
        }

        if (leftover > 0) {
            tax = tax + leftover * 0.06;
        }

        // print results.
        System.out.printf("The tax amount is $%,13.02f%n", tax);
    }
}

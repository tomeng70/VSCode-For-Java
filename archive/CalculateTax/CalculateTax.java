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
public class CalculateTax {
    public static void main(String[] args) {
        // create a Scanner object to use to get input from user.
        Scanner in = new Scanner(System.in);

        // prompt the user for their income.
        System.out.print ("Enter your income ($): ");
        double income = in.nextDouble();

        // use conditional statements to calculate the total tax.
        double tax = 0;
        double leftover = 0;
        if (income <= 50000) {
            // they only pay 1% on their income.
            tax = income * 0.01;
        } else if (income <= 75000) {
            // 1% on the first 50k
            // and 2% on whatever is leftover.
            leftover = income - 50000;
            tax = 50000 * 0.01 + leftover * 0.02;
        } else if (income <= 100000) {
            // 1% on the first 50k.
            // 2% on the next 25k.
            // 3% on whatever is leftover.
            leftover = income - (50000 + 25000);
            tax = 50000 * 0.01 + 25000 * 0.02 + leftover * 0.03;
        } else if (income <= 250000) {
            // 1% on the first 50k.
            // 2% on the next 25k.
            // 3% on the next 25k.
            // 4% on whatever is leftover.
            leftover = income - (50000 + 25000 + 25000);
            tax = 50000 * 0.01 + 25000 * 0.02 + 25000 * 0.03 + leftover * 0.04;
        } else if (income <=500000) {
            // 1% on the first 50k.
            // 2% on the next 25k.
            // 3% on the next 25k.
            // 4% on the next 150k.
            // 5% on whatever is leftover.
            leftover = income - (50000 + 25000 + 25000 + 150000);
            tax = 50000 * 0.01 + 25000 * 0.02 + 25000 * 0.03 + 150000 * 0.04 + leftover * 0.05;
        } else {
            // 1% on the first 50k.
            // 2% on the next 25k.
            // 3% on the next 25k.
            // 4% on the next 150k.
            // 5% on the next 250k.
            // 6% on whatever is leftover.
            leftover = income - (50000 + 25000 + 25000 + 150000 + 250000);
            tax = 50000 * 0.01 + 25000 * 0.02 + 25000 * 0.03 + 150000 * 0.04 + 250000 * 0.05 + leftover * 0.06;
        }

        // print results.
        System.out.printf("The tax amount is $%,13.02f%n", tax);
    }
}
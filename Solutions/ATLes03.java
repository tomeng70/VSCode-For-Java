import java.util.Scanner;

public class ATLes03 {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // get the amount of money from the user.
        double amount;
        System.out.print("Enter how much money you have in decimal format: ");
        amount = input.nextDouble();

        // how many dollars and cents?
        // cast the value to an integer to get rid of the decimal portion.
        int dollars = (int) amount;

        // subtract dollars from amount, then multiply by 100 to calculate cents.
        int cents = (int) ((amount - dollars) * 100);

        // print value.
        System.out.printf("You have %d dollars and %d cents.%n", dollars, cents);
    }
}
import java.util.Scanner;

public class StudentStore {
    static public void main(String args[]) {
        // create Scanner object for user input.
        Scanner input = new Scanner(System.in);

        // ask store clerk if shopper has has a valid ID.
        System.out.print("Does shopper have a valid student ID (yes/no)? ");
        String reply = input.next();

        // ask store clerk for the total cost of the products.
        System.out.print("Enter the total cost of goods: ");
        double total = input.nextDouble();

        // apply a discount that depends on whether they have an ID
        // and on the total purchase amount.
        double discount = 0.0;
        if (reply.toUpperCase().equals("YES")) {
            // they are a student and get bigger discounts.
            if (total > 150) {
                discount = 0.20;
            } else if (total > 100) {
                discount = 0.10;
            } else if (total > 30) {
                discount = 0.05;
            } 
        } else {
            // they are not a student, but still get a discount.
            if (total > 150) {
                discount = 0.125;
            } else if (total > 100) {
                discount = 0.07;
            } else if (total > 30) {
                discount = 0.02;
            }
        }
        
        // revise the total amount.
        total = (1 - discount) * total;

        // print the total.
        System.out.printf("Discount: %.1f%%%n", (discount * 100));
        System.out.printf("Discounted Total cost: $%10.2f%n", total);
    }
    
}

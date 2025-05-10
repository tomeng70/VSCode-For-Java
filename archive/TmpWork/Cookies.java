package Unit05.Unit06;
import java.util.Scanner;
public class Cookies {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many cookies do you want to buy: ");
        double cookies = input.nextDouble();
        final double COST = .99;

        // make totalCost a variable that visible in the main method (not just in an if or else clause).
        double totalCost = 0;
        if (cookies >= 24){
            //double totalCost = (cookies * COST) * .85;
            totalCost = (cookies * COST) * .85;
            //System.out.printf("Total cost: $%.2f%n", totalCost);
        } else if (cookies >= 12){
            //double totalCost = (cookies * COST) * .95;
            totalCost = (cookies * COST) * .95;
            //System.out.printf("Total cost: $%.2f%n", totalCost);
        } else if (cookies >= 6){
            //double totalCost = (cookies * COST) * .975;
            totalCost = (cookies * COST) * .975;
            //System.out.printf("Total cost: $%.2f%n", totalCost);
        } else {
            // don't forget the case when they have < 6 cookies.
            // no discount.
            totalCost = cookies * COST;
        }

        // print the total cost here to be more efficient.
        System.out.printf("Total cost: $%.2f%n", totalCost);
    

    }
}


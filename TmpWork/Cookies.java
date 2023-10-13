package Unit05.Unit06;
import java.util.Scanner;
public class Cookies {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many cookies do you want to buy: ");
        double cookies = input.nextDouble();
        final double COST = .99;

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
            // no discount.
            totalCost = cookies * COST;
        }

        // print the total cost.
        System.out.printf("Total cost: $%.2f%n", totalCost);
    

    }
}


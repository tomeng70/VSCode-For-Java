import java.util.Scanner;

public class ExamplePromptUserMoney {
    public static void main(String[] args) {
        // a simple program that demonstrates how
        // to use a do loop to get data from a user through the keyboard.

        // create a Scanner object to get data.
        Scanner in = new Scanner(System.in);

        // declare a variable to track the total money spent.
        // initialize to zero dollars.
        double totalAmount = 0;

        // declare a variable to represent the value entered by the user.
        double value = 0;

        // provide user with instructions on how to enter data before looping.
        System.out.println("Enter money spent as double values.  Enter in a negative value to finish.");

        // use a do loop to collect data from the user.
        // use a boolean variable called "loopFlag" to determine when to quit looping.
        boolean loopFlag = true;
        do {
            // get the next double value.
            value = in.nextDouble();

            // did the user provide valid data or are they done entering data?
            if (value >= 0) {
                // add the value to the total.
                totalAmount = totalAmount + value;
            } else {
                // the user is done entering data.
                loopFlag = false;
            }
        } while (loopFlag);

        // print the total money spent.
        System.out.printf("The total amount spent is $%.02f.%n", totalAmount);

    }
    
}

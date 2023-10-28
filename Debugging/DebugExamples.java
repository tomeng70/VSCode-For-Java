package Debugging;

import java.util.Scanner;

public class DebugExamples {
    public static void main(String[] args) {
        // compile time error.
        /*
        int a;
        double x = 3.14;
        a = x;
        */

        
/*         // runtime error.
        String name = "Harry";
        for (int i=1; i <= name.length(); i++) {
            System.out.println(name.charAt(i));
        } */
       
        // logic error
        Scanner in = new Scanner(System.in);
        double total = 0;
        double value = 0;
        int count = 0;
        do {
            System.out.print("Enter how much money you spent or a negative value to exit: ");
            value = in.nextDouble();
            count = count + 1;
            total = total + value;
        } while (value >= 0);
        
        double avg = total / count;
        System.out.println("The number of values entered is " + count);
        System.out.printf("The average value is %.2f", avg);
    }
}

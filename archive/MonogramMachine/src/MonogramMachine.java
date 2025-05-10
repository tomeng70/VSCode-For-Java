
/*
 * Thomas Eng
 * SW Design with Java
 * This program asks for 3 names and creates a monogram
 * which consists of the first three letters of each name.
 */
import java.util.Scanner;

public class MonogramMachine {
    public static void main(String[] args) throws Exception {
        // get input from user.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first middle and last names: ");
        String first = input.next();
        String middle = input.next();
        String last = input.next();

        // get the first letter of each name.
        String monogram = first.substring(0, 1)
                + middle.substring(0, 1) + last.substring(0, 1);

        // make it upper case.
        monogram = monogram.toUpperCase();

        System.out.println("Your monogram is " + monogram);
    }
}

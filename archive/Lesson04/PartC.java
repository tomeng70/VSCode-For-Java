/*
 * Thomas Eng
 * SW Design with Java
 * 
 * Write a program that does the following,
 * Prompts the user for the length, width, and height in cm of a box
 * The dimensions can have fractional components (i.e., not integers)
 * Calculates the surface area of the box (in cm2)
 * Calculates the volume of the box (in cm3)
 * Displays the dimensions, surface area, and volume with the decimal places all aligned (see example output below)
 * Assume max value is 9,999,999.99
 * 
 * Enter the length, width, and height (cm) of the box: 234.56 241 99.9
 *   length (cm)     =     234.56
 *   width  (cm)     =     241.00
 *   height (cm)     =      99.90
 *   s area (sq cm)  =  208074.81
 *   volume (cu cm)  = 5647243.10
 */

// import Scanner class so we can get keyboard input.
import java.util.Scanner;

public class PartC {
    public static void main(String[] args) {
        // create Scanner object.
        Scanner in = new Scanner(System.in);

        // prompt user for inputs.
        System.out.print("Enter the length, width, and height (cm) of the box: ");

        // Scan in values as doubles.
        // Note we're not doing any error checking here (even though we should).
        double l = in.nextDouble();
        double w = in.nextDouble();
        double h = in.nextDouble();

        // calc surf area and vol.
        double surf = 2 * (l * w) + 2 * (l * h) + 2 * (w * h);
        double vol = l * w * h;

        // display info (formatted).
        System.out.printf("  length (cm)     = %10.2f%n", l);
        System.out.printf("   width (cm)     = %10.2f%n", w);
        System.out.printf("  height (cm)     = %10.2f%n", h);
        System.out.printf("  s area (sq cm)  = %10.2f%n", surf);
        System.out.printf("  volume (cu cm)  = %10.2f%n", vol);
    }
}

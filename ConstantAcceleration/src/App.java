/*
 * Thomas Eng
 * AT SW Design with Java.
 * HW #03, Part D.
 * 
 * This program calculates the height of an object in free fall.
 * It uses the constant acceleration equations from physics.
 * 
 * h = h0 + v0·t + ½·g·t2
 * where g = -9.81 m/s^2.
 */

// import the Scanner class. We will use it to get input from the user.
import java.util.Scanner;

import javax.swing.plaf.synth.SynthCheckBoxUI;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a Scanner object.
        Scanner in = new Scanner(System.in);

        // define constant for gravity.
        final double GRAVITY = -9.81; // m/s.

        // get the user's name.
        System.out.print("Enter your name: ");
        String name = in.nextLine();

        // print the name.
        System.out.println("Hello, " + name);

        // get the initial height (as a decimal and in meters).
        System.out.print("Enter the initial height in meters (as a decimal number): ");
        double h0 = in.nextDouble();

        // get the initial velocity (as a decimal and in m/s).
        System.out.print("Enter the initial velocity in meters per second (as a decimal number): ");
        double v0 = in.nextDouble();

        // get the time (as a decimal and in s).
        System.out.print("Enter the time of fall in seconds (as a decimal number): ");
        double t = in.nextDouble();

        // calculate height.
        // note, be careful when evaluating 1.0 / 2.0.
        // use doubles to avoid integer division.
        double h = h0 + v0 * t + 1.0 / 2.0 * GRAVITY * t * t;

        System.out.println("h0 = " + h0 + " m.");
        System.out.println("v0 = " + v0 + " m/s.");
        System.out.println("t  = " + t + " s.");
        System.out.println("h  = " + h + " m.");
    }
}

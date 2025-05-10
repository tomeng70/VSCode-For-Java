import java.util.Scanner;

public class App {
   
    public static void main(String[] args) throws Exception {
        final double THRESHOLD = 1e-14;
        double x = 0.3 * 3 + 0.1;
        double y = 1;

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        if (Math.abs(x-y) < THRESHOLD) {
            System.out.println("The numbers are the same.");
        } else {
            System.out.println("The numbers are different.");
        }
    }
}

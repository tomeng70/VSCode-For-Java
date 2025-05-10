import java.util.Scanner;

/*
 * Thomas Eng
 * Software Design with Java
 * Example: Investment Calculator
 */
public class App {
    public static void main(String[] args) throws Exception {
        // set up a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // get initial investment
        System.out.print("Enter the initial investment amount ($): ");
        float initInvest = input.nextFloat();

        // get APY
        System.out.print("Enter the APY as a decimal value: ");
        float APY = input.nextFloat();

        // get term
        System.out.print("Enter the number of years (integer): ");
        int N = input.nextInt();

        // initialize current year and balance variables.
        int currentYear = 0;
        float balance = initInvest;
        float interestEarned = 0;
        System.out.println(String.format("  year = %2d, balance = $%.02f", currentYear, balance));

        // loop N times.
        while (currentYear < N) {
            currentYear = currentYear + 1;
            interestEarned = balance * APY;
            balance = balance + interestEarned;
            System.out.println(String.format("  year = %2d, balance = $%.02f", currentYear, balance));
        }
    }
}

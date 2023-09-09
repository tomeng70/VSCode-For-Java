import java.util.Scanner;

public class HrMinSec {
    static final int SECONDS_PER_HOUR = 3600;
    static final int SECONDS_PER_MIN = 60;

    public static void main(String[] args) {
        // input will be used to get user input.
        Scanner input = new Scanner(System.in);

        // prompt user for the period in seconds.
        int periodSec;
        System.out.print("Enter the time period in seconds: ");
        periodSec = input.nextInt();

        // the variable leftover is used to track how many seconds 
        // is left over after the previous calculation.
        int leftover = periodSec;

        // calculate how many hours in period.
        int hours = leftover / SECONDS_PER_HOUR;

        // calculate how many seconds are leftover after calculating hours.
        leftover = leftover % SECONDS_PER_HOUR;

        // calculate how many minutes in the leftover time.
        int minutes = leftover / SECONDS_PER_MIN;

        // how many seconds leftover after calculating minutes?
        // the leftover time is equal to the number of seconds in our display.
        leftover = leftover % SECONDS_PER_MIN;

        // display in hours:minutes:seconds format.
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, leftover);
    }
}
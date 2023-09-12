public class App {
    // we want to solve for Pi to 6 significant digits.  
    // If we set our threshold to 1E-7 then our value of Pi
    // (which is 4 * our calculated value of the series) 
    // should be accurate to 1E-6.
    static final double THRESHOLD = 0.0000005 / 4;

    // set the following constant to true if you want to display debug statements.
    // note it will take a very, very long time to calculat Pi if you display the
    // debug statements.
    static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        // declare my variables.
        int sign;                   // used to keep track of whether we're adding or subtracting the next term in the series.
        double previous;            // the previous value of our estimate of Pi/4.
        double current;             // the current value of our estimate of Pi/4
        int denominator;            // use this to track the denominator of the term that we are adding to the series.
        double term;                // the next term we are adding to the series.
        double error;               // the absolute value of the difference between our current and previous estimates.
        long steps;                 // use this to track how many steps it takes to solve for Pi to our desired accuracy.

        // initialize our variables.
        previous = 0;               // our previous estimate starts out as zero.
        denominator = 1;            // the denominator of the series starts at as 1.
        sign = +1;                  // initially you add the first term of the series.
        
        // calculate the first term.
        term = 1.0 / denominator;
        current = previous + term;
        error = Math.abs(current - previous);
        steps = 1;

        // loop until our errror is below the precision value.
        while (error > THRESHOLD) {
            // update the previous value.
            previous = current;

            // calculate the next term.
            denominator = denominator + 2;  
            sign = -1 * sign;                           // sign toggles between + and -
            term = sign * 1.0/ denominator;

            // update our estimate;
            current = previous + term;

            // update our error.
            error = Math.abs(current - previous);

            // keep track of how many steps we took.
            steps = steps + 1;
        }
      
        // calculate Pi.
        double pi = current * 4;

        // display formatted output.
        System.out.println(String.format("  steps = %04d, prev = %.08f, curr = %.08f, err = %.16f", steps, previous, current, error));
        String answer = String.format("%.07f", pi);
        System.out.println(String.format("  Pi = " + answer));


        // chop off the last digit (but don't round);
        answer = answer.substring(0, answer.length() - 1);

        System.out.println(String.format("  Pi = " + answer));
    }
}

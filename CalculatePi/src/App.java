public class App {
    // we want to solve for Pi to 6 significant digits.  
    // If we set our threshold to 1E-7 then our value of Pi
    // (which is 4 * our calculated value of the series) 
    // should be accurate to 1E-6.
    static final double THRESHOLD = 0.0000001;

    // set the following constant to true if you want to display debug statements.
    // note it will take a very, very long time to calculat Pi if you display the
    // debug statements.
    static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        // initialize variables.
        int sign = -1; // keep track of whether we're subtracting or adding.
        double previousVal = 0;
        double currentVal = 1;
        double error = Math.abs(currentVal - previousVal);

        // loop until error is below threshold value.
        int index = 3;
        while (error > THRESHOLD) {
            // update the previous value.
            previousVal = currentVal;
            
            // Add or subtract to the current value.
            currentVal = previousVal + sign * 1.0 / index;

            // cacluate the error (as an absolute value).
            error = Math.abs(currentVal - previousVal);

            // display info for user.
            if (DEBUG) {
                System.out.println(String.format(" index = %04d, prev = %.12f, curr = %.12f, err = %.12f", index,
                    previousVal, currentVal, error));
            }
            
            // toggle the sign so we'll alternate between subtraction and addition.
            sign = -1 * sign;

            // increase the index by two (we only want the odd numbers).
            index = index + 2;
        }
        
        // calculate Pi.
        double pi = currentVal * 4;

        // display formatted output.
        System.out.println(String.format("  index = %04d, prev = %.08f, curr = %.08f, err = %.08f", index, previousVal, currentVal, error));
        System.out.println(String.format("  Pi = %.08f", pi));
    }
}

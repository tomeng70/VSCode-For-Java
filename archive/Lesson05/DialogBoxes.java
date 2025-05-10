/*
 * Thomas Eng
 * SW Development with Java
 * 
 * This program demonstrates how to use dialog boxes to get input
 * and to display output.  It also showcases how to use static methods.
 */

// import the JOptionPane string which contains static 
// methods for displaying dialog boxes.
import javax.swing.JOptionPane;

public class DialogBoxes {
    public static void main(String[] args) {
        // prompt user for name.
        String name = JOptionPane.showInputDialog("Tell me your name:");

        // prompt user for a number.
        // note the input is returned as a String.
        // we need to convert it to a double afterwards.
        String input = JOptionPane.showInputDialog("Enter a number:");
        double x = Double.parseDouble(input);

        // get a second number;
        input = JOptionPane.showInputDialog("Enter another number:");
        double y = Double.parseDouble(input);

        // calculate the product.
        double product = x * y;

        // display info using a message dialog box.
        JOptionPane.showMessageDialog(null, name +
                ", the product of the numbers is " + product);
    }
}
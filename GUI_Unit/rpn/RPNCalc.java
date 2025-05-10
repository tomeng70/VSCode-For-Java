import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPNCalc {
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 200;
    private JFrame frame;
    private JPanel panel;
    private JTextField txtDisplay;

    private JPanel pnlButtons;
    private GridBagConstraints constraints;

    // Use a stack of doubles to keep track of operands.
    private Stack stack;

    // clearFlag indicates if display should be cleared
    // before its text value gets updated.
    private boolean clearFlag;

    // constructor
    public RPNCalc() {
        // create the frame.
        frame = new JFrame("RPN Calculator");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // place the frame in the center of the screen
        frame.setLocationRelativeTo(null);

        // create our main panel for our UI.
        // use a BorderLayout manager.
        panel = new JPanel(new BorderLayout());

        // add the display field to our panel.
        addDisplay(panel);

        // add the buttons subpanel to our panel.
        addButtons(panel);

        // add the panel to our frame.
        frame.add(panel);

        // make the frame visible.
        frame.setVisible(true);

        // create a stack of double values to hold our operands.
        stack = new Stack();

        // initially, clear flag is false.
        // clear flag gets set to true after a calculation is made
        // and after a result is displayed on the UI.
        clearFlag = false;
    }

    private void addButtons(JPanel panel) {
        // use a gridbag layout to allow us to have variable sized buttons.
        pnlButtons = new JPanel(new GridBagLayout());

        // the constraints object is what we will use
        // to configure the cells of our grid.
        constraints = new GridBagConstraints();

        // By default, each button should be one col wide and one row tall.
        constraints.gridheight = 1;
        constraints.gridwidth = 1;

        // set weight of constraints so the sizes of the buttons are all the same.
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        // configure the cells so the components fill
        // the cell in the horiz and vert directions.
        constraints.fill = GridBagConstraints.BOTH;

        // add the number keys,
        addDigitButton(0, 0, "7");
        addDigitButton(1, 0, "8");
        addDigitButton(2, 0, "9");
        addDigitButton(0, 1, "4");
        addDigitButton(1, 1, "5");
        addDigitButton(2, 1, "6");
        addDigitButton(0, 2, "1");
        addDigitButton(1, 2, "2");
        addDigitButton(2, 2, "3");
        addDigitButton(0, 3, "0");
        addDigitButton(1, 3, ".");
        addDigitButton(2, 3, "+/-");

        // add the all clear key to 1st col, 5th row.
        addActionButton(0, 4, "C");

        // add the clear entry key to 2nd col, 5th row.
        addActionButton(1, 4, "CE");

        // add the operator keys.
        // add the / key to 4th col, 1st row.
        addActionButton(3, 0, "/");

        // add the * key to 4th col, 2nd row.
        addActionButton(3, 1, "*");

        // add the - key to the 4th col, 3rd row.
        addActionButton(3, 2, "-");

        // add the + key to the 4th col, 4th row.
        addActionButton(3, 3, "+");

        // change the constraints so the ENTER button will
        // be twice as wide as the other buttons
        // (i.e., so it takes up two cell widths).
        constraints.gridwidth = 2;
        addActionButton(2, 4, "ENTER");

        // add subpanel to center of main panel.
        panel.add(pnlButtons, BorderLayout.CENTER);
    }

    private void addDisplay(JPanel panel) {
        // add the display at the top of the panel.
        txtDisplay = new JTextField("0");
        txtDisplay.setHorizontalAlignment(SwingConstants.LEFT);
        txtDisplay.setEditable(false);
        panel.add(txtDisplay, BorderLayout.NORTH);
    }

    private JButton addButton(int gridx, int gridy, String label) {
        // create the button.
        JButton btn;
        btn = new JButton(label);

        // add button to the button panel.
        constraints.gridy = gridy;
        constraints.gridx = gridx;
        pnlButtons.add(btn, constraints);
        return btn;
    }

    private void addDigitButton(int gridx, int gridy, String label) {
        // create the button and add it to the buttons panel.
        JButton btn = addButton(gridx, gridy, label);

        // add a DigitButtonListener for this type of button.
        btn.addActionListener(new DigitButtonListener(label));
    }

    private void addActionButton(int gridx, int gridy, String label) {
        // create the button and add it to the buttons panel.
        JButton btn = addButton(gridx, gridy, label);

        // add an ActionButtonListener for this type of button.
        btn.addActionListener(new ActionButtonListener(label));
    }

    private class DigitButtonListener implements ActionListener {
        private String label;

        /*
         * Constructor.
         */
        public DigitButtonListener(String label) {
            this.label = label;
        }

        public void actionPerformed(ActionEvent e) {
            // get the current text from the display.
            String text = txtDisplay.getText();

            // check to see if we should toggle the sign
            // of the value in the display.
            if (label.equals("+/-")) {
                if (text.contains("-")) {
                    text = text.replaceAll("-", "");
                } else {
                    text = "-" + text;
                }
                txtDisplay.setText(text);
                // reset clear flag.
                clearFlag = false;
                return;
            }

            // clear the display if needed.
            if (clearFlag) {
                clearEntry();
                clearFlag = false;
                // since we cleared the display,
                // get the updated text from the display.
                text = txtDisplay.getText();

                // if label equals "0" then don't add another zero.
                if (label.equals("0")) {
                    // the display should already have a zero from the clearEntry() method.
                    return;
                }
            }

            // check to see what digit (or decimal point) we need to add.
            if (text.equals("0") && !label.equals("0")) {
                txtDisplay.setText(label);
            } else if (label.equals(".")) {
                if (!text.contains(".")) {
                    // put a decimal if there isn't already a decimal.
                    text = text + ".";
                    txtDisplay.setText(text);
                }
            } else {
                txtDisplay.setText(text + label);
            }
        }
    }

    private class ActionButtonListener implements ActionListener {
        private String label;

        public ActionButtonListener(String label) {
            this.label = label;
        }

        public void actionPerformed(ActionEvent e) {
            if (label.equals("C")) {
                clearAll();
            } else if (label.equals("CE")) {
                clearEntry();
            } else if (label.equals("ENTER")) {
                doEnter();
            } else if (label.equals("+")) {
                doOperation(label);
            } else if (label.equals("-")) {
                doOperation(label);
            } else if (label.equals("*")) {
                doOperation(label);
            } else if (label.equals("/")) {
                doOperation(label);
            }
        }
    }

    /*
     * Clear the stack and the display.
     */
    public void clearAll() {
        stack.clear();
        setDisplay(0);
    }

    // Clear the display.
    public void clearEntry() {
        setDisplay(0);
    }

    /*
     * Update the display with a double value.
     * If the double value is also an integer,
     * then display it as an integer.
     */
    public void setDisplay(double d) {
        String text;
        // check if it's an integer.
        if (d % 1 == 0) {
            text = Integer.toString((int) d);
        } else {
            text = Double.toString(d);
        }
        txtDisplay.setText(text);
    }

    public double getDisplayValue() {
        double value;
        try {
            value = Double.parseDouble(txtDisplay.getText());
            return value;
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public void doEnter() {
        // get the value from the display.
        double value;
        try {
            // get the value and then push it to the stack.
            value = Double.parseDouble(txtDisplay.getText());
            stack.push(value);

            // set clear flag so display will clear if they type in a new digit.
            clearFlag = true;
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse the text display.");
        }
    }

    public void doOperation(String label) {
        // check if the clearFlag is set to true.
        // if it's true, do not do any operation until a new number is entered into the
        // display
        // (which will clear the display and reset the clearFlag).
        if (clearFlag) {
            System.out.println("Enter another number into the display.");
            return;
        }

        // check to make sure something is on the stack.
        if (stack.isEmpty()) {
            // nothing in the stack. cannot do operation.
            System.err.println("unable to do operation (" + label + ").");
            System.err.println("stack is empty.");
            return;
        }

        // get the second operand from the display.
        double d2 = getDisplayValue();

        // if not a number, return.
        // can't do anything till they type in a valid number.
        if (Double.isNaN(d2)) {
            System.err.println("Cannot do an operation with NaN in display.");
            return;
        }

        // check for divide by zero.
        if (d2 == 0 && label.equals("/")) {
            txtDisplay.setText("NaN");
            clearFlag = true;
            System.err.println("unable to do operation (" + label + ").");
            System.err.println("divide by zero.");
            return;
        }

        // get the first operand from the stack.
        double d1 = stack.pop();

        // use the label to determine which operation to conduct.
        double result;
        if (label.equals("/")) {
            result = d1 / d2;
        } else if (label.equals("*")) {
            result = d1 * d2;
        } else if (label.equals("-")) {
            result = d1 - d2;
        } else if (label.equals("+")) {
            result = d1 + d2;
        } else {
            System.err.println("Unknown operation.");
            return;
        }

        // update the display
        setDisplay(result);

        // push result onto stack.
        stack.push(result);

        // set clear flag so display will clear if they enter new digits.
        clearFlag = true;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new RPNCalc();
        });
    }
}
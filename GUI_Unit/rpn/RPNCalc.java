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

    private class DigitButtonListener implements ActionListener {
        private String label;

        /*
         * Constructor.
         */
        public DigitButtonListener(String label) {
            this.label = label;
        }

        public void actionPerformed(ActionEvent e) {
            // for now just print a message to the console whenever button is pressed.
            System.out.println("The button labeled \"" + label + "\" was pressed");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new RPNCalc();
        });
    }
}
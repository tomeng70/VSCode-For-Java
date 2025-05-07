import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.EventQueue;

public class RPNCalc {
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 200;
    private JFrame frame;
    private JPanel panel;
    private JTextField txtDisplay;

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

        // add the panel to our frame.
        frame.add(panel);

        // make the frame visible.
        frame.setVisible(true);
    }

    private void addDisplay(JPanel panel) {
        // add the display at the top of the panel.
        txtDisplay = new JTextField("0");
        txtDisplay.setHorizontalAlignment(SwingConstants.LEFT);
        txtDisplay.setEditable(false);
        panel.add(txtDisplay, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new RPNCalc();
        });
    }
}

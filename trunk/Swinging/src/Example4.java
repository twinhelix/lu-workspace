import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Example4Gui {
    int value = 0;
    JLabel result = new JLabel("0",SwingConstants.CENTER);

    public  void example4() {

        JButton increase = new JButton("+1");
        JButton decrease = new JButton("-1");
        JButton red = new JButton("red");
        JButton blank = new JButton("clear");
        JPanel square = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(300,300);
        Container contentPane =  frame.getContentPane();
        ExampleListener listen = new ExampleListener();

        red.setBackground(Color.RED);
        square.setLayout(new GridLayout(2,2));
        square.add(increase);
        square.add(decrease);
        square.add(red);
        square.add(blank);

        contentPane.add(result,BorderLayout.NORTH);
        contentPane.add(square,BorderLayout.CENTER);

        increase.addActionListener(listen);
        decrease.addActionListener(listen);
        red.addActionListener(listen);
        blank.addActionListener(listen);
        frame.setVisible(true);
    }

    class ExampleListener implements ActionListener {

        public  void actionPerformed(ActionEvent event) {
            /* only do this if the buttons are related and
               the action is short */
            // the button pressed
            JButton sent = (JButton)event.getSource();
            // the button's label
            String label = sent.getText();

            // Use the button's text to select the action
            if (label.equals("+1")) {
                value++;
            } else if (label.equals("-1")) {
                value--;
            } else if (label.equals("red")) {
                result.setForeground(Color.RED);
            } else {
                value=0;
                result.setForeground(Color.BLACK);
            }
            // update the value shown in the label
            result.setText(Integer.toString(value));
        }
    }
}

public class Example4 {

    public static void main(String [] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Example4Gui gui = new Example4Gui();
                gui.example4();
            }
        });
    }

}
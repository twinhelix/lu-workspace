import java.awt.*;
import javax.swing.*;

class Example3Gui {

    public  void example3() {
        JLabel  result = new JLabel("0",SwingConstants.CENTER);
        JPanel  square = new JPanel();
        JButton increase = new JButton("+1");
        JButton decrease = new JButton("-1");
        JButton red = new JButton("red");
        JButton clear = new JButton("blank");
        JFrame frame = new JFrame();

        frame.setSize(200,200);
        Container contentPane =  frame.getContentPane();
        square.setLayout(new GridLayout(2,2));
        square.add(increase);
        square.add(decrease);
        square.add(red);
        square.add(clear);
        red.setBackground(Color.RED);

        contentPane.add(result,BorderLayout.NORTH);
        contentPane.add(square,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

public class Example3 {
    public static void main(String [] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Example3Gui gui = new Example3Gui();
                gui.example3();
            }
        });
    }
}


import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.*;

class Example2Gui {

    public void example2() {

        JLabel  aLabel   = new JLabel("0",SwingConstants.CENTER);
        JButton increase = new JButton("+1");

        JFrame frame = new JFrame();
        frame.setSize(200,200);
        Container contentPane =  frame.getContentPane();
        contentPane.add(aLabel,BorderLayout.NORTH);
        contentPane.add(increase,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

public class Example2  {
    public static void main(String [] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Example2Gui gui = new Example2Gui();
                gui.example2();
            }
        });
    }

}

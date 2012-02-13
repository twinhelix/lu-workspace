import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


class Example1Gui {
    void example() {
        JFrame examp = new JFrame("A very simple gui");
        JLabel onlyComponent = new JLabel("0",SwingConstants.CENTER);

        examp.getContentPane().add(onlyComponent);
        examp.setSize(100,100);
        examp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        examp.setVisible(true);
    }
}

public class Example1  {

    public static void main(String [] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Example1Gui gui = new Example1Gui();
                gui.example();
            }
        });
    }
}


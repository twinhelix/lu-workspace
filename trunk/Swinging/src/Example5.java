import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Example5Gui  {
    int value = 0;
    int rows =2 ;
    Class myClass = Example5.class;
    JLabel result = new JLabel("0",SwingConstants.CENTER);
    ImageIcon downButtonIcon ;
    ImageIcon upButtonIcon ;

    void  example5(int theRows) {
        upButtonIcon =   new ImageIcon(myClass.getResource("Up.png"));
        downButtonIcon = new ImageIcon(myClass.getResource("Down.png"));
        JButton up = new JButton();
        JFrame frame = new JFrame();
        Container contentPane =  frame.getContentPane();
        rows = theRows;
        frame.setSize(300,300);
        JButton plusMinus = new JButton("+/-");
        JButton red = new JButton("red");
        JButton blank = new JButton("clear");
        ExampleListener listen = new ExampleListener();
        ExampleMouseAdapter mouseListen = new ExampleMouseAdapter();
        red.setBackground(Color.red);
        JPanel square = new JPanel(new GridLayout(rows,rows));
        square.add(plusMinus);
        square.add(red);
        square.add(up);
        square.add(blank);

        contentPane.add(result,BorderLayout.NORTH);
        contentPane.add(square,BorderLayout.CENTER);

        plusMinus.addMouseListener(mouseListen);
        red.addActionListener(listen);
        up.addActionListener(listen);
        blank.addActionListener(listen);
        up.setIcon(upButtonIcon);
        frame.setVisible(true);
    }

    class ExampleListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

             // the button pressed
            JButton sent = (JButton)event.getSource();
            // the button's label
            String label = sent.getText();

            if (label.equals("red")) {
                result.setForeground(Color.red);
            } else if (label.equals("clear")) {
                value=0;
                result.setForeground(Color.black);
            } else if ( sent.getIcon() == upButtonIcon) {
                sent.setIcon(downButtonIcon);
            } else {
                sent.setIcon(upButtonIcon);
            }
            result.setText(Integer.toString(value));
        }
    }


    class ExampleMouseAdapter extends MouseAdapter {

        public void mouseClicked(MouseEvent event) {
            // this overrides the empty method in Mouse Adapter

            if (SwingUtilities.isLeftMouseButton(event)) {
                value++;
            } else if (SwingUtilities.isRightMouseButton(event)) {
                value--;
            }
            result.setText(Integer.toString(value));
        }
    }
}

public class Example5 {
    public static void main(String[] args) {
        //  get the program parameter
        final int rows;
        if (args.length > 0) {
            try {
                rows = Integer.parseInt(args[0]);
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Example5Gui gui = new Example5Gui();
                        gui.example5(rows);
                    }
                });
            } catch (NumberFormatException except) {
                System.err.println("The first parameter should be a number");
                System.exit(1);
            }
        } else {
            System.err.println("The number of rows should be given as an argument");
        }
    }
}

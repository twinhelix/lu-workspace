import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class Example7Gui {

    JLabel result = new JLabel("0",SwingConstants.CENTER);
    int value = 0;

    public  void example7() {

        JFrame frame = new JFrame();
        frame.setSize(300,300);
        Container contentPane =  frame.getContentPane();
        JSlider slide = new JSlider(JSlider.VERTICAL,-10,10,0);
        slide.setMajorTickSpacing(5);
        slide.setMinorTickSpacing(1);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        slide.setBorder(
            BorderFactory.createEmptyBorder(0,0,10,0));

        contentPane.add(result,BorderLayout.CENTER);
        contentPane.add(slide,BorderLayout.EAST);
        slide.addChangeListener(new ChangeValue());
        frame.setVisible(true);
    }

    class ChangeValue implements ChangeListener {

        public void stateChanged(ChangeEvent expn) {
            JSlider source = (JSlider)expn.getSource();
            if (!source.getValueIsAdjusting()) {
                value = (int)source.getValue();
                result.setText(Integer.toString(value));
            }
        }
    }
}

public class Example7 {

    public static void main(String []argv) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Example7Gui gui = new Example7Gui();
                gui.example7();
            }
        });
    }
}

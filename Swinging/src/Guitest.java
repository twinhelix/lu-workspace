import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class Guitest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonHello = null;
	private JLabel jLabelfadjgjag = null;

	/**
	 * This is the default constructor
	 */
	public Guitest() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelfadjgjag = new JLabel();
			jLabelfadjgjag.setBounds(new Rectangle(84, 20, 156, 29));
			jLabelfadjgjag.setText("JLabel");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButtonHello(), null);
			jContentPane.add(jLabelfadjgjag, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonHello	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonHello() {
		if (jButtonHello == null) {
			jButtonHello = new JButton();
			jButtonHello.setBounds(new Rectangle(126, 75, 80, 29));
			jButtonHello.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jLabelfadjgjag.setText("ben is gay "); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonHello;
	}

}

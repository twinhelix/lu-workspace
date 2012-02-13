import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class App extends JFrame {

	private JPanel jContentPane = null;
	private JTextField TXTScreen = null;

	/**
	 * This method initializes TXTScreen	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTXTScreen() {
		if (TXTScreen == null) {
			TXTScreen = new JTextField();
			TXTScreen.setBounds(new java.awt.Rectangle(12,7,283,47));
		}
		return TXTScreen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public App() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(325, 301);
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
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new java.awt.Color(210,198,198));
			jContentPane.add(getTXTScreen(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

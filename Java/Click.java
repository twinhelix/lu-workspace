import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Click extends JFrame {

	private JPanel jContentPane = null;
	private JButton Pro = null;
	private JLabel jLabel = null;
	private JComboBox jComboBox = null;
	/**
	 * This method initializes Pro	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getPro() {
		if (Pro == null) {
			Pro = new JButton();
			Pro.setBounds(new java.awt.Rectangle(321,148,121,37));
			Pro.setText("Proceed");
			Pro.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int x = getJComboBox().getSelectedIndex();
					String name = "";
					switch (x){
					case 1 : name = "Lu";
					break;
					case 2 : name = "Fraser";
					break;
					case 3 : name = "Mark";
					break;
					case 4 : name = "Chainz";
					break;
					case 5 : name = "Ben";
					break;
					}
					Wtf c = new Wtf (name);
					c.setVisible(true);
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return Pro;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new java.awt.Rectangle(298,45,205,58));
		}
		return jComboBox;
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
	public Click() {
		super();
		initialize();
		getJComboBox().addItem("--Select Name--");
		getJComboBox().addItem("Lu");
		getJComboBox().addItem("Fraser");
		getJComboBox().addItem("Mark");
		getJComboBox().addItem("Chainz");
		getJComboBox().addItem("BEN");
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(551, 303);
		this.setContentPane(getJContentPane());
		this.setTitle("Name");
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(34,31,174,52));
			jLabel.setText("WHO ARE YOU!?!@?$");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getPro(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJComboBox(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

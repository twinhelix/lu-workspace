import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Wtf extends JFrame {

	private JPanel jContentPane = null;

	private JLabel wtf = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public Wtf (String Name){
		super();
		initialize();
		check (Name);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(572, 235);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private void check (String x)
	{
		if (x.equalsIgnoreCase("LU"))
			wtf.setText(x+ " IS FUCKING AWESOME!");
		else
		wtf.setText(x+" IS SUPER GAY hahahaha");
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			wtf = new JLabel();
			wtf.setBounds(new java.awt.Rectangle(8,20,510,150));
			wtf.setText("wtf");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(wtf, null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

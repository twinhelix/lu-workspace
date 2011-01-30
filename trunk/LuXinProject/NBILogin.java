import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.*;


public class NBILogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9022815419671440245L;
	String Login, Password, CorrectLogin; 
	String []DBLogin = new String[100];
	String [] DBPassword = new String[100];
	boolean [] DBAdmin = new boolean[100];
	private String SecretPassword="";
	int convert;
	
	private JPanel jContentPane = null;
	private JTextField TXTLogin = null;
	private JPasswordField PSWPassword = null;
	private JLabel LBLLogin = null;
	private JLabel LBLPassword = null;
	private JButton BTNLogin = null;
	Methods c = new Methods();
	private Connection conn = c.con();
	private ResultSet rs = null;
	private Statement sql;
	private JLabel LBLErrorLogin = null;
	private JLabel LBLNBI = null;
	private JLabel LBLLogo = null;
	UseProgram u = new UseProgram();
	private JLabel LBLWarning = null;
	/**
	 * This is the default constructor
	 */
	public NBILogin() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(642, 442);
		this.setContentPane(getJContentPane());
		this.setTitle("NBI Login");
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			LBLWarning = new JLabel();
			LBLWarning.setBounds(new java.awt.Rectangle(370,116,254,27));
			LBLWarning.setForeground(java.awt.Color.yellow);
			LBLWarning.setText("UNAUTHORISED ENTRY IS FORBIDDEN!!");
			LBLWarning.setFont(new Font("Perpetua", Font.BOLD, 14));
			LBLLogo = new JLabel();
			LBLLogo.setBounds(new java.awt.Rectangle(23,22,323,337));
			LBLLogo.setIcon(new ImageIcon(getClass().getResource("/NBI-Seal-Plaque.JPG")));
			LBLLogo.setText("JLabel");
			LBLNBI = new JLabel();
			LBLNBI.setBounds(new java.awt.Rectangle(370,20,253,84));
			LBLNBI.setForeground(java.awt.Color.white);
			LBLNBI.setText("NATIONAL  BUREAU OF  INVESTIGATION");
			LBLNBI.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 14));
			LBLErrorLogin = new JLabel();
			LBLErrorLogin.setBounds(new java.awt.Rectangle(411,308,189,32));
			LBLErrorLogin.setText("Your Login is incorrect!");
			LBLErrorLogin.setFont(new java.awt.Font("DialogInput", java.awt.Font.BOLD, 12));
			LBLErrorLogin.setForeground(java.awt.Color.red);
			LBLErrorLogin.setVisible(false);
			LBLLogin = new JLabel();
			LBLLogin.setBounds(new java.awt.Rectangle(386,163,82,35));
			LBLLogin.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 12));
			LBLLogin.setForeground(java.awt.Color.white);
			LBLLogin.setText("Login: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(getLogin(), null);
			jContentPane.add(getJPasswordField(), null);
			jContentPane.add(LBLLogin, null);
			jContentPane.add(getJLabel(), null);
			jContentPane.add(getBTNLogin(), null);
			jContentPane.add(LBLErrorLogin, null);
			jContentPane.add(LBLNBI, null);
			jContentPane.add(LBLLogo, null);
			jContentPane.add(LBLWarning, null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes Login	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLogin() {
		if (TXTLogin == null) {
			TXTLogin = new JTextField();
			TXTLogin.setLocation(new java.awt.Point(467,163));
			TXTLogin.setSize(new java.awt.Dimension(140,35));
			
		}
		return TXTLogin;
	}
	
	/**
	 * This method initializes jPasswordField	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField() {
		if (PSWPassword == null) {
			PSWPassword = new JPasswordField();
			PSWPassword.setEchoChar('*');
			PSWPassword.setSize(new java.awt.Dimension(140,32));
			PSWPassword.setLocation(new java.awt.Point(467,210));
		}
		return PSWPassword;
	}
	
	/**
	 * This method initializes jLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabel() {
		if (LBLPassword == null) {
			LBLPassword = new JLabel();
			LBLPassword.setText("Password: ");
			LBLPassword.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 12));
			LBLPassword.setForeground(java.awt.Color.white);
			LBLPassword.setBounds(new java.awt.Rectangle(386,212,83,31));
		}
		return LBLPassword;
	}
	
	/**
	 * This method initializes BTNLogin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNLogin() {
		
		if (BTNLogin == null) {
			BTNLogin = new JButton();
			BTNLogin.setBounds(new java.awt.Rectangle(468,260,140,31));
			BTNLogin.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 12));
			BTNLogin.setForeground(java.awt.Color.green);
			BTNLogin.setSelected(true);
			BTNLogin.setText("Login");
			BTNLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Login = TXTLogin.getText();
					Password = PSWPassword.getText();
					int size = 0;
					try {
						sql = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						rs = sql.executeQuery("SELECT * FROM Login");
						while (rs.next())
						{
							DBLogin [size] = rs.getString(1);
							DBPassword [size]= rs.getString(2);
							DBAdmin [size]=rs.getBoolean(3);
							size ++;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i =0; i<Password.length();i++)
					{
						convert = ((int)Password.charAt(i)) + 2;
						SecretPassword = SecretPassword + ((char)convert);
					}					
					int x = 0;			
					
					
					boolean found=false;
					
					while (x<size)
					{ 	
						if (Login.equalsIgnoreCase(DBLogin[x]) && SecretPassword.equalsIgnoreCase(DBPassword[x]))
						{
							c.setAdmin(DBAdmin[x]);
							c.setUser(DBLogin[x]);
							MainMenu m = new MainMenu();
							m.setVisible (true);
							dispose();
							found = true;
							
							
						}
						x++;
					}
					
					if (!(found))
					{
						LBLErrorLogin.setVisible(true);
						SecretPassword="";
					}	
					
				}
				
			});
			
		}
		return BTNLogin;
		
	} } 


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.*;

public class MainMenu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5517562051350379002L;
	private JPanel jContentPane = null;
	private JLabel LBLNBI = null;
	private JButton BTNBack = null;
	private JLabel JBLLogo = null;
	private JLabel LBLTopSecret = null;
	private JLabel LBLSelectionText = null;
	private JLabel LBLView = null;
	private JButton BTNFugitive = null;
	private JButton BTNTerrorists = null;
	private JButton BTNCriminals = null;
	private JButton BTNSearch = null;
	private JLabel LBLOptions = null;
	private JButton BTNRankings = null;
	private JButton BTNCapture = null;
	private JButton BTNAdd = null;
	private JButton BTNHelp = null;
	Methods m = new Methods();
	int msg;
	private JButton BTNSwitch = null;
	private JButton BTNMsg = null;
	
	/**
	 * This is the default constructor
	 * @throws SQLException 
	 */
	public MainMenu()  {
		super();
		initialize();
		
		Statement sql;
		ResultSet rs;
		msg=0;
		try {
			sql = m.con().createStatement();
			rs = sql.executeQuery("SELECT * FROM Messages WHERE Receiver ='"+Methods.user+"'");
			while (rs.next()){
				if (!(rs.getBoolean(5)))
					msg++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BTNMsg.setText("Messages ("+msg+")");
		BTNAdd.setEnabled(Methods.admin);
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(642, 446);
		this.setContentPane(getJContentPane());
		this.setTitle("Main Menu");
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			LBLOptions = new JLabel();
			LBLOptions.setBounds(new java.awt.Rectangle(394,205,105,36));
			LBLOptions.setForeground(Color.white);
			LBLOptions.setText("OTHER OPTIONS:");
			LBLOptions.setFont(new Font("Perpetua", Font.BOLD, 12));
			LBLView = new JLabel();
			LBLView.setBounds(new java.awt.Rectangle(180,207,68,37));
			LBLView.setForeground(java.awt.Color.white);
			LBLView.setText("VIEW ALL:");
			LBLView.setFont(new Font("Perpetua", Font.BOLD, 12));
			LBLSelectionText = new JLabel();
			LBLSelectionText.setBounds(new java.awt.Rectangle(202,155,226,28));
			LBLSelectionText.setForeground(java.awt.Color.white);
			LBLSelectionText.setText("Please select what you would like to do:");
			LBLSelectionText.setFont(new Font("Perpetua", Font.BOLD, 12));
			LBLTopSecret = new JLabel();
			LBLTopSecret.setBounds(new java.awt.Rectangle(234,96,171,41));
			LBLTopSecret.setForeground(java.awt.Color.red);
			LBLTopSecret.setText("All information is Confidential!");
			LBLTopSecret.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 12));
			JBLLogo = new JLabel();
			JBLLogo.setBounds(new java.awt.Rectangle(9,15,129,130));
			JBLLogo.setIcon(new ImageIcon(getClass().getResource("/SmallLogo.jpg")));
			JBLLogo.setText("JLabel");
			LBLNBI = new JLabel();
			LBLNBI.setBounds(new java.awt.Rectangle(176,36,310,57));
			LBLNBI.setForeground(java.awt.Color.white);
			LBLNBI.setText("NATIONAL BUREAU OF INVESTIGATION");
			LBLNBI.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(LBLNBI, null);
			jContentPane.add(getBTNBack(), null);
			jContentPane.add(JBLLogo, null);
			jContentPane.add(LBLTopSecret, null);
			jContentPane.add(LBLSelectionText, null);
			jContentPane.add(LBLView, null);
			jContentPane.add(getBTNFugitive(), null);
			jContentPane.add(getBTNTerrorists(), null);
			jContentPane.add(getBTNCriminals(), null);
			jContentPane.add(getBTNSearch(), null);
			jContentPane.add(LBLOptions, null);
			jContentPane.add(getBTNRankings(), null);
			jContentPane.add(getBTNCapture(), null);
			jContentPane.add(getBTNAdd(), null);
			jContentPane.add(getBTNHelp(), null);
			jContentPane.add(getBTNSwitch(), null);
			jContentPane.add(getBTNMsg(), null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes BTNBack	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNBack() {
		if (BTNBack == null) {
			BTNBack = new JButton();
			BTNBack.setFont(new java.awt.Font("DialogInput", java.awt.Font.BOLD, 12));
			BTNBack.setForeground(java.awt.Color.red);
			BTNBack.setLocation(new java.awt.Point(501,168));
			BTNBack.setSize(new java.awt.Dimension(119,28));
			BTNBack.setText("Log Out");
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return BTNBack;
	}
	
	/**
	 * This method initializes BTNFugitive	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNFugitive() {
		if (BTNFugitive == null) {
			BTNFugitive = new JButton();
			BTNFugitive.setText("Fugitives");
			BTNFugitive.setSize(new java.awt.Dimension(150,35));
			BTNFugitive.setLocation(new java.awt.Point(140,263));
			BTNFugitive.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AllPeople c = new AllPeople ("Fugitive","SELECT * FROM Info WHERE type = 'Fugitive'");
					//Fugitives c = new Fugitives();
					c.setVisible(true);
					dispose();
				}
			});
		}
		return BTNFugitive;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNTerrorists() {
		if (BTNTerrorists == null) {
			BTNTerrorists = new JButton();
			BTNTerrorists.setText("Terrorists");
			BTNTerrorists.setSize(new java.awt.Dimension(150,35));
			BTNTerrorists.setLocation(new java.awt.Point(140,297));
			BTNTerrorists.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AllPeople c = new AllPeople ("Terrorist","SELECT * FROM Info WHERE type = 'Terrorist'");
					//Terrorists c = new Terrorists();
					c.setVisible(true);
					dispose();
				}
			});
		}
		return BTNTerrorists;
	}
	
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNCriminals() {
		if (BTNCriminals == null) {
			BTNCriminals = new JButton();
			BTNCriminals.setText("Criminals");
			BTNCriminals.setSize(new java.awt.Dimension(150,35));
			BTNCriminals.setLocation(new java.awt.Point(140,331));
			BTNCriminals.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AllPeople c = new AllPeople ("Criminal","SELECT * FROM Info WHERE type = 'Criminal'");
					//Criminals c = new Criminals();
					c.setVisible(true);
					dispose();
				}
			});
		}
		return BTNCriminals;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNSearch() {
		if (BTNSearch == null) {
			BTNSearch = new JButton();
			BTNSearch.setText("Search");
			BTNSearch.setSize(new java.awt.Dimension(150,35));
			BTNSearch.setLocation(new java.awt.Point(373,263));
			BTNSearch.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Search c = new Search();
					c.setVisible(true);
					dispose();
				}
			});
		}
		return BTNSearch;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNRankings() {
		if (BTNRankings == null) {
			BTNRankings = new JButton();
			BTNRankings.setText("Rankings");
			BTNRankings.setLocation(new java.awt.Point(373,297));
			BTNRankings.setSize(new java.awt.Dimension(150,35));
			BTNRankings.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Rankings c = new Rankings();
					c.setVisible(true);
					dispose();}
			});
		}
		return BTNRankings;
	}
	
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNCapture() {
		if (BTNCapture == null) {
			BTNCapture = new JButton();
			BTNCapture.setText("State of Capture");
			BTNCapture.setSize(new java.awt.Dimension(150,35));
			BTNCapture.setLocation(new java.awt.Point(373,331));
			BTNCapture.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Status c = new Status();
					c.setVisible(true);
					dispose();}
			});
		}
		return BTNCapture;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNAdd() {
		if (BTNAdd == null) {
			BTNAdd = new JButton();
			BTNAdd.setText("Manage Users");
			BTNAdd.setEnabled(false);
			BTNAdd.setLocation(new java.awt.Point(501,113));
			BTNAdd.setSize(new java.awt.Dimension(119,28));
			BTNAdd.setForeground(java.awt.Color.green);
			BTNAdd.setFont(new java.awt.Font("DialogInput", java.awt.Font.BOLD, 12));
			BTNAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Users u = new Users();
					u.setVisible(true);
				}
			});
		}
		return BTNAdd;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNHelp() {
		if (BTNHelp == null) {
			BTNHelp = new JButton();
			BTNHelp.setForeground(java.awt.Color.cyan);
			BTNHelp.setText("User Manual");
			BTNHelp.setLocation(new java.awt.Point(501,65));
			BTNHelp.setSize(new java.awt.Dimension(119,28));
			BTNHelp.setFont(new java.awt.Font("DialogInput", java.awt.Font.BOLD, 12));
			BTNHelp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Runtime.getRuntime().exec("cmd /c \"UserManual.doc");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "User Manual not found!");
					} 
				}
			});
		}
		return BTNHelp;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNSwitch() {
		if (BTNSwitch == null) {
			BTNSwitch = new JButton();
			BTNSwitch.setForeground(java.awt.Color.magenta);
			BTNSwitch.setText("Switch User");
			BTNSwitch.setLocation(new java.awt.Point(501,141));
			BTNSwitch.setSize(new java.awt.Dimension(119,28));
			BTNSwitch.setFont(new Font("DialogInput", Font.BOLD, 12));
			BTNSwitch.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					NBILogin l = new NBILogin();
					l.setVisible(true);
					dispose();
				}
			});
		}
		return BTNSwitch;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNMsg() {
		if (BTNMsg == null) {
			BTNMsg = new JButton();
			BTNMsg.setForeground(java.awt.Color.blue);
			BTNMsg.setLocation(new java.awt.Point(501,37));
			BTNMsg.setSize(new java.awt.Dimension(119,28));
			BTNMsg.setFont(new Font("DialogInput", Font.BOLD, 12));
			BTNMsg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Messaging msg = new Messaging(Methods.user);
					msg.setVisible(true);
					dispose();
				}
			});
		}
		return BTNMsg;
	}
	
	/**
	 * This method initializes BTNLogin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

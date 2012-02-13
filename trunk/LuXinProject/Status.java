import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Status extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6618022626400232211L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JList jList = null;
	Methods c=new Methods();
	private ResultSet rs = null;
	private Statement sql;
	private DefaultListModel listModel;
	private JLabel LBLLogo = null;
	private JLabel LBLHeading = null;
	private JLabel LBLWarning = null;
	private JLabel LBLType = null;
	private JButton BTNBack = null;
	private JButton BTNLogout = null;
	private JButton BTNView = null;
	private int option= 0 ;
	String [] name = new String[20];
	private int size = 0;
	private JButton BTNCaught = null;
	private JButton BTNNotCaught = null;
	
	
	public Status() {
		super();
		initialize();
		display();
		
		
	}
	
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(27,163,484,243));
			jScrollPane.setViewportView(getJList());
			jScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
				
			});
		}
		return jScrollPane;
	}
	
	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		
		listModel = new DefaultListModel();
		jList = new JList();
		jList = new JList(listModel);
		jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jList.setFont(new java.awt.Font("Courier New", java.awt.Font.BOLD | java.awt.Font.ITALIC, 18));
		jList.setEnabled(true);
		jList.setBackground(java.awt.Color.black);
		jList.setForeground(java.awt.Color.white);
		jList.setVisibleRowCount(20);	  
		jList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent e) {
				option = jList.getSelectedIndex();
			}
		});
		JScrollPane scrollPane = new JScrollPane(jList);
		scrollPane.setPreferredSize(new Dimension(250, 80));
		getContentPane().add(scrollPane, BorderLayout.CENTER);   
		
		
		return jList;
	}
	
	private void display(){
		listModel.clear();
		
		try {
			sql = c.con().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = sql.executeQuery("SELECT * FROM Info ORDER BY Caught");
			
			String headings = spacing("Name")+"Caught (Y/N)";
			listModel.addElement(headings);
			listModel.addElement("");
			
			while (rs.next())
			{		
				name [size]= rs.getString(1);
				
				String caught = rs.getString(13);
				
				String line = spacing(name[size])+caught;
				size++;
				
				listModel.addElement(line);
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			this.setTitle("RANKING OF MOST WANTED");
			LBLType.setText("MOST WANTED CRIMINALS:");
			
			
	}
	private String spacing(String x){
		for (int i = x.length(); i<30;i++ )
			x = x + " ";
		return x;
	}
	
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNBack() {
		if (BTNBack == null) {
			BTNBack = new JButton();
			BTNBack.setText("Back");
			BTNBack.setLocation(new java.awt.Point(543,60));
			BTNBack.setSize(new java.awt.Dimension(95,27));
			BTNBack.setFont(new Font("DialogInput", Font.BOLD, 12));
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MainMenu m = new MainMenu();
					m.setVisible(true);
					dispose();
				}
			});
		}
		return BTNBack;
	}
	
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNLogout() {
		if (BTNLogout == null) {
			BTNLogout = new JButton();
			BTNLogout.setForeground(Color.red);
			BTNLogout.setText("Log Out");
			BTNLogout.setPreferredSize(new java.awt.Dimension(95,27));
			BTNLogout.setLocation(new java.awt.Point(542,90));
			BTNLogout.setSize(new java.awt.Dimension(95,27));
			BTNLogout.setFont(new Font("DialogInput", Font.BOLD, 12));
			BTNLogout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNLogout;
	}
	
	/**
	 * This method initializes BTNView	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNView(){
		if (BTNView == null) {
			BTNView = new JButton();
			BTNView.setBounds(new java.awt.Rectangle(238,421,129,32));
			BTNView.setText("View Details");
			BTNView.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (option!=0){
						PersonalDetails vd = new PersonalDetails(name[option-2]);
						vd.setVisible(true);
						dispose();
					}
				}
			});
		}
		return BTNView;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNCaught() {
		if (BTNCaught == null) {
			BTNCaught = new JButton();
			BTNCaught.setText("Set to Caught");
			BTNCaught.setLocation(new java.awt.Point(527,216));
			BTNCaught.setSize(new java.awt.Dimension(157,40));
			BTNCaught.setForeground(java.awt.Color.green);
			BTNCaught.setFont(new Font("DialogInput", Font.BOLD, 12));
			BTNCaught.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option = jList.getSelectedIndex();
					if (option!=0){
						try {
							c.updateTable("UPDATE Info SET Caught ='Y' WHERE Name = '"+name[option-2]+"'");
							JOptionPane.showMessageDialog(null, "STATUS UPDATED");
							display();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return BTNCaught;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNNotCaught() {
		if (BTNNotCaught == null) {
			BTNNotCaught = new JButton();
			BTNNotCaught.setText("Set to NOT Caught");
			BTNNotCaught.setLocation(new java.awt.Point(527,278));
			BTNNotCaught.setSize(new java.awt.Dimension(156,40));
			BTNNotCaught.setForeground(java.awt.Color.magenta);
			BTNNotCaught.setFont(new Font("DialogInput", Font.BOLD, 12));
			BTNNotCaught.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option = jList.getSelectedIndex();
					if (option!=0){
						try {
							c.updateTable("UPDATE Info SET Caught ='N' WHERE Name = '"+name[option-2]+"'");
							JOptionPane.showMessageDialog(null, "STATUS UPDATED");
							display();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}}
			});
		}
		return BTNNotCaught;
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
	
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(705, 500);
		this.setBackground(java.awt.Color.black);
		this.setContentPane(getJContentPane());
		
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			LBLType = new JLabel();
			LBLType.setBounds(new java.awt.Rectangle(246,111,203,34));
			LBLType.setForeground(Color.white);
			
			LBLType.setFont(new Font("Perpetua", Font.BOLD, 12));
			LBLWarning = new JLabel();
			LBLWarning.setBounds(new java.awt.Rectangle(242,83,183,22));
			LBLWarning.setForeground(Color.red);
			LBLWarning.setText("All information is Confidential!");
			LBLWarning.setFont(new Font("Perpetua", Font.BOLD, 12));
			LBLHeading = new JLabel();
			LBLHeading.setBounds(new java.awt.Rectangle(209,23,306,48));
			LBLHeading.setForeground(Color.white);
			LBLHeading.setText("NATIONAL BUREAU OF INVESTIGATION");
			LBLHeading.setFont(new Font("Perpetua", Font.BOLD, 16));
			LBLLogo = new JLabel();
			LBLLogo.setBounds(new java.awt.Rectangle(25,9,133,130));
			LBLLogo.setText("");
			LBLLogo.setIcon(new ImageIcon(getClass().getResource("/SmallLogo.jpg")));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(getJScrollPane(), null);
			//jContentPane.add(getJTable(), null);
			jContentPane.add(LBLLogo, null);
			jContentPane.add(LBLHeading, null);
			jContentPane.add(LBLWarning, null);
			jContentPane.add(LBLType, null);
			jContentPane.add(getBTNBack(), null);
			jContentPane.add(getBTNLogout(), null);
			jContentPane.add(getBTNView(), null);
			jContentPane.add(getBTNCaught(), null);
			jContentPane.add(getBTNNotCaught(), null);
		}
		return jContentPane;
	}
	
}  //  @jve:decl-index=0:visual-constraint="59,26"

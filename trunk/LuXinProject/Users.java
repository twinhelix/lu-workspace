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

public class Users extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5881210928000683616L;
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
	private int option= 0 ;
	public	String [] name = new String[20];
	public 	String [] pass = new String[20];
	public int size = 0;
	private JButton BTNAdd = null;
	private JButton BTNDelete = null;
	private JButton BTNAdmin = null;
	private JButton BTNDeAdmin = null;
	public Users() {
		super();
		initialize();
		display();
		
	}
	
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(24,152,453,205));
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
		jList = new JList(listModel);
		jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jList.setFont(new java.awt.Font("Courier New", java.awt.Font.BOLD | java.awt.Font.ITALIC, 18));
		jList.setEnabled(true);
		jList.setBackground(java.awt.Color.black);
		jList.setForeground(java.awt.Color.white);
		jList.setVisibleRowCount(20);	  
		JScrollPane scrollPane = new JScrollPane(jList);
		scrollPane.setPreferredSize(new Dimension(250, 80));
		getContentPane().add(scrollPane, BorderLayout.CENTER);   
		
		
		return jList;
	}
	
	private void display(){
		listModel.clear();
		size = 0;
		try {
			sql = c.con().createStatement();
			rs = sql.executeQuery("SELECT * FROM Login");
			
			String headings = spacing("Username",18)+spacing("Password",12)+"Admin";
			listModel.addElement(headings);
			listModel.addElement("");
			char convert;
			String SecretPassword;
			boolean admin;
			String auth="";
			while (rs.next())
			{		
				name [size]= rs.getString(1);
				pass [size]= rs.getString(2);
				admin = rs.getBoolean(3);
				
				if (admin)
					auth="Admin";
				else
					auth="User";
				SecretPassword="";
				for (int i =0; i<pass [size].length();i++)
				{
					convert = (char) ((pass [size].charAt(i)) - 2);
					SecretPassword = SecretPassword + (convert);
				}	
				String line = spacing(name[size],18)+spacing(SecretPassword,12)+auth;
				size++;
				listModel.addElement(line);  
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			this.setTitle("Users");
			LBLType.setText("ALL users :");
			
			
	}
	
	private String spacing(String x,int len){
		for (int i = x.length(); i<len;i++ )
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
			BTNBack.setLocation(new java.awt.Point(489,25));
			BTNBack.setSize(new java.awt.Dimension(95,27));
			BTNBack.setFont(new Font("DialogInput", Font.BOLD, 12));
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					dispose();
				}
			});
		}
		return BTNBack;
	}
	
	/**
	 * This method initializes BTNAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNAdd() {
		if (BTNAdd == null) {
			BTNAdd = new JButton();
			BTNAdd.setForeground(java.awt.Color.green);
			BTNAdd.setLocation(new java.awt.Point(484,185));
			BTNAdd.setSize(new java.awt.Dimension(112,32));
			BTNAdd.setText("Add User");
			BTNAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AddUser ad = new AddUser();
					ad.setVisible(true);
					dispose();
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNAdd;
	}
	/**
	 * This method initializes BTNDelete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNDelete() {
		if (BTNDelete == null) {
			BTNDelete = new JButton();
			BTNDelete.setForeground(java.awt.Color.red);
			BTNDelete.setLocation(new java.awt.Point(484,215));
			BTNDelete.setSize(new java.awt.Dimension(112,32));
			BTNDelete.setText("Delete User");
			BTNDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option = jList.getSelectedIndex();
					
					if(option!=0){
						
						Methods m = new Methods();
						try {
							m.updateTable("DELETE * FROM Login WHERE Username ='"+name[option-2]+"' ");
							
							JOptionPane.showMessageDialog(null, "Login has been deleted!");
							
							display();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				}
			});
		}
		return BTNDelete;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNAdmin() {
		if (BTNAdmin == null) {
			BTNAdmin = new JButton();
			BTNAdmin.setText("Make Admin");
			BTNAdmin.setLocation(new java.awt.Point(484,245));
			BTNAdmin.setSize(new java.awt.Dimension(112,32));
			BTNAdmin.setForeground(java.awt.Color.orange);
			BTNAdmin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option = jList.getSelectedIndex();
					if(option!=0){
						
						Methods m = new Methods();
						try {
							m.updateTable("UPDATE Login SET Admin='1' WHERE Username ='"+name[option-2]+"' ");
							
							JOptionPane.showMessageDialog(null, "Made " +name[option-2] +" an admin!");
							
							display();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			});
		}
		return BTNAdmin;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNDeAdmin() {
		if (BTNDeAdmin == null) {
			BTNDeAdmin = new JButton();
			BTNDeAdmin.setText("De-Admin");
			BTNDeAdmin.setLocation(new java.awt.Point(484,275));
			BTNDeAdmin.setSize(new java.awt.Dimension(112,32));
			BTNDeAdmin.setForeground(java.awt.Color.orange);
			BTNDeAdmin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option = jList.getSelectedIndex();
					if(option!=0){
						
						Methods m = new Methods();
						try {
							m.updateTable("UPDATE Login SET Admin='0' WHERE Username ='"+name[option-2]+"' ");
							
							JOptionPane.showMessageDialog(null, "Made " +name[option-2] +" an user!");
							
							display();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			});
		}
		return BTNDeAdmin;
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
		this.setSize(607, 434);
		this.setTitle("Users");
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
			LBLType.setBounds(new java.awt.Rectangle(261,104,56,34));
			LBLType.setForeground(Color.white);
			LBLType.setText("All Users:");
			
			LBLType.setFont(new Font("Perpetua", Font.BOLD, 12));
			LBLWarning = new JLabel();
			LBLWarning.setBounds(new java.awt.Rectangle(204,73,183,22));
			LBLWarning.setForeground(Color.red);
			LBLWarning.setText("All information is Confidential!");
			LBLWarning.setFont(new Font("Perpetua", Font.BOLD, 12));
			LBLHeading = new JLabel();
			LBLHeading.setBounds(new java.awt.Rectangle(170,16,306,48));
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
			jContentPane.add(getBTNAdd(), null);
			jContentPane.add(getBTNDelete(), null);
			jContentPane.add(getBTNAdmin(), null);
			jContentPane.add(getBTNDeAdmin(), null);
		}
		return jContentPane;
	}
	
}  //  @jve:decl-index=0:visual-constraint="0,1"

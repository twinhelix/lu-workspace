import java.sql.*;
import javax.swing.*;
import javax.swing.JComboBox;

public class AddUser extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -677374276430640345L;
	private JPanel jContentPane = null;
	private JButton BTNAdd = null;
	private JButton BTNCancel = null;
	private JLabel LBLNewUser = null;
	private JLabel LBLPass = null; 
	private JLabel LBLConfirm = null;
	private JTextField TXTNewLogin = null;
	private JPasswordField PSWNewPass = null;
	private JPasswordField PSWConfirm = null;
	Methods c = new Methods();
	Users u = new Users();  //  @jve:decl-index=0:visual-constraint="368,10"
	private JLabel LBLError = null;
	private JComboBox CBXAdmin = null;
	
	
	public AddUser() {
		super();
		initialize();
		CBXAdmin.addItem("Normal User");
		CBXAdmin.addItem("Admin");
		
	}
	
	
	private void initialize() {
		u.setSize(new java.awt.Dimension(46,31));
		this.setSize(348, 311);
		this.setContentPane(getJContentPane());
		this.setTitle("Add User");
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			LBLError = new JLabel();
			LBLError.setBounds(new java.awt.Rectangle(16,199,301,29));
			LBLError.setForeground(java.awt.Color.red);
			LBLError.setText("Sorry your passwords do not match, please re enter!");
			LBLError.setVisible(false);
			LBLConfirm = new JLabel();
			LBLConfirm.setText("Confirm Password:");
			LBLConfirm.setSize(new java.awt.Dimension(114,27));
			LBLConfirm.setForeground(java.awt.Color.white);
			LBLConfirm.setLocation(new java.awt.Point(21,122));
			LBLPass = new JLabel();
			LBLPass.setText("Password:");
			LBLPass.setSize(new java.awt.Dimension(113,27));
			LBLPass.setForeground(java.awt.Color.white);
			LBLPass.setLocation(new java.awt.Point(21,77));
			LBLNewUser = new JLabel();
			LBLNewUser.setBounds(new java.awt.Rectangle(23,33,111,27));
			LBLNewUser.setForeground(java.awt.Color.white);
			LBLNewUser.setText("New user name:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(getBTNAdd(), null);
			jContentPane.add(getBTNCancel(), null);
			jContentPane.add(LBLNewUser, null);
			jContentPane.add(LBLPass, null);
			jContentPane.add(LBLConfirm, null);
			jContentPane.add(getTXTNewLogin(), null);
			jContentPane.add(getPSWNewPass(), null);
			jContentPane.add(getPSWConfirm(), null);
			jContentPane.add(LBLError, null);
			jContentPane.add(getCBXAdmin(), null);
		}
		return jContentPane;
	}
	private JButton getBTNAdd() {
		if (BTNAdd == null) {
			BTNAdd = new JButton();
			BTNAdd.setBounds(new java.awt.Rectangle(18,232,93,29));
			BTNAdd.setForeground(java.awt.Color.green);
			BTNAdd.setText("Add!");
			BTNAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String Name = TXTNewLogin.getText();
					String Pass1 = PSWNewPass.getText();
					String Pass2 = PSWConfirm.getText();
					String UpdatePass="";
					int admin = CBXAdmin.getSelectedIndex();
					boolean duplicate=false;
					if (Pass1.equalsIgnoreCase(Pass2))
					{	for (int j = 0;j<u.size;j++)
					{
						if (Name.equalsIgnoreCase(u.name[j]))
							duplicate = true;
					}
					if (duplicate)
						JOptionPane.showMessageDialog(null, "Login already exist");
					else{
						for (int i = 0; i< Pass1.length();i++)
						{
							UpdatePass = UpdatePass + (char)(Pass1.charAt(i)+2);
							
						}
						try {
							c.updateTable("INSERT INTO Login  VALUES('"+Name+"', '"+UpdatePass+"','"+admin+"')");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "New Login has been added!");
						Users u = new Users();
						u.setVisible(true);
						dispose();
					}
					
					}
					else
					{
						LBLError.setVisible(true);
					}
					
				}
			});
		}
		return BTNAdd;
	}
	
	
	private JButton getBTNCancel() {
		if (BTNCancel == null) {
			BTNCancel = new JButton();
			BTNCancel.setLocation(new java.awt.Point(213,233));
			BTNCancel.setText("Cancel");
			BTNCancel.setSize(new java.awt.Dimension(93,29));
			BTNCancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return BTNCancel;
	}
	
	/**
	 * This method initializes TXTNewLogin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTXTNewLogin() {
		if (TXTNewLogin == null) {
			TXTNewLogin = new JTextField();
			TXTNewLogin.setLocation(new java.awt.Point(189,35));
			TXTNewLogin.setSize(new java.awt.Dimension(120,27));
		}
		return TXTNewLogin;
	}
	
	
	private JPasswordField getPSWNewPass() {
		if (PSWNewPass == null) {
			PSWNewPass = new JPasswordField();
			PSWNewPass.setLocation(new java.awt.Point(189,77));
			PSWNewPass.setSize(new java.awt.Dimension(120,27));
		}
		return PSWNewPass;
	}
	
	
	private JPasswordField getPSWConfirm() {
		if (PSWConfirm == null) {
			PSWConfirm = new JPasswordField();
			PSWConfirm.setLocation(new java.awt.Point(189,121));
			PSWConfirm.setSize(new java.awt.Dimension(120,27));
		}
		return PSWConfirm;
	}
	
	
	/**
	 * This method initializes CBXAdmin	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCBXAdmin() {
		if (CBXAdmin == null) {
			CBXAdmin = new JComboBox();
			CBXAdmin.setBounds(new java.awt.Rectangle(20,160,291,28));
		}
		return CBXAdmin;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

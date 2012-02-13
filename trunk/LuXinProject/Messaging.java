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
import javax.swing.JComboBox;

public class Messaging extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4018408276239313314L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JList LSTMsg = null;
	Methods c=new Methods();
	private ResultSet rs = null;
	private Statement sql;
	private DefaultListModel listModel;
	private JLabel LBLLogo = null;
	private JLabel LBLHeading = null;
	private JButton BTNBack = null;
	private JButton BTNLogout = null;
	private int option= 0 ;
	private int choice=0;
	public	String [] Title = new String[20];
	public	String [] MsgID = new String[20];
	public int size = 0;
	String user="";
	String urgent="";
	private JButton BTNNewMsg = null;
	private JButton BTNDeleteMsg = null;
	private JButton BTNRead = null;
	private JButton BTNMark = null;
	private JComboBox CBXMessages = null;
	private JLabel LBLMSG = null;
	public Messaging(String Login) {
		super();
		initialize();
		user=Login;
		CBXMessages.addItem(" Inbox ");
		CBXMessages.addItem(" Sent Messages ");
		displayInbox(user);
		
	}
	
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(22,174,678,228));
			jScrollPane.setViewportView(getLSTMsg());
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
	private JList getLSTMsg() {
		
		listModel = new DefaultListModel();
		LSTMsg = new JList(listModel);
		LSTMsg.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		LSTMsg.setFont(new java.awt.Font("Courier New", java.awt.Font.BOLD | java.awt.Font.ITALIC, 18));
		LSTMsg.setEnabled(true);
		LSTMsg.setBackground(java.awt.Color.black);
		LSTMsg.setForeground(java.awt.Color.white);
		LSTMsg.setVisibleRowCount(20);	  
		JScrollPane scrollPane = new JScrollPane(LSTMsg);
		scrollPane.setPreferredSize(new Dimension(250, 80));
		getContentPane().add(scrollPane, BorderLayout.CENTER);   
		
		
		return LSTMsg;
	}
	
	private void displayInbox(String user){
		listModel.clear();
		size = 0;
		BTNRead.setLocation(100,426);
		BTNMark.setVisible(true);
		BTNDeleteMsg.setVisible(true);
		try {
			sql = c.con().createStatement();
			rs = sql.executeQuery("SELECT * FROM Messages WHERE Receiver ='"+user+"' ORDER BY READ DESC");
			
			String headings = spacing("Title",30)+spacing("Sender",12)+spacing("Read?",10)+"Urgency";
			listModel.addElement(headings);
			listModel.addElement("");
			
			String Read;
			while (rs.next())
			{		
				Title [size]= rs.getString(1);
				String Sender= rs.getString(3);
				MsgID[size]=rs.getString(6);
				if (!(rs.getBoolean(5)))
					Read = "Un-Read";
				else
					Read = "Read";
				int urg = rs.getInt(7);
				if (urg==0)
					urgent="Normal";
				if (urg==1)
					urgent="Moderate";
				if (urg==2)
					urgent="High";
				String line = spacing(Title[size],30)+spacing(Sender,12)+spacing(Read,10)+urgent;
				size++;
				listModel.addElement(line);  
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			this.setTitle("Inbox of user: "+ user);
			
	}
	private void displaySent(String user){
		listModel.clear();
		BTNMark.setVisible(false);
		BTNDeleteMsg.setVisible(false);
		BTNRead.setLocation(287,426);
		size = 0;
		try {
			sql = c.con().createStatement();
			rs = sql.executeQuery("SELECT * FROM Messages WHERE Sender ='"+user+"' ORDER BY READ DESC");
			
			String headings = spacing("Title",30)+spacing("Receiver",12)+spacing("Sent?",10)+"Urgency";
			listModel.addElement(headings);
			listModel.addElement("");
			
			String Read;
			while (rs.next())
			{		
				Title [size]= rs.getString(1);
				String Receiver= rs.getString(4);
				MsgID[size]=rs.getString(6);
				if (!(rs.getBoolean(5)))
					Read = "Pending";
				else
					Read = "Sent";
				int urg = rs.getInt(7);
				if (urg==0)
					urgent="Normal";
				if (urg==1)
					urgent="Moderate";
				if (urg==2)
					urgent="High";
				String line = spacing(Title[size],30)+spacing(Receiver,12)+spacing(Read,10)+urgent;
				size++;
				listModel.addElement(line);  
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			this.setTitle("Sent messages of user: "+ user);
			
	}
	
	private String spacing(String x, int num){
		for (int i = x.length(); i<num;i++ )
			x = x + " ";
		return x;
	}
	
	private JButton getBTNBack() {
		if (BTNBack == null) {
			BTNBack = new JButton();
			BTNBack.setText("Back");
			BTNBack.setLocation(new java.awt.Point(600,32));
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
			BTNLogout.setLocation(new java.awt.Point(600,58));
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
	 * This method initializes BTNAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNNewMsg() {
		if (BTNNewMsg == null) {
			BTNNewMsg = new JButton();
			BTNNewMsg.setBounds(new java.awt.Rectangle(559,113,137,31));
			BTNNewMsg.setForeground(java.awt.Color.green);
			BTNNewMsg.setText("Compose");
			BTNNewMsg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					NewMsg nm = new NewMsg(user);
					nm.setVisible(true);
					dispose();
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNNewMsg;
	}
	/**
	 * This method initializes BTNDelete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNDeleteMsg() {
		if (BTNDeleteMsg == null) {
			BTNDeleteMsg = new JButton();
			BTNDeleteMsg.setForeground(java.awt.Color.yellow);
			BTNDeleteMsg.setLocation(new java.awt.Point(458,424));
			BTNDeleteMsg.setSize(new java.awt.Dimension(137,31));
			BTNDeleteMsg.setText("Delete Message");
			BTNDeleteMsg.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option = LSTMsg.getSelectedIndex();
					
					if(option!=0){
						
						try {
							
							c.updateTable("DELETE FROM Messages WHERE Message_ID ='"+MsgID[option-2]+"' ");	
							JOptionPane.showMessageDialog(null, "Message has been deleted!");
							
							displayInbox(user);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				}
			});
		}
		return BTNDeleteMsg;
	}
	/**
	 * This method initializes BTNRead	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNRead() {
		if (BTNRead == null) {
			BTNRead = new JButton();
			BTNRead.setText("Read Message");
			BTNRead.setSize(new java.awt.Dimension(137,31));
			BTNRead.setForeground(java.awt.Color.magenta);
			BTNRead.setLocation(new java.awt.Point(100,426));
			BTNRead.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option=LSTMsg.getSelectedIndex();
					
					ReadMsg rm = new ReadMsg(MsgID[option-2]);
					rm.setVisible(true);
					
					if (choice==1)
					{
						rm.setSent();
					}
					dispose();
				}
			});
		}
		return BTNRead;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNMark() {
		if (BTNMark == null) {
			BTNMark = new JButton();
			BTNMark.setText("Mark as Unread");
			BTNMark.setLocation(new java.awt.Point(287,426));
			BTNMark.setSize(new java.awt.Dimension(137,31));
			BTNMark.setForeground(java.awt.Color.green);
			BTNMark.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option=LSTMsg.getSelectedIndex();
					if (option!=0){
						try {
							c.updateTable("UPDATE Messages SET Read='0' WHERE Message_ID ='"+MsgID[option-2]+"'");
							JOptionPane.showMessageDialog(null, "Message has been marked as unread!");
							
							displayInbox(user);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return BTNMark;
	}
	/**
	 * This method initializes CBXMessages	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCBXMessages() {
		if (CBXMessages == null) {
			CBXMessages = new JComboBox();
			CBXMessages.setLocation(new java.awt.Point(285,114));
			CBXMessages.setSize(new java.awt.Dimension(137,31));
			CBXMessages.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choice = CBXMessages.getSelectedIndex();
					if (choice==0)
						displayInbox(user);
					if (choice==1){
						displaySent(user);
					}
				}
			});
		}
		return CBXMessages;
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
		this.setSize(737, 534);
		this.setTitle("");
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
			
			
			LBLMSG = new JLabel();
			LBLMSG.setBounds(new java.awt.Rectangle(295,73,104,30));
			LBLMSG.setForeground(java.awt.Color.orange);
			LBLMSG.setText("Messages from :");
			LBLHeading = new JLabel();
			LBLHeading.setBounds(new java.awt.Rectangle(202,16,306,48));
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
			jContentPane.add(LBLLogo, null);
			jContentPane.add(LBLHeading, null);
			jContentPane.add(getBTNBack(), null);
			jContentPane.add(getBTNLogout(), null);
			jContentPane.add(getBTNNewMsg(), null);
			jContentPane.add(getBTNDeleteMsg(), null);
			jContentPane.add(getBTNRead(), null);
			jContentPane.add(getBTNMark(), null);
			jContentPane.add(getCBXMessages(), null);
			jContentPane.add(LBLMSG, null);
		}
		return jContentPane;
	}
	
}  //  @jve:decl-index=0:visual-constraint="0,1"







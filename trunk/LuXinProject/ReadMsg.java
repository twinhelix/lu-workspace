import javax.swing.JPanel;
import javax.swing.JFrame;
import java.sql.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ReadMsg extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7648377448171986617L;
	private JPanel jContentPane = null;
	String MsgID="";
	String Title, Sender, Receiver, Body;
	int urg;
	Methods m = new Methods();
	Statement stmt;
	ResultSet rs;
	private JScrollPane jScrollPane = null;
	private JTextArea TXABody = null;
	private JLabel LBLTitle = null;
	private JButton BTNBack = null;
	private JButton BTNDelete = null;
	private JButton BTNReply = null;
	private JLabel LBLSub = null;
	private JLabel LBLPerson = null;
	private JLabel LBLSendRec = null;
	private JLabel LBLHeading = null;
	private JLabel LBLIcon = null;
	private JButton BTNForward = null;
	private JLabel LBLUrgency = null;
	private JLabel LBLUrg = null;
	private JButton BTNPrint = null;
	/**
	 * This is the default constructor
	 */
	public ReadMsg(String ID) {
		super();
		initialize();
		MsgID=ID;
		display(MsgID);
	}
	
	private void display(String ID) {
		try {
			stmt = m.con().createStatement();
			m.updateTable("UPDATE Messages SET Read='1' WHERE Message_ID ='"+ID+"'");
			rs=stmt.executeQuery("SELECT * FROM Messages WHERE Message_ID='"+ID+"' ");
			while(rs.next()){
				Title=rs.getString(1);
				Body = rs.getString(2);
				Sender = rs.getString(3);
				Receiver = rs.getString(4);
				urg=rs.getInt(7);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setTitle(Title + " Sent from: "+ Sender);
		TXABody.setText(Body);
		LBLTitle.setText(Title);
		LBLSendRec.setText(Sender);
		if(urg==0){
			LBLUrg.setText("Not Urgent");
			LBLUrg.setForeground(java.awt.Color.green);
		}
		if(urg==1){
			LBLUrg.setText("Urgent");
			LBLUrg.setForeground(java.awt.Color.orange);
		}
		if(urg==2){
			LBLUrg.setText("Very Urgent!");
			LBLUrg.setForeground(java.awt.Color.red);
		}
	}
	public void setSent(){
		LBLPerson.setText("To: ");
		LBLSendRec.setText(Receiver);
		BTNReply.setVisible(false);
		BTNDelete.setVisible(false);
		try {
			m.updateTable("UPDATE Messages SET Read='0' WHERE Message_ID ='"+MsgID+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(526, 400);
		this.setContentPane(getJContentPane());
		
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			LBLUrg = new JLabel();
			LBLUrg.setForeground(Color.blue);
			LBLUrg.setSize(new java.awt.Dimension(230,35));
			LBLUrg.setLocation(new java.awt.Point(120,129));
			LBLUrgency = new JLabel();
			LBLUrgency.setText("Urgency:");
			LBLUrgency.setLocation(new java.awt.Point(14,127));
			LBLUrgency.setSize(new java.awt.Dimension(85,35));
			LBLUrgency.setForeground(Color.magenta);
			LBLIcon = new JLabel();
			LBLIcon.setBounds(new java.awt.Rectangle(379,12,135,133));
			LBLIcon.setText("");
			LBLIcon.setIcon(new ImageIcon(getClass().getResource("/SmallLogo.jpg")));
			LBLHeading = new JLabel();
			LBLHeading.setBounds(new java.awt.Rectangle(13,10,364,44));
			LBLHeading.setForeground(java.awt.Color.cyan);
			LBLHeading.setText("NATIONAL BUREAU OF INVESTIGATION MESSAGE SERVICE");
			LBLHeading.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 14));
			LBLSendRec = new JLabel();
			LBLSendRec.setForeground(java.awt.Color.blue);
			LBLSendRec.setSize(new java.awt.Dimension(230,35));
			LBLSendRec.setLocation(new java.awt.Point(120,95));
			LBLPerson = new JLabel();
			LBLPerson.setForeground(java.awt.Color.magenta);
			LBLPerson.setLocation(new java.awt.Point(14,94));
			LBLPerson.setSize(new java.awt.Dimension(85,35));
			LBLPerson.setText("Sender:");
			LBLSub = new JLabel();
			LBLSub.setForeground(java.awt.Color.magenta);
			LBLSub.setLocation(new java.awt.Point(14,61));
			LBLSub.setSize(new java.awt.Dimension(85,35));
			LBLSub.setText("Subject: ");
			LBLTitle = new JLabel();
			LBLTitle.setForeground(java.awt.Color.blue);
			LBLTitle.setSize(new java.awt.Dimension(230,35));
			LBLTitle.setLocation(new java.awt.Point(120,60));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(LBLTitle, null);
			jContentPane.add(getBTNBack(), null);
			jContentPane.add(getBTNDelete(), null);
			jContentPane.add(getBTNReply(), null);
			jContentPane.add(LBLSub, null);
			jContentPane.add(LBLPerson, null);
			jContentPane.add(LBLSendRec, null);
			jContentPane.add(LBLHeading, null);
			jContentPane.add(LBLIcon, null);
			jContentPane.add(getBTNForward(), null);
			jContentPane.add(LBLUrgency, null);
			jContentPane.add(LBLUrg, null);
			jContentPane.add(getBTNPrint(), null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(15,171,350,177));
			jScrollPane.setViewportView(getTXABody());
		}
		return jScrollPane;
	}
	
	/**
	 * This method initializes TXABody	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTXABody() {
		if (TXABody == null) {
			TXABody = new JTextArea();
			TXABody.setLineWrap(true);
			TXABody.setBackground(java.awt.Color.black);
			TXABody.setWrapStyleWord(true);
			TXABody.setEditable(false);
			TXABody.setForeground(java.awt.Color.white);
		}
		return TXABody;
	}
	
	/**
	 * This method initializes BTNBack	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNBack() {
		if (BTNBack == null) {
			BTNBack = new JButton();
			BTNBack.setBounds(new java.awt.Rectangle(404,157,93,31));
			BTNBack.setText("Back");
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Messaging msg = new Messaging (Methods.user);
					msg.setVisible(true);
					dispose();
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNBack;
	}
	
	/**
	 * This method initializes Delete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNDelete() {
		if (BTNDelete == null) {
			BTNDelete = new JButton();
			BTNDelete.setForeground(java.awt.Color.red);
			BTNDelete.setLocation(new java.awt.Point(404,279));
			BTNDelete.setSize(new java.awt.Dimension(93,31));
			BTNDelete.setText("Delete");
			BTNDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						
						m.updateTable("DELETE FROM Messages WHERE Message_ID ='"+MsgID+"' ");	
						JOptionPane.showMessageDialog(null, "Message has been deleted!");
						Messaging msg = new Messaging (Methods.user);
						msg.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
			});
		}
		return BTNDelete;
	}
	
	/**
	 * This method initializes Reply	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNReply() {
		if (BTNReply == null) {
			BTNReply = new JButton();
			BTNReply.setForeground(java.awt.Color.green);
			BTNReply.setLocation(new java.awt.Point(404,249));
			BTNReply.setSize(new java.awt.Dimension(93,31));
			BTNReply.setText("Reply");
			BTNReply.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					NewMsg nm = new NewMsg(Methods.user);
					nm.setVisible(true);
					nm.reply(Body, Title,Sender);
					dispose();
					
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNReply;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNForward() {
		if (BTNForward == null) {
			BTNForward = new JButton();
			BTNForward.setText("Forward");
			BTNForward.setLocation(new java.awt.Point(404,219));
			BTNForward.setSize(new java.awt.Dimension(93,31));
			BTNForward.setForeground(java.awt.Color.blue);
			BTNForward.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					NewMsg nm = new NewMsg(Methods.user);
					nm.setVisible(true);
					nm.forward(Body, Title);
					dispose();
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNForward;
	}
	
	/**
	 * This method initializes BTNPrint	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNPrint() {
		if (BTNPrint == null) {
			BTNPrint = new JButton();
			BTNPrint.setLocation(new java.awt.Point(404,189));
			BTNPrint.setText("Print Msg");
			BTNPrint.setForeground(java.awt.Color.magenta);
			BTNPrint.setSize(new java.awt.Dimension(93,31));
			BTNPrint.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					PrintPreview pp = new PrintPreview( Title, LBLPerson.getText(),LBLSendRec.getText(),LBLUrg.getText(),Body);
					pp.setVisible(true);
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNPrint;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

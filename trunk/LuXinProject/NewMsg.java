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
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class NewMsg extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2762781648983784832L;
	private JPanel jContentPane = null;
	private JScrollPane ScrollList = null;
	private JList LSTMsg = null;
	Methods c=new Methods();
	private ResultSet rs = null;
	private Statement sql;
	private DefaultListModel listModel;
	private JButton BTNBack = null;
	private JButton BTNLogout = null;
	private int option= 0 ;
	private int listOpt=-1;
	private int urgent=0;
	public int size, sizeID;
	String user="";
	String [] receivers = new String[100];
	String [] logins = new String [100];
	int[] ID=new int[100];
	private JLabel LBLHeading = null;
	private JLabel LBLTo = null;
	private JLabel LBLSubject = null;
	private JTextField TXTSub = null;
	private JButton BTNAdd = null;
	private JLabel LBLBody = null;
	private JButton BTNSend = null;
	private JLabel LVLReceivers = null;
	private JComboBox CBXTo = null;
	int counter=0;
	private JButton BTNDelete = null;
	private JScrollPane ScrollText = null;
	private JTextArea TXTBody = null;
	private JComboBox CBXUrgency = null;
	private JLabel LBLUrgency = null;
	public NewMsg(String Login) {
		super();
		initialize();
		user=Login;
		display(user);
		
	}
	
	
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollList() {
		if (ScrollList == null) {
			ScrollList = new JScrollPane();
			ScrollList.setBounds(new java.awt.Rectangle(501,95,114,109));
			ScrollList.setViewportView(getLSTMsg());
			ScrollList.addMouseListener(new java.awt.event.MouseAdapter() {
				
			});
		}
		return ScrollList;
	}
	
	public void forward(String body, String subject){
		TXTBody.setText(body);
		TXTSub.setText("FW: "+subject);
	}
	public void reply(String body, String subject,String Receiver){
		TXTBody.setText("\n\n >>>>>"+body);
		TXTSub.setText("RE: "+subject);
		receivers[0]=Receiver;
		counter++;
		showList();
	}
	
	private JList getLSTMsg() {
		
		listModel = new DefaultListModel();
		LSTMsg = new JList(listModel);
		LSTMsg.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		LSTMsg.setFont(new java.awt.Font("Georgia", java.awt.Font.BOLD, 12));
		LSTMsg.setEnabled(true);
		LSTMsg.setBackground(java.awt.Color.black);
		LSTMsg.setForeground(java.awt.Color.white);
		LSTMsg.setVisibleRowCount(20);	  
		JScrollPane scrollPane = new JScrollPane(LSTMsg);
		scrollPane.setPreferredSize(new Dimension(250, 80));
		getContentPane().add(scrollPane, BorderLayout.CENTER);   
		
		
		return LSTMsg;
	}
	
	private void display(String user){
		listModel.clear();
		size = 0;
		sizeID=0;
		CBXUrgency.addItem("Normal");
		CBXUrgency.addItem("Moderate");
		CBXUrgency.addItem("High");
		CBXTo.addItem("< SELECT >");
		try {
			sql = c.con().createStatement();
			rs = sql.executeQuery("SELECT * FROM Login");
			
			while (rs.next())
				
			{	
				String temp = rs.getString(1);
				if (temp.compareToIgnoreCase(Methods.user)!=0	)
				{
					logins [size]= temp;
					CBXTo.addItem(logins[size]);
					size++;
				}
				
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			this.setTitle("Compose a message from "+user);
			
			try {
				sql = c.con().createStatement();
				rs = sql.executeQuery("SELECT * FROM Messages");
				
				while (rs.next())
				{		
					ID[sizeID]=Integer.parseInt(rs.getString(6));
					sizeID++;
					
				}} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
	
	private JButton getBTNBack() {
		if (BTNBack == null) {
			BTNBack = new JButton();
			BTNBack.setText("Cancel");
			BTNBack.setLocation(new java.awt.Point(538,419));
			BTNBack.setSize(new java.awt.Dimension(95,27));
			BTNBack.setFont(new Font("DialogInput", Font.BOLD, 12));
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Messaging msg = new Messaging(Methods.user);
					msg.setVisible(true);
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
			BTNLogout.setLocation(new java.awt.Point(518,30));
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
	 * This method initializes TXTSub	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTXTSub() {
		if (TXTSub == null) {
			TXTSub = new JTextField();
			TXTSub.setBounds(new java.awt.Rectangle(96,128,378,28));
		}
		return TXTSub;
	}
	/**
	 * This method initializes BTNAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNAdd() {
		if (BTNAdd == null) {
			BTNAdd = new JButton();
			BTNAdd.setBounds(new java.awt.Rectangle(412,88,62,26));
			BTNAdd.setText("Add");
			BTNAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					option = CBXTo.getSelectedIndex();
					boolean dup=false;
					if(option!=0){
						if (counter==0){
							receivers[0]=logins[option-1];
							counter++;
							showList();
						}
						
						else{
							for (int i=0;i<counter;i++){
								if(logins[option-1].equalsIgnoreCase(receivers[i]))
									dup=true;
								
							}
							if (dup){
								JOptionPane.showMessageDialog(null, "That receiver already exist!");
							}
							else{
								receivers[counter]=logins[option-1];
								counter++;
								showList();}
							
						}
						CBXTo.setSelectedIndex(0);
					}
				}
				
				
			});
		}
		return BTNAdd;
	}
	private void showList() {
		listModel.clear();
		for(int i =0;i<counter;i++){
			listModel.addElement(receivers[i]);
		}
		
	}
	private JButton getBTNSend() {
		if (BTNSend == null) {
			BTNSend = new JButton();
			BTNSend.setText("Send!");
			BTNSend.setSize(new java.awt.Dimension(95,27));
			BTNSend.setForeground(java.awt.Color.green);
			BTNSend.setLocation(new java.awt.Point(538,376));
			BTNSend.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String subject = TXTSub.getText();
					String body =TXTBody.getText();
					urgent=CBXUrgency.getSelectedIndex();
					if (counter==0)
						JOptionPane.showMessageDialog(null,"Please add receivers for this message!");
					else{
						for (int i =0;i<counter;i++){
							int idNo = findMax()+i+1;
							String idNum = idNo+"";
							try {
								c.updateTable("INSERT INTO Messages VALUES('"+subject+"','"+body+"','"+Methods.user+"','"+receivers[i]+"','0','"+idNum+"','"+urgent+"')");
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						JOptionPane.showMessageDialog(null,"Message(s) sent!");
						Messaging msg = new Messaging(Methods.user);
						msg.setVisible(true);
						dispose();
					}
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNSend;
	}
	private int findMax(){
		int max=0;
		for (int i=0;i<sizeID;i++)
		{
			if (ID[i]>max)
				max = ID[i];
		}
		return max;
	}
	private JComboBox getCBXTo() {
		if (CBXTo == null) {
			CBXTo = new JComboBox();
			CBXTo.setBounds(new java.awt.Rectangle(96,87,297,27));
			CBXTo.setBackground(java.awt.Color.white);
		}
		
		return CBXTo;
	}
	/**
	 * This method initializes BTNDelete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNDelete() {
		if (BTNDelete == null) {
			BTNDelete = new JButton();
			BTNDelete.setBounds(new java.awt.Rectangle(500,211,113,24));
			BTNDelete.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 10));
			BTNDelete.setText("Remove from list");
			BTNDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					listOpt=LSTMsg.getSelectedIndex();
					if (listOpt!=-1){
						delFromArray(listOpt);
						showList();
					}
					
				}
			});
		}
		return BTNDelete;
	}
	
	private void delFromArray(int order){
		for (int i = order;i<counter;i++){
			receivers[i]=receivers[i+1];
		}
		counter--;
	}
	private JScrollPane getScrollText() {
		if (ScrollText == null) {
			ScrollText = new JScrollPane();
			ScrollText.setBounds(new java.awt.Rectangle(19,243,492,202));
			ScrollText.setViewportView(getTXTBody());
		}
		return ScrollText;
	}
	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTXTBody() {
		if (TXTBody == null) {
			TXTBody = new JTextArea();
			TXTBody.setBackground(java.awt.Color.white);
			TXTBody.setEditable(true);
			TXTBody.setLineWrap(true);
			TXTBody.setWrapStyleWord(true);
			TXTBody.setForeground(java.awt.Color.black);
		}
		return TXTBody;
	}
	/**
	 * This method initializes CBXUrgency	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCBXUrgency() {
		if (CBXUrgency == null) {
			CBXUrgency = new JComboBox();
			CBXUrgency.setBounds(new java.awt.Rectangle(95,167,300,24));
		}
		return CBXUrgency;
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
		this.setSize(655, 512);
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
			
			
			LBLUrgency = new JLabel();
			LBLUrgency.setText("Urgency:");
			LBLUrgency.setLocation(new java.awt.Point(18,166));
			LBLUrgency.setSize(new java.awt.Dimension(67,29));
			LBLUrgency.setForeground(Color.white);
			LVLReceivers = new JLabel();
			LVLReceivers.setBounds(new java.awt.Rectangle(502,68,110,24));
			LVLReceivers.setForeground(java.awt.Color.white);
			LVLReceivers.setText("Current Receivers:");
			LBLBody = new JLabel();
			LBLBody.setBounds(new java.awt.Rectangle(18,204,67,29));
			LBLBody.setText("Body:");
			LBLBody.setForeground(java.awt.Color.white);
			LBLSubject = new JLabel();
			LBLSubject.setBounds(new java.awt.Rectangle(19,129,66,29));
			LBLSubject.setText("Subject:");
			LBLSubject.setForeground(java.awt.Color.white);
			LBLTo = new JLabel();
			LBLTo.setBounds(new java.awt.Rectangle(18,86,67,31));
			LBLTo.setForeground(java.awt.Color.white);
			LBLTo.setText("To:");
			LBLHeading = new JLabel();
			LBLHeading.setBounds(new java.awt.Rectangle(18,17,372,47));
			LBLHeading.setForeground(java.awt.Color.cyan);
			LBLHeading.setText("NATIONAL BUREAU OF INVESTIGATION MESSAGE SERVICE");
			LBLHeading.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 14));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.add(getScrollList(), null);
			//jContentPane.add(getJTable(), null);
			jContentPane.add(getBTNBack(), null);
			jContentPane.add(getBTNLogout(), null);
			jContentPane.add(LBLHeading, null);
			jContentPane.add(LBLTo, null);
			jContentPane.add(LBLSubject, null);
			jContentPane.add(getTXTSub(), null);
			jContentPane.add(getBTNAdd(), null);
			jContentPane.add(LBLBody, null);
			jContentPane.add(getBTNSend(), null);
			jContentPane.add(LVLReceivers, null);
			jContentPane.add(getCBXTo(), null);
			jContentPane.add(getBTNDelete(), null);
			jContentPane.add(getScrollText(), null);
			jContentPane.add(getCBXUrgency(), null);
			jContentPane.add(LBLUrgency, null);
		}
		return jContentPane;
	}
	
}  //  @jve:decl-index=0:visual-constraint="0,1"







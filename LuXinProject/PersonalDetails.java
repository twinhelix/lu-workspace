import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PersonalDetails extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2613432484702267195L;
	private JPanel jContentPane = null;
	private JLabel LBLWarning = null;
	private JLabel LBLPic = null;
	private JLabel LBLName = null;
	private JLabel LBLDOB = null;
	private JLabel LBLHeight = null;
	private JLabel LBLWeight = null;
	private JLabel LBLHair = null;
	private JLabel LBLEyes = null;
	private JLabel LBLSex = null;
	private JLabel LBLNationality = null;
	private JLabel LBLReward = null;
	Methods c=new Methods();
	private Connection conn = c.con();
	private ResultSet rs = null;
	private Statement stmt;
	private String Name, DOB, Hair, Eyes, Sex,Nationality, Scars, Crime;
	private double Height,Weight, Reward;
	char Caught;
	private JLabel LBLCaught = null;
	private JLabel LBLDBDOB = null;
	private JLabel LBLDBHight = null;
	private JLabel LBLDBWeight = null;
	private JLabel LBLDBHair = null;
	private JLabel LBLDBEyes = null;
	private JLabel LBLDBSex = null;
	private JLabel LBLDBNation = null;
	private JLabel LBLDBReward = null;
	private JLabel LBLScars = null;
	private JLabel LBLCrime = null;
	private JTextArea TXAScars = null;
	private JButton BTNBack = null;
	private JTextArea TXACrime = null;
	private JButton BTNEdit = null;
	/**
	 * This is the default constructor
	 */
	public PersonalDetails(String Person) {
		super();
		initialize();
		getInfo(Person);
	}
	private void getInfo(String info) {
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * FROM Info WHERE Name ='"+info+"'");
			while (rs.next()){
				Name = rs.getString(1);
				DOB = rs.getString(2);
				Height = rs.getDouble(3);
				Weight = rs.getDouble(4);
				Hair = rs.getString(5);
				Eyes = rs.getString(6);
				Sex = rs.getString(7);
				Nationality = rs.getString(8);
				Scars = rs.getString(9);
				Crime = rs.getString(10);
				Reward = rs.getDouble(11);
				Caught = rs.getString(13).charAt(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		display (info);
	}
	private void display(String Person) {
		this.setTitle("Details of "+Name);
		LBLName.setText(Name);
		LBLDBDOB.setText(DOB);
		LBLDBHight.setText(Height+ " m");
		LBLDBWeight.setText(Weight+" lbs");
		LBLDBHair.setText(Hair);
		LBLDBEyes.setText(Eyes);
		LBLDBSex.setText(Sex);
		LBLDBNation.setText(Nationality);
		LBLDBReward.setText("$ "+ Reward);
		TXAScars.setText (Scars);
		TXACrime.setText (Crime);
		if (Caught == 'Y')
		{LBLCaught.setForeground(java.awt.Color.green);
		LBLCaught.setText("Caught!");			
		}
		else {
			LBLCaught.setForeground(java.awt.Color.red);
			LBLCaught.setText("Not Captured!");
		}
		if (Person.equalsIgnoreCase("Richard Steve Goldberg"))
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/Steve.jpg")));
			
			
		}
		if (Person.equalsIgnoreCase("Victor Manuel Gerena"))			
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/gerena.jpg")));
			
		}
		if (Person.equalsIgnoreCase("Denise Mammy Vythalingham"))			
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/Mammy.jpg")));
			
		}
		if (Person.equalsIgnoreCase("Abdullah Ahmed Abdullah"))			
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/terabdullah.jpg")));
			
		}
		if (Person.equalsIgnoreCase("Adam Yahiye Gadahn"))			
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/gadahn.jpg")));
			
		}
		if (Person.equalsIgnoreCase("Emigdio Preciado JR."))			
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/preciado.jpg")));
			
		}
		if (Person.equalsIgnoreCase("James J. Bulger"))			
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/bulger.jpg")));
			
		}
		if (Person.equalsIgnoreCase("Jorge Alberto Lopez-Orozco"))			
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/lopez.jpg")));
			
		}
		if (Person.equalsIgnoreCase("USAMA BIN LADEN"))			
		{
			LBLPic.setIcon(new ImageIcon(getClass().getResource("/laden.jpg")));
			
		}
		
		
		
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(723, 486);
		this.setContentPane(getJContentPane());
		
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			LBLCrime = new JLabel();
			LBLCrime.setBounds(new java.awt.Rectangle(180,307,124,33));
			LBLCrime.setText("Crime Committed:");
			LBLCrime.setForeground(Color.blue);
			LBLScars = new JLabel();
			LBLScars.setBounds(new java.awt.Rectangle(179,223,125,35));
			LBLScars.setText("Scars and Remarks: ");
			LBLScars.setForeground(Color.blue);
			LBLDBReward = new JLabel();
			LBLDBReward.setText("");
			LBLDBReward.setSize(new java.awt.Dimension(132,28));
			LBLDBReward.setForeground(java.awt.Color.white);
			LBLDBReward.setLocation(new java.awt.Point(503,174));
			LBLDBNation = new JLabel();
			LBLDBNation.setText("");
			LBLDBNation.setSize(new java.awt.Dimension(121,28));
			LBLDBNation.setForeground(java.awt.Color.white);
			LBLDBNation.setLocation(new java.awt.Point(271,176));
			LBLDBSex = new JLabel();
			LBLDBSex.setText("");
			LBLDBSex.setSize(new java.awt.Dimension(76,28));
			LBLDBSex.setForeground(java.awt.Color.white);
			LBLDBSex.setLocation(new java.awt.Point(619,127));
			LBLDBEyes = new JLabel();
			LBLDBEyes.setText("");
			LBLDBEyes.setSize(new java.awt.Dimension(76,28));
			LBLDBEyes.setForeground(java.awt.Color.white);
			LBLDBEyes.setLocation(new java.awt.Point(445,131));
			LBLDBHair = new JLabel();
			LBLDBHair.setText("");
			LBLDBHair.setSize(new java.awt.Dimension(76,28));
			LBLDBHair.setForeground(java.awt.Color.white);
			LBLDBHair.setLocation(new java.awt.Point(270,133));
			LBLDBWeight = new JLabel();
			LBLDBWeight.setText("");
			LBLDBWeight.setSize(new java.awt.Dimension(76,28));
			LBLDBWeight.setForeground(java.awt.Color.white);
			LBLDBWeight.setLocation(new java.awt.Point(619,84));
			LBLDBHight = new JLabel();
			LBLDBHight.setText("");
			LBLDBHight.setSize(new java.awt.Dimension(76,28));
			LBLDBHight.setForeground(java.awt.Color.white);
			LBLDBHight.setLocation(new java.awt.Point(446,83));
			LBLDBDOB = new JLabel();
			LBLDBDOB.setBounds(new java.awt.Rectangle(270,83,76,28));
			LBLDBDOB.setForeground(java.awt.Color.white);
			LBLDBDOB.setText("");
			LBLCaught = new JLabel();
			LBLCaught.setBounds(new java.awt.Rectangle(19,298,150,33));
			LBLCaught.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			LBLCaught.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			LBLCaught.setText("");
			LBLReward = new JLabel();
			LBLReward.setText("Reward:");
			LBLReward.setLocation(new java.awt.Point(407,172));
			LBLReward.setSize(new java.awt.Dimension(79,31));
			LBLReward.setForeground(java.awt.Color.blue);
			LBLNationality = new JLabel();
			LBLNationality.setText("Nationality:");
			LBLNationality.setLocation(new java.awt.Point(181,178));
			LBLNationality.setSize(new java.awt.Dimension(79,31));
			LBLNationality.setForeground(java.awt.Color.blue);
			LBLSex = new JLabel();
			LBLSex.setText("Sex:");
			LBLSex.setLocation(new java.awt.Point(531,128));
			LBLSex.setSize(new java.awt.Dimension(79,31));
			LBLSex.setForeground(java.awt.Color.blue);
			LBLEyes = new JLabel();
			LBLEyes.setText("Eyes:");
			LBLEyes.setLocation(new java.awt.Point(356,129));
			LBLEyes.setSize(new java.awt.Dimension(79,31));
			LBLEyes.setForeground(java.awt.Color.blue);
			LBLHair = new JLabel();
			LBLHair.setText("Hair:");
			LBLHair.setLocation(new java.awt.Point(183,134));
			LBLHair.setSize(new java.awt.Dimension(79,31));
			LBLHair.setForeground(java.awt.Color.blue);
			LBLWeight = new JLabel();
			LBLWeight.setText("Weight: ");
			LBLWeight.setLocation(new java.awt.Point(531,83));
			LBLWeight.setSize(new java.awt.Dimension(79,31));
			LBLWeight.setForeground(java.awt.Color.blue);
			LBLHeight = new JLabel();
			LBLHeight.setText("Height: ");
			LBLHeight.setLocation(new java.awt.Point(358,81));
			LBLHeight.setSize(new java.awt.Dimension(79,31));
			LBLHeight.setForeground(java.awt.Color.blue);
			LBLDOB = new JLabel();
			LBLDOB.setBounds(new java.awt.Rectangle(184,82,79,31));
			LBLDOB.setForeground(java.awt.Color.blue);
			LBLDOB.setText("Date of Birth:");
			LBLName = new JLabel();
			LBLName.setBounds(new java.awt.Rectangle(59,23,360,34));
			LBLName.setForeground(java.awt.Color.white);
			LBLName.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			LBLName.setText("");
			LBLPic = new JLabel();
			LBLPic.setText("LBLIMAGE");
			LBLPic.setSize(new java.awt.Dimension(150,200));
			LBLPic.setLocation(new java.awt.Point(19,86));
			LBLWarning = new JLabel();
			LBLWarning.setBounds(new java.awt.Rectangle(431,30,172,24));
			LBLWarning.setForeground(Color.red);
			LBLWarning.setText("All information is Confidential!");
			LBLWarning.setFont(new Font("Perpetua", Font.BOLD, 12));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(LBLWarning, null);
			jContentPane.add(LBLPic, null);
			jContentPane.add(LBLName, null);
			jContentPane.add(LBLDOB, null);
			jContentPane.add(LBLHeight, null);
			jContentPane.add(LBLWeight, null);
			jContentPane.add(LBLHair, null);
			jContentPane.add(LBLEyes, null);
			jContentPane.add(LBLSex, null);
			jContentPane.add(LBLNationality, null);
			jContentPane.add(LBLReward, null);
			jContentPane.add(LBLCaught, null);
			jContentPane.add(LBLDBDOB, null);
			jContentPane.add(LBLDBHight, null);
			jContentPane.add(LBLDBWeight, null);
			jContentPane.add(LBLDBHair, null);
			jContentPane.add(LBLDBEyes, null);
			jContentPane.add(LBLDBSex, null);
			jContentPane.add(LBLDBNation, null);
			jContentPane.add(LBLDBReward, null);
			jContentPane.add(LBLScars, null);
			jContentPane.add(LBLCrime, null);
			jContentPane.add(getBTNBack(), null);
			jContentPane.add(getTXAScars1(), null);
			jContentPane.add(getTXACrime(), null);
			jContentPane.add(getBTNEdit(), null);
			
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
			BTNBack.setBounds(new java.awt.Rectangle(444,397,110,31));
			BTNBack.setForeground(java.awt.Color.red);
			BTNBack.setText("Back");
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MainMenu mm = new MainMenu();
					mm.setVisible(true);
					dispose();	
				}
			});
		}
		return BTNBack;
	}
	/**
	 * This method initializes TXAScars1	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTXAScars1() {
		if (TXAScars == null) {
			TXAScars = new JTextArea();
			TXAScars.setBounds(new java.awt.Rectangle(330,231,359,64));
			TXAScars.setForeground(java.awt.Color.white);
			TXAScars.setLineWrap(true);
			TXAScars.setEditable(false);
			TXAScars.setWrapStyleWord(true);
			TXAScars.setBackground(java.awt.Color.black);
		}
		return TXAScars;
	}
	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTXACrime() {
		if (TXACrime == null) {
			TXACrime = new JTextArea();
			TXACrime.setForeground(java.awt.Color.white);
			TXACrime.setLocation(new java.awt.Point(329,313));
			TXACrime.setSize(new java.awt.Dimension(359,64));
			TXACrime.setLineWrap(true);
			TXACrime.setEditable(false);
			TXACrime.setWrapStyleWord(true);
			TXACrime.setBackground(java.awt.Color.black);
		}
		return TXACrime;
	}
	
	private JButton getBTNEdit() {
		if (BTNEdit == null) {
			BTNEdit = new JButton();
			BTNEdit.setBounds(new java.awt.Rectangle(197,396,116,30));
			BTNEdit.setForeground(java.awt.Color.orange);
			BTNEdit.setText("Edit Details");
			BTNEdit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EditDetails ed = new EditDetails(Name);
					ed.setVisible(true);
					dispose();
					
				}
			});
		}
		return BTNEdit;
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

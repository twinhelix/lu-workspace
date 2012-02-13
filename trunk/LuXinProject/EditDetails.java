import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;

public class EditDetails extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1977321062048841039L;
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
	Methods m=new Methods();
	private Connection conn = m.con();
	private ResultSet rs = null;
	private Statement stmt;
	private String Name, DOB, Hair, Eyes, Sex,Nationality, Scars, Crime, TXTHeight, TXTWeight, TXTReward;
	private double Height,Weight, Reward;
	char Caught;
	private JLabel LBLCaught = null;
	private JTextField TXTDBDOB = null;
	private JTextField TXTDBHight = null;
	private JTextField TXTDBWeight = null;
	private JTextField TXTDBHair = null;
	private JTextField TXTDBEyes = null;
	private JTextField TXTDBSex = null;
	private JTextField TXTDBNation = null;
	private JTextField TXTDBReward = null;
	private JLabel LBLScars = null;
	private JLabel LBLCrime = null;
	private JTextArea TXAScars = null;
	private JButton BTNBack = null;
	private JTextArea TXACrime = null;
	private JButton BTNEdit = null;
	
	/**
	 * This is the default constructor
	 */
	public EditDetails(String Person) {
		super();
		initialize();
		getInfo(Person);
	}
	private void getInfo(String info) {
		try {
			stmt = conn.createStatement();
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
		TXTDBDOB.setText(DOB);
		TXTDBHight.setText(Height+"");
		TXTDBWeight.setText(Weight+"");
		TXTDBHair.setText(Hair);
		TXTDBEyes.setText(Eyes);
		TXTDBSex.setText(Sex);
		TXTDBNation.setText(Nationality);
		TXTDBReward.setText(Reward+"");
		TXAScars.setText (Scars);
		TXACrime.setText (Crime);
		if (Caught == 'Y')
		{
			LBLCaught.setText("Caught!");			
		}
		else {
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
		this.setTitle("Edit");
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
			TXTDBReward = new JTextField();
			TXTDBReward.setText("");
			TXTDBReward.setSize(new java.awt.Dimension(132,28));
			TXTDBReward.setForeground(java.awt.Color.black);
			TXTDBReward.setLocation(new java.awt.Point(503,174));
			TXTDBNation = new JTextField();
			TXTDBNation.setText("");
			TXTDBNation.setSize(new java.awt.Dimension(121,28));
			TXTDBNation.setForeground(java.awt.Color.black);
			TXTDBNation.setLocation(new java.awt.Point(271,176));
			TXTDBSex = new JTextField();
			TXTDBSex.setText("");
			TXTDBSex.setSize(new java.awt.Dimension(76,28));
			TXTDBSex.setForeground(java.awt.Color.black);
			TXTDBSex.setLocation(new java.awt.Point(619,127));
			TXTDBEyes = new JTextField();
			TXTDBEyes.setText("");
			TXTDBEyes.setSize(new java.awt.Dimension(76,28));
			TXTDBEyes.setForeground(java.awt.Color.black);
			TXTDBEyes.setLocation(new java.awt.Point(445,131));
			TXTDBHair = new JTextField();
			TXTDBHair.setText("");
			TXTDBHair.setSize(new java.awt.Dimension(76,28));
			TXTDBHair.setForeground(java.awt.Color.black);
			TXTDBHair.setLocation(new java.awt.Point(270,133));
			TXTDBWeight = new JTextField();
			TXTDBWeight.setText("");
			TXTDBWeight.setSize(new java.awt.Dimension(76,28));
			TXTDBWeight.setForeground(java.awt.Color.black);
			TXTDBWeight.setLocation(new java.awt.Point(619,84));
			TXTDBHight = new JTextField();
			TXTDBHight.setText("");
			TXTDBHight.setSize(new java.awt.Dimension(76,28));
			TXTDBHight.setForeground(java.awt.Color.black);
			TXTDBHight.setLocation(new java.awt.Point(446,83));
			TXTDBDOB = new JTextField();
			TXTDBDOB.setBounds(new java.awt.Rectangle(270,83,76,28));
			TXTDBDOB.setForeground(java.awt.Color.black);
			TXTDBDOB.setText("");
			LBLCaught = new JLabel();
			LBLCaught.setBounds(new java.awt.Rectangle(21,295,148,33));
			LBLCaught.setForeground(java.awt.Color.red);
			LBLCaught.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			LBLCaught.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			LBLCaught.setText("");
			LBLReward = new JLabel();
			LBLReward.setText("Reward ($):");
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
			LBLWeight.setText("Weight (lbs): ");
			LBLWeight.setLocation(new java.awt.Point(531,83));
			LBLWeight.setSize(new java.awt.Dimension(79,31));
			LBLWeight.setForeground(java.awt.Color.blue);
			LBLHeight = new JLabel();
			LBLHeight.setText("Height (m): ");
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
			jContentPane.add(TXTDBDOB, null);
			jContentPane.add(TXTDBHight, null);
			jContentPane.add(TXTDBWeight, null);
			jContentPane.add(TXTDBHair, null);
			jContentPane.add(TXTDBEyes, null);
			jContentPane.add(TXTDBSex, null);
			jContentPane.add(TXTDBNation, null);
			jContentPane.add(TXTDBReward, null);
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
			BTNBack.setBounds(new java.awt.Rectangle(418,395,110,31));
			BTNBack.setForeground(java.awt.Color.red);
			BTNBack.setText("Back");
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					PersonalDetails pd = new PersonalDetails(Name);
					pd.setVisible(true);
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
			TXAScars.setForeground(java.awt.Color.black);
			TXAScars.setLineWrap(true);
			TXAScars.setWrapStyleWord(true);
			TXAScars.setBackground(java.awt.Color.white);
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
			TXACrime.setForeground(java.awt.Color.black);
			TXACrime.setLocation(new java.awt.Point(329,313));
			TXACrime.setSize(new java.awt.Dimension(359,64));
			TXACrime.setLineWrap(true);
			TXACrime.setWrapStyleWord(true);
			TXACrime.setBackground(java.awt.Color.white);
		}
		return TXACrime;
	}
	
	private JButton getBTNEdit() {
		if (BTNEdit == null) {
			BTNEdit = new JButton();
			BTNEdit.setBounds(new java.awt.Rectangle(174,399,116,30));
			BTNEdit.setForeground(java.awt.Color.green);
			BTNEdit.setText("Update");
			BTNEdit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					boolean correct = false;
					
					DOB = TXTDBDOB.getText();
					TXTHeight=TXTDBHight.getText();
					TXTWeight=TXTDBWeight.getText();
					Hair = TXTDBHair.getText();
					Eyes = TXTDBEyes.getText();
					Sex = TXTDBSex.getText();
					Nationality = TXTDBNation.getText();
					Scars = TXAScars.getText();
					Crime = TXACrime.getText();
					TXTReward=TXTDBReward.getText();
					
					if ( m.test (TXTHeight)==true&& m.test (TXTWeight)==true&& m.test (TXTReward)==true)
						correct=true;
					
					if (correct){
						Height = Double.parseDouble(TXTHeight);
						Weight = Double.parseDouble(TXTWeight);
						Reward = Double.parseDouble(TXTReward);
						try {
							
							m.updateTable("UPDATE Info SET Date_of_Birth='"+DOB+"',Height_m='"+Height+"', Weight_lbs='"+Weight+"',Hair='"+Hair+"',Eyes='"+Eyes+"',Nationality='"+Nationality+"',Scars_and_Marks='"+Scars+"',Crime='"+Crime+"',Reward_USD='"+Reward+"'"+" WHERE Name ='"+Name+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "Details has been updated!");
						PersonalDetails pd = new PersonalDetails(Name);
						pd.setVisible(true);
						dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "There is an error in the number fields");
					
				}
			});
		}
		return BTNEdit;
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

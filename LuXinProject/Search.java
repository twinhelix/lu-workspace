import javax.swing.*;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Search extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3955395434867379781L;
	private JPanel jContentPane = null;
	private JLabel LBLTitle = null;
	private JLabel LBLInfo = null;
	private JButton BTNName = null;
	private JButton BTNHair = null;
	private JButton BTNEyes = null;
	private JButton BTNNation = null;
	private JButton BTNRank = null;
	private JButton BTNDOB = null;
	private JTextField TXTSearchField = null;
	private JButton BTNSearch = null;
	private JLabel LBLMsg = null;
	int choice =0;
	String search;
	Methods m = new Methods();
	private JButton BTNBack = null;
	
	/**
	 * This is the default constructor
	 */
	public Search() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(428, 385);
		this.setContentPane(getJContentPane());
		this.setTitle("Search");
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			LBLMsg = new JLabel();
			LBLMsg.setBounds(new java.awt.Rectangle(55,226,358,30));
			LBLMsg.setForeground(java.awt.Color.green);
			LBLInfo = new JLabel();
			LBLInfo.setBounds(new java.awt.Rectangle(165,45,70,26));
			LBLInfo.setForeground(java.awt.Color.white);
			LBLInfo.setText("Search by:");
			LBLTitle = new JLabel();
			LBLTitle.setBounds(new java.awt.Rectangle(135,15,117,34));
			LBLTitle.setForeground(java.awt.Color.yellow);
			LBLTitle.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			LBLTitle.setText("Search Menu");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(LBLTitle, null);
			jContentPane.add(LBLInfo, null);
			jContentPane.add(getBTNName(), null);
			jContentPane.add(getBTNHair(), null);
			jContentPane.add(getBTNEyes(), null);
			jContentPane.add(getBTNNation(), null);
			jContentPane.add(getBTNRank(), null);
			jContentPane.add(getBTNDOB(), null);
			jContentPane.add(getTXTSearchField(), null);
			jContentPane.add(getBTNSearch(), null);
			jContentPane.add(LBLMsg, null);
			jContentPane.add(getBTNBack(), null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes BTNName	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNName() {
		if (BTNName == null) {
			BTNName = new JButton();
			BTNName.setBounds(new java.awt.Rectangle(60,90,106,31));
			BTNName.setBackground(new java.awt.Color(99,112,199));
			BTNName.setText("Name");
			BTNName.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LBLMsg.setText("What is the name that you are searching for?");
					TXTSearchField.setVisible(true);
					BTNSearch.setVisible(true);
					choice=1;
				}
			});
		}
		return BTNName;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNHair() {
		if (BTNHair == null) {
			BTNHair = new JButton();
			BTNHair.setText("Hair");
			BTNHair.setLocation(new java.awt.Point(60,135));
			BTNHair.setSize(new java.awt.Dimension(106,31));
			BTNHair.setBackground(new java.awt.Color(99,112,199));
			BTNHair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LBLMsg.setText("What is the hair colour you are searching for?");
					TXTSearchField.setVisible(true);
					BTNSearch.setVisible(true);
					choice=2;	}
			});
		}
		return BTNHair;
	}
	
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNEyes() {
		if (BTNEyes == null) {
			BTNEyes = new JButton();
			BTNEyes.setBounds(new java.awt.Rectangle(60,180,106,31));
			BTNEyes.setText("Eyes");
			BTNEyes.setBackground(new java.awt.Color(99,112,199));
			BTNEyes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LBLMsg.setText("What is the Eye colour you are searching for?");
					TXTSearchField.setVisible(true);
					BTNSearch.setVisible(true);
					choice=3;
				}
			});
		}
		return BTNEyes;
	}
	
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNNation() {
		if (BTNNation == null) {
			BTNNation = new JButton();
			BTNNation.setBounds(new java.awt.Rectangle(240,90,106,31));
			BTNNation.setText("Nationality");
			BTNNation.setBackground(new java.awt.Color(99,112,199));
			BTNNation.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LBLMsg.setText("What is the Nationality that you are searching for?");
					TXTSearchField.setVisible(true);
					BTNSearch.setVisible(true);
					choice=4;}
			});
		}
		return BTNNation;
	}
	
	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNRank() {
		if (BTNRank == null) {
			BTNRank = new JButton();
			BTNRank.setBounds(new java.awt.Rectangle(240,135,106,31));
			BTNRank.setText("Rank");
			BTNRank.setBackground(new java.awt.Color(99,112,199));
			BTNRank.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LBLMsg.setText("What is the Most Wanted Rank that your are searching for?");
					TXTSearchField.setVisible(true);
					BTNSearch.setVisible(true);
					choice=5;}
			});
		}
		return BTNRank;
	}
	
	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNDOB() {
		if (BTNDOB == null) {
			BTNDOB = new JButton();
			BTNDOB.setBounds(new java.awt.Rectangle(240,180,106,31));
			BTNDOB.setText("Date of Birth");
			BTNDOB.setBackground(new java.awt.Color(99,112,199));
			BTNDOB.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LBLMsg.setText("What is the year of birth that your are searching for?");
					TXTSearchField.setVisible(true);
					BTNSearch.setVisible(true);
					choice=6;}
			});
		}
		return BTNDOB;
	}
	
	/**
	 * This method initializes TXTSearchField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTXTSearchField() {
		if (TXTSearchField == null) {
			TXTSearchField = new JTextField();
			TXTSearchField.setBounds(new java.awt.Rectangle(109,265,194,28));
			TXTSearchField.setVisible(false);
		}
		return TXTSearchField;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNSearch() {
		if (BTNSearch == null) {
			BTNSearch = new JButton();
			BTNSearch.setBounds(new java.awt.Rectangle(146,300,107,37));
			BTNSearch.setText("SEARCH!");
			BTNSearch.setBackground(java.awt.Color.red);
			BTNSearch.setVisible(false);
			BTNSearch.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					search = TXTSearchField.getText();
					m.fillArray();
					boolean found = false;
					int value = 0;
					int rank=0;
					
					if (search.compareToIgnoreCase("")!=0){
						switch (choice){
						
						case 1:
							
							for (int i=0;i<m.size;i++){
								StringTokenizer st = new StringTokenizer(m.criminals[i].getName());
								while (st.hasMoreTokens()){
									if (search.equalsIgnoreCase(st.nextToken()))
									{
										found = true;
										value = i;
									}
								}
							}
							
							if (found){
								AllPeople ap = new AllPeople ("Search Result","SELECT * FROM Info WHERE Name = '"+m.criminals[value].getName()+"'");
								ap.setVisible(true);
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Name not found");
							
							break;
						case 2:
							for (int i=0;i<m.size;i++){
								if(search.equalsIgnoreCase(m.criminals[i].getHair()))
								{
									found = true;
									
									value = i;
								}
							}
							if (found){
								AllPeople ap = new AllPeople ("Search Result","SELECT * FROM Info WHERE Hair = '"+m.criminals[value].getHair()+"'");
								ap.setVisible(true);
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Hair colour not found");
							
							break;
						case 3:
							for (int i=0;i<m.size;i++){
								if(search.equalsIgnoreCase(m.criminals[i].getEyes()))
								{
									found = true;
									
									value = i;
								}
							}
							if (found){
								AllPeople ap = new AllPeople ("Search Result","SELECT * FROM Info WHERE Eyes = '"+m.criminals[value].getEyes()+"'");
								ap.setVisible(true);
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Eye colour not found");
							
							break;
						case 4:
							for (int i=0;i<m.size;i++){
								if(search.equalsIgnoreCase(m.criminals[i].getNationality()))
								{
									found = true;
									
									value = i;
								}
							}
							if (found){
								AllPeople ap = new AllPeople ("Search Result","SELECT * FROM Info WHERE Nationality = '"+m.criminals[value].getNationality()+"'");
								ap.setVisible(true);
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Nationality not found");
							
							break;
						case 5:
							if (m.test(search)==true)
							{
								rank= Integer.parseInt(search);
								if (rank<=9&&rank>=1){
									PersonalDetails pd = new PersonalDetails (m.criminals[rank-1].getName());
									pd.setVisible(true);
									dispose();
								}
								else 
									JOptionPane.showMessageDialog(null, "Invalid Rank, please re enter");
							}
							else 
								JOptionPane.showMessageDialog(null, "The number you have entered is invalid, please re enter");
							
							break;
						case 6:
							if (m.test(search.substring(0,3))==true)
							{
								
								for (int i=0;i<m.size;i++){
									if(search.substring(0,3).equalsIgnoreCase(m.criminals[i].getDoB().substring(0,3)))
									{
										found = true;
										
										value = i;
									}
								}
								if (found){
									AllPeople ap = new AllPeople ("Search Result","SELECT * FROM Info WHERE Date_of_Birth = '"+m.criminals[value].getDoB()+"'");
									ap.setVisible(true);
									dispose();
								}
								else
									JOptionPane.showMessageDialog(null, "The search for that year returned no results");
							}
							else 
								JOptionPane.showMessageDialog(null, "The year you have entered is invalid, please re enter");
							break;
						default:
							JOptionPane.showMessageDialog(null, "Invalid option");
						
						
						}
					}else
						JOptionPane.showMessageDialog(null, "Please type in what you are searching for ");
					
				}
			});
		}
		return BTNSearch;
	}
	
	/**
	 * This method initializes BTNBack	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNBack() {
		if (BTNBack == null) {
			BTNBack = new JButton();
			BTNBack.setBounds(new java.awt.Rectangle(310,25,80,30));
			BTNBack.setText("Back");
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MainMenu c = new MainMenu();
					c.setVisible(true);
					dispose();
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNBack;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

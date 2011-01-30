import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PrintPreview extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8403044992598016082L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTextArea TXTPrint = null;
	private JLabel LBLPreview = null;
	private JButton BTNBack = null;
	private JButton BTNPrint = null;
	/**
	 * This is the default constructor
	 */
	public PrintPreview(String Title, String Type, String person,String urgent,String body) {
		super();
		initialize();
		setPage( Title,  Type,  person, urgent, body);
	}
	
	private void setPage(String Title, String Type, String person,String urgent,String body) {
		String text = "         NATIONAL BUREAU OF INVESTIGATION MESSAGING SERVICE";
		text=text+"\n\n\n\nTITLE:\t"+Title;
		text=text+"\n\n"+Type.toUpperCase()+"\t"+person;
		text=text+"\n\nURGENCY:\t"+urgent;
		text=text+"\n\nMESSAGE:\n\n"+body;
		text=text+"\n\n\n-----------------------------------------------------------------\nEND OF MESSAGE";
		TXTPrint.setText(text);
		
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(615, 438);
		this.setContentPane(getJContentPane());
		this.setTitle("Print Message");
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			LBLPreview = new JLabel();
			LBLPreview.setBounds(new java.awt.Rectangle(200,16,139,38));
			LBLPreview.setForeground(java.awt.Color.magenta);
			LBLPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			LBLPreview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			LBLPreview.setText("Print Preview:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(LBLPreview, null);
			jContentPane.add(getBTNBack(), null);
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
			jScrollPane.setBounds(new java.awt.Rectangle(38,70,431,312));
			jScrollPane.setForeground(java.awt.Color.white);
			jScrollPane.setViewportView(getTXTPrint());
		}
		return jScrollPane;
	}
	
	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTXTPrint() {
		if (TXTPrint == null) {
			TXTPrint = new JTextArea();
			TXTPrint.setBackground(java.awt.Color.white);
			TXTPrint.setEditable(false);
			TXTPrint.setLineWrap(true);
			TXTPrint.setWrapStyleWord(true);
			TXTPrint.setForeground(java.awt.Color.black);
		}
		return TXTPrint;
	}
	
	/**
	 * This method initializes BTNBack	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNBack() {
		if (BTNBack == null) {
			BTNBack = new JButton();
			BTNBack.setPreferredSize(new java.awt.Dimension(93,31));
			BTNBack.setLocation(new java.awt.Point(490,16));
			BTNBack.setSize(new java.awt.Dimension(93,31));
			BTNBack.setForeground(java.awt.Color.red);
			BTNBack.setText("Back");
			BTNBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNBack;
	}
	
	/**
	 * This method initializes BTNPrint	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBTNPrint() {
		if (BTNPrint == null) {
			BTNPrint = new JButton();
			BTNPrint.setPreferredSize(new java.awt.Dimension(93,31));
			BTNPrint.setLocation(new java.awt.Point(488,255));
			BTNPrint.setSize(new java.awt.Dimension(93,31));
			BTNPrint.setForeground(java.awt.Color.blue);
			BTNPrint.setText("Print");
			BTNPrint.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Print.printComponent(TXTPrint);
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BTNPrint;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main{
	JLabel  titleLabel,imageLabel,imageLabel1, imageLabel3,
	 regLabel,  disLabel, showregLabel, showdisLabel,inLabel,
	 outLabel,docLabel, staffLabel,hosLabel,  menuLabel;
	 
	 
	 JButton regButton,disButton , showregButton,showdisButton,
	 inButton,outButton,docButton, staffButton,hosButton,
	 homeButton, logButton,cancelButton;
	
	JFrame theFrame;
	
	JPanel thePanel,thePanel1,thePanel2, thePanel3,thePanel4, thePanel5,
	 thePanel6, thePanel7 ,thePanel8, thePanel9, thePanel11;
	
	public static void main(String args[]){
		new Main();
	}//void main closed
	
	public Main(){
		//Frame
		theFrame = new JFrame("Main Page");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setSize(1366,768);
	 	theFrame.setLocationRelativeTo(null);
	 	theFrame.setLayout(null);
	 	 imageLabel3 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\22.png")));
	 	imageLabel3.setBounds(0,0,1366,768);
	 	theFrame.getContentPane().setBackground( Color.LIGHT_GRAY);
	 	theFrame.add(imageLabel3);
	 	//Menu Panel
	 	
	 	thePanel = new JPanel();
	 	thePanel.setBounds(0,0,1366,50);
	 	thePanel.setLayout(null);
		titleLabel = new JLabel("Patient Information System");
		
		titleLabel.setBounds(150,0,1500,50);
		titleLabel.setFont(new Font("Algerian",Font.BOLD,65));
		thePanel.setBackground(Color.white);
		imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\34.png")));
		imageLabel.setBounds(10,0,70,50);
		imageLabel1 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\34.png")));
		imageLabel1.setBounds(1270,0,70,50);
		thePanel.setBackground(Color.LIGHT_GRAY);
		thePanel.add(imageLabel1);
		thePanel.add(imageLabel); 
		thePanel.add(titleLabel); 
		
		
		 thePanel1 =  new JPanel();
		thePanel1.setBounds(0,150,235,50);
		thePanel1.setBackground(Color.white);
		thePanel1.setLayout(null);
 		// regLabel = new JLabel("Patient Registration Form");
		//regLabel.setBounds(0,0,700,50);
		 regButton = new JButton ("Patient Registration Form");
		regButton.setBounds(0,0,235,50);
	 	regButton.setFocusPainted(true);
		regButton.setBorderPainted(true);
		thePanel1.add(regButton);
	//	thePanel1.add(regLabel);
		imageLabel3.add(thePanel1);
		
 		 thePanel2 =  new JPanel();
		thePanel2.setBounds(1135,150,213,50);
		thePanel2.setBackground(Color.white);
		thePanel2.setLayout(null);
	  //  disLabel = new JLabel("Patient Discharge Form");
	//	disLabel.setBounds(0,0,700,50);
		//thePanel2.add(disLabel);
		 disButton = new JButton ("Patient Discharge Form");
		disButton.setBounds(-30,0,245,50);
		disButton.setFocusPainted(true);
		disButton.setBorderPainted(true);
		thePanel2.add(disButton);
		imageLabel3.add(thePanel2);
		
		 thePanel3 =  new JPanel();
		thePanel3.setBounds(0,250,232,50);
		thePanel3.setBackground(Color.white);
		thePanel3.setLayout(null);
 	//	 showregLabel = new JLabel("Show Registered Patient");
	//	showregLabel.setBounds(0,0,700,50);
		 showregButton = new JButton ("Show Registered Patient");
		showregButton.setBounds(-30,0,262,50);
		showregButton.setFocusPainted(true);
		showregButton.setBorderPainted(true);
		thePanel3.add(showregButton);
		//thePanel3.add(showregLabel);
		imageLabel3.add(thePanel3);
		
 		 thePanel4 =  new JPanel(); 
 		thePanel4.setBounds(1135,250,213,50);
		
 		//thePanel4.setBounds();
		thePanel4.setBackground(Color.white);
		thePanel4.setLayout(null);
 		 //showdisLabel = new JLabel("Show  Discharged Patient");
	//	showdisLabel.setBounds(0,0,700,50);
		 showdisButton = new JButton ("Show  Discharged Patient");
		showdisButton.setBounds(-30,0,245,50);
		showdisButton.setFocusPainted(true);
		showdisButton.setBorderPainted(true);
		thePanel4.add(showdisButton);
	//	thePanel4.add(showdisLabel);
		imageLabel3.add(thePanel4);
		
 	    thePanel5 =  new JPanel();
		thePanel5.setBounds(0,350,235,50);
		thePanel5.setBackground(Color.white);
		thePanel5.setLayout(null);
 		//inLabel = new JLabel("Show InPatient");
	///	inLabel.setBounds(0,0,700,50);
		 inButton = new JButton ("Show InPatient");
		 inButton.setFocusPainted(true);
			inButton.setBorderPainted(true);
		 inButton.setBounds(0,0,235,50);
		thePanel5.add(inButton);
	//	thePanel5.add(inLabel);
		imageLabel3.add(thePanel5);
 		
 		 thePanel6 =  new JPanel();
 		thePanel6.setBounds(1135,350,213,50);
 		//
		thePanel6.setBackground(Color.white);
		thePanel6.setLayout(null);
 		// outLabel = new JLabel("Show OutPatient");
	//	outLabel.setBounds(0,0,700,50);
	    outButton = new JButton ("Show OutPatient");
		outButton.setBounds(-30,0,245,50);
		outButton.setFocusPainted(true);
		outButton.setBorderPainted(true);
		thePanel6.add(outButton);
		//thePanel6.add(outLabel);
		imageLabel3.add(thePanel6);
 		
 		 thePanel7 =  new JPanel();
 	
		thePanel7.setBounds(0,450,235,50);
		//0,550,500,50
		thePanel7.setBackground(Color.white);
		thePanel7.setLayout(null);
 		// docLabel = new JLabel("Doctor Information");
		//docLabel.setBounds(0,0,700,50);
		 docButton = new JButton ("Doctor Information");
		docButton.setBounds(0,0,235,50);
		docButton.setFocusPainted(true);
		docButton.setBorderPainted(true);
		thePanel7.add(docButton);
		//thePanel7.add(docLabel);
		imageLabel3.add(thePanel7);
 		
 		  thePanel8 =  new JPanel(); 
		thePanel8.setBounds(550,580,245,50);
		thePanel8.setBackground(Color.white);
		thePanel8.setLayout(null);
 		 //staffLabel = new JLabel("Staff Information");
		//staffLabel.setBounds(0,0,700,50);
		 staffButton = new JButton ("Staff Information");
		staffButton.setBounds(0,0,245,50);
		//thePanel8.add(staffLabel);
		thePanel8.add(staffButton);
		imageLabel3.add(thePanel8);
 		
		 thePanel9 =  new JPanel();
		thePanel9.setBounds(1135,450,213,50);
		thePanel9.setBackground(Color.white);
		thePanel9.setLayout(null);
 		 // hosLabel = new JLabel("Hospital Information");
		//hosLabel.setBounds(0,0,700,50);
		hosButton = new JButton ("Hospital Information");
		hosButton.setBounds(-30,0,245,50);
		hosButton.setFocusPainted(true);
		hosButton.setBorderPainted(true);
		//thePanel9.add(hosLabel);
		thePanel9.add(hosButton);
		imageLabel3.add(thePanel9);
 		

	    thePanel11 = new JPanel();
	    thePanel11.setBounds(0,70,1366,60);
	    thePanel11.setBackground(Color.white);
	    menuLabel = new JLabel("MENU");
	    thePanel11.setBackground( Color.LIGHT_GRAY );
	  menuLabel.setBounds(400,70,800,50);
	    menuLabel.setFont(new Font("ALGERIAN",Font.BOLD,50)); 
	    thePanel11.add(menuLabel);
	    imageLabel3.add(thePanel11);
		
		homeButton = new JButton("HOME");
		homeButton.setBounds(100,650,150,30);
		homeButton.setFocusPainted(true);
		homeButton.setBorderPainted(true);
		 
		logButton = new JButton("LogOut");
		logButton.setBounds(800,650,150,30);
		logButton.setFocusPainted(true);
		logButton.setBorderPainted(true);
		 
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(1000,650,150,30);
		cancelButton.setFocusPainted(true);
		cancelButton.setBorderPainted(true);
		
		imageLabel3.add(homeButton);
		imageLabel3.add(cancelButton);
		imageLabel3.add(logButton);
		imageLabel3.add(thePanel);
		theFrame.setVisible(true);	
/*	  
	 
	 JButton regButton,disButton , showregButton,showdisButton,
	 inButton,outButton,docButton, staffButton,hosButton,
	 homeButton, logButton,cancelButton;
*/
		 ListenForButton lForButton = new ListenForButton();
		 regButton.addActionListener(lForButton);
		 disButton.addActionListener(lForButton);
		 showregButton.addActionListener(lForButton);
		  showdisButton.addActionListener(lForButton);
		  inButton.addActionListener(lForButton);
		  outButton.addActionListener(lForButton);
		  docButton.addActionListener(lForButton);
		  staffButton.addActionListener(lForButton);
		  hosButton.addActionListener(lForButton);
		  homeButton.addActionListener(lForButton);
		  cancelButton.addActionListener(lForButton);
		  logButton.addActionListener(lForButton);
	}//Constructor closed
	public class ListenForButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
		

			if(e.getSource() == regButton){
				new Registration();
				theFrame.setVisible(false);	
			}//if loop regButton closed
			
			else if(e.getSource() == disButton){
				new Discharge();
				theFrame.setVisible(false);
			}// if loop of discharge Button closed
		

			else if(e.getSource() == showregButton){
				new ShowRegistration();
				theFrame.setVisible(true);
			}// if loop of show registration Button closed
			
			
			else if(e.getSource() == showdisButton){
				new ShowDischarge();
				theFrame.setVisible(true);
			}// if loop of show discharge Button closed
			 		

			else if(e.getSource() == inButton){
				new InPatient();
				theFrame.setVisible(false);
			}// if loop of in Button closed
			
			else if(e.getSource() == outButton){
				new OutPatient();
				theFrame.setVisible(false);
			}// if loop of discharge Button closed
			
			else if(e.getSource() == staffButton){
				new Staff();
				theFrame.setVisible(false);
			}// if loop of discharge Button closed
		
			else if(e.getSource() == hosButton){
				new Hospital();
				theFrame.setVisible(false);
			}// if loop of discharge Button closed
			

			else if(e.getSource() == docButton){
				new Doctor();
				theFrame.setVisible(false);
			}// if loop of discharge Button closed
				

			else if(e.getSource() == homeButton){
				 new Mobile();
				 theFrame.setVisible(false);
			}// if loop of discharge Button closed
			
			else if(e.getSource() == cancelButton){
				 System.exit(0);
			}// if loop of discharge Button closed
				
			else if(e.getSource() == logButton){
				new LoginForm();
				 theFrame.setVisible(false);
			}// if loop of discharge Button closed
			
			
		}//Action Performed closed
	}//Action Listener closed
	
}//Main class Closed

 
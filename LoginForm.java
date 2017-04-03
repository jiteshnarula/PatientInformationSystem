import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class LoginForm extends JFrame{
	static JLabel imageLabel,imageLabel2,newLabel,titleLabel;
	static JLabel usrLabel,passLabel,fogLabel;
	//static JLabel forgotPassLabel;
	static JTextField usrField;
	 private JPasswordField passField;
	static JButton logButton,cancelButton;
	JFrame theFrame;
	
	public static void main(String args[]){
		new LoginForm();
	}
	
	public LoginForm(){
		 theFrame = new JFrame();
		JPanel thePanel = new JPanel();
		theFrame.setSize(1369,769);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//thePanel.setBackground(Color.BLUE);
		thePanel.setLayout(null);
		imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\11.png")));
		imageLabel.setBounds(15,0,1500,1400);
		
		titleLabel = new JLabel("Patient Information System");
  		
		titleLabel.setBounds(0,-70,2000,200);
		 titleLabel.setFont(new Font("Algerian",Font.BOLD,70));
	       //	titleLabel.setForeground(Color.red);
		
	 	JPanel thePanel2 = new JPanel();
	 	
  		thePanel2.setLayout(null);
  		thePanel2.setBounds(750,200,500,200);
	
  		usrLabel = new JLabel("Username");
  		usrLabel.setFont(new Font("Times New Roman",Font.BOLD,22));
		usrField = new JTextField("",16);
		passLabel = new JLabel("Password");
		passField  =new JPasswordField();
		logButton = new JButton("Login",new ImageIcon(ClassLoader.getSystemResource("images\\Login.png")));
		cancelButton = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.png")));
		fogLabel = new JLabel("Forget Password");
		
		
		 thePanel2.setBackground(Color.white);
		 usrLabel.setBounds(190, 30, 100, 25);
		 usrField.setBounds(310, 30, 160, 25);
		 passLabel.setBounds(190, 65, 100, 25);
         passField.setBounds(310, 65, 160, 25);
         logButton.setBounds(220, 130, 100, 25);
         cancelButton.setBounds(350, 130, 100, 25);
		
        usrLabel.setFont(new Font("monospaced", Font.BOLD, 16));
       passLabel.setFont(new Font("monospaced", Font.BOLD, 16));
       usrField.setFont(new Font("monospaced", Font.CENTER_BASELINE, 16));
       passField.setFont(new Font("monospaced", Font.CENTER_BASELINE, 16));
		
       thePanel2.add(usrLabel);
        thePanel2.add(usrField);
       thePanel2.add(passLabel);
        thePanel2.add(passField);
        thePanel2.add(logButton);
        thePanel2.add(cancelButton);
        
       JPanel thePanel3 = new JPanel();
       thePanel2.setBackground(Color.gray);
       thePanel3.setLayout(null);
        thePanel3.setBounds(20, 20, 150, 150);
       JLabel imageLabel2 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\100.png"))); 
      imageLabel2.setBounds(1, 1, 150, 150);
       
       thePanel3.add(imageLabel2);
       thePanel2.add(thePanel3);
       
		imageLabel.add(thePanel2);
		imageLabel.add(titleLabel);
	    
		thePanel.add(imageLabel);
		theFrame.add(thePanel);
		theFrame.setVisible(true);
		
		ListenForButton lForButton = new ListenForButton();
		logButton.addActionListener(lForButton);
		cancelButton.addActionListener(lForButton);
	}//constructor login form closed
	
	public class ListenForButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource() == logButton){
				String username = usrField.getText();
				String password = passField.getText();
				String SQL;
				
	SQL = "SELECT * FROM users WHERE username='" + username + "'  AND password='" +password +"'";
	 try {
		 Connection con=null;
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 con = DriverManager.getConnection("jdbc:mysql://localhost/patientmanagement","root","00213513");
  Statement stmt = con.createStatement();
	 stmt.execute(SQL);
	  ResultSet rs = stmt.getResultSet();
 boolean recordfound = rs.next();
 if (recordfound) {
	 new Main();
	 theFrame.setVisible(false);
   } else {
 JOptionPane.showMessageDialog(null, "The system could not log you in.\n" +
			        " Please make sure your username and password are correct", "Login Failure", JOptionPane.INFORMATION_MESSAGE);
   usrField.setText("");
		 passField.setText("");
    usrField.requestFocus();
		   }
	   } catch (Exception ex) {
 JOptionPane.showMessageDialog(null, "Error on login operation", "Login Error", JOptionPane.ERROR_MESSAGE);
			   }//try catch closed
				
	}//log Button closed
			if(e.getSource() == cancelButton){
				new Mobile();
				theFrame.setVisible(false);
			}//cancel Button closed
			
		}//action event closed
	}//actionListener closed
}//main login form closed
//main screen is closed
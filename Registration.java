//Registration
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Registration extends JFrame{
	
	JLabel titleLabel,regLabel,nameLabel,ageLabel,sexLabel,
	dobLabel,bloodLabel,phoneNumLabel,addressLabel,
	emailLabel,admissionDate,menuLabel,bedLabel,patientLabel,imageLabel;
	JComboBox comboBox1,comboBox2,patientCombo;
	JTextField regField,nameField,ageField,genderField,
	dobField,bloodField,phoneNumField,addressField,
	emailField,admissionField,bedField;
	JButton cancelButton,submitButton,resetButton,homeButton;
	JFrame theFrame;
	JPanel thePanel;
	 

	public static void main(String args[]){
		new Registration();
	}//static void main closed
	
	public Registration(){
		
		 theFrame = new JFrame("Patient Registeration");
		 theFrame.setSize(1000,700);
		 theFrame.setLocationRelativeTo(null);
		 theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 theFrame.setLayout(null);
		
		 thePanel = new JPanel();
		 thePanel.setBackground(Color.white);
		 thePanel.setBounds(-200,0,1200,900);
		 thePanel.setLayout(null); 
		 titleLabel = new JLabel("Patient Registration");
		 imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\54.png")));
		 imageLabel.setBounds(250,0,500,100);
		 titleLabel.setBounds(565,0,700,80);
		 titleLabel.setFont(new Font("Times New Roman",Font.BOLD,52));
		 thePanel.add(titleLabel);
		 thePanel.add(imageLabel);
	
		    
		regLabel = new JLabel("Patient Registering Number");
		regLabel.setBounds(400,100,300,100);
		
		regField = new JTextField("",15);
		regField.setBounds(700,135,300,30);
		
		nameLabel = new JLabel("Patient Name");
		nameLabel.setBounds(400,140,300,100);
		
		nameField = new JTextField("",15);
		nameField.setBounds(700,175,300,30);
		 	 
	 	
	 	sexLabel = new JLabel("Gender");
	 	sexLabel.setBounds(400,220,300,100);
		 
		 String[] str = {"M","F"};
		comboBox1 = new JComboBox(str);
		comboBox1.setBounds(700,255,300,30);
		
		dobLabel = new JLabel("Date Of Birth");
		dobLabel.setBounds(400,260,300,100);
		
		dobField = new JTextField("YYYY/MM/DD",15);
		dobField.setBounds(700,295,300,30);
		
	 	
		bloodLabel = new JLabel("Blood Group");
		bloodLabel.setBounds(400,300,300,100);
		
		String[] str1 = {"A+","O+","B+","AB+","A-","O-","B-","AB-"}; 
		comboBox2 = new JComboBox(str1);
		comboBox2.setBounds(700,335,300,30);
			
		 
 phoneNumLabel = new JLabel("Phone Number");
 phoneNumLabel.setBounds(400,345,300,100);
	
 phoneNumField = new JTextField("",15);
 phoneNumField.setBounds(700,375,300,30);
 
addressLabel = new JLabel("Address");
addressLabel.setBounds(400,380,300,100);
	 	
addressField = new JTextField("",15); 	 	
addressField.setBounds(700,415,300,30);

emailLabel = new JLabel("Email");
emailLabel.setBounds(400,420,300,100);
	 	
emailField = new JTextField("",15);
emailField.setBounds(700,450,300,30);

	 	admissionDate = new JLabel("Admission Date");
	 	admissionDate.setBounds(400,460,300,100);
	 	
	 	admissionField = new JTextField("YYYY/MM/DD",15);
	 	admissionField.setBounds(700,490,300,30);
	 	
	 	bedLabel = new JLabel("Bed Number");
	 	bedLabel.setBounds(400,495,300,100);
	 	
	 	bedField = new JTextField("",15);
	 	bedField.setBounds(700,535,300,30);
	 	
	 	patientLabel = new JLabel("Patient Type");
	 	patientLabel.setBounds(400,540,300,100);
	 	
	 	String[] str2 = {"InPatient","OutPatient"}; 
		patientCombo = new JComboBox(str2);
		patientCombo.setBounds(700,575,300,30);
		
	 	submitButton=new JButton("Submit");
	 	submitButton.setBounds(600,620,153,30);
	 	submitButton.setFocusPainted(true);
		submitButton.setBorderPainted(true);
		 
		resetButton = new JButton("Reset");
		 resetButton.setBounds(800,620,153,30);
		 resetButton.setFocusPainted(true);
		resetButton.setBorderPainted(true); 	 
		
		cancelButton=new JButton("Back");
		cancelButton.setBounds(1000,620,153,30);
		cancelButton.setFocusPainted(true);
		cancelButton.setBorderPainted(true); 	
	 	
		homeButton=new JButton("Home");
	 	homeButton.setBounds(400,620,153,30);
	 	homeButton.setFocusPainted(true);
		homeButton.setBorderPainted(true);
	
	 	thePanel.add(comboBox1);
		thePanel.add(sexLabel);
	 	  thePanel.add(nameField);
		thePanel.add(nameLabel); 
		thePanel.add(regField);
		thePanel.add(regLabel); 
		   
		 thePanel.add(dobLabel);
		thePanel.add(dobField);
		thePanel.add(bloodLabel);
		thePanel.add(comboBox2);
		thePanel.add(phoneNumLabel);
		thePanel.add(phoneNumField);
		thePanel.add(addressLabel);
		thePanel.add(addressField);
		thePanel.add(emailLabel);
		thePanel.add(emailField);
		thePanel.add(admissionDate);
		thePanel.add(admissionField);
		thePanel.add(bedLabel);
		thePanel.add(bedField);
		thePanel.add(patientLabel);
		thePanel.add(patientCombo);
			
			
			thePanel.add(cancelButton);
			thePanel.add(submitButton);
			thePanel.add(resetButton);
			thePanel.add(homeButton);
		 
		
		
		
		 theFrame.add(thePanel);
		 theFrame.setVisible(true);
		 
		   ListenForButton lForButton = new ListenForButton();
			submitButton.addActionListener(lForButton);
			cancelButton.addActionListener(lForButton);
			resetButton.addActionListener(lForButton);
			homeButton.addActionListener(lForButton);
	}
	public class  ListenForButton implements ActionListener{
		Connection con;
		String dburl ="jdbc:mysql://localhost/patientmanagement";
		String pass = "00213513";
		String user ="root";
		String str="com.mysql.jdbc.Driver";
		
		
		
public void actionPerformed(ActionEvent e){
if(e.getSource() == submitButton){

if(regField.getText()==null || regField.getText().toString().equals(" ")||bedField.getText()==null || bedField.getText().toString().equals("")
||nameField==null || nameField.getText().toString().equals("")
//||ageField.getText().toString() == null || ageField.getText().toString().equals("")
||dobField.getText().toString()==null || dobField.getText().toString().equals("")
||phoneNumField.getText().toString() ==null || phoneNumField.getText().toString().equals("")
||addressField.getText().toString() ==null || addressField.getText().toString().equals("")
||emailField.getText().toString() ==null || emailField.getText().toString().equals("")
||admissionDate.getText().toString() ==null || admissionDate.getText().toString().equals("")){
	JOptionPane.showMessageDialog(null,"Required Field must not be blank");
	
}
 


try{
	  Class.forName(str);
		System.out.println("Connecting to a selected database...");
	con = DriverManager.getConnection(dburl, user, pass);

	if(!nameField.getText().matches("^[A-Za-z\\s]+$")){
		JOptionPane.showMessageDialog(null,"Patient name must be of character type");
		con.close();}
	 
	if(!phoneNumField.getText().matches("\\d{10}")){
		JOptionPane.showMessageDialog(null,"Phone Number must contain 10 digit");
		con.close();}
	if(!emailField.getText().matches( "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")){
		JOptionPane.showMessageDialog(null,"Please check your Email I'd");
		con.close();
	}
	

	PreparedStatement ps=con.prepareStatement("insert into registration(PatientName,Gender,DOB,EMail,PhoneNumber,Address,BloodGroup,AdmissionDate,PatientType,BedNum,RegNumber) values( ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
	//RegNumber,PatientName,Age,Gender,DOB,EMail,PhoneNumber,Address,BloodGroup,AdmissionDate

	
	ps.setString(1, nameField.getText());
	//ps.setString(2, ageField.getText());
	ps.setString(2, comboBox1.getSelectedItem().toString());
	ps.setString(3, dobField.getText());
	ps.setString(4, emailField.getText());
	ps.setString(5, phoneNumField.getText());
	ps.setString(6, addressField.getText());
	ps.setString(7, comboBox2.getSelectedItem().toString());
	ps.setString(8, admissionField.getText());
	ps.setString(9,patientCombo.getSelectedItem().toString());
	ps.setString(10, bedField.getText());
	ps.setString(11, regField.getText());
	ps.executeUpdate();

	JOptionPane.showMessageDialog(null,"Record Insert Successfully");
	}catch(MySQLNonTransientConnectionException e4){
    	System.out.println("Connection Closed");
    }
catch(Exception ex){
	    System.out.println("Error is :: "+ ex) ;
	   
	 
	    if (ex instanceof SQLIntegrityConstraintViolationException) 
	    JOptionPane.showMessageDialog(null,"RegistrationID and Bed Number already existing","DuplicateField",JOptionPane.ERROR_MESSAGE);
	    
	    else{
	    	 JOptionPane.showMessageDialog(null,"please check date format","Worng Format",JOptionPane.ERROR_MESSAGE);
	    			}
	    	
				} //catch block closed
			}//if submit button
if(e.getSource() == resetButton){
 	
	/*
regField,nameField,ageField,genderField,
dobField,bloodField,phoneNumField,addressField,
emailField,admissionField;
*/
	regField.setText("");
	nameField.setText("");
	 
	dobField.setText("YYYY/MM/DD");
	phoneNumField.setText("");
	addressField.setText("");
	emailField.setText("");
	admissionField.setText("YYYY/MM/DD");
	bedField.setText("");
}
if(e.getSource() == cancelButton){
	new Main();
  theFrame.setVisible(false);
		}

if(e.getSource() == homeButton){
	new Mobile();
	theFrame.setVisible(false);
}
 
		}//action performed
	}//action Listener
}//main
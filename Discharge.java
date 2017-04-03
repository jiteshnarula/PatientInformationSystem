import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

 

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Discharge extends JFrame{
	JLabel  regLabel,nameLabel,admissionLabel,
	dischargeLabel,diseasesLabel,roomLabel,
	medicineLabel,operationLabel,doctorLabel,
	totalLabel,menuLabel,dumyLabel,titleLabel,imageLabel,typeLabel;
	JTextField  nameField,admissionField,
	dischargeField,diseasesField,roomField,
	medicineField,operationField,doctorField,
	totalField,regField,typeField;
	JButton cancelButton,submitButton,resetButton,homeButton,goButton,calculateButton;
	JComboBox regCombo;
	
	String dburl ="jdbc:mysql://localhost/patientmanagement";
	String pass = "00213513";
	String user ="root";
	String str="com.mysql.jdbc.Driver";
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	JFrame theFrame;
	JPanel thePanel;
	
	public static void main(String args[]){
		new Discharge();	
	}//static void main closed
	
	public Discharge(){
		 theFrame = new JFrame("Patient Discharge Form");
		 theFrame.setSize(1000,660);
		 theFrame.setLocationRelativeTo(null);
		 theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 theFrame.setLayout(null);
		 
		 thePanel = new JPanel();
		 thePanel.setBackground(Color.white);
		 thePanel.setBounds(-200,0,1200,900);
		 thePanel.setLayout(null); 
		 titleLabel = new JLabel("Patient Discharge");
		 imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\58.png")));
		 imageLabel.setBounds(250,0,500,100);
		 titleLabel.setBounds(565,0,700,80);
		 titleLabel.setFont(new Font("Times New Roman",Font.BOLD,52));
		 thePanel.add(titleLabel);
		 thePanel.add(imageLabel);
		 
		    regLabel = new JLabel("Patient Registering Number");
			regLabel.setBounds(400,100,300,100);
			
			
			
			regCombo = new JComboBox();
			regCombo.setBounds(700,135,300,30);
			
			goButton = new JButton("Go");
			goButton.setBounds(1050,135,50,30);
			
			nameLabel = new JLabel("Patient Name");
			nameLabel.setBounds(400,140,300,100);
			
			nameField = new JTextField("",15);
			nameField.setBounds(700,175,300,30);
			nameField.setEditable(false);
			
			admissionLabel = new JLabel("Admission Date");
			admissionLabel.setBounds(400,180,300,100);
		 	
			
			admissionField = new JTextField("YYYY/MM/DD",15);
			admissionField.setBounds(700,215,300,30);
		 	admissionField.setEditable(false);
		
		 	typeLabel = new JLabel("Patient Type");
		 	typeLabel.setBounds(400,220,300,100);
			
		 	typeField = new JTextField("",15);
		 	typeField.setBounds(700,255,300,30);
			typeField.setEditable(false);
		 			
			dischargeLabel = new JLabel("Discharge Date");
			dischargeLabel.setBounds(400,260,300,100);
			 
			dischargeField = new JTextField("YYYY/MM/DD",15);
			dischargeField.setBounds(700,295,300,30);
			
			diseasesLabel = new JLabel("Diseases");
			diseasesLabel.setBounds(400,300,300,100);
			
			 diseasesField = new JTextField("",15);
			 diseasesField.setBounds(700,335,300,30);
			
		 	
			 roomLabel = new JLabel("Room Charges");
			 roomLabel.setBounds(400,345,300,100);
			
			 roomField = new JTextField("",15);
			 roomField.setBounds(700,375,300,30);
				
			 
			 medicineLabel = new JLabel("Medicine Charges");
			 medicineLabel .setBounds(400,380,300,100);
		
			 medicineField = new JTextField("",15);
			 medicineField.setBounds(700,415,300,30);
	 
			 operationLabel = new JLabel("Operation/Testing Charges");
			 operationLabel.setBounds(400,420,300,100);
		 	
	operationField = new JTextField("",15); 	 	
	operationField.setBounds(700,450,300,30);

	doctorLabel = new JLabel("Doctor Charges");
	doctorLabel.setBounds(400,460,300,100);
		 	
	doctorField = new JTextField("",15);
	doctorField.setBounds(700,490,300,30);

	totalLabel = new JLabel("Total Charges");
	totalLabel.setBounds(400,495,300,100);
		 	
	totalField = new JTextField("",15); 
	totalField.setBounds(700,530,300,30);
	totalField.setEditable(false);
	
	calculateButton = new JButton("Calculate");
	calculateButton.setBounds(1050,490,90,30);
	
	
	submitButton=new JButton("Submit");
	submitButton.setBounds(600,580,153,30);
		 	
	 resetButton = new JButton("Reset");
	 resetButton.setBounds(800,580,153,30);
		 	
	 cancelButton=new JButton("Back");
	 cancelButton.setBounds(1000,580,153,30);
		 	
		homeButton=new JButton("Home");
	 	homeButton.setBounds(400,580,153,30);
	 	
	 	thePanel.add(typeLabel);
	 	thePanel.add(typeField);
	 	thePanel.add(calculateButton);
	 	thePanel.add(goButton);
		thePanel.add(titleLabel);
		thePanel.add(regLabel);
		thePanel.add(regCombo);
		thePanel.add(nameLabel);
		thePanel.add(nameField);
		thePanel.add(admissionLabel);
		thePanel.add(admissionField);
		thePanel.add(dischargeLabel);
		thePanel.add(dischargeField);
		thePanel.add(diseasesLabel);
		thePanel.add(diseasesField);
		thePanel.add(roomLabel);
		thePanel.add(roomField);
		thePanel.add(medicineLabel);
		thePanel.add(medicineField);
		thePanel.add(operationLabel);
		thePanel.add(operationField);
		thePanel.add(doctorLabel);
		thePanel.add(doctorField);
		thePanel.add(totalLabel);
		thePanel.add(totalField);
		thePanel.add(cancelButton);
		thePanel.add(submitButton);
		thePanel.add(resetButton);
		thePanel.add(homeButton);
		 
		 theFrame.add(thePanel);
		 theFrame.setVisible(true);
		 
		 try{
				String	sql="SELECT *  FROM  registration";
					Class.forName(str);
					System.out.println("Connecting to a selected database...");
					con = DriverManager.getConnection(dburl, user, pass);
					
					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					//PreparedStatement ps=con.prepareStatement();
				 	//RegNumber,PatientName,Age,Gender,DOB,EMail,PhoneNumber,Address,BloodGroup,AdmissionDate
					while (rs.next()){
					    String m1= rs.getString("RegNumber");
				 	 regCombo.addItem(m1);
					//JOptionPane.showMessageDialog(null,"Record Insert Successfully");
					}
					 //String selectedCombo = regCombo.getSelectedItem().toString();
				
				}catch(Exception ex1){
				System.out.println(""+ex1);
				}	
		 
		  ListenForButton lForButton = new ListenForButton();
			submitButton.addActionListener(lForButton);
			cancelButton.addActionListener(lForButton);
			resetButton.addActionListener(lForButton);
			homeButton.addActionListener(lForButton);
			goButton.addActionListener(lForButton);
			calculateButton.addActionListener(lForButton);
	}//discharge Constructor closed
	public class ListenForButton implements ActionListener{
	
		
		public void actionPerformed(ActionEvent e){
	
			if (e.getSource() == goButton){
				if(roomField.getText().matches("^[A-Za-z\\s]+$")||medicineField.getText().matches("^[A-Za-z\\s]+$")||operationField.getText().matches("^[A-Za-z\\s]+$")||doctorField.getText().matches("^[A-Za-z\\s]+$")){
					JOptionPane.showMessageDialog(null,"Charges must be of integer type");
					}
				try {
				 
					 String sql = "SELECT PatientName,AdmissionDate,PatientType FROM registration WHERE RegNumber =?";
				        pst=con.prepareStatement(sql);
				    	
				        pst.setString(1,regCombo.getSelectedItem().toString());
				        rs = pst.executeQuery();
				    if(rs.next()) { 
				        String ID = rs.getString("PatientName");
				        nameField.setText(ID);
				        String FN = rs.getString("AdmissionDate");
				        admissionField.setText(FN);
				        String LN = rs.getString("PatientType");
				        typeField.setText(LN);
				    
				    }
				    } 
			
				catch (SQLException ex ) {
				    JOptionPane.showMessageDialog(null,"Connection Has Been Closed Please Restart Application");
				}
				
			}//go Button closed
			
			if(e.getSource() == calculateButton)
			{ 
				
				if( roomField.getText() == null || roomField.getText().toString().equals("")
						||operationField.getText() == null ||operationField.getText().toString().equals("")
						||doctorField.getText() == null || doctorField.getText().toString().equals("")
						||medicineField.getText() == null || medicineField.getText().toString().equals("")){
					 JOptionPane.showMessageDialog(null,"Required Field must not be empty ");
					 
				}
				
				if(roomField.getText().matches("^[A-Za-z\\s]+$")||medicineField.getText().matches("^[A-Za-z\\s]+$")||operationField.getText().matches("^[A-Za-z\\s]+$")||doctorField.getText().matches("^[A-Za-z\\s]+$")){
					JOptionPane.showMessageDialog(null,"Charges must be of integer type");
				}
				try{
				
				int medicineCharges= Integer.parseInt(medicineField.getText());
			 	int roomCharges = Integer.parseInt(roomField.getText());
			 	int  OTCharges=Integer.parseInt(operationField.getText());
			 	int  DoctorCharges=Integer.parseInt(doctorField.getText());
					 
					
					int total = medicineCharges+roomCharges+OTCharges+DoctorCharges;
			 		
					String n = String.valueOf(total);
				 	System.out.println("Answer :"+n); 
					totalField.setText(n);
				}	catch(NumberFormatException e2){
					JOptionPane.showMessageDialog(null,"charges must be of integer type");
				}
				}
			
			if(e.getSource() == submitButton){
				
				
			 	if( roomField.getText() == null || roomField.getText().toString().equals("")
||operationField.getText() == null ||operationField.getText().toString().equals("")
||doctorField.getText() == null || doctorField.getText().toString().equals("")
||medicineField.getText() == null || medicineField.getText().toString().equals("")
||diseasesField.getText() ==null || diseasesField.getText().equals("")
||dischargeField.getText() ==null || dischargeField.getText().equals("")
||nameField.getText() == null || nameField.getText().toString().equals("")
||totalField.getText() == null || totalField.getText().toString().equals("")	
		){
JOptionPane.showMessageDialog(null,"Required Field must not be blank");
}
				
				try{
					Class.forName(str);
					System.out.println("Connecting to a selected database...");
					con = DriverManager.getConnection(dburl, user, pass);
					if(!diseasesField.getText().matches("^[A-Za-z\\s]+$")){
						JOptionPane.showMessageDialog(null,"Diseases name must be of character type");
						con.close();}
					if(roomField.getText().matches("^[A-Za-z\\s]+$")||medicineField.getText().matches("^[A-Za-z\\s]+$")||operationField.getText().matches("^[A-Za-z\\s]+$")||doctorField.getText().matches("^[A-Za-z\\s]+$")){
						JOptionPane.showMessageDialog(null,"Charges must be of integer type");
						con.close();}
					
					PreparedStatement ps=con.prepareStatement("insert into discharge(DischargeDate,Diseases,medicineCharges,roomCharges,OTCharges,DoctorCharges,Totalcharges,RegNum,Name,AdmissionDate,PatientType) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
				 
					
					String DischargeDate=dischargeField.getText();
					String Diseases=diseasesField.getText();
					int medicineCharges= Integer.parseInt(medicineField.getText());
				 	int roomCharges = Integer.parseInt(roomField.getText());
				 	int  OTCharges=Integer.parseInt(operationField.getText());
				 	int  DoctorCharges=Integer.parseInt(doctorField.getText());
				 	 //RegNum,Name,AdmissionDate
				 	String RegNum = regCombo.getSelectedItem().toString();
				 	String Name = nameField.getText();
				 	String AdmissionDate = admissionField.getText();
				 	String PatientType = typeField.getText();
				 	//RegNumber,PatientName,Age,Gender,DOB,EMail,PhoneNumber,Address,BloodGroup,AdmissionDate

				 	if(PatientType.equals("OutPatient")){
				 		if(!AdmissionDate.equals(DischargeDate)){
				 			JOptionPane.showMessageDialog(null, "For OutPatient both Admission Date and Discharge Date are equal");
				 			con.close();
				 		}
				 	}
				 	 
				 	
					ps.setString(1, DischargeDate);
					ps.setString(2, Diseases);
					ps.setInt(3, medicineCharges);
					ps.setInt(4, roomCharges);
					ps.setInt(5, OTCharges);
					ps.setInt(6, DoctorCharges);
					ps.setString(7, totalField.getText());
					
				 	 //RegNum,Name,AdmissionDate
					
					ps.setString(8, RegNum);
					ps.setString(9, Name);
					ps.setString(10, AdmissionDate);
					ps.setString(11, PatientType);
					
					
					ps.executeUpdate();
				 

					JOptionPane.showMessageDialog(null,"Patient Has Been Succesfully Discharged");
					}
				catch(java.sql.SQLException e3){
				JOptionPane.showMessageDialog(null,"connection has been closed");
				}
				catch(Exception ex){ 
					    System.out.println("Error is :: "+ ex);
					    if (ex instanceof SQLIntegrityConstraintViolationException) 
				    	    JOptionPane.showMessageDialog(null,"Patient has already been discharged","DuplicateField",JOptionPane.ERROR_MESSAGE);
					     else
					    JOptionPane.showMessageDialog(null,"please check date format","Worng Format",JOptionPane.ERROR_MESSAGE);
					     	
					     	 
					}//catch block
			 }//submit Button closed
 if(e.getSource() == resetButton){
				 
				 nameField.setText("");
				 admissionField.setText("YYYY/MM/DD");
				 dischargeField.setText("YYYY/MM/DD");
				 diseasesField.setText("");
				 roomField.setText("");
				 medicineField.setText("");
				 operationField.setText("");
				 doctorField.setText("");
				 
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
	}//action listener
}//main discharge closed
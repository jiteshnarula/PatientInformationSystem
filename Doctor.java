import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Doctor extends JFrame{
	JLabel listLabel,idLabel,nameLabel,sexLabel,deptLabel,phoneLabel,
	imageLabel,timeLabel,srchNameLabel,srchIdLabel,srchdeptLabel,menuLabel
	,srchnameLabel;
	JTextField idField,nameField,sexField,deptField,phoneField,
	timeField,srchNameField,srchIdField,srchnameField;
	JButton showButton2,showButton1,srchButton2,cancelButton,resetButton,homeButton;
 	JFrame theFrame;
	JPanel thePanel;
	 

	public static void main(String args[]){
		new Doctor();	
	}//static void main closed
			
		public Doctor(){
		 theFrame.setDefaultLookAndFeelDecorated(true);
	 	 theFrame = new JFrame("Doctor's Detail");
		 theFrame.setSize(1000,660);
		 theFrame.setLocationRelativeTo(null);
		 theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 theFrame.setLayout(null);
	 
		 thePanel = new JPanel();
		 thePanel.setBackground(Color.white);
		 thePanel.setBounds(-200,0,1200,900);
		 thePanel.setLayout(null); 
	
		 menuLabel = new JLabel("DOCTORS INFORMATION");
		 imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\44.png")));
		 imageLabel.setBounds(40,0,800,150);
		 menuLabel.setBounds(500,0,700,80);
		 menuLabel.setFont(new Font("Times New Roman",Font.BOLD,52));
		 thePanel.add(menuLabel);
		 thePanel.add(imageLabel);
		  				  
		 listLabel = new JLabel("Show List Of Doctors");
		 listLabel.setBounds(400,100,300,100);
		 					
		 showButton1 = new JButton("Show");
		showButton1.setBounds(800,135,100,30);
		 
		srchIdLabel = new JLabel("Search By Doctor ID");
		srchIdLabel.setBounds(400,140,300,100);
							
		srchIdField = new JTextField("",15);
		srchIdField.setBounds(700,175,300,30);
							 
		srchButton2 = new JButton("Search");
		srchButton2.setBounds(1050,175,90,30);
			
		idLabel = new JLabel("DoctorID");
		idLabel.setBounds(400,180,300,100);
						 	
							
	    idField = new JTextField("",15);
		idField.setBounds(700,215,300,30);
		idField.setEditable(false);
						
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(400,220,300,100);
							
		nameField = new JTextField("",15);
		nameField.setBounds(700,255,300,30);
		nameField.setEditable(false);
	 		
	 		

				 			
		sexLabel = new JLabel("Sex");
         sexLabel.setBounds(400,260,300,100);
							 
	sexField = new JTextField("",15); 
	sexField.setBounds(700,295,300,30);
	sexField.setEditable(false);
	
	
	deptLabel = new JLabel("Specialization/Department");
	deptLabel.setBounds(400,300,300,100);
							
	deptField = new JTextField("",15); 
	deptField.setBounds(700,335,300,30);
	deptField.setEditable(false);
							
	 		
	phoneLabel = new JLabel("Phone Number");
	phoneLabel.setBounds(400,345,300,100);
							
	phoneField = new JTextField("",15);
	phoneField.setBounds(700,375,300,30);
	phoneField.setEditable(false);
								
							 
	timeLabel = new JLabel("Timing");
	timeLabel .setBounds(400,380,300,100);
						
	timeField = new JTextField("HH:MM:SS",15);
	timeField.setBounds(700,415,300,30);
	timeField.setEditable(false);
	
	
	srchnameLabel = new JLabel("Search By Name");
	srchnameLabel.setBounds(400,420,300,100);
						
	srchnameField = new JTextField("",15);
	srchnameField.setBounds(700,455,300,30);
	
	showButton2 = new JButton("Show");
	showButton2.setBounds(1050,455,90,30);
						 
								 	
	resetButton = new JButton("Reset");
	resetButton.setBounds(800,580,153,30);
								 	
	cancelButton=new JButton("Back");
	cancelButton.setBounds(1000,580,153,30);
								 	
		homeButton=new JButton("Home");
	homeButton.setBounds(400,580,153,30);
 				
	thePanel.add(srchnameLabel);
	thePanel.add(srchnameField);
	
	thePanel.add(showButton2);
	thePanel.add(srchButton2);
	thePanel.add(menuLabel);
	thePanel.add(listLabel);
	 thePanel.add(showButton1);
	thePanel.add(srchIdLabel);
	thePanel.add(srchIdField);
	thePanel.add(idLabel);
	thePanel.add(idField);
	thePanel.add(nameLabel);
	thePanel.add(nameField);
	thePanel.add(sexLabel);
	thePanel.add(sexField);
	thePanel.add(deptLabel);
	thePanel.add(deptField);
	thePanel.add(phoneLabel);
	thePanel.add(phoneField);
	thePanel.add(timeLabel);
    thePanel.add(timeField);
	thePanel.add(cancelButton);
	thePanel.add(resetButton);
	thePanel.add(homeButton);
				 
	theFrame.add(thePanel);
	theFrame.setVisible(true);		
		 
	 ListenForButton lForButton = new ListenForButton();
	 	
		cancelButton.addActionListener(lForButton);
		resetButton.addActionListener(lForButton);
		homeButton.addActionListener(lForButton);
		showButton1.addActionListener(lForButton);
		srchButton2.addActionListener(lForButton);
		showButton2.addActionListener(lForButton);
 		}//doctor constructor closed
		
		public class ListenForButton implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == showButton1){
					setDefaultLookAndFeelDecorated(true);
					JFrame f5=new JFrame("List Of Doctors");
					f5.setSize(800,700);
					f5.setLocation(100,0);
					JTextField []t1=new JTextField[180];
					JPanel p5=new JPanel();
					f5.getContentPane().add(p5);
					p5.setLayout(new GridLayout(31,6));
					p5.add(new JLabel("DoctorID"));
					p5.add(new JLabel("Name"));
					p5.add(new JLabel("Sex"));
					p5.add(new JLabel("Specialization"));
					p5.add(new JLabel("PhoneNum"));
					p5.add(new JLabel("Timing"));

				for(int i=0; i<180; i++)
				{
				t1[i]=new JTextField(10);
				p5.add(t1[i]);
				}
				f5.setVisible(true);
				try
				{
				final String DB_URL ="jdbc:mysql://localhost/patientmanagement";
				Connection con ;
				   //  Database credentials
				    final String USER = "root";
				    final String PASS = "00213513";

					Class.forName("com.mysql.jdbc.Driver");
					
				con = DriverManager.getConnection(DB_URL, USER, PASS);
				 	PreparedStatement ps=con.prepareStatement("Select * from Doctor ");
					 ResultSet rs=ps.executeQuery();
						int i=0;
					while(rs.next())
					{
					 	String DoctorID=rs.getString(1);
						String Name=rs.getString(2);
						String Gender=rs.getString(3);
						String Specialization=rs.getString(4);
						String PhoneNo=rs.getString(5);
						String Timing=rs.getString(6);


						t1[i].setText(DoctorID);
						i++;
						t1[i].setText(Name);
						i++;
						t1[i].setText(Gender);
						i++;
						t1[i].setText(Specialization);
						i++;
						t1[i].setText(PhoneNo);
						i++;
						t1[i].setText(Timing);
						i++;

						}
					}
					catch(Exception ex)
					{
				JOptionPane.showMessageDialog(null,"Record Not Found ");
						}
	
					
					
				}//if loop of showButton1
				
  if(e.getSource()==showButton2)
				{
	  
				setDefaultLookAndFeelDecorated(true);
				JFrame f5=new JFrame("search By Id");
				f5.setSize(800,200);
				f5.setLocation(100,525);
				JTextField []t1=new JTextField[24];
				JPanel p5=new JPanel();
				f5.getContentPane().add(p5);
				p5.setLayout(new GridLayout(5,6));
				p5.add(new JLabel("DoctorID"));
				p5.add(new JLabel("Name"));
				p5.add(new JLabel("Gender"));
				p5.add(new JLabel("Specialization"));
				p5.add(new JLabel("PhoneNo"));
				p5.add(new JLabel("Timing"));
				 
			for(int i=0; i<24; i++)
			{
			t1[i]=new JTextField(10);
			p5.add(t1[i]);
			}
			f5.setVisible(true);
			try
			{
				final String DB_URL ="jdbc:mysql://localhost/patientmanagement";
			Connection con ;
			   //  Database credentials
			    final String USER = "root";
			    final String PASS = "00213513";


				Class.forName("com.mysql.jdbc.Driver");
				
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			if(srchnameField.getText() == null || srchnameField.getText().toString().equals("")||srchnameField.getText().toString().equals(" ")){
				  JOptionPane.showMessageDialog(null,"Required Field can't be null");
				  con.close();
			}
			
				String str1 = srchnameField.getText();
			 	PreparedStatement ps=con.prepareStatement("Select * from doctor where Name='"+str1+"'");
				 ResultSet rs=ps.executeQuery();
					int i=0;
				if(rs.next())
				{
					String DoctorID=rs.getString(1);
					String Name=rs.getString(2);
					String Gender=rs.getString(3);
					String Specialization=rs.getString(4);
					String PhoneNo=rs.getString(5);
					String Timing=rs.getString(6);


					t1[i].setText(DoctorID);
					i++;
					t1[i].setText(Name);
					i++;
					t1[i].setText(Gender);
					i++;
					t1[i].setText(Specialization);
					i++;
					t1[i].setText(PhoneNo);
					i++;
					t1[i].setText(Timing);
					i++;

					}
				else{
					JOptionPane.showMessageDialog(null, "doctor name doesn't exist ");
				
				}
				}catch(MySQLNonTransientConnectionException e3){
					JOptionPane.showMessageDialog(null,"Connection Has been closed" );
				}
			
				catch(Exception ex2)
				{
					System.out.println("error"+ex2);
					}

					
				}//showbutton2 closed		
			
  if(e.getSource() == srchButton2){
	
	  
		try
		{
	final String DB_URL ="jdbc:mysql://localhost/patientmanagement";
Connection con ;
   //  Database credentials
    final String USER = "root";
    final String PASS = "00213513";


	Class.forName("com.mysql.jdbc.Driver");
	
con = DriverManager.getConnection(DB_URL, USER, PASS);
	
if(srchIdField.getText() == null || srchIdField.getText().toString().equals("")||srchIdField.getText().toString().equals(" ")){
	  JOptionPane.showMessageDialog(null,"Required Field can't be null");
	  con.close();
}

String str=srchIdField.getText();
	PreparedStatement ps=con.prepareStatement("Select * from Doctor where DoctorID='"+str+"'");

	 ResultSet rs=ps.executeQuery();
	boolean flag=rs.next();
	if(flag)
	{
		String DoctorID=rs.getString(1);
		String Name=rs.getString(2);
		String Gender=rs.getString(3);
		String Specialization=rs.getString(4);
		String PhoneNo=rs.getString(5);
		String Timing=rs.getString(6);


		idField.setText(DoctorID);
		nameField.setText(Name);
		sexField.setText(Gender);
		deptField.setText(Specialization);
		phoneField.setText(PhoneNo);
		timeField.setText(Timing);
		
JOptionPane.showMessageDialog(null,"Record Found Successfully");
	}
	else{
		JOptionPane.showMessageDialog(null, "doctor i'd doesn't exist ");
		idField.setText("");
		sexField.setText("");
		nameField.setText("");
		deptField.setText("");
		phoneField.setText("");
		timeField.setText("");
		
		
	}
	}catch(MySQLNonTransientConnectionException e3){
		JOptionPane.showMessageDialog(null,"Connection Has been closed" );
	}
catch(Exception ex)
	{
		 System.out.println("ERROR");
	}
				
	}
  if(e.getSource() == resetButton){
	  srchnameField.setText("");
	  srchIdField.setText("");
	  idField.setText("");
		sexField.setText("");
		nameField.setText("");
		deptField.setText("");
		phoneField.setText("");
		timeField.setText("HH:MM:SS");
		  JOptionPane.showMessageDialog(null, "Fields succesfully resetted");
  }
  if(e.getSource() == cancelButton){
	  new Main();
	  theFrame.setVisible(false);
	  }
  if(e.getSource() == homeButton){
	  new Mobile();
  }
  
  
  
			}//ACTION PERFORMED
			
		}//action listener
		
}	//main doctor class closed
		
		
		
			
		
	 	
		 
		
		
		
	
		 
		 

			/* 
			 
	}//discharge Constructor closed
		
	public class ListenForButton implements ActionListener{
	
		
		public void actionPerformed(ActionEvent e){
	
			if (e.getSource() == goButton){
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
				    } catch (SQLException ex ) {
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
				
				
				int medicineCharges= Integer.parseInt(medicineField.getText());
			 	int roomCharges = Integer.parseInt(roomField.getText());
			 	int  OTCharges=Integer.parseInt(operationField.getText());
			 	int  DoctorCharges=Integer.parseInt(doctorField.getText());
					 
					
					int total = medicineCharges+roomCharges+OTCharges+DoctorCharges;
			 		
					String n = String.valueOf(total);
				 	System.out.println("Answer :"+n); 
					totalField.setText(n);
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
JOptionPane.showMessageDialog(null,"Required Field must not be empty must not be blank");
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
					 int i=1;
					 int num=100000;
					 num=num+i;
					  String sql1="Update registration Set BedNum = ? Where RegNumber = ? ";
					 PreparedStatement ps1=con.prepareStatement(sql1);		
					 String reg = regCombo.getSelectedItem().toString();
					  int m =Integer.parseInt(reg);
					 ps1.setInt(1, num);
					 ps1.setInt(2, m);
					 
					
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
					ps1.executeUpdate();
				 	

					JOptionPane.showMessageDialog(null,"Patient Has Been Succesfully Discharged  and his BedNum is deallocated");
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
				 
			 }
			}//action performed
	}//action listener
}//main discharge closed

*/


  
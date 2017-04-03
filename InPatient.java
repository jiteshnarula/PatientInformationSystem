//Registration
import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class InPatient extends JFrame{
	   
	JLabel titleLabel,regLabel,nameLabel,ageLabel,sexLabel,
	dobLabel,bloodLabel,phoneNumLabel,addressLabel,
	emailLabel,admissionDate,menuLabel,bedLabel,patientLabel,imageLabel,regLabel1,
	srchadminLabel,dateLabel,srchnameLabel;
	JComboBox comboBox1,comboBox2,patientCombo;
	JTextField regField,nameField,ageField,genderField,
	dobField,bloodField,phoneNumField,addressField,
	emailField,admissionField,bedField,regField1,sexField,bloodField1,
	srchadminField,dateField,srchnameField;
	JButton cancelButton,submitButton,resetButton,homeButton,srchButton,srchButton2,srchButton3;
	JFrame theFrame;
	JPanel thePanel,thePanel1;
	JTextField []t1=new JTextField[400];

	public static void main(String args[]){
		new InPatient();
	}//static void main closed
	
	public InPatient(){
		
		 theFrame = new JFrame("IN Patient Information ");
		 theFrame.setSize(1000,700);
		 theFrame.setLocationRelativeTo(null);
		 theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 theFrame.setLayout(null);
		
		 thePanel = new JPanel();
		 thePanel.setBackground(Color.white);
		 thePanel.setBounds(-200,0,1200,900);
		 thePanel.setLayout(null); 
		 titleLabel = new JLabel("In Patient Information ");
		 imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\53.png")));
		 imageLabel.setBounds(250,0,500,100);
		 titleLabel.setBounds(565,0,700,80);
		 titleLabel.setFont(new Font("Times New Roman",Font.BOLD,52));
		 thePanel.add(titleLabel);
		 thePanel.add(imageLabel);
		
		 
		 thePanel1 = new JPanel();
		 thePanel1.setBackground(Color.white);
		 thePanel1.setBounds(-200,0,1200,900);
		 
		    
		regLabel = new JLabel("Search By Patient Registration Number");
		regLabel.setBounds(400,100,900,100);
		regLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
		
		regField = new JTextField("",15);
		regField.setBounds(700,135,300,30);
		
		
		srchButton = new JButton("Search");
		srchButton.setBounds(1050,135,90,30);
		
		regLabel1 = new JLabel("Registering Number");
		regLabel1.setBounds(400,140,300,100);
		
		regField1 = new JTextField("",15);
		regField1.setBounds(700,175,300,30);
		regField1.setEditable(false);
		nameLabel = new JLabel("Patient Name");
		nameLabel.setBounds(400,180,900,100);
		
		nameField = new JTextField("",15);
		nameField.setBounds(700,210,300,30);
		nameField.setEditable(false); 	 
	 	
	 	sexLabel = new JLabel("Gender");
	 	sexLabel.setBounds(400,220,300,100);
		 
		sexField = new JTextField("",15);  
	 	sexField.setBounds(700,255,300,30);
		sexField.setEditable(false);
	 	
		dobLabel = new JLabel("Date Of Birth");
		dobLabel.setBounds(400,260,300,100);
		
		dobField = new JTextField("YYYY/MM/DD",15);
		dobField.setBounds(700,295,300,30);
		dobField.setEditable(false);
	 	
		bloodLabel = new JLabel("Blood Group");
		bloodLabel.setBounds(400,300,300,100);
		
		
		bloodField= new JTextField("",15); 
 		bloodField.setBounds(700,335,300,30);
		bloodField.setEditable(false);	
		 
 
  
  

	 	admissionDate = new JLabel("Admission Date");
	 	admissionDate.setBounds(400,390,300,100);
	 	
	 	admissionField = new JTextField("YYYY/MM/DD",15);
	 	admissionField.setBounds(700,420,300,30);
	 	admissionField.setEditable(false);
	 	bedLabel = new JLabel("Bed Number");
	 	bedLabel.setBounds(400,345,300,100);
	 	
	 	bedField = new JTextField("",15);
	 	bedField.setBounds(700,380,300,30);
	 	bedField.setEditable(false);
	 	
	 	srchadminLabel = new JLabel("Search By Admission Date");
	 	srchadminLabel.setBounds(400,445,300,100);
	 	srchadminLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
	 	
	 	srchadminField = new JTextField("YYYY/MM/DD",15);
	 	srchadminField.setBounds(700,480,300,30);
	 	 
	 	srchnameLabel  = new JLabel("Search By Name");
	 	srchnameLabel.setBounds(400,495,300,100);
	 	srchnameLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
	 	
	 	srchnameField = new JTextField("",15);
	 	srchnameField.setBounds(700,535,300,30);
	 	
	 	srchButton3 = new JButton("Search");
	 	srchButton3.setBounds(1050,535,90,30);
	 	
	 	
	 	srchButton2 = new JButton("Search");
	 	srchButton2.setBounds(1050,480,90,30);
	 	 
	 	resetButton = new JButton("Reset");
		 resetButton.setBounds(650,620,153,30);
		 	 
		 cancelButton=new JButton("Back");
		 cancelButton.setBounds(900,620,153,30);
		 	
	 	homeButton=new JButton("Home");
	 	homeButton.setBounds(400,620,153,30);
	 	
	thePanel.add(srchButton);
	thePanel.add(srchButton2);
	thePanel.add(srchButton3);
	
	thePanel.add(sexLabel);
		thePanel.add(sexField);
	 	  thePanel.add(nameField);
		thePanel.add(nameLabel); 
		thePanel.add(regField);
		thePanel.add(regLabel); 
		thePanel.add(regField1);
		thePanel.add(regLabel1); 
		   
		 thePanel.add(dobLabel);
		thePanel.add(dobField);
		thePanel.add(bloodLabel);
		thePanel.add(bloodField);
		 
		 thePanel.add(admissionField);
		 thePanel.add(admissionDate);
		thePanel.add(bedLabel);
		thePanel.add(bedField);
 
			
			thePanel.add(cancelButton);
			 
			thePanel.add(resetButton);
			thePanel.add(homeButton);
		 
		thePanel.add(srchadminLabel);
		thePanel.add(srchadminField);
		thePanel.add(srchnameField);
		thePanel.add(srchnameLabel);
		
		
	//	theFrame.add(thePanel1);
		 
		 theFrame.add(thePanel);
		 theFrame.setVisible(true);
		 
		   ListenForButton lForButton = new ListenForButton();
			 
			cancelButton.addActionListener(lForButton);
			resetButton.addActionListener(lForButton);
			homeButton.addActionListener(lForButton);
			srchButton.addActionListener(lForButton);
			srchButton2.addActionListener(lForButton);
			srchButton3.addActionListener(lForButton);
			}
	public class ListenForButton implements ActionListener{
		Connection con;
		String dburl ="jdbc:mysql://localhost/patientmanagement";
		String pass = "00213513";
		String user ="root";
		String str="com.mysql.jdbc.Driver";
		
		
		
public void actionPerformed(ActionEvent e){
if(e.getSource() == srchButton){


 
try{
	  Class.forName(str);
		System.out.println("Connecting to a selected database...");
	con = DriverManager.getConnection(dburl, user, pass);

	if(regField.getText()==null || regField.getText().toString().equals("")||regField.getText().toString().equals(" "))
	{
	 	JOptionPane.showMessageDialog(null,"Required Field must not be blank");
	 	 regField1.setText("");
	     nameField.setText("");
	     sexField.setText("");
	    
	     dobField.setText("");
	     bloodField.setText("");
	    
	     admissionField.setText("");

	     bedField.setText("");
	     con.close();
	}
	 
  	

	PreparedStatement ps=con.prepareStatement("select RegNumber,PatientName,Gender,DOB,BloodGroup,AdmissionDate,BedNum from registration where RegNumber = ? and PatientType = ?");
	//RegNumber,PatientName,Age,Gender,DOB,EMail,PhoneNumber,Address,BloodGroup,AdmissionDate
	 ps.setString(1,regField.getText()); 
	 ps.setString(2,"Inpatient"); 

    ResultSet  rs = ps.executeQuery();
  if(rs.next()) { 
	  //RegNumber,PatientName,Gender,DOB,BloodGroup,AdmissionDate,BedNum
      String ID = rs.getString("RegNumber");
      regField1.setText(ID);
      String FN = rs.getString("PatientName");
      nameField.setText(FN);
      String FN1 = rs.getString("Gender");
      sexField.setText(FN1);
      
      String FN2 = rs.getString("DOB");
      dobField.setText(FN2);
      String FN3 = rs.getString("BloodGroup");
      bloodField.setText(FN3);
      
      String FN4 = rs.getString("AdmissionDate");
      admissionField.setText(FN4);

      String FN5 = rs.getString("BedNum");
      bedField.setText(FN5);
      
  }
  else{
		JOptionPane.showMessageDialog(null, "Either He is OutPatient or Registration Number is not Existing ");
	      
		 regField1.setText("");
	       nameField.setText("");
	       sexField.setText("");
	      
	       dobField.setText("");
	       bloodField.setText("");
	      
	       admissionField.setText("");

	       bedField.setText("");
		
  }
	} catch(MySQLNonTransientConnectionException e4){
		JOptionPane.showMessageDialog(null, "Connection has been closed");
	}
catch(Exception ex){
	    System.out.println("Error is :: "+ ex) ;
	  	} //catch block closed
}//if search button

	if(e.getSource() == srchButton2){
	if(srchadminField.getText() == null || srchadminField.getText().toString().equals(" ")){
	 JOptionPane.showMessageDialog(null,"admission Date can't be null");	
	}
	JFrame f5=new JFrame("Search By Admission Date");
	f5.setSize(800,200);
	f5.setLocationRelativeTo(null);
	JTextField []t1=new JTextField[40];
	JPanel p5=new JPanel();
	f5.getContentPane().add(p5);
	p5.setLayout(new GridLayout(6,10));
	p5.add(new JLabel("Patient"));
	p5.add(new JLabel("Patient Name"));
	p5.add(new JLabel("Gender"));
	p5.add(new JLabel("Date Of Birth"));
	p5.add(new JLabel("Blood Group"));
	p5.add(new JLabel("Bed Number"));
	p5.add(new JLabel("EMail"));
	p5.add(new JLabel("PhoneNumber"));
for(int i=0; i<40; i++)
{
t1[i]=new JTextField(5);
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
	String str2=srchadminField.getText().toString();
 	PreparedStatement ps=con.prepareStatement("select * from registration where AdmissionDate='"+str2+"'" );

	 ResultSet rs=ps.executeQuery();
		int i=0;
	if(rs.next())
	{
		String RegNumber = rs.getString(11);
		String PatientName = rs.getString(1);
		 String Gender = rs.getString(2);
		String DateOfBirth = rs.getString(3);
		String BloodGroup = rs.getString(7);
		String BedNumber =rs.getString(10);
		String EMail = rs.getString(4);
		String PhoneNumber =rs.getString(5);
		t1[i].setText(RegNumber);
		i++;
		t1[i].setText(PatientName);
		i++;
		t1[i].setText(Gender);
		i++;
		t1[i].setText(DateOfBirth);
		i++;
		t1[i].setText(BloodGroup);
		i++;
		t1[i].setText(BedNumber);
		i++;
		t1[i].setText(EMail);
		i++;
		t1[i].setText(PhoneNumber);
		i++;
		}
	else{
		JOptionPane.showMessageDialog(null, "record doesnot found");
	}
	}
	catch(Exception ex)
	{
		System.out.println("error"+ex);
		}

}
  
 if(e.getSource() == srchButton3){
		if(srchnameField.getText() == null || srchnameField.getText().toString().equals(" ")){
			 JOptionPane.showMessageDialog(null,"Patient Name can't be null");	
			}
			JFrame f5=new JFrame("Search By Admission Date");
			f5.setSize(800,200);
			f5.setLocationRelativeTo(null);
			JTextField []t1=new JTextField[40];
			JPanel p5=new JPanel();
			f5.getContentPane().add(p5);
			p5.setLayout(new GridLayout(6,10));
			p5.add(new JLabel("Patient"));
			p5.add(new JLabel("Patient Name"));
			p5.add(new JLabel("Gender"));
			p5.add(new JLabel("Date Of Birth"));
			p5.add(new JLabel("Blood Group"));
			p5.add(new JLabel("Bed Number"));
			p5.add(new JLabel("EMail"));
			p5.add(new JLabel("PhoneNumber"));
		for(int i=0; i<40; i++)
		{
		t1[i]=new JTextField(5);
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
			String str2=srchnameField.getText().toString();
		 	PreparedStatement ps=con.prepareStatement("select * from registration where PatientName ='"+str2+"'" );

			 ResultSet rs=ps.executeQuery();
				int i=0;
			
				if(rs.next())
			{
				String RegNumber = rs.getString(11);
				String PatientName = rs.getString(1);
				 String Gender = rs.getString(2);
				String DateOfBirth = rs.getString(3);
				String BloodGroup = rs.getString(7);
				String BedNumber =rs.getString(10);
				String EMail = rs.getString(4);
				String PhoneNumber =rs.getString(5);
				t1[i].setText(RegNumber);
				i++;
				t1[i].setText(PatientName);
				i++;
				t1[i].setText(Gender);
				i++;
				t1[i].setText(DateOfBirth);
				i++;
				t1[i].setText(BloodGroup);
				i++;
				t1[i].setText(BedNumber);
				i++;
				t1[i].setText(EMail);
				i++;
				t1[i].setText(PhoneNumber);
				i++;
				}
				else{
				JOptionPane.showMessageDialog(null,"Record Doesnot Found");
			}
			}
			catch(Exception ex)
			{
				System.out.println("error"+ex);
				}

 }
 
if(e.getSource() == resetButton){
	 regField.setText("");
	regField1.setText("");
     nameField.setText("");
     sexField.setText("");
    
     dobField.setText("YYYY/MM/DD");
     bloodField.setText("");
    
     admissionField.setText("YYYY/MM/DD");
srchadminField.setText("YYYY/MM/DD");
srchnameField.setText("");
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
//Registration
import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class OutPatient extends JFrame{
	
	JLabel titleLabel,srchregLabel,nameLabel,ageLabel,sexLabel,
	dobLabel,bloodLabel,phoneNumLabel,addressLabel,
	emailLabel,admissionDate,menuLabel,bedLabel,patientLabel,imageLabel,regLabel1,
	srchadminLabel,dateLabel,srchnameLabel,srchdisLabel;
	JComboBox comboBox1,comboBox2,patientCombo;
	JTextField srchregField,nameField,ageField,genderField,
	dobField,bloodField,phoneNumField,addressField,
	emailField,admissionField,bedField,regField1,sexField,bloodField1,
	srchadminField,dateField,srchnameField,srchdisField;
	JButton cancelButton ,resetButton,homeButton,regsrchButton,dissrchButton,srchButton3,adminsrchButton,namesrchButton;
	JFrame theFrame;
	JPanel thePanel,thePanel1;
	JTextField []t1=new JTextField[400];

	public static void main(String args[]){
		new OutPatient();
	}//static void main closed
	
	public OutPatient(){
		
		 theFrame = new JFrame("Out Patient Information ");
		 theFrame.setSize(1000,600);
		 theFrame.setLocationRelativeTo(null);
		 theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 theFrame.setLayout(null);
		
		 thePanel = new JPanel();
		 thePanel.setBackground(Color.white);
		 thePanel.setBounds(-200,0,1200,900);
		 thePanel.setLayout(null); 
		 titleLabel = new JLabel("Out Information ");
		 imageLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\l.png")));
		 imageLabel.setBounds(250,0,500,140);
		 titleLabel.setBounds(565,0,700,80);
		 titleLabel.setFont(new Font("Times New Roman",Font.BOLD,52));
		 thePanel.add(titleLabel);
		 thePanel.add(imageLabel);
		
		 
		 thePanel1 = new JPanel();
		 thePanel1.setBackground(Color.white);
		 thePanel1.setBounds(-200,0,1200,900);
		 
		    
		srchregLabel = new JLabel("Search By Patient Registration Number");
		srchregLabel.setBounds(400,100,900,100);
		srchregLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
		
		srchregField = new JTextField("",15);
		srchregField.setBounds(700,135,300,30);
		
		regsrchButton = new JButton("Search");
		regsrchButton.setBounds(1050,135,90,30);
		
		 

		srchdisLabel = new JLabel("Search By Discharge Date");
		srchdisLabel.setBounds(400,200,900,100);
		srchdisLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
		
		srchdisField = new JTextField("YYYY/MM/DD",15);
		srchdisField.setBounds(700,235,300,30);
		 
		dissrchButton = new JButton("Search");
		dissrchButton.setBounds(1050,235,90,30);
	  	 
	 	srchadminLabel = new JLabel("Search By Admission Date");
	 	srchadminLabel.setBounds(400,295,300,100);
	 	srchadminLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
	 	
	 	srchadminField = new JTextField("YYYY/MM/DD",15);
	 	srchadminField.setBounds(700,330,300,30);
		
	 	adminsrchButton = new JButton("Search");
	 	adminsrchButton.setBounds(1050,330,90,30);
	 	 
	 	srchnameLabel  = new JLabel("Search By Name");
	 	srchnameLabel.setBounds(400,390,300,100);
	 	srchnameLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
	 	
	 	srchnameField = new JTextField("",15);
	 	srchnameField.setBounds(700,430,300,30);
	 	
	 	namesrchButton = new JButton("Search");
	 	namesrchButton.setBounds(1050,430,90,30);
	 	
	 
	 	resetButton = new JButton("Reset");
		 resetButton.setBounds(650,500,153,30);
		 	 
		 cancelButton=new JButton("Back");
		 cancelButton.setBounds(900,500,153,30);
		 	
	 	homeButton=new JButton("Home");
	 	homeButton.setBounds(400,500,153,30);
	 	
	 	thePanel.add(srchdisLabel);
	 	thePanel.add(srchdisField);
	 	thePanel.add(dissrchButton);
	 	
	thePanel.add(regsrchButton);
	thePanel.add(dissrchButton);
	thePanel.add(namesrchButton);
	
 		thePanel.add(srchregField);
		thePanel.add(srchregLabel); 
		    
   
			
			thePanel.add(cancelButton);
			 
			thePanel.add(resetButton);
			thePanel.add(homeButton);
		 
		thePanel.add(srchadminLabel);
		thePanel.add(srchadminField);
		thePanel.add(adminsrchButton);
		thePanel.add(srchnameField);
		thePanel.add(srchnameLabel);
		
		
	//	theFrame.add(thePanel1);
		 
		 theFrame.add(thePanel);
		 theFrame.setVisible(true);
		 
		   ListenForButton lForButton = new ListenForButton();
			 
			cancelButton.addActionListener(lForButton);
			resetButton.addActionListener(lForButton);
			homeButton.addActionListener(lForButton);
			regsrchButton.addActionListener(lForButton);
			dissrchButton.addActionListener(lForButton);
			adminsrchButton.addActionListener(lForButton);
			namesrchButton.addActionListener(lForButton);
					
	}
	public class ListenForButton implements ActionListener{
		Connection con;
		String dburl ="jdbc:mysql://localhost/patientmanagement";
		String pass = "00213513";
		String user ="root";
		String str="com.mysql.jdbc.Driver";
		
		
		
public void actionPerformed(ActionEvent e){
if(e.getSource() == regsrchButton){

setDefaultLookAndFeelDecorated(true);
JFrame f5=new JFrame("Search By Patient Registration Number");
f5.setSize(700,200);
f5.setLocation(200,500);
JTextField []t1=new JTextField[28];
JPanel p5=new JPanel();
f5.getContentPane().add(p5);
p5.setLayout(new GridLayout(5,7));
p5.add(new JLabel("Patient Registration No"));
p5.add(new JLabel("Patient Name"));
p5.add(new JLabel("Admission Date"));
p5.add(new JLabel("Discharge Date"));
p5.add(new JLabel("Diseases"));
p5.add(new JLabel("Doctor Charges"));
p5.add(new JLabel("BillingAmount"));
for(int i=0; i<28; i++)
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
if(srchregField.getText()==null || srchregField.getText().toString().equals(""))
{
 	JOptionPane.showMessageDialog(null,"Required Field must not be blank"); 	  
 	con.close();
}

	PreparedStatement ps=con.prepareStatement("Select  * from discharge where RegNum = ? && PatientType = ?");
 ps.setString(1,srchregField.getText());
 ps.setString(2,"OutPatient");

 ResultSet rs=ps.executeQuery();
	int i=0;
if(rs.next())
{
	String RegNo=rs.getString(8);
	String PatientName=rs.getString(9);
	String AddmissionDate=rs.getString(10);
	String DischargeDate=rs.getString(1);
	String Diseases=rs.getString(2);
	String DoctorCharges=rs.getString(6);
	String BillingAmount=rs.getString(7);

	t1[i].setText(RegNo);
	i++;
	t1[i].setText(PatientName);
	i++;
	t1[i].setText(AddmissionDate);
	i++;
	t1[i].setText(DischargeDate);
	i++;
	t1[i].setText(Diseases);
	i++;
	t1[i].setText(DoctorCharges);
	i++;
	t1[i].setText(BillingAmount);
	i++;

	}
else{
	JOptionPane.showMessageDialog(null, "Either Patient Registration number is not existing or He is InPatient ");
}
}catch(MySQLNonTransientConnectionException e4){
	JOptionPane.showMessageDialog(null, "Connection is closed");
}
catch(Exception ex)
{
	System.out.println("error"+ex);
	}
 
 
}//regsrchbutton closed

if(e.getSource() == adminsrchButton){
	
setDefaultLookAndFeelDecorated(true);
JFrame f5=new JFrame("Search By Admission Date");
f5.setSize(700,200);
f5.setLocationRelativeTo(null);
JTextField []t1=new JTextField[28];
JPanel p5=new JPanel();
f5.getContentPane().add(p5);
p5.setLayout(new GridLayout(5,7));
p5.add(new JLabel("Patient Registration No"));
p5.add(new JLabel("Patient Name"));
p5.add(new JLabel("Admission Date"));
p5.add(new JLabel("Discharge Date"));
p5.add(new JLabel("Diseases"));
p5.add(new JLabel("Doctor Charges"));
p5.add(new JLabel("BillingAmount"));
for(int i=0; i<28; i++)
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

if(srchadminField.getText()==null || srchadminField.getText().toString().equals("YYYY/MM/DD")||srchadminField.getText().toString().equals("")||srchadminField.getText().toString().equals(" "))
{
 	JOptionPane.showMessageDialog(null,"Required Field must not be blank"); 	  
 	con.close();
}

if(srchadminField.getText()==null || srchadminField.getText().toString().equals(""))
{
 	JOptionPane.showMessageDialog(null,"Required Field must not be blank"); 	  
 	con.close();
}

	PreparedStatement ps=con.prepareStatement("Select  * from discharge where AdmissionDate = ? && PatientType = ?");
 ps.setString(1,srchadminField.getText());
 ps.setString(2,"OutPatient");

 ResultSet rs=ps.executeQuery();
	int i=0;
if(rs.next())
{
	String RegNo=rs.getString(8);
	String PatientName=rs.getString(9);
	String AddmissionDate=rs.getString(10);
	String DischargeDate=rs.getString(1);
	String Diseases=rs.getString(2);
	String DoctorCharges=rs.getString(6);
	String BillingAmount=rs.getString(7);

	t1[i].setText(RegNo);
	i++;
	t1[i].setText(PatientName);
	i++;
	t1[i].setText(AddmissionDate);
	i++;
	t1[i].setText(DischargeDate);
	i++;
	t1[i].setText(Diseases);
	i++;
	t1[i].setText(DoctorCharges);
	i++;
	t1[i].setText(BillingAmount);
	i++;

	}
else{
	JOptionPane.showMessageDialog(null, "Either Patient admission date is not existing or It is an admission date of In Patient");
}
}catch(MySQLNonTransientConnectionException e4){
	JOptionPane.showMessageDialog(null, "Connection is closed");
}
catch(Exception ex)
{
	System.out.println("error"+ex);
	}
 
 
}//regsrchbutton closed



if(e.getSource() == dissrchButton){
	
setDefaultLookAndFeelDecorated(true);
JFrame f5=new JFrame("Search By Discharge Date");
f5.setSize(700,200);
f5.setLocationRelativeTo(null);
JTextField []t1=new JTextField[28];
JPanel p5=new JPanel();
f5.getContentPane().add(p5);
p5.setLayout(new GridLayout(5,7));
p5.add(new JLabel("Patient Registration No"));
p5.add(new JLabel("Patient Name"));
p5.add(new JLabel("Admission Date"));
p5.add(new JLabel("Discharge Date"));
p5.add(new JLabel("Diseases"));
p5.add(new JLabel("Doctor Charges"));
p5.add(new JLabel("BillingAmount"));
for(int i=0; i<28; i++)
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

if(srchdisField.getText()==null|| srchdisField.getText().toString().equals("YYYY/MM/DD") ||srchdisField.getText().toString().equals("")||srchdisField.getText().toString().equals(" "))
{
 	JOptionPane.showMessageDialog(null,"Required Field must not be blank"); 	  
 	con.close();
}
 
	PreparedStatement ps=con.prepareStatement("Select  * from discharge where DischargeDate = ? && PatientType = ?");
 ps.setString(1,srchdisField.getText());
 ps.setString(2,"OutPatient");

 ResultSet rs=ps.executeQuery();
	int i=0;
if(rs.next())
{
	String RegNo=rs.getString(8);
	String PatientName=rs.getString(9);
	String AddmissionDate=rs.getString(10);
	String DischargeDate=rs.getString(1);
	String Diseases=rs.getString(2);
	String DoctorCharges=rs.getString(6);
	String BillingAmount=rs.getString(7);

	t1[i].setText(RegNo);
	i++;
	t1[i].setText(PatientName);
	i++;
	t1[i].setText(AddmissionDate);
	i++;
	t1[i].setText(DischargeDate);
	i++;
	t1[i].setText(Diseases);
	i++;
	t1[i].setText(DoctorCharges);
	i++;
	t1[i].setText(BillingAmount);
	i++;

	}
else{
	JOptionPane.showMessageDialog(null, "Either Patient discharge date is not existing or It is discharge date of In Patient");
}
}catch(MySQLNonTransientConnectionException e4){
	JOptionPane.showMessageDialog(null, "Connection is closed");
}
catch(Exception ex)
{
	System.out.println("error"+ex);
	}
 
 
}//regsrchbutton closed


if(e.getSource() == namesrchButton){
	
setDefaultLookAndFeelDecorated(true);
JFrame f5=new JFrame("Search By Name");
f5.setSize(700,200);
f5.setLocationRelativeTo(null);
JTextField []t1=new JTextField[28];
JPanel p5=new JPanel();
f5.getContentPane().add(p5);
p5.setLayout(new GridLayout(5,7));
p5.add(new JLabel("Patient Registration No"));
p5.add(new JLabel("Patient Name"));
p5.add(new JLabel("Admission Date"));
p5.add(new JLabel("Discharge Date"));
p5.add(new JLabel("Diseases"));
p5.add(new JLabel("Doctor Charges"));
p5.add(new JLabel("BillingAmount"));
for(int i=0; i<28; i++)
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

if(srchnameField.getText()==null ||  srchnameField.getText().toString().equals("")||srchnameField.getText().toString().equals(" "))
{
 	JOptionPane.showMessageDialog(null,"Required Field must not be blank"); 	  
 	con.close();
}

 
	PreparedStatement ps=con.prepareStatement("Select  * from discharge where Name = ? && PatientType = ?");
 ps.setString(1,srchnameField.getText());
 ps.setString(2,"OutPatient");

 ResultSet rs=ps.executeQuery();
	int i=0;
if(rs.next())
{
	String RegNo=rs.getString(8);
	String PatientName=rs.getString(9);
	String AddmissionDate=rs.getString(10);
	String DischargeDate=rs.getString(1);
	String Diseases=rs.getString(2);
	String DoctorCharges=rs.getString(6);
	String BillingAmount=rs.getString(7);

	t1[i].setText(RegNo);
	i++;
	t1[i].setText(PatientName);
	i++;
	t1[i].setText(AddmissionDate);
	i++;
	t1[i].setText(DischargeDate);
	i++;
	t1[i].setText(Diseases);
	i++;
	t1[i].setText(DoctorCharges);
	i++;
	t1[i].setText(BillingAmount);
	i++;

	}
else{
	JOptionPane.showMessageDialog(null, "Either Patient name is not existing or It is a name of In Patient");
}
}catch(MySQLNonTransientConnectionException e4){
	JOptionPane.showMessageDialog(null, "Connection is closed");
}
catch(Exception ex)
{
	System.out.println("error"+ex);
	}
 
 
}//regsrchbutton closed
if(e.getSource() == resetButton){
	 
	srchregField.setText("");
	 	srchdisField.setText("YYYY/MM/DD");
	 
 	srchadminField.setText("YYYY/MM/DD");
 	 	
 	srchnameField.setText("");
 	 
	//theFrame.setVisible(false);
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
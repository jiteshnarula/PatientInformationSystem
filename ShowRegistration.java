import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class ShowRegistration extends JFrame{
	JPanel thePanel;
	JFrame theFrame;
	public static void main(String args[]){
		new ShowRegistration();
	}//void main closed
	
	public ShowRegistration(){
		JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\JiteshNarula\\Desktop\\Patient Info System Images\\phone_1x.png"));
		JFrame theFrame = new JFrame("Registered Patients Detail");
		setDefaultLookAndFeelDecorated(true);
		JFrame f5=new JFrame("Registered Patients Detail");
		f5.setSize(1000,700);
		f5.setLocation(0,0);
		
		JTextField []t1=new JTextField[400];
		JPanel p5=new JPanel();
		f5.getContentPane().add(p5);
		f5.setLocationRelativeTo(null);
		p5.setLayout(new GridLayout(41,10));

		
		p5.add(new JLabel("Registration Number"));
		p5.add(new JLabel("Patient Name"));
		p5.add(new JLabel("Admission Date"));
		p5.add(new JLabel("Sex"));
		p5.add(new JLabel("Blood Group"));
		p5.add(new JLabel("Date Of Birth"));
		p5.add(new JLabel("EMail I'D"));
		p5.add(new JLabel("Phone Number"));
		p5.add(new JLabel("Address"));
		p5.add(new JLabel("PatientType"));
		p5.add(new JLabel("Bed Number"));
	for(int i=0; i<400; i++)
	{
	t1[i]=new JTextField(10);
	p5.add(t1[i]);
	t1[i].setEditable(false);
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
	PreparedStatement ps=con.prepareStatement("Select * from registration" );

	 ResultSet rs=ps.executeQuery();
		int i=0;
	while(rs.next())
	
	{  
		String RegNumber = rs.getString(11);
		String PatientName = rs.getString(1);
		String AdmissionDate = rs.getString(8);
		String Sex = rs.getString(2);
		String DOB = rs.getString(3);
		String BloodGroup = rs.getString(7);
		String Email = rs.getString(4);
		String PhoneNumber =rs.getString(5);
		String Address = rs.getString(6);
		String PatientType = rs.getString(9);
		String BedNumber=rs.getString(10);


		t1[i].setText(RegNumber);
		i++;
		t1[i].setText(PatientName);
		i++;
		t1[i].setText(AdmissionDate);
		i++;
		t1[i].setText(Sex);
		i++;
		t1[i].setText(DOB);
		i++;
		t1[i].setText(BloodGroup);
		i++;
		t1[i].setText(Email);
		i++;
		t1[i].setText(PhoneNumber);
		i++;
		t1[i].setText(Address);
		
		i++;
		t1[i].setText(PatientType);
		i++;
		t1[i].setText(BedNumber);
		i++;
		}
	}
	catch(Exception ex)
	{
		System.out.println("Exception not found");
		}

	 

	}//show registration constructor closed
}//show registration closed
 
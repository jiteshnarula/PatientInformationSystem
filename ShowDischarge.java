import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class ShowDischarge extends JFrame{
	JPanel thePanel;
	JFrame theFrame;
	public static void main(String args[]){
		new ShowDischarge();
	}//void main closed
	
	public ShowDischarge(){
		JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\JiteshNarula\\Desktop\\Patient Info System Images\\phone_1x.png"));
		JFrame theFrame = new JFrame("Discharged Patients Detail");
		setDefaultLookAndFeelDecorated(true);
		JFrame f5=new JFrame("Table");
		f5.setSize(1000,700);
		f5.setLocation(0,0);
		
		JTextField []t1=new JTextField[400];
		JPanel p5=new JPanel();
		f5.getContentPane().add(p5);
		f5.setLocationRelativeTo(null);
		p5.setLayout(new GridLayout(41,10));

		
		p5.add(new JLabel("Patient Registration No"));
		p5.add(new JLabel("Patient Name"));
		p5.add(new JLabel("Admission Date"));
		p5.add(new JLabel("Discharge Date"));
		p5.add(new JLabel("Diseases"));
		p5.add(new JLabel("Medical Charges"));
		p5.add(new JLabel("Room Charges"));
		p5.add(new JLabel("OT Charges"));
		p5.add(new JLabel("Doctor Charges"));
		p5.add(new JLabel("Total Charges"));
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
	PreparedStatement ps=con.prepareStatement("Select * from discharge" );

	 ResultSet rs=ps.executeQuery();
		int i=0;
	while(rs.next())
	{
		String RegNumber = rs.getString(8);
		String PatientName = rs.getString(9);
		String AdmissionDate = rs.getString(10);
		String DischargeDate = rs.getString(1);
		String Diseases = rs.getString(2);
		String MedicalCharges = rs.getString(3);
		String RoomCharges =rs.getString(4);
		String OTCharges = rs.getString(5);
		String DoctorCharges = rs.getString(6);
		String TotalCharges=rs.getString(7);


		t1[i].setText(RegNumber);
		i++;
		t1[i].setText(PatientName);
		i++;
		t1[i].setText(AdmissionDate);
		i++;
		t1[i].setText(DischargeDate);
		i++;
		t1[i].setText(Diseases);
		i++;
		t1[i].setText(MedicalCharges);
		i++;
		t1[i].setText(RoomCharges);
		i++;
		t1[i].setText(OTCharges);
		i++;
		t1[i].setText(DoctorCharges);
		
		i++;
		t1[i].setText(TotalCharges);
		i++;

		}
	}
	catch(Exception ex)
	{
		System.out.println("Exception not found");
		}

	 

	}//show registration constructor closed
}//show registration closed
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mobile{
	JButton bt1;
	JLabel imageLabel1,imageLabel2;
	JFrame theFrame;
	public static void main(String args[]){
		new Mobile();
	}
	
	 public Mobile(){
		 theFrame = new JFrame("Jitesh Narula");
		 theFrame.setLayout(null);
		 JLabel imageLabel =  new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\phone_1x.png")));
		imageLabel.setBounds(0,0,450,700);
		 theFrame.setLocation(500,0);
		  theFrame.setSize(450,700);  	
		imageLabel1 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\Stethoscope.png")));
		imageLabel1.setBounds(130,70,300,300);
		imageLabel.add(imageLabel1);
		JLabel textLabel = new JLabel("Temple Run         patient information system");
		
		textLabel.setBounds(110,130,290,300);  
		 imageLabel2 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images\\88.png")));
			imageLabel2.setBounds(30,65,200,300);
			imageLabel.add(imageLabel2);
			   theFrame.add(textLabel);
			theFrame.add(imageLabel);
		  
		  bt1 = new JButton("Cancel");
		 bt1.setBounds(175,415,90,30);
		 theFrame.setVisible(true);
		 theFrame.add(bt1);
		 ListenForButton lForButton = new ListenForButton();
		 bt1.addActionListener(lForButton);
		 ListenForMouse l = new ListenForMouse();
		  imageLabel1.addMouseListener(l);
		  imageLabel2.addMouseListener(l);
	 }	
	 public class ListenForButton implements ActionListener{
		 public void actionPerformed(ActionEvent e){
			 if(e.getSource() == bt1){
				 System.exit(0);
			 }
		 }
	 }
	 public class ListenForMouse implements MouseListener{

		 
		public void mouseClicked(MouseEvent e) {
			 
			if(e.getSource() == imageLabel1)
				{new LoginForm();
				theFrame.setVisible(false);
				}
			if(e.getSource() == imageLabel2){
				JOptionPane.showMessageDialog(null, "App Stop Working");
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	 }
}
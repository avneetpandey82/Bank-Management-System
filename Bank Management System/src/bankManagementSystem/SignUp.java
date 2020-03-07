package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JComboBox cb1, cb2, cb3;
	JRadioButton rb1, rb2, rb3, rb4, rb5;
	JButton b;

	Random r = new Random();
	Long n = (r.nextLong() % 9000L) + 1000L;
	Long no = Math.abs(n);

	public SignUp() {
		
		setTitle("                                                 NEW ACCOUNT APPLICATION FORM");
			  
		l1 = new JLabel("APPLICATION FORM NO. " + no);
		l1.setFont(new Font("Raleway", Font.BOLD, 30));

		l2 = new JLabel("Page 1: Personal Details ");
		l2.setFont(new Font("Raleway", Font.BOLD, 20));

		l3 = new JLabel("Name : ");
		l3.setFont(new Font("Raleway", Font.BOLD, 15));

		l4 = new JLabel("Father's Name : ");
		l4.setFont(new Font("Raleway", Font.BOLD, 15));

		l5 = new JLabel("Date Of Birth : ");
		l5.setFont(new Font("Raleway", Font.BOLD, 15));

		l6 = new JLabel("Gender :");
		l6.setFont(new Font("Raleway", Font.BOLD, 15));

		l7 = new JLabel("Email : ");
		l7.setFont(new Font("Raleway", Font.BOLD, 15));

		l8 = new JLabel("Marital Status : ");
		l8.setFont(new Font("Raleway", Font.BOLD, 15));

		l9 = new JLabel("Address : ");
		l9.setFont(new Font("Raleway", Font.BOLD, 15));

		l10 = new JLabel("City : ");
		l10.setFont(new Font("Raleway", Font.BOLD, 15));

		l11 = new JLabel("Pin Code : ");
		l11.setFont(new Font("Raleway", Font.BOLD, 15));

		l12 = new JLabel("State: ");
		l12.setFont(new Font("Raleway", Font.BOLD, 15));

		l13 = new JLabel("Date");
		l13.setFont(new Font("Raleway", Font.BOLD, 15));

		l14 = new JLabel("Month");
		l14.setFont(new Font("Raleway", Font.BOLD, 15));

		l15 = new JLabel("Year");
		l15.setFont(new Font("Raleway", Font.BOLD, 15));

		tf1 = new JTextField();
		tf1.setFont(new Font("Raleway", Font.BOLD, 15));

		tf2 = new JTextField();
		tf2.setFont(new Font("Raleway", Font.BOLD, 15));

		tf3 = new JTextField();
		tf3.setFont(new Font("Raleway", Font.BOLD, 15));

		tf4 = new JTextField();
		tf4.setFont(new Font("Raleway", Font.BOLD, 15));

		tf5 = new JTextField();
		tf5.setFont(new Font("Raleway", Font.BOLD, 15));

		tf6 = new JTextField();
		tf6.setFont(new Font("Raleway", Font.BOLD, 15));

		tf7 = new JTextField();
		tf7.setFont(new Font("Raleway", Font.BOLD, 15));
		
		b = new JButton("Next");
		b.setFont(new Font("Raleway",Font.BOLD,14));
		b.setBackground(Color.black);
		b.setForeground(Color.white);
		
		rb1 = new JRadioButton("Male");
		rb1.setFont(new Font("Raleway",Font.BOLD,14));
		rb1.setBackground(Color.white);
		
		rb2 = new JRadioButton("Female");
		rb2.setFont(new Font("Raleway",Font.BOLD,14));
		rb2.setBackground(Color.white);
		
		rb3 = new JRadioButton("Other");
		rb3.setFont(new Font("Raleway",Font.BOLD,14));
		rb3.setBackground(Color.white);
		
		rb4 = new JRadioButton("Married");
		rb4.setFont(new Font("Raleway",Font.BOLD,14));
		rb4.setBackground(Color.white);
		
		rb5 = new JRadioButton("UnMarried");
		rb5.setFont(new Font("Raleway",Font.BOLD,14));
		rb5.setBackground(Color.white);
		
		
		String date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String month[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String year[] = {"1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003"};
		
		cb1=new JComboBox(date);
		cb1.setBackground(Color.gray);
		
		cb2 = new JComboBox(month);
		cb2.setBackground(Color.gray);
		
		cb3 = new JComboBox(year);
		cb3.setBackground(Color.gray);
		
		setLayout(null);
		
		l1.setBounds(80, 30, 450, 30);
		add(l1);
		
		l2.setBounds(175, 80, 300, 25);
		add(l2);
		
		l3.setBounds(40, 130, 100, 20);
		add(l3);
		
		l4.setBounds(40, 170,150, 20);
		add(l4);
		
		l5.setBounds(40, 210,150, 20);
		add(l5);
		
		l6.setBounds(40, 250,150, 20);
		add(l6);

		l7.setBounds(40, 290,150, 20);
		add(l7);
		
		l8.setBounds(40, 330,150, 20);
		add(l8);

		l9.setBounds(40, 370,150, 20);
		add(l9);

		l10.setBounds(40, 410,150, 20);
		add(l10);

		l11.setBounds(40, 450,150, 20);
		add(l11);

		l12.setBounds(35, 490,150, 20);
		add(l12);

		l13.setBounds(210, 210,150, 20);
		add(l13);

		l14.setBounds(290, 210,150, 20);
		add(l14);

		l15.setBounds(425, 210,150, 20);
		add(l15);
		
		tf1.setBounds(210, 130, 310, 25);
		add(tf1);
		
		tf2.setBounds(210, 170, 310, 25);
		add(tf2);
		
		tf3.setBounds(210, 290, 310, 25);
		add(tf3);
		
		tf4.setBounds(210, 370, 310, 25);
		add(tf4);
		
		tf5.setBounds(210, 410, 310, 25);
		add(tf5);
		
		tf6.setBounds(210, 450, 310, 25);
		add(tf6);
		
		tf7.setBounds(210, 490, 310, 25);
		add(tf7);
		
		cb1.setBounds(245, 210, 40, 25);
		add(cb1);
		cb1.setBackground(Color.white);
		
		cb2.setBounds(340, 210, 80, 25);
		add(cb2);
		cb2.setBackground(Color.white);
		
		cb3.setBounds(460, 210, 60, 25);
		add(cb3);
		cb3.setBackground(Color.white);
		
		rb1.setBounds(210, 250, 70, 20);
		add(rb1);

		rb2.setBounds(280, 250, 80, 20);
		add(rb2);
		
		rb3.setBounds(380, 250, 70, 20);
		add(rb3);

		rb4.setBounds(210, 330, 100, 20);
		add(rb4);
		
		rb5.setBounds(320, 330, 100, 20);
		add(rb5);
		
		
		
		b.setBounds(435, 530, 100, 25);
		add(b);
		
		getContentPane().setBackground(Color.white);
		setSize(600, 650);
		setLocation(450, 100);
		setVisible(true);
		
		b.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		
		String name = tf1.getText();
		String fatherName=tf2.getText();
		String date=(String)cb1.getSelectedItem();
		String month =(String)cb2.getSelectedItem();
		String year = (String)cb3.getSelectedItem();
		
		String gender="";
		if(rb1.isSelected())
		{
			gender="Male";
		}
		else if(rb2.isSelected())
		{
			gender="Female";
		}
		else if(rb3.isSelected())
		{
			gender="Others";
		}
		
		String email =tf3.getText();
		
		String status="";
			if(rb4.isSelected())
			{
				status ="Married";
			}
			else if(rb5.isSelected())
			{
				status="Unmarried";
			}
			
		String address=tf4.getText();
		String city = tf5.getText();
		String pincode=tf6.getText();
		String state = tf7.getText();
		
		if(gender.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter the gender");
			
		}
		else if(status.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Enter Your Marital Status");
		}
		else
		{
		
		Connection connect = DBConnection.getConnection();
		PreparedStatement ps;
		String sql;
		try {

			sql = "Insert into SignUp1(Name,FatherName,Date,Month,Year,Gender,Email,MaritalStatus,Address,City,PinCode,State) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps= connect.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, fatherName);
			ps.setString(3, date);
			ps.setString(4, month);
			ps.setString(5, year);
			ps.setString(6, gender);
			ps.setString(7, email);
			ps.setString(8, status);
			ps.setString(9, address);
			ps.setString(10, city);
			ps.setString(11, pincode);
			ps.setString(12, state);
			int i = ps.executeUpdate();
			
			if(i!=0)
			{
				JOptionPane.showMessageDialog(null, "Details Entered Successfully");
				
				new SignUp2().setVisible(true);
				setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Not Entered");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp().setVisible(true);
	}

}

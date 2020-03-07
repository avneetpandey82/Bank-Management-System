package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;


public class SignUp3 extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
	JRadioButton rb1,rb2,rb3,rb4;
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
	JButton b1,b2;
	JTextField tf;
	public SignUp3()
	{
		super("                                                 NEW ACCOUNT APPLICATION FORM - 3");
		
		lb1=new JLabel("Form No: ");
		lb1.setFont(new Font("Raleway",Font.BOLD,10));
		
		lb2=new JLabel("Page 3: Account Details");
		lb2.setFont(new Font("Raleway",Font.BOLD,30));
		
		lb3=new JLabel("Account Type: ");
		lb3.setFont(new Font("Raleway",Font.BOLD,18));
		
		lb4=new JLabel("Card No         : ");
		lb4.setFont(new Font("Raleway",Font.BOLD,18));
		
		lb5=new JLabel("Pin                  : ");
		lb5.setFont(new Font("Raleway",Font.BOLD,18));
		
		lb6=new JLabel("Service Required: ");
		lb6.setFont(new Font("Raleway",Font.BOLD,18));

		lb7=new JLabel("(Your 16 digitCard Number) ");
		lb7.setFont(new Font("Raleway",Font.BOLD,10));

		lb8=new JLabel("(It is Your Card Number which would Appear On your ChequeBook And Statements)");
		lb8.setFont(new Font("Raleway",Font.BOLD,9));

		lb9=new JLabel("(4-digit Pin) ");
		lb9.setFont(new Font("Raleway",Font.BOLD,10));
		
		lb10 = new JLabel("XXXX-XXXX-XXXX-4562");
		lb10.setFont(new Font("Raleway",Font.BOLD,18));
		
		lb11 = new JLabel("XXXX");
		lb11.setFont(new Font("Raleway",Font.BOLD,18));
		
		rb1 = new JRadioButton(" Saving Account ");
		rb1.setFont(new Font("Raleway",Font.PLAIN,15));
		rb1.setBackground(Color.white);
		
		rb2 = new JRadioButton(" Fixed Deposit Account ");
		rb2.setFont(new Font("Raleway",Font.PLAIN,15));
		rb2.setBackground(Color.white);
		
		rb3 = new JRadioButton(" Current Account ");
		rb3.setFont(new Font("Raleway",Font.PLAIN,15));
		rb3.setBackground(Color.white);
		
		rb4 = new JRadioButton(" Recurring Deposit Account ");
		rb4.setFont(new Font("Raleway",Font.PLAIN,15));
		rb4.setBackground(Color.white);
		
		
		cb1 =new JCheckBox("ATM CARD");		
		cb1.setFont(new Font("Raleway",Font.PLAIN,15));

		cb2 =new JCheckBox("Internet Banking");		
		cb2.setFont(new Font("Raleway",Font.PLAIN,15));
		
		cb3 =new JCheckBox("Mobile Banking");		
		cb3.setFont(new Font("Raleway",Font.PLAIN,15));
		
		cb4 =new JCheckBox("EMAIL Alerts");		
		cb4.setFont(new Font("Raleway",Font.PLAIN,15));
		
		cb5 =new JCheckBox("E-Statement");		
		cb5.setFont(new Font("Raleway",Font.PLAIN,15));
		
		cb6 =new JCheckBox("I here by declare that the above credentials are correct in the best of my knowledge");		
		cb6.setFont(new Font("Raleway",Font.PLAIN,10));
		
		cb7 = new JCheckBox("Cheque Book");
		cb7.setFont(new Font("Raleway",Font.PLAIN,15));
		
		b1 = new JButton("SUBMIT");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);

		b2 = new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		tf = new JTextField();
		tf.setFont(new Font("Raleway",Font.BOLD,10));
		
		lb1.setBounds(500, 5, 50, 20);
		add(lb1);
		
		lb2.setBounds(120, 40, 400, 40);
		add(lb2);
		
		lb3.setBounds(50, 100, 150, 50);
		add(lb3);
		
		rb1.setBounds(50,140,180,35);
		add(rb1);
		
		rb2.setBounds(50,170,230,35);
		add(rb2);
		
		rb3.setBounds(280,140,180,35);
		add(rb3);
		
		rb4.setBounds(280,170,230,35);
		add(rb4);
	
		lb4.setBounds(50,220 ,150,50);
		add(lb4);
		
		lb7.setBounds(50, 240, 200, 40);
		add(lb7);

		lb8.setBounds(220, 240, 370, 45);
		add(lb8);
		
		lb5.setBounds(50, 290, 150, 50);
		add(lb5);
		
		lb10.setBounds(220,220,300,50);
		add(lb10);
		
		lb11.setBounds(220,290,300,50);
		add(lb11);
		
		lb9.setBounds(50, 310, 200, 40);
		add(lb9);
		
		lb6.setBounds(50, 360, 200, 50);
		add(lb6);
		
		cb1.setBounds(50, 400, 150, 35);
		add(cb1);

		cb2.setBounds(280, 400, 150, 35);
		add(cb2);

		cb3.setBounds(50, 440, 150, 35);
		add(cb3);

		cb4.setBounds(280, 440, 150, 35);
		add(cb4);

		cb5.setBounds(50, 480, 150, 35);
		add(cb5);

		cb7.setBounds(280, 480, 150, 35);
		add(cb7);
		
		cb6.setBounds(50, 550, 500, 20);
		add(cb6);
		
		b1.setBounds(180,600,100,30);
		add(b1);

		b2.setBounds(300,600,100,30);
		add(b2);
		
		tf.setBounds(550, 5, 30, 20);
		add(tf);

		getContentPane().setBackground(Color.white);
		setSize(600,700);
		setLocation(450, 100);
		setLayout(null);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String a="";
		if(rb1.isSelected())
		{
			a= "Savings Account";
		}
		else if(rb2.isSelected())
		{
			a= "Fixed Deposit Account";
		}
		else if(rb3.isSelected())
		{
			a= "Current Savings";
		}
		else if(rb4.isSelected())
		{
			a="Recurring Deposit Account";
		}
		/*
		 * else if(a.equals("")) { JOptionPane.showMessageDialog(null,
		 * "Enter a valid type of account"); }
		 */
		Random r1 = new Random();
		long n1 = (r1.nextLong()%90000000L)+5040243900000000L;
		long no1=Math.abs(n1);
		
		
		/*
		 * for(int i=0;i<19;i++) { if(i==4 || i==9 || i==14) { lb10 = new JLabel("-");
		 * lb10.setFont(new Font("",Font.BOLD,15)); } else { lb11 = new JL } }
		 */
		
		Random r2 = new Random();
		long l=r2.nextLong();
		long no2=(Math.abs(l)%1000L)+1000L;
		
		
		String b = "";
		if(cb1.isSelected())
		{
			b="ATM Card";
		}
		if(cb2.isSelected())
		{
			b=b+" Intenet Banking";
		}
		if(cb3.isSelected())
		{
			b=b+" Mobile Banking";
		}
		if(cb4.isSelected())
		{
			b=b+" Emial Alerts";
		}
		if(cb5.isSelected())
		{
			b=b+" E-Statements";
		}
		if(cb7.isSelected())
		{
			b=b+" Cheque Book";
		}
		boolean c= false;
		if(cb6.isSelected())
		{
			c=true;
		}
		if(ae.getSource()==b2)
		{
			System.exit(0);
		}
		
		
		if(c==false)
		{
			JOptionPane.showMessageDialog(null,"Accept the Terms & Condition");
		}
		else if(a.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "select one of the type of account");
		}
		else if(ae.getSource()==b1)
		{
			Connection connect = DBConnection.getConnection();
			PreparedStatement ps1,ps2,ps3;
			String sql1,sql2,sql3;
			try
			{
			sql1="Insert into SignUp3(Account,CardNumber,Pin,Services) values(?,?,?,?)";
			ps1=connect.prepareStatement(sql1);
			ps1.setString(1, a);
			ps1.setLong(2, no1);
			ps1.setLong(3, no2);
			ps1.setString(4, b);
			int i = ps1.executeUpdate();
			
			sql2="Insert into login values(?,?)";
			ps2=connect.prepareStatement(sql2);
			ps2.setLong(1,no1);
			ps2.setLong(2, no2);
			int j = ps2.executeUpdate();

			sql3="Insert into bank values(?,?,?,?)";
			ps3 = connect.prepareStatement(sql3);
			ps3.setLong(1, no2);
			ps3.setLong(2, 0);
			ps3.setLong(3, 0);
			ps3.setLong(4, no1);
			int k=ps3.executeUpdate();
			
			if(i!=0 && j!=0 && k!=0)
			{
				JOptionPane.showMessageDialog(null, "Card No : "+no1+"\n Pin : "+no2);
				new Transaction().setVisible(true);
				setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Not Added");
			}
			
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Internal Error. Refill the Details");
				e.printStackTrace();
				
			}	
		}
	}
	
	public static void main(String[] args) {
		new SignUp3().setVisible(true);
	}

}

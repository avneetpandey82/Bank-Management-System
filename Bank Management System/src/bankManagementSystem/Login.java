package bankManagementSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3;
	JTextField tf;
	JPasswordField pf;
	JButton b1,b2,b3;
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
	public Login()
	{
		super("AUTOMATED TELLER MACHINE");
		
		l1 = new JLabel("Welcome To the ATM");
		l1.setFont(new Font("Osward",Font.BOLD,30));
		
		l2 = new JLabel("Card No:-");
		l2.setFont(new Font("Raleway",Font.BOLD,20));
		
		l3 = new JLabel("Pin:-");
		l3.setFont(new Font("Raleway",Font.BOLD,20));
		
		tf = new JTextField(15);
		pf = new JPasswordField(15);
		
		b1 = new JButton("LogIn");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		b2 = new JButton("Clear");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		b3 = new JButton("SignUp");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		setLayout(null);
		
		l1.setBounds(90,10,450,200);
		add(l1);

		l2.setBounds(100,80,375,200);
		add(l2);
		
		l3.setBounds(110,150,375,200);
		add(l3);
		
		tf.setFont(new Font("Arial",Font.BOLD,15));
		tf.setBounds(220,170,150,20);
		add(tf);
		
		pf.setFont(new Font("Arial",Font.BOLD,15));
		pf.setBounds(220,240,150,20);
		add(pf);
		
		b1.setFont(new Font("Arial",Font.BOLD,15));
		b1.setBounds(110,290,100,30);
		add(b1);
		b1.addActionListener(this);
		
		b2.setFont(new Font("Arial",Font.BOLD,15));
		b2.setBounds(270,290,100,30);
		add(b2);
		b2.addActionListener(this);
		
		b3.setFont(new Font("Arial",Font.BOLD,15));
		b3.setBounds(110, 350, 260, 30);
		add(b3);
		b3.addActionListener(this);
		
		
		getContentPane().setBackground(Color.white);
		
		setSize(500,500);
		setLocation(500,200);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		Connection connect = DBConnection.getConnection();
		PreparedStatement ps;
			if(e.getSource()==b1)
			{
				try
				{
					String card= tf.getText();
					char[] Password = pf.getPassword();
					String password = new String(Password);
					String sql="Select * from Login where CardNo=? and pin=?";
					ps=connect.prepareStatement(sql);
					ps.setString(1, card);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						new Transaction().setVisible(true);
						setVisible(false);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Card No or Pin may be wrong.Please try again ");
					}
					
				JOptionPane.showMessageDialog(null, "LOGIN");
				}
				catch(Exception l)
				{
					l.printStackTrace();
				}
			}
			else if(e.getSource()==b2)
			{
				tf.setText("");
				pf.setText("");
				JOptionPane.showMessageDialog(null, "Clear");
			}
			else if(e.getSource()==b3)
			{
				new SignUp().setVisible(true);
				setVisible(false);
			}
		
	}
	
	

}

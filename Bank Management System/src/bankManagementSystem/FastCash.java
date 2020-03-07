package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{

	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6;
	
	public FastCash() {
		
		super("                                                                  FAST CASH");
		
		
		l1 = new JLabel(" Fast Cash");
		l1.setFont(new Font("Raleway",Font.BOLD,30));
		
		b1 = new JButton(" Rs.50");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		b2 = new JButton(" Rs.100");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		b3 = new JButton(" Rs.200");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		b4 = new JButton(" Rs.500");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		
		b5 = new JButton(" Rs.1000");
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);
		
		b6 = new JButton(" Back");
		b6.setBackground(Color.black);
		b6.setForeground(Color.white);
		
		l1.setBounds(200, 20, 200, 80);
		add(l1);
		
		b1.setBounds(50,100,200,40);
		add(b1);
		
		b2.setBounds(280, 170, 200, 40);
		add(b2);

		b3.setBounds(50,240,200,40);
		add(b3);
		
		b4.setBounds(280,310,200,40);
		add(b4);
		
		b5.setBounds(50,380,200,40);
		add(b5);
		
		b6.setBounds(170, 480, 200, 40);
		add(b6);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		setSize(550, 650);
		setLocation(400, 100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1)
		{
			fcash(50);
		}
		if(ae.getSource()==b2)
		{
			fcash(100);
		}
		if(ae.getSource()==b3)
		{
			fcash(200);
		}
		if(ae.getSource()==b4)
		{
			fcash(500);
		}
		if(ae.getSource()==b5)
		{
			fcash(1000);
		}
		
		if(ae.getSource()==b6)
		{
			new Transaction().setVisible(true);
			setVisible(false);
		}
	}
	public void fcash(int n)
	{
		String s = JOptionPane.showInputDialog(null, "Enter the 4 digit Pin");
		int pin=Integer.parseInt(s);
		double balance=0;
		long cardNo=0;
		Connection connect = DBConnection.getConnection();
		PreparedStatement ps;
		String sql1,sql2;
		try
		{
		sql1="Select * from bank where pin=?";
		ps=connect.prepareStatement(sql1);
		ps.setInt(1,pin);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			balance=rs.getDouble("balance");
			cardNo=rs.getLong("cardNo");
		}
		if(rs.previous())
		{
			if(n>balance)
			{
				JOptionPane.showMessageDialog(null, "Not suffiecient Balance");
			}
			else
			{
			balance-=n;
			n=0-n;
			sql2="Insert into bank values(?,?,?,?)";
			ps=connect.prepareStatement(sql2);
			ps.setInt(1, pin);
			ps.setDouble(2, n);
			ps.setDouble(3, balance);
			ps.setLong(4, cardNo);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				JOptionPane.showMessageDialog(null, "Rs "+n+" are successfully withdrawal");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "NOT");
			}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Wrong pin. Please try again");
		}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Internal error please try after Sometime");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
			
			new FastCash().setVisible(true);
	}

}

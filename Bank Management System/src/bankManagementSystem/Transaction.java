package bankManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.ResultSetMetaData;

public class Transaction extends JFrame implements ActionListener{

	Connection connect = DBConnection.getConnection();
	PreparedStatement ps;
	JLabel lb1;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JTable t;
	public Transaction() {
		
		super("                                                                     TRANSACTION");
		
		lb1 = new JLabel("Please Select Your Transaction");
		lb1.setFont(new Font("Raleway",Font.BOLD,30));
		
		b1=new JButton("DEPOSIT");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		b2=new JButton("CASH WITHDRAWL");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		b3=new JButton("FAST CASH");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		b4=new JButton("MINI STATEMENT");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		
		b5=new JButton("PIN CHANGE");
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);
		
		b6=new JButton("BALANCE ENQUIRY");
		b6.setBackground(Color.black);
		b6.setForeground(Color.white);
		
		b7=new JButton("EXIT");
		b7.setBackground(Color.black);
		b7.setForeground(Color.white);
		
		lb1.setBounds(60, 40, 500, 100);
		add(lb1);
		
		b1.setBounds(50, 160, 220, 50);
		add(b1);
		
		b2.setBounds(300,160,220,50);
		add(b2);
		
		b3.setBounds(50, 230, 220, 50);
		add(b3);
		
		b4.setBounds(300,230,220,50);
		add(b4);
		
		b5.setBounds(50, 300, 220, 50);
		add(b5);
		
		b6.setBounds(300,300,220,50);
		add(b6);
		
		b7.setBounds(200, 370, 220, 50);
		add(b7);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		setSize(600,550);
		setLayout(null);
		setLocation(450,100);		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			new Deposit().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b2)
		{
			new Withdraw().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b3)
		{
			new FastCash().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b4)
		{
			String s = JOptionPane.showInputDialog(null,"Enter the pin");
			int pin = Integer.parseInt(s);
			try {
			String sql="Select * from bank where pin=?";
			ps=connect.prepareStatement(sql);
			ps.setInt(1, pin);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmt=rs.getMetaData();
			int c= rsmt.getColumnCount();
			Vector column = new Vector(c);
			for(int i=2;i<=c;i++)
			{
				column.add(rsmt.getColumnName(c));
			}
			Vector data= new Vector();
			Vector row = new Vector();
			while(rs.next())
			{
				new Vector(c);
				for(int i=2;i<c;i++)
				{
					data.add(rs.getInt(i));
				}
				row.add(data);
			}
			if(rs.previous())
			{
			System.out.println(row);
			t = new JTable(row,column);
			this.add(new JScrollPane(t));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No output");
			}
			}
			catch( Exception e)
			{
				JOptionPane.showMessageDialog(null, "Internal Error");
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==b5)
		{
			new Pin().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b6)
		{
			String s = JOptionPane.showInputDialog(null, "Enter your Pin");
			int pin=Integer.parseInt(s);
			double balance=0;
			String sql;
			try {
				sql="Select balance from bank where pin=?";
				ps=connect.prepareStatement(sql);
				ps.setInt(1, pin);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					balance=rs.getDouble("balance");
				}
				if(rs.previous()) {
				JOptionPane.showMessageDialog(null, "Your balance is "+balance);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect pin.Please try again");
				}
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==b7)
		{
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new Transaction().setVisible(true);

	}

}

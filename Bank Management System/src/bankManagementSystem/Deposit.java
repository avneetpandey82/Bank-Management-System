package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{

	JLabel lb1,lb2;
	JTextField tf;
	JButton b1,b2,b3;

	public Deposit() {
		
		super("                                                               DEPOSIT");
		
		lb1 = new JLabel("ENTER AMOUNT YOU ");
		lb1.setFont(new Font("Raleway",Font.BOLD,30));
		
		lb2 = new JLabel("WANT TO DEPOSIT ");
		lb2.setFont(new Font("Raleway",Font.BOLD,30));
		
		tf = new JTextField();
		tf.setFont(new Font("Raleway",Font.BOLD,15));
		
		b1 = new JButton("Deposit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);

		b3 = new JButton("Exit");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		lb1.setBounds(80, 80, 400, 50);
		add(lb1);

		lb2.setBounds(120, 130, 300, 50);
		add(lb2);

		tf.setBounds(100, 200, 250, 30);
		add(tf);

		b1.setBounds(80, 260, 150, 30);
		add(b1);

		b2.setBounds(250, 260, 150, 30);
		add(b2);

		b3.setBounds(160, 310, 150, 30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.white);;
		setSize(500, 450);
		setLocation(450, 100);
		setLayout(null);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
			if(tf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter the amount you want to Deposit");
			}
			else
			{
				double amount = Double.parseDouble(tf.getText());
				double balance=0;long cardNo=0;
				String s = JOptionPane.showInputDialog(null, "Enter you Pin");
				int pin = Integer.parseInt(s);
				
				Connection connect = DBConnection.getConnection();
				PreparedStatement ps1,ps2;
				String sql1,sql2;

				try
				{
				sql1="Select * from bank where pin=?";
				
				ps1=connect.prepareStatement(sql1);
				ps1.setInt(1, pin);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					balance=rs.getDouble("balance");
					cardNo=rs.getLong("cardNo");
				}
				
				if(rs.previous())
				{
					balance+=amount;
					sql2="Insert into bank values(?,?,?,?)";
					ps2=connect.prepareStatement(sql2);
					ps2.setInt(1, pin);
					ps2.setDouble(2, amount);
					ps2.setDouble(3, balance);
					ps2.setLong(4, cardNo);
					int i= ps2.executeUpdate();
					if(i!=0)
					{
						JOptionPane.showMessageDialog(null, "Succesfully Added");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Not Succesfully Added");	
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong Pin. Renter your pin");
				}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource()==b2)
		{
			
			new Transaction().setVisible(true);
			setVisible(false);
		}
		else if(e.getSource()==b3)
		{
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Deposit().setVisible(true);

	}
}

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

public class Withdraw extends JFrame implements ActionListener{

	JLabel lb1,lb3,lb4;
	JTextField tf;
	JButton b1,b2,b3;

	public Withdraw() {
		
		super("                                                                 WITHDRAW");
		
		
		lb3 = new JLabel("MAXIMUM DAILY WITHDRAWAL ");
		lb3.setFont(new Font("Raleway",Font.BOLD,30));
		
		lb4 = new JLabel("IS RS.10,000");
		lb4.setFont(new Font("Raleway",Font.BOLD,30));
		
		lb1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
		lb1.setFont(new Font("Raleway",Font.BOLD,20));
		
		tf = new JTextField();
		tf.setFont(new Font("Raleway",Font.BOLD,15));
		
		b1 = new JButton("Withdraw");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);

		b3 = new JButton("Exit");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		lb3.setBounds(30, 80, 550, 50);
		add(lb3);

		lb4.setBounds(170, 130, 300, 50);
		add(lb4);

		lb1.setBounds(60, 200, 500, 30);
		add(lb1);

		tf.setBounds(130, 250, 300, 30);
		add(tf);
		
		b1.setBounds(120,310, 150, 30);
		add(b1);
		
		b2.setBounds(300, 310, 150, 30);
		add(b2);

		b3.setBounds(210,370, 150, 30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		setSize(550, 550);
		setLocation(450, 100);
		setLayout(null);
	}
	
	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {

		double balance=0,withdraw=0;
		long cardNo=0;
		
		if(e.getSource()==b1)
		{
			Connection connect = DBConnection.getConnection(); 
			PreparedStatement ps;
			String sql1,sql2;
			if(tf.getText().isBlank())
			{
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}
			else
			{
				withdraw=Double.parseDouble(tf.getText());
				String s = JOptionPane.showInputDialog(null, "Enter the Pin");
				int pin = Integer.parseInt(s);
				sql1="Select * from bank where pin=?";
				try {
					ps=connect.prepareStatement(sql1);
					ps.setInt(1, pin);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						balance = rs.getDouble("balance");
						cardNo= rs.getLong("cardNo");
						
					}
					if(rs.previous())
					{
					if(withdraw<=balance)
					{
					balance-=withdraw;
					withdraw=0-withdraw;
					sql2="Insert into bank values(?,?,?,?) ";
					ps = connect.prepareStatement(sql2);
					ps.setInt(1, pin);
					ps.setDouble(2, withdraw);
					ps.setDouble(3, balance);
					ps.setLong(4, cardNo);
					int i= ps.executeUpdate();
					if(i!=0)
					{
						JOptionPane.showMessageDialog(null, "Rs "+withdraw+" has been deducted from Your Account");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Not");
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Not Sufficient ammount in Your account");
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Pin is not Correct");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		new Withdraw().setVisible(true);
	}

}

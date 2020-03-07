package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp2 extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField tf1,tf2,tf3;
	JComboBox cb1,cb2,cb3,cb4,cb5;
	JRadioButton rb1,rb2,rb3,rb4;
	JButton bt;
	
	public SignUp2()
	{
		
		super("                                                 NEW ACCOUNT APPLICATION FORM - 2");
		
		l1 = new JLabel("Form No:");
		l1.setFont(new Font("Raleway",Font.BOLD,10));
		
		l2 = new JLabel("Page 2: Additional Details ");
		l2.setFont(new Font("Raleway",Font.BOLD,30));

		l3 = new JLabel("Religion: ");
		l3.setFont(new Font("Raleway",Font.BOLD,17));
		
		l12 = new JLabel("Category: ");
		l12.setFont(new Font("Raleway",Font.BOLD,17));

		l4 = new JLabel("Income: ");
		l4.setFont(new Font("Raleway",Font.BOLD,17));

		l5 = new JLabel("Education: ");
		l5.setFont(new Font("Raleway",Font.BOLD,17));

		l6 = new JLabel("Qualification: ");
		l6.setFont(new Font("Raleway",Font.BOLD,17));

		l7 = new JLabel("Occupation: ");
		l7.setFont(new Font("Raleway",Font.BOLD,17));

		l8 = new JLabel("Pan: ");
		l8.setFont(new Font("Raleway",Font.BOLD,17));

		l9 = new JLabel("Aadhar No: ");
		l9.setFont(new Font("Raleway",Font.BOLD,17));

		l10 = new JLabel("Senior Citizen: ");
		l10.setFont(new Font("Raleway",Font.BOLD,17));

		l11 = new JLabel("Existing Account: ");
		l11.setFont(new Font("Raleway",Font.BOLD,17));
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Raleway",Font.PLAIN,17));

		tf2 = new JTextField();
		tf2.setFont(new Font("Raleway",Font.PLAIN,17));

		tf3 = new JTextField();
		tf3.setFont(new Font("Raleway",Font.PLAIN,17));
		
		String r[] = {"Hindu","Muslim","Sikh","Christian","Others"};
		String c[] = {"General","OBC","SC","ST"};
		String i[] = {"Null","<1,50,000","<2,50,000","<5,00,000","<10,00,000","Above 10,00,000"};
		String e[] = {"Graduate","Non-Graduate","Post-Graduate","Phd","Doctor","Others"};
		String o[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
		
		cb1 = new JComboBox(r);
		cb1.setBackground(Color.white);
		
		cb2 = new JComboBox(c);
		cb2.setBackground(Color.white);
		
		cb3 = new JComboBox(i);
		cb3.setBackground(Color.white);
		
		cb4 = new JComboBox(e);
		cb4.setBackground(Color.white);
		
		cb5 = new JComboBox(o);
		cb5.setBackground(Color.white);
			
		rb1 = new JRadioButton("Yes");
		rb1.setBackground(Color.white);
		
		rb2 = new JRadioButton("No");
		rb2.setBackground(Color.white);
		
		rb3 = new JRadioButton("Yes");
		rb3.setBackground(Color.white);
	
		rb4 = new JRadioButton("No");
		rb4.setBackground(Color.white);
		
		bt = new JButton("Next");
		bt.setBackground(Color.black);
		bt.setForeground(Color.white);
		
		l1.setBounds(500, 5, 50, 20);
		add(l1);
		
		l2.setBounds(120, 50, 400, 40);
		add(l2);
		
		l3.setBounds(60,120,130,30);
		add(l3);
		
		l12.setBounds(60, 160, 130, 30);
		add(l12);

		l4.setBounds(60, 200, 130, 30);
		add(l4);

		l5.setBounds(60, 240, 130, 30);
		add(l5);

		l6.setBounds(60, 260, 130, 30);
		add(l6);

		l7.setBounds(60, 300, 130, 30);
		add(l7);

		l8.setBounds(60, 340, 130, 30);
		add(l8);

		l9.setBounds(60, 380, 130, 30);
		add(l9);

		l10.setBounds(60, 420, 130, 30);
		add(l10);

		l11.setBounds(60, 460,150, 30);
		add(l11);
		
		tf1.setBounds(550,5,35,20);
		add(tf1);
		
		cb1.setBounds(250, 120, 300, 25);
		add(cb1);
		
		cb2.setBounds(250, 160, 300, 25);
		add(cb2);

		cb3.setBounds(250, 200, 300, 25);
		add(cb3);

		cb4.setBounds(250, 240, 300, 25);
		add(cb4);

		cb5.setBounds(250, 300, 300, 25);
		add(cb5);
		
		tf2.setBounds(250, 340, 300, 25);
		add(tf2);
		
		tf3.setBounds(250, 380, 300, 25);
		add(tf3);
		
		rb1.setBounds(280, 425, 100, 25);
		add(rb1);
		
		rb2.setBounds(400, 425, 100, 25);
		add(rb2);
		
		rb3.setBounds(280, 465, 100, 25);
		add(rb3);
		
		rb4.setBounds(400, 465, 100, 25);
		add(rb4);
		
		bt.setBounds(450, 520, 100, 30);
		add(bt);
		bt.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		setSize(600, 650);
		setLocation(450, 100);
		setLayout(null);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String a =(String)cb1.getSelectedItem();
		String b =(String)cb2.getSelectedItem();
		String c =(String)cb3.getSelectedItem();
		String d =(String)cb4.getSelectedItem();
		String e =(String)cb5.getSelectedItem();
		
		String f =(String)tf2.getText();
		String g =(String)tf3.getText();
		
		String h = "";
		if(rb1.isSelected())
		{
			h = "Yes";
		}
		else if(rb2.isSelected())
		{
			h ="No";
		}
			
		String i ="";
		if(rb3.isSelected())
		{
			i = "Yes";
		}
		else if(rb4.isSelected())
		{
			i ="No";
		}	
		//take value of tf1 from database
		if(f.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Enter your Pan No");
		}
		else if(g.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Enter your Aadhar No");
		}
		else if(g.length()!=16)
		{
			JOptionPane.showMessageDialog(null, "Enter a valid Aadhar Card Number");
		}
		else
		{

			Connection con = DBConnection.getConnection();
			PreparedStatement ps;
			String sql;
			try
			{
				sql="Insert into SignUp2(Religion,Category,Income,Qualification,Occupation,Pan,AadharNo,SCitizen,Existing) values(?,?,?,?,?,?,?,?,?)";
				
				ps=con.prepareStatement(sql);
				ps.setString(1, a);
				ps.setString(2, b);
				ps.setString(3, c);
				ps.setString(4, d);
				ps.setString(5, e);
				ps.setString(6, f);
				ps.setString(7, g);
				ps.setString(8, h);
				ps.setString(9, i);
				
				int z = ps.executeUpdate();
				if(z!=0)
				{
					JOptionPane.showMessageDialog(null, "Entered Successfully");
					new SignUp3().setVisible(true);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not Entered");
				}
			}
			catch( Exception x)
			{
				x.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp2().setVisible(true);
	}

	
}

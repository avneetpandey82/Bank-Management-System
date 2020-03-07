package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pin extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4;
	JPasswordField pf1,pf2,pf3;
	JButton b1,b2;
	
	public Pin() {
		
		super("                                                                    PIN");
		
		
		
		l1 = new JLabel("CHANGE YOUR PIN");
		l1.setFont(new Font("Raleway",Font.BOLD,30));
		

		l2 = new JLabel("Old Pin :");
		l2.setFont(new Font("Raleway",Font.BOLD,20));
	

		l3 = new JLabel("New Pin :");
		l3.setFont(new Font("Raleway",Font.BOLD,20));

		l4 = new JLabel("Re-enter New Pin :");
		l4.setFont(new Font("Raleway",Font.BOLD,20));
		
		
		pf1 = new JPasswordField();
		pf2 = new JPasswordField();
		pf3 = new JPasswordField();
		
		b1 = new JButton("Change");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
	

		b2 = new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);

		b1.addActionListener(null);
		b1.addActionListener(null);
		
		l1.setBounds(130,120,300,50);
		add(l1);
		
		l2.setBounds(50,200,100,50);
		add(l2);

		l3.setBounds(50,280,100,50);
		add(l3);

		l4.setBounds(50,360,180,50);
		add(l4);

		pf1.setBounds(250,210,200,30);
		add(pf1);

		pf2.setBounds(250,290,200,30);
		add(pf2);

		pf3.setBounds(250,370,200,30);
		add(pf3);
		
		b1.setBounds(100, 450, 130, 40);
		add(b1);

		b2.setBounds(300, 450, 130, 40);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		setSize(550, 600);
		setLocation(450, 100);
		setLayout(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b2)
		{
			
			new Transaction().setVisible(true);
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		
		new Pin().setVisible(true);
	}

}

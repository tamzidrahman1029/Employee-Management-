import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SecondFrame extends JFrame implements MouseListener,ActionListener
{
	JPanel panel;
	ImageIcon img;
	JLabel emp, imglabel;
	JButton add1, view, rmv;
	Color myColor;
	Font myFont, myFont2;
	
	public SecondFrame()
	{
		super("Prime Invest");
		this.setSize(1000,550);
		this.setLocation(200,50);
		
		myColor=new Color(230,230,230);
		
		myFont=new Font("Times New Roman", Font.BOLD,40);
		myFont2=new Font("Times New Roman",Font.BOLD,18);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		
		emp=new JLabel("Employee Management");
		emp.setBounds(264,128,440,40);
		emp.setFont(myFont);
		panel.add(emp);
		
		add1=new JButton("Add Employee");
		add1.setBounds(195, 233, 155, 35);
		add1.setBackground(Color.BLACK);
		add1.setForeground(Color.WHITE);
		add1.setFont(myFont2);
		add1.addActionListener(this);
		add1.addMouseListener(this);
		panel.add(add1);
		
		
		view=new JButton("View Employee");
		view.setBounds(585, 233, 190, 35);
		view.setBackground(Color.BLACK);
		view.setForeground(Color.WHITE);
		view.setFont(myFont2);
		view.addActionListener(this);
		view.addMouseListener(this);
		panel.add(view);
		
		rmv=new JButton("Remove Employee");
		rmv.setBounds(375, 380, 190, 35);
		rmv.setBackground(Color.BLACK);
		rmv.setForeground(Color.WHITE);
		rmv.setFont(myFont2);
		rmv.addActionListener(this);
		rmv.addMouseListener(this);
		panel.add(rmv);
		
		img=new ImageIcon("Icons/home.jpg");
		imglabel=new JLabel(img);
		imglabel.setBounds(0, 0, 1000, 550);
		panel.add(imglabel);

		
		this.add(panel);
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==add1)
		{
			add1.setBackground(Color.WHITE);
			add1.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==view)
		{
			view.setBackground(Color.WHITE);
			view.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==rmv);
		{
			rmv.setBackground(Color.WHITE);
			rmv.setForeground(Color.BLACK);
		}
		
		
	}
	
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==add1)
		{
			add1.setBackground(Color.BLACK);
			add1.setForeground(Color.WHITE);
		}
		
		else if(me.getSource()==view)
		{
			view.setBackground(Color.WHITE);
			view.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==rmv);
		{
			rmv.setBackground(Color.WHITE);
			rmv.setForeground(Color.BLACK);
		}
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==add1)
		{
			AddEmployee a1=new AddEmployee();
			a1.setVisible(true);
			setVisible(false);
		}
		
	    else if(ae.getSource()==view)
		{
			ViewEmployee ve1=new ViewEmployee();
			ve1.setVisible(true);
			setVisible(false);
		}
		
		else if(ae.getSource()==rmv)
		{
			RemoveEmployee r1= new RemoveEmployee();
			r1.setVisible(true);
			setVisible(false);
		}
		
	}
	
}

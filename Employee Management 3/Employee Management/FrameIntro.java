import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FrameIntro extends JFrame implements MouseListener,ActionListener
{
	JPanel panel;
	
	JLabel  user,name,pass,acc,imglabel1,imglabel2;
	JTextField namefield;
	JPasswordField passfield;
	
	JButton login,back,sign;
	
	Font myfont,myfont2;
	
	Color mycolor;
	
	ImageIcon img1,img2;
	//String adminname = new String ("java");
	//String adminpass = new String("1234");
	
	public FrameIntro()
	{
		super("My First GUI");
		this.setSize(1000,550);
		this.setLocation(200,50);
		
		mycolor=new Color(250,250,250);
		
		myfont=new Font("Cambria",Font.BOLD,28);
		myfont2=new Font("Cambria",Font.PLAIN,24);
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(mycolor);
		
		user=new JLabel("User Informartion ");
		user.setBounds(540, 190, 250, 30);
		user.setFont(myfont);
		panel.add(user);

		name=new JLabel("User Name: ");
		name.setBounds(500, 235, 160, 30);
		name.setFont(myfont2);
		panel.add(name);
		
		namefield=new JTextField();
		namefield.setBounds(640, 235, 200, 30); //(Right-left, up-down , length, height)
		namefield.setBackground(Color.WHITE);
		panel.add(namefield);
		
		pass=new JLabel("Password  : ");
		pass.setBounds(500, 275, 160, 30);
		pass.setFont(myfont2);
		panel.add(pass);
		
		passfield=new JPasswordField();
		passfield.setBounds(640, 275, 200, 30);
		passfield.setBackground(Color.WHITE);
		passfield.setEchoChar('*');
		panel.add(passfield);
		
		back=new JButton("Back");
		back.setBounds(560, 325, 80, 30);
		back.setBackground(Color.RED);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);
		
		
		login=new JButton("Log In");
		login.setBounds(660, 325, 80, 30);
		login.setBackground(Color.GREEN);
		login.addMouseListener(this);
		login.addActionListener(this);
		panel.add(login);
		
		img2=new ImageIcon("Icons/Man2.jpeg");
		imglabel2=new JLabel(img2);
		imglabel2.setBounds(570,30,150,150);
		panel.add(imglabel2);
		
		img1=new ImageIcon("Icons/PT.png");
		imglabel1=new JLabel(img1);
		imglabel1.setBounds(150,90,250,250);  //(x-axis,y-axis,img width, img length)
		panel.add(imglabel1);
		
		this.add(panel);
	}
	//}

	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==login)
		{
			login.setBackground(Color.BLUE);
			login.setForeground(Color.WHITE);
		}
		
		
		else if(me.getSource()==back)
		{
			back.setBackground(Color.BLUE);
			back.setForeground(Color.WHITE);
		}
	}
		
		//else{}
	
	
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==login)
		{
			login.setBackground(Color.BLUE);
			login.setForeground(Color.BLACK);
		}
		
		
		else if(me.getSource()==back)
		{
			back.setBackground(Color.RED);
		}
		
		else{}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(namefield.getText().equals("java") && passfield.getText().equals("1234"))
			{				
			SecondFrame se1=new SecondFrame();
			se1.setVisible(true);
			setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Invalid Username or Password");
			}
		
	}
	}
	
	

	
			
	


	//@Override
	//public void actionPerformed(ActionEvent e) {}


	/*public void actionPerformed(ActionEvent ae)
	{	
		String s1=namefield.getText();
		String s2=passfield.getText();
		
		if(ae.getSource()==login)
		{
			if(s1.isEmpty()||s2.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Invalid Details");
			}
		}
		
		else if(ae.getSource()==login)
		{
			if(namefield.getText().equals("Tamzid") && passfield.getText().equals("1234")){
				
			SecondFrame se1=new SecondFrame();
			se1.setVisible(true);
			this.setVisible(false);
			}
			else{
			JOptionPane.showMessageDialog(this,"Enter the details correctly");
			}
		//}
		}
		
		else if(ae.getSource()==back)
		{
			
		}
		
		else {}
		
	}*/
//}
			
	
//}
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener
{
	JPanel panel;
	ImageIcon i1;
	JButton spl;
	JLabel ilabel;
	
	public Splash()
	{
		super("GUI");
		this.setSize(1000,550);
		this.setLocation(200,50);
		
		panel= new JPanel();
		panel.setLayout(null);
		
		ImageIcon i1=new ImageIcon("Icons/front.gif");
		spl=new JButton(i1);
		spl.setBounds(0,0,1000,550);
		spl.addActionListener(this);
		panel.add(spl);
		
		
		this.add(panel);
	}
		
		public void actionPerformed(ActionEvent ae) 
		{
			if(ae.getSource()==spl)
			{
				FrameIntro f1=new FrameIntro();
				f1.setVisible(true);
				setVisible(false);
			}
		}

}

		
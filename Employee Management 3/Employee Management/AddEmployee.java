import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class AddEmployee extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel heading, name, fname, dob, salary, address, phone, email, education, designation, nidnumber, imgLabel, id, tempid;
	JTextField tname, tfname, dobfield, salaryfield, addressfield, phonefield, emfield, desigfield, nidfield, idfield;
	@SuppressWarnings("rawtypes")
	JComboBox combo;//combo1, combo2, combo3;
	JButton back, adddetails;
	ImageIcon img;
	Color myColor;
	Font myFont, myFont1;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddEmployee() {
		super("Add Details");
		this.setSize(1000, 550);
		this.setLocation(200,50);

		myColor = new Color(191, 199, 177);

		myFont = new Font("Times New Roman", Font.PLAIN, 20);
		myFont1 = new Font("Times New Roman", Font.BOLD, 30);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

		heading = new JLabel("Add Employee Detail ");
		heading.setBounds(360, 40, 300, 35);
		heading.setFont(myFont1);
		heading.setBackground(Color.WHITE);
		panel.add(heading);
		

		name = new JLabel("Name: ");
		name.setBounds(120, 130, 140, 22);
		name.setFont(myFont);
		name.setBackground(Color.WHITE);
		panel.add(name);

		tname = new JTextField();
		tname.setBounds(245, 130, 165, 25);
		tname.setBackground(Color.WHITE);
		panel.add(tname);

		fname = new JLabel("Father's Name: ");
		fname.setBounds(470, 130, 140, 22);
		fname.setFont(myFont);
		panel.add(fname);

		tfname = new JTextField();
		tfname.setBounds(600, 130, 165, 25);
		tfname.setBackground(Color.WHITE);
		panel.add(tfname);

		dob = new JLabel("Date of Birth: ");
		dob.setBounds(120, 180, 140, 22);
		dob.setFont(myFont);
		panel.add(dob);

		dobfield = new JTextField();
		dobfield.setBounds(245, 180, 165, 25);
		dobfield.setBackground(Color.WHITE);
		panel.add(dobfield);
		
		/*String items1[] = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" };
		combo1 = new JComboBox(items1);
		combo1.setBounds(305, 180, 50, 25);
		panel.add(combo1);
		
		String items2[] = {"1", "2", "3" ,"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" ,"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		combo2 = new JComboBox(items2);
		combo2.setBounds(265, 180, 50, 25);
		panel.add(combo2);
		
		String items3[] = {"1990", "2", "3" ,"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" ,"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		combo3 = new JComboBox(items3);
		combo3.setBounds(355, 180, 50, 25);
		panel.add(combo3);*/

		salary = new JLabel("Salary: ");
		salary.setBounds(470, 180, 140, 22);
		salary.setFont(myFont);
		panel.add(salary);

		salaryfield = new JTextField();
		salaryfield.setBounds(600, 180, 165, 25);
		salaryfield.setBackground(Color.WHITE);
		panel.add(salaryfield);

		address = new JLabel("Address: ");
		address.setBounds(120, 230, 140, 22);
		address.setFont(myFont);
		panel.add(address);

		addressfield = new JTextField();
		addressfield.setBounds(245, 230, 165, 25);
		addressfield.setBackground(Color.WHITE);
		panel.add(addressfield);

		phone = new JLabel("Phone: ");
		phone.setBounds(470, 230, 140, 22);
		phone.setFont(myFont);
		panel.add(phone);

		phonefield = new JTextField();
		phonefield.setBounds(600, 230, 165, 25);
		phonefield.setBackground(Color.WHITE);
		panel.add(phonefield);

		email = new JLabel("E-mail: ");
		email.setBounds(120, 280, 140, 22);
		email.setFont(myFont);
		panel.add(email);

		emfield = new JTextField();
		emfield.setBounds(245, 280, 165, 25);
		emfield.setBackground(Color.WHITE);
		panel.add(emfield);

		education = new JLabel("Education: ");
		education.setBounds(470, 280, 140, 22);
		education.setFont(myFont);
		panel.add(education);

		String items[] = { "BSc", "MSc", "BBA", "MBA", "BA", "MA" };
		combo = new JComboBox(items);
		combo.setBounds(600, 280, 165, 25);
		panel.add(combo);

		designation = new JLabel("Designation: ");
		designation.setBounds(120, 330, 140, 22);
		designation.setFont(myFont);
		panel.add(designation);

		desigfield = new JTextField();
		desigfield.setBounds(245, 330, 165, 25);
		desigfield.setBackground(Color.WHITE);
		panel.add(desigfield);

		nidnumber = new JLabel("NID Number: ");
		nidnumber.setBounds(470, 330, 160, 22);
		nidnumber.setFont(myFont);
		panel.add(nidnumber);

		nidfield = new JTextField();
		nidfield.setBounds(600, 330, 165, 25);
		nidfield.setBackground(Color.WHITE);
		panel.add(nidfield);

		id = new JLabel("Employee id: ");
		id.setBounds(120, 380, 160, 22);
		id.setFont(myFont);
		panel.add(id);
		
		/*idfield = new JTextField();
		idfield.setBounds(245, 380, 165, 25);
		idfield.setBackground(Color.WHITE);
		panel.add(idfield);*/
		
		Random random=new Random();
		int employeeID= random.nextInt(100000);
		tempid=new JLabel(""+employeeID);
		tempid.setBounds(245, 380, 165, 25);
		tempid.setBackground(Color.RED);
		tempid.setFont(myFont);
		panel.add(tempid);

		back = new JButton("Back");
		back.setBounds(400, 450, 100, 30);
		back.setBackground(Color.RED);
		back.setForeground(Color.BLACK);
		back.addActionListener(this);
		panel.add(back);


		adddetails = new JButton("Add Details");
		adddetails.setBounds(550, 450, 100, 30);
		adddetails.setBackground(Color.GREEN);
		adddetails.setForeground(Color.BLACK);
		adddetails.addActionListener(this);

		panel.add(adddetails);

		
		img = new ImageIcon("Login.jpeg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(40, 30, 230, 95);
		panel.add(imgLabel);

		this.add(panel);
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==adddetails)
		{
			adddetails.setBackground(Color.BLACK);
			adddetails.setForeground(Color.WHITE);
		}
		
		else if(me.getSource()==back)
		{
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
		}
	}
	
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==adddetails)
		{
			adddetails.setBackground(Color.GREEN);
			adddetails.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==back)
		{
			back.setBackground(Color.RED);
			back.setForeground(Color.BLACK);
		}
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==adddetails)
		{
			String name= tname.getText();
			String fname= tfname.getText();
			String dob= dobfield.getText();
			int salary= Integer.parseInt(salaryfield.getText());
			String address= addressfield.getText();
			int phone=  Integer.parseInt(phonefield.getText());
			String email= emfield.getText();
			String education= (String)combo.getSelectedItem();
			String designation= desigfield.getText();
			int nidnumber= Integer.parseInt(nidfield.getText());
			int employeeID= Integer.parseInt(tempid.getText());
			
			Information i= new Information(name, fname, dob, salary, address, phone, email, education, designation, nidnumber, employeeID);
			i.addInformation();
			
			JOptionPane.showMessageDialog(this,"Employee Details Saved");
			
			
		}
			
			else if(ae.getSource()==back)
			{
				SecondFrame se1=new SecondFrame();
				se1.setVisible(true);
				setVisible(false);
			}
			
		}
		
		
}
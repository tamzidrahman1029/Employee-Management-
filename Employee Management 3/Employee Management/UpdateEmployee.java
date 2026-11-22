import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class UpdateEmployee extends JFrame implements ActionListener
{
	JPanel panel;
	JLabel heading, name, fname, dob, salary, address, phone, email, education, designation, nidnumber, imgLabel, tempid, nidfield; //tname, tfname, dobfield, nidfield;
	JTextField  salaryfield, addressfield, phonefield, emfield, desigfield, idfield;
	@SuppressWarnings("rawtypes")
	JComboBox combo;//combo1, combo2, combo3;
	JButton back, update;
	ImageIcon img;
	Color myColor;
	Font myFont, myFont1, myFont2;
	//String number;
	String[] data;
	

	@SuppressWarnings({ "rawtypes", "unchecked" })

	
	
	
	public UpdateEmployee(String[] data) 
	{
		super("Update Details");
		this.setSize(1000, 550);
		this.setLocation(200,50);
		//this.tempid= new JLabel("Employee ID: "+tempid);
		this.data=data;

		myColor = new Color(191, 199, 177);

		myFont = new Font("Times New Roman", Font.PLAIN, 16);
		myFont2 = new Font("Times New Roman", Font.PLAIN, 14);
		myFont1 = new Font("Times New Roman", Font.BOLD, 30);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

		heading = new JLabel("Update Employee Detail ");
		heading.setBounds(340, 40, 370, 35);
		heading.setFont(myFont1);
		heading.setBackground(Color.WHITE);
		panel.add(heading);
		

		name = new JLabel("Name: "+data[0]);
		name.setBounds(120, 130, 200, 22);
		name.setFont(myFont2);
		name.setBackground(Color.WHITE);
		panel.add(name);

		/*tname = new JLabel();
		tname.setBounds(245, 130, 165, 25);
		tname.setBackground(Color.WHITE);
		panel.add(tname);*/

		fname = new JLabel("Father's Name: "+data[1]);
		fname.setBounds(470, 130, 200, 22);
		fname.setFont(myFont2);
		panel.add(fname);

		/*tfname = new JLabel();
		tfname.setBounds(600, 130, 165, 25);
		tfname.setBackground(Color.WHITE);
		panel.add(tfname);*/

		dob = new JLabel("Date of Birth: "+data[2]);
		dob.setBounds(120, 180, 200, 22);
		dob.setFont(myFont2);
		panel.add(dob);

		/*dobfield = new JLabel();
		dobfield.setBounds(245, 180, 165, 25);
		dobfield.setBackground(Color.WHITE);
		panel.add(dobfield);*/

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

		nidnumber = new JLabel("NID Number: "+data[9]);
		nidnumber.setBounds(470, 330, 200, 22);
		nidnumber.setFont(myFont2);
		panel.add(nidnumber);

		

		/*id = new JLabel("Employee id: ");
		id.setBounds(120, 380, 160, 22);
		id.setFont(myFont);
		panel.add(id);
		
		idfield = new JTextField();
		idfield.setBounds(245, 380, 165, 25);
		idfield.setBackground(Color.WHITE);
		panel.add(idfield);*/
		
		
		/*tempid=new JLabel("Employee ID:"+tempid);
		tempid.setBounds(245, 380, 165, 25);
		tempid.setBackground(Color.RED);
		tempid.setFont(myFont);
		panel.add(tempid);*/

		back = new JButton("Back");
		back.setBounds(400, 450, 100, 30);
		back.setFont(myFont);
		back.setBackground(Color.BLUE);
		back.setForeground(Color.BLACK);
		back.addActionListener(this);
		panel.add(back);


		update = new JButton("Update");
		update.setBounds(550, 450, 100, 30);
		update.setFont(myFont);
		update.setBackground(Color.GREEN);
		update.setForeground(Color.BLACK);
		update.addActionListener(this);
		panel.add(update);
		
		img = new ImageIcon("Login.jpeg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(40, 30, 230, 95);
		panel.add(imgLabel);

		salaryfield.setText(data[3]); // Assuming index 3 holds salary
		addressfield.setText(data[4]); // Assuming index 4 holds address
		phonefield.setText(data[5]); // Assuming index 5 holds phone
		emfield.setText(data[6]); // Assuming index 6 holds email
		// Set initial value for combo box
		combo.setSelectedItem(data[7]); // Assuming index 7 holds education
		desigfield.setText(data[8]);


		this.add(panel);
		
	}
	
	
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==update) {
				try {
					int salary = Integer.parseInt(salaryfield.getText());
					String address = addressfield.getText();
					int phone = Integer.parseInt(phonefield.getText());
					String email = emfield.getText();
					String education = (String)combo.getSelectedItem();
					String designation = desigfield.getText();
					
					if(data == null || data.length < 9) {
						data = new String[9];
					}
					
					data[3] = String.valueOf(salary);
					data[4] = address;
					data[5] = String.valueOf(phone);
					data[6] = email;
					data[7] = education;
					data[8] = designation;
					
					String[] updateData = new String[data.length];
					System.arraycopy(data, 0, updateData, 0, data.length);
					
					ViewEmployee v = new ViewEmployee();
					v.updateRow(updateData);
					// Save the update details to file
					saveUpdateDetails(updateData);

					

					
					JOptionPane.showMessageDialog(null, "Details Update Successful");
				} 
				
				catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Invalid input for salary or phone number");
				} 
			} 	
			
			else if(ae.getSource()==back)
			{
				ViewEmployee v1=new ViewEmployee();
				v1.setVisible(true);
				setVisible(false);
			}
		}
		
		
	
	
	
		private void saveUpdateDetails(String[] updateData) {
			try (FileWriter fwrite = new FileWriter("employee_details.txt", true)) {
				for (String item : updateData) {
					fwrite.write(item + "\t");
				}
				fwrite.write("\n");
				// Close the FileWriter
				fwrite.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
}
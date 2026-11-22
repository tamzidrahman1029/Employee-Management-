import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class RemoveEmployee extends JFrame implements ActionListener, ItemListener
{
	JPanel panel;
	JLabel name, phone, email, tempid, imglabel, imglabel1;
	JTextField tname, phonefield, emfield;
	JButton delete, back;
	Choice choiceEMP;
	Font myFont;
	Color myColor;
	ImageIcon img, img1;
	
	public RemoveEmployee()
	{
		super("Remove Employee");
		this.setSize(1000,550);
		this.setLocation(200,50);
		
		myColor= new Color(69, 169, 196);
		myFont= new Font("Times New Roman", Font.PLAIN, 18);
		
		panel= new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		tempid= new JLabel("Employee Id: ");
		tempid.setBounds(20, 50, 150, 20);
		tempid.setFont(myFont);
		panel.add(tempid);
		
		choiceEMP= new Choice();
		choiceEMP.setBounds(180, 50, 150, 20);
		choiceEMP.addItemListener(this);
		panel.add(choiceEMP);
		
		name=new JLabel("Name: ");
		name.setBounds(20, 90, 150, 20);
		name.setFont(myFont);
		panel.add(name);
		
		tname= new JTextField();
		tname.setBounds(180, 90, 220, 20);
		tname.setFont(myFont);
		tname.setEditable(false);
		panel.add(tname);
		
		phone= new JLabel("Phone: ");
		phone.setBounds(20, 120, 150, 20);
		phone.setFont(myFont);
		panel.add(phone);
		
		phonefield= new JTextField();
		phonefield.setBounds(180, 120, 220, 20);
		phonefield.setFont(myFont);
		phonefield.setEditable(false);
		panel.add(phonefield);
		
		email= new JLabel("Email: ");
		email.setBounds(20, 150, 150, 20);
		email.setFont(myFont);
		panel.add(email);
		
		emfield= new JTextField();
		emfield.setBounds(180, 150, 220, 20);
		emfield.setFont(myFont);
		emfield.setEditable(false);
		panel.add(emfield);
		
		delete= new JButton("Delete");
		delete.setBounds(180, 220, 100, 30);
		delete.setFont(myFont);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		panel.add(delete);
		
		back= new JButton("BACK");
		back.setBounds(300, 220, 100, 30);
		back.setFont(myFont);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		panel.add(back);
		
		img=new ImageIcon("Icons/Delete.png");
		imglabel=new JLabel(img);
		imglabel.setBounds(600,70,300,300);  //(x-axis,y-axis,img width, img length)
		panel.add(imglabel);
		
		img1=new ImageIcon("Icons/Rback.png");
		imglabel1=new JLabel(img1);
		imglabel1.setBounds(0,0,1000,550);  //(x-axis,y-axis,img width, img length)
		panel.add(imglabel1);
		
		this.add(panel);
		loadEmployeeIds();
	}
	
	private void loadEmployeeIds() 
	{
        try 
		{
            Scanner sc = new Scanner(new File("employee_details.txt"));
            while (sc.hasNextLine()) 
			{
                String line = sc.nextLine();
                String[] value = line.split("\t");
                choiceEMP.add(value[10]);
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void loadEmployeeDetails(String tempid) 
	{
        try 
		{
            Scanner sc = new Scanner(new File("employee_details.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] value = line.split("\t");
                if (value[10].equals(tempid)) {
                    tname.setText(value[0]);
                    phonefield.setText(value[5]);
                    emfield.setText(value[6]);
                    break;
                }
            }
            sc.close();
        } catch (IOException ioe) 
		{
            ioe.printStackTrace();
        }
    }

    public void itemStateChanged(ItemEvent ie) 
	{
        if (ie.getSource() == choiceEMP) 
		{
            String selectedId = choiceEMP.getSelectedItem();
            if (selectedId != null) {
                loadEmployeeDetails(selectedId);
            }
        }
    }
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==delete)
		{
			delete.setBackground(Color.RED);
			delete.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==back)
		{
			back.setBackground(Color.BLUE);
			back.setForeground(Color.BLACK);
		}
	}
	
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==delete)
		{
			delete.setBackground(Color.RED);
			delete.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==back)
		{
			back.setBackground(Color.BLUE);
			back.setForeground(Color.BLACK);
		}
		
	}

    public void actionPerformed(ActionEvent ae) 
	{
        if (ae.getSource() == delete) 
		{
            String tempid = choiceEMP.getSelectedItem();
            if (tempid != null) 
			{
                deleteEmployee(tempid);
                JOptionPane.showMessageDialog(this, "Employee details deleted successfully");
                choiceEMP.remove(tempid);
                tname.setText("");
                phonefield.setText("");
                emfield.setText("");
            }
        } 
		
		else if (ae.getSource() == back) 
		{
            SecondFrame s1 = new SecondFrame();
            s1.setVisible(true);
            setVisible(false);
        }
    }

    private void deleteEmployee(String tempid) 
	{
        File inputFile = new File("employee_details.txt");
        File tempFile = new File("temp_employee_details.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) 
			 {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) 
			{
                String[] lineData = currentLine.split("\t");
                if (!lineData[10].equals(tempid)) 
				{
                    writer.write(currentLine + System.lineSeparator());
                }
            }
        } 
		
		catch (IOException ioe) 
		{
            ioe.printStackTrace();
        }

        if (inputFile.delete()) 
		{
            if (!tempFile.renameTo(inputFile)) 
			{
                System.out.println("Could not rename the file");
            }
        }
    }
}
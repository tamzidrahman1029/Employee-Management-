import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;


public class Information 
{
    private String name;
    private String fname;
    private String dob;
    private int salary;
    private String address;
    private int phone;
    private String email;
    private String education;
    private String designation;
    private int nidnumber;
    private int employeeID;
		
    File file;
    FileWriter fwrite;
    Scanner sc;


    public Information() 
	{

    }

    public Information(String name, String fname, String dob, int salary, String address, int phone, String email, String education, String designation, int nidnumber, int employeeID) 
	{
        this.name = name;
        this.fname = fname;
        this.dob = dob;
        this.salary = salary;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.designation = designation;
        this.nidnumber = nidnumber;
        this.employeeID = employeeID;
    }

    public void setName(String name) 
	{
        this.name = name;
    }

    public void setFname(String fname) 
	{
        this.fname = fname;
    }

    public void setDob(String dob) 
	{
        this.dob = dob;
    }

    public void setSalary(int salary) 
	{
        this.salary = salary;
    }

    public void setAddress(String address) 
	{
        this.address = address;
    }

    public void setPhone(int phone) 
	{
        this.phone = phone;
    }

    public void setEmail(String email) 
	{
        this.email = email;
    }

    public void setEducation(String education) 
	{
        this.education = education;
    }

    public void setDesignation(String designation) 
	{
        this.designation = designation;
    }

    public void setNidnumber(int nidnumber) 
	{
        this.nidnumber = nidnumber;
    }

    public void setemployeeID(int employeeID) 
	{
        this.employeeID = employeeID;
    }

    // Getter methods
    public String getName() 
	{
        return name;
    }

    public String getFname()
	{
        return fname;
    }

    public String getDob() 
	{
        return dob;
    }

    public int getSalary() 
	{
        return salary;
    }

    public String getAddress() 
	{
        return address;
    }

    public int getPhone() 
	{
        return phone;
    }

    public String getEmail() 
	{
        return email;
    }

    public String getEducation() 
	{
        return education;
    }

    public String getDesignation() 
	{
        return designation;
    }

    public int getNidnumber() 
	{
        return nidnumber;
    }

    public int getemployeeID() 
	{
        return employeeID;
    }

    public void addInformation() 
	{
        try 
		{
            file = new File("employee_details.txt");
            file.createNewFile();
			
            fwrite = new FileWriter(file, true);
			
            fwrite.write(getName()+"\t");
			fwrite.write(getFname()+"\t");
			fwrite.write(getDob()+"\t");
			fwrite.write(getSalary()+"\t");
			fwrite.write(getAddress()+"\t");
			fwrite.write(getPhone()+"\t");
			fwrite.write(getEmail()+"\t");
			fwrite.write(getEducation()+"\t");
			fwrite.write(getDesignation()+"\t");
			fwrite.write(getNidnumber()+"\t");
			fwrite.write(getemployeeID() +"\n");

			fwrite.flush();
            fwrite.close();
            System.out.println("Employee details saved successfully.");
        } 
		catch (IOException ioe) 
		{
            ioe.printStackTrace();
        }
    }
	
	public boolean checkInformation(String name, String fname, String dob, int salary, String address, int phone, String email, String education, String designation, int nidnumber, int getemployeeID)
	{
		boolean flag=false;
		file=new File("employee_details.txt");
		try
		{
			
			
			sc=new Scanner(file);
			
			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				String[] value=line.split("\t");
				if(value[0].equals(name) && value[1].equals(fname) && value[2].equals(dob) && value[3].equals(salary) && value[4].equals(address) && value[5].equals(phone) && value[6].equals(email) && value[7].equals(education) && value[8].equals(designation) && value[9].equals(nidnumber) && value[10].equals(employeeID))
				{
					flag=true;
					break;
				}
			}
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		return flag;
	}

}
package assignment3_4;
/*
 * This assignment will test knowledge on Variables, Methods, Constructors,Inheritance and Encapsulation
 */
import java.io.*;//Import Input Output header file for user input
class Student //Parent Class
{
	private String name;
	private String rollno;	
	private String phone_no;
	private int class_no;
	final int no_of_sub =3; //Making Value of Number of subject constant using Final keyword
	int mark[];
	//Getters and Setters Method for Student Name
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	//Getters and Setters Method for Roll Number
	public String getRollno() 
	{
		return rollno;
	}
	public void setRollno(String rollno) 
	{
		this.rollno = rollno;
	}
	//Getters and Setters Method for Phone Number
	public String getPhone_no() 
	{
		return phone_no;
	}
	public void setPhone_no(String phone_no) 
	{
		this.phone_no = phone_no;
	}
	//Getters and Setters Method for Class
	public int getClass_no()
	{
		return class_no;
	}
	public void setClass_no(int class_no) 
	{
		this.class_no = class_no;
	}	
	Student() // Creating Default Constructor for Student Class
	{
	}
	Student(String stud_name,String roll,String phone,int class_No)throws IOException  // Parameterized Constructor Student
	{
		name=stud_name;
		rollno=roll;		
		phone_no=phone;
		class_no=class_No;
		mark=new int[no_of_sub];
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		// User Input For 3 Subject Marks
		for (int i=0; i<no_of_sub;i++)
		{
			int j= i+1;
			System.out.println("Enter "+ j+" Subject Marks.:=> ");
			mark[i]=Integer.parseInt(br.readLine());
		}
	}
	//Result Method accept 3 subject marks and Check for student passed or fail
	public void result()throws IOException
	{
		double percentage=0;
		int tmarks=0;
		for (int i=0;i<mark.length;i++)
		{
			tmarks+=mark[i];
		}
		percentage=tmarks/no_of_sub;
		System.out.println("Name Of Student is :=>" +name);
		System.out.println("Roll Number :=>" +rollno);		
		System.out.println("Phone Number Of Student is :=>" +phone_no);
		System.out.println("Class Of Student is :=>" +class_no);
		//Checking whether Student pass or fail
		if (percentage>=70)
			System.out.println("You Pass with First Class With Distinction");
		else if(percentage>=60 && percentage<70)
			System.out.println("You Pass with First Class");
		else if(percentage>=50 && percentage<60)
			System.out.println("You Pass with Second Class");
		else if(percentage>=40 && percentage<50)
			System.out.println(" You Pass with Third Class");
		else
			System.out.println("You Are Fail");
		System.out.println(" ");
	}
}
public class StudentResultProcessing extends Student //Child Class
{
	public static void main(String args[])throws IOException //Start of Main Class
	{
		String name;
		String rno;
		String phone_no;
		int class_no;
		int nostud;
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Enter Number of Students:-");// Taking input For Number of Students
		nostud=Integer.parseInt(br.readLine());
		Student s1=new Student(); // Creating object of Parent Class Student
		Student s[]=new Student[nostud];
		// for loop Is used for Taking User Input for RollNo ,Name, phone number, class 
		for(int i=0;i<nostud;i++)
		{
			System.out.println("Enter Name:- ");
			name=br.readLine();
			s1.setName(name);
			System.out.println("Enter Roll Number:- ");
			rno = br.readLine();
			s1.setRollno(rno);			
			System.out.println("Enter Phone no:-");
			phone_no =br.readLine();
			s1.setPhone_no(phone_no);
			System.out.println("Enter Class:-");
			class_no =Integer.parseInt(br.readLine());
			s1.setClass_no(class_no);
			s[i]=new Student(s1.getName(),s1.getRollno(),s1.getPhone_no(),s1.getClass_no());
		}
		for(int i=0;i<nostud;i++)
		{
			s[i].result();// Printing the Result As PAss or Fail 
		}
	}//Close of Main Class
}

package controller;
import java.io.*;
import model.Employee;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.IEmployeeDao;
import daoimpl.EmployeeDao;
import dao.IEmpSkillDao;
import daoimpl.EmpskillDao;
import model.Empjob;
import model.Empskill;
import daoimpl.EmpjobDao;
import dao.IEmpJobDao;


public class Employeecontroller {
	IEmployeeDao empDao=null;
	IEmpSkillDao empskillDao=null;
	IEmpJobDao empjobDao=null;
	public Employeecontroller() throws ClassNotFoundException, SQLException{
		empDao=new EmployeeDao();
	}
	
	public Employee checkLogin(String UserId, String Password) {
		Employee emp=empDao.checkLogin(UserId, Password);
		return emp;
	}
	public void addEmployee(String UFN, String ULN, String UID, String UP, String UG, String UR){
		Employee emp=new Employee();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		emp.setFirstName(UFN);
		
		emp.setLastName(ULN);
		
		emp.setUserId(UID);
		
		emp.setPassword(UP);
		
		emp.setRole(UR);
		
		emp.setGender(UG);
		if(UR.equals("HRA")) {
			emp.setActive("Active");
		}
		else {
			emp.setActive("Deactivate");
		}
		//calling  dao method for insert record
		empDao.addEmployee(emp);
	}
		
	public void getAllEmployees() {
		
		List<Employee> allEmpList=empDao.getAllEmployees();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
	}
	public void getEmployeeById(int s) {
		
		
		Employee emp=empDao.getEmployeeById(s);
		System.out.println(emp);
		
		
	}
	public void updateEmployee() {
		
			/*
			 * try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String FirstName, LastName, Password, confirmPassword;
			System.out.print("Enter the EmployeeId whose record you want to Update: ");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
			System.out.println("Enter Your New Password: ");
			Password=reader.readLine();
			System.out.print("Re-Enter Your New Password");
			confirmPassword=reader.readLine();
			if(Password.equals(confirmPassword)) {
				emp.setPassword(Password);
				empDao.updateEmployee(emp);
			}
			else {
				System.out.println("It Seems you have Entered Different Password !!!");
			}
			
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
			
		}
		*/
			
	}
	public void deactivateEmployee(int s) {
			
			Employee emp=empDao.getEmployeeById(s);
			empDao.deactivateEmployee(emp);
	}
	
	
	public void activateEmployee(int s) {
		Employee emp=empDao.getEmployeeById(s);
		empDao.activateEmployee(emp);
	}
	
	
	public void deleteEmployee() {
		
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the Employee ID you wish to Delete: ");
			id=Integer.parseInt(reader.readLine());
			empDao.deleteEmployee(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void addEmpSkill(int s1, int s2, int s3) {
		Empskill esk=new Empskill();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		//System.out.println("Enter year of Expiry:");
		esk.setEmpId(s1);
		esk.setSkillId(s2);
		esk.setExpYear(s3);
		empskillDao.addEmpskill(esk);
	}
	public void getAllEmpSkills() {
		
		List<Empskill> allEmpSkillList=empskillDao.getAllEmpskills();
		for(Empskill esk:allEmpSkillList) {
			System.out.println(esk);
		}
	}
	public void getEmpSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			//System.out.println("Enter EmpSkillId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Empskill esk=empskillDao.getEmpskillById(id);
			//System.out.println(esk);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
	}
	public void updateEmpSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			Scanner sc=new Scanner(System.in);
			int id;
			int expyear;
			//System.out.println("Enter ESId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Empskill esk=empskillDao.getEmpskillById(id);
			System.out.println("Enter your new Expiry Year:");
			expyear=sc.nextInt();
			esk.setExpYear(expyear);
			empskillDao.updateEmpskill(esk);
			System.out.println(esk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteEmpSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter ESId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			empskillDao.deleteEmpskill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void addEmpJob(int s1, int s2, String s3) {
		
		
		Empjob ejb=new Empjob();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter whether recruited or not :");
		ejb.setEmpId(s1);
		ejb.setJobId(s2);
		ejb.setRecruited(s3);
		empjobDao.addEmpJob(ejb);
	}
public void getAllEmpJobs() {
		
		List<Empjob> allEmpJobList=empjobDao.getAllEmpJobs();
		for(Empjob ejb:allEmpJobList) {
			System.out.println(ejb);
		}
	}
	public void getEmpJobById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmpJobId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Empjob ejb=empjobDao.getEmpJobById(id);
			System.out.println(ejb);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
	}
	public void updateEmpJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String recruited;
			System.out.println("Enter EJId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Empjob ejb=empjobDao.getEmpJobById(id);
			System.out.println("Enter your new recruited info:");
			recruited=reader.readLine();
			ejb.setRecruited(recruited);
			empjobDao.updateEmpJob(ejb);
			System.out.println(ejb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteEmpJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EJId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			empjobDao.deleteEmpJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}

	
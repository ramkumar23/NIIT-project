package controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import dao.IJobDao;
import daoimpl.JobDao;
import model.Job;

public class Jobcontroller {
		IJobDao jobDao=null;
		public Jobcontroller() throws ClassNotFoundException, SQLException{
			jobDao=new JobDao();
		}
		public void addJob(String JBT, String JD, String CN,String LC, String KS, String JS ) {
			Job j=new Job();
				
				j.setJobTitle(JBT);
				j.setJobDescription(JD);
				j.setCompanyName(CN);
				j.setLocation(LC);
				j.setKeySkill(KS);
				j.setSalary(JS);
				System.out.println(JBT);
				if(JBT.equals("HR")) {
					j.setActive("Active");
				}
				else {
					j.setActive("Deactive");
				}
				//Calling dao method for insert record
				jobDao.addJob(j);
			}
			
			public void getAllJobs() {
				
				List<Job> allJobList=jobDao.getAllJobs();
				for(Job j:allJobList) {
					System.out.println(j);
				}
			}
			public void getJobById() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					System.out.println("Enter EmployeeId whose record you want to access: ");
					id=Integer.parseInt(reader.readLine());
					Job j=jobDao.getJobById(id);
					System.out.println(j);
					}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
					}
				}
			public void updateJob() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					String location, confirmlocation;
					System.out.println("Enter JobId whose record you want to update:");
					id=Integer.parseInt(reader.readLine());
					Job j=jobDao.getJobById(id);
					System.out.println("Enter your new location:");
					location=reader.readLine();
					System.out.println("re-enter same Location to confirm:");
					confirmlocation=reader.readLine();
					if(location.contentEquals(confirmlocation)) {
						j.setLocation(location);
						jobDao.updateJob(j);
					}
					else {
						System.out.println("Sorry! you have entered different location");
					}
					System.out.println(j);
				}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
			public void deactivateJob(int s) {
				
				Job j=jobDao.getJobById(s);
				jobDao.deactivateJob(j);
					
				}
			public void activateJob(int s) {
				
				Job j=jobDao.getJobById(s);
				jobDao.activateJob(j);
			
				}
					
			public void DeleteJob() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					System.out.println("Enter JobId whose record you want to delete: ");
					id=Integer.parseInt(reader.readLine());
					jobDao.deleteJob(id);
				}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
}

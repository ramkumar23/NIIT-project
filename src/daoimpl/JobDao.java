package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.Jdbcconnection;
import dao.IJobDao;
import model.Job;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class JobDao implements IJobDao{
	
	Connection conn=null;
	public JobDao() throws ClassNotFoundException, SQLException{

		conn=Jdbcconnection.getDBConnection();
	}
	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobList=new ArrayList<Job>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			if(rst!=null) {
				Job j=null;
				while(rst.next()) {
					j=new Job();
					j.setJobId(rst.getInt(1));
					j.setJobTitle(rst.getString(2));
					j.setJobDescription(rst.getString(3));
					j.setCompanyName(rst.getString(4));
					j.setLocation(rst.getString(5));
					j.setKeySkill(rst.getString(6));
					j.setSalary(rst.getString(7));
					j.setActive(rst.getString(8));
					allJobList.add(j);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allJobList;
	}
	@Override
	public void addJob(Job j){
		try {
			
			PreparedStatement pst=conn.prepareStatement("insert into Job(JobTitle, JobDescription,CompanyName,Location,KeySkill,Salary,Active) values(?,?,?,?,?,?,?)");
			pst.setString(1, j.getJobTitle());
			pst.setString(2, j.getJobDescription());
			pst.setString(3, j.getCompanyName());
			pst.setString(4, j.getLocation());
			pst.setString(5, j.getKeySkill());
			pst.setString(6, j.getSalary());
			pst.setString(7, j.getActive());
			int i=pst.executeUpdate();
			
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("1 record inserted...");
				JOptionPane.showMessageDialog(g,"Successfully added a Job");
			}
			else {
				//System.out.println("Insertion failed...");
				JOptionPane.showMessageDialog(g,"Oh noooo!!! Unable to add a Job");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public Job getJobById(int id) {
		Job j=new Job();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Job where JobId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					j=new Job();
					j.setJobId(rst.getInt(1));
					j.setJobTitle(rst.getString(2));
					j.setJobDescription(rst.getString(3));
					j.setCompanyName(rst.getString(4));
					j.setLocation(rst.getString(5));
					j.setKeySkill(rst.getString(6));
					j.setSalary(rst.getString(7));
					j.setActive(rst.getString(8));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return j;
	}
	@Override
	public void updateJob(Job j) {
		try {
			
			PreparedStatement pst=conn.prepareStatement("update Job set Location=? where JobId=? ");
			pst.setString(1, j.getLocation());
			pst.setInt(2, j.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record updated...");
			}
			else {
				System.out.println("update failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void deactivateJob(Job j) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update job set Active=? where JobId=? ");
			pst.setString(1, "Deactive");
			pst.setInt(2, j.getJobId());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("Job deactivated...");
				JOptionPane.showConfirmDialog(g, "Sry to congratulating for this....Job Deactivated successfully...");
				
			}
			else {
				System.out.println("Deactivation failed...");
				JOptionPane.showConfirmDialog(g, "Deactivation failed mate...");
				
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

@Override
public  void deleteJob(int id) {
	try {
		//creating PreparedStatement object by passing query string
		PreparedStatement pst=conn.prepareStatement("delete from Job where JobId=? ");
		pst.setInt(1, id);
		int i=pst.executeUpdate();
		JFrame g=new JFrame();
		if(i==1){
			//System.out.println("1 record deleted...");
			JOptionPane.showConfirmDialog(g, "HOOOOHuuuuu...You have successfully deleted a Job....");
		}
		else {
			//System.out.println("deletion failed...");
			JOptionPane.showConfirmDialog(g, "Oh My God... Deletion Failed...");
		}
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
	
}
	@Override
	public void activateJob(Job j) {
		try {
			
			PreparedStatement pst=conn.prepareStatement("update job set Active=? where JobId=? ");
			pst.setString(1, "Active");
			pst.setInt(2, j.getJobId());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("Job activated...");
				JOptionPane.showConfirmDialog(g, "Tadaaaa....Job activated Succesfully...");
				
			}
			else {
				System.out.println("Activation failed...");
				JOptionPane.showConfirmDialog(g, "Oh my God!!! Activation Failed...");

			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}

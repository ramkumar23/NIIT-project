package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.Jdbcconnection;
import dao.ISkillDao;
import model.Empskill;
import model.Skill;

public class SkillDao implements ISkillDao {
	
	Connection conn=null;
	public SkillDao() throws ClassNotFoundException, SQLException{
		conn=Jdbcconnection.getDBConnection();
		
	}
	@Override
	public List<Skill> getAllSkills(){
		List<Skill> allSkillList=new ArrayList<Skill>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Skill");
			if(rst!=null) {
				Skill emp=null;
				while(rst.next()) {
					emp=new Skill();
					emp.setSkillId(rst.getInt(1));
					emp.setSkillName(rst.getString(2));
					emp.setSkillDescription(rst.getString(3));
					emp.setActive(rst.getString(4));
					allSkillList.add(emp);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allSkillList;
	}
	@Override
	public void addSkill(Skill skill){
		try {
			
			PreparedStatement pst=conn.prepareStatement("insert into Skill(SkillName,SkillDescription,Active) values(?,?,?)");
			pst.setString(1, skill.getSkillName());
			pst.setString(2, skill.getSkillDescription());
			pst.setString(3, skill.getActive());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("1 record inserted...");
				JOptionPane.showConfirmDialog(g, "You have successfully added a Skill..");
			}
			else {
				//System.out.println("insertion failed...");
				JOptionPane.showConfirmDialog(g, "Oh no.. Insertion Failed..");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public Skill getSkillById(int id) {
		Skill emp=new Skill(); //1
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Skill where SkillId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp=new Skill();
					emp.setSkillId(rst.getInt(1));
					emp.setSkillName(rst.getString(2));
					emp.setSkillDescription(rst.getString(3));
					emp.setActive(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}
	@Override
	public void updateSkill(Skill skill) {
		try {
			PreparedStatement pst=conn.prepareStatement("update Skill set SkillName=?,SkillDescription=? where SkillId=? ");
			pst.setString(1, skill.getSkillName());
			pst.setString(2, skill.getSkillDescription());
			pst.setInt(3, skill.getSkillId());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("1 record updated...");
				JOptionPane.showConfirmDialog(g, "You have successfully updated a Skill...");
			}
			else {
				//System.out.println("update failed...");
				JOptionPane.showConfirmDialog(g, "Oh no no no no...Updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void activateSkill(Skill skill) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=? ");
			pst.setString(1, "Active");
			pst.setInt(2, skill.getSkillId());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("Skill activated...");
				JOptionPane.showConfirmDialog(g, "You have successfully Activated a Skill..");
			}
			else {
				//System.out.println("Action Failed...");
				JOptionPane.showConfirmDialog(g, "Bad time buddy. Your Action Failed...");
			}
	}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void deactivateSkill(Skill skill) {
		try {
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=? ");
			pst.setString(1, "Deactive");
			pst.setInt(2, skill.getSkillId());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("Skill deactivated...");
				JOptionPane.showConfirmDialog(g, "You have successfully deactivated a Skill..");
				
				
			}
			else {
				//System.out.println("Deactivation failed...");
				JOptionPane.showConfirmDialog(g, "World is so cruel!! so I am...Deactivation failed...");

			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void deleteSkill(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from Skill where SkillId=? ");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("1 record deleted...");
				JOptionPane.showConfirmDialog(g, "You have successfully deleted a Skill.");
			}
			else {
				//System.out.println("deletion failed...");
				JOptionPane.showConfirmDialog(g, "Never mind retry again.. deletion failed..");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

}

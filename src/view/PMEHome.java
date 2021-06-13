package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PMEHome extends JFrame {
	
	Container container=null;
	JLabel lTitle;
	JButton bViewAllSkill,bAddJob,bViewAllJobs,bViewEmpbySkill,bViewJobsbySkill,bViewAppliedJob,bSetDeactiveJob,bLogout;
	
	public PMEHome() {
		container=getContentPane();
		lTitle=new JLabel("Welcome to PME Portal");
		
		

		bViewEmpbySkill=new JButton("View Skill wise Employee");
		bViewEmpbySkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				new skillwiseemp();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}	
		});
		
		bViewAllSkill=new JButton("View All Skills");
		bViewAllSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AllSkillFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}	
		});
		
		bAddJob=new JButton("Add an Job");
		bAddJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new AddJobFrame();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		bViewAllJobs=new JButton("View All Jobs");
		bViewAllJobs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AllJobsFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}	
				
			}	
		});
		
		bViewJobsbySkill=new JButton("View Skill wise Jobs");
		bViewJobsbySkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new Skillwisejob();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		bViewAppliedJob=new JButton("View Employees who have applied for Job");
		bViewAppliedJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AppliedJobsFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		bSetDeactiveJob=new JButton("Deactivate Job");
		bSetDeactiveJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DeactivateJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		bLogout=new JButton("Logout");
		bLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Logout();	
			}	
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("PME Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,700);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	private void addComponentsToContainer() {
		container.setLayout(null);
		
	}
	public void Logout(){
		this.dispose();
	}

	private void setLocationAndSize() {
		lTitle.setBounds(100, 100, 300, 30);
		bViewEmpbySkill.setBounds(50,150,300,30);
		bViewAllSkill.setBounds(50,200,300,30);
		bAddJob.setBounds(50,250,300,30);
		bViewAllJobs.setBounds(50,300,300,30);
		bViewJobsbySkill.setBounds(50,350,300,30);
		bViewAppliedJob.setBounds(50,400,300,30);
		bSetDeactiveJob.setBounds(50,450,300,30);
		bLogout.setBounds(50,500,300,30);
		
	}

	private void setLayoutManager() {
		container.add(lTitle);
		container.add(bViewEmpbySkill);	
		container.add(bViewAllSkill);	
		container.add(bAddJob);	
		container.add(bViewAllJobs);
		container.add(bViewJobsbySkill);	
		container.add(bViewAppliedJob);	
		container.add(bSetDeactiveJob);	
		container.add(bLogout);
		
	}


}

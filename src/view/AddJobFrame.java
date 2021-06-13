package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.Jobcontroller;

public class AddJobFrame extends JFrame {
	
	Container container;
	JLabel lJobtitle,lJobdescrip,lCompanyname,lLocation,lKeyskill,lSalary;
	JTextField tJobtitle,tJobdescrip,tCompanyname,tLocation,tKeyskill,tSalary;
	JButton bSubmit;
	Jobcontroller jobController=null;
	JFrame f;
	public AddJobFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		jobController=new Jobcontroller();
		
		lJobtitle=new JLabel("Job Title");
		lJobdescrip=new JLabel("Job Description");
		lCompanyname=new JLabel("Company Name");
		lLocation=new JLabel("Location");
		lKeyskill=new JLabel("Key Skill");
		lSalary=new JLabel("Salary");
		
		tJobtitle=new JTextField();
		tJobdescrip=new JTextField();
		tCompanyname=new JTextField();
		tLocation=new JTextField();
		tKeyskill=new JTextField();
		tSalary=new JTextField();
		
		
		bSubmit=new JButton("SUBMIT");
		//Event handling for Register button
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s1,s2,s3,s4,s5,s6;
				s1=tJobtitle.getText();
				s2=tJobdescrip.getText();
				s3=tCompanyname.getText();
				s4=tLocation.getText();
				s5=tKeyskill.getText();
				s6=tSalary.getText();
				jobController.addJob(s1,s2,s3,s4,s5,s6);
				f=new JFrame();
				JOptionPane.showMessageDialog(f,"Job Added");
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Add Job");
		this.setVisible(true);
		this.setBounds(10,10,500,800);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}


	private void setLayoutManager() {
		container.setLayout(null);
		
	}


	public void setLocationAndSize() {
		lJobtitle.setBounds(30, 150, 100, 30);
		lJobdescrip.setBounds(30, 200, 100, 30);
		lCompanyname.setBounds(30, 250, 100, 30);
		lLocation.setBounds(30, 300, 100, 30);
		lKeyskill.setBounds(30,350,100,30);
		lSalary.setBounds(30, 400, 100, 30);
		
		tJobtitle.setBounds(250, 150, 150, 30);
		tJobdescrip.setBounds(250,200,150,30);
		tCompanyname.setBounds(250, 250, 150, 30);
		tLocation.setBounds(250,300,150,30);
		tKeyskill.setBounds(250,350,150,30);
		tSalary.setBounds(250, 400, 150, 30);
		
		
		bSubmit.setBounds(100, 450, 100, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(lJobtitle);
		container.add(lJobdescrip);
		container.add(lCompanyname);
		container.add(lLocation);
		container.add(lKeyskill);
		container.add(lSalary);
		container.add(tJobtitle);
		container.add(tJobdescrip);
		container.add(tCompanyname);
		container.add(tLocation);
		container.add(tKeyskill);
		container.add(tSalary);
		container.add(bSubmit);
		
	}
}
					

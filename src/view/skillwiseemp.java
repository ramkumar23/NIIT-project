package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import controller.Employeecontroller;

public class skillwiseemp extends JFrame{
	Container container;
	JFrame f;
	JLabel lEmployeeId;
	JTextField tEmployeeId;
	JButton bSubmit;
	Employeecontroller empController=null;
	public int st;

	
	public skillwiseemp() throws ClassNotFoundException, SQLException{
		
		
		container=getContentPane();
		f=new JFrame();
		lEmployeeId=new JLabel("skill name");
		tEmployeeId=new JTextField();
		bSubmit=new JButton("SUBMIT");
		empController=new Employeecontroller();
		
		
		
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			try { 
				String h= tEmployeeId.getText();
					new SkillwiseempTable(h);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("View Employee");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lEmployeeId.setBounds(30, 150, 250, 30);
		tEmployeeId.setBounds(200, 150, 150, 30);
		bSubmit.setBounds(200, 250, 100, 30);
	}

	private void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(bSubmit);
	}


}

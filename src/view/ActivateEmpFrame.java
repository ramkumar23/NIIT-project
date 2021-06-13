package view;


import java.awt.*;
import javax.swing.*;
import controller.Employeecontroller;
import model.Job;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
public class ActivateEmpFrame extends JFrame {
	Container container;
	JFrame f;
	JLabel lEmployeeId;
	JTextField tEmployeeId;
	JButton bActivate;
	Employeecontroller empController=null;
	
	public ActivateEmpFrame() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lEmployeeId=new JLabel("ENTER EMPLOYEE ID");
		tEmployeeId=new JTextField();
		bActivate=new JButton("ACTIVATE");
		empController=new Employeecontroller();
		
		bActivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(tEmployeeId.getText());
				empController.activateEmployee(s);
				
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Activate Employee");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lEmployeeId.setBounds(30, 150, 100, 30);
		tEmployeeId.setBounds(300, 150, 150, 30);
		bActivate.setBounds(200, 250, 100, 30);
	}

	private void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(bActivate);
	}

}

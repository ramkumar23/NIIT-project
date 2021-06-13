package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;

import controller.Employeecontroller;
import model.Employee;

public class LoginFrame extends JFrame{

	Container container;
	JLabel lUserId, lPassword, lMessage,ltitle;
	JTextField tUserId;
	JPasswordField tPassword;
	JButton bLogin, bRegister;
	Employeecontroller empController=null;
	public LoginFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		lUserId=new JLabel("username");
		ltitle=new JLabel("Login Page");
		lPassword=new JLabel("Password");
		lMessage=new JLabel();
		tUserId=new JTextField();
		tPassword=new JPasswordField();
		bLogin=new JButton("Login");
		empController=new Employeecontroller();
		//Event handling for Login button
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userId,password;
				Employee emp=new Employee();
				userId=tUserId.getText();
				password=new String(tPassword.getPassword());
				emp=empController.checkLogin(userId, password);
				if(emp.getUserId()==null || emp.getPassword()==null) {
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"You are not authorized user! Retry or Register!");
				}
				else {
					if(emp.getActive().equals("Active")) {
						if(emp.getRole().equals("HRA")) {
							try {
								new HRAHome();
							} catch (ClassNotFoundException | SQLException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}
						}
						else if(emp.getRole().equals("PME")) {
							new PMEHome();
						}
						else {
							try {
								new EMPHome(emp);
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else {
						JFrame f=new JFrame();
						JOptionPane.showMessageDialog(f,"User not activated !...");
					}
				}	
			}
		});
		bRegister=new JButton("Register");
		//Event handling for Register button
		bRegister.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				RegistrationFrame.main(null);
				
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("PCS User Login");
		this.setVisible(true);
		this.setBounds(300,200,500,500);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		ltitle.setBounds(120, 75, 100, 30);
		lUserId.setBounds(50, 150, 100, 30);
		lPassword.setBounds(50, 250, 100, 30);
		tUserId.setBounds(250, 150, 150, 30);
		tPassword.setBounds(250, 250, 150, 30);
		bLogin.setBounds(100, 350, 100, 30);
		bRegister.setBounds(250, 350, 100, 30);
	}
	public void addComponentsToContainer() {
		container.add(ltitle);
		container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(bLogin);
		container.add(bRegister);
	}

}

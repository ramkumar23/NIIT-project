package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.*;
import controller.Employeecontroller;

public class DeactivateEmpFrame extends JFrame{
	Container container;
	JFrame f;
	JLabel lEmployeeId;
	JTextField tEmployeeId;
	JButton bDeactivate;
	Employeecontroller empController=null;
	
	
	public DeactivateEmpFrame() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lEmployeeId=new JLabel("ENTER EMPLOYEE ID");
		tEmployeeId=new JTextField();
		bDeactivate=new JButton("DEACTIVATE");
		empController=new Employeecontroller();
		
		bDeactivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(tEmployeeId.getText());
					empController.deactivateEmployee(s);

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
		lEmployeeId.setBounds(30, 150, 300, 30);
		tEmployeeId.setBounds(300, 150, 150, 30);
		bDeactivate.setBounds(200, 250, 200, 30);
	}

	private void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(bDeactivate);
	}


}

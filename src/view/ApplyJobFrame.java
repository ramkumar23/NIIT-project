package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import config.Jdbcconnection;
import controller.Employeecontroller;

public class ApplyJobFrame extends JFrame {
	
	Container container;
	JLabel lRecruited,lEmployeeId,lJobId;
	JTextField tRecruited,tEmployeeId,tJobId;
	JButton bSubmit;
	Employeecontroller empController=null;
	JFrame f;
	public ApplyJobFrame(int s) throws ClassNotFoundException, SQLException {
		Connection conn=Jdbcconnection.getDBConnection();
		container=getContentPane();
		empController=new Employeecontroller();
		lRecruited=new JLabel("Recruited(yes/no)");
		lEmployeeId=new JLabel("Employee ID");
		lJobId=new JLabel("Job ID");
		tRecruited=new JTextField();
		tEmployeeId=new JTextField();
		tJobId=new JTextField();
		
		
		PreparedStatement pst=conn.prepareStatement("select * from employee where empid=?");
		pst.setInt(1,s);
		ResultSet rst=pst.executeQuery();
		while(rst.next())
		{
		    int a = rst.getInt("empid");
		    
		    tEmployeeId.setText(String.valueOf(a));
		}
		
		bSubmit=new JButton("SUBMIT");
		//Event handling for Register button
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int s1,s2;
				String s3;
				s1=Integer.parseInt(tEmployeeId.getText());
				s2=Integer.parseInt(tJobId.getText());
				s3=tRecruited.getText();
				try {
					PreparedStatement pst=conn.prepareStatement("Insert into empjob(EmployeeId,JobId,Recruited) values(?,?,?)");
					pst.setInt(1,s1);
					pst.setInt(2,s2);
					pst.setString(3,s3);
				
					int i=pst.executeUpdate();
					JFrame j=new JFrame();
					
					if(i==1)
					{
						//System.out.println("1 record inserted");
						JOptionPane.showMessageDialog(j,"We Have Received Your Application...");
					}
					else
					{
						//System.out.println("Insertion failed...");
						JOptionPane.showMessageDialog(j,"Something went Wrong...");
					}
				}
					catch(SQLException ex)
					{
						System.out.println(ex.getMessage());
					}
				
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Apply Job");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}


	private void setLayoutManager() {
		container.setLayout(null);
		
	}


	public void setLocationAndSize() {
		lEmployeeId.setBounds(50, 150, 100, 30);
		lJobId.setBounds(50, 250, 100, 30);
		lRecruited.setBounds(50, 350, 100, 30);
		
		tEmployeeId.setBounds(200, 150, 150, 30);
		tJobId.setBounds(200, 250, 150, 30);
		tRecruited.setBounds(200, 350, 150, 30);
		
		bSubmit.setBounds(100, 500, 100, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(tJobId);
		container.add(lJobId);
		container.add(lRecruited);
		container.add(lJobId);
		container.add(tRecruited);
		container.add(bSubmit);
		
	}

}

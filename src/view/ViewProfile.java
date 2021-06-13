package view;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import config.Jdbcconnection;

public class ViewProfile extends JFrame{
	
	JFrame frame;
	Container container;
	JLabel lEmployeeId,lFirstname,lLastname,lGender,lRole,lActive;
	JTextField tEmployeeId,tFirstname,tLastname,tGender,tRole,tActive;
	
	public ViewProfile (int s) throws ClassNotFoundException, SQLException {
		
		Connection conn=Jdbcconnection.getDBConnection();
		container=getContentPane();
		frame=new JFrame();   
		lEmployeeId=new JLabel("Employee ID");
		lFirstname=new JLabel("First Name");
		lLastname=new JLabel("Last Name");
		lGender=new JLabel("Gender");
		lRole=new JLabel("Role");
		lActive=new JLabel("Active");
		tEmployeeId=new JTextField();
		tFirstname=new JTextField();
		tLastname=new JTextField();
		tGender=new JTextField();
		tRole=new JTextField();
		tActive=new JTextField();
		PreparedStatement pst=conn.prepareStatement("select * from Employee where empId=?");
		pst.setInt(1,s);
		ResultSet rst=pst.executeQuery();
		while(rst.next())
		{
		    int a = rst.getInt("empId");
		    String b = rst.getString("FirstName");
		    String c = rst.getString("LastName");
		    String d = rst.getString("Role");
		    String e = rst.getString("Gender");
		    String f = rst.getString("Active");
		    tEmployeeId.setText(String.valueOf(a));
		    tFirstname.setText(b);
		    tLastname.setText(c);
		    tGender.setText(d);
		    tRole.setText(e);
		    tActive.setText(f);
		    container.setLayout(null);
		    setLocationAndSize();
		    addComponentsToContainer();
		    this.setVisible(true);
		    this.setBounds(10,10,500,500);
		    this.setResizable(true);
		    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("Your Profile");
		}
	}
	private void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(lFirstname);
		container.add(tFirstname);
		container.add(lLastname);
		container.add(tLastname);
		container.add(lGender);
		container.add(tGender);
		container.add(lRole);
		container.add(tRole);
		container.add(lActive);
		container.add(tActive);
	}
	private void setLocationAndSize() {
		lEmployeeId.setBounds(30, 100, 100, 30);
		lFirstname.setBounds(30, 150, 100, 30);
		lLastname.setBounds(30, 200, 100, 30);
		lGender.setBounds(30, 250, 100, 30);
		lRole.setBounds(30,300,200,30);
		lActive.setBounds(30, 350, 100, 30);
		
		tEmployeeId.setBounds(300, 100, 150, 30);
		tFirstname.setBounds(300,150,150,30);
		tLastname.setBounds(300, 200, 150, 30);
		tGender.setBounds(300,250,150,30);
		tRole.setBounds(300,300,150,30);
		tActive.setBounds(300, 350, 150, 30);
	}
}

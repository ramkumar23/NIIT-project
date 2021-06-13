package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import config.Jdbcconnection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class AppliedJobsFrame extends JFrame{
	JFrame frame;
	Container container;
	
	public AppliedJobsFrame() throws ClassNotFoundException, SQLException{
		Connection conn=Jdbcconnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"EJId","EmployeeId", "JobId", "Recruited"}, 0);
		ResultSet rst=stmt.executeQuery("select * from EmpJob");
		model.addRow(new Object[] {"EJId","EmployeeId", "JobId", "Recruited"});
		while(rst.next())
		{
		    int a = rst.getInt("EJId");
		    int b = rst.getInt("EmployeeId");
		    int c = rst.getInt("JobId");
		    String d = rst.getString("Recruited");
		    model.addRow(new Object[]{a,b,c,d});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setResizable(false);
		    this.setTitle("Information regarding Applied Jobs");
		}

	}

}

package view;

import java.awt.Container;
import java.sql.SQLException;
import java.sql.Statement;
import config.Jdbcconnection;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;

public class AllJobsFrame extends JFrame{
	JFrame frame;
	Container container;
	
	public AllJobsFrame() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbcconnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobId","JobTitle", "JobDescription", "CompanyName", "Location","KeySkill","Salary","Active"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Job");
		while(rst.next())
		{
		    int a = rst.getInt("JobId");
		    String b = rst.getString("JobTitle");
		    String c = rst.getString("JobDescription");
		    String d = rst.getString("CompanyName");
		    String e = rst.getString("Location");
		    String f = rst.getString("KeySkill");
		    String g = rst.getString("Salary");
		    String h = rst.getString("Active");
		    model.addRow(new Object[]{a,b,c,d,e,f,g,h});
		    table.setModel(model);
		    container=getContentPane();
		    setLayoutManager();
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("All Job Data");
		}

	}
	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	


}

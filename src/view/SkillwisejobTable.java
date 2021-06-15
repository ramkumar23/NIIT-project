package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import config.Jdbcconnection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SkillwisejobTable extends JFrame{
	JFrame frame;
	Container container;
	
	public SkillwisejobTable(String k) throws ClassNotFoundException, SQLException{
		Connection conn=Jdbcconnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[] {"jobtitle","jobdescription","salary","active"}, 0);
		model.addRow(new Object[] {"JOBTILE","JOBDESCRIPTION","SALARY","ACTIVE"});
		PreparedStatement pst= conn.prepareStatement("select jobtitle,jobdescription,salary,active from Job where KeySkill=?");
	    pst.setString(1,k);
	    
		ResultSet rst=pst.executeQuery();
		while (rst.next()) {
			String a = rst.getString("jobtitle");
			String b = rst.getString("jobdescription");
			String c= rst.getString("salary");
			String d=rst.getString("active");
			model.addRow(new Object[] { a, b , c, d });
			table.setModel(model);
		
		}
	    container=getContentPane();
	    setLayoutManger();
	    JScrollPane sp=new JScrollPane(table);  
	    
	    container.add(sp);
	    container.add(table);
	    
	    table.setBounds(10,10,800,900);
	    this.setVisible(true);
	    this.setBounds(10,10,800,900);	    
		this.setTitle("Skillwise Employee Data");
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}

}

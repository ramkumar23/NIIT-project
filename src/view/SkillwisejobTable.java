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
		DefaultTableModel model = new DefaultTableModel(new String[]{"EJId","EmployeeId", "JobId", "Recruited"}, 0);
		PreparedStatement pst=conn.prepareStatement("select employeeid,skillid from empskill where skillid");
		pst.setString(1,k);
		ResultSet rst=pst.executeQuery();
		if(rst!=null) {
			if(rst.next()) {
			    int a = rst.getInt("skillId");
			    String b = rst.getString("skillName");
			  
			   
			    model.addRow(new Object[]{a,b});
			}
		}
		
		table.setModel(model);
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

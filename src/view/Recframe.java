
	package view;

	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
	import javax.swing.*;

import config.Jdbcconnection;
	

	public class Recframe extends JFrame{
		Container container;
		JFrame f;
		JLabel lJobId;
		JTextField tJobId;
		JButton bActivate,bDeActivate;
		
		
		public Recframe() throws ClassNotFoundException, SQLException{
			Connection conn=Jdbcconnection.getDBConnection();
			container=getContentPane();
			f=new JFrame();
			lJobId=new JLabel("ENTER the emp id");
			tJobId=new JTextField();
			bActivate=new JButton("YES");
			bDeActivate=new JButton("NO");
			
			bActivate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int s;
					s=Integer.parseInt(tJobId.getText());
					
					try {
						PreparedStatement pst=conn.prepareStatement("update Empjob set Recruited='YES' where employeeId=?");
						pst.setInt(1,s);
						int i=pst.executeUpdate();
						JFrame g=new JFrame();
						if(i==1) {
						
							JOptionPane.showConfirmDialog(g, "updated YES ");
						}
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			bDeActivate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int s;
					s=Integer.parseInt(tJobId.getText());
					
					try {
						PreparedStatement pst=conn.prepareStatement("update Empjob set Recruited='NO' where employeeId=?");
						pst.setInt(1,s);
						int i=pst.executeUpdate();
						JFrame g=new JFrame();
						if(i==1) {
						
							JOptionPane.showConfirmDialog(g, "Updated NO ");
						}
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			setLayoutManager();
			setLocationAndSize();
			addComponentsToContainer();
			this.setTitle("Activate Job");
			this.setVisible(true);
			this.setBounds(10,10,500,600);
			//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
		}
		

		private void setLayoutManager() {
			container.setLayout(null);
			
		}
		private void setLocationAndSize() {
			lJobId.setBounds(30, 150, 300, 30);
			tJobId.setBounds(200, 150, 150, 30);
			bActivate.setBounds(200, 250, 100, 30);
			bDeActivate.setBounds(200, 300, 100, 30);
		}

		private void addComponentsToContainer() {
			container.add(lJobId);
			container.add(tJobId);
			container.add(bActivate);
			container.add(bDeActivate);
			container.setBackground(new Color(51, 204, 153));
		}


	}



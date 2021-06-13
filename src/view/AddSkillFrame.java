package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.Skillcontroller;

public class AddSkillFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	Container container;
	JLabel lSkillname,lSkilldescrip;
	JTextField tSkillname,tSkilldescrip;
	JButton bSubmit;
	Skillcontroller skillController=null;
	JFrame f;
	public AddSkillFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		skillController=new Skillcontroller();
		lSkillname=new JLabel("Skill Name");
		lSkilldescrip=new JLabel("Skill Description");
		tSkillname=new JTextField();
		tSkilldescrip=new JTextField();
		
		bSubmit=new JButton("SUBMIT");
		//Event handling for Register button
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s1,s2;
				s1=tSkillname.getText();
				s2=tSkilldescrip.getText();
				try {
					skillController.addSkill(s1, s2);
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				f=new JFrame();
				JOptionPane.showMessageDialog(f,"Skill Added");
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Add Skill");
		this.setVisible(true);
		this.setBounds(10,10,500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}


	private void setLayoutManager() {
		container.setLayout(null);
		
	}


	public void setLocationAndSize() {
		lSkillname.setBounds(50, 150, 100, 30);
		lSkilldescrip.setBounds(50, 250, 100, 30);
		
		tSkillname.setBounds(200, 150, 150, 30);
		tSkilldescrip.setBounds(200, 250, 150, 30);
		
		bSubmit.setBounds(100, 450, 100, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(lSkillname);
		container.add(tSkillname);
		container.add(tSkilldescrip);
		container.add(lSkilldescrip);
		container.add(bSubmit);
		
	}
}


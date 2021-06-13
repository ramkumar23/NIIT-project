package view;

import java.awt.*;
import javax.swing.*;

public class setActiveFrame extends JFrame {
	Container container=null;
	 public setActiveFrame() {
		 container=getContentPane();
		 
		 this.setTitle("Activate User Screen");
		 this.setVisible(true);
		 this.setBounds(10, 10, 500, 600);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
	 }

}

package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Work extends Frame implements ActionListener{

	public Work() {
	Button btnA=	new Button("A");
	Button btnB=	new Button("B");
		
	Panel panelCenter=new Panel();
	panelCenter.add(btnA);
	panelCenter.add(btnB);
	
	add("Center",panelCenter);
	
	btnA.addActionListener(this);
	
	setBounds(100, 100, 300, 200);
	
	setVisible(true);
	
	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent we) {
			dispose();
		}
	});
	}
	
	public static void main(String[] args) {
		new Work();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

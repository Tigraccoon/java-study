package ch17;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FlowExam extends JFrame {
	public FlowExam() {
		setLayout(new FlowLayout());
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(int i=1;i<=12;i++) {
			JButton button = new JButton("Button"+String.valueOf(i));
			add(button);
		}
		
	}
	
	public static void main(String[] args) {
		new FlowExam();
		
	}
	
}

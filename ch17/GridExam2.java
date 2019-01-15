package ch17;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GridExam2 extends JFrame {
	public GridExam2() {
		setLayout(new GridLayout(4,3));
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(int i=1;i<=12;i++) {
			JButton button = new JButton("Button"+String.valueOf(i));
			add(button);
		}
		
	}
	
	public static void main(String[] args) {
		new GridExam2();
		
	}
	
}

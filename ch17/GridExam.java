package ch17;

//import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GridExam extends JFrame {
	public GridExam() {
		setLayout(new GridLayout(2,3));	//2행, 3열
//		setLayout(new FlowLayout());
		for(int i=1;i<=6;i++) {
			JButton button = new JButton("Button"+String.valueOf(i));
			add(button);
		}
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new GridExam();
		
	}
	
}

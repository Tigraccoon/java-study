package ch17;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelExam extends JFrame {
	
	public PanelExam() {
		JPanel p = new JPanel();	//패널 생성
		p.setBackground(Color.RED);
		JButton button1 = new JButton("버튼1");	//버튼 생성
		JButton button2 = new JButton("버튼2");
		JButton button3 = new JButton("버튼3");
		JButton button4 = new JButton("버튼4");
		JButton button5 = new JButton("버튼5");
		JButton button6 = new JButton("버튼6");
		
		p.add(button1);
		p.add(button6);
		
		add(p,BorderLayout.NORTH);	//Panel을 North에 add
		add(button2);	//위치를 생략하면 기본값인 Center로 배치
		add(button3,"South");
		add(button4,"West");
		add(button5,"East");
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new PanelExam();
		
	}
	
}

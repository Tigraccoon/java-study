package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelExam2 extends JFrame {
	public PanelExam2(){
		
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel northPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		
		JButton b1 = new JButton("버튼1");
		JButton b2 = new JButton("버튼2");
		JButton b3 = new JButton("버튼3");
		JButton b4 = new JButton("버튼4");
		JButton b5 = new JButton("버튼5");
		JButton b6 = new JButton("버튼6");
		JButton b7 = new JButton("버튼7");
		JButton b8 = new JButton("버튼8");
		
		northPanel.add(b1);
		northPanel.add(b2);
		westPanel.add(b3);
		westPanel.add(b4);
		eastPanel.add(b6);
		eastPanel.add(b7);
		
		Color yellow = new Color(230,255,00);
		Color blue = new Color(00,00,255);
		Color purple = new Color(167,77,255);
		
		northPanel.setBackground(yellow);
		eastPanel.setBackground(blue);
		b1.setBackground(purple);
		b1.setContentAreaFilled(true);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("궁서체",Font.BOLD,40));
		
		add(northPanel,"North");
		add(westPanel,BorderLayout.WEST);
		add(b5,"Center");	//Center는 생략가능
		add(eastPanel,"East");
		add(b8,"South");
		
		
		
		
	}
	
	public static void main(String[] args) {
		new PanelExam2();
		
	}
	
}

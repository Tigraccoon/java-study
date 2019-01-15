package ch17;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class EventExam3 extends JFrame {
	private JButton b1,b2,b3,b4,b5,b6;
	
	public EventExam3() {
		setLayout(new FlowLayout());
		b1 = new JButton("Red");
		b2 = new JButton("Green");
		b3 = new JButton("Blue");
		b4 = new JButton("White");
		b5 = new JButton("Yellow");
		b6 = new JButton("Cyan");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		//버튼 클릭에 이벤트 기능 추가
		//버튼을 누르면 MyColorAction 클래스에 구현한 actionPerformed()호출
		b1.addActionListener(new MyColorAction(this,Color.RED));
		b2.addActionListener(new MyColorAction(this,Color.GREEN));
		b3.addActionListener(new MyColorAction(this,Color.BLUE));
		b4.addActionListener(new MyColorAction(this,Color.WHITE));
		b5.addActionListener(new MyColorAction(this,Color.YELLOW));
		b6.addActionListener(new MyColorAction(this,Color.CYAN));
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new EventExam3();
		
	}
	
}

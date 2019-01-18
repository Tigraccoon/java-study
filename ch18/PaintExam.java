package ch18;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PaintExam extends JFrame {
	public PaintExam() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);	//JFrame의 paint가 실행됨
		//drawString("문자열",x좌표,y좌표) : 문자열을 그래픽 형태로 출력하는 메소드
		g.setColor(Color.BLUE);
		g.drawString("hello java?", 50, 60);
		g.drawOval(100, 100, 50, 50);
		g.fillOval(30, 100, 50, 50);
		g.setColor(Color.GREEN);
		g.drawRect(200, 200, 50, 50);
		g.fillRect(100, 200, 50, 50);
		
	}

	public static void main(String[] args) {
		new PaintExam();
	}
	
}

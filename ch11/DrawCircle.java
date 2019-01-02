package ch11;

import java.awt.Graphics;

public class DrawCircle extends Point implements Draw {
	private int width, height;//멤버변수 0,0
	public DrawCircle() {//기본생성자
		this(0,0,0,0);//DrawCircle(a,b,c,d)
	}
	public DrawCircle(int a, int b, int w, int h) {
		super(a,b); //부모클래스 Point(a,b) 생성자 호출
		width = w;
		height = h;
	}

	@Override
	public void paint(Graphics g) {
		//타원그리기(x,y,가로,세로)
		g.drawOval(a, b, width, height);
	}

}

package ch16;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

@SuppressWarnings("serial")
public class Ball extends Applet implements Runnable, ComponentListener {

	private int x,y;
	private int mx=2,my=3;
	private int width=200,height=200;
	
	//애플릿을 초기화시키는 메소드
	
	public void init() {
		//화면의 변화를 감지하는 이벤트 처리
		//이벤트 소스, 이벤트 리스너(이벤트 핸들러)
		this.addComponentListener(this);//A(Ball) is a B(Applet)
		//this는 Applet
		//새로운 쓰레드 생성
		Thread t = new Thread(this);
		//새로운 작업 단위가 할당되고 run()이 실행
		t.start();
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		//Graphics 자바의 그래픽 처리 클래스
		g.setColor(Color.BLUE);	//색상 변경
		g.fillOval(x, y, 30, 30);
		//fillOval(시작 x좌표, 시작 y좌표, 가로 길이, 세로 길이) - 타원을 그리는 메소드
	}//paint
	
	
	@Override
	public void run() {
		while(true) {	//무한 반복
			//x, t 좌표값 변경
			if(x > (width-30) || x < 0) {	
				//공이 x축 벽에 맞았을때 좌표가 오른쪽 벽에서 -30만큼 공 포인터가 있어야 하고 x가 음수가 되면 안 됌
				mx = -mx;	//부호 변환으로 방향을 반대로
			}
			x+=mx;	//x좌표의 가중치 부여
			
			if(y > (height-30) || y < 0) {
				//공이 y축 벽에 맞았을 때 좌표가 하단 벽에서 -30만큼 공 포인터가 있어야 하고 y가 음수가 되면 안 됌
				my = -my;	//부호 변환으로 방향을 반대로
			}
			y+=my;
			
			repaint();	//화면을 새로 그림 -> paint() 호출
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}//run
	

	@Override
	public void componentResized(ComponentEvent e) {
		//화면의 가로, 세로 사이즈를 저장(화면 크기가 바뀌더라도 정상적으로 출력되게 해줌)
		width = getWidth();
		height = getHeight();
		
		System.out.println("가로 : "+width);
		System.out.println("세로 : "+height);
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
	}

	
	
	
}

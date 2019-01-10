package ch16;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Anim2 extends Applet implements Runnable{
	
	private Image[] img;//이미지 배열
	private int idx; //이미지배열의 인덱스값
	
	@Override
	public void init() {
		img = new Image[10];//이미지 10개를 가리키는 객체 참조변수 배열생성
		for(int i=0; i<img.length; i++) {
			img[i]=Toolkit.getDefaultToolkit().getImage(getClass().getResource("aduke"+(i+1)+".gif"));
			//배열은 0부터인데 이미지파일이름은 duke1부터라 +1을 해줌.
		}//end for
		Thread t=new Thread(this);
		t.start();
		setSize(500,200); //애플릿의 화면 크기 조정
	}//end init()
		
	@Override
	public void paint(Graphics g) {
		g.drawImage(img[idx], 90, 73, this);
	}

	@Override
	public void run() {
		while(true) {
			idx++; //이미지의 인덱스 증가
			//인덱스가 10이 되면 0으로 초기화(0~9 로테이션)
			if(idx >= 10) {
				idx=0;
			}
			repaint();//paint()호출
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

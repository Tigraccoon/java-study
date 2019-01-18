package ch18;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameColor extends JFrame {
	public FrameColor() throws InterruptedException {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//프래임의 컨텐츠 영역 설정
		Container c = getContentPane();
		for(int i=0;i<=255;i++) {
			setSize(i*2,i);			//프레임의 사이즈 변경
			setLocation(i*2, i);	//프레임의 좌표값
			c.setBackground(new Color(i,0,0));	//배경 색상 설정
			Thread.sleep(1);
		}
		
		for(int i=0;i<=255;i++) {
			setSize(i*2,i);			//프레임의 사이즈 변경
			setLocation(i*2, i);	//프레임의 좌표값
			c.setBackground(new Color(255,i,0));	//배경 색상 설정
			Thread.sleep(1);
		}
		
		for(int i=0;i<=255;i++) {
			setSize(+i*2,i);			//프레임의 사이즈 변경
			setLocation(i*2, i);	//프레임의 좌표값
			c.setBackground(new Color(255,255,i));	//배경 색상 설정
			Thread.sleep(1);
		}
		System.exit(0);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new FrameColor();
		
	}
}

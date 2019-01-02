package ch12;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class InnerExam extends Frame {
	public InnerExam() {
		super("내부 클래스 테스트");	//super()를 썼으므로 상위 클래스인 Frame 클래스의 생성자 호출 및 제목 삽입
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		InnerExam e=new InnerExam();	//객채 생성 및 생성자 호출
		e.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			@Override	//윈도우 창이 닫힐 때 호출 * 이벤트처리
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
	
	}
	
}

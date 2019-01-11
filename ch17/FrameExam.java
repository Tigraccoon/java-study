package ch17;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;

//AWT : java, C로 개발
//Swing : AWT를 향상시킨 버젼, java로 개발

public class FrameExam {
	public static void main(String[] args) {
		//Frame 생성(윈도우 화면을 띄우는 클래스) Frame(String title);
		Frame f = new Frame("프레임 타이틀");
		//프레임의 사이즈 설정
		f.setSize(800, 300);
		//프레임 화면에 표시(True or False)
		f.setVisible(true);
		
		//이벤트 소스, 이벤트 리스너(이벤트 핸들러)
		//add***Listener
		//addMouseListener, AddKeyListener, ...
		
//		f.addWindowListener(new WindowListener() {
//			
//			@Override
//			public void windowOpened(WindowEvent e) {
//				
//			}
//			
//			@Override
//			public void windowIconified(WindowEvent e) {
//				
//			}
//			
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				
//			}
//			
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				
//			}
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				//x 버튼을 눌렀을때 프로그램을 종료
//				//정상 종료 : 0, 비정상종료 : -1
//				System.exit(0);
//			}
//			
//			@Override
//			public void windowClosed(WindowEvent e) {
//				
//			}
//			
//			@Override
//			public void windowActivated(WindowEvent e) {
//				
//			}
//		});	//1회성 무명 클래스
		
		
		//WindowAdapter는 abstract / WindowListener는 interface
		//abstract는 추상 정도가 낮아서 반드시 오버라이딩 할 필요가 없으므로 사용할 메소드만 오버라이딩 하여 사용
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
}

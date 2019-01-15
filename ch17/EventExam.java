package ch17;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class EventExam extends Frame{
	//이벤트 처리하는 방법
	//1. WindowListener익명내부클래스로 구현
	//2. 윈도우 아답터 익명내부클래스로 구현
	//3. 외부파일에서 구현
	public EventExam() {
		setSize(300,300);//프레임의 가로,세로 초기사이즈 설정
		setVisible(true);//프레임을 화면에 표시
		//이벤트소스.이벤트리스너(이벤트핸들러)
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
//		this.addWindowListener(new WindowListener() {
//			
//			@Override
//			public void windowOpened(WindowEvent e) {
//			}
//			@Override
//			public void windowIconified(WindowEvent e) {
//			}
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//			}
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//			}
//			@Override
//			public void windowClosing(WindowEvent e) {
//				//프로그램종료(정상종료:0, 비정상종료:-1)
//				System.exit(0);
//			}
//			@Override
//			public void windowClosed(WindowEvent e) {
//			}
//			@Override
//			public void windowActivated(WindowEvent e) {
//			}
//		});//익명내부클래스, 이벤트처리기
	}
	
	public static void main(String[] args) {
		new EventExam();
	}
	
	

}

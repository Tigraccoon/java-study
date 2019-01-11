package ch17;

import javax.swing.JFrame;

public class FrameExam2 {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		f.setTitle("프래임 타이틀");
		f.setSize(800, 300);
		f.setVisible(true);
		
		//EXIT_ON_CLOSE : 창닫기, 프로그램 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//HIDE_ON_CLOSE : 프로그램 숨김
//		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//DIPOSIT_ON_CLOSE : 현재 창만 닫음
//		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
}

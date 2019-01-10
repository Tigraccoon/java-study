package ch16;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CountDownTest extends JFrame {
	private JLabel label;
	
	class MyThread extends Thread {	//내부 클래쓰
		@Override
		public void run() {
			for (int i=10;i>=0;i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				label.setText(String.valueOf(i));
				
			}	//for
			
		}	//run
		
	}	//MyThread
	
	
	public CountDownTest() {
		setTitle("카운트다운");	//타이틀
		setSize(300, 200);		//크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//창닫기 기능
		
		label = new JLabel("Start");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		add(label);
		(new MyThread()).start();
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		CountDownTest t = new CountDownTest();
		t.getColorModel();
		
	}
	
}

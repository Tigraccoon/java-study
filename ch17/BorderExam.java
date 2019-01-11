package ch17;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BorderExam extends JFrame {
	public BorderExam() {
		setTitle("BorderLayout 테스트");	//타이틀 설정
		setSize(500,300);	//화면 사이즈
		setVisible(true);	//화면 표시여부
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//창닫기, 프로그램 종료
		JButton button1 = new JButton("버튼1");	//버튼 생성
		JButton button2 = new JButton("버튼2");
		JButton button3 = new JButton("버튼3");
		JButton button4 = new JButton("버튼4");
		JButton button5 = new JButton("버튼5");
		JButton button6 = new JButton("버튼6");
		
		this.add(button1);	//this : 이 프레임
//		this.add(button2);
//		this.add(button3);
//		this.add(button4);
//		this.add(button5);
//		this.add(button6);
		
		//패널 위치 첫 문자는 대문자
		add(button2,"North");
		add(button3,"South");
		add(button4,"East");
		add(button5,"West");
		add(button6,"West");
		
		JPanel p = new JPanel();
		add(p,"West");	//West영역에 패널을 붙임
		p.add(button5);
		p.add(button6);
		
	}
	
	public static void main(String[] args) {
		new BorderExam();	//생성자가 자동으로 호출
		//BorderLayout이 기본 레이아웃이기 때문에 기본 Center에 배치됨.
		//한 영역에 한 컴포넌트만 배치, 만약 2개 이상의 컴포넌트를 배치하려면 패널을 사용
		
		
		
		
	}
	
}

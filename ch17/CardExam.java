package ch17;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CardExam extends JFrame {
	CardLayout card;
	Container con;
	
	public CardExam() {
		con = getContentPane();	//프래임의 컨텐츠 영역
		card = new CardLayout();
		setLayout(card);	//기본 레이아웃인 border 레이아웃에서 card레이아웃으로 변경
		JPanel[] pan = new JPanel[8];	//패널 참조변수 5개
		Color[] color = {Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE,Color.CYAN,new Color(100,50,200),Color.PINK,Color.BLACK};	//색상 배열
		
		for(int i=0;i<pan.length;i++) {
			pan[i] = new JPanel();	//패널 생성
			pan[i].setBackground(color[i]);	//패널의 배경 설정
			add("card"+i,pan[i]);	//add("이름",컴포넌트);
			//패널에 마우스 이벤트 추가
			
			pan[i].addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					card.next(con);	//다음 화면으로 이동
//					card.previous(con); //이전 화면으로 이동
				}
				
			});	//익명클래스
			
			setSize(300,300);	//프래임 사이즈 설정
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
		
	}
	
	public static void main(String[] args) {
		new CardExam();
	}
	
}

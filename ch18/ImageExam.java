package ch18;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ImageExam extends JFrame implements ActionListener {
	
	Image curImg;
	Panel p, view;
	JButton btnNormal, btnPart, btnScale, btnHori, btnVert, btnAll;
	Dimension d;	//화면의 가로, 세로, 길이 등의 정보를 저장하는 클래쓰
	int command;
	static final int SHOW_NORM = 0;
	static final int SHOW_PART = 1;
	static final int SHOW_SCALE = 2;
	static final int SHOW_HORI = 3;
	static final int SHOW_VERT = 4;
	static final int SHOW_ALL = 5;
	
	public ImageExam(){
		//상대 경로
		curImg = Toolkit.getDefaultToolkit().getImage((getClass().getResource("flower.jpg")));
		//절대 경로
//		curImg = Toolkit.getDefaultToolkit().getImage("D:\\work_java\\JavaProject\\src\\ch18\\flower.jpg");
		
		p = new Panel();
		btnNormal = new JButton("정상그림");
		p.add(btnNormal);
		p.add(btnPart = new JButton("그림 일부"));
		p.add(btnScale = new JButton("축소"));
		p.add(btnHori = new JButton("좌우 반전"));
		p.add(btnVert = new JButton("상하 반전"));
		p.add(btnAll = new JButton("전체 반전"));
		
		//패널을 north에 배치
		add(p, BorderLayout.NORTH);
		
		//이벤트 리스너 연결
		this.btnNormal.addActionListener(this);
		this.btnPart.addActionListener(this);
		this.btnScale.addActionListener(this);
		this.btnHori.addActionListener(this);
		this.btnVert.addActionListener(this);
		this.btnAll.addActionListener(this);
		
		this.setSize(600,400);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == btnNormal) {	//정상 그림 버튼
			command = SHOW_NORM;
		}else if (btn == btnPart) {	//부분 그림 버튼
			command = SHOW_PART;
		}else if (btn == btnScale) {//축소 그림 버튼
			command = SHOW_SCALE;
		}else if (btn == btnHori) {	//좌우 반전 버튼
			command = SHOW_HORI;
		}else if (btn == btnVert) {	//상하 반전 버튼
			command = SHOW_VERT;
		}else if (btn == btnAll) {	//전체 반전 버튼
			command = SHOW_ALL;
		}
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		d = p.getSize();
		switch(command) {
		case SHOW_NORM : g.drawImage(curImg, 10, d.height, this); break;
		//d.height는  버튼이 위치한 패널의 높이 만큼 y좌표값을 조절
		case SHOW_PART : g.drawImage(curImg, 10, d.height, 100, d.height+100, 60, 60, 120, 120, this); break;
		case SHOW_SCALE : g.drawImage(curImg, 10, d.height, curImg.getWidth(this)/2, d.height+curImg.getHeight(this)/2
							, 0, 0, curImg.getWidth(this), curImg.getHeight(this), this); break;
		case SHOW_HORI : g.drawImage(curImg, curImg.getWidth(this), d.height, 0, d.height+curImg.getHeight(this)
		, 0, 0, curImg.getWidth(this), curImg.getHeight(this), this); break;
		case SHOW_VERT : g.drawImage(curImg, 10, d.height+curImg.getHeight(this), curImg.getWidth(this), d.height
							, 0, 0, curImg.getWidth(this), curImg.getHeight(this), this); break;
		case SHOW_ALL : 			g.drawImage(curImg, curImg.getWidth(this), d.height+curImg.getHeight(this), 
				0, d.height, 0, 0, curImg.getWidth(this), 
				curImg.getHeight(this), this); break;
		
		}
	}
	
	public static void main(String[] args) {
		new ImageExam();
	}
	
}

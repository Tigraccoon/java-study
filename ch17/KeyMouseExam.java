package ch17;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//MouseListener : 마우스 이벤트 처리를 위한 리스너(인터페이스)
//MouseMotionListener : 마우스 이동 이벤트 처리를 위한 리스너
//KeyListener : 키보드 이벤트 처리를 위한 리스너

import javax.swing.JApplet;


@SuppressWarnings("serial")
public class KeyMouseExam extends JApplet implements MouseListener, MouseMotionListener, KeyListener {
	private int x, y;			//이미지를 출력할 x, y좌표값
	private int width, height;	//이미지의 가로, 세로 사이즈
	private Image img;			//이미지가 car.gif를 사용할 변수
	private boolean flag = false;//이미지가 처음 실해할땐 안보이게 boolean으로 false처리

	@Override
	public void init() {
		setSize(300,300);
		img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("car.gif"));
		//현재 클래스에 마우스 이벤트 기능을 추가
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//현재 클래스에 키 이벤트 기능을 추가
		this.addKeyListener(this);
		//키 입력을 받을 수 있도록 설정
		setFocusable(true);
		//현재 화면에 키 입력을 요청
		requestFocus();

	}//init 애플렛이 실행될 때 먼저 실행

	//화면 출력 메쏘드
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//이미지의 가로, 세로 길이 계산
		width = img.getWidth(null);
		height = img.getHeight(null);
		System.out.println(width+"\n"+height);
		if (flag) {	//마우스 클릭 시 true
			g.drawImage(img, x, y, this);
		}

	}//paint

	@Override
	public void keyTyped(KeyEvent e) {
		//키보드의 키를 입력하면 호출

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//키보드의 키를 누를 때 호출
		System.out.println(e.getKeyCode());	//키 코드값
		System.out.println(e.getKeyChar());	//키 문자
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP : y = Math.max(0, y-5); break;	//키보드 위쪽 키
		case KeyEvent.VK_DOWN : y = Math.min(300-height, y+5); break;
		case KeyEvent.VK_LEFT : x = Math.max(0, x-5); break;
		case KeyEvent.VK_RIGHT : x = Math.min(300-width, x+5); break;
		}
		repaint();	//그래픽 갱신
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//키보드의 키를 땔 때 호출
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//컴포넌트에서 마우스 버튼을 눌러 드래그를 했을 때
		System.out.println("Mouse Drag x : "+x+"\nMouse Drag y : "+y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//컴포넌트 상에 마우스가 이동했지만 버튼이 작동 안 한 경우 호출
		x = e.getX();
		y = e.getY();
		System.out.println("Mouse Move x : "+x+"\nMouse Move y : "+y);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		flag = true;	//클릭 시 flag를 true로 설정하여 보여지게 함
		//마우스가 클릭한 좌표 설정
		x = e.getX();
		y = e.getY();
		//그래픽 갱신 요청
		repaint();//paint() 메소드를 호출

	}

	@Override
	public void mousePressed(MouseEvent e) {
		//컴포넌트 상에 마우스가 눌렸을 때 호출
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//컴포넌트 상에 마우스가 눌렀다 땔 때 호출
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//마우스가 컴포넌트에 들어올 때 호출
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//마우스가 컴포넌트에서 나갈 때 호출
	}

}

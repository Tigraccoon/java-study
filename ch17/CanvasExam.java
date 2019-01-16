package ch17;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
class BallCanvas extends Canvas implements Runnable, ComponentListener{
	private int x,y;
	private int moveX=2, moveY=2; //x,y이동할 좌표값
	private int red,green,blue;
	private Random random;
	private int width, height;//화면 가로,세로 사이즈
	
	public BallCanvas() {
		//이벤트소스.이벤트리스너(이벤트핸들러)
		this.addComponentListener(this);
		random = new Random();
		//백그라운드 스레드 생성
		Thread th=new Thread(this);
		th.start();//백그라운드 스레드 시작 요청==>run메소드 호출
	}
	@Override
	public void paint(Graphics g) {
		//색상설정
		g.setColor(new Color(red,green,blue));
		//타원 그리기(x,y,width,height)
		g.fillOval(x, y, 20, 20);
	}
	
	void setColor() {
		//랜덤.nextInt(num) 0 ~ (num-1) 사이의 난수 발생
		red = random.nextInt(256);//0~255
		green = random.nextInt(256);
		blue = random.nextInt(256);
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		//가로,세로 사이즈 저장
		width = getWidth();
		height = getHeight();
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		
	}
	@Override
	public void run() {
		while(true) {//무한 반복
			if(x > (width-20) || x < 0) {//좌우 벽처리
				setColor();
				moveX = -moveX;
			}
			if(y > (height-20) || y < 0) {//상하 벽처리
				setColor();
				moveY = -moveY;
			}
			x += moveX;//x=x+moveX
			y += moveY;
			repaint();//그래픽 갱신 요청 => paint()가 호출됨
			
			try {
				Thread.sleep(10);//cpu 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}


@SuppressWarnings("serial")
public class CanvasExam extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CanvasExam frame = new CanvasExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CanvasExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		BallCanvas canvas=new BallCanvas();
		canvas.setBackground(Color.YELLOW);//캔버스의 배경색상
		//캔버스객체를 프레임에 붙임
		contentPane.add(canvas);
	}

}

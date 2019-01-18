package ch18;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

//키 이벤트 : KeyListener, 멀티쓰레드 : Runnable
@SuppressWarnings("serial")
public class Game extends JApplet implements KeyListener, Runnable{
	
	private Image imgBackground;	//배경
	private Image imgGunship;		//비행기
	private Image imgMissile;		//미사일
	private Image imgEnemy;			//적기
	private Image imgHit;			//폭발
	private AudioClip audioFire;	//총알 사운드
	private AudioClip audioHit;		//폭발 사운드
	private int x, y = 270;			//비행기 좌표
	@SuppressWarnings("unused")
	private int mx = x + 10;		//미사일 좌표
	@SuppressWarnings("unused")
	private int my = y - 10;
	private int ex, ey = 50;		//적기 좌표
	private int moveEx = 2;			//적기의 좌표 이동값
	private int hitX, hitY;			//폭발지점의 좌표
	private int point = 1000;		//점수
	private boolean hit;			//폭발상태(true = 폭발, false = 폭발 안 된 상태)
	
	//미사일 리스트
	ArrayList<Missile> mlist = new ArrayList<Missile>();
	//더블 버퍼링을 위한 변수
	private Image offImage;
	private Graphics bg;
	
	@Override
	public void init() {
		this.setSize(300,300);
		//더블 버퍼링을 위한 백그라운드 이미지 영역 생성
		offImage = createImage(this.getWidth(),this.getHeight());
		bg = offImage.getGraphics();
		
		//이미지 객체 생성
		imgBackground = Toolkit.getDefaultToolkit().getImage(getClass().getResource("space.png"));
		imgGunship = Toolkit.getDefaultToolkit().getImage(getClass().getResource("gunship.png"));
		imgMissile = Toolkit.getDefaultToolkit().getImage(getClass().getResource("missile.png"));
		imgEnemy = Toolkit.getDefaultToolkit().getImage(getClass().getResource("enemy.png"));
		imgHit = Toolkit.getDefaultToolkit().getImage(getClass().getResource("hit.png"));
		
		//사운드 객체 생성
		audioFire = getAudioClip(getClass().getResource("fire.wav"));
		audioHit = getAudioClip(getClass().getResource("hit.wav"));
		
		//이벤트 추가
		this.addKeyListener(this);	//애플릿에 키 이벤트 기능 추가
		this.setFocusable(true);	//클릭하지 않더라도 포커스를 설정
		this.requestFocus(true);	//현재 화면에 입력 포커스를 설정
		
		//Thread 객체 생성
		Thread t = new Thread(this);
		t.start();	//run()
		
	}
	
	@Override
	public void start() {
		//비행기의 초기 좌표
		x = getWidth() / 2 - 15;
		//총알의 초기 좌표
		mx = getWidth() / 2 - 2;
		//적기 초기 좌표
		ex = getWidth() - 25;
		
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		bg.clearRect(0, 0, getWidth(), getHeight());	//이미지 클리어
		bg.drawImage(imgBackground, 0, 0, this);		//배경 이미지 처리
		bg.drawImage(imgGunship, x, y, this);			//아군기 이미지 처리
		
		//총알 리스트를 화면에 출력
		for(int i=0;i<mlist.size();i++) {
			Missile m = mlist.get(i);
			bg.drawImage(imgMissile, m.getMx(), m.getMy(), this);
		}
		
		if (hit) {
			bg.drawImage(imgHit, hitX, hitY, this);	//폭발 이미지 처리
			hit = false;
		} else {
			bg.drawImage(imgEnemy, ex, ey, this);
		}
		
		bg.setColor(Color.white);
		bg.drawString("점수 : "+point, 20, 20);
		g.drawImage(offImage, 0, 0, this);	//그래픽 화면에 출력
		
	}

	@Override
	public void run() {
		while(true) {
			for(int i=0;i<mlist.size();i++) {
				Missile m = mlist.get(i);	//i 번째 총알 객체를 꺼냄
				//총알의 y좌표를 감소
				m.setMy(m.getMy() - 5);
				//총알의 y좌표가 0이 되면 발사 대기상태로 전환
				if(m.getMy() == 0) {
					mlist.remove(i);	//총알 리스트에서 제거
				}
				//충돌 체크
				Rectangle rec1 = new Rectangle(ex, ey, imgEnemy.getWidth(null), imgEnemy.getHeight(null));
				Rectangle rec2 = new Rectangle(m.getMx(), m.getMy(), imgMissile.getWidth(null),imgMissile.getHeight(null));
				
				//두 사각 영역이 교집합이 있으면
				if(rec1.intersects(rec2)) {
					System.out.println("충돌");
					audioHit.play();	//폭발음 플레이
					hit = true;
					//폭발 지점의 좌표 저장
					hitX = m.getMx() - 30;
					hitY = m.getMy() - 30;
					//점수 처리
					point += 100;
					//총알, 적기 좌표를 초기화
					setMissilePos();
					ex = getWidth() - 25;
					ey = 0;
					//총알 제거
					mlist.remove(i);
					
					
				}//if
				
			}//for
			
			//적기 좌표 변경
			ex -= moveEx;
			if(ex < 0 || ex > getWidth() - 25) {
				moveEx = -moveEx;
				ey += 10;
			}
			if(ey == (getHeight() - imgGunship.getHeight(this))) {
				int result = JOptionPane.showConfirmDialog(this, "GAME OVER... RESTART?");
				if(result == JOptionPane.NO_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.YES_OPTION) {
					ex = getWidth() - 25;
					ey = 0;
					point = 1000;
				}
				
			}
			
			repaint();
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}//while
		
	}

	private void setMissilePos() {
		mx = x + 13;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {	//키보드의 키값을 가져옴
		case KeyEvent.VK_LEFT : x = Math.max(0, x - 5); setMissilePos(); break;
		case KeyEvent.VK_RIGHT : x = Math.min(300-imgGunship.getWidth(null), x + 5); setMissilePos(); break;
		case KeyEvent.VK_A : Missile m = new Missile();
			m.setMx(x+imgGunship.getWidth(null)/2);	//총알의 x좌표
			m.setMy(y);	//총알의 y좌표
			mlist.add(m);	//리스트에 총알 객체를 추가
			audioFire.play();	//총알 사운드 플레이
			break;
			
		}
		
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}

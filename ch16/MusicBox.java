package ch16;

//MusicBox에는 세 개의 메소드가 존재(신나는 음악, 슬픈 음악, 카페 음악)
//Player 세 명이 하나의 MusicBox를 사용 이때 어떤 일이 발생하는지 살펴봄

public class MusicBox {	//공유 객체
	//신나는 음악! 이란 메세지가 1초 이하로 쉬면서 10번 반복 출력
	//synchronized를 붙이면 해당 메소드는 객체의 사용권(Monitoring Lock)을 얻는다.
	//즉, 해당 메소드가 다 실행된 후 다른 메소드가 실행된다.
	public synchronized void playMusicA() {
		for(int i=0;i<10;i++) {
			System.out.println("씬나는 음악!");
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	//playMusicA
	
	public synchronized void playMusicB() {
		for(int i=0;i<10;i++) {
			System.out.println("슬픈 음악..");
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	//playMusicB
	
	public void playMusicC() {
		synchronized (this) {	
			//synchronized를 메소드에 붙여서 사용 할 경우 메소드의 코드가 길어지면 마지막에 대기하는 쓰레드가 너무오래 기다리는 것을 막기 위해
			//메소드에 synchronized를 붙이지 않고 문제가 있을 것 같은 부분만 synchronized 블록을 사용
			System.out.println("카페 음악?");
		}
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	//playMusicC
	
}

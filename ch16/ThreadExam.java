package ch16;

//멀티쓰레드 : 작업단위가 2개 이상
//멀티쓰레드를 구현하는 방법 :
//1. Thread를 상속
//2. Runnable을 구현

public class ThreadExam extends Thread{
	public ThreadExam() {}
	public ThreadExam(String name) {
		super(name);	//부모 클래스의 생성자 호출, 쓰레드의 title 설정
		
	}	//ThreadExam(String name)
	
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000); //cpu의 실행을 1초간 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();	//에러 메세지를 화면에 출력
			}	
		}
	}	//run
	
	public static void main(String[] args) {
		ThreadExam t1 = new ThreadExam("Thread1");
		ThreadExam t2 = new ThreadExam("Thread2");
		ThreadExam t3 = new ThreadExam("Thread3");
		
		t1.start();	//쓰레드 객체.start() -> run()이 호출됌
		t2.start();	//위와 동시에 호출
		t3.start();	//위와 동시에 호출, 즉 여기선 3개가 동시에 run()을 호출
		//run()을 호출하면 메인 쓰레드가 실행되기 때문에 주의해야 한다
		
	}
	
}

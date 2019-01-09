package ch16;

public class ThreadJoin extends Thread {
	//join : join 메소드를 호출한 쓰레드가 종료될 때까지 현재의 쓰레드를 대기시킴
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" 쓰레드가 시작됐다.");
		ThreadJoin e = new ThreadJoin();
		e.setName("Thread1");
		e.start();	//run() 실행
		
		try {
			e.join();	//새로운 작업을 요청하면 기다렸다가 다시 실행. 싱글 쓰레드처럼
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" 쓰레드가 종료됐다.");
		
		
	}
	
	@Override
	public void run() {
		//현재 실행중인 쓰레드의 이름
		System.out.println(Thread.currentThread().getName()+" 쓰레드가 시작됐다.");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" 쓰레드가 종료됐다.");
		
	}
	
}

package ch16;

public class ThreadA {
	public static void main(String[] args) {	//main -> Thread
		ThreadB t = new ThreadB();	//ThreadB -> Thread
		
		t.start();
		
		synchronized (t) {
			System.out.println("t가 완료될 때까지 기다립니다.");
			try {
				t.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Total is "+t.total);
		}	//synchronized
		
		
	}
	
}

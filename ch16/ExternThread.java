package ch16;

public class ExternThread {
	public static void main(String[] args) {
		//Thread 기능을 외부 클래스에서 구현
		
		MyThread t1 = new MyThread("Thread1");
		MyThread t2 = new MyThread("Thread2");
		
		t1.start();
		t2.start();
		
	}
	
}

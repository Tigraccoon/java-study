package ch16;

public class ThreadRunUseEx {
	public static void main(String[] args) {
		MyThreadRunEx t1 = new MyThreadRunEx("Thread one");
		MyThreadRunEx t2 = new MyThreadRunEx("Thread two");
		MyThreadRunEx t3 = new MyThreadRunEx("Thread three");
		
		System.out.println("main Thread");
		
		Thread e1 = new Thread(t1);
		Thread e2 = new Thread(t2);
		Thread e3 = new Thread(t3);
		
		e1.start();
		e2.start();
		e3.start();
		
		
	}
	
}

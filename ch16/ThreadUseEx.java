package ch16;

public class ThreadUseEx {
	public static void main(String[] args) {
		MyThreadEx t1 = new MyThreadEx("Thread one");
		MyThreadEx t2 = new MyThreadEx("Thread two");
		MyThreadEx t3 = new MyThreadEx("Thread three");
		
		System.out.println(Thread.currentThread().getName()+" Thread");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}

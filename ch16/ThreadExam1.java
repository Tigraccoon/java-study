package ch16;

public class ThreadExam1 {
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("*");
		MyThread1 t2 = new MyThread1("-");
		//쓰레드 생성, 쓰레드가 가지고 있는 start()메소드 호출
		//main 쓰레드를 포함해서 모두 3개의 쓰레드가 실행되는 것
		
		t1.start();
		t2.start();
		
		System.out.println("main end~");
		
	}
	
}

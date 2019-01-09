package ch16;

public class ThreadExam2 {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("*");
		MyThread2 t2 = new MyThread2("-");
		
		//MyThread2는 직접 Thread를 상속받지 않았기 때문에 Thread가 아니다.
		//따라서 Thread를 별도로 생성하고 해당 생성자에 MyThread2를 입력하여 Thread를 생성해야함
		
		Thread e1 = new Thread(t1);
		Thread e2 = new Thread(t2);
		
		//Start()는 Thread가 가진 run()을 호출
		e1.start();
		e2.start();
		
		System.out.println("main~");
		
	}
	
}

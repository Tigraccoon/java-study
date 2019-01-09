package ch16;

public class JoinExam {
	public static void main(String[] args) {
		MyThread5 t = new MyThread5();
		
		t.start();
		System.out.println("Thread가 종료될 때까지 기다린다.");
		try {
			t.join();	//해당 쓰레드가 종료될 때까지 기다림
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread가 종료됐다.");
		
	}
	
}

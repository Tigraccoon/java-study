package ch16;

public class RunnableExam implements Runnable{

	@Override
	public void run() {
		for (int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName()+" ==> "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	//run
	
	public static void main(String[] args) {
		RunnableExam e1 = new RunnableExam();
		
		//Runnable을 쓸 땐 Thread를 별도로 생성해서 써야함
		//java는 단일 상속만을 하기 때문에 다른 객체와 함께 상속받아 쓰레드를 구현하려면 implements Runnable로 처리해야함
		//new Thread(쓰레드 구현 객체, "쓰레드 이름")
		
		Thread t1 = new Thread(e1,"Thread1");
		Thread t2 = new Thread(e1,"Thread2");
		
		t1.start();
		t2.start();
		
	}
	
}

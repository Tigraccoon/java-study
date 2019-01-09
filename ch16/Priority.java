package ch16;

public class Priority extends Thread {
	
	public static void main(String[] args) {
		Priority e1 = new Priority();
		Priority e2 = new Priority();

		//쓰레드 이름 설정
		e1.setName("Thread1");
		e2.setName("Thread2");
		System.out.println("e1의 기본 우선순위 : "+e1.getPriority());
		System.out.println("e2의 기본 우선순위 : "+e2.getPriority());
		
		//쓰레드의 우선순위 설정(1~10)
		//우선순위를 설정한다고 해서 반드시 적용되는 것은 아님
		//Thread.MAX_PRIORITY 최대 우선순위(10)
		//Thread.NORM_PRIORITY 기본 우선순위(5)
		//Thread.MIN_PRIORITY 최소 우선순위(1)
		
		e1.setPriority(Thread.MIN_PRIORITY);
		e2.setPriority(Thread.MAX_PRIORITY);
		
		e1.start();
		e2.start();
		
	}
	
	@Override
	public void run() {
		
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName()+" ==> "+i);
		}
	
	}

}

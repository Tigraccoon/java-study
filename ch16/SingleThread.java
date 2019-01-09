package ch16;

//Single Thread : 작업단위가 1개(main thread만 존재)
//순차적으로 처리

public class SingleThread {
	void print() {
		//현재 실행중인 쓰레드는 Thread.currentThread().getName()으로 이름을 가져올 수 있음
		System.out.println(Thread.currentThread().getName());
		
		for(int i=1;i<=5;i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		SingleThread st = new SingleThread();
		st.print();
		st.print();
		
	}
	
}

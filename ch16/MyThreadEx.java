package ch16;

public class MyThreadEx extends Thread{
	
	public MyThreadEx() {}
	public MyThreadEx(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}

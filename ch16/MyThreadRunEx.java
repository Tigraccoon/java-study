package ch16;

public class MyThreadRunEx implements Runnable{
	
	Thread t = new Thread();
	
	public MyThreadRunEx() {}
	public MyThreadRunEx(String name) {
		t.setName(name);
	}
	
	@Override
	public void run() {
		
		for(int i=1;i<=5;i++) {
			System.out.println(t.getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

package ch16;

public class ThreadB extends Thread {
	int total;
	@Override
	public void run() {

		synchronized (this) {
			
			for(int i=0;i<5;i++) {
				System.out.println((i+1)+" 을 더합니다.");
				total+=(i+1);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//for
			
			notify();
		}//synchronized
	}//run

}

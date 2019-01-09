package ch16;

public class Test<T> implements Runnable {
	
	T str;
	public Test(){}
	public Test(T str){
		this.str=str;
	}
	
	
	@Override
	public void run() {
		
		for(int i=1;i<=5;i++) {
			
			try {
				System.out.println(str);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

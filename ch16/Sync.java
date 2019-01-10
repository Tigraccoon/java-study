package ch16;

public class Sync {
	public static void main(String[] args) {
		Atm atm = new Atm();
		
		Thread t1 = new Thread(atm,"mom");
		Thread t2 = new Thread(atm,"son");
		
		t1.start();
		t2.start();
	}
	
}

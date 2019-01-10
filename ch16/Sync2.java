package ch16;


public class Sync2 {
	public static void main(String[] args) {
		Atm2 atm = new Atm2();
		
		Thread t1 = new Thread(atm,"p1");
		Thread t2 = new Thread(atm,"p2");
		Thread t3 = new Thread(atm,"p3");
		Thread t4 = new Thread(atm,"p4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	
}

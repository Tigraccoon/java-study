package ch16;

public class TestUse {
	public static void main(String[] args) {
		Test<String> t1 = new Test<>("Thread1");
		Test<String> t2 = new Test<>("Thread2");
		Test<String> t3 = new Test<>("Thread3");
		
		Thread e1 = new Thread(t1);
		Thread e2 = new Thread(t2);
		Thread e3 = new Thread(t3);
		
		e1.start();
		e2.start();
		e3.start();
	}

}

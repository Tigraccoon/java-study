package ch10;

public class Test {
	static int a;
	int b;
	
	void print() {
		System.out.println(a);
		System.out.println(b);
		
	}
	
	public static void main(String[] args) {
		System.out.println(a);
		
		Test t = new Test();
		System.out.println(t.b);
		
		t=null;	// t참조변수의 값을 null로 초기화하여 주소값을 제거
		
		System.out.println(Math.PI);
//		final int NUM = 5000;
		
	}
	
}

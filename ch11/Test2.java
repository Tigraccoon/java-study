package ch11;

public class Test2 extends Test{
	@Override
	public void print() {
		System.out.println("추상클래스 구현");
	}
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.print();
	}
}

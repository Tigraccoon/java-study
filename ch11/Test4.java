package ch11;

public class Test4 extends Test implements A {
	@Override
	public void print() {
		System.out.println("인터페이스와 추상메소드 구현");
	}
	public static void main(String[] args) {
		Test4 t=new Test4();
		t.print();
	}
}

package ch10;
//final로 클래스를 상수처리하면 상속이 안 됌.
class A2{
	//final로 메소드를 상수처리하면 역시 상속이 안 됌.
	void print() {
		System.out.println("a");
	}
}

class B extends A2{
	void print() {	//오버라이딩, method 재정의
		System.out.println("b");
	}
}

public class Test2 {
	public static void main(String[] args) {
		B b = new B();
		b.print();	//오버라이딩 된 메소드를 호출할경우 상속받은 클래스 우선
	}
	
}

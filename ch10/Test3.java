package ch10;

public class Test3 {
	public static void main(String[] args) {
//		int a = 10;
//		double b = 20.0;
//		char c = 'a';
//		String d = "Hello";
		
		//Object 클래스는 최상위 클래스로 어떤 데이터든 수용 가능하지만 무거워지며 속도가 느려짐.
		//다형성이라 함.		LabVIEW의 배리언트 타입과는 조금 다른듯...
		
		Object a = 10;
		Object b = 20.0;
		Object c = 'a';
		Object d = "Hello";
		
		Object a1 = 10;
		a1 = 20.5;
		a1 = 'a';
		a1 = "hello";
		
		System.out.println(a1);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		//다형성의 코드의 예. 좌변과 우변의 자료형이 다른 것을 실무에서 다형성이라고 함.
		//좌변(부모객체), 우변(자식객체)
		Object a0 = new Integer(10);	
		System.out.println(a0);	
		//원래는 번지값이 출력돼야 하지만 내부적으로 xxxValue()를 실행하여 해당 값이 출력되는 것.
		
		
//		a0 = new Double(20.5); 원래는 new 생성자를 통해 써야하지만 생략 가능.
		a0 = 20.5;
		System.out.println(a0);
		
//		a0 = new Character('A'); 원래는 new 생성자를 통해 써야하지만 생략 가능.
		a0 = 'A';
		System.out.println(a0);
		
	}
	
}

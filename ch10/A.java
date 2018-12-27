package ch10;

//static - 메모리에 자동 로딩
public class A {
	String name = "kim";	// non static member
	static int n = 20;		// static member
	public void print() {	// non static member
		System.out.println(name);
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		int a = 10;
		double b = 20.5;
		
		System.out.println(a);
		System.out.println(b);
//		System.out.println(name);	// non static member이고 객체를 생성하기 전이라 호출이 안 됌.
		System.out.println(n);
		System.out.println();
		
		A aa = new A();		// 객체를 생성한 후에나 non static member를 호출 가능
		System.out.println(aa.name);
		aa.print();
		
	}
	
}

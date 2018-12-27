package ch10;

class T {
	private int num = 10;
	public final void print() { //메소드에 final이 붙으면 오버라이딩만 안 됌.
		System.out.println(num);
	}
}

public class FinalMethod extends T {
	int num = 100; // non-static member
	
	public static void main(String[] args) {
		FinalMethod f = new FinalMethod();
		System.out.println(f.num);
//		FinalMethod f = new FinalMethod();
		f.print();	//메소드에 final이 붙어도 호출은 가능.
		
	}
	
}

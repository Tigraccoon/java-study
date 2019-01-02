package ch12;

public class StaticOuter {
	static int data1=30;	//static
	int data2=50;			//non static
	static class StaticInner{
		void msg() {
			System.out.println("data1 is " + data1);
//			System.out.println("data1 is " + data2);
//			non static 멤버 변수는 static inner class에서 사용 불가능.
			
			StaticOuter t = new StaticOuter();
			System.out.println("data2 is " + t.data2);

		}
	}	// end StaticInner
	
	public static void main(String[] args) {
		StaticOuter.StaticInner so = new StaticOuter.StaticInner();
		so.msg();
		
	}
	
}

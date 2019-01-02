package ch12;

//Local inner class : 메소드 안에 생성되는 클래스를 지역 내부 클래스라 한다.
//Local inner class의 규칙
//1. Local inner class는 외부 메소드로부터 불러올 수 없다.
//2. jdk1.7 까지는 마지막이 아닌 지역 변수에 접속할 수 없다.
//3. jdk1.7 부터는 마지막이 아닌 지역 변수에 접속할 수 있다.

public class LocalOuter {
	private int data = 30;
	void display() {
		int value1 = 50;	//첫번째 지역변수 *jdk1.7 부터 마지막이 아닌 지역 변수에 접속 가능
		int value2 = 100;	//마지막 지역변수	 
		class LoaclInner{
			void msg() {
				System.out.println(data);
				System.out.println(value1);
				System.out.println(value2);
			}
		}//inner class
	
		LoaclInner li = new LoaclInner();
		li.msg();
		
	}//global method
	
	public static void main(String[] args) {
		LocalOuter lo = new LocalOuter();
		lo.display();
		
	}
	
}

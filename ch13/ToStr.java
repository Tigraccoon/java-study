package ch13;

public class ToStr {
	public static void main(String[] args) {
		Object obj = new Object();
		obj = new Integer(20);	//다형성
		
		obj=40;		
		//참조 변수에는 원래 주소값이 들어가지만 jdk1.5부터는 value가 들어갈 수 있도록 내부처리(intValue()등의 호출)하도록 했다.
		//AutoBoxing
		System.out.println(obj);//Auto Unboxing
		
//		obj = new Double(20.5);
		obj=20.5;
		System.out.println(obj);
//		obj=null;
//		System.out.println(obj.hashCode());
		
	}
	
}

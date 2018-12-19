package ch06;
//메소드 오버로딩
//주의점 : 
//1) 메소드의 이름이 같아야 한다.
//2) 파라미터(매개변스)의 갯수가 달라야한다.
//3) 데이터 타입이 달라야한다.
public class Overload{	//클래스 이름 = extends object가 상속돼있음.
						//같은 기능을 하는게 많으면 메소드를 하나의 이름으로 만들어 처리(오버로딩)하는게 효율적(유지보수가 편리)
	public static void main(String[] args) {
//		Object obj = new Integer(10);
//		obj = 100.5;
//		obj=new double(100.5);
//		obj=new String("java");
		
		print(10);
		print(100.5);
		print("Java");

	}	//main

	private static void print(String string) {
		System.out.println(string);
		
	}	//print String

	private static void print(double d) {
		System.out.println(d);
		
	}	//print double

	private static void print(int i) {
		System.out.println(i);
		
	}	//print int

}

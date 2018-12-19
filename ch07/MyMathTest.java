package ch07;

public class MyMathTest {
	public static void main(String[] args) {
		int i=2;
		double d=3.0;
		MyMath mm = new MyMath();
		
		System.out.println("--------------------------------------");
		System.out.println(i + "의 정수의 제곱은 : " + mm.square(i));
		System.out.println(d + "의 실수의 제곱은 : " + mm.square(d));
		System.out.println("--------------------------------------");
		
	}
	
}

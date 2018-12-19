package ch02;

public class CircleArea {

	public static void main(String[] args) {
			//원의 반지름 a, 원의 면적 b
		double a = 10.0, b;
		final double PI = 3.141592;
		
		b = a * a * PI;
		
		System.out.println("원의 면적 : " + b);
	}
	
}

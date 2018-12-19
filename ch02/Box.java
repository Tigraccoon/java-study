package ch02;

public class Box {

	public static void main(String[] args) {
		//x = 가로, y = 세로, a = 넓이, b = 둘레
		
		double x = 10.0, y = 5.0, a, b;		
		
		a = x * y;
		b = 2.0 * (x + y);
		
		
		System.out.println("사각형의 넓이 : " + a);
		System.out.println("사각형의 둘레 : " + b);
		
	}
	
}

package ch02;

import java.util.Scanner;

public class RectangleTest {

	public static Scanner in;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double x, y, a;
		
		System.out.println("직사각형의 가로 길이를 입력하세요 : ");
		
		x = input.nextDouble();
		
		System.out.println("직사각형의 세로 길이를 입력하세요 : ");
		
		y = input.nextDouble();
		
		a = x * y;
		
		input.close();
		
		System.out.println("직사각형의 넓이는 " + a + " 입니다.");
		
		
	}
	
}

package ch02;

import java.util.Scanner;

public class DoubleTest {
	
		private static Scanner in;

		public static void main(String[] args) {
			
			in = new Scanner(System.in);
			System.out.println("첫번째 실수값을 입력하세요!");
			double x = in.nextDouble();
			System.out.println("두번째 실수값을 입력하세요!");
			double y = in.nextDouble();
			
			System.out.printf("%.3f + %.3f 는 %.3f 입니다. ", x, y, x+y);
	}
	
}

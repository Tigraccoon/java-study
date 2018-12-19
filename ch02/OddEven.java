package ch02;

import java.util.Scanner;

public class OddEven {

	public static Scanner in;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		
		int num = in.nextInt();
		
		in.close();
		
		System.out.println( num % 2 == 0 ? "짝수" : "홀수");
		
	}
	
}

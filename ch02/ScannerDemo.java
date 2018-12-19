package ch02;

import java.util.Scanner;

public class ScannerDemo {		//F2 로 파일명 변경 가능

	private static Scanner in;

	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		System.out.println("첫번째 정수?");
		int x = in.nextInt();
		System.out.println("두번째 정수?");
		int y = in.nextInt();
		
		System.out.printf("%d * %d 는 %d 입니다.", x, y, x*y);
		
		
		
	}
	
}

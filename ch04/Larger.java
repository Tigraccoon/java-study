package ch04;

import java.util.Scanner;

public class Larger {

	public static Scanner in;
	
	public static void main(String[] args) {
		int x, y, max;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("첫번째 정수 : ");
		x = scan.nextInt();
		
		System.out.println("두번째 정수 : ");
		y = scan.nextInt();
		
		scan.close();
		
		if ( x > y ) {
			max = x;
		}
		else {
			max = y;
		}
		
		System.out.println("큰 수는 "+ max);
		
		
	}
	
}

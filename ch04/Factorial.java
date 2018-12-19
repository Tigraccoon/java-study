package ch04;

import java.util.Scanner;

public class Factorial {
		public static Scanner in;
	public static void main(String[] args) {
		long fact = 1 ;
		int n ;
		
		Scanner scan = new Scanner(System.in);
		System.out.println(  "정수를 입력하시오 : ");
		n = scan.nextInt();
		scan.close();
		
		for(int i = 1 ; i <= n ; i++) {
			fact *= i ;
		}	// end for
		
		System.out.printf("%d ! 은 %d 입니다.", n, fact);
	}	// end main
}	// end class

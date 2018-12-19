package ch04;

import java.util.Scanner;

public class Divisor {

	public static Scanner in;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("양의 정수를 입력하시오 ; ");
		int n = scan.nextInt();
		
		scan.close();
		
		System.out.println(n + " 의 약수는 다음과 같습니다.");
		
		for ( int i = 1 ; i <= n ; i ++ ) {
			
			if ( n % i == 0) {
				
				System.out.print(" " + i);
				
			}	// end if
			
		}	// end for
		
	}	// end main
	
}	// end class

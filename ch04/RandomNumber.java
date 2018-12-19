package ch04;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
	public static Scanner in;
	public static void main(String[] args) {
		Random generator = new Random();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("난수의 개수 : ");
		int count = scan.nextInt();
		scan.close();
		int sum = 0;
		
		for (int i = 0 ; i < count ; i++) {
			int number = generator.nextInt(100);
			System.out.println("생성된 난수 " + (i+1) + " : " + number);
			sum += number ;
		}	// end for
		
		System.out.println("난수 " + count + " 개의 합은 : " + sum);
	}	// end main
}	// end class

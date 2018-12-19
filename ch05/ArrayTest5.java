package ch05;

import java.util.Scanner;

public class ArrayTest5 {	//사용자가 배열 크기를 지정
		public static Scanner in;
	public static void main(String[] args) {
		int total=0, size;
		Scanner scan = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		size = scan.nextInt();
		
		int[] scores = new int[size];
		for (int i =0;i<scores.length;i++) {
			System.out.print("성적을 입력하세요 : ");
			scores[i] = scan.nextInt();
			
		}	//end for
		
		for (int i =0; i<scores.length;i++) {
			total += scores[i];
		}
		System.out.println("평균 성적은 " + total/scores.length + " 입니다.");
		scan.close();
		
	}
	
}

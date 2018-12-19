package ch05;

import java.util.Scanner;

public class ArrayHakjum {
		public static Scanner in;
	public static void main(String[] args) {
		int size, sum=0;
		Scanner scan = new Scanner(System.in);
		System.out.print("과목 수를 입력하세요 : ");
		size = scan.nextInt();
		
		int[] hak = new int[size];
		
		for (int i=0;i<hak.length;i++) {
			System.out.print((i+1)+ " 번째 과목 성적을 입력하세요 : ");
			hak[i] = scan.nextInt();
			sum += hak[i];
		}
		System.out.println("\n성적 합계는 ' " + sum +" ' 입니다.");
		System.out.printf("평균 성적은 ' " + String.format("%.1f", sum/(double)hak.length) + " ' 입니다.");
		scan.close();
	}
	
}

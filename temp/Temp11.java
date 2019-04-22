package temp;

import java.util.Arrays;

public class Temp11 {
	public static void main(String[] args) {
		int[] score = {99, 69, 79, 89, 77};
		int sum=0;
		int avg=0;
		
		Arrays.sort(score);
		System.out.print("정렬된 배열 : ");
		
		for(int i : score) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println();
		avg = sum/(score.length);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("------점수와 등급------");
		for(int i : score) {
			int temp = i/10;
			String grade = "";
			switch (temp) {
			case 10 : grade = "수+"; break;
			case 9 : grade = "수"; break;
			case 8 : grade = "우"; break;
			case 7 : grade = "미"; break;
			case 6 : grade = "양"; break;
			default : grade = "가";
			}
			System.out.println(i + " : " + grade);
		}
	}
}

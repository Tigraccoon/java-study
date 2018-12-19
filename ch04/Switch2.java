package ch04;

import java.util.Scanner;

public class Switch2 {

	public static Scanner in;
	public static void main(String[] args) {
		
		double kor, eng, mat, tot, avg;
		String grade = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어 : ");
		kor = scan.nextDouble();
		System.out.print("영어 : ");
		eng = scan.nextDouble();
		System.out.print("수학 : ");
		mat = scan.nextDouble();
		scan.close();
		
		tot = kor + mat + eng;
		avg = tot / 3.0;
		
		switch ((int)avg / 10){
			case 10 : 
			case 9 : grade = "수"; break;
			case 8 : grade = "우"; break;
			case 7 : grade = "미"; break;
			case 6 : grade = "양"; break;
			default : grade = "가"; break;
		}
		
		System.out.println("국어\t\t영어\t\t수학\t\t총점\t\t평균\t\t등급");
		System.out.printf("%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%s", kor, eng, mat, tot, avg, grade);
		
	}
	
}

package ch04;

import java.util.Scanner;

public class Ifelse2 {

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
		
		if ( avg >= 90.0 ) {
			grade = "수";
		}
		else if (avg >= 80.0 ) {
			grade = "우";
		}
		else if (avg >= 70.0 ) {
			grade = "미";
		}
		else if ( avg >= 60.0){
			grade = "양";
		}
		else {
			grade ="가";
		}
		
		System.out.println("국어\t\t영어\t\t수학\t\t총점\t\t평균\t\t등급");
		System.out.printf("%.1f\t%.1f\t%.1f\t\t%.1f\t\t%.1f\t\t%s", kor, eng, mat, tot, avg, grade);
		
	}
	
}

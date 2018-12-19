package ch03;

import java.util.Scanner;

// 성적 계산 프로그램
//국, 영, 수 점수를 입력받아 총점, 평균 출력

public class Point {
	public static Scanner in;
	public static void main(String[] args) {
		// 변수 선언
		String name;
		int kor, eng, met, tot;
		double avg;
		
		// 입력 객체 생성
		Scanner scan = new Scanner(System.in);
		System.out.print( "이름 : ");
		name = scan.next();
		System.out.print( "국어 점수 : ");
		kor = scan.nextInt();
		System.out.print( "영어 점수 : ");
		eng = scan.nextInt();
		System.out.print( "수학 점수 : ");
		met = scan.nextInt();
		scan.close();	//스캐너 객체가 사용중인 메모리 정리
		//계산
		tot = kor + eng + met;
		avg = tot / 3.0;
		//결과 출력
		System.out.println( "이름\t\t국어\t\t영어\t\t수학\t\t총점\t\t평균");
		System.out.println(name + "\t" + kor + "\t\t" + eng + "\t\t" + met + "\t\t" + tot + "\t\t" + avg);
		
		
	}
	
}

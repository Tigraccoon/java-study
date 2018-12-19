package ch06;

import java.util.Scanner;

public class Holiday {
	static int y;	//전역변수=맴버변수=필드변수=글로벌변수=>클래스 전체에서 사용할 수 있는 변수
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("근속 연수를 입력하세요 : ");
		y=scan.nextInt();
		scan.close();
	}
	
	static int holiday(int year) {
		int day=0;
		if(year<=5) {			//근속년수 1~5년
			day=10;				//10일 휴가
		} else if(year<=10) {	//근속년수 6~10년
			day=15;
		} else {
			day=20;
		}
		return day;
	}
	
	public static void main(String[] args) {
		input();
		System.out.println("휴가일수 : " + holiday(y));
		
	}
	
}

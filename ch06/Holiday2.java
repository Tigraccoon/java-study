package ch06;

import java.util.Scanner;

public class Holiday2 {
	static int y;
	static void input(){
		Scanner scan = new Scanner(System.in);
		System.out.print("근속 연수를 입력하세요 : ");
		y=scan.nextInt();
		scan.close();
	}
	
	static void cal() {
		int year=0;
		if (y <=5) {
			year = 5;
		}else if(y<=10) {
			year = 10;
		}else if(y<=20) {
			year = 20;
		} else {
			year = 30;
		}
		System.out.println(year);
	}
	
	static void out() {
		System.out.print("휴가 일수 : ");
		cal();
	}
	
	public static void main(String[] args) {
		input();
		out();
	}
}

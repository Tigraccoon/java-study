package ch04;

import java.util.Scanner;

public class StringSwitch {

	public static Scanner in;
	
	public static void main(String[] args) {
		
		int monthNumber;
		String month;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("월의 이름을 입력하세요 : ");
		month = scan.nextLine();
		scan.close();
		
		switch (month) {
		case "Jan" : monthNumber = 1; break;
		case "Feb" : monthNumber = 2; break;
		case "Mar" : monthNumber = 3; break;
		default : monthNumber = 0; break;
		}
		
		System.out.println(monthNumber);
		
	}
	
}

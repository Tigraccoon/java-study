package ch13;

//import java.util.GregorianCalendar;
import java.util.Scanner;

public class LeapYear {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.print("연도를 입력하세요 : ");
		int year=scan.nextInt();
//		GregorianCalendar cal = new GregorianCalendar();
//		if(cal.isLeapYear(year)) {	//윤년 계산 메소드 : isLeapYear()
//			//is로 시작하는 메소드는 대부분 boolean타입이다.
//			System.out.println("윤년입니다.");
		if(year%4==0 && year%100!=0 || (year%400==0)) {
			System.out.println("윤년입니다.");
		}else {
			System.out.println("평년입니다.");
		}
		
	}
	
}

package ch04;

import java.util.Scanner;

public class Bonus {

	public static Scanner in;
	
	public static void main(String[] args) {
		
		final int TARGETSALES = 1000;
		int mySales, bonus;
		String result = "";
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("실적을 입력하세요(단위 : 만원) : ");
		mySales = input.nextInt();
		
		input.close();
		
		if (mySales >= TARGETSALES) {
			result = "실적 달성";
			bonus = (mySales - TARGETSALES) / 10;
		}
		else {
			result = "실적 달성 못함";
			bonus = 0;
		}
		
		System.out.println(result + "\n" + "보너스 : "+ bonus);
		
	}
	
}

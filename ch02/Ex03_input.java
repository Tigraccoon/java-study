package ch02;

import java.util.Scanner;

public class Ex03_input {
	
	public static Scanner in;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		
		String name = scan.next();
		
		scan.close();
		
		System.out.println("당신의 이름은 " + name + " 입니다.");
		
	}
	
}

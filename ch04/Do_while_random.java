package ch04;

import java.util.Scanner;

public class Do_while_random {
		public static Scanner in;
	public static void main(String[] args) {
		int input = 0, answer = 0;
		answer = (int)(Math.random()*10)+1; // 1~10 사이의 수를 저장
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("1과 10사이의 정수를 입력하세요 : ");
			String tmp = sc.next();
			input = Integer.parseInt(tmp);
			if (input > answer) {
				System.out.println("더 작은 수로 다시 시도해보세요.");
			} else if (input < answer) {
				System.out.println("더 큰 수로 다시 시도해보세요.");
			}
		} while (input!=answer);
		System.out.println(answer + " 정답입니다.");
		
		sc.close();
	}
}

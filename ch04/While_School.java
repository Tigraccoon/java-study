package ch04;

import java.util.Scanner;

public class While_School {
		public static Scanner in;
	public static void main(String[] args) {
		int count = 0, sum = 0, n;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 영어 수학 점수를 각각 입력하고 마지막에 -1을 입력하세요.");
		n = sc.nextInt();
		
		while (n != -1) {
			sum += n;
			count++;
			n = sc.nextInt();
		}
		if (count == 0) {
			System.out.println("입력된 수가 없습니다.");
		} else {
			System.out.printf("총점은 %d 이고 평균은 %.1f 입니다.", sum, (double)sum / count);
		}
		sc.close();
		
	}
}

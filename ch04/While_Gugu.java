package ch04;

import java.util.Scanner;

public class While_Gugu {
	public static Scanner in;
	public static void main(String[] args) {
		int dan, i = 1 ;
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 중에서 출력하고 싶은 단을 입력하시오 : ");
		dan = sc.nextInt();
		sc.close();

		if ( dan >= 9) {
			while (i <= dan) {
				System.out.println(dan + " * " + i + " = " + dan * i);
				i++;
			}
		} else {
			while (i <= 9) {
				System.out.println(dan + " * " + i + " = " + dan * i);
				i++;
			}
		}


	}

}

package ch05;

import java.util.Scanner;

public class TheaterReserve {
	public static Scanner in;
	public static void main(String[] args) {
		final int SIZE=10;
		int[] seats=new int[SIZE];
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("---------------------");
			for(int i=0;i<SIZE;i++) {
				System.out.print(i+1 + " ");
			}	//end for1

			System.out.println("\n---------------------");

			for (int i=0;i<SIZE;i++) {
				System.out.print(seats[i] + " ");
			}	//end for2

			System.out.println("\n---------------------");
			System.out.print("원하시는 좌석번호를 입력하세요. (종료는 -1) >> ");

			int s = scan.nextInt();
			if (s==-1) {
				break;
			}
			if (seats[s-1] ==0) {
				seats[s-1] = 1;
				System.out.println("\n예약됐습니다.");
			} else {
				System.out.println("\n이미 예약된 자리입니다.");

			}
		}	//end while
		scan.close();
	}	//end main
}

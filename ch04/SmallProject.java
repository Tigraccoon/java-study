package ch04;

import java.util.Scanner;

public class SmallProject {
		public static Scanner in;
	public static void main(String[] args) {
		int menu = 0, num =0;
		Scanner scan = new Scanner(System.in);
		outer:
			while(true) {
				System.out.println("(1) square(제곱)");
				System.out.println("(2) square(제곱근)");
				System.out.println("(3) log(로그)");
				System.out.print("원하는 메뉴(1~3)를 선택하세요. (종료 : 0) >> ");
				String tem = scan.next();
				menu = Integer.parseInt(tem);
				if (menu == 0) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else if (!(1 <= menu && menu <= 3)) {
					System.out.println("메뉴를 잘못 선택하셨습니다. (종료 : 0)");
					continue;
				}
				for(;;) {	//for문 무한루프
					System.out.println("계산할 값을 입력하세요.(계산 종료 : 0, 전체 종료 : 99)");
					tem = scan.next();
					num = Integer.parseInt(tem);
					if (num ==0) {
						break;
					}
					if (num == 99) {
						break outer;
					}
					switch(menu) {
					case 1 :
						System.out.println("result = " + num * num);
						break;
					case 2 : 
						System.out.println("result = " + Math.sqrt(num));
						break;
					case 3 : 
						System.out.println("result = " + Math.log(num));
						break;
					}	//end switch
				}	//end for(;;)
				
			}	//end while (true)
		scan.close();
		System.out.println("프로그램을 모두 종료합니다.");
	}
}

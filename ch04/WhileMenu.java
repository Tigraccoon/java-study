package ch04;

import java.util.Scanner;

public class WhileMenu {
		public static Scanner in;
	public static void main(String[] args) {
		
		int menu=0;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("(1) 아메리카노");
			System.out.println("(2) 카페라떼");
			System.out.println("(3) 에스프레소");
			System.out.print("원하는 메뉴 (1~3)을 선택하세요. (종료 : 0) > ");
			
			String tmp = scan.next();
			menu = Integer.parseInt(tmp);	//입력받은 문자열 tmp를 숫자로 변환	parseint
			
			if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!(1<=menu && menu <=3)){	//menu가 1 이상 and menu가 3 이하
				System.out.println("메뉴를 잘못 선택했습니다. (종료는 0)");
				continue;
			}
			System.out.println("선택하신 메뉴는 " + menu + " 번 입니다.");
			
		}
		scan.close();
	}
}

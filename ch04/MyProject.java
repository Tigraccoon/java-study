package ch04;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class MyProject {
	public static Scanner in;
	public static void main(String[] args) {

		int menu = 0, monny, data;
		Date date = new Date();
		Scanner scan = new Scanner(System.in);
		Random m = new Random();
		Random d = new Random();
		monny = m.nextInt(100);
		data = d.nextInt(100);
		out:
			while (true) {	// while1
				System.out.println("114입니다.");
				System.out.println("(1) 실시간 요금 조회");
				System.out.println("(2) 휴대폰 분실 신고");
				System.out.println("(3) 남은 데이터 조회");
				System.out.println("(8) 다시 듣기");
				System.out.println("(0) 상담원 연결");
				System.out.println("(9) 종료");
				System.out.print("원하시는 메뉴를 선택해주세요. >>");
				String tem = scan.next();
				menu = Integer.parseInt(tem);
				if (menu == 1) {
					while(true) {
						System.out.println(date + " 까지의 요금은 " + monny + " 만원 입니다.");
						System.out.println("(9) 이전 단계");
						System.out.println("(0) 종료");
						System.out.print("원하시는 메뉴를 선택해주세요. >>");
						tem = scan.next();
						menu = Integer.parseInt(tem);
						if (menu==9) {
							break;
						}
						else if(menu==0) {
							break out;
						} else if (!(menu == 9 && menu == 0)) {
							continue;
						}
					}
				}
				else if (menu == 2) {
					System.out.println("분실 신고를 위해 상담원을 연결합니다.");
					for (int i = 1 ; i <= 3 ; i++) {
						for (int j = 1 ; j <= 3 ; j++) {
							if (i > j) {
								System.out.print(" ");
							} else {
								System.out.print("*");
							}
						}
						System.out.println();
					}
					System.out.println("현재 상담원이 모두 통화중입니다.");
					System.out.println("다음에 다시 통화 부탁드립니다.");
					break out;
				}
				else if (menu == 3) {
					while(true) {
						System.out.println(date + " 부터 월말까지 남은 데이터는 " + data + " Gb 입니다.");
						System.out.println("(9) 이전 단계");
						System.out.println("(0) 종료");
						System.out.print("원하시는 메뉴를 선택해주세요. >>");
						tem = scan.next();
						menu = Integer.parseInt(tem);
						if (menu==9) {
							break;
						}
						else if(menu==0) {
							break out;
						} else if (!(menu == 9 && menu == 0)) {
							continue;
						}
					}
				}
				else if (menu == 8) {
					continue;
				}
				else if (menu == 0) {
					System.out.println("상담원을 연결합니다.");
					for (int i = 1 ; i <= 3 ; i++) {
						for (int j = 1 ; j <= 3 ; j++) {
							if (i > j) {
								System.out.print(" ");
							} else {
								System.out.print("*");
							}
						}
						System.out.println();
					}
					System.out.println("현재 상담원이 모두 통화중입니다.");
					System.out.println("다음에 다시 통화 부탁드립니다.");
					break out;
				}
				else if (menu == 9) {
					break out;
				}
				else if(!(0 <=menu && menu <= 3 && menu == 8 && menu ==9) ) {
					continue;
				}


			}	//end while1
		scan.close();
		System.out.println("\n\nbye");

	}

}

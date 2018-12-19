package ch04;

import java.util.Scanner;

//배송료 계산
public class Cost2 {

	public static Scanner in;
	
	public static void main(String[] args) {
		//name 이름 	pirce 이름 	point 적립금	point_use 적립금 사용액		fee 배송료		pay 실제 금액
		String name = "";
		int price = 0, point = 0, point_use = 0, fee = 0, pay = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		name = scan.next();
		System.out.print("구매금액 : ");
		price = scan.nextInt();
		System.out.print("포인트 : ");
		point = scan.nextInt();
		scan.close();
		
		if ( price < 50000 ) {
			fee = 2500;
			System.out.println("\n구매금액이 5만원 미만이므로 배송료가 추가됩니다.");
		}
		if ( point >= 30000 ) {
			point_use = point;
			pay = price + fee - point;
		} else {
			pay = price + fee;
			System.out.println("\n포인트가 3만원 미만이므로 포인트 사용이 불가능합니다.");
		}
		
		
		System.out.println( "\n이름\t\t구매금액\t배송료\t포인트사용\t결제금액");
		System.out.println( name + "\t" + price + "\t"+ fee + "\t\t" + point_use + "\t\t" + pay);
		
		
	}
	
}

package project;

import java.util.Scanner;

/**
 * @author 이재호
 * @since 20190114
 */

//[포트폴리오 문제] class ProjectJavaBasic
//구입할 상품의 갯수를 입력하여 각 상품의 가격을 입력 후
//총구입가격과 마일리지를 계산하여 출력하는 프로그램을 작성한다.
//(마일리지는 총구입가격 x 0.01로 계산한다.)
//
//(출력예시)
//구매할 상품의 갯수를 입력하시오(단, 1개 이상 5개 이하) : 
//3
//상품가격을 입력하시오 : 
//28000
//상품가격을 입력하시오 : 
//12000
//상품가격을 입력하시오 : 
//50000
//===============================
//총구입가격은 : 90000(원)입니다.
//마일리지는 : 900.0(점)입니다.
//===============================

public class ProjectJavaBasic {
	//변수 생성
	private Scanner sc = new Scanner(System.in);	//스캐너
	private int num;	//상품 갯수
	private int price = 0;	//상품 가격
	private double mile;	//마일리지

	public void inputNum() {
		System.out.println("구매할 상품의 갯수를 입력하시오(단, 5개 미만) : ");
		//num에 정수 저장 및 오류검사 후 오류 발생시 메소드 재실행
		//오류 검사
		try {	
			num = Integer.parseInt(sc.nextLine());
		}catch (Exception e) {
			System.out.println("숫자만 입력하시오.\n");
			inputNum();
		}//try~catch
		if (num <= 0 || num >= 5) {
			System.out.println("상품 갯수 오류입니다. 1이상 5 미만의 숫자를 입력하시오.\n");
			inputNum();
		} else {
			
		}

	}//inputNum()

	public void priceCalculate() {
		for (int i=1;i<=num;i++) {
			System.out.println(i+". 상품 가격을 입력하시오 : ");
			//오류 검사
			try {	
				price+=Integer.parseInt(sc.nextLine());
			}catch (Exception e) {
				//상품 가격 입력 재 실행
				--i;
				System.out.println("숫자만 입력하시오.\n");
				continue;
			}//try~catch
		}//for

		//스캐너 종료
		sc.close();
	}//priceCalculate()

	public void mileageCalculate() {
		//마일리지 계산
		mile = (double)price*0.01;
		
	}//mileageCalculate()

	public void print() {
		//결과 출력
		System.out.println("===============================");
		System.out.println("총구입가격은 : "+price+"(원)입니다.");
		System.out.printf("마일리지는 : %.1f(점)입니다.\n",mile);
		System.out.println("===============================");
		//프로그램 종료
		System.exit(0);
	}

	public static void main(String[] args) {
		ProjectJavaBasic pro = new ProjectJavaBasic();

		pro.inputNum();
		pro.priceCalculate();
		pro.mileageCalculate();
		pro.print();

	}//main

}//end

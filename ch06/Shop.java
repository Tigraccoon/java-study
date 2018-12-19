package ch06;
import java.util.Scanner;


// 쇼핑몰 프로그램
// 메인 페이지	- 페이지 표시		- 상품 리스트, 장바구니 / 종료
// 페이지 1	- 상품 리스트		- TV, 컴퓨터, 핸드폰, 커피, 과자, 음료수  / 이전, 종료
// 페이지 2 	- 장바구니 		- 상품명, 수량, 가격, 5만원 이상 시 배송료무료, 총 구입금액, 상품 삭제, 전체 삭제 / 배송 정보 입력, 이전, 종료
// 페이지 3	- 배송 정보 입력 	- 이름, 전화번호, 주소 입력 / 최종 결제, 이전, 메인으로, 종료
// 페이지 4	- 최종 확인		- 장바구니 + 고객 정보 / 이전, 메인으로, 종료


// 메소드 이름
// main 	- 메인 페이지
// pg1 		- 상품 리스트 페이지 1 구성
// pg2		- 장바구니 페이지 2 구성
// pg3		- 배송 정보 입력 페이지 3 구성
// pg4		- 최종 확인 페이지 4 구성
// cart		- 장바구니 리스트 가변형 2차원 배열 [상품명], [가격]


// 글로벌 변수 이름
// list		- 상품 리스트 배열
// price	- 상품 가격 배열
// name		- 고객 이름
// hp		- 고객 전화번호
// add		- 고객 주소
// tot		- 최종 금액
// scan		- 스캐너
// sel		- 메뉴 선택 변수
// tem		- 임시 문자열

// 글로벌 상수
// dil		- 배송비 2500원 고정



public class Shop {
	//글로벌 상수
	final int dil = 2500;													//배송비
	//글로벌 변수		** static형으로 안 만들면 static 메소드에서 안 불러와짐.
	static String[] list = {"TV", "컴퓨터", "핸드폰", "커피", "과자", "음료수"};	//상품 리스트
	static int[] price = {30000, 50000, 40000, 5000, 2000, 3000};			//상품 가격
	static String name;														//고객 이름
	static String hp;														//고객 전화번호
	static String add;														//고객 주소
	static int tot;															//최종 금액
	static int sel;
	static Scanner scan = new Scanner(System.in);
	static String tem = scan.nextLine();
	
	
	// ---------------------------
	
	public static void main(String[] args) {	//메인 페이지	- 페이지 표시		- 상품 리스트, 장바구니 / 종료
		
		pg1();
		
		
	}	// end main --------------------
	
	static void cartlist(int l, String ...n){
		String [] slist = new String[10];
		
		
		
	}
	
	
	
	static void pg1() {	// 상품 리스트	- TV, 컴퓨터, 핸드폰, 커피, 과자, 음료수  / 이전, 종료
		while(true) {
			System.out.println("--------------------------");
			System.out.println("상품 리스트");
			System.out.println("번호\t상품\t금액");
			for(int i=0; i<list.length;i++) {
				System.out.println((i+1)+")\t" + list[i] + "\t" + price[i]);
			}	// end pg1 for
			System.out.println("--------------------------");
			System.out.println("구매할 상품의 번호를 입력하세요. 9. 이전 0. 종료");
			System.out.print(">>>>>>>>>> ");
			
			while(true) {
				sel = Integer.parseInt(tem);
				if(sel==1) {
					
				}
			}	// end pg1 in while
		}	// end pg1 main while
	}	// end pg1 ---------------------
	
	static void pg2() {// 장바구니 - 상품명, 수량, 가격, 5만원 이상 시 배송료무료, 총 구입금액, 상품 삭제, 전체 삭제 / 배송 정보 입력, 이전, 종료
		
		
	}	//end pg2 ----------------------
	
	static void pg3() {// 배송 정보 입력 	- 이름, 전화번호, 주소 입력 / 최종 결제, 이전, 메인으로, 종료

		
	}	//end pg3 ----------------------
	
	static void pg4() {// 최종 확인		- 장바구니 + 고객 정보 / 이전, 메인으로, 종료
		
		
	}	//end pg4 ----------------------
	
	
}

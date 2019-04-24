package temp;

public class Q_1 {
	/* 아래의 배열들은 모 가전제품 사이트의 회원 5명의 이름과 거주지 및 구매 정보를 배열로 처리한 것입니다.
	 * 배송비(fee)는 기본 25000원이며 90만원 이상 구매시 면제,
	 * 포인트(point)는 50000점 이상 적립되어 있을 때 한꺼번에 사용 가능합니다.
	 * 또한 구매시 포인트 적립률(save)은 결제금액(pay)의 3%라 할 때,
	 * 아래 다섯 회원의 이름,주소,상품명,가격,배송비,포인트,결제금액,적립된 포인트를 각각 출력해 보시오.
	 */
	static String[][] member= {{"김철수","종로구"},{"박철수","동대문구"},
		     {"홍길동","마포구"},{"김진영","중구"},{"김은정","성동구"}}; //회원정보
	static String[] item= {"TV","노트북","공기청정기","휴대폰","냉장고"}; //구매상품
	static int[] price= {810000,1200000,750000,1050000,1500000}; //가격
	static int[] point= {12000,0,55000,40000,68000}; //보유한 포인트
	static int[] fee= new int[5]; //배송비
	static int[] point_use=new int[5]; //사용할 포인트
	static int[] pay= new int[5]; //결제금액
	static int[] save=new int[5]; //적립될 포인트
	
	static void print() {
		System.out.println("이름\t주소\t상품명\t가격\t배송비\t포인트\t결제금액\t포인트적립");
		System.out.println("---------------------------------------------------------------");
		
		
	}
	
	public static void main(String[] args) {		
		print();
		
		for(int i=0; i<5;i++) {	//값 저장
			if (point[i] >= 50000) point_use[i] = point[i];
			if (price[i] <= 900000) fee[i] = 25000;
			pay[i]=price[i]+fee[i];
			save[i]=(int)(pay[i]*0.03);
		}
		
		
		for(int i=0; i<5;i++) {	//출력
			for(int j = 0; j < 2 ; j++) {
				if(j==0) {
					System.out.print(member[i][j]+"\t");
				}else {
					System.out.print(member[i][j]+"\t");
				}
			}
			System.out.print(item[i]+"\t");
			System.out.print(price[i]+"\t");
			System.out.print(fee[i]+"\t");
			System.out.print(point[i]+"\t");
			System.out.print(pay[i]+"\t");
			System.out.println(save[i]);
		}
	}	
}


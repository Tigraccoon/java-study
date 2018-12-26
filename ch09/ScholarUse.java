package ch09;

public class ScholarUse {
	public static void main(String[] args) {
		Scholar s1 = new Scholar();
		
		s1.input("김철수", "20171130", "컴공", 1, "1종", 2500000);
		s1.print();
		
		System.out.println("--------------------------------------------------------");
		
		s1.input("홍길동", "20180101", "전자", 3);
		s1.print2();
	}
	
}

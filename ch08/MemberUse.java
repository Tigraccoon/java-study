package ch08;

public class MemberUse {
	public static void main(String[] args) {
//		Member m1 = new Member("홍길동","hong",50000);
		Member m1;			//객체참조변수 선언
		m1 = new Member();	//객체생성 및 호출
		m1.input("킴찰스", "Kim", 50000);
		
		m1.print();
		
		Member m2 = new Member("팍찰스","Park",100000);
		
		m2.print();
		
	}
	
}

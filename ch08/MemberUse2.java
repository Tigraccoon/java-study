package ch08;

public class MemberUse2 {
	public static void main(String[] args) {
		Member2 m1 = Member2.getInstance();
		m1.print();
		Member2 m2 = Member2.getInstance();
		m2.input("박철수", 4321, 70, 80, 90);
		m2.print();
		
	}
	
}

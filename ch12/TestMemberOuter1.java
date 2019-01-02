package ch12;

public class TestMemberOuter1 {
	private int data = 30;
	class Inner{
		void msg() {
			System.out.println("data is " + data);	//private 데이터도 바로 끌어올 수 있음
		}
	}
	
	public static void main(String[] args) {
		TestMemberOuter1 obj = new TestMemberOuter1();
		TestMemberOuter1.Inner in = obj.new Inner();
		in.msg();
		
		
	}
	
}

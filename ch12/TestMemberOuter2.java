package ch12;

public class TestMemberOuter2 {
	private String name = "홍길동";
	private int age = 30;
	
	class Inner {
		public void out() {
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
		}
	}
	
	public static void main(String[] args) {
		TestMemberOuter2 obj = new TestMemberOuter2();
		TestMemberOuter2.Inner in = obj.new Inner();
		
		in.out();
		
	}
	
}

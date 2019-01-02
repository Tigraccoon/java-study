package ch12;

public class StaticInner2 {
	private static String name = "홍길동";
	private static int age = 30;
	
	static class Inner{
		public void out(){
			System.out.println("이름 : "+name);
			System.out.println("나이 : "+age);
		}
	}
	
	public static void main(String[] args) {
		StaticInner2.Inner in = new StaticInner2.Inner();
		
		in.out();
		
	}
	
}

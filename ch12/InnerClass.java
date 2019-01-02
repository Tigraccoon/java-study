package ch12;

public class InnerClass {
	private static int x = 10;
	
	class Inner{
		int getX() {
			return x;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(x);
		InnerClass e = new InnerClass();
		InnerClass.Inner in = e.new Inner();
		System.out.println(in.getX());
		
	}
	
}

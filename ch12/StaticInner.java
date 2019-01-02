package ch12;

public class StaticInner {
	static int x = 10;
	//static inner class
	static class Inner{
		int getX() {
			return x;
		}
	}
	
	public static void main(String[] args) {
		StaticInner.Inner in = new StaticInner.Inner();
		System.out.println(in.getX());
	}
	
}

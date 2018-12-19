package ch02;

public class VarScope2 {
		static int g;
	
	public static void main(String[] args) {
		int l = 30;
		
		System.out.println("g = " + g);
		System.out.println("l = " + l);
	}
}

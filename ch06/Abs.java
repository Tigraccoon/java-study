package ch06;

public class Abs {
	public static void main(String[] args) {
		int a=-15;
		System.out.println(a);
		System.out.println(abs(a));
		System.out.println(Math.abs(a));
		
	}	//main
	
	static int abs(int num) {
		return num > 0 ? num : -num;
	}	//abs
	
}

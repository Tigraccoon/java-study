package ch06;

public class Recursive {
	static long fact1 (int n) {
		return n==1 ? 1 : n * fact1(n-1);
	}

	public static void main(String[] args) {
		System.out.println(fact1(5));		

	}

}

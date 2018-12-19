package ch06;

public class TestOverload {
	static void print(double a) {
		System.out.println(a);
	}	//print double
	
	static void print(String a) {
		System.out.println(a);
	}	//print String
	
	static void print(String a, String b) {
		System.out.println(a);
		System.out.println(b);
	}	//print String, String
	
	static void print(int a) {
		System.out.println(a);
	}	//pring int
	
	public static void main(String[] args) {
		print(10.5);
		print("hello");
		print(100);
		
		
	}	//main
	
}

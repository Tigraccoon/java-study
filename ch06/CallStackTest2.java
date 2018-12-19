package ch06;

public class CallStackTest2 {
	public static void main(String[] args) {
		System.out.println("main(String[] args) 가 시작됐음.");
		firstMethod();
		System.out.println("main(String[] args) 가 끝났음.");
	}
	
	static void firstMethod() {
		System.out.println("\tfirstMethod() 가 시작됐음.");
		secondMethod();
		System.out.println("\tfirstMethod() 가 끝났음.");
	}
	
	static void secondMethod() {
		System.out.println("\t\tsecondMethod() 가 시작됐음.");
		System.out.println("\t\tsecondMethod() 가 끝났음.");
	}
	
}

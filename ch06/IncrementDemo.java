package ch06;

public class IncrementDemo {
	public static void main(String[] args) {
		int x=0;
		System.out.println("increment() 메소드를 호출하기 전의 x 는 " + x);
		increment(x);
		System.out.println("increment() 메소드를 호출한 후의 x 는 " + x);
		
	}
	
	public static void increment(int n) {
		System.out.println("increment() 메소드를 시작할 때의 n 은 " + n);
		n++;
		System.out.println("increment() 메소드를 끝날 때의  n 은 " + n);
		
	}
	
}

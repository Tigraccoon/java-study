package ch13;

public class Exam {
	public static void main(String[] args) {
		String a = "Hello";
		String b = "Hello";
		System.out.println(a==b);		// true	/ a, b의 주소가 같음	String pool 영역
		
		String c = new String("Hello");	// new로 새로운 주소	heap영역으로 들어가서 메모리를 차지함
		String d = new String("Hello");	// new로 새로운 주소	heap영역으로 들어가서 메모리를 차지함
		System.out.println(c==d);		// false / == 는 주소값을 비교함
		System.out.println(c.equals(d));// true	/ equals는 문자열의 내용을 비교함
		
		
	}
	
}

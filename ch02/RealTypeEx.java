package ch02;

public class RealTypeEx {

	public static void main(String[] args) {
		
		double d = 0.1234;
		double e = 1234E-4;			//1234E-4 = 1234 * 10-4 이므로 0.1234와 동일
		float f = 0.1234f;				//float 변수는 숫자 뒤 f나 F를 붙임
		double w = .1234D;			//D는 생략 가능, .1234D와 .1234와 0.1234는 동일
		
		
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(w);
		
	}
	
}

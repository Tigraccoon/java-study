package ch13;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		System.out.println(Math.ceil(10.1));	//올림
		System.out.println(Math.round(10.4));	//반올림
		System.out.println(Math.floor(10.9));	//버림
		System.out.println(Math.pow(10, 3));	//제곱
		System.out.println(Math.random());
		
		Random rand = new Random();
		System.out.println("정수값 : "+rand.nextInt(100));	//100 이하의 랜덤 정수
		System.out.println("실수값 : "+rand.nextDouble());	//1 이하의 랜덤 실수
		
		int a=10;
		
		Integer b=20;
		Integer c=new Integer(30);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(c.intValue());
		
	}
	
}

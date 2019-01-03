package ch13;

//import java.lang.*		//기본으로 포함되는 패키지
//Object class				//최상위 클래스(모든 클래스에서 기본으로 상속)

public class Obj {	//extends Object가 생략돼있음
	public static void main(String[] args) {
		Obj e1=new Obj();
		System.out.println(e1.getClass());	//클래스의 정보
		System.out.println(e1);				//객체의 주소값(hash code)
		System.out.println(e1.toString());	//문자열로 변환
		
		
	}
	
}

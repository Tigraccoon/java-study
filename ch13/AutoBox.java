package ch13;

public class AutoBox {
	public static void main(String[] args) {
		//기본 자료형
		int num1=10;
		int num2;
		
		//객체(클래스) 데이터 자료형
		Integer i1;	//객체 참조 변수(주소값 저장), 아직은 선언만 한 상태라서 값은 null 상태.
		Integer i2 = new Integer(20);
		i1=num1;	//Auto Boxing(기본 자료형을 객체 자료형으로 박스 처리)
		num2=i2;	//Auto unBoxing(객체 자료형을 기본 자료형으로 언박싱 처리)
		
		System.out.println(num1+", "+i1);
		System.out.println(num2+", "+i2);
	}
	
}

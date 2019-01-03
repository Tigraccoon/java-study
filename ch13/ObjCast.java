package ch13;

public class ObjCast {
	public static void main(String[] args) {
		int a=10;
		Object obj=20;
		
		a=(Integer)obj;	//정상적인 형변환 하지만 a=(int)obj도 가능.. 구버젼에서는 obj가 객체형이라 기본 자료형으로 하면 안 됐음.
		System.out.println(a);
		
		Object[] obj2={100,200.5,true,"Hi!",'A'};
		//각 데이터가 Object객체(Integer,Double,Boolean...)로 돼버린다.(Auto Boxing) 하지만 메모리 낭비가 심함.
		
		for (Object o : obj2) {	//향상된 for문
			System.out.println(o);	//Auto unBoxing
			
		}
		
	}
	
}

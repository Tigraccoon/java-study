package ch10;

public class StaticVar {
	static int a = 20;	//static
	int b = 20;			//non static
	
	public static void main(String[] args) {
		System.out.println(StaticVar.a);	//static 메모리에 올라간 함수라서 new를 안 쓰고 이렇게도 호출 가능.

		StaticVar s = new StaticVar();
//		non-static member는 new를 써서 사용. 
		System.out.println(s.b);
//		물론 static member도 경고가 뜨긴 하지만 사용가능. 
//		System.out.println(s.a);
	}
	
}

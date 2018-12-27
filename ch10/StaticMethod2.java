package ch10;

public class StaticMethod2 {
	
	static void imstatic() {
		System.out.println("static method 호출!");
		System.out.println("저는 static 멤버에요!");
		System.out.println("안녕?!");
	}
	
	void amistatic() {
		System.out.println("non-static method 호출..");
		System.out.println("저는 non-static 멤버에요..");
		System.out.println("hi..?");
	}
	
	public static void main(String[] args) {
		imstatic();

		StaticMethod2 non = new StaticMethod2();
		
		System.out.println();
		
		non.amistatic();
		
		
	}
	
	
}

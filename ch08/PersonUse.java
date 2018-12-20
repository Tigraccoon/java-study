package ch08;

public class PersonUse {
	public static void main(String[] args) {
		//객체 생성 겸 기본생성자 호출
		Person p1 = new Person();	
		p1.showInfo();
		
		//객채 생성 겸 String 매개변수 1개
		Person p2 = new Person("김찰스");
		p2.showInfo();
		
		//객채 생성 겸 String, int 매개변수 2개
		Person p3 = new Person("팍찬호", 185);
		p3.showInfo();
		
		//객채 생성 겸 String, int, int 매개변수 3개
		Person p4 = new Person("팍지성", 175, 70);
		p4.showInfo();
		
	}

}

package ch07;

class Phone{		// 한 파일에 다수의 클래스를 생성 가능하지만 간단한 기능의 프로그램에서만 사용.
	String model;
	int value;
	
	void print() {
		System.out.println(value + " 만원 짜리 " + model + " 스마트폰");
	}
	
}

public class PhoneDemo {	//파일을 저장시 public class의 이름으로 저장됌.
	public static void main(String[] args) {
		Phone myPhone = new Phone();
		myPhone.model = "갤럭시 S9";
		myPhone.value = 100;
		myPhone.print();
		
		Phone yourPhone = new Phone();
		yourPhone.model = "아이폰8";
		yourPhone.value = 120;
		yourPhone.print();
		
		
	}
	
}

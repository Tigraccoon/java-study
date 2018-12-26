package ch09;

class Food {
	String getFruit() {
		return "";
	}
}

class Apple extends Food {
	String getFruit() {
		return "사과";
	}
}

class Banana extends Food {
	String getFruit() {
		return "바나나";
	}
}

public class FoodTest {
	public static void main(String[] args) {
		Apple a1 = new Apple();
		Banana b1 = new Banana();
		
		System.out.println("저는 " + a1.getFruit() + "를 좋아합니다.");
		System.out.println("저는 " + b1.getFruit() + "를 좋아합니다.");

		
	}
	
	
}

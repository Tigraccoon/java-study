package ch09;

public class Circle {
	private void secret() {
		System.out.println("비밀");
	}
	
	protected void findRadius() {
		System.out.println("반지름이 10센티이다.");
		secret();
	}
	
	public void findArea() {
		System.out.println("넓이는 (파이*반지름*반지름) 이다.");
	}
	
}

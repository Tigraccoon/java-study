package ch07;

public class BottleTest {
	public static void main(String[] args) {
		Bottle b = new Bottle();
		
		b.oldsize = "1000ml";
		b.newsize = "500ml";
		
		System.out.println("물병의 용량은 " + b.oldsize + " 인데 지금 남은 용량은 " + b.newsize + " 입니다.");
	}
	
}

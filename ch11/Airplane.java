package ch11;

public class Airplane implements Flyer {
	//interface 클래스는 implements로 구현함

	@Override
	public void takeOff() {
		System.out.println("Airplane 이륙");
	}

	@Override
	public void fly() {
		System.out.println("Airplane 비행");
	}

	@Override
	public void land() {
		System.out.println("Airplane 착륙");
	}
}

package ch12;

interface RemoteControl {
	void turnOn();
	void turnOff();
}

public class AnonymousClassTest {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("TV turnOn()");
			}

			@Override
			public void turnOff() {
				System.out.println("TV turnOff()");
			}
			
		};	// interface인 RemoteControl을 상속받아 무명클래스로 생성
		
		rc.turnOn();
		rc.turnOff();
	}
	
}

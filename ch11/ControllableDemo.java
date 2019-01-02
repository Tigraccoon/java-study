package ch11;

public class ControllableDemo {
	public static void main(String[] args) {
		TV tv=new TV();
		tv.turnOn();
		tv.turnOff();
		tv.repair();
		
		Controllable.reset();
		//Controllable클래스의 static메소드인 reset() 접근
		//클래스이름.메소드이름
		Computer com = new Computer();
		com.turnOn();
		com.turnOff();
		com.repair();
		Controllable.reset();
		
		NoteBook not = new NoteBook();
		not.turnOn();
		not.turnOff();
		not.repair();
		Controllable.reset();
		
	}
	
}

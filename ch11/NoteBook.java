package ch11;

public class NoteBook implements Controllable {

	@Override
	public void turnOn() {
		System.out.println("NoteBook을 켠다.");
	}

	@Override
	public void turnOff() {
		System.out.println("NoteBook을 끈다.");
	}

}

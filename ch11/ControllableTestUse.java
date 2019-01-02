package ch11;

public class ControllableTestUse{
	public static void main(String[] args) {
		Computer c1 = new Computer();
		c1.turnOn();
		c1.turnOff();
		c1.repair();
		ControllableTest.reset();
		
	}
	
}

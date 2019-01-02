package ch11;

public class AutoCarTest {
	public static void main(String[] args) {
		OperateCar obj = new AutoCar();//다형성(좌:부, 우:자)
		obj.start();
		obj.setSpeed(30);
		obj.turn(15);
		obj.stop();
	}
}

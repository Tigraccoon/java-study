package ch09;

public class SportsCarTest {
	public static void main(String[] args) {
		SportsCar obj = new SportsCar();
		
		//SportsCar 객체는 Car 객체를 상속받았기 때문에 Car 객체의 멤버(변수, 메소드)를 모두 사용 가능
		obj.speed = 10;		//Car의 글로벌 변수 호출 및 초기화
		obj.setSpeed(60);	//Car의 글로벌 메소드 호출 및 초기화
		obj.setTurbo(true);
		
	}
	
}

package ch07;

public class Car {
	String color;
	int speed;
	int gear;
	
//	public String toString() {
//		return "Car [color="+color+", Spped=" + speed + ", gear=" + gear + "]";
//		
//	}
	
	
	
	void changeGear(int g) {
		gear=g;
		
	}

	public String toString() {	//우클릭 - source - Generate toString 	=> 다른 클래스에서 호출 시 주소값 대신 글로벌 변수의 값을 출력
		return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + "]";
	}

	void speedUp(){
		speed+=10;
	}
	
	void speedDown() {
		speed-=10;
	}
	
	
}

package ch07;

class MyCar{
	int value;
	String car;
	
	void print() {
		System.out.println(value+" 만원 짜리 " + car);
	}
	
}

public class MyCarTest {
	public static void main(String[] args) {
		MyCar mc = new MyCar();
		mc.value = 7000;
		mc.car = "ClubMan";
		
		mc.print();
		
		MyCar yc = new MyCar();
		yc.value = 6000; 
		yc.car = "Cooper";
		
		yc.print();
		
	}
	
}

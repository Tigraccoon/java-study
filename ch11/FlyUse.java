package ch11;

public class FlyUse {
	public static void main(String[] args) {
		Bird bird=new Bird();
		bird.takeOff();
		bird.fly();
		bird.land();
		
		Airplane air=new Airplane();
		air.takeOff();
		air.fly();
		air.land();
		
		Flyer f=new Bird();//좌변(부모) = 우변(자식) => 다형성
		//f는 Bird객체의 주소값
		System.out.println(f);
		f.takeOff();
		f.fly();
		f.land();
		
		f=new Airplane();
		//f는 Airplane객체의 주소값
		System.out.println(f);
		f.takeOff();
		f.fly();
		f.land();
		
	}

}

package ch09;

class Animal{
	public Animal() {}
	
	public Animal(String s) {
		System.out.println("동물 : " + s);
	}
	
}

class Mammal extends Animal{
	public Mammal() {
		super("원숭이");
		System.out.println("포유류 : 원숭이");
	}
	
	public Mammal(String s) {
		super(s);
		System.out.println("포유류 : " + s);
	}
}


public class AnimalDemo {
	public static void main(String[] args) {
		Mammal ape = new Mammal();			//객체 생성 및 호출
		Mammal lion = new Mammal("사자");	//객체 생성 및 호출
		
		
		
		
	}
	
	
}

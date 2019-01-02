package ch12;

import ch11.Flyer;

public class InnerUse {
	public static void main(String[] args) {
		Flyer f = new Flyer() {

			@Override
			public void takeOff() {
				System.out.println("takeOff!");
			}

			@Override
			public void fly() {
				System.out.println("fly!");
			}

			@Override
			public void land() {
				System.out.println("land!");
			}
			
		};	// 무명 클래스
			// new 자료형(){ }; -> Anonymous class
		
		f.takeOff();
		f.fly();
		f.land();
	}
	
}

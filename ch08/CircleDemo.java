package ch08;

public class CircleDemo {
	public static void main(String[] args) {
		Circle c1 = new Circle(15.0,"green");
		c1.print();
		
		Circle c2 = new Circle(5.0);
		c2.print();
		
		Circle c3 = new Circle("yellow");
		c3.print();
		
		Circle c4 = new Circle();
		c4.print();
		
	}
	
}	// end of class CircleDemo


class Circle{
	double radius;
	String color;
	public Circle(double r, String c) {
		System.out.println("c1");
		radius = r;
		color = c;
	}
	
	public Circle (double r) {
		System.out.println("c2");
		radius = r;
		color = "blue";
	}
	
	public Circle (String c) {
		System.out.println("c3");
		radius = 10.0;
		color = c;
	}

	public Circle() {
		System.out.println("기본");
		radius = 10.0;
		color = "red";
	}
	
	public void print() {
		System.out.println("반지름 : " + radius);
		System.out.println("색  깔 : " + color);
		System.out.println();
	}
	
	
}	// end of class Circle

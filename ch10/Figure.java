package ch10;

class Triangle extends Figure {
	void draw() {
		System.out.println("삼각형 그리기");
	}
}

class Rectangle extends Figure{
	void draw() {
		System.out.println("사각형 그리기");
	}
}

class Circle extends Figure{
	void draw() {
		System.out.println("원 그리기");
	}
}

public class Figure {
	void draw() {
		System.out.println("도형을 그린다");
	}

	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.draw();
		Rectangle r = new Rectangle();
		r.draw();
		Circle c = new Circle();
		c.draw();
		
		//has a 관계. 부모는 자식을 포함한다.
		//좌변의 자료형(부모)과 우변의 자료형(자식)이 다름.
		//좌변과 우변의 자료형이 다르지만 좌변의 부모 객체인 Figure 하나로 처리 가능한 이유는 다형성 때문.
		Figure f = new Triangle();
		f.draw();
		f = new Rectangle();
		f.draw();
		f = new Circle();
		f.draw();

	}


}

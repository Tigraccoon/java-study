package ch11;
//추상클래스를 상속받아서 사용할 경우
//추상 method를 구현(implement 또는 Override 라고도 함)해야함.
//추상클래스를 쓰는 이유는 표준화(유지보수의 이유) 때문
//추상클래스는 인스턴스를 만들 수 없음.

public class AbstractExtends extends AbstractClass {

	@Override
	void method1() {
		System.out.println("추상 method를 완성한 method");
	}
	public static void main(String[] args) {
		AbstractExtends ex=new AbstractExtends();
		ex.method1();
		ex.method2();
	}

}

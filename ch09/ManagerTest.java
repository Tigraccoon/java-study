package ch09;

public class ManagerTest {
	public static void main(String[] args) {
		Manager m = new Manager("Tom", "Seoul", 1000000, 991234, 50000);
		System.out.println(m);	//toString()호출해서 리터럴 값 출력
		m.test();
	}
}

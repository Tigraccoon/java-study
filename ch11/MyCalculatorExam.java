package ch11;

public class MyCalculatorExam {
	public static void main(String[] args) {
		Calculator cal = new MyCalculator();	//다형성 (좌변 : 부모, 우변 : 자식)
		//인터페이스 클레스라 이렇게 사용해야 가능.
		
		int value1 = cal.multiple(5, 10);
		int value2 = cal.plus(5, 10);
		int value3 = cal.exec(5, 10);
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
		
	}
	
}

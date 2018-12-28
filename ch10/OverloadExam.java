package ch10;

public class OverloadExam {
	public void putData(String a) {
		System.out.println(a);
	}
	
	public void putData(int a) {
		System.out.println(a);
	}
	
	public void putData(double a) {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		OverloadExam o= new OverloadExam();
		
		o.putData("Hello");
		o.putData(100);
		o.putData(100.5);
		
	}
	
}

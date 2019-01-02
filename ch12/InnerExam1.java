package ch12;

public class InnerExam1 {
	class Cal {	//inner class
		int value =0;
		public void plus() {
			value++;
		}
	}	//end inner class
		
	public static void main(String[] args) {
		InnerExam1 t = new InnerExam1();	//outer class 객체 생성
		//inner class 객체 생성시 
		//outer class.inner class 변수명 = outer class 변수.new inner class();
		InnerExam1.Cal c = t.new Cal();		//inner class 객체 생성
		
		c.plus();
		System.out.println(c.value);
		
		
	}
	
}

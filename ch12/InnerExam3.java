package ch12;

public class InnerExam3 {
	public void exec() {
		class Cal {
			int value =0;
			public void plus() {
				value++;
			}//inner method
			
		}//inner class
		
		Cal c = new Cal();
		c.plus();
		System.out.println(c.value);
		
	}//method
	
	public static void main(String[] args) {
		InnerExam3 t = new InnerExam3();
		
		t.exec();
		
	}
	
}// public class

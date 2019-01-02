package ch12;

public class InnerExam2 {
	static class Cal {	// * static형태임
		int value =0;
		public void plus() {
			value++;
		}
		
	}
	
	public static void main(String[] args) {
		// static inner class 인 경우
		// outer class.inner class 변수명 = new outer class.inner class();
		InnerExam2.Cal c = new InnerExam2.Cal();
		c.plus();
		System.out.println(c.value);
		
		
	}
	
}

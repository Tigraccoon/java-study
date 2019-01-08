package ch15;

public class ThrowsExam {
	
	//예외처리 방법
	//try~catch 직접 처리
	//throws 예외처리 클래스에 위임
	//메소드 이름 throws 예외처리 클래스1, 예외처리 클래스2 ... : 예외처리 클래스는 여러개 지정 가능
	//main method 내부의 코드를 실행하다가 예외가 발생하면 직접 처리하지 않고 throws 뒤에 지정한 예외처리 클래스에 처리를 위임
	
	public static void main(String[] args) throws InterruptedException {
		for(int i=1;i<10;i++) {
			System.out.println(i);
			Thread.sleep(1000);	//Interrupt (CPU 간섭)
		}
		
	}
	
}

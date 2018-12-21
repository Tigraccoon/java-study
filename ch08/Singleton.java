package ch08;

public class Singleton {
	
	private Singleton() {
		print();
	}
	
	//싱글톤 처리된 생성자는 private static으로 처리하고 클래스명, 변수명으로 명시해서 사용
	private static Singleton instance;	//보통 싱글톤에선 instance라는 변수 명을 사용
	
	//생성자가 private 처리가 됐을 땐 public static으로 처리한 메소드로 우회 접근
	public static Singleton getInstance() {	
		if(instance == null) {	//처음으로 인스턴스를 만든다면
			instance = new Singleton();	//여기서 실제 new를 통해 생성자를 호출
		}
		return instance; //참조변수의 주소값을 리턴
	}	// end of getInstance
	
	public void print() {
		System.out.println("생성자");
	}
	
}	// end of Singleton

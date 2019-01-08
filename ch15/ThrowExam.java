package ch15;

public class ThrowExam {

	//throw : 예외를 직접 발생시키는 방법
	//테스트 이외에는 거의 쓸 일이 없다.
	
	static void test (int n) {
		if (n==0) {
			throw new NullPointerException();
			//throw new 에외처리 클래스 이름(); 특정한 조건에 인위적으로 예외를 발생시킴
			//throws와 throw 혼동 주의ㅉ
		}
	}
	
	public static void main(String[] args) {
		test(0);
	}
}

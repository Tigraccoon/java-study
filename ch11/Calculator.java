package ch11;

public interface Calculator {
	public int plus(int i, int j);	//추상 메소드
	public int multiple(int i, int j);	// 추상 메소드
	default int exec(int i, int j) {	// (인터페이스 클레스인데도)일반 메소드 jdk 1.8부터 가능한 기능하지만 실무에선 사용 안 함.
		return i+j;
	}
	
}

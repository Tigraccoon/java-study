package ch08;

public class MyManager {
	private int score;
	
	private MyManager(int score) {
		this.score = score;
	}
	
	//싱글톤 처리된 생성자는 private static 클래스명 참조변수;
	private static MyManager instance;
	public static MyManager getinstance() {
		if (instance == null) {
			instance = new MyManager(10);
		}
		return instance;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}

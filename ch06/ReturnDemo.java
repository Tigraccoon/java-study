package ch06;

public class ReturnDemo {
	public static void main(String[] args) {
		printScore(99);
		printScore(120);
		
	}
	
	public static void printScore(int score) {
		if (score<=0 || 100<=score) {
			System.out.println("잘못된 점수 : " + score);
			return;	//코드블럭 내에서 return을 만나면 해당메소드 종료
		}
		System.out.println("점수 : " + score);
	}
	
}

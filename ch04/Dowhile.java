package ch04;

public class Dowhile {
	public static void main(String[] args) {
		int i = 1;
		do {	//먼저 실행
			System.out.print(i);
			i++;
		} while(i <= 10);	// 나중에 검사
	}
}

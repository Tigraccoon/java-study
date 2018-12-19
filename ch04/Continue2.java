package ch04;

public class Continue2 {
	public static void main(String[] args) {

		int i;
		for(i = 1 ; i <= 10 ; i++) {
			if (i % 2 ==0) {
				continue;
			}
			System.out.println("홀수값 : " + i);
		}

	}
}

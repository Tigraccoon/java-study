package ch04;

public class Dowhile2 {
	public static void main(String[] args) {
		int i = 1, sum = 0;
		do {
			sum += i ;
			i++;
		} while(i <= 10);
		System.out.println("1 ~ 10까지의 합계 : " + sum);
	}
}

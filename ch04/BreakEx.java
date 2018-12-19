package ch04;

public class BreakEx {
	public static void main(String[] args) {
		int n=1;
		while(n<=10) {
			System.out.println(n + ". Hello World !");
			n++;
			if (n==8) {
				break;
			}
		}
		
		System.out.println("n 값이 s 이며 while문 빠져나옴");
	}
}

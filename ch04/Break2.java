package ch04;

public class Break2 {
	public static void main(String[] args) {
		int i=1;
		while (i <= 9) {
			System.out.println(i++);
			if(i >= 5) {
				break;
			}
		}
		System.out.println("** 반복문 종료 **");
	}
}

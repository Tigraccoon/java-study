package ch04;

public class Char_Tower2 {
	public static void main(String[] args) {
		int i, j;
		char a = 65;
		for (i = 1 ; i < 7 ; i++) {	//for1
			for (j = 1 ; j <= i ; j++) {	//for2
				System.out.print(a++);

			}	//for2
			System.out.println();
		}	//for1
	}
}

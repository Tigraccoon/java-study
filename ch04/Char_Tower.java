package ch04;

public class Char_Tower {
	public static void main(String[] args) {

		int i, j; 
		char a = 65;	//65 는 아스키코드 A
		for ( i = 1 ; i < 5 ; i++) {	//for1
			for (j = 1 ; j <= i ; j++) {	//for2
				System.out.print(a++);
			}	//for2
			System.out.println();
		}	//for1

	}
}

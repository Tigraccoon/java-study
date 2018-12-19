package ch04;

public class Matrix2 {
	public static void main(String[] args) {
		for ( int i = 1 ; i <= 5 ; i++) {	// for1
			for ( int j = 1 ; j <= 5 ; j++) {	// for2
				if (i == j) {
					System.out.printf("[%d, %d]" , i, j);
				}	
				else {
					System.out.printf("%5c", ' ');	// %c 는 문자 출력, 5칸씩 공백
				}	
			}	//end for2
			System.out.println();
		} // end for1
	}
}

package ch04;

public class For_For {
	public static void main(String[] args) {
		for ( int i = 1 ; i <= 5 ; i++) {	// start for 1
			System.out.print(i + " ");
			for (int j = 1 ; j <= 10 ; j++) {		// start for 2
				System.out.print(" * ");
			}	// end for 2
			System.out.println();
		}	// end for 1
	}	// end main
}	// end class

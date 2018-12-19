package ch04;

public class Star {
	public static void main(String[] args) {
		for (int i = 1 ; i <= 5 ; i++) {	// for 1
			for (int j = 1 ; j <= i ; j++) {		//for 2
				System.out.print("*");
				
			}	// end for 2
			System.out.println();
			
		}	// end for 1
		
		for (int i = 4 ; i >= 1 ; i --) {	// for1
			for (int j = 1 ; j <= i ; j++) {		// for2
				System.out.print("*");
				
			}	// end for 2
			System.out.println();
			
		}	// end for 1
	}
}

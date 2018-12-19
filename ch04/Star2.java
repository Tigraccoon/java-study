package ch04;

public class Star2 {
	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {	// for1
			for (int j = 4; j > 0 ; j --) {	// for2
				if (i < j) {	
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
				
			}	//end for 2
			System.out.println();
			
		}	// end for 1
			
		
	}
}

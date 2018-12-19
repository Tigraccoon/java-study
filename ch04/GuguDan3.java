package ch04;

public class GuguDan3 {
	public static void main(String[] args) {
		
		for (int i = 1 ; i <= 9 ; i++ ) {
		
			System.out.print(" * " + i + "단 :\t");
			
			for(int n = 1 ; n <= 9 ; n++) {
				
				System.out.print(i + " * " + n + " = " + i * n + "\t\t");
				
			}
			
			System.out.println();
			
		}
		
	}
}

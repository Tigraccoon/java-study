package ch04;

public class Star3 {
	public static void main(String[] args) {

		for(int i=0;i<4;i++){
			for (int j=0;j<=2-i;j++) {
				System.out.print(" ");
			}
			for (int n=0;n<(i*2)+1;n++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	
	}

}

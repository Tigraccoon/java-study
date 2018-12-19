package ch04;

public class Even {

	public static void main(String[] args) {
		int tot = 0;
		for (int i = 1 ; i <= 10 ; i ++) {
			
			if ( i % 2 == 0) {
				
				tot += i;
				
			} // end if
			
		} // end for

		System.out.println("1 ~ 10 사이의 짝수의 합은 : " + tot);

		
	}
	
}

package ch03;
	//논리 연산  && = AND, || = OR
public class AndOr {

	public static void main(String[] args) {
		
		int a = 7;
		System.out.println( a > 5 && a < 0 ); 		// t && f = > f
		System.out.println( a > 5 || a < 0 ); 			// t && f => t
		
	}
	
}

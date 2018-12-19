package ch03;
	//대입 연산자와 비교 연산자
public class Compare {

	public static void main(String[] args) {
		
		int a = 65;
		char c = 'A';
		System.out.println( a == c );	// a와 c가 같는가?		ture			- A가 아스키 코드로 65의 값이 있음
		System.out.println( a = c );		// a에 c를 대입									- 자동 형 변환으로 인해 'A'가 int형으로 변환돼 'A'의 아스키값인 65가 출력 
		System.out.println( 'A' != 65 );	// A 와 c가 같지 않은가?	false	 
		
	}
	
}

package ch03;

public class CompLogicDemo {

	public static void main(String[] args) {
		
		int x = 0, y = 1;
		System.out.println( (x < 1 ) || (y-- < 1 ));		// t || f => t
		System.out.println( "x = " + x + ", y = " + y );	// y 값이 그대로 1인 이유는 논리 연산자에 있는 앞의 조건이 true이면 뒤에 조건을
																							// 계산 안 하는 쇼트 서킷이 발생하기 때문에 그대로 값이 1로 남아 있는 것.
		x = 0;
		y = 1;
		System.out.println( ( x < 1 ) | ( y-- < 1 ));		// t | f => t
		System.out.println( "x = " + x + ", y = " + y);	// 비트 연산에선 쇼트 서킷이 없어서 y값이 0으로 바뀜.
		
	}

}

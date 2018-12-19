package ch02;

public class TypeMismatch {

	public static void main(String[] args) {
		
		byte n;		//byte 타입 변수에는 -128 ~ 127까지만 대입 가능
		n = 127;
		
		System.out.println(n);
		
	}

}

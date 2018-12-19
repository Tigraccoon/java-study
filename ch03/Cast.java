package ch03;

public class Cast {

	public static void main(String[] args) {
		
		float f = 1.6F;
		System.out.println(f);
		
		f = 100;								// 자동 형 변환
		System.out.println(f);
		
		f = 100.5F;
		int i = (int)f;						// 강제 형 변환이 이루어질 경우 소숫점 이하는 버림 현상 발생
		System.out.println(i);
		
		i = 300;
		byte b = (byte)i;
		System.out.println(b);	// 강제 형 변환 시 크기가 클 경우 값이 이상하게 나옴.
		
		
	}
	
}

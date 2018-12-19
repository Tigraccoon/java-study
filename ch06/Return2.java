package ch06;

public class Return2 {
	public static void main(String[] args) {
		System.out.println(sum2(300));
		System.out.println(sum2(500));
	}
	
	static int sum2(int a) {
		int result =0;
		
		for(int i=1;i<=a;i++) {
			result+=i;
		}
		return result;
		
	}
	
}

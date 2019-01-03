package ch13;

public class ExceptionEx {
	public static void main(String[] args) {
		int[] nums={10,20,30,40,50};
		
		try {
		for(int i=0;i<=5;i++) {
			System.out.println(nums[i]);
		}
		} catch(Exception e) {
			System.out.println("\n프로그램 실행 중 에러가 발생했습니다."+e);
		}
		
		System.out.println("프로그램 종료");
	}
	
}

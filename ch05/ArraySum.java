package ch05;

public class ArraySum {
	public static void main(String[] args) {
		int [] num = {10, 20, 30, 40, 50};
		int sum = 0;	// 배열의 합계를 저장할 변수
		for (int i = 0 ; i < num.length ; i++) {
			sum += num[i];	// i는 배열의 index값 배열을 for로 돌릴 땐 i를 0으로 하는게 나음
		}
		System.out.println("합계 : "+ sum);
		
	}
	
}

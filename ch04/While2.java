package ch04;
//1~N까지의 합계 계산
public class While2 {
	public static void main(String[] args) {
		int i=1, num=10, sum=0;
		while(i <= num) {
			sum += i;
			i++;
		}
		System.out.println("1 ~ " + num + " 까지의 합계 : " + sum);
		
	}
}

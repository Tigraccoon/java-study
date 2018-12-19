package ch06;

//자료형 ...변수 => 가변사이즈 매개변수, 변수가 배열참조 변수가 됨.
//같은 자료형의 매개변수의 갯수에 관계없이 처리.
//매개변수들이 배열로 저장.
//실제로 많이 쓰지는 않지만 알아두면 좋음.

public class VariantParam {
	
	static void print(String ...n) {	// n 이 가변형 매개변수(배열처리의 주소값)
		for (int i=0;i<n.length;i++) {
			System.out.print(" "+n[i]);
		}
		System.out.println();
	}	// print
	
	public static void main(String[] args) {
		print("Java");
		print("Java","program");
		print("Java","program","jsp");
		print("Java","program","jsp","big");
		print("Java","program","jsp","big","data");
	}
	
}

package ch05;

public class StringArray2 {
	public static void main(String[] args) {
		String[] str = {"Java", "DB", "JSP", "Spring"};
		// for(개별값 저장 변수 : 집합변수)
		// 집합변수의 모든 값을 반복처리
		for(String ss : str) {
			System.out.println(ss);
		}
		
	}
	
}

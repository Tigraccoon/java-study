package ch15;


public class Test {
	public static void main(String[] args) {

		try {
			int num = Integer.parseInt("abc");
			System.out.println(num);

		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException 예외 발생");
			e.printStackTrace();
		} finally {
			System.out.println("프로그램이 종료됐습니다.");
		}

	}

}

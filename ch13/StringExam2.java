package ch13;

public class StringExam2 {
	public static void main(String[] args) {
		String name1=new String("김갑수");
		String name2=new String("김갑수");
		
		String num1=new String("010-1234-5678");
		String num2=new String("010-1234-5678");
		
		System.out.println("-------------- (==) 사용 --------------");
		if (name1 == name2) {
			System.out.println("name1과 name2는 같은 인스턴스를 참조합니다.");
		} else {
			System.out.println("name1과 name2는 다른 인스턴스를 참조합니다.");
		}
		System.out.println("------------ equals() 사용 ------------");
		if (name1.equals(name2)) {
			System.out.println("name1과 name2는 같은 값을 가지고 있습니다.");
		}else {
			System.out.println("name1과 name2는 다른 값을 가지고 있습니다.");
		}
		System.out.println();
		System.out.println("-------------- (==) 사용 --------------");
		if (num1 == num2) {
			System.out.println("num1과 num2는 같은 인스턴스를 참조합니다.");
		} else {
			System.out.println("num1과 num2는 다른 인스턴스를 참조합니다.");
		}
		System.out.println("------------ equals() 사용 ------------");
		if (num1.equals(num2)) {
			System.out.println("num1과 num2는 같은 값을 가지고 있습니다.");
		}else {
			System.out.println("name1과 name2는 다른 값을 가지고 있습니다.");
		}
		
	}
	
}

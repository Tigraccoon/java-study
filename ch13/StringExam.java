package ch13;

public class StringExam {
	public static void main(String[] args) {
		String str1=new String("Hello world");
		String str2=new String("Hello world");
		
		//hashCode()는 보통 객체에 대한 고유값으로 쓰이지만
		//String에 있어서는 hashCode() 대신 System.identityHashCode()를 쓴다.
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println();
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		
		System.out.println(" * == 사용");
		if (str1==str2) {//주소값을 비교
			System.out.println("str1과 str2는 같은 인스턴스를 참조합니다.");
		}else {
			System.out.println("str1과 str2는 다른 인스턴스를 참조합니다.");
		}
		
		System.out.println(" * equals() 사용");
		if(str1.equals(str2)) {//내용을 비교
			System.out.println("str1과 str2는 같은 값을 갖고 있습니다.");
		}else {
			System.out.println("str1과 str2는 다른 값을 갖고 있습니다.");
		}
		
	}
	
}

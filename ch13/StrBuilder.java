package ch13;

public class StrBuilder {
	public static void main(String[] args) {
		//String : 불변(immutable)
		//StringBuilder : 가변(mutable)
		
		//StringBuffer str1=new StringBuffer(); // 초기 버젼
		StringBuilder str1=new StringBuilder();	// 최신 버젼
		//StringBuilder는 일반 객체이기 때문에 String과는 달리 new로 사용.
		
		str1.append("java");	//append()는 문자열 내용 추가, 메모리 절약
		System.out.println(str1);
		str1.append(" programming");
		System.out.println(str1);
		
		str1.replace(0, 4, "jsp");	//replace(start index, end index -1, "문자열");
		System.out.println(str1);
		
		String str2=str1.substring(4);//index -1부터 끝까지
		System.out.println(str1);
		System.out.println(str2);
		
		//StringBuilder를 String에 저장할 땐 toString()을 사용
		String str3 = str1.toString();
		System.out.println("StringBuilder(str1)을 String(str3)에 저장 / str3 : "+str3);
		
		//String을 StringBuilder에 저장할 땐 new StringBuilder()를 사용
		str1 = new StringBuilder(str3);
		System.out.println("String(str3)을 StringBuilder(str1)에 저장 / str1 : "+str1);
		
	}
	
}

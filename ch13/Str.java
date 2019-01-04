package ch13;

public class Str {
	public static void main(String[] args) {
		String str="Java Programing";
		System.out.println("str의 주소값 : "+System.identityHashCode(str));
		System.out.println("str : "+str);
		//대문자로 변경
		System.out.println("str : "+str.toUpperCase());
		//소문자로 변경
		System.out.println("str : "+str.toLowerCase());
		//원본은 바뀌지 않음(immutable, 불변성)
		System.out.println("str : "+str);
		
		str=str.toLowerCase();
		System.out.println("str의 주소값 : "+System.identityHashCode(str));
		System.out.println("str : "+str);
		
		str="";	//null 문자열 ('\0'값이 들어가 있음)
		System.out.println("str : "+str);
		System.out.println("str의 주소값 : "+System.identityHashCode(str));
		
		str=null;
		System.out.println("str : "+str);
		System.out.println("str의 주소값 : "+System.identityHashCode(str));
		
		char ch='\0';
		System.out.println("ch : "+ch+", code : "+(int)ch);
		
		ch=' ';
		System.out.println("ch : "+ch+", code : "+(int)ch);
		
	}
	
}

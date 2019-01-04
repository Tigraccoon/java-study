package ch13;

public class StrMethod {
	public static void main(String[] args) {
		String str1="java";
		str1+=" programming";	//문자열 연결이지만 실제로는 새로운 문자열을 만들고 str1은 새로운 문자열의 주소값을 가르키게 됌.
		System.out.println(str1);
		
		System.out.println(str1.length());
//		System.out.println(str1.charAt(9));
//		System.out.println(str1.substring(4, 9));
//		System.out.println(str1.substring(5));
		
		String str2=str1.concat(" programming");
		System.out.println(str2);
		System.out.println(str1);
		
		System.out.println(str1.charAt(2));
		System.out.println(str2.indexOf("program"));	//"program"의 시작 문자열인 p의 시작 인덱스를 출력 값이 없으면 -1 출력
		
		System.out.println(str2.substring(0, 4));	//substring(startnum, endnum-1)
		System.out.println(str2.substring(5));	//5~끝까지 출력
		
		System.out.println(str2.replace("java", "jsp"));	//replace(old, new) 글자 변경
		System.out.println(str2);
		str2=str2.replace("java", "jsp");
		System.out.println(str2);
		
		
	}
	
}

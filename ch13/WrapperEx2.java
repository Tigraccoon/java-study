package ch13;

public class WrapperEx2 {
	public static void main(String[] args) {
		//Character 사용
		System.out.println("<Character> 사용");
		char[]ch= {'2','J','@'};
		for(int i=0;i<ch.length;i++) {
			if(Character.isDigit(ch[i])) {
				System.out.println(ch[i]+" : 숫자");
			} else if(Character.isAlphabetic(ch[i])) {
				System.out.println(ch[i]+" : 영문자");
			} else {
				System.out.println(ch[i]+" : 기타 문자");
			}
		}
		System.out.println();
		
		//Integer 사용
		System.out.println("<Integer> 사용");
		System.out.println("parseInt를 활용한 출력 : "+Integer.parseInt("300"));
		System.out.println("toString을 활용한 출력 : "+Integer.toString(300));
		System.out.println("toBinaryString()을 활용한 출력 : "+Integer.toBinaryString(300));
		System.out.println();
		
		//Double 사용
		System.out.println("<Double> 사용");
		System.out.println("parseDouble을 활용한 출력 : "+Double.parseDouble("300.0"));
		System.out.println("toString을 활용한 출력 : "+Double.toString(300.0));
		System.out.println();
		
		//Boolean 사용
		System.out.println("<Boolean> 사용");
		System.out.println("parseBoolean을 활용한 출력 : "+Boolean.parseBoolean("true"));
		System.out.println("toString을 활용한 출력 : "+Boolean.toString(true));
		
		
	}
	
}

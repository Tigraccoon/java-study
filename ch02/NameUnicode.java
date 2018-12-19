package ch02;

public class NameUnicode {

	public static void main(String[] args) {
		
		char a = '\uC774', b = '\uC7AC', c = '\uD638';
		
		System.out.println(a + "  "+ b + "  " + c);
		System.out.println("char형 ( ' \\uC774 ' ) : " + a);
		System.out.println("char형 ( ' \\uC7AC ' ) : " + b);
		System.out.println("char형 ( ' \\uD638 ' ) : " + c);
		
	}
	
}

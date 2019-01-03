package ch13;

public class Append {
	public static void main(String[] args) {
		String a="hello";		//불변 immutable		a=100번지
		a=a+"java";				//a=200번지
		System.out.println(a);
		
		StringBuilder b=new StringBuilder("HELLO");
		b.append("JAVA");
		System.out.println(b);
		b.reverse();
		System.out.println(b);
		
	}
	
}

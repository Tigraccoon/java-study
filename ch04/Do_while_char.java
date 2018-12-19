package ch04;

public class Do_while_char {
	public static void main(String[] args) {
		char c='a';
		do {
			System.out.print(c);
			c=(char)(c+1);
		} while(c <= 'z');
		
	}
}

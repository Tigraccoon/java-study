package ch08;

public class BookUse {
	public static void main(String[] args) {
		Book b1 = new Book("java","김선생","영진",2016,30000,10);
		b1.print();
		
		Book b2 = new Book();
		b2.print();
		
	}
	
}

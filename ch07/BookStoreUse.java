package ch07;

public class BookStoreUse {
	public static void main(String[] args) {
		BookStore bs = new BookStore();
		
		bs.setBookName("java");
		bs.setAuthor("김선생");
		bs.setPress("영진");
		bs.setYear(2018);
		bs.setAmount(10);
		bs.setPrice(30000);
		
		bs.print();
		
	}
	
}

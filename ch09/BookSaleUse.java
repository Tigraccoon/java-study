package ch09;

public class BookSaleUse {
	public static void main(String[] args) {
		BookSale b1 = new BookSale();
//		System.out.println("도서명\t출판사\t저자\t출판연도\t단가\t수량\t금액\t판매순위");
		
		b1.setBookName("java");
		b1.setPress("길벗");
		b1.setAuthor("김찰스");
		b1.setYear(2018);
		b1.setPrice(30000);
		
		b1.setAmount(10);
		b1.setMoney();
		b1.setRank(1);
		
		b1.print();
	}
	
}

package ch08;

public class Book {
	private String bookName;
	private String author;	//저자
	private String press;	//출판사
	private int year;		//출판연도
	private int price;		//단가
	private int amount;		//판매수량
	private int money;		//판매금액(단가*판매수량)
	
	public Book() {
		//this()를 활용하여 아래 매개변수가 6개인 생성자를 호출하면서 값들을 초기화
		this("자바","찰스킴","한빛",2017,20000,10);
		System.out.println("기본 생성자 호출!");
	}
	
	public Book(String bookName, String author, String press, int year, int price, int amount) {
		System.out.println("매개변수가 있는 생성자 호출!");
		this.bookName = bookName;
		this.author = author;
		this.press = press;
		this.year = year;
		this.price = price;
		this.amount = amount;
		money = price*amount;
	}
	
	public void print() {
		System.out.println("도서명\t저자\t출판사\t출판연도\t단가\t판매수량\t판매금액");
		System.out.println(bookName+"\t"+author+"\t"+press+"\t"+year+"\t"+price+"\t"+amount+"\t"+money);
		System.out.println();
	}
	
}	// end of class Book




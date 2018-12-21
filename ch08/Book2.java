package ch08;

public class Book2 {
	private String author;	//이름
	private String bookName;//도서명
	private String press;	//출판사
	private int price;		//가격
	private int amount;		//수량
	private int money;		//금액(단가*판매수량)
	private String grade;	//등급(10만원 이상이면 gold, 미만이면 silver)
	
	public Book2() {
		this("홍길동","java","한빛",20000,3);
	}
	
	public Book2(String author, String bookName, String press, int price, int amount) {
		this.author = author;
		this.bookName = bookName;
		this.press = press;
		this.price = price;
		this.amount = amount;
		money = price*amount;
		if (money >=100000) {
			grade = "gold";
		} else {
			grade = "silver";
		}
	}
	
	public void print() {
		System.out.println("이름\t도서명\t출판사\t가격\t수량\t금액\t등급");
		System.out.println(author+"\t"+bookName+"\t"+press+"\t"+price+"\t"+amount+"\t"+money+"\t"+grade);
	}
	
}

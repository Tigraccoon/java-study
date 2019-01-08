package ch14;

import java.util.Scanner;

public class Book {
	private String bookname;	//책이름
	private String press;		//출판사
	private int price;			//가격
	private int amount;			//판매수량
	private int money;			//판매금액(단가*판매수량)
	
	public void input() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("도서명 : ");
		bookname = scan.nextLine();
		System.out.print("출판사 : ");
		press = scan.nextLine();
		System.out.print("단가 : ");
		price = Integer.parseInt(scan.nextLine());
		System.out.print("수량 : ");
		amount = Integer.parseInt(scan.nextLine());
		
		money=price*amount;
		
	}
	
	//getter setter
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}

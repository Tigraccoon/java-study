package ch14;

import java.util.Scanner;

public class Shop {
	private String model;
	private String press;
	private int price;
	private int amount;
	private int money;
	
	public void input() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("제품명 : ");
		model = scan.nextLine();
		System.out.println("제조사 : ");
		press = scan.nextLine();
		System.out.println("단가 : ");
		price = scan.nextInt();
		System.out.println("수량 : ");
		amount = scan.nextInt();
		
		money = price * amount;
		
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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

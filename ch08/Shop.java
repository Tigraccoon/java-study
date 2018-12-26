package ch08;

public class Shop {
	private String name;
	private String model;
	private String company;
	private int price;
	private int amount;
	private int money;
	private String grade;
	
	public Shop() {
		//기본 생성자에서 다른 생성자 호출시 첫 라인에서 호출!!
		this("홍길동","OLEDTV","LG",400,2);
	}
	
	public Shop(String name, String model, String company, int price, int amount) {
		this.name = name;
		this.model = model;
		this.company = company;
		this.price = price;
		this.amount = amount;
		
	}
	
	public int getMoney() {
		money = price*amount;
		return money;
	}
	
	public String getGrade() {
		if(money >= 500) {
			grade = "gold";
		} else {
			grade = "silver";
		}
		return grade;
	}
	
	public void print() {
		System.out.println("고객명\t상품명\t제조사\t가격\t수량\t금액\t고객등급");
		System.out.println(name+"\t"+model+"\t"+company+"\t"+price+"\t"+amount+"\t"+getMoney()+"\t"+getGrade());
	}
	
}

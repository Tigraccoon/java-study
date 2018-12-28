package ch09;

public class Sale2 extends Product2 {
	private int price;
	private int amount;
	private int tot;
	
	public void input(String code, String name, String madeby,String date, int price, int amount) {
		super.setCode(code);
		super.setName(name);
		super.setMadeby(madeby);
		super.setDate(date);
		this.price = price;
		this.amount = amount;
		
		calc();
	}
	
	public void calc() {
		tot = price*amount;
	}
	
	public void print() {
		System.out.println("코드\t품명\t제조사\t제조일자\t\t단가\t수량\t금액(단위:천원)");
		System.out.println(getCode()+"\t"+getName()+"\t"+getMadeby()+"\t"+getDate()+"\t"+price+"\t"+amount+"\t"+tot);
	}
	
}

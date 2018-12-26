package ch09;

class Product{
	private int code;
	private String model;
	private String madeby;
	private String date;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMadeby() {
		return madeby;
	}
	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}

class Sale extends Product {
	private int price;
	private int amount;
	private int tot;
	
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

//	public int getTot() {
//		return tot;
//	}

	public int setTot() {
		return tot = getPrice()*amount;
	}

	
	
	public void print() {
		System.out.println("코드\t품명\t제조사\t제조일자\t\t단가\t수량\t금액(단위:천원)");
		System.out.println(getCode()+"\t"+getModel()+"\t"+getMadeby()+"\t"+getDate()+"\t"+price+"\t"+amount+"\t"+tot);
	}
	
}


public class SaleUse {
	public static void main(String[] args) {
		
		Sale s1 = new Sale();
		
		s1.setCode(1);
		s1.setModel("냉장고");
		s1.setMadeby("LG");
		s1.setDate("2018-01-01");
		
		s1.setPrice(1000);
		s1.setAmount(10);
		s1.setTot();
		
		s1.print();
		
	}
	
}

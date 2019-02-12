package project2;

public class ProductDTO {
	private int pcode;
	private String pname;
	private int price;
	private int pamount;
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPamount() {
		return pamount;
	}
	public void setPamount(int pamount) {
		this.pamount = pamount;
	}
	@Override
	public String toString() {
		return "ProductDTO [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", pamount=" + pamount + "]";
	}
	public ProductDTO() {
	}
	public ProductDTO(int pcode, String pname, int price, int pamount) {
		this.pcode = pcode;
		this.pname = pname;
		this.price = price;
		this.pamount = pamount;
	}
	
}

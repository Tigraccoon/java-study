package ch21;

public class ProductDTO {
	private String product_no;
	private String plocal;
	private String pname;
	private String company;
	private int uprice;
	private int acc;
	private int sprice;
	
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getPlocal() {
		return plocal;
	}
	public void setPlocal(String plocal) {
		this.plocal = plocal;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getUprice() {
		return uprice;
	}
	public void setUprice(int uprice) {
		this.uprice = uprice;
	}
	public int getAcc() {
		return acc;
	}
	public void setAcc(int acc) {
		this.acc = acc;
	}
	public int getSprice() {
		return sprice;
	}
	public void setSprice(int sprice) {
		this.sprice = sprice;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [product_no=" + product_no + ", plocal=" + plocal + ", pname=" + pname + ", company="
				+ company + ", uprice=" + uprice + ", acc=" + acc + ", sprice=" + sprice + "]";
	}
	
	public ProductDTO() {
	}
	
	public ProductDTO(String product_no, String plocal, String pname, String company, int uprice, int acc) {
		super();
		this.product_no = product_no;
		this.plocal = plocal;
		this.pname = pname;
		this.company = company;
		this.uprice = uprice;
		this.acc = acc;
		sprice = uprice*acc;
	}
	
	
}

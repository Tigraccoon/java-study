package project2;

import java.sql.Date;

public class LoginDTO {
	private String id;		//user id
	private String pwd;		//password
	private String name;	//name
	private String hp;		//phone number
	private String address;	//address
	private String email;	//e-mail
	private int amount;		//user amount
	private int point;		//bonus point
	private Date date;		//access date
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", hp=" + hp + ", address=" + address
				+ ", email=" + email + ", amount=" + amount + ", point=" + point + ", date=" + date + "]";
	}
	
	public LoginDTO() {
	}
	
	public LoginDTO(String id, String pwd, String name, String hp, String address, String email, int amount, int point,
			Date date) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.hp = hp;
		this.address = address;
		this.email = email;
		this.amount = amount;
		this.point = point;
		this.date = date;
	}
	public LoginDTO(String id, String pwd, String name, String hp, String address, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.hp = hp;
		this.address = address;
		this.email = email;
	}
	public LoginDTO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
}
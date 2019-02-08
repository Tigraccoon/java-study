package project2;

import java.sql.Date;

public class LoginDTO {
	private String id;
	private String pwd;
	private String name;
	private String hp;
	private String address;
	private String email;
	private int point;
	private Date date;
	private int admin=0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", hp=" + hp + ", address=" + address
				+ ", email=" + email + ", point=" + point + ", date=" + date + ", admin=" + admin + "]";
	}
	
	public LoginDTO() {
	}
	
	public LoginDTO(String id, String pwd, String name, String hp, String address, String email, int point, Date date,
			int admin) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.hp = hp;
		this.address = address;
		this.email = email;
		this.point = point;
		this.date = date;
		this.admin = admin;
	}
	
}

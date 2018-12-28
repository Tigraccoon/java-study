package ch09;

public class Employee2 {
	protected String num;	//사원번호
	protected String name;	//이름
	private String add;		//주소
	private String email;	//이메일

	
	public Employee2() {}
	public Employee2(String num, String name, String add, String email) {
		this.num=num;
		this.name=name;
		setAdd(add);
		setEmail(email);
		
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	@Override
//	public String toString() {
//		return "Employee2 [num=" + num + ", name=" + name + ", add=" + add + ", email=" + email + "]";
//	}
	
	
	
}

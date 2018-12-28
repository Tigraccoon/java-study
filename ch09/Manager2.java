package ch09;

public class Manager2 extends Employee2{
	protected int sal;		//연봉
	private String pid;		//주민번호
	protected int bonus;	//뽀너스
	
	public Manager2() {}
	public Manager2(String num, String name, String add, String email, int sal, String pid, int bonus) {
		super(num,name,add,email);
		this.sal = sal;
		setPid(pid);
		this.bonus=bonus;
		
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public void print() {
		System.out.println("사원번호 : "+"\t"+num);
		System.out.println("이름 : "+"\t"+"\t"+name);
		System.out.println("주소 : "+"\t"+"\t"+getAdd());
		System.out.println("이메일 주소 : "+"\t"+getEmail());
		System.out.println("연봉 : "+"\t"+"\t"+sal);
		System.out.println("주민번호 : "+"\t"+getPid());
		System.out.println("보너스 : "+"\t"+"\t"+bonus);
		
		
	}
	
	
}

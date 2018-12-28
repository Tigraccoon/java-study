package ch09;

public class Employee {
	public String name; 	//이름
	String address; 		//주소
	protected int salary; 	//월급
	private int rrn; 		//주민등록번호
	public Employee() {}
	public Employee(String name, String address, int salary, int rrn) {
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.rrn = rrn;
	}

	@Override
	public String toString() {	//개발자를 위한 디버깅용 메소드(해당 주소값에 있는 리터럴 출력)
		return "Employee [name=" + name + ", address=" + address + ", salary=" + salary + ", rrn=" + rrn + "]";
	}
}

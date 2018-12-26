package ch09;

public class Student {
	protected String name;
	protected String num;
	protected String major;
	protected int year;
	
	public Student() {}
	
	public void input(String name, String num, String major, int year) {
		this.name = name;
		this.num = num;
		this.major = major;
		this.year = year;
	}
	
}

package ch07;

public class Student {
	private String name;
	private String major;
	private int grade;
	private int snum;
	private double avgn;
	private int pay;
	private int bonus;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public double getAvgn() {
		if (avgn>4.5) {
			avgn = 4.5;
			bonus = pay;
		}else if(avgn >= 4.3) {
			bonus = pay;
		} else if (avgn >= 4.0) {
			bonus = 250;
		} else if (avgn >= 3.5) {
			bonus = 100;
		} else {
			bonus = 0;
		}
		
		return avgn;
	}
	public void setAvgn(double avgn) {
		this.avgn = avgn;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	void print() {
		System.out.println("이름\t전공\t학년\t학번\t학점평균\t등록금\t장학금");
		System.out.println(name+"\t"+major+"\t"+grade+"\t"+snum+"\t"+getAvgn()+"\t"+pay+"만\t"+bonus+"만");
	}
	
}

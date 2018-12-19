package ch07;

public class Point2 {
	private String name;
	private String grade;
	private double avg;
	private int tot;
	private int java;
	private int db;
	private int jsp;
	private int spring;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		if (avg >= 100) {
			grade = "A+";
		} else if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60){
			grade = "D";
		} else {
			grade = "F";
		}
		
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getAvg() {
		avg = tot / 4.0;
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getTot() {
		tot = java+db+jsp+spring;
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getDb() {
		return db;
	}
	public void setDb(int db) {
		this.db = db;
	}
	public int getJsp() {
		return jsp;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	
	public void print () {
		System.out.println("이름\tJAVA\tDB\tJSP\tSpring\t총점\t평균\t등급");
		System.out.println(name+"\t"+java+"\t"+db+"\t"+jsp+"\t"+spring+"\t"+getTot()+"\t"
							+String.format("%.2f", getAvg())+"\t"+getGrade());
		
		
	}
	
	
}

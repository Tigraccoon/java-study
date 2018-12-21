package ch08;
	//singleton을 배운 김에 어거지로 끼워 넣어봤는데 출력 결과는 원하는데로 나오지만 좀 아닌듯..
public class Member2 {
	private String name;
	private int num;
	private int java;
	private int jsp;
	private int html;
	private int tot;
	private int avg;
	private String grade;
	
	private Member2() {
		System.out.println("기본 생성자 호출!");
		input("김철수",1234,90,80,70);
	}
	private Member2 (int i) {
		System.out.println("매개변수가 있는 생성자 호출!");
	}
	
	private static Member2 instance;
	
	public static Member2 getInstance() {
		if (instance == null) {
			instance = new Member2();
		} else if(instance != null){
			instance = new Member2(1);
		}
		return instance;
	}
	public void input(String name, int num, int java, int jsp, int html) {
		this.name = name;
		this.num = num;
		this.java = java;
		this.jsp = jsp;
		this.html = html;
	}
	
	public int getTot() {
		tot = java+jsp+html;
		return tot;
	}
	public int getAvg() {
		avg = tot/3;
		return avg;
	}
	public String getGrade() {
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
	}
	
	public void print() {
		System.out.println("이름\t학번\tJava\tJSP\tHTML\t총점\t평균\t등급");
		System.out.println(name+"\t"+num+"\t"+java+"\t"+jsp+"\t"+html+"\t"+getTot() +"\t"+getAvg()+"\t"+getGrade());
	}
	
}

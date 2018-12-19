package ch07;

public class StudentUse {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("김찰스");
		s1.setMajor("컴퓨터");
		s1.setGrade(3);
		s1.setSnum(1234);
		s1.setAvgn(4.4);
		s1.setPay(400);
		
		s1.print();
		
	}
	
}

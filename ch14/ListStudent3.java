package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListStudent3 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		Student s1 = new Student();
		s1.setNum("2019001");
		s1.setName("홍길동");
		s1.setMajor("Java");
		s1.setYear(1);
		s1.setProfessor("박교슈");
		
		list.add(s1);
		
		System.out.println("학번\t이름\t과목\t학년\t교수");
		for(Student s : list) {
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()+"\t"+s.getYear()+"\t"+s.getProfessor());
		}
		
		
		
	}
	
}

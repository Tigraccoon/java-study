package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListStudent2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("2019001","홍길동","Java",1,"박교수"));
		list.add(new Student("2016002","이순신","JSP",2,"최교수"));
		list.add(new Student("2017003","김유신","HTML",3,"김교수"));
		list.add(new Student("2018004","사임당","DB",4,"오교수"));
		
		System.out.println("학번\t이름\t과목\t학년\t교수");
		for(Student s : list) {
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()+"\t"+s.getYear()+"\t"+s.getProfessor());
		}
		
	}
	
}

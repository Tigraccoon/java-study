package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListStudent {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		//new를 할 때마다 실제로 새로운 주소를 가진 생성자에 값을 넣음
		list.add(new Student("2019001","김찰스","국사",1,"박교수"));
		list.add(new Student("2019002","박찰스","영문",1,"최교수"));
		list.add(new Student("2019003","정찰스","전산",1,"김교수"));
		
		System.out.println("학번\t이름\t과목\t학년\t교수");
		
		for(Student s : list) {	//향상된 for문(java 1.5 이후부터 사용)
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()+"\t"+s.getYear()+"\t"+s.getProfessor());
		}
		
//		for(int i=0;i<list.size();i++) {
//			Student s=list.get(i);
//			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()+"\t"+s.getYear()+"\t"+s.getProfessor());
//		}
		
		
	}

}

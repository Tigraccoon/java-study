package ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {
	static void print(@SuppressWarnings("rawtypes") Map map) {
		@SuppressWarnings("unchecked")
		ArrayList<Student> list2 = (ArrayList<Student>)map.get("list");
		for(Student s : list2) {
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()+"\t"+s.getYear()+"\t"+s.getProfessor());
		}
		
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		List<Student> list = new ArrayList<>();
		list.add(new Student("2019001","홍길동","국사",1,"박교수"));
		list.add(new Student("2019002","정길동","영어",2,"고교수"));
		list.add(new Student("2019003","김길동","사학",3,"진교수"));
		
		map.put("list", list);
		
		print(map);
		
	}
	
}

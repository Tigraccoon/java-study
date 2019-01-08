package ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList2 {
	public void print(@SuppressWarnings("rawtypes") Map map) {
		@SuppressWarnings("unchecked")
		ArrayList<Student> l1 = (ArrayList<Student>)map.get("masterkey");
		@SuppressWarnings("unchecked")
		ArrayList<Student> l2 = (ArrayList<Student>)map.get("subkey");
		
		System.out.println("<<그룹1>>");
		System.out.println("학번\t이름\t과목\t학년\t교수이름");
		for(Student s : l1) {
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()+"\t"+s.getYear()+"\t"+s.getProfessor());
		}
		System.out.println("\n<<그룹2>>");
		System.out.println("학번\t이름\t과목\t학년\t교수이름");
		for(Student s : l2) {
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()+"\t"+s.getYear()+"\t"+s.getProfessor());
		}
		
	}		
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("2017001","홍길동","국사",1,"박교수"));
		list.add(new Student("2015002","이순신","영문",3,"홍교수"));
		list.add(new Student("2019003","사임당","전산",2,"최교수"));
		list.add(new Student("2016004","임꺽정","수학",4,"김교수"));
		
		map.put("masterkey", list);
		
		List<Student> list2 = new ArrayList<>();
		
		list2.add(new Student("2017001","홍길동","국사",1,"박교수"));
		list2.add(new Student("2015002","이순신","영문",3,"홍교수"));
		list2.add(new Student("2019003","사임당","전산",2,"최교수"));
		list2.add(new Student("2016004","임꺽정","수학",4,"김교수"));
		
		map.put("subkey", list2);
		
		MapList2 m1 = new MapList2();
		m1.print(map);
		
		
		
	}
	
}

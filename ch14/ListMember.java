package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListMember {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<>();
		
		Member m1=new Member();
		
		m1.setName("김찰스");
		m1.setUserid("kim");
		m1.setPasswd("1234");
		m1.setTel("010-1234-5678");
		m1.setEmail("kim@chi.com");
		
		list.add(m1);	//Array List에 Member의 데이터를 추가

		Member m2=new Member();
		
		m2.setName("김찰스1");
		m2.setUserid("kim1");
		m2.setPasswd("12341");
		m2.setTel("010-1234-56781");
		m2.setEmail("kim@chi.com1");
		
		list.add(m2);
		
		System.out.println("이름\t아디\t비번\t전번\t\t이멜");
		for(int i=0;i<list.size();i++) {
			Member m=list.get(i);	//여기의 m은 ArrayList의 각 데이터를 가르키는 임시 참조변수로 활용
			
			System.out.println(m.getName()+"\t"+m.getUserid()+"\t"+m.getPasswd()+"\t"+m.getTel()+"\t"+m.getEmail());
		}
		
	}
	
}

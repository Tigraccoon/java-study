package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListMember2 {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<>();
		
//						(String userid, String passwd, String name, String tel, String email) {
		list.add(new Member("hong","1234","홍길동","02-123-1234","hong@hoho.com"));
		list.add(new Member("pack","1235","박길동","02-123-1235","pack@papa.com"));

		System.out.println("이름\t아디\t비번\t전번\t\t이멜");
		for(Member m : list) {
			System.out.println(m.getName()+"\t"+m.getUserid()+"\t"+m.getPasswd()+"\t"+m.getTel()+"\t"+m.getEmail());
		}
		
	}
	
}

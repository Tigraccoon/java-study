package ch14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExam {
	public static void main(String[] args) {
		Set<String> hs = new HashSet<>();
		
		hs.add("korea");
		hs.add("japan");
		hs.add("america");
		hs.add("britain");
		hs.add("korea");	//중복값은 입력되지 않음
		System.out.println(hs);	//순서가 없음
		
		for(String str : hs) {
			System.out.println(str);
		}
		
		//Iterator 반복 처리를 위한 클래스
		Iterator<String> it = hs.iterator();

		while(it.hasNext()) {	//다음 요소가 있으면 true, 없으면 false
			System.out.println(it.next());//다음 요소를 꺼냄
		}
		
	}
	
}

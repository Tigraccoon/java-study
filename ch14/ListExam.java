package ch14;

import java.util.ArrayList;
import java.util.List;

//ArrayList : Vector의 사용법과 비슷하지만 좀 더 가볍고 속도가 빠름. 동기화 보장이 안 됌(Vector는 동기화 보장)

public class ListExam {
	public static void main(String[] args) {
		
		List<Object> list = new ArrayList<>();	
		//<다형성> 실무에서는 큰 자료타입(interface)인 List를 좌변에 놓고 쓴다.
		//ArrayList에도 다양한 자료형을 저장 가능
		
		list.add("하나");
		list.add(2);
		list.add(3.3);
		list.add(true);
		list.add(5);
		list.add(3, 4);
		list.remove(1);
		
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		
		
	}
	
}

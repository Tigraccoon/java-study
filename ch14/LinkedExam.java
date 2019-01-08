package ch14;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedExam {
	public static void main(String[] args) {
		//큐 구조 : FIFO(First In First Out)
		//입력 : offer, 출력 : poll
		
		String[] fruits = {"사과","배","포도","딸기","수박"};
		
		LinkedList<String> list = new LinkedList<>();
		
		for(String str : fruits) {
			list.offer(str);
		}
		
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
//		String str = "";
//		while((str=(String)list.poll()) != null) {
//			System.out.println(str+" 삭제되었습니다.");
//		}
		
	}
	
}

package ch14;

import java.util.Stack;

public class StackExam {
	public static void main(String[] args) {
		//Stack 구조 : LIFO(Last In First Out)
		String[] nation = {"한국","일본","중국","미국","영국"};
		
		Stack<String> s = new Stack<>();
		for(String srt : nation) {
			s.push(srt);	//Stack에 입력
		}
		
//		System.out.println(s.pop());	//Stack에서 pop(출력)
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
		
		while(!s.isEmpty()) {	//Stack이 비어있지 않으면? true
			System.out.println(s.pop());
		}
	}
	
}

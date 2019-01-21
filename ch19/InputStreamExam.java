package ch19;

import java.io.IOException;

//스트림(Stream) : 데이터의 논리적인 통로
//1byte 단위로 처리
//InputStream
//OutputStream

public class InputStreamExam {
	public static void main(String[] args) {
		int var = 0;
		System.out.println("내용을 입력하세요 : ");
		
		try {	//네트워크나 입출력, DB는 필수적으로 예외처리
			var = System.in.read();	//키보드로부터 1byte씩 읽음 즉 한글은 안 됌.
			//한글을 사용하려면 InputStreamReader를 써야함
			while(var != 13) {	//13 : 엔터키 = 엔터키를 입력할 때까지 반복
				System.out.println(var + " ==> " + (char)var);
				//모든 문자는 고유한 숫자코드가 있다. int형 var를 문자형(char)로 형변환하여 출력
				var = System.in.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

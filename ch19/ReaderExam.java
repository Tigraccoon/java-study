package ch19;

import java.io.InputStreamReader;
import java.io.Reader;

//InputStream : 1바이트 단위로 읽음
//InputStreamReader : 문자 단위로 읽음

public class ReaderExam {
	public static void main(String[] args) {
		int var = 0;
		Reader input = new InputStreamReader(System.in);
		System.out.println("입력하세요 : ");
		try {
			while(true) {
				var = input.read();	//1문자 단위로 읽어들임
				//문자코드 13번 : 엔터
				if(var == 13) break;	//엔터키가 입력되면 종료
				System.out.println(var + " ==> " + (char)var);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

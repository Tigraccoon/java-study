package ch19;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileWrite {
	public static void main(String[] args) {
		//프로그램 -> 파일(출력 스트림이 필요)
		//OutputStream : 1byte 출력
		//OutputStreamWriter : 문자단위(char) 출력
		OutputStream os = null;
		
		try {
			os = new FileOutputStream("d:\\test3.txt");
			System.out.println("입력하셔요 : ");
			while(true) {
				int ch = System.in.read();	//1byte 읽음
				if(ch == 13) { //엔터키를 누르면? 종료
					break;
				}
				os.write(ch);
			}
			System.out.println("저장됐습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}

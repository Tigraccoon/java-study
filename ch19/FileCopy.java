package ch19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
	public static void main(String[] args) {
		String str = "";
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		//한글 윈도우의 기본 인코딩 방식 : ms949(ANSI, euc-kr)한글을 2byte씩 저장
		//유닉스, 리눅스의 기본 인코딩 방식 : UTF-8
		//이클립스 초기 설정을 UTF-8로 설정하였기 때문에 소스 작성 파일들이 UTF-8로 저장되며 한글을 3byte씩 저장
		//c 루트 디렉토리는 사용하면 안 됌. 관리자 보호가 돼있어서 에러가 발생함.
		
		String file1 = "d:\\test\\a.txt";	//원본 파일
		String file2 = "d:\\test\\b.txt";
		
		try {
			reader = new BufferedReader(new FileReader(new File(file1)));
			writer = new BufferedWriter(new FileWriter(new File(file2)));
			
			while(true) {
				str = reader.readLine();	//한 라인씩 읽음
				if(str == null) break;		//내용이 없으면 종료
				//파일에 기록할 때는 "\r\n"을 써줘야 줄바꿈 처리가 됌
				// \r은 carriage return(왼쪽으로 당기기)
				// \n은 new line(줄바꿈)
				writer.write(str+"\r\n");
				
			}
			
			System.out.println("파일 복사 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) reader.close();
				//리소스를 개별적으로 닫아주는게 좋다.
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(writer != null) writer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
}

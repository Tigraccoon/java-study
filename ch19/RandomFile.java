package ch19;

import java.io.RandomAccessFile;

public class RandomFile {
	public static void main(String[] args) {
		//String : 불변성, 값이 변할 일이 없을 때 String을 사용
		//StringBuilder, StringBuffer : 가변성, 값이 변할 때 StringBuffer보단 StringBuilder를 사용
		
		StringBuilder output = new StringBuilder();
		String str = null;
		try {
			//r : 읽기 , w : 쓰기
			RandomAccessFile file = new RandomAccessFile("D:\\test.txt", "rw");
			file.seek(0);	//89번째 index부터 처리
			file.write("추가한 내용".getBytes());	//기존 내용을 덮어씀
			file.seek(0);
			
			while(file.getFilePointer() < file.length()) {
				output.append(file.getFilePointer()+" : ");
				str = file.readLine();
				//한글 처리
				//String.getBytes() 스트링을 바이트 배열로 변환
				//new String(문자열, 캐릭터셋) 인코딩 방식 변환
				//iso-8859-1, 8859_1 서유럽 언어 인코딩 방식
				//ms949 2byte, UTF-8 3byte : 초성, 중성, 종성 1byte씩
				
				str = new String(str.getBytes("8859_1"),"utf-8");
				output.append(str + "\r\n");
				
			}
			
			file.close();
			System.out.println(output);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

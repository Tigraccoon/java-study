package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStream {
	public static void main(String[] args) {
		//텍스트 파일이 아닌 binary file로 저장
		
		try {
			DataOutputStream dataout = new DataOutputStream(new FileOutputStream("d:\\test.dat"));
			dataout.writeInt(123);		//숫자형 자료를 파일에 저장
			dataout.writeChar('A');		//문자형 자료를 파일에 저장
			dataout.writeDouble(3.14);	//실수형 자료를 파일에 저장
			dataout.close();	//스트림 닫기
			System.out.println("저장됐음.");
			
			//이진 파일을 읽기 위한 객체 생성
			DataInputStream datain = new DataInputStream(new FileInputStream("d:\\test.dat"));
			//이진 파일로 저장된것을 콘솔화면에서 출력되도록 함.
			System.out.println(datain.readInt());
			System.out.println(datain.readChar());
			System.out.println(datain.readDouble());
			datain.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

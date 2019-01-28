package ch21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.Properties;

//중요 정보를 소스에 직접 쓰게 되면 위험하기 때문에 별도의 Property 파일로 저장할 필요가 있다.

public class Property {
	public static void main(String[] args) {
//		Connection conn = null;
//		PreparedStatement ppsm = null;
//		ResultSet rs = null;
		
		try {
			//파일의 내용을 읽기 위한 객체
			FileInputStream fis = new FileInputStream("D:\\SQL\\MySQL\\db.prop");
			//key, value구조(HashMap구조)로 저장된 파일을 읽거나 쓰기 위한 객체
			Properties prop = new Properties();
			//파일 내용을 읽어서 prop에 로딩
			prop.load(fis);
			System.out.println(prop);
			
			//값을 불러올 때 : 프로퍼티 객체.getProperty(변수명)
			String pwd = prop.getProperty("pwd");
			System.out.println(pwd);
			
			//값을 기록할 때 : 프로퍼티 객체.setProperty("key", "value")
			prop.setProperty("password", "java1235");
			FileOutputStream fos = new FileOutputStream("D:\\SQL\\MySQL\\db.prop");
			//파일에 저장 : prop.store(출력스트림, 주석)
			prop.store(fos, "test");
			//HashMap을 쓰기 때문에 저장시 순서가 바뀔 수 있다.
			System.out.println("저장됐다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

package ch21;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
	//static : 인스턴스를 만들지 않고 호출 가능, 자주 쓰는 메쏘드는 static으로 만들어 처리하면 편리함
	
	//MySQL 접속
	public static Connection dbConn() {
		Connection conn = null;
		
		try {
			FileInputStream fis = new FileInputStream("d:\\SQL\\MySQL\\db.prop");
			//key와 value를 셋트로 저장
			Properties prop = new Properties();
			prop.load(fis);
			
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String pwd = prop.getProperty("pwd");
			
			//MySQL 접속
			conn = DriverManager.getConnection(url, id, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return conn;
	
	}
	
}

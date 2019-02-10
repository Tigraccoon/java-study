package project2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SqlDB {
	public static Connection SqlConn() {
		Connection conn = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\SQL\\MySQL\\project2\\DBin.prop");
			Properties prop = new Properties();
			prop.load(fis);
			
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String pwd = prop.getProperty("pwd");
			
			conn = DriverManager.getConnection(url, id, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}

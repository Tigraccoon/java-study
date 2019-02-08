package ch21.oracle;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class MemberInsert {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("d:\\SQL\\Oracle\\oracle.prop");
		Properties prop = new Properties();
		prop.load(fis);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String id = prop.getProperty("id");
		String password = prop.getProperty("password");
		
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			Class.forName(driver);	//생략가능
			//오라클 서버 접속
			conn = DriverManager.getConnection(url, id, password);
			Scanner scan = new Scanner(System.in);
			System.out.print("아이디 : ");
			String userid = scan.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = scan.nextLine();
			System.out.print("이름 : ");
			String name = scan.nextLine();
			
			String sql = "insert into member (userid,pwd,name) values (?,?,?)";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, userid);
			ppsm.setString(2, pwd);
			ppsm.setString(3, name);
			ppsm.executeQuery();
			System.out.println("저장되었습니다?");
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppsm != null) ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}

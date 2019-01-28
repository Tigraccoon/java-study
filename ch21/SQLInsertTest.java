package ch21;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class SQLInsertTest {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("D:\\SQL\\MySQL\\db.prop");
		//Map구조처럼 key와 Value를 세트로 관리하는 객체
		Properties prop = new Properties();
		//db.prop파일을 읽어서 key, value구조로 변환
		prop.load(fis);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String id = prop.getProperty("id");
		String pwd = prop.getProperty("pwd");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(id);
		System.out.println(pwd);
		
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {	//driver 호출을 jdk1.6부턴 생략 가능하지만 하는게 좋음
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			String title = "명품 java";
			String publisher = "영진출판사";
			String year = "2018"; 
			int price = 30000;
			
			String sql = "INSERT INTO books (title,publisher,year,price) values (?,?,?,?)";
			ppsm = conn.prepareStatement(sql);	//sql 실행 준비
			ppsm.setString(1, title);
			ppsm.setString(2, publisher);
			ppsm.setString(3, year);
			ppsm.setInt(4, price);
			ppsm.executeUpdate();	//sql 실행
			//executeUpdate : 데이터의 업데이트 또는 삭제
			//executeQuery : 데이터 확인
			
			System.out.println("데이터가 추가됐습니다.");
			
			String sql1 = "SELECT * FROM books";
			rs = ppsm.executeQuery(sql1);
			while(rs.next()) {
				title = rs.getString("title");
				publisher = rs.getString("publisher");
				year = rs.getString("year");
				price = rs.getInt("price");
				
				System.out.println(title+"\t"+year+"\t"+price+"\t"+price);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(ppsm != null) ppsm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
	}
	
}

package ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDatabase {
	public static void main(String[] args) {
		//DB연결 문자열"jdbc:mysql://host/db"
		String url = "jdbc:mysql://localhost/java?serverTimezone=UTC";
		String id="java"; 			//MySQL 접속 아이디
		String password="java1235"; //MySQL 접속 비밀번호
		Connection conn=null; 		//DB접속처리
		Statement stmt=null; 		//SQL명령어 실행
		ResultSet rs=null; 			//SELECT 명령어의 결과셋을 조회(레코드 탐색)
		
		try {
			//jdbc driver를 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버를 로딩했습니다!");
			
			//1) MySQL접속(Connection)
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("MySQL에 접속 성공!");
			
			//2) SQL문 실행(Statement)
			String sql = "select * from books";//sql문 작성
			stmt = conn.createStatement();//sql문 실행 객체
			
			//3) 결과셋 실행(ResultSet)
			rs = stmt.executeQuery(sql);
			
			//select query를 실행한 결과가 결과셋에 전달됨
			while(rs.next()) {//다음 레코드가 존재하면
				//결과셋.get자료형("필드명")
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String publisher = rs.getString("publisher");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				
				System.out.println(book_id+"\t"+title+"\t"+publisher+"\t"+year+"\t"+price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//DB연동 관련 리소스 정리
			//open (Connection => Statement => ResultSet)
			//close (ResultSet => Statement => Connection)
			//즉, 닫을 땐 오픈한 역순으로 닫음.
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(stmt != null) stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

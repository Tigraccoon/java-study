package ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDatabase2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/java?serverTimezone=UTC";
		String id = "java";
		String pwd = "java1235";

		Connection co = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");

			co = DriverManager.getConnection(url, id, pwd);
			System.out.println("데이터베이스 접속!");

			st = co.createStatement();

			String sql = "SELECT * FROM bookExam";
			rs = st.executeQuery(sql);

			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String bookdate = rs.getString("bookdate");
				int price = rs.getInt("price");
				
				System.out.println(title+"\t"+author+"\t"+bookdate+"\t"+price);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(co != null) co.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null) st.close();
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

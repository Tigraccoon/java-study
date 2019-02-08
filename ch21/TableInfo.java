package ch21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TableInfo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		//테이블에 대한 부가적인 정보 설명 데이터
		ResultSetMetaData meta = null;
		
		try {
			conn = DB.dbConn();
			String sql = "SELECT * FROM score";
			ppsm = conn.prepareStatement(sql);
			rs = ppsm.executeQuery();
			
			//ResultSet으로부터 메타데이터(테이블의 정보)를 가져옴
			meta = rs.getMetaData();
			int cols = meta.getColumnCount();	//컬럼의 갯수
			System.out.println("필드명\t\t자료형\tNULL여부");
			for(int i=1;i<=cols;i++) {	//DB는 필드 인덱스가 1부터 시작이라서 i = 1
				String colName = meta.getColumnName(i);	//i번째 컬럼 이름
				String colType = meta.getColumnTypeName(i);	//i번째 컬럼 타입
				int isnull = meta.isNullable(i);		//i번째 NULL 여부(0 = NOT NULL, 1 = NULL)
				System.out.println(colName+"\t\t"+colType+"\t"+isnull);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

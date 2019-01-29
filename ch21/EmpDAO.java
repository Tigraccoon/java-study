package ch21;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Data Access Object
public class EmpDAO {
	public List<EmpDTO> listEmp(){
		List<EmpDTO> items = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();	//MySQL에 접속, DB.java내의 static으로 처리된 메소드 접근은 new가 필요 없으므로 편~리
			String sql = "SELECT * FROM emp";
			ppsm = conn.prepareStatement(sql);	//쿼리 실행 준비
			rs = ppsm.executeQuery();	//쿼리 실행 -> 결과셋에 저장
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
				int sel = rs.getInt("sel");
				//ArrayList에 DTO를 추가, 값 전달
				items.add(new EmpDTO(empno, ename, hiredate, sel));
				
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
		
		return items;	//리스트 리턴

	}//listEmp

	public void insertEmp(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO emp (empno,ename,hiredate,sel) VALUES (?,?,?,?)";
			ppsm = conn.prepareStatement(sql);
			ppsm.setInt(1, dto.getEmpno());
			ppsm.setString(2, dto.getEname());
			ppsm.setDate(3, dto.getHiredate());
			ppsm.setInt(4, dto.getSel());
			ppsm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ppsm != null) ppsm.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	public int deleteEmp(int empno) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			conn = DB.dbConn();
			String sql = "DELETE FROM emp WHERE empno = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setInt(1, empno);
			result = ppsm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ppsm != null) ppsm.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	
	
	
}

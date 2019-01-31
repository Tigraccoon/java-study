package ch21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

//Data Access Object
public class EmpDAO {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector listEmp() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();	//MySQL에 접속, DB.java내의 static으로 처리된 메소드 접근은 new가 필요 없으므로 편~리
			String sql = "SELECT * FROM emp ORDER BY ename";
			ppsm = conn.prepareStatement(sql);	//쿼리 실행 준비
			rs = ppsm.executeQuery();	//쿼리 실행 -> 결과셋에 저장
			
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("empno"));
				row.add(rs.getString("ename"));
				row.add(rs.getDate("hiredate"));
				row.add(rs.getInt("sel"));

				items.add(row);
				
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

	public int insertEmp(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		int result=0;
		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO emp (empno,ename,hiredate,sel) VALUES (?,?,?,?)";
			ppsm = conn.prepareStatement(sql);
			ppsm.setInt(1, dto.getEmpno());
			ppsm.setString(2, dto.getEname());
			ppsm.setDate(3, dto.getHiredate());
			ppsm.setInt(4, dto.getSel());
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
	
	
	public int updateEmp(EmpDTO dto) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			conn = DB.dbConn();
			String sql = "UPDATE emp SET ename=?,hiredate=?,sel=? WHERE empno = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, dto.getEname());
			ppsm.setDate(2, dto.getHiredate());
			ppsm.setInt(3, dto.getSel());
			ppsm.setInt(4, dto.getEmpno());
			
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector searchEmp(String ename) {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			
			conn = DB.dbConn();
			String sql = "SELECT * FROM emp WHERE ename like ? ORDER BY ename";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, "%"+ename+"%");
			rs = ppsm.executeQuery();
			
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("empno"));
				row.add(rs.getString("ename"));
				row.add(rs.getDate("hiredate"));
				row.add(rs.getInt("sel"));
				
				items.add(row);
				
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
		
		
		
		
		return items;
		
	}
	
	
}

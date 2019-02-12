package ch21.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch21.DB;

public class DeptDAO {
	public ArrayList<DeptDTO> listDept(){
		ArrayList<DeptDTO> items = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.hrConn();
			String sql = "select * from dept order by dname asc";
			ppsm = conn.prepareStatement(sql);
			rs = ppsm.executeQuery();
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				items.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (ppsm != null) ppsm.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
		return items;
	}
	
}

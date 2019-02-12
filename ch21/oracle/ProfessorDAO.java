package ch21.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch21.DB;

public class ProfessorDAO {
	public ArrayList<ProfessorDTO> listProfessor() {
		ArrayList<ProfessorDTO> items = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.hrConn();
			String sql = "select * from dept order by name asc";
			ppsm = conn.prepareStatement(sql);
			rs = ppsm.executeQuery();
			
			while(rs.next()) {
				int profno = rs.getInt("profno");
				String name = rs.getString("name");
				ProfessorDTO dto = new ProfessorDTO(profno, name);
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

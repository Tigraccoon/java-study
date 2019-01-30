package ch21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HealthDAO {
	public HealthDTO search(String id) {
		HealthDTO dto = null;
		
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "SELECT id,NAME,age,height,weight,(weight/((height/100)*(height/100))) bmi FROM health WHERE id = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, id);
			rs = ppsm.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
				double weight = rs.getDouble("weight");
				double bmi = rs.getDouble("bmi");
				dto = new HealthDTO(id, name, age, height, weight, bmi);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ppsm!=null) ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
	
}

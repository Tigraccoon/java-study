package ch21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
	public List<AddressDTO> list (){
		
		List<AddressDTO> items = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			String sql = "SELECT * FROM address";
			ppsm = conn.prepareStatement(sql);
			rs = ppsm.executeQuery();
			
			while (rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String hp = rs.getString("hp");
				
				items.add(new AddressDTO(email, name, addr, hp));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return items;
	}//list
	
	
	public void insert(AddressDTO dto) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO address VALUES (?,?,?,?)";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, dto.getEmail());
			ppsm.setString(2, dto.getName());
			ppsm.setString(3, dto.getAddr());
			ppsm.setString(4, dto.getHp());
			ppsm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		
	}//insert
	
	
	public int delete(String name) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		int result = 0;
		
		try {
			conn = DB.dbConn();
			String sql = "DELETE FROM address WHERE NAME = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, name);
			result = ppsm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		
		
		return result;
	}
	
	
}

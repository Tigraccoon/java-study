package ch21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
	public List<AccountDTO> list(){
		List<AccountDTO> items = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			
			String sql = "SELECT * FROM account";
			ppsm = conn.prepareStatement(sql);
			rs = ppsm.executeQuery();
			
			while(rs.next()) {
				String bank = rs.getString("bank");
				String num = rs.getString("num");
				String name = rs.getString("name");
				int money = rs.getInt("money");
				
				items.add(new AccountDTO(bank, num, name, money));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ppsm != null) ppsm.close();
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
	}//list
	
	
	
	public void insert(AccountDTO dto) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			
			conn = DB.dbConn();
			String sql = "INSERT INTO account VALUES (?,?,?,?)";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, dto.getBank());
			ppsm.setString(2, dto.getNum());
			ppsm.setString(3, dto.getName());
			ppsm.setInt(4, dto.getMoney());
			ppsm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ppsm != null) ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}//insert
	
	
	public int delete(String name) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		int result=0;

		try {
			conn = DB.dbConn();
			String sql = "DELETE FROM account WHERE name = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, name);
			result = ppsm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ppsm != null) ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}//delete
	
}

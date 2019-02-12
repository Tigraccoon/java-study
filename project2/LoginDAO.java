package project2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class LoginDAO {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector userList() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;

		try {
			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id,pwd,NAME,hp,address,email,amount,POINT,DATE FROM member ORDER BY id");
			ppsm = conn.prepareStatement(sb.toString());
			rs = ppsm.executeQuery();

			while(rs.next()) {
				Vector row = new Vector();
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String address = rs.getString("address");
				String email = rs.getString("email"); 
				int amount = rs.getInt("amount");
				int point = rs.getInt("point");
				Date date = rs.getDate("date");

				row.add(id);
				row.add(pwd);
				row.add(name);
				row.add(hp);
				row.add(address);
				row.add(email);
				row.add(amount);
				row.add(point);
				row.add(date);

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

	public int insertUser(LoginDTO dto) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;

		try {

			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO member (id,pwd,NAME,hp,address,email,DATE) VALUES (?,?,?,?,?,?,NOW())");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, dto.getId());
			ppsm.setString(2, dto.getPwd());
			ppsm.setString(3, dto.getName());
			ppsm.setString(4, dto.getHp());
			ppsm.setString(5, dto.getAddress());
			ppsm.setString(6, dto.getEmail());
			//			ppsm.setInt(7, dto.getAmount());
			//			ppsm.setInt(8, dto.getPoint());

			result = ppsm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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


		return result;
	}


	public int updateUser(LoginDTO dto) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;

		try {

			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			//SELECT id,pwd,NAME,hp,address,email,amount,POINT,DATE FROM member ORDER BY id;
			sb.append("UPDATE member SET pwd=?,NAME=?,hp=?,address=?,email=?,amount=?,point=? WHERE id=?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, dto.getPwd());
			ppsm.setString(2, dto.getName());
			ppsm.setString(3, dto.getHp());
			ppsm.setString(4, dto.getAddress());
			ppsm.setString(5, dto.getEmail());
			ppsm.setInt(6, dto.getAmount());
			ppsm.setInt(7, dto.getPoint());
			ppsm.setString(8, dto.getId());

			result = ppsm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		return result;
	}

	public LoginDTO viewUser(String id) {
		LoginDTO dto = null;
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;

		try {
			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id,pwd,NAME,hp,address,email,amount,POINT,DATE FROM member WHERE id = ?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, id);
			rs = ppsm.executeQuery();

			if(rs.next()) {
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String address = rs.getString("address");
				String email = rs.getString("email");
				int amount = rs.getInt("amount");
				int point = rs.getInt("point");
				Date date = rs.getDate("date");

				dto = new LoginDTO(id, pwd, name, hp, address, email, amount, point, date);
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

		return dto;
	}
	
	

	public int deleteUser(String id) {
		int result=0;

		Connection conn = null;
		PreparedStatement ppsm = null;

		try {

			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM member WHERE id=?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, id);

			result = ppsm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		return result;
	}
	
	private String id;		
	private String pwd;
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}

	public int findUser(String email) {
		int result = 0;
		LoginDTO dto = null;
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		try {
			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id,pwd FROM member WHERE email = ?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, email);
			rs = ppsm.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
				pwd = rs.getString("pwd");
				dto = new LoginDTO(id, pwd);
				System.out.println("2\t"+dto.toString());
				result = 1;
			} else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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

		return result;
	}

}

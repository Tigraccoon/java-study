package project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProductDAO {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector productList() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;

		try {
			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
//			"ProductDTO [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", pamount=" + pamount + "]";
			sb.append("SELECT pcode,pname,price,pamount FROM product ORDER BY pcode");
			ppsm = conn.prepareStatement(sb.toString());
			rs = ppsm.executeQuery();

			while(rs.next()) {
				Vector row = new Vector();
				int pcode = rs.getInt("pcode");
				String pname = rs.getString("pname");
				int price = rs.getInt("price");
				int pamount = rs.getInt("pamount");

				row.add(pcode);
				row.add(pname);
				row.add(price);
				row.add(pamount);

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

	public int insertProduct(ProductDTO dto) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;

		try {
//			SELECT pcode,pname,price,pamount FROM product ORDER BY pcode
			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO product (pname,price,pamount) VALUES (?,?,?)");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, dto.getPname());
			ppsm.setInt(2, dto.getPrice());
			ppsm.setInt(3, dto.getPamount());

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


	public int updateProduct(ProductDTO dto) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;

		try {

			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			//pname,price,pamount
			sb.append("UPDATE product SET pname=?,price=?,pamount=? WHERE pcode=?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, dto.getPname());
			ppsm.setInt(2, dto.getPrice());
			ppsm.setInt(3, dto.getPamount());

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

	public ProductDTO viewProduct(int pcode) {
		ProductDTO dto = null;
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;

		try {
			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
//			pname,price,pamount
			sb.append("SELECT pname,price,pamount FROM product WHERE pcode = ?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setInt(1, pcode);
			rs = ppsm.executeQuery();

			if(rs.next()) {
				String pname = rs.getString("pname");
				int price = rs.getInt("price");
				int pamount = rs.getInt("pamount");

				dto = new ProductDTO(pcode, pname, price, pamount);
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
	
	

	public int deleteProduct(int pcode) {
		int result=0;

		Connection conn = null;
		PreparedStatement ppsm = null;

		try {

			conn = SqlDB.SqlConn();
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM product WHERE pcode=?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setInt(1, pcode);

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

}

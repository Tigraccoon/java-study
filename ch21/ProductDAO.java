package ch21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProductDAO {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector listProduct() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			String sql = "SELECT * FROM product";
			ppsm = conn.prepareStatement(sql);
			rs = ppsm.executeQuery();
			
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("product_no"));
				row.add(rs.getString("plocal"));
				row.add(rs.getString("pname"));
				row.add(rs.getString("company"));
				row.add(rs.getInt("uprice"));
				row.add(rs.getInt("acc"));
				row.add(rs.getInt("sprice"));
				
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
	}//list
	
	public int insertProduct(ProductDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO product VALUES (?,?,?,?,?,?,(uprice*acc))";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, dto.getProduct_no());
			ppsm.setString(2, dto.getPlocal());
			ppsm.setString(3, dto.getPname());
			ppsm.setString(4, dto.getCompany());
			ppsm.setInt(5, dto.getUprice());
			ppsm.setInt(6, dto.getAcc());
			
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
	}//insert
	
	
	public int updateProduct(ProductDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			conn = DB.dbConn();
			String sql = "UPDATE product SET plocal=?,pname=?,company=?,uprice=?,acc=?, sprice=(uprice*acc) WHERE product_no = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, dto.getPlocal());
			ppsm.setString(2, dto.getPname());
			ppsm.setString(3, dto.getCompany());
			ppsm.setInt(4, dto.getUprice());
			ppsm.setInt(5, dto.getAcc());
			ppsm.setString(6, dto.getProduct_no());
			
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
	}//update
	
	
	public int deleteProduct (String product_no) {
		int result =0;
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			conn = DB.dbConn();
			String sql = "DELETE FROM product WHERE product_no = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, product_no);
			
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
	}//delete
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector searchProduct(String pname) {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			String sql = "SELECT * FROM product WHERE pname LIKE ? ORDER BY pname";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, "%"+pname+"%");
			rs = ppsm.executeQuery();
			
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("product_no"));
				row.add(rs.getString("plocal"));
				row.add(rs.getString("pname"));
				row.add(rs.getString("company"));
				row.add(rs.getInt("uprice"));
				row.add(rs.getInt("acc"));
				row.add(rs.getInt("sprice"));
				
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
	}//search
	
}

package ch21.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ch21.DB;

public class ScoreDAO {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector listScore() {
		//ArrayList는 JTable과 잘 호환이 안 되므로 Vector를 사용
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.oraConn();
			//String보단 StringBuilder가 효율적
			StringBuilder sb = new StringBuilder();
			sb.append("select student_no,name,kor,eng,mat,(kor+eng+mat) as tot, round((kor+eng+mat)/3.0,2) as avg from score ");
			sb.append(" order by name");
			ppsm = conn.prepareStatement(sb.toString());
			rs = ppsm.executeQuery();
			
			while(rs.next()) {
				Vector row = new Vector();
				String student_no = rs.getString("student_no");
				//컬럼 이름 대신 인덱스를 넣어도 되나 가독성이 떨어짐
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				//DB에는 없고 쿼리문에 있는 데이터 타입이라도 가져올 수 있음
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");
				
				row.add(student_no);
				row.add(name);
				row.add(kor);
				row.add(eng);
				row.add(mat);
				row.add(tot);
				row.add(avg);
				
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
	
	public int insertScore(ScoreDTO dto) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into score (student_no,name,kor,eng,mat) values (?,?,?,?,?)");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, dto.getStudent_no());
			ppsm.setString(2, dto.getName());
			ppsm.setInt(3, dto.getKor());
			ppsm.setInt(4, dto.getEng());
			ppsm.setInt(5, dto.getMat());
			
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
	
	//레코드를 전달하는 방법
	//1. primary key만 전달 - 가장 적절한 방법
	//2. 선택한 행을 dto로 전달 - 여러 사용자가 사용중에 변경이 있을 경우 반영이 안 될 수 있음.
	//3. static 변수에 저장 - 코드 양이 줄지만 객체지향 방식에선 가능한 static은 별로 안 쓰는게 좋음? 또한 무거운 데이터가 들어가면 메모리 낭비가 심함
	
	public int updateScore(ScoreDTO dto) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("update score set name=?,kor=?,eng=?,mat=? where student_no=?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, dto.getName());
			ppsm.setInt(2, dto.getKor());
			ppsm.setInt(3, dto.getEng());
			ppsm.setInt(4, dto.getMat());
			ppsm.setString(5, dto.getStudent_no());
			
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

	public ScoreDTO viewScore(String student_no) {
		ScoreDTO dto = null;
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("select student_no,name,kor,eng,mat,(kor+eng+mat) as tot, round((kor+eng+mat)/3.0,2) as avg from score ");
			sb.append(" where student_no=?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, student_no);
			rs = ppsm.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				dto = new ScoreDTO(student_no, name, kor, eng, mat);
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
	
	public int deleteScore(String student_no) {
		int result=0;
		
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("delete from score where student_no=?");
			ppsm = conn.prepareStatement(sb.toString());
			ppsm.setString(1, student_no);
			
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

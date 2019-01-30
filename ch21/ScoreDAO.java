package ch21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ScoreDAO {
	//학생 점수를 테이블에 저장
	public int insertScore(ScoreDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ppsm = null;

		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO score VALUES (?,?,?,?,?,?,?)";
			ppsm = conn.prepareStatement(sql);
			//?에 입력될 값 설정
			ppsm.setString(1, dto.getStudent_no());
			ppsm.setString(2, dto.getName());
			ppsm.setInt(3, dto.getKor());
			ppsm.setInt(4, dto.getEng());
			ppsm.setInt(5, dto.getMat());
			ppsm.setInt(6, dto.getTot());
			ppsm.setDouble(7, dto.getAvg());
			//insert query 실행 후 성공한 레코드 갯수를 result에 저장
			result = ppsm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ppsm!=null)ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}//insertScore

	public int deleteScore(String student_no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ppsm = null;

		try {
			conn = DB.dbConn();
			String sql = "DELETE FROM score WHERE student_no = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, student_no);
			result = ppsm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ppsm!=null)ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}//deleteScore


	public int updateScore(ScoreDTO dto) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;

		try {
			conn = DB.dbConn();
			String sql = "UPDATE score SET name=?,kor=?,eng=?,mat=?,tot=?,avg=? WHERE student_no=?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, dto.getName());
			ppsm.setInt(2, dto.getKor());
			ppsm.setInt(3, dto.getEng());
			ppsm.setInt(4, dto.getMat());
			ppsm.setInt(5, dto.getTot());
			ppsm.setDouble(6, dto.getAvg());
			ppsm.setString(7, dto.getStudent_no());
			result = ppsm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ppsm!=null)ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector searchScore(String name) {
		Vector items = new Vector();	//ArrayList를 쓰면 에러 발생 가능성이 있음
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;

		try {
			conn = DB.dbConn();
			String sql = "SELECT student_no,NAME,kor,eng,mat,(kor+eng+mat) AS tot,ROUND(((kor+eng+mat)/3.0),1)AS AVG FROM "
					+ " score WHERE name like ? ORDER BY name";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, "%"+name+"%");
			rs = ppsm.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("student_no"));
				row.add(rs.getString("name"));
				row.add(rs.getInt("kor"));
				row.add(rs.getInt("eng"));
				row.add(rs.getInt("mat"));
				row.add(rs.getInt("tot"));
				row.add(rs.getDouble("avg"));
				//레코드 1개를 벡터에 추가 (벡터 items에 벡터 row를 저장)
				items.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ppsm!=null)ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return items;
	}

	//JTable에 전달할 벡터 데이터 리턴

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector listScore() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;

		try {
			conn = DB.dbConn();
			String sql = "SELECT student_no,NAME,kor,eng,mat,(kor+eng+mat) AS tot,ROUND(((kor+eng+mat)/3.0),1)AS AVG FROM "
					+ " score ORDER BY name";
			ppsm = conn.prepareStatement(sql);
			rs = ppsm.executeQuery();
			
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("student_no"));
				row.add(rs.getString("name"));
				row.add(rs.getInt("kor"));
				row.add(rs.getInt("eng"));
				row.add(rs.getInt("mat"));
				row.add(rs.getInt("tot"));
				row.add(rs.getDouble("avg"));
				//레코드 1개를 벡터에 추가 (벡터 items에 벡터 row를 저장)
				items.add(row);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ppsm!=null)ppsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return items;

	}


}

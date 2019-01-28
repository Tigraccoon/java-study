package ch21;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//DAO = Data Access Object : 데이터 처리를 담당하는 객체
//핵심적인 비즈니스 로직 처리, 주로 DB연동 관련 작업 Back-End, Front-End

public class CarDAO {
	//DB 접속
	public Connection dbConn() {
		Connection conn = null;
		try {
			FileInputStream fio = new FileInputStream("D:\\SQL\\MySQL\\db.prop");
			Properties prop = new Properties();
			prop.load(fio);
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String pwd = prop.getProperty("pwd");
			conn = DriverManager.getConnection(url, id, pwd);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}//dbCone
	
	//car테이블의 레코드들을 ArrayList로 리턴하는 코드
	public List<CarDTO> listCar() {
		List<CarDTO> items = new ArrayList<>();	//좌:부 / 우:자
		Connection conn = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			//DB접속
			conn = dbConn();
			//SQL 실행
			String sql = "SELECT * FROM car";
			//각각의 레코드를 DTO에 저장
			ppsm = conn.prepareStatement(sql);
			rs = ppsm.executeQuery();	//SELECT문 처리
			while(rs.next()) {
				String license_number = rs.getString("license_number");
				String company = rs.getString("company");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				int efficiency = rs.getInt("efficiency");
				
				CarDTO dto = new CarDTO(license_number, company, type, year, efficiency);
				items.add(dto);	//ArrayList에 DTO를 추가
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppsm != null) ppsm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return items;
		
	}
	
	public void insertCar(CarDTO dto) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		
		try {
			conn = dbConn();
			String sql = "INSERT INTO car (license_number,company,TYPE,YEAR,efficiency) VALUES (?,?,?,?,?)";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, dto.getLicense_number());
			ppsm.setString(2, dto.getCompany());
			ppsm.setString(3, dto.getType());
			ppsm.setInt(4, dto.getYear());
			ppsm.setInt(5, dto.getEfficiency());
			//sql 실행 (INSERT, UPDATE 명령어는 executeUpdate()명렁어
			ppsm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppsm != null) ppsm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
	
	public int deleteCar(String license_number) {
		int result=0;
		Connection conn = null;
		PreparedStatement ppsm = null;
		try {
			conn = dbConn();
			
			String sql = "DELETE FROM car WHERE license_number = ?";
			ppsm = conn.prepareStatement(sql);
			ppsm.setString(1, license_number);
			result = ppsm.executeUpdate();	//result 값은 정상 삭제가 됐다면 1, 삭제가 안 됐다면 0이 return
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppsm != null) ppsm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	
	
}

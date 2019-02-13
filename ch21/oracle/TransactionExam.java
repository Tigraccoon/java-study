package ch21.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ch21.DB;

//Transaction : 거래 처리 단위
//insert, delete, update : 레코드를 변경하는 작업
//commit, rollback
//만약 A, B, C -> 성공
//A, B -> 성공, C -> 실패시 소스에서도 트랜젝션 처리를 해야함.

public class TransactionExam {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ppsm = null;
		boolean success = false;

		try {
			conn = DB.hrConn();
			conn.setAutoCommit(false);	//auto commit 해제
			StringBuilder sb = new StringBuilder();
			sb.append("insert into emp_copy (empno,ename,sal) ");
			sb.append(" values (?,?,?) ");
			ppsm = conn.prepareStatement(sb.toString());
			long start = System.currentTimeMillis();	//현재 시각
			for(int i=1;i<=100000;i++) {
				ppsm.setInt(1, i);
				ppsm.setString(2, "kim");
				ppsm.setInt(3, 4500);
				System.out.println(i);
				//				ppsm.executeUpdate();	//DB서버에 부하가 걸릴 위험이 있으므로?
				ppsm.addBatch();		//일괄처리 작업 추가
			}
			ppsm.executeBatch();		//일괄처리 작업 실행
			success = true;
			long end = System.currentTimeMillis();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (success) {
					System.out.println("커밋되었습니다!");
					conn.commit();
				} else {
					System.out.println("롤백되었습니다!");
					conn.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if(ppsm!=null)
					ppsm.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}

	}

}

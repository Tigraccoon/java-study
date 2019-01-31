package ch21;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpManage {
	EmpDAO dao = new EmpDAO();	//EmpManage가 메모리에 올라가는 시점에 자동으로 EmpDAO도 new를 실행하면서 동시에 메모리에 올라간다.
	
	void delete() {
		@SuppressWarnings("resource")
		Scanner scan1 = new Scanner(System.in);
		
		System.out.print("삭제할 사번을 입력하셔유~ : ");
		int empno = scan1.nextInt();
		int result = dao.deleteEmp(empno);
		if (result == 1) {
			System.out.println("삭재됐어유~");
		} else {
			System.out.println("사번을 확인하셔유~");
			delete();
		}
		
	}
	
	
	
	void insert() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("사번 : ");
		int empno = scan.nextInt();
		System.out.print("이름 : ");
		String ename = scan.next();
		System.out.print("입사일 : ");
		String hiredate = scan.next();
		System.out.print("급여 : ");
		int sel = scan.nextInt();
		
		EmpDTO dto = new EmpDTO(empno, ename, Date.valueOf(hiredate), sel);
		dao.insertEmp(dto);
		System.out.println("저장됐어유~");
		
	}
	
	//사원 목록 출력
	
	@SuppressWarnings("unchecked")
	void list() {
		//사원 목록을 받아옴
		
		List<EmpDTO> items = dao.listEmp();
		System.out.println("사번\t이름\t입사일자\t\t급여");
		for(EmpDTO dto : items) {
			System.out.println(dto.getEmpno()+"\t"+dto.getEname()+"\t"+dto.getHiredate()+"\t"+dto.getSel());
		}
		
	}
	
	public static void main(String[] args) {
		EmpManage e = new EmpManage();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("메뉴를 선택하세유~ (1:목록, 2 추가, 3:삭제, 0:종료)");
			int code = sc.nextInt();
			
			switch(code) {
			case 0 : System.out.println("프로그램 종료해유~"); sc.close(); System.exit(0); break;
			case 1 : e.list(); break;
			case 2 : e.insert(); break;
			case 3 : e.delete(); break;
			}
			
		}
		
	}
	
}

package ch21;

import java.util.List;
import java.util.Scanner;

public class AccountManage {
	AccountDAO dao = new AccountDAO();
	
	void list() {
		List<AccountDTO> list = dao.list();
		
		System.out.println("은행\t계좌번호\t\t예금주\t잔액");
		for(AccountDTO dto : list) {
			System.out.println(dto.getBank()+"\t"+dto.getNum()+"\t"+dto.getName()+"\t"+String.format("%,d", dto.getMoney()));
			
		}
		
	}//list
	
	
	void insert() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.print("은행 : ");
		String bank = scan.next();
		System.out.print("계좌번호 : ");
		String num = scan.next();
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("잔액 : ");
		int money = scan.nextInt();
		
		AccountDTO dto = new AccountDTO(bank, num, name, money);
		dao.insert(dto);
		System.out.println("등록되었습니다.");
		
		
	}//insert
	
	
	
	void delete() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 예금주를 입력하세요 : ");
		String name = scan.next();
		
		int result = dao.delete(name);
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("이름을 확인하세요.");
			delete();
		}
		
	}//delete
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		AccountManage ac = new AccountManage();
		
		while(true) {
			System.out.print("메뉴를 선택하세요(1:목록, 2:추가, 3:삭제, 0:종료) >> ");
			int code = sc.nextInt();
			
			switch(code) {
			case 0 : System.out.println("Bye~"); System.exit(0); break;
			case 1 : ac.list(); break;
			case 2 : ac.insert(); break;
			case 3 : ac.delete(); break;
			}
			
		}
		
		
	}

	
}

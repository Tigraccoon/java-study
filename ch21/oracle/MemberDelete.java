package ch21.oracle;

import java.util.Scanner;

public class MemberDelete {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 아이디를 입력하세요 : ");
		String userid = scan.nextLine();
		scan.close();
		
		int rows = MemberDAO.memberDelete(userid);
		
		if(rows>0) {
			System.out.println("삭제되었습니다?");
		} else {
			System.out.println("삭제 안 되었습니다?!");
		}
		
	}
	
}

package ch21;

import java.util.List;
import java.util.Scanner;

public class CarManage {
	CarDAO dao = new CarDAO();

	
	void delete() {
		@SuppressWarnings("resource")
		Scanner delscan = new Scanner(System.in);
		System.out.println("삭제할 차량번호를 입력하세요 : ");
		String license_number = delscan.nextLine();
		int result = dao.deleteCar(license_number);
		if (result == 1) {
			System.out.println("삭제됐습니다.");
		} else {
			System.out.println("차량번호를 확인하여 주십쇼.");
			delete();
		}
//		delscan.close();
	}//delete

	void insert() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("차량번호 : ");
		String license_number = scan.nextLine();
		System.out.println("제조사 : ");
		String company = scan.nextLine();
		System.out.println("타입 : ");
		String type = scan.nextLine();
		System.out.println("제조연도 : ");
		int year = scan.nextInt();
		System.out.println("연비 : ");
		int efficiency = scan.nextInt();
		CarDTO dto = new CarDTO(license_number, company, type, year, efficiency);

		dao.insertCar(dto);
		System.out.println("추가됐습니다.");
//		scan.close();
	}//insert


	void list() {
		List<CarDTO> items = dao.listCar();	//레코드 목록 리턴
		System.out.println("차량번호\t\t제조사\t타입\t연도\t연비");
		System.out.println("-------------------------------");
		for(CarDTO dto : items) {
			System.out.println(dto.getLicense_number()+"\t\t"+dto.getCompany()+"\t"+dto.getType()
			+"\t"+dto.getYear()+"\t"+dto.getEfficiency());

		}

	}//list

	public static void main(String[] args) throws Exception {
		CarManage car = new CarManage();
		Scanner mainscan = new Scanner(System.in);
		int code;
		while(true) {

			System.out.println("작업을 선택하세요.(1 : 목록, 2 : 추가, 3 : 삭제, 0 : 종료) >>> ");
			code = mainscan.nextInt();

			switch(code) {
			case 0 : mainscan.close(); System.out.println("프로그램 종료!"); System.exit(0); break;
			case 1 : car.list();	break;
			case 2 : car.insert();	break;
			case 3 : car.delete();	break;
			}
			

		}

	}

}

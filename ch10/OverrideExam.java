package ch10;

// class 1당 1개의 file이 정상
// 다수의 class를 1개의 file로 처리할땐 한 개의 public class 생성.
// 등등..


class Test11{
	public void print() {
		System.out.println("Test11");
	}	
	
}

class Test22 extends Test11 {
	@Override	//주석 @ ctrl + space 어노테이션
	public void print() {	//오버라이딩 됐더라도 호출받은 당사자가 우선권이 있음
		System.out.println("Test22");
	}
}


public class OverrideExam {
	public static void main(String[] args) {
		Test22 t2 = new Test22();
		
		t2.print();
		
	}
	
}

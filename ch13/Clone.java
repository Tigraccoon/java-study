package ch13;

public class Clone implements Cloneable{
	int num=10;
	void print() {
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		
		Clone t1=new Clone();
		Clone t2=null;
		
		try {	//예외가 발생할 가능성의 코드에 쓰임 - try~catch문
			t2=(Clone)t1.clone();	//인스턴스를 복제함. clone()은 object의 메소드이기 때문에 좌변과 맞추어 주기 위해 (Clone)형변환을 해야 함.
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();	//예외가 발생한 시점의 스택 정보를 출력. 개발자를 위한 디버깅 정보 제공
		}
		
		System.out.println(t1);
		System.out.println(t2);
		t1.print();
		t2.print();
	}
	
}

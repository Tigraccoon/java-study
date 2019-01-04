package ch13;

public class Change {
	public static void main(String[] args) {
		//값을 변경할 때 쓰이는 패턴
		int a=10; 
		int b=20;
		int temp;//b의 값을 a에 넣기 전 미리 백업하는 임시 변수
		
		temp=a;	//temp=10
		a=b;	//a=20
		b=temp;	//b=10
		System.out.println(a);
		System.out.println(b);
		
		
	}
	
}

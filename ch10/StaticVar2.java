package ch10;

public class StaticVar2 {
	static int total;	//클래스 메모리(static) 영역에 생성됨.
	String model;		//heap 메모리(non-static) 영역에 생성됨.
	public StaticVar2() {}
	public StaticVar2(String model) {
		this.model = model;
		total++;
	}
	
}

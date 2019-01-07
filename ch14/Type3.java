package ch14;

//Generic

public class Type3<T> {	//자료형 미정 <임의의 문자>
	T t;
	
	public void setT(T t) {
		this.t=t;
	}
	
	public T getT(){
		return t;
	}
	
	public static void main(String[] args) {
		Type3<String> t = new Type3<String>();
//		t.setT(100);	//<String>으로 지정했기 때문에 에러남
		t.setT("100");
		System.out.println(t.getT());
		
		Type3<Integer> t2 = new Type3<Integer>();
		t2.setT(100);
		System.out.println(t2.getT());
		
		Type3<Double> t3 = new Type3<Double>();
//		Type3 t3 = new Type3();	이렇게 형 지정을 생략 가능하지만 사용하지 않는게 좋음
		t3.setT(100.5);
		System.out.println(t3.getT());
		
	}
	
}

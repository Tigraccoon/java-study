package ch14;

//제네릭 클래스(generic class)에서는 타입을 변수로 표시
//type parameter라고 하는데 타입 매개변수는 객체 생성 시 프로그래머에 의해 결정

public class Box2<T> {	//<T> 타입 매개변수 보통 Type의 약자인 T를 많이 씀?
	private T data;
	public void set(T data) {
		this.data=data;
	}
	public T get() {
		return data;
	}
	
	public static void main(String[] args) {
		Box2<String> b=new Box2<String>();	//타입 매개변수에 대입하게 될 String 지정
		System.out.println(b);
		b.set("Hello World!!");				//문자열 저장
		String s=b.get();
		System.out.println(s);
		
		Box2<Integer> c=new Box2<Integer>();
		System.out.println(c);
		c.set(10);
		Integer i=c.get();
		System.out.println(i);
		
	}
	
}

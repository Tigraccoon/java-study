package ch14;

//Object

public class Type2 {
	Object value;
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value=value;
	}
	
	public static void main(String[] args) {
		Type2 t=new Type2();
		
		t.setValue("hi?");	//실행시 결정
		System.out.println(t.getValue());
		
		t.setValue(10);
		System.out.println(t.getValue());
		
		t.setValue(100.1);
		System.out.println(t.getValue());
		
		//이처럼 Object로 처리하면 메모리를 많이 먹으므로 성능이 저하
		//내부적 형변환 처리
		
	}
	
}

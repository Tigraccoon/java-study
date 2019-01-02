package ch12;

class Outer {
	class InstanceInner{
		int iv=100;
	}	//InstanceInner class
	static class StaticInner {
		int iv=200;
		static int cv=300;
	}	//staticInner class
	
	void myMethod() {
		class LocalInner{
			int iv=400;
		}	//LocalInner class
		
		//*맴버 메소드 안의 클래스는 메인 메소드에서 직접적으로 호출은 안 되고 사전에 생성해서 메소드를 호출하는 형식으로 호출해야함. 
		LocalInner ac = new LocalInner();
		System.out.println("li.iv : " + ac.iv);
	}	//myMethod method
}	//Outer class

public class InnerExam4 {
	public static void main(String[] args) {
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);
		
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv : " + si.iv);
		
		oc.myMethod();
		
	}
	
}

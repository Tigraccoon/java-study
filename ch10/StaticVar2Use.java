package ch10;
	
public class StaticVar2Use {
	public static void main(String[] args) {
		System.out.println(StaticVar2.total);
		
		StaticVar2 car1 = new StaticVar2("쏘나타");
		System.out.println(car1.model);
		System.out.println(StaticVar2.total);
		StaticVar2 car2 = new StaticVar2("k5");
		System.out.println(car2.model);
		System.out.println(StaticVar2.total);
		StaticVar2 car3 = new StaticVar2("말리부");
		System.out.println(car3.model);
		System.out.println(StaticVar2.total);
		
		//static 영역은 공유
		
		
	}
	
}

package ch08;

public class Person {
	private String name;
	private int height;
	private int weight;
	
	public Person() {
		this("김철수",150,100);
	}
	
	public Person(String name) {
		this(name,190,100);
	}
	
	public Person(String name, int height) {
		this(name,height,90);
	}
	
	public Person(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		
	}
	
	public void showInfo() {
		System.out.println("---신상정보---");
		System.out.println("이  름 : " + name);
		System.out.println("신  장 : " + height);
		System.out.println("체  중 : " + weight);
<<<<<<< HEAD
		System.out.println();
=======
>>>>>>> parent of 8f32c4c... Revert "Tigraccoon"
	}
	
	
}

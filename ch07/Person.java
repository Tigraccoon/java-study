package ch07;

public class Person {
	private String name;
	private int age;
	private double height;

	//우클릭 - source - Generate Getter and Setter 	=> private 타입 설정시 getter와 setter를 자동으로 생성 (*변수 이름이 중요)

	public String getName() {	//getter
		return name;
	}

	public void setName(String name) {	//setter
		this.name = name;	//this 는 변수 명이 같을 경우 글로벌 변수 호출
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age<0 || age>150) {
			System.out.println("입력값이 정확하지 않습니다.");
		} else {
			this.age = age;
		}

	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height < 50.0 || height > 300) {
			System.out.println("입력값이 정확하지 않습니다.");
		} else {
			this.height = height;
		}
	}
	
	public void print() {
		System.out.println("이름 : "+name+", 나이 : "+age+", 키 : "+height);
	}


}

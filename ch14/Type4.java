package ch14;

public class Type4<Data> {
	
	private Data num, name, address, hp, weight;

	
	public Data getNum() {
		return num;
	}


	public void setNum(Data num) {
		this.num = num;
	}


	public Data getName() {
		return name;
	}


	public void setName(Data name) {
		this.name = name;
	}


	public Data getAddress() {
		return address;
	}


	public void setAddress(Data address) {
		this.address = address;
	}


	public Data getHp() {
		return hp;
	}


	public void setHp(Data hp) {
		this.hp = hp;
	}


	public Data getWeight() {
		return weight;
	}


	public void setWeight(Data weight) {
		this.weight = weight;
	}


	public static void main(String[] args) {
		Type4<Integer> num = new Type4<Integer>();
		num.setNum(100);
		System.out.println("학번\t: "+num.getNum());
		
		Type4<String> name = new Type4<String>();
		name.setName("홍길동");
		System.out.println("이름\t: "+name.getName());
		
		Type4<String> address = new Type4<String>();
		address.setAddress("서울 강동구");
		System.out.println("주소\t: "+address.getAddress());
		
		Type4<String> hp = new Type4<String>();
		hp.setHp("010-1234-4567");
		System.out.println("h.p\t: "+hp.getHp());
		
		Type4<Double> weight = new Type4<Double>();
		weight.setWeight(60.5);
		System.out.println("몸무게\t: "+weight.getWeight());
		
	}
	
}

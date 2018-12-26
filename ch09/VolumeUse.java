package ch09;

public class VolumeUse {
	public static void main(String[] args) {
		Volume v1 = new Volume();
		System.out.println("부피 : " + v1.getVolume());
		
		Volume v2 = new Volume(10, 20, 30);
		System.out.println("부피 : " + v2.getVolume());
		
	}
	
}

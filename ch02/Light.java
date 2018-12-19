package ch02;

public class Light {

	public static void main(String[] args) {
			//64비트(8바이트) 정수를 저장
		long lightspeed;
		long distance;
		
		lightspeed = 300000;
		distance = lightspeed * 365L * 24 * 60 * 60;
			//거리 = 빛의 속도 * 365일 * 24시 * 60분 * 60초
		
		System.out.println("빛이 1년동안 가는 거리 : " + distance + " km");
		
	}
	
}

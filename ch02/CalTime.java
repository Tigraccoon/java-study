package ch02;
//지구에서 달까지의 거리 계산하기
public class CalTime {

	public static void main(String[] args) {
		
		final double LIGHT_SPEED = 30e4;
		double distance = 40e12, secs;
		
		secs = distance / LIGHT_SPEED;
		
		double light_year = secs / (60.0 * 60.0 * 24.0 * 365.0);
		
		System.out.println("지구에서 달까지 걸리는 시간은 " + light_year + " 광년입니다.");
				
	}
	
}

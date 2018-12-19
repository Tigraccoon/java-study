package ch02;

public class Constant {

	public static void main(String[] args) {
		
		final double KM_PER_MIEL = 1.609344;
		double km, mile = 60.0;
		
		km = KM_PER_MIEL * mile;
		
		
		System.out.println("60마일은 " + km + " km 입니다.");
		
		
	}
	
}

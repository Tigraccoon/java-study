package ch04;

public class Switch {

	public static void main(String[] args) {
		
		int kor = 85, eng = 70, mat = 90, tot = kor + mat + eng;
		double avg = tot / 3.0;
		String grade = "";
		
		switch ((int)avg / 10 ) {
		case 10:
		case 9: grade = "수"; break;
		case 8: grade = "우"; break;
		case 7: grade = "미"; break;
		case 6: grade = "양"; break;
		
		default : grade = "가";
		}
		
		System.out.println("국어\t수학\t영어\t\t평균\t\t등급");
		System.out.printf("%d\t%d\t%d\t\t%.1f\t%s" , kor, mat, eng, avg, grade);
		
	}
	
}

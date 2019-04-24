package temp;

public class Q3 {
	public static void main(String[] args) {
		int[] kor = {80,52,66};
		int[] eng = {100,98,41};
		int[] mat = {90,99,29};
		
		int[] sum = returnSum(kor, eng, mat);
		int[] avg = returnAvg(kor, eng, mat);
		String[] grade = returnGrade(kor, eng, mat);
		
		for(int i=0 ; i < kor.length ; i++) {
			System.out.print(i+1 + ". 국어 : " + kor[i] + ", 수학 : " + mat[i] + ", 영어 : " + eng[i]);
			System.out.println(" / 합계 : " + sum[i] + ", 평균 : " + avg[i] + ", 등급 : " + grade[i]);
		}
	}
	
	public static int[] returnSum(int[] a, int[] b, int[] c) {
		int[] sum = new int[a.length];
		
		for(int i=0 ; i<a.length ; i++) {
			sum[i] += a[i]+b[i]+c[i];
		}
		
		return sum;
	}
	
	public static int[] returnAvg(int[] a, int[] b, int[] c) {
		int[] avg = new int[a.length];
		
		for(int i=0 ; i<a.length ; i++) {
			avg[i] = (a[i]+b[i]+c[i])/3;
		}
		
		return avg;
	}
	
	public static String[] returnGrade(int[] a, int[] b, int[] c) {
		String[] grade = new String[a.length];
		int[] avg = returnAvg(a, b, c);
		
		for(int i=0 ; i<a.length ; i++) {
			switch(avg[i]/10) {
			case 10 : grade[i] = "수"; break;
			case 9 : grade[i] = "수"; break;
			case 8 : grade[i] = "우"; break;
			case 7 : grade[i] = "미"; break;
			case 6 : grade[i] = "양"; break;
			default : grade[i] = "가";
			}
		}
		
		return grade;
	}
}

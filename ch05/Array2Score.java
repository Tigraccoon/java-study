package ch05;

public class Array2Score {
	public static void main(String[] args) {
		int[][] score = {
				{80,90,100,0,0},
				{70,60,95,0,0},
				{88,77,66,0,0}
		};
		
		System.out.println("------------------------------------");
		System.out.println("Java\tDB\tJSP\t총점\t평균");
		
		for (int i=0;i<score.length;i++) {
			score[i][3] += score[i][0]+score[i][1]+score[i][2];
			score[i][4] = score[i][3]/3;
			
			for(int j=0;j<score[i].length;j++) {
				System.out.print(score[i][j]+"\t");
				
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
		
	}
	
}

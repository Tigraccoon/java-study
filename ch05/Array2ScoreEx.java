package ch05;

public class Array2ScoreEx {
	public static void main(String[] args) {
		int[][] score = {
				{80,90,100},
				{70,60,95},
				{88,77,66}
		};
		
		System.out.println("------------------------------------");
		System.out.println("Java\tDB\tJSP\t총점\t평균");
		
		for (int i=0;i<score.length;i++) {	//for1
			int tot=0;
			for(int j=0;j<score[i].length;j++) {	//for2
				System.out.printf("%d\t",score[i][j]);
				tot+=score[i][j];
			}	//for2
			
			System.out.printf("%d\t%.1f",tot,tot/(double)score[i].length);
			System.out.println();
		}	//for1

		System.out.println("------------------------------------");
		
	}
	
}

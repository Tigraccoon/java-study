package ch05;
/*	2차원 배열
 * 		0	1	2
 * 0	10	20	30
 * 1	40	50	60
 * 2	70	80	90
 *		배열첨자가 2개가 돼야함
 */

public class Array2 {
	public static void main(String[] args) {
		int [][] num = { {10,20,30}, {40,50,60}, {70,80,90}};

//		int[][] num;
//		num = new int[3][3];
//		num [0][0]=10;
//		num [0][1]=20;
//		num [0][2]=30;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(num[i][j]);
			}
		}

	}

}

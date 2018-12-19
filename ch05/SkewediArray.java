package ch05;

public class SkewediArray {
	public static void main(String[] args) {
		int[][] intArray = new int[4][];
		intArray[0] = new int[3];	//첫째 행의 정수 3개의 열 생성
		intArray[1] = new int[2];	//둘째 행의 정수 2개의 열 생성
		intArray[2] = new int[3];	//셋째 행의 정수 3개의 열 생성
		intArray[3] = new int[2];	//넷째 행의 정수 2개의 열 생성
		
		for (int i=0;i<intArray.length;i++) {	//행
			for(int j=0;j<intArray[i].length;j++) {	//열
				intArray[i][j] = (i+1)*10+j;
				
				
			}	//for2
			
		}	//for1
		
		for(int i=0; i<intArray.length;i++) {
			for (int j=0;j<intArray[i].length;j++) {
				System.out.print(intArray[i][j]+" ");
				
			}	//for2
			
			System.out.println();
			
		}	//for1
		
	}	//main
	
}

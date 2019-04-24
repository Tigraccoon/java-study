package temp;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q2_MightBeCorrectAnswer {
	static Scanner scan = new Scanner(System.in);	//스캐너
	static int num=0;	//배열 크기 지정 변수

	public static void main(String[] args) {
		int[] array = returnArray();	//배열 변수를 메소드로 초기화
		int sum = 0, avg = 0;
		String grade = "";
		
		Arrays.sort(array);	//배열 정렬
		System.out.print("정렬된 점수 : ");
		for(int i : array) {
			System.out.print(i + " ");
			sum += i;
		}
		avg = sum/array.length;
		System.out.println("\n------");
		
		for(int i : array) {
			switch(i / 10) {
			case 10 : grade = "A+"; break;
			case 9 : grade = "A"; break;
			case 8 : grade = "B"; break;
			case 7 : grade = "C"; break;
			case 6 : grade = "D"; break;
			default : grade = "F";
			}
			
			System.out.println("점수 : " + i + ", 등급 : " + grade);
		}
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
	}	//main
	
	public static int[] returnArray() {
		int num = returnNum();
		Random ran = new Random();
		
		int[] array = new int[num];
		for(int i=0 ; i < array.length ; i++) {
			array[i] = ran.nextInt(100);
		}
		return array;
	}//returnArray
	
	public static int returnNum() {
		System.out.print("30명 이하의 인원 수를 입력하세요 : ");
		num = scan.nextInt();
		if(num > 30 || num <= 0) {
			returnNum();	//숫자 범위 이상시 재귀호출
		}
		scan.close();
		return num;
	}
}

package temp;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q2 {
	//문제 : 30명 이하의 수를 입력받아 이 배열을 정렬하고 배열 내부 값의 합계, 평균, 각각의 값의 등급을 출력하는 프로그램을 만드시오.
	//메소드 returnArray는 배열의 크기를 반환하는 메소드인 returnNum을 통해 배열을 생성하고 반환하는 메소드입니다.
	//returnArray 메소드는 완성된 상태이므로 그냥 사용하시고 main메소드와 returnNum 메소드를 수정하세요.
	//등급은 100 이상 A+,	90이상 A, 80이상 B, 70이상 C, 60이상 D, 60미만 F로 출력하세요.
	
	//아래는 출력 예시
/* 	30명 이하의 인원 수를 입력하세요 : 99		//값 범위 초과, 미만시 다시 값을 입력받습니다.
   	30명 이하의 인원 수를 입력하세요 : -45
	30명 이하의 인원 수를 입력하세요 : 25
	정렬된 점수 : 8 8 10 20 23 24 25 29 29 30 32 36 40 42 48 51 52 58 60 66 74 76 80 90 95 
	------
	점수 : 8, 등급 : F
	점수 : 8, 등급 : F
	.
	.
	.
	점수 : 95, 등급 : A
	합계 : 1106
	평균 : 44
	*/
	
	//아래의 변수는 전역변수로 사용하여주십시오.
	static Scanner scan = new Scanner(System.in);	//스캐너
	static int num=0;	//배열 크기 지정 변수
	
	public static void main(String[] args) {
		
		
		
	}	//main
	
	public static int returnNum() {		//배열 크기 입력 메소드
		System.out.print("30명 이하의 인원 수를 입력하세요 : ");
		num = scan.nextInt();
		
		
		return num;
	}
	
	//아래는 수정할 필요가 없는 메소드입니다.
	public static int[] returnArray() {	//배열생성 후 리턴 메소드, 배열 내부는 랜덤 함수를 통해 자동으로 생성됩니다.
		int num = returnNum();
		Random ran = new Random();
		
		int[] array = new int[num];
		for(int i=0 ; i < array.length ; i++) {
			array[i] = ran.nextInt(100);
		}
		return array;
	}//returnArray
}

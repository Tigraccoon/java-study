package ch13;

import java.util.Arrays;

public class ArrSort {
	public static void main(String[] args) {
		int[] num= {50,40,70,90,120,-20};
		System.out.print("배열 데이터 : ");
		for(int i : num) {
			System.out.print(i+" ");
		}
		
		Arrays.sort(num);
		//bubble sort(버블 정렬)
		
		
		System.out.println();
		System.out.print("오름차순 : ");
		for(int i : num) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.print("내림차순 : ");
		for(int i=num.length-1;i>=0;i--) {
			System.out.print(num[i]+" ");
		}
	}
	
}

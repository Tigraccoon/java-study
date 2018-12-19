package ch05;

import java.util.Scanner;

public class SeqSearch {
	public static void main(String[] args) {
		int[] s = {0,10,20,30,40,50,60,70,80,90,100};
		int value, index=-1;

		Scanner scan = new Scanner(System.in);
		System.out.println("(보기) : 0 10 20 30 40 50 60 70 80 90 100");
		System.out.print("위 숫자 중 탐색할 값을 입력하세요 : ");
		value = scan.nextInt();
		for	(int i=0;i<s.length;i++) {
			if(s[i] == value) {
				index = i;	
			}	// end if

		}	// end for
		if (index < s.length && index >= 0) {
			System.out.println("" + value + " 값은 index " + index + " 의 위치에 있습니다.");
		}else {
			System.out.println(""+ value + " 값은 없습니다.");
		}
		scan.close();

	}

}

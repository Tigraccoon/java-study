package temp;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {

		String[] got12 = { "쥐", "소", "호랑이", "토끼", 
	            "용", "뱀", "말", "양", "원숭이", "닭", "개", "돼지" }; 
	      

	      System.out.println("당신이 태어난 연도를 입력하세요.");
	      Scanner scan = new Scanner(System.in); 
	      int year = scan.nextInt()+8; 
	      

	      System.out.println("당신의 띠는 "+got12[year%12]+"띠입니다.");

	      System.out.print("당신의 나이는 "+(2028-year)+"살 입니다"); 
	      scan.close();

	}
}

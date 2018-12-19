package ch05;

import java.util.Scanner;

public class Array2MyPro {
		public static Scanner in;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String an = "";
		
		String[][] q = {
				{"1+1=","2"},
				{"2+2=","4"},
				{"3+3=","6"}
		};
		
		for(int i=0;i<q.length;i++) {
			System.out.print("Q"+(i+1)+" >> "+q[i][0]+" 은? ");
			an=scan.next();
			
				if (an.equals(q[i][1])) {
					System.out.println("정답입니다.");
				}
				else {
					System.out.println("오답입니다. 정답은 "+q[i][1]+" 입니다.");
				}	//end if
		System.out.println();
		}	//end for
		
		scan.close();
	}	//end main
	
}

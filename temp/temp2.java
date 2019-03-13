package temp;

import java.util.Scanner;

public class temp2 {
	public static void main(String[] args) {
		int n, fact=1;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while(n>0) {
			fact = n*fact;
			n--;
		}
		System.out.println(fact);
		sc.close();
	}
	
}

package temp;

import java.util.Scanner;

class Factorial2{
	int fact=1;
	public int CalFact(int n) {
		return (n>0) ? fact=n*CalFact(n-1) : 1;
	}
}

public class Tmp1 {
	public static void main(String[] args) {
		int n;
		Scanner sc =  new Scanner(System.in);
		
		n = sc.nextInt();
		System.out.print(n);
		Factorial2 fc = new Factorial2();
		System.out.println("의 누승은 " + fc.CalFact(n));
		sc.close();
		
	}
	
}

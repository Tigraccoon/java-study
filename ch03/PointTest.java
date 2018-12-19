package ch03;

import java.util.Scanner;

public class PointTest {
	
	public static Scanner in;
	
	public static void main(String[] args) {
		//  tot = 총점 / avg = 평균
		double  Java, DataBase, HTML, JSP, tot, avg;	
		
		// name = 이름 / TF = 합격여부
		String name, TF;		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print( "이름 : ");
		name = scan.next();
		
		System.out.print( "Java 점수 : ");
		Java = scan.nextDouble();
		
		System.out.print("DataBase  점수 : ");
		DataBase = scan.nextDouble();
		
		System.out.print( "HTML  점수 : ");
		HTML = scan.nextDouble();
		
		System.out.print( "JSP 점수 : ");
		JSP = scan.nextDouble();
		scan.close();
		
		tot = Java + DataBase + HTML + JSP;
		avg = tot / 4.0;
		
		
		// 평균이 60 이상이면 합격 and 한 과목이라도 60 이하면 과락
		TF = ( avg >= 60 && Java >= 60 && DataBase >= 60 && HTML >= 60 && JSP >= 60 ) ? "합격" : "과락";	
		
		System.out.println( "합격여부\t\t이름\t\tJava\t\tDataBase\tHTML\t\tJSP\t\t\t총점\t\t\t평균" );
		System.out.println( TF + "\t\t\t" + name + "\t" + Java + "\t\t" + DataBase + "\t\t" + HTML + "\t\t" + JSP + "\t\t" + tot + "\t\t" + avg );
		
		
	}
	
}

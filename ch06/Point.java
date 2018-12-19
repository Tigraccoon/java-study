package ch06;

public class Point {
	static String[] name = {"홍길동","이몽룡","이순신","차두리","박지성"};
	static int[] kor = {100,90,80,70,60};
	static int[] eng = {60,70,80,90,100};
	static int[] mat = {50,50,50,50,50};
	static int[] tot = new int[5];
	static int[] avg = new int[5];
	
	static void getTot() {
		for(int i=0;i<name.length;i++) {
			tot[i] += kor[i]+eng[i]+mat[i];
		}
	}	// getTot
	
	
	static void getAvg() {
		for(int i=0;i<name.length;i++) {
			avg[i] = tot[i]/3;
		}
	}	// getAvg
	
	static void print() {
		getTot();
		getAvg();
		System.out.println("--------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+mat[i]+"\t"+tot[i]+"\t"+avg[i]);
		}
		System.out.println("--------------------------------------------");

	}	// print
	
	public static void main(String[] args) {
		print();
	}	// main
	
	
}	// class

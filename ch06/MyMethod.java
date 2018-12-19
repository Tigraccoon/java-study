package ch06;

import java.util.Scanner;
//메소드를 활용한 메뉴 형식의 4칙연산, 구구단 출력 프로그램
public class MyMethod {
	public static Scanner in;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sel, a, b;
		String tem;
		out:

			while(true) {
				System.out.println("\n-----------------------------------");
				System.out.println("원하는 메뉴를 선택하세요.");
				System.out.println("1. 더하기\t2. 빼기\t3. 곱하기\t4. 나누기");
				System.out.println("5. 구구단(한 단)\t6. 구구단(전체)\t0. 종료");
				System.out.print(">>>>>>> ");
				tem = scan.next();
				sel = Integer.parseInt(tem);

				if (sel==1) {
					while(true) {
						System.out.println("A + B = ?");
						System.out.print("A : ");
						a = scan.nextInt();
						System.out.print("B : ");
						b = scan.nextInt();
						System.out.println("\t"+ a + " + " + b + " = " +plus(a, b)+"\n");
						System.out.println("0. 종료\t1. 이전");
						System.out.println("이외의 숫자 입력 시 다시");
						System.out.print(">>>>>> ");
						tem = scan.next();
						sel = Integer.parseInt(tem);
						if (sel==0)
							break out;
						else if (sel==1)
							break;
						else
							continue;
					}	//plus while
				}	//plus

				else if(sel==2) {
					while(true) {
						System.out.println("A - B = ?");
						System.out.print("A : ");
						a = scan.nextInt();
						System.out.print("B : ");
						b = scan.nextInt();
						System.out.println("\t"+ a + " - " + b + " = " +minus(a, b)+"\n");
						System.out.println("0. 종료\t1. 이전");
						System.out.println("이외의 숫자 입력 시 다시");
						System.out.print(">>>>>> ");
						tem = scan.next();
						sel = Integer.parseInt(tem);
						if (sel==0)
							break out;
						else if (sel==1)
							break;
						else
							continue;


					}	//minus while
				}	//minus

				else if (sel==3) {
					while(true) {
						System.out.println("A * B = ?");
						System.out.print("A : ");
						a = scan.nextInt();
						System.out.print("B : ");
						b = scan.nextInt();
						System.out.println("\t"+ a + " * " + b + " = " +multi(a, b)+"\n");
						System.out.println("0. 종료\t1. 이전");
						System.out.println("이외의 숫자 입력 시 다시");
						System.out.print(">>>>>> ");
						tem = scan.next();
						sel = Integer.parseInt(tem);
						if (sel==0)
							break out;
						else if (sel==1)
							break;
						else
							continue;
					}	//multi while
				}	//multi

				else if(sel==4) {
					while(true) {
						System.out.println("A / B = ?");
						System.out.print("A : ");
						a = scan.nextInt();
						System.out.print("B : ");
						b = scan.nextInt();
						System.out.println("\t"+ a + " / " + b + " = " +divide(a, b)+"\n");
						System.out.println("0. 종료\t1. 이전");
						System.out.println("이외의 숫자 입력 시 다시");
						System.out.print(">>>>>> ");
						tem = scan.next();
						sel = Integer.parseInt(tem);
						if (sel==0)
							break out;
						else if (sel==1)
							break;
						else
							continue;
					}	//divide while
				}	//divide

				else if(sel==5) {
					while(true) {
						System.out.print("원하는 단 입력 : ");
						a = scan.nextInt();
						gugu(a);
						System.out.println();
						System.out.println("0. 종료\t1. 이전");
						System.out.println("이외의 숫자 입력 시 다시");
						System.out.print(">>>>>> ");
						tem = scan.next();
						sel = Integer.parseInt(tem);
						if (sel==0)
							break out;
						else if (sel==1)
							break;
						else
							continue;
					}	// gugu while
				}	//gugu

				else if (sel==6) {
					while(true) {
						guguAll();
						System.out.println();
						System.out.println("0. 종료\t1. 이전");
						System.out.println("이외의 숫자 입력 시 다시");
						System.out.print(">>>>>> ");
						tem = scan.next();
						sel = Integer.parseInt(tem);
						if (sel==0)
							break out;
						else if (sel==1)
							break;
						else
							continue;
					}	// guguAll while
				}	//guguAll

				else if (sel==0) {
					break out;
				}

				else {

					System.out.println("\n메뉴에 있는 숫자를 입력하세요.\n");
					continue;

				}
				
			}	//main while
		scan.close();
		System.out.println("\n\nBye~\n");
	}	//main


	// ------------------------------------------

	static int plus(int a, int b) {
		return a+b;
	}

	static int minus(int a, int b) {
		return a-b;
	}

	static int multi(int a, int b) {
		return a*b;
	}

	static int divide(int a, int b) {
		return a/b;
	}

	static void gugu(int a) {
		System.out.println("--- " + a + " 단 ---");
		for (int i=1;i<=9;i++) {
			System.out.println(a + " * " + i + " = " + (a*i));
		}
	}

	static void guguAll() {
		for(int i=2;i<=9;i++) {
			System.out.println("\n--- " + i + " 단 ---");
			for(int j=1;j<=9;j++) {
				System.out.print(i + " * " + j + " = " + (i*j)+"\t");
			}
		}
	}

}
	//문제점 : 메뉴 선택 시 문자를 입력할 경우 바로 에러가 발생.
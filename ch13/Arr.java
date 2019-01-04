package ch13;

public class Arr {
	public static void main(String[] args) {
		int[] num1= {10,20,30,40,50};
		int[] num2= {10,20,30,40,50};
		boolean b=true;
		
		if(num1.length!=num2.length) {	//배열의 크기가 서로 다르면?
			b=false;
		}else {
			for(int i=0;i<num1.length;i++) {
				if(num1[i] != num2[i]) {	//내용이 다르면 반복문 종료
					b=false;
					break;
				}//if
			}//for
		}//else
		if(b==true) {
			System.out.println("배열의 내용이 같습니다.");
		}else {
			System.out.println("배열의 내용이 다릅니다.");
		}
		
	}
	
}

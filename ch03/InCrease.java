package ch03;
//증감연산자
public class InCrease {

	public static void main(String[] args) {
		
		int i = 5 , j = 0;
		j = i++;	// i의 값을 1씩 나중에 증가시킴(후위 연산자)
		System.out.println(i + ", " + j);
		
		i = 5;
		j = ++i;	// i의 값을 먼저 증가시킴 (전위 연산자)
		System.out.println(i + ", " + j);
		
	}
	
}

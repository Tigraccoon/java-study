package temp;

public class Q1 {
	public static void main(String[] args) {
		//문제 : 아래의 2차원 문자열 배열 변수 newArray를 가지고 '향상된 for문' 만을 사용하여 아래와 같이 출력하십시오.
		
		//TIP : 본 문제는 향상된 for문의 이해력을 높이기 위해 만들었으며 
		//향상된 for문의 공식인 for(배열 대입변수 : 배열) 의 공식을 생각하여 푸시면 도움이 될 것 같습니다.
		
		//---아래는 콘솔 출력 결과---
		//A
		//B
		//C
		//e
		//f
		//g
		
		String[][] newArray = {{"A", "B", "C"}, {"e", "f", "g"}};
		
		for(String[] i : newArray) {
			for(String j : i) {
				System.out.println(j);
			}
		}
		
	}

}

package ch12;

public class ActionExam {
	public static void main(String[] args) {
		Action a = new Action() {
			public void exec() {
				System.out.println("execc");
			}	//method
		};	// 중괄호 끝에 ; 을 추가함으로서 익명 class로 만듬.
			//*이벤트 처리 등 1회성으로 사용하는 간단한 코드에 익명클래스 자주 사용
		
		a.exec();
		
//		Action action = new MyAction();
//		action.exec();
		
	}
	
}

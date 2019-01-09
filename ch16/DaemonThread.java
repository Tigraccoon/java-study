package ch16;

//데몬 쓰레드 : 데몬(Daemon)이란 보통 리눅스와 같은 유닉스 계열의 운영체제에서 백그라운드로 동작하는 프로그램을 말한다.
//데몬 쓰레드를 만드는 방법은 쓰레드에 데몬을 설정하면 된다.
//윈도우에선 데몬을 서비스라고 한다.
//  예) 에디터를 실행할때 자동 저장 기능, 자동 맞춤법 검사 등등
//데몬 쓰레드는 일반 쓰레드가 모두 종료되면 강제적으로 종료되는 특징이 있음.

public class DaemonThread implements Runnable {

	//무한루프 안에서 0.5초 씩 쉬면서 메세지 출력
	@Override
	public void run() {
		while(true) {
			System.out.println("데몬 쓰레드 실행중..");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;	//Exception 발생시 while문이 정지하도록
			}
		}
	}

	public static void main(String[] args) {
		Thread th = new Thread(new DaemonThread());
		th.setDaemon(true);	//대몬 쓰레드 설정

		th.start();

		//메인 쓰레드가 1초 뒤에 종료되도록 설정
		//데몬 쓰레드는 다른 쓰레드가 모두 종료되면 자동 종료
		for(int i=0;i<3;i++) {
			try {
				Thread.sleep(1500);
				System.out.println("메인 메소드 실행중");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("메인 쓰레드 종료!");

	}

}

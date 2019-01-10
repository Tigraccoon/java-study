package ch16;

public class Atm extends Thread {
	private long depositMoney=100000;	//예금 잔액
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			withDraw(10000);
		}
		
	}//run

	public synchronized void withDraw(int money) {
		String name=Thread.currentThread().getName();
		if(depositMoney > 0) {	//잔액이 있으면
			depositMoney -= money;
			System.out.println(name+" - 잔액 : "+depositMoney);
		}else {	//잔액이 없으면
			System.out.println(name+" - 빈 깡통입니다.");
		}
		
		
	}

}

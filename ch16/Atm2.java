package ch16;

public class Atm2 implements Runnable {
	private long depositMoney=1000000000;
	
	@Override
	public synchronized void run() {
		for(int i=0;i<10;i++) {
			givemethemoney(100000000);
		}
	}

	public void givemethemoney(int hereitis) {
		String name = Thread.currentThread().getName();
		if(depositMoney > 0) {
			depositMoney-=hereitis;
			System.out.println(name+" - 잔액 : "+depositMoney);
		} else {
			System.out.println(name+" - 빈 깡통입니다.");
		}
	
	}
	
	
}

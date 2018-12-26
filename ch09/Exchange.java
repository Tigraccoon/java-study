package ch09;

class Money {
	int getExchange() {
		return 0;
	}
}

class Kor extends Money {
	int getExchange() {
		return 1200;
	}
}

class Jap extends Money {
	int getExchange() {
		return 1018;
	}
}

public class Exchange {
	public static void main(String[] args) {
		Kor k1 = new Kor();
		Jap j1 = new Jap();
		
		System.out.println("달러에 대한 환율 : " + k1.getExchange());
		System.out.println("엔화에 대한 환율 : " + j1.getExchange());
		
	}
	
}

package ch07;

public class TelevisionTest {
	public static void main(String[] args) {
		Television tv = new Television();	//Television.java의 클래스 생성
		tv.channel = 7; // tv. => 인스턴스화된 Television 객채의 메모리 주소값 접근
		tv.volume = 9;
		tv.onOff = true;
		System.out.println("텔레비젼의 채널은 : " + tv.channel);
		System.out.println("텔레비젼의 볼륨은 : " + tv.volume);
		
	}
	
}

package ch07;

public class TelevisionTest2 {
	public static void main(String[] args) {
		Television myTv = new Television();
		myTv.channel = 7;
		myTv.volume = 10;
		myTv.onOff = true;
		
		Television yourTv = new Television();
		yourTv.channel = 9;
		yourTv.volume = 12;
		yourTv.onOff = true;
		System.out.println("나의 텔레비젼의 채널은 : " + myTv.channel + " 이고 볼륨은 : " + myTv.volume);
		System.out.println("당신의 텔레비젼의 채널은 : " + yourTv.channel + " 이고 볼륨은 : " + yourTv.volume);

		
	}
	
}

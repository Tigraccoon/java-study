package ch16;

public class MusicPlayer extends Thread{
	int type;
	MusicBox musicBox;
	//생성자로부터 musicBox와 정수 하나를 받아서 필드를 초기화
	
	public MusicPlayer() {}
	public MusicPlayer(int type, MusicBox musicBox) {
		this.type = type;
		this.musicBox = musicBox;
	}
	
	//type이 무엇이냐에 따라 musicBox가 가지고 있는 메소드가 다르게 호출
	@Override
	public void run() {
		switch(type) {
		case 1: musicBox.playMusicA(); break;
		case 2: musicBox.playMusicB(); break;
		case 3: musicBox.playMusicC(); break;
		}
		
	}
	
}

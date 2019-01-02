package ch11;

public interface RemoteControllabe extends Controllable {
	//같은 interface인 Controllable 인터페이스를 상속받음.
	void remoteOn();
	void remoteOff();
}

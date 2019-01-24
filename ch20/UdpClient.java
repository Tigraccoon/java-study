package ch20;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	public static void main(String[] args) {
		try {
			//getByName("서버측 IP주소");
			InetAddress address = InetAddress.getByName("localhost");
			
			//서버에 전송할 데이터
			System.out.println("서버에 전송할 메시지를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			String data = scan.next();
			scan.close();
			
			byte[] send = data.getBytes();
			DatagramPacket packet = new DatagramPacket(send, send.length, address, 7777);
			
			//소켓 생성
			DatagramSocket socket = new DatagramSocket();
			//소켓을 사용하여 패킷을 서버에 전송
			socket.send(packet);
			socket.close();
			System.out.println("전송이 완료되었습니다.");
			
			//서버에서 보낸 메시지를 받기 위한 객체 생성
			//8888번 포트 개방
			DatagramSocket socket2 = new DatagramSocket(8888);
			//바이트 배열 생성
			byte[] data2 = new byte[65508];
			//서버에서 보낸 메시지를 저장하기 위한 패킷객체
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
			//서버에서 보낸 메시지를 수신
			socket2.receive(packet2);
			socket2.close();//소켓 연결 닫기
			
			String message = new String(data2);
			System.out.println("서버에서 보낸 메시지 : "+message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

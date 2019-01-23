package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {
	public static void main(String[] args) throws Exception {
		//Socket("ip", 포트번호)
		Socket s = new Socket("192.168.0.233", 8000);
		//서버에서 accept()하면 통신이 가능한 상태가 됌
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//서버에서 보낸 메세지를 받음
		String res = input.readLine();
		System.out.println(res);
		
		s.close();		//소켓 닫기(연결 종료)
		System.out.println("연결 종료");
		System.exit(0);	//프로그램 종료
		
	}
	
}

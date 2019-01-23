package ch20;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//서버용 프로그램

public class DateServer {
	public static void main(String[] args) throws Exception {
		//네트워크 관련 작업은 예외 처리가 필수
		//ServerSocket : 서비스용 소켓
		//Socket : ServerSocket에 접속하는 소켓
		
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("서비스 시작!");
		
		while(true) {
			//accept() 클라이언트가 접속할 때까지 대기
			//접속이 되면 소켓을 연결(논리적인 회선 연결)
			Socket socket = ss.accept();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//날짜 포맷 yyyy 연도, MM 월, dd 일, HH 시, mm 분, ss 초
			String str = sdf.format(new Date());	//Date() 영문 형식의 날짜가 출력
			out.println(str);	//클라이언트에게 데이터 전송
			
			socket.close();		//소켓 종료(연결 종료)
			ss.close();
		}
	}
	
}

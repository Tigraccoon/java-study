package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) throws Exception{
		Socket socket = null;
		PrintWriter writer = null;
		BufferedReader reader = null;
		try {
			socket = new Socket("192.168.0.2", 5555);
			writer = new PrintWriter(socket.getOutputStream(),true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String receive = "";
		String send;
		Scanner sc = new Scanner(System.in);
		while(true) {
			receive = reader.readLine();	//메세지 읽음
			System.out.println("[Server] " + receive);
			if(receive.equals("quit")) break;
			System.out.println("입력하세요(종료 : quit) >>> ");
			send = sc.nextLine();	//키보드 입력
			if(send.equals("quit")) {
				System.out.println("bye~");
				break;
			}
			if(send != null) {
				writer.println(send);
			}
		}
		
		sc.close();
		writer.close();
		reader.close();
		socket.close();
	}
	
}

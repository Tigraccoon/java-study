package ch20;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadImage2{
	public static void main(String[] args) throws Exception {
		String web = "http://www.mrhi.or.kr/DATA/portfolio/d7635e4a5576871281da5ebe0547e3a80.jpg";
		URL url = new URL(web);
		byte[] buffer = new byte[8192];
		InputStream in = url.openStream();
		OutputStream out = new FileOutputStream("D:\\testt.jpg");
		int length = 0;

		try {
			System.out.println("다운로드 시작~");

			while((length = in.read(buffer)) != -1) {

				System.out.println(length + " 바이트 다운로드-");
				out.write(buffer, 0, length);

			}

			System.out.println("다운로드 완료~");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				if(in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if(out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

}
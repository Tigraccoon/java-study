package ch13;

import java.util.Calendar;
import java.util.Date;
//Calendar
public class Cal {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();	//abstract class의 static method
		System.out.println(cal.get(Calendar.YEAR));	//OS에서 가져옴
		//월은 시작 index가 0이라서 +1 해줘야 함.
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		//12시간제
		System.out.println(cal.get(Calendar.HOUR));
		//24시간제
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		//오전:0 / 오후:1
		System.out.println(cal.get(Calendar.AM_PM));
		if(cal.get(Calendar.AM_PM)==0) {
			System.out.println("오~전");
		}else {
			System.out.println("오~후");
		}
		
		//1년 중 몇 번째 날?
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		//월의 몇 번째 날?
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		//요일 (일요일:1 ~ 토요일:7) = java에서는 숫자 코드까지만 제공..
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		String yoil="";
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:yoil="일요일"; break;
		case 2:yoil="월요일"; break;
		case 3:yoil="화요일"; break;
		case 4:yoil="수요일"; break;
		case 5:yoil="목요일"; break;
		case 6:yoil="금요일"; break;
		case 7:yoil="토요일"; break;
		}
		System.out.println("오늘은 "+yoil+" 입니다.");
		
		//1년중 몇 번째 주?
		System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
		
		Date date=cal.getTime();
		System.out.println(date.getYear()+1900);
		System.out.println(date.getMonth()+1);
		System.out.println(date.getDate());
		
	}
	
}

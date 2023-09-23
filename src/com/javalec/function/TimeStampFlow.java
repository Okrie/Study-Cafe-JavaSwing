package com.javalec.function;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JLabel;



//	사용 방법
//	//실시간 시간 노출
//	시작 할 때 timeSet(0)으로 시작 window closing 할 때 timeSet(1)로 종료
//	private void timeSet(int i) {
//		TimeStampFlow time = new TimeStampFlow(lblNewLabel_3);
//		if(i == 0) {
//			time.start();
//		}else {
//			time.interrupt();
//		}
//	}
//  현재 시간 1번만 들고 오기
//	private void nowTimeis() {
//		String nowTime = "";
//		TimeStampFlow time = new TimeStampFlow(lblTime);
//		nowTime = time.nowTime();
//	}


public class TimeStampFlow extends Thread{
	private JLabel lbldTime;	
	
	public TimeStampFlow() {
		// TODO Auto-generated constructor stub
	}
	
	public TimeStampFlow(JLabel lbldTime) {
		// TODO Auto-generated constructor stub
		this.lbldTime = lbldTime;
	}
	
	@Override
	public void run() {
		while(true) {
			// 현재 시스템 시간 구하기
			long systemTime = System.currentTimeMillis();
	
			// 출력 형태를 위한 formmater 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
			 
			// format에 맞게 출력하기 위한 문자열 변환
			lbldTime.setText(formatter.format(systemTime));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 현재시간 받기 위한 함수
	public String nowTime() {
		// 현재 시스템 시간 구하기
		long systemTime = System.currentTimeMillis();
		
		// 출력 형태를 위한 formmater 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		
		return formatter.format(systemTime);
	}

	public String diffTime(Timestamp endtime) {
//		long currentTime = System.currentTimeMillis();
//
//	    long remainingTime = endtime.getTime() - currentTime;
//
//	    SimpleDateFormat formatter = new SimpleDateFormat("dd HH:mm:ss", Locale.KOREA);
//	    String formattedRemainingTime = formatter.format(new Date(remainingTime));
		long currentTime = System.currentTimeMillis();
	    long remainingTime = endtime.getTime() - currentTime;

	    long seconds = remainingTime / 1000 % 60;
	    long minutes = remainingTime / (1000 * 60) % 60;
	    long hours = remainingTime / (1000 * 60 * 60) % 24;
	    long days = remainingTime / (1000 * 60 * 60 * 24);
	    
	    if(seconds < 0) {
	    	return "종료";
	    }
	    String formattedRemainingTime;
	    if(days <= 0) {
	    	formattedRemainingTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
	    } else {
	    	formattedRemainingTime = String.format("%02d일 %02d:%02d:%02d", days, hours, minutes, seconds);	    	
	    }
		
		return formattedRemainingTime;
	}
}


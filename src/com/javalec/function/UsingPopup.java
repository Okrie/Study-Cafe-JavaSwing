package com.javalec.function;

import javax.swing.JOptionPane;


// 사용 방법
//	private void showMe() {
//		UsingPopup popuptest = new UsingPopup("새로운 방법", "", "팝업테스트", 0);
//	}


public class UsingPopup {
	
	private String infoString;
	private String errorCode;
	private String title;
	
	private int whatPopup;
	// 0 = 확인 버튼만 있는 팝업
	// 1 = 확인, 취소 버튼이 있는 팝업
	// 2 = 에러 팝업
	// 3 = 커스텀 팝업

	
	public UsingPopup() {
		// TODO Auto-generated constructor stub
	}

	public UsingPopup(String infoString, String errorCode, String title, int whatPopup) {
		super();
		this.infoString = infoString;
		this.errorCode = errorCode;
		this.title = title;
		this.whatPopup = whatPopup;
		
		
		switch(this.whatPopup) {
		case 0:
			// 0 = 확인 버튼만 있는 팝업
			confirmPopup();
			break;
		case 1:
			// 1 = 확인, 취소 버튼이 있는 팝업
			reCheckPopup();
			break;
		case 2:
			// 2 = 에러 팝업
			errorPopup();
			break;
		case 3:
			// 3 = 커스텀 팝업
			customPopup();
		default:
			break;				
		}
	}
	
	private void confirmPopup() {
		JOptionPane.showMessageDialog(null, infoString + "\n정보가 수정되었습니다.", title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void reCheckPopup() {
		JOptionPane.showMessageDialog(null, infoString + "\n정보를 변경하시겠습니까?", title, JOptionPane.DEFAULT_OPTION);
	}
	
	private void errorPopup() {
		JOptionPane.showMessageDialog(null, infoString + "\n에러가 발생했습니다.\n 에러코드 : " + errorCode + "\n4조에 문의 하세요.", title, JOptionPane.ERROR_MESSAGE);
	}

	private void customPopup() {
		JOptionPane.showMessageDialog(null, infoString, title, JOptionPane.INFORMATION_MESSAGE);
	}
}

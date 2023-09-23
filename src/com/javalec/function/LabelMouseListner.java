package com.javalec.function;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.javalec.util.ShareVar;


// 마우스 리스너 추가 하는 방법
// 사용할 클래스 내에 아래와 같은 함수 선언
//	private void addMouseListenerToLabel(JLabel label) {
//		label.addMouseListener(new LabelMouseListner());
//	}
// 해당 panel 안에 사용 
// addMouseListenerToLabel(라벨 생성하는 함수명); 

/* 이 해당 클래스를 사용하지 않고 사용하는 방법
 * 이 방법은 따로 물어 보면 설명 해줌
 * private void addMouseListenerToLabel(JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component c = e.getComponent();
	            if (c instanceof JLabel) {
	                JLabel label = (JLabel) c;
	            }
			}
		});
	}	
 */

public class LabelMouseListner extends MouseAdapter {
	
	// 마우스 갖다 댔을 때
    @Override
    public void mouseEntered(MouseEvent e) {
//        JLabel label = (JLabel) e.getSource();
//        label.setBackground(Color.LIGHT_GRAY);
    }
    
    // 마우스가 영역을 벗어 났을 때
    @Override
    public void mouseExited(MouseEvent e) {
//        JLabel label = (JLabel) e.getSource();
//        label.setBackground(Color.WHITE);
    }

    // 마우스로 클릭했을 때
    @Override
    public void mouseClicked(MouseEvent e) {
        // 클릭 이벤트 처리
    	Component c = e.getComponent();
    	if(c instanceof JLabel) {
    		JLabel label = (JLabel) c;
    		ShareVar.labelText = label.getText();
    	}
    }
}
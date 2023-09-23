package com.javalec.function;
import java.awt.Color;
import javax.swing.JButton;


		/* 이거 쓸때는 이런식으로 위에서 색깔 정해주면 간단하게 쓸 수 있어. 맨처음 색은 기본 배경 색깔, 기본 글자 색깔, 누른 버튼의 배경색깔, 누른 버튼의 글자 색깔 
		 * ButtonColorChanger colorChanger = new ButtonColorChanger(Color.LIGHT_GRAY, Color.BLACK, Color.ORANGE, Color.WHITE);
		 * 밑에부터는 그냥 예시
		   buttons[i].addActionListener(e -> {
    	   JButton clickedButton = (JButton) e.getSource();
    	   if (selectedButton != null) {
    	   colorChanger.changeButtonColor(selectedButton, false);
    	   }
           colorChanger.changeButtonColor(clickedButton, true);
           selectedButton = clickedButton;
           });
		 */

	public class ButtonColorChanger {
		Color defaultBackgroundColor;
	    Color defaultTextColor;
	    Color selectedBackgroundColor;
	    Color selectedTextColor;

	    public ButtonColorChanger(Color defaultBackgroundColor, Color defaultTextColor, Color selectedBackgroundColor, Color selectedTextColor) {
	        this.defaultBackgroundColor = defaultBackgroundColor;
	        this.defaultTextColor = defaultTextColor;
	        this.selectedBackgroundColor = selectedBackgroundColor;
	        this.selectedTextColor = selectedTextColor;
	    }

	    public void changeButtonColor(JButton button, boolean isSelected) {
	        if (isSelected) {
	            button.setBackground(selectedBackgroundColor);
	            button.setForeground(selectedTextColor);
	        } else {
	            button.setBackground(defaultBackgroundColor);
	            button.setForeground(defaultTextColor);
	        }
	    }
	}
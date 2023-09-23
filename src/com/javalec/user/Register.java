package com.javalec.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.javalec.dao.RegisterDao;
import com.javalec.function.ImageResize;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;

public class Register extends JFrame {

	private JPanel contentPane;
	
	private boolean isDone = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String message = "";
	private JLabel lblNewLabel;
	private JTextField tfTelno;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField tfPassword;
	private JPasswordField tfPasswordCheck;
	private JLabel messageLabel;
	private JLabel lblNewLabel_4;
	private JLabel lblGoBack;
	private JLabel lblRegister;
	private JLabel lblRegister2;
	private JLabel lbTop;
	private JLabel lbBody;
	private JLabel lbBody_1;
	private JLabel lbBottom;
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTfTelno());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTfPassword());
		contentPane.add(getTfPasswordCheck());
		contentPane.add(getMessageLabel());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblGoBack());
		contentPane.add(getLblRegister());
		contentPane.add(getLblRegister2());
		contentPane.add(getLbTop());
		contentPane.add(getLbBody());
		contentPane.add(getLbBottom());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("휴대폰 번호 : ");
			lblNewLabel.setBounds(84, 295, 107, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setBounds(228, 290, 115, 26);
			tfTelno.setColumns(10);
		}
		return tfTelno;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("비밀번호 :");
			lblNewLabel_1.setBounds(84, 354, 79, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("비밀번호 확인 : ");
			lblNewLabel_2.setBounds(84, 414, 115, 16);
		}
		return lblNewLabel_2;
	}
	private JPasswordField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JPasswordField();
			tfPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int maxLength = 4;
					JPasswordField textfield = new JPasswordField();
					
				}
			});
			tfPassword.getDocument().addDocumentListener(new PasswordFieldListener());
			tfPassword.setBounds(195, 349, 148, 26);
		}
		return tfPassword;
	}
	private JPasswordField getTfPasswordCheck() {
		if (tfPasswordCheck == null) {
			tfPasswordCheck = new JPasswordField();
			tfPasswordCheck.getDocument().addDocumentListener(new PasswordFieldListener());
			tfPasswordCheck.setBounds(195, 409, 148, 26);
		}
		return tfPasswordCheck;
	}
	
	private void insertAction() { //회원가입 등록누르는 기
		String telno = tfTelno.getText();
	    String password = tfPassword.getText();   
		String passwordcheck= tfPasswordCheck.getText();

		RegisterDao dao = new RegisterDao(telno, passwordcheck);//dao에서 불러오기
		boolean result =  dao.insertAction(); //dao에서 insertaction의 결과값을 boolean으로 선언해주기

		if(result) {
			JOptionPane.showMessageDialog(this, " 정보 입력!\n"  + "님의 정보가 입력 되었습니다!", "회원 정보", JOptionPane.INFORMATION_MESSAGE);
			isDone = true;
		}else {
			JOptionPane.showMessageDialog(this, "정보 입력!\n" + "입력중 문제가 발생했습니다. \n관리자에게 문의하세요!", "Error", JOptionPane.ERROR_MESSAGE);
			isDone = false;
		}
	}
	
	
	
	
	
	private int insertFieldCheck() {
		int i = 0;
		if(tfTelno.getText().trim().length() == 0) {
			i++;
			message = "전화번호를 ";
			tfTelno.requestFocus();
		}
		
		if(tfPassword.getText().trim().length() == 0) {
			i++;
			message = "비밀번호를 ";
			tfPassword.requestFocus();
		}
		if(tfPasswordCheck.getText().trim().length() == 0) {
			i++;
			message = "비밀번호 확인을 ";
			tfPasswordCheck.requestFocus();
		}
	
				
		return i;
	}
	

	private JLabel getMessageLabel() {
		if (messageLabel == null) {
			messageLabel = new JLabel("");
			messageLabel.setBounds(195, 461, 167, 16);
		}
		return messageLabel;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("010-");
			lblNewLabel_4.setBounds(195, 295, 39, 16);
		}
		return lblNewLabel_4;
	}
	

	private class PasswordFieldListener implements DocumentListener {
		@Override
		public void insertUpdate(DocumentEvent e) {
			checkPasswords();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			checkPasswords();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			checkPasswords();
		}

		private void checkPasswords() {
			char[] password = tfPassword.getPassword();
			char[] confirmPassword = tfPasswordCheck.getPassword();
			if (password.length == 0 || confirmPassword.length == 0) {
				messageLabel.setText("");
				messageLabel.setForeground(Color.BLACK);
			} else if (isEqual(password, confirmPassword)) {
				messageLabel.setText("Passwords match");
				messageLabel.setForeground(Color.GREEN);
			} else {
				messageLabel.setText("Passwords do not match");
				messageLabel.setForeground(Color.RED);
			}
		}

		private boolean isEqual(char[] password, char[] confirmPassword) {
			if (password.length != confirmPassword.length) {
				return false;
			}
			for (int i = 0; i < password.length; i++) {
				if (password[i] != confirmPassword[i]) {
					return false;
				}
			}
			return true;
		}
	}
	
	private JLabel getLblGoBack() {
		if (lblGoBack == null) {
			lblGoBack = new JLabel("");
			ImageResize image = new ImageResize(80,70,"GoBackicon.png");
			lblGoBack.setIcon(image.resizeImage());
			lblGoBack.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Login().setVisible(true);
				}
			});
			lblGoBack.setForeground(Color.BLACK);
			lblGoBack.setBounds(466, 199, 86, 71);
		}
		return lblGoBack;
	}
	private JLabel getLblRegister() {
		if (lblRegister == null) {
			lblRegister = new JLabel("");
			lblRegister.setBounds(194, 809, 61, 16);
		}
		return lblRegister;
	}
	private JLabel getLblRegister2() {
		if (lblRegister2 == null) {
			lblRegister2 = new JLabel("");
			ImageResize image = new ImageResize(90,50,"Regisicon.png");
			lblRegister2.setIcon(image.resizeImage());
			lblRegister2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int j = insertFieldCheck();
					if(j == 0 && tfPassword.getText().equals(tfPasswordCheck.getText()) && tfPassword.getText().length() == 4) {
						insertAction();
						if(isDone) {
							dispose();
							new Login().setVisible(true);
						}
					} else if(tfPassword.getText().length() != 4){
						JOptionPane.showMessageDialog(null, "4자리의 비밀번호를 입력 해주세요.", "회원 정보", JOptionPane.ERROR_MESSAGE);
					}else if(!tfPassword.getText().equals(tfPasswordCheck.getText())) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "회원 정보", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, message + "를 확인 해주세요.", "회원 정보", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			lblRegister2.setBounds(247, 622, 107, 69);
		}
		return lblRegister2;
	}
	
	

	
	
	
	
	private JLabel getLbTop() {
		if (lbTop == null) {
			lbTop = new JLabel("");
			lbTop.setBounds(0, 0, 585, 150);
			ImageResize icon = new ImageResize(585, 150, "Top.jpg");
			lbTop.setIcon(icon.resizeImage());
		}
		return lbTop;
	}
	private JLabel getLbBody() {
		if (lbBody == null) {
			lbBody = new JLabel("");
			lbBody.setBounds(0, 151, 585, 658);
			ImageResize icon = new ImageResize(585, 658, "Body.jpg");
			lbBody.setIcon(icon.resizeImage());
		}
		return lbBody;
	}
	
	private JLabel getLbBottom() {
		if (lbBottom == null) {
			lbBottom = new JLabel("");
			lbBottom.setBounds(0, 809, 585, 150);
			ImageResize icon = new ImageResize(585, 150, "Bottom.png");
			lbBottom.setIcon(icon.resizeImage());
		}
		return lbBottom;
	}
}//END



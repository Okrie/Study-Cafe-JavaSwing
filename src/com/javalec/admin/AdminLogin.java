package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.LoginDao;
import com.javalec.function.TimeStampFlow;
import com.javalec.function.UsingPopup;
import com.javalec.util.ShareVar;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel infoPanel;
	private JPanel nowPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JTextField tfInputid;
	private JButton btnLogin;
	private JPasswordField pfPassword;
	private JLabel lblNewLabel_3;
	
	// 필요에 의한 전역변수 설정
	private String message = ""; // 입력 빈칸시 오류 설정
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setTitle("스터디카페 관리자 로그인 화면");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				timeSet(0);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				timeSet(1);
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{220, 0};
		gbl_contentPane.rowHeights = new int[]{50, 500, 170, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 10.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 14.0, 5.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		getTopPanel().setLayout(null);
		GridBagConstraints gbc_topPanel = new GridBagConstraints();
		gbc_topPanel.insets = new Insets(0, 0, 0, 0);
		gbc_topPanel.fill = GridBagConstraints.BOTH;
		gbc_topPanel.gridx = 0;
		gbc_topPanel.gridy = 0;
		gbc_topPanel.gridwidth = 2;
		contentPane.add(getTopPanel(), gbc_topPanel);
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 0, 0);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 1;
		contentPane.add(getInfoPanel(), gbc_infoPanel);
		getMainPanel().setLayout(null);
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.insets = new Insets(0, 0, 0, 0);
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 1;
		gbc_mainPanel.gridy = 1;
		gbc_mainPanel.gridheight = 2;
		contentPane.add(getMainPanel(), gbc_mainPanel);
		GridBagConstraints gbc_nowPanel = new GridBagConstraints();
		gbc_nowPanel.insets = new Insets(0, 0, 0, 0);
		gbc_nowPanel.fill = GridBagConstraints.BOTH;
		gbc_nowPanel.gridx = 0;
		gbc_nowPanel.gridy = 2;
		contentPane.add(getNowPanel(), gbc_nowPanel);
		
		
		setResizable(false);
	}
	private JPanel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setBackground(new Color(247, 248, 228));
			mainPanel.add(getLblNewLabel());
			mainPanel.add(getLblNewLabel_1());
			mainPanel.add(getLblNewLabel_2());
			mainPanel.add(getLblNewLabel_2_1());
			mainPanel.add(getTfInputid());
			mainPanel.add(getPfPassword());
			mainPanel.add(getBtnLogin());
		}
		return mainPanel;
	}
	private JPanel getTopPanel() {
		if (topPanel == null) {
			topPanel = new JPanel();
			topPanel.setBackground(new Color(247, 226, 202));
			topPanel.add(getLblNewLabel_3());
		}
		return topPanel;
	}
	private JPanel getInfoPanel() {
		if (infoPanel == null) {
			infoPanel = new JPanel();
			infoPanel.setBackground(new Color(226, 223, 222));
		}
		return infoPanel;
	}
	private JPanel getNowPanel() {
		if (nowPanel == null) {
			nowPanel = new JPanel();
			nowPanel.setBackground(new Color(223, 234, 195));
			
		}
		return nowPanel;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Forever");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 65));
			lblNewLabel.setBounds(376, 81, 288, 85);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("StudyCafe 관리자 로그인");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 65));
			lblNewLabel_1.setBounds(148, 193, 763, 85);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("아이디 : ");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_2.setBounds(282, 387, 133, 36);
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("비밀번호 : ");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_2_1.setBounds(286, 451, 133, 36);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTfInputid() {
		if (tfInputid == null) {
			tfInputid = new JTextField();
			tfInputid.setToolTipText("아이디를 입력하세요");
			tfInputid.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			tfInputid.setBounds(436, 382, 276, 45);
			tfInputid.setColumns(10);
		}
		return tfInputid;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = insertFieldCheck();
					if(i == 0) {
						boolean result = checkAction();
						if(result) {
							dispose();
							UsingPopup cPopup = new UsingPopup(ShareVar.id + "님 어서오세요.\n", null, "관리자 로그인", 3);
							new AdminMain().setVisible(true);
						}else {
							UsingPopup cPopup = new UsingPopup("ID 혹은 비밀번호가 틀렸습니다.\n 다시 입력해주세요.\n", "0000", "관리자 로그인", 2);
						}
					} else {
						UsingPopup cPopup = new UsingPopup(message + "를 입력해주세요.\n", "0001", "관리자 로그인", 2);
					}
				}
			});
			btnLogin.setToolTipText("");
			btnLogin.setBounds(763, 536, 188, 47);
		}
		return btnLogin;
	}
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setToolTipText("비밀번호를 입력하세요");
			pfPassword.setBounds(436, 446, 276, 45);
			pfPassword.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int i = insertFieldCheck();
					if(i == 0) {
						boolean result = checkAction();
						if(result) {
							dispose();
							UsingPopup cPopup = new UsingPopup(ShareVar.id + "님 어서오세요.\n", null, "관리자 로그인", 3);
							new AdminMain().setVisible(true);
						}else {
							UsingPopup cPopup = new UsingPopup("ID 혹은 비밀번호가 틀렸습니다.\n 다시 입력해주세요.\n", "0000", "관리자 로그인", 2);
						}
					} else {
						UsingPopup cPopup = new UsingPopup(message + "를 입력해주세요.\n", "0001", "관리자 로그인", 2);
					}
				}
			});
		}
		return pfPassword;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBounds(10, 20, 160, 20);
		}
		return lblNewLabel_3;
	}
	
	
	
	
	
	// Method
	
	private void timeSet(int i) {
		TimeStampFlow time = new TimeStampFlow(lblNewLabel_3);
		if(i == 0) {
			time.start();
		}else {
			time.interrupt();
		}
	}
	
	
	// 빈 항목 체크
	private int insertFieldCheck() {
		int i = 0;
		
		if(tfInputid.getText().trim().length() == 0) {
			i++;
			message = "아이디를 ";
			tfInputid.requestFocus();
		}
		if(pfPassword.getText().trim().length() == 0) {
			i++;
			message = "비밀번호를 ";
			pfPassword.requestFocus();
		}
		return i;
	}
	
	// 로그인 버튼 터치 시 ID PW 입력 받아 어드민 유저인지 확인
	private boolean checkAction() {
		String id = tfInputid.getText();
		String password = pfPassword.getText();
		
		LoginDao dao = new LoginDao(id, password);
		boolean result = dao.checkAction(1);
		
		return result;
	}
}

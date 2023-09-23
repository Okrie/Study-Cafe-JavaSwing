package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.CheckoutDao;
import com.javalec.util.ShareVar;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IfUsingUser extends JFrame {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btnNewButton;
	private JPanel infoPanel;
	private JPanel infoPanel_1;
	private JButton btn1_2;
	ShareVar shareVar = new ShareVar();
	String str = shareVar.id;
	String str1 = str.substring(str.length() - 4);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IfUsingUser frame = new IfUsingUser();
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
	public IfUsingUser() {
		setTitle("ifusinguser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtn1());
		contentPane.add(getInfoPanel());
		contentPane.add(getInfoPanel_1());
		contentPane.add(getBtn1_2());
	}

	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton("문열기");
			btn1.setBounds(219, 377, 144, 64);
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, str1 + "고객님 문이 열렸습니다.", "open", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new Login().setVisible(true);
				}
			});
		}
		return btn1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Logout");
			btnNewButton.setBounds(453, 60, 85, 70);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Login().setVisible(true);
				}
			});
		}
		return btnNewButton;
	}
	private JPanel getInfoPanel() {
		if (infoPanel == null) {
			infoPanel = new JPanel();
			infoPanel.setBackground(new Color(226, 223, 222));
			infoPanel.setBounds(0, 0, 600, 150);
			infoPanel.setLayout(null);
			infoPanel.add(getBtnNewButton());
		}
		return infoPanel;
	}
	private JPanel getInfoPanel_1() {
		if (infoPanel_1 == null) {
			infoPanel_1 = new JPanel();
			infoPanel_1.setBackground(new Color(226, 223, 222));
			infoPanel_1.setBounds(0, 811, 600, 150);
		}
		return infoPanel_1;
	}
	private JButton getBtn1_2() {//퇴실시 db에 퇴실시간 적어주고 자리를 다시 활성화 시켜야 하는 작업 필요.
		
		if (btn1_2 == null) {
			btn1_2 = new JButton("퇴실");
			btn1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//퇴실했을 때 DB에서 삭제 해야될 정보 productStatus 0으로 변경, enddatetime을 퇴실하는 시간으로 update
					statusChange();
					
					
					
					//퇴실되었을 때 메세지 출력
					JOptionPane.showMessageDialog(null, str1 + "님 안녕히가세요", "out", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
			btn1_2.setBounds(219, 484, 144, 64);
		}
		return btn1_2;
	}


	//------------------------Function----------------------------
	
	private void statusChange() {
		CheckoutDao checkoutDao = new CheckoutDao(str1);
		//CheckoutDao에서 사용할건 endtimeUpdate(), status1to0() 둘다.
		try {
			checkoutDao.endtimeUpdate();
			checkoutDao.updateStatus();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	



















}//----------------------END---------------------

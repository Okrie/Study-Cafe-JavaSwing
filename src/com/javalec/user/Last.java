package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.PaymentDao;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Last extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_1_1;
	private JLabel lblID;
	private JLabel lblProductID;
	private JLabel lblPurchaseTime;
	private JLabel lbDuration;
	private JLabel lblpPrice;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Last frame = new Last();
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
	public Last() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setPurchaseInfo();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(177, 180, 191));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_3_1());
		contentPane.add(getLblNewLabel_3_1_1());
		contentPane.add(getLblID());
		contentPane.add(getLblProductID());
		contentPane.add(getLblPurchaseTime());
		contentPane.add(getLbDuration());
		contentPane.add(getLblpPrice());
		contentPane.add(getBtnNewButton());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("사용자 ID :");
			lblNewLabel.setForeground(new Color(236, 241, 255));
			lblNewLabel.setBounds(72, 95, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("구매가 완료되었습니다.");
			lblNewLabel_1.setFont(new Font("Gurmukhi Sangam MN", Font.PLAIN, 20));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(149, 38, 212, 41);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("상품번호 :");
			lblNewLabel_2.setForeground(new Color(236, 241, 255));
			lblNewLabel_2.setBounds(72, 154, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("구매기간 :");
			lblNewLabel_3.setForeground(new Color(236, 241, 255));
			lblNewLabel_3.setBounds(72, 213, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("이용기간 :");
			lblNewLabel_3_1.setForeground(new Color(236, 241, 255));
			lblNewLabel_3_1.setBounds(72, 269, 61, 16);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel("결제 금액 :");
			lblNewLabel_3_1_1.setForeground(new Color(236, 241, 255));
			lblNewLabel_3_1_1.setBounds(72, 327, 61, 16);
		}
		return lblNewLabel_3_1_1;
	}
	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel("New label");
			lblID.setBounds(72, 123, 109, 16);
		}
		return lblID;
	}
	private JLabel getLblProductID() {
		if (lblProductID == null) {
			lblProductID = new JLabel("New label");
			lblProductID.setBounds(72, 182, 109, 16);
		}
		return lblProductID;
	}
	private JLabel getLblPurchaseTime() {
		if (lblPurchaseTime == null) {
			lblPurchaseTime = new JLabel("New label");
			lblPurchaseTime.setBounds(72, 241, 369, 16);
		}
		return lblPurchaseTime;
	}
	private JLabel getLbDuration() {
		if (lbDuration == null) {
			lbDuration = new JLabel("New label");
			lbDuration.setBounds(72, 297, 369, 16);
		}
		return lbDuration;
	}
	private JLabel getLblpPrice() {
		if (lblpPrice == null) {
			lblpPrice = new JLabel("New label");
			lblpPrice.setBounds(72, 355, 150, 16);
		}
		return lblpPrice;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("확인");
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBackground(new Color(236, 241, 255));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Payment.closeWindow();
					new Login().setVisible(true);
				}
			});
			btnNewButton.setBounds(40, 396, 436, 35);
			btnNewButton.setOpaque(true);
		}
		return btnNewButton;
	}
	
	// Function
	
	private void setPurchaseInfo() {
		PaymentDao paymentDao = new PaymentDao();
		
		int calctime = paymentDao.getCalcTime();
		
		if(calctime < 24) {
			lblPurchaseTime.setText(Integer.toString(calctime) + "시간");
		}else {
			lblPurchaseTime.setText(Integer.toString(calctime/24) + "일");
		}
		
		lblID.setText(ShareVar.id);
		lblProductID.setText(ShareVar.labelText);
		lblpPrice.setText(Integer.toString(ShareVar.pPrice) + "원");
		lbDuration.setText(usingDuration(calctime));
	}
	
	private String usingDuration(int hours) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime targetDateTime = currentDateTime.plusHours(hours);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String dateTimeRange = currentDateTime.format(formatter) + " ~ " + targetDateTime.format(formatter);

		return dateTimeRange;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
} // End

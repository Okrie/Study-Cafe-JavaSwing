package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class AdminOnUserInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOnUserInfo frame = new AdminOnUserInfo();
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
	public AdminOnUserInfo() {
		setTitle("정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInfoLabel1 = new JLabel("정보 1");
		lblInfoLabel1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel1.setBounds(15, 20, 400, 35);
		contentPane.add(lblInfoLabel1);
		
		JLabel lblInfoLabel2 = new JLabel("정보 2");
		lblInfoLabel2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel2.setBounds(15, 65, 400, 35);
		contentPane.add(lblInfoLabel2);
		
		JLabel lblInfoLabel3 = new JLabel("정보 3");
		lblInfoLabel3.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel3.setBounds(15, 110, 400, 35);
		contentPane.add(lblInfoLabel3);
		
		JLabel lblInfoLabel4 = new JLabel("정보 4");
		lblInfoLabel4.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel4.setBounds(15, 155, 400, 35);
		contentPane.add(lblInfoLabel4);
		
		JLabel lblInfoLabel5 = new JLabel("정보 5");
		lblInfoLabel5.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel5.setBounds(15, 200, 400, 35);
		contentPane.add(lblInfoLabel5);
		
		JButton btnInfo1 = new JButton("버튼 1");
		btnInfo1.setFont(new Font("굴림", Font.PLAIN, 13));
		btnInfo1.setBounds(20, 380, 140, 35);
		contentPane.add(btnInfo1);
		
		JButton btnInfo2 = new JButton("버튼 2");
		btnInfo2.setFont(new Font("굴림", Font.PLAIN, 13));
		btnInfo2.setBounds(235, 380, 140, 35);
		contentPane.add(btnInfo2);
		
		JButton btnInfo3 = new JButton("버튼 3");
		btnInfo3.setFont(new Font("굴림", Font.PLAIN, 13));
		btnInfo3.setBounds(450, 380, 140, 35);
		contentPane.add(btnInfo3);
	}
}

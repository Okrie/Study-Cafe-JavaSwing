package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.ImageResize;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Choose extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogOut;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	private static JButton selectedButton;
	private JLabel lblTop;
	private JLabel lblBody;
	private JLabel lblBottom;
	public static JButton getSelectedButton() {
        return selectedButton;
    }
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choose frame = new Choose();
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
	public Choose() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
			}
		});
		setTitle("좌석유형선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogOut());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getBtnNewButton_4());
		contentPane.add(getBtnNewButton_5());
		contentPane.add(getLblTop());
		contentPane.add(getLblBody());
		contentPane.add(getLblBottom());
	}
	private JLabel getLblLogOut() {
		if (lblLogOut == null) {
			lblLogOut = new JLabel("로그아웃");
			lblLogOut.setBounds(463, 180, 70, 60);
			lblLogOut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Login().setVisible(true);
				}
			});
			lblLogOut.setBackground(new Color(176, 180, 192));
			ImageResize image = new ImageResize(70, 60, "LogOutIcon.png");
			lblLogOut.setIcon(image.resizeImage());
			lblLogOut.setOpaque(true);
		}
		return lblLogOut;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("사물함 선택");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Choose.selectedButton = btnNewButton_2;
					dispose();
					new CabinetChoose().setVisible(true);
				}
				
			});
			btnNewButton_2.setBounds(199, 631, 200, 100);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("스터디룸 선택");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Choose.selectedButton = btnNewButton_3;
					dispose();
					new RoomTimeChoose().setVisible(true);
				}
			});
			btnNewButton_3.setBounds(199, 499, 200, 100);
			
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("1인실 선택");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Choose.selectedButton = btnNewButton_4;
					dispose();
					new ReservedSeatChoose().setVisible(true);
				}
			});
			btnNewButton_4.setBounds(199, 366, 200, 100);
			
		}
		return btnNewButton_4;
	}
	private JButton getBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("자유석 선택");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Choose.selectedButton = btnNewButton_5;
					dispose();
					new SeatChoose().setVisible(true);
				}
			});
			btnNewButton_5.setBounds(199, 233, 200, 100);
		}
		return btnNewButton_5;
	}
	
	
	private JLabel getLblTop() {
		if (lblTop == null) {
			lblTop = new JLabel("New label");
			lblTop.setBounds(0, 0, 585, 150);
			ImageResize image = new ImageResize(585, 150, "Top.jpg");
			lblTop.setIcon(image.resizeImage());
		}
		return lblTop;
	}
	private JLabel getLblBody() {
		if (lblBody == null) {
			lblBody = new JLabel("New label");
			lblBody.setBounds(0, 150, 585, 658);
			ImageResize image = new ImageResize(585, 658, "body.jpg");
			lblBody.setIcon(image.resizeImage());
			
		}
		return lblBody;
	}
	private JLabel getLblBottom() {
		if (lblBottom == null) {
			lblBottom = new JLabel("New label");
			lblBottom.setBounds(0, 809, 585, 150);
			ImageResize image = new ImageResize(585, 150, "Bottom.png");
			lblBottom.setIcon(image.resizeImage());
		}
		return lblBottom;
	}
} // End

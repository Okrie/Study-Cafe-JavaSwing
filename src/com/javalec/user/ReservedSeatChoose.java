package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.javalec.dao.CabinetDao;
import com.javalec.dao.ReservedSeatDao;
import com.javalec.function.ImageResize;
import com.javalec.util.ShareVar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ReservedSeatChoose extends JFrame {

	private JPanel contentPane;
	private JLabel lblProductImage;
	private JLabel lblRsSeat;
	private JLabel lblFixed01;
	private JLabel lblFixed02;
	private JLabel lblFixed03;
	private JLabel lblFixed04;
	private JLabel lblFixed05;
	private JLabel lblFixed06;
	private JLabel lblFixed07;
	private JLabel lblFixed08;
	private JLabel lblFixed09;
	private JLabel lblFixed10;
	private JLabel lblFixed11;
	private JLabel lblFixed12;
	private JLabel lblFixed13;
	private JLabel lblFixed14;
	private JLabel lblFixed15;
	private JLabel lblFixed16;

	JLabel tbtns[] = { lblFixed01, lblFixed02, lblFixed03, lblFixed04, lblFixed05, lblFixed06, lblFixed07, lblFixed08, lblFixed09, lblFixed10, lblFixed11, lblFixed12, lblFixed13, lblFixed14, lblFixed15, lblFixed16};
	private JLabel lblGoBackIcon;
	private JLabel lblLogOut;
	private JLabel lblPriceTagIcon;
	private JLabel lblbody;
	private JLabel lblTop;
	private JLabel lblBottom;
	   
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservedSeatChoose frame = new ReservedSeatChoose();
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
	public ReservedSeatChoose() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				disableReservedSeatLabel();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBottom());
		contentPane.add(getLblPriceTagIcon());
		contentPane.add(getLblGoBackIcon());
		contentPane.add(getLblLogOut());
		contentPane.add(getLblFixed01());
		contentPane.add(getLblFixed02());
		contentPane.add(getLblFixed03());
		contentPane.add(getLblFixed04());
		contentPane.add(getLblFixed05());
		contentPane.add(getLblFixed06());
		contentPane.add(getLblFixed07());
		contentPane.add(getLblFixed08());
		contentPane.add(getLblFixed09());
		contentPane.add(getLblFixed10());
		contentPane.add(getLblFixed11());
		contentPane.add(getLblFixed12());
		contentPane.add(getLblFixed13());
		contentPane.add(getLblFixed14());
		contentPane.add(getLblFixed15());
		contentPane.add(getLblFixed16());
		contentPane.add(getLblRsSeat());
		contentPane.add(getLblProductImage());
		contentPane.add(getLblbody());
		contentPane.add(getLblTop());
		
	}
	
	private JLabel getLblProductImage() {
		if (lblProductImage == null) {
			lblProductImage = new JLabel("");
			lblProductImage.setBounds(8, 216, 250, 140);
			ImageResize image = new ImageResize(258, 144, "AllseatView.png");
			lblProductImage.setIcon(image.resizeImage());
		}
		return lblProductImage;
	}
	
	private JLabel getLblRsSeat() {
		if (lblRsSeat == null) {
			lblRsSeat = new JLabel("");
			lblRsSeat.setBounds(6, 381, 588, 362);
			ImageResize image = new ImageResize(588, 362, "reSeatChooseViewTextX.png");
			lblRsSeat.setIcon(image.resizeImage());
		}
		return lblRsSeat;
	}
	
	private JLabel getLblFixed01() {
		if (lblFixed01 == null) {
			lblFixed01 = new JLabel("Fixed01");
			lblFixed01.setBackground(new Color(255, 255, 0));
			lblFixed01.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed01.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed01.setBounds(6, 381, 55, 55);
		}
		return lblFixed01;
	}
	private JLabel getLblFixed02() {
		if (lblFixed02 == null) {
			lblFixed02 = new JLabel("Fixed02");
			lblFixed02.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed02.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed02.setBounds(61, 381, 55, 55);
		}
		return lblFixed02;
	}
	private JLabel getLblFixed03() {
		if (lblFixed03 == null) {
			lblFixed03 = new JLabel("Fixed03");
			lblFixed03.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed03.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed03.setBounds(114, 381, 55, 55);
		}
		return lblFixed03;
	}
	private JLabel getLblFixed04() {
		if (lblFixed04 == null) {
			lblFixed04 = new JLabel("Fixed04");
			lblFixed04.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed04.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed04.setBounds(169, 381, 55, 55);
		}
		return lblFixed04;
	}
	private JLabel getLblFixed05() {
		if (lblFixed05 == null) {
			lblFixed05 = new JLabel("Fixed05");
			lblFixed05.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed05.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed05.setBounds(224, 381, 55, 55);
		}
		return lblFixed05;
	}
	private JLabel getLblFixed06() {
		if (lblFixed06 == null) {
			lblFixed06 = new JLabel("Fixed06");
			lblFixed06.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed06.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed06.setBounds(279, 381, 55, 55);
		}
		return lblFixed06;
	}
	private JLabel getLblFixed07() {
		if (lblFixed07 == null) {
			lblFixed07 = new JLabel("Fixed07");
			lblFixed07.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed07.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed07.setBounds(332, 381, 55, 55);
		}
		return lblFixed07;
	}
	private JLabel getLblFixed08() {
		if (lblFixed08 == null) {
			lblFixed08 = new JLabel("Fixed08");
			lblFixed08.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed08.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed08.setBounds(388, 381, 55, 55);
		}
		return lblFixed08;
	}
	private JLabel getLblFixed09() {
		if (lblFixed09 == null) {
			lblFixed09 = new JLabel("Fixed09");
			lblFixed09.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed09.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed09.setBounds(441, 381, 55, 55);
		}
		return lblFixed09;
	}
	private JLabel getLblFixed10() {
		if (lblFixed10 == null) {
			lblFixed10 = new JLabel("Fixed10");
			lblFixed10.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed10.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed10.setBounds(496, 381, 55, 55);
		}
		return lblFixed10;
	}
	private JLabel getLblFixed11() {
		if (lblFixed11 == null) {
			lblFixed11 = new JLabel("Fixed11");
			lblFixed11.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed11.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed11.setBounds(224, 685, 52, 52);
		}
		return lblFixed11;
	}
	private JLabel getLblFixed12() {
		if (lblFixed12 == null) {
			lblFixed12 = new JLabel("Fixed12");
			lblFixed12.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed12.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed12.setBounds(279, 685, 52, 52);
		}
		return lblFixed12;
	}
	private JLabel getLblFixed13() {
		if (lblFixed13 == null) {
			lblFixed13 = new JLabel("Fixed13");
			lblFixed13.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed13.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed13.setBounds(332, 685, 52, 52);
		}
		return lblFixed13;
	}
	private JLabel getLblFixed14() {
		if (lblFixed14 == null) {
			lblFixed14 = new JLabel("Fixed14");
			lblFixed14.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed14.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed14.setBounds(388, 685, 52, 52);
		}
		return lblFixed14;
	}
	private JLabel getLblFixed15() {
		if (lblFixed15 == null) {
			lblFixed15 = new JLabel("Fixed15");
			lblFixed15.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed15.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed15.setBounds(441, 685, 52, 52);
		}
		return lblFixed15;
	}
	private JLabel getLblFixed16() {
		if (lblFixed16 == null) {
			lblFixed16 = new JLabel("Fixed16");
			lblFixed16.setHorizontalAlignment(SwingConstants.CENTER);
			lblFixed16.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFixed16.setBounds(496, 685, 52, 52);
		}
		return lblFixed16;
	}
	
	private JLabel getLblGoBackIcon() {
		if (lblGoBackIcon == null) {
			lblGoBackIcon = new JLabel("New label");
			lblGoBackIcon.setBackground(new Color(176, 180, 192));
			lblGoBackIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Choose().main(null);
					dispose();
				}
			});
			lblGoBackIcon.setBounds(476, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "GoBackIcon.png");
			lblGoBackIcon.setIcon(image.resizeImage());
		}
		return lblGoBackIcon;
	}
	private JLabel getLblLogOut() {
		if (lblLogOut == null) {
			lblLogOut = new JLabel("New label");
			lblLogOut.setBackground(new Color(176, 180, 192));
			lblLogOut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Login().main(null);
				}
			});
			lblLogOut.setBounds(407, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "LogOutIcon.png");
			lblLogOut.setIcon(image.resizeImage());
		}
		return lblLogOut;
	}
	private JLabel getLblPriceTagIcon() {
		if (lblPriceTagIcon == null) {
			lblPriceTagIcon = new JLabel("New label");
			lblPriceTagIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new SeatPriceTag().setVisible(true);
				}
			});
			lblPriceTagIcon.setBounds(336, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "PriceTagIcon.png");
			lblPriceTagIcon.setIcon(image.resizeImage());
		}
		return lblPriceTagIcon;
	}
	private JLabel getLblbody() {
		if (lblbody == null) {
			lblbody = new JLabel("New label");
			lblbody.setBounds(0, 150, 585, 658);
			ImageResize image = new ImageResize(585, 658, "body.jpg");
			lblbody.setIcon(image.resizeImage());
		}
		return lblbody;
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
	private JLabel getLblBottom() {
		if (lblBottom == null) {
			lblBottom = new JLabel("New label");
			lblBottom.setBounds(0, 809, 585, 150);
			ImageResize image = new ImageResize(585, 150, "Bottom.png");
			lblBottom.setIcon(image.resizeImage());
		}
		return lblBottom;
	}
	
	
	//Function
	
	// 순서부터 정하고 들어가자
	// 1.버튼을 눌렀을 때 기간을 정하는 페이지로 넘어가야해(하지만 이건 맨 마지막에 해야해)
	// 2.정보값이 뭔지 알게 해야해 즉 내가 선택한 버튼이 뭔지 어딘가에 저장해둬야한다는거지
	// 3.로그아웃 버튼을 누르면 가지고 있던 Login 클래스로 돌아가고 다시 로그인 하게 만들어야 해
	// 4.뒤로가기 버튼을 누르면 Choose 클래스로 돌아가게 해야해
	// 5.
	
	
	 private void setLabelText(JLabel label) {
	        ShareVar.labelText = label.getText();
	        new ReservedSeatTimeChoose().setVisible(true);
	        dispose();
	    }
	
	
	// 라벨의 값이 차있을때는 누르지 못하게 해야한다.
	private void disableReservedSeatLabel() {
		JLabel tbtns[] = { lblFixed01, lblFixed02, lblFixed03, lblFixed04, lblFixed05, lblFixed06, lblFixed07, lblFixed08,
				lblFixed09, lblFixed10, lblFixed11, lblFixed12, lblFixed13, lblFixed14, lblFixed15, lblFixed16 };
		ReservedSeatDao reservedSeatDao = new ReservedSeatDao();
		ArrayList<Integer> rsSeatStatus = reservedSeatDao.getRsSeatStatus();
		for (int i = 0; i < rsSeatStatus.size(); i++) {
			if (rsSeatStatus.get(i) == 0) {
				tbtns[i].setBackground(new Color(255, 160, 122));
				tbtns[i].setEnabled(false);
				tbtns[i].setOpaque(true);
			}else {
				JLabel l= tbtns[i];
				tbtns[i].addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                	setLabelText(l);
	                }
	            });
	        }
	    }
	}
	
	
	
	
	
	
	
	//test
	
	
	
} //End

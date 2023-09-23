package com.javalec.user;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.ReservedSeatDao;
import com.javalec.dao.SeatDao;
import com.javalec.function.ImageResize;
import com.javalec.util.ShareVar;

import java.awt.Color;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SeatChoose extends JFrame {

	private JPanel contentPane;
	private JLabel lblSeatView;
	private JLabel lblAllView;
	LocalDateTime dateTime = LocalDateTime.now();
	private JLabel lblFree01;
	private JLabel lblFree02;
	private JLabel lblFree03;
	private JLabel lblFree04;
	private JLabel lblFree05;
	private JLabel lblFree06;
	private JLabel lblFree07;
	private JLabel lblFree08;
	private JLabel lblFree09;
	private JLabel lblFree10;
	private JLabel lblFree11;
	private JLabel lblFree12;
	private JLabel lblFree13;
	private JLabel lblFree14;
	private JLabel lblFree15;
	private JLabel lblFree16;
	private JLabel lblFree17;
	private JLabel lblFree18;
	private JLabel lblFree19;
	private JLabel lblFree20;
	private JLabel lblFree21;
	private JLabel lblFree22;
	
	JLabel[] lblFree = new JLabel[22];
	

	private JLabel lblLogout;
	private JLabel lblBackIcon;
	private JLabel lblPriceTagIcon;
	private JLabel lblTop;
	private JLabel lblBody;
	private JLabel lblBottom;
	// 토글버튼들을 for문을 통해 제어하기 위한 토글버튼 배열.


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatChoose frame = new SeatChoose();
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
	public SeatChoose() {
		setTitle("자유석 좌석 선택");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				disableSeatLabel();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<(상품가격표 닫기 x표시 눌러도 창전체가 닫히지 않는 액션추가)
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPriceTagIcon());
		contentPane.add(getLblLogout());
		contentPane.add(getLblAllView());
		contentPane.add(getLblFree01());
		contentPane.add(getLblFree02());
		contentPane.add(getLblFree03());
		contentPane.add(getLblFree04());
		contentPane.add(getLblFree05());
		contentPane.add(getLblFree06());
		contentPane.add(getLblFree07());
		contentPane.add(getLblFree08());
		contentPane.add(getLblFree09());
		contentPane.add(getLblFree10());
		contentPane.add(getLblFree11());
		contentPane.add(getLblFree12());
		contentPane.add(getLblFree13());
		contentPane.add(getLblFree14());
		contentPane.add(getLblFree15());
		contentPane.add(getLblFree16());
		contentPane.add(getLblFree17());
		contentPane.add(getLblFree18());
		contentPane.add(getLblFree19());
		contentPane.add(getLblFree20());
		contentPane.add(getLblFree21());
		contentPane.add(getLblFree22());
		contentPane.add(getLblSeatView());
		contentPane.add(getLblBackIcon());
		contentPane.add(getLblTop());
		contentPane.add(getLblBody());
		contentPane.add(getLblBottom());
	}
	
	private JLabel getLblLogout() {
		if (lblLogout == null) {
			lblLogout = new JLabel("");
			lblLogout.setBounds(407, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "LogOutIcon.png");
			lblLogout.setIcon(image.resizeImage());
			lblLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Login().setVisible(true);
				}
			});
			lblLogout.setOpaque(true);
			lblLogout.setBackground(new Color(176, 180, 192));
		}
		return lblLogout;
	}
	private JLabel getLblBackIcon() {
		if (lblBackIcon == null) {
			lblBackIcon = new JLabel("");
			lblBackIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Choose().setVisible(true);
				}
			});
			lblBackIcon.setOpaque(true);
			lblBackIcon.setBackground(new Color(176, 180, 192));
			lblBackIcon.setBounds(476, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "GoBackIcon.png");
			lblBackIcon.setIcon(image.resizeImage());
			
		}
		return lblBackIcon;
	}
	private JLabel getLblSeatView() {
		if (lblSeatView == null) {
			lblSeatView = new JLabel("");
			lblSeatView.setBounds(6, 381, 588, 362);
			ImageResize image = new ImageResize(588, 362, "SeatChooseViewTextX.png");
			lblSeatView.setIcon(image.resizeImage());
		}
		return lblSeatView;
	}
	private JLabel getLblAllView() {
		if (lblAllView == null) {
			lblAllView = new JLabel("전체조감도");
			lblAllView.setBounds(8, 216, 250, 140);
			ImageResize image = new ImageResize(250, 140, "AllSeatView.png");
			lblAllView.setIcon(image.resizeImage());
		}
		return lblAllView;
	}
	private JLabel getLblFree01() {
		if (lblFree01 == null) {
			lblFree01 = new JLabel("Free01");
			
			lblFree01.setBounds(8, 383, 42, 42);
			
		}
		return lblFree01;
	}

	private JLabel getLblFree02() {
		if (lblFree02 == null) {
			lblFree02 = new JLabel("Free02");
			
			lblFree02.setBounds(53, 383, 42, 42);
		}
		return lblFree02;
	}
	private JLabel getLblFree03() {
		if (lblFree03 == null) {
			lblFree03 = new JLabel("Free03");
			
			lblFree03.setBounds(96, 383, 42, 42);
			
		}
		return lblFree03;
	}
	private JLabel getLblFree04() {
		if (lblFree04 == null) {
			lblFree04 = new JLabel("Free04");
			
			lblFree04.setBounds(139, 383, 42, 42);
		}
		return lblFree04;
	}
	private JLabel getLblFree05() {
		if (lblFree05 == null) {
			lblFree05 = new JLabel("Free05");
			
			lblFree05.setBounds(182, 383, 42, 42);
		}
		return lblFree05;
	}
	private JLabel getLblFree06() {
		if (lblFree06 == null) {
			lblFree06 = new JLabel("Free06");
			
			lblFree06.setBounds(227, 383, 42, 42);
		}
		return lblFree06;
	}
	private JLabel getLblFree07() {
		if (lblFree07 == null) {
			lblFree07 = new JLabel("Free07");
			
			lblFree07.setBounds(270, 383, 42, 42);
		}
		return lblFree07;
	}
	private JLabel getLblFree08() {
		if (lblFree08 == null) {
			lblFree08 = new JLabel("Free08");
			
			lblFree08.setBounds(312, 383, 42, 42);
		}
		return lblFree08;
	}
	private JLabel getLblFree09() {
		if (lblFree09 == null) {
			lblFree09 = new JLabel("Free09");
			
			lblFree09.setBounds(355, 383, 42, 42);
		}
		return lblFree09;
	}
	private JLabel getLblFree10() {
		if (lblFree10 == null) {
			lblFree10 = new JLabel("Free10");
			
			lblFree10.setBounds(398, 383, 42, 42);
		}
		return lblFree10;
	}
	private JLabel getLblFree11() {
		if (lblFree11 == null) {
			lblFree11 = new JLabel("Free11");
			
			lblFree11.setBounds(442, 383, 42, 42);
		}
		return lblFree11;
	}
	private JLabel getLblFree12() {
		if (lblFree12 == null) {
			lblFree12 = new JLabel("Free12");
			
			lblFree12.setBounds(485, 383, 42, 42);
		}
		return lblFree12;
	}
	private JLabel getLblFree13() {
		if (lblFree13 == null) {
			lblFree13 = new JLabel("Free13");
			
			lblFree13.setBounds(95, 699, 42, 42);
		}
		return lblFree13;
	}
	private JLabel getLblFree14() {
		if (lblFree14 == null) {
			lblFree14 = new JLabel("Free14");
			
			lblFree14.setBounds(138, 699, 42, 42);
		}
		return lblFree14;
	}
	private JLabel getLblFree15() {
		if (lblFree15 == null) {
			lblFree15 = new JLabel("Free15");
			
			lblFree15.setBounds(181, 699, 42, 42);
		}
		return lblFree15;
	}
	private JLabel getLblFree16() {
		if (lblFree16 == null) {
			lblFree16 = new JLabel("Free16");
			lblFree16.setBounds(225, 699, 42, 42);
			
		}
		return lblFree16;
	}
	private JLabel getLblFree17() {
		if (lblFree17 == null) {
			lblFree17 = new JLabel("Free17");
			
			lblFree17.setBounds(269, 699, 43, 43);
		}
		return lblFree17;
	}
	private JLabel getLblFree18() {
		if (lblFree18 == null) {
			lblFree18 = new JLabel("Free18");
			
			lblFree18.setBounds(312, 699, 42, 42);
		}
		return lblFree18;
	}
	private JLabel getLblFree19() {
		if (lblFree19 == null) {
			lblFree19 = new JLabel("Free19");
			
			lblFree19.setBounds(355, 699, 42, 42);
		}
		return lblFree19;
	}
	private JLabel getLblFree20() {
		if (lblFree20 == null) {
			lblFree20 = new JLabel("Free20");
			
			lblFree20.setBounds(399, 699, 42, 42);
		}
		return lblFree20;
	}
	private JLabel getLblFree21() {
		if (lblFree21 == null) {
			lblFree21 = new JLabel("Free21");
			
			lblFree21.setBounds(442, 699, 42, 42);
		}
		return lblFree21;
	}
	private JLabel getLblFree22() {
		if (lblFree22 == null) {
			lblFree22 = new JLabel("Free22");
			
			lblFree22.setBounds(486, 699, 42, 42);
		}
		return lblFree22;
	}
	
	// ------- Function -------
	
//	// 현재 이미 사용중인 좌석의 버튼 비활성화 및 색 변경
//	private void disableSeatButton() {
//		ArrayList<Boolean> test = new ArrayList<>();
//		test.add(true);
//		test.add(false);
//		test.add(true);
//		test.add(true);
//		test.add(false);
//		test.add(true);
//		test.add(true);
//		test.add(true);
//		test.add(false);
//		test.add(true);
//		test.add(true);
//		test.add(true);
//		
//		for (int i = 0; i < test.size(); i++) {
//			JLabel jlbl = lblFree[i];
//	        if (!test.get(i)) {
//	        	jlbl.setBackground(new Color(255, 160, 122));
//	        	jlbl.setEnabled(false);
//	        }
//	    }
//
//		// 라벨 초기화
//		for (int i = 0; i < lblFree.length; i++) {
//		    lblFree[i] = new JLabel();
//		}
//	
//		// ActionListener 적용
//		for (int i = 0; i < lblFree.length; i++) {
//		    final int index = i;  // ActionListener 내부에서 사용하기 위한 변수
//	
//		    lblFree[i].addMouseListener(new MouseAdapter() {
//		        @Override
//		        public void mouseClicked(MouseEvent e) {
//		            ShareVar.freeSeatNum = lblFree[index].getText();
//		        }
//		    });
//		}
//	}
	// 라벨의 값이 차있을때는 누르지 못하게 해야한다.
		private void setLabelText(JLabel label) {
		    ShareVar.labelText = label.getText();
		    new SeatTimeChoose().setVisible(true);
		    dispose();
		}
	
	
		private void disableSeatLabel() {
			JLabel tbtns[] = { lblFree01, lblFree02, lblFree03, lblFree04, lblFree05, lblFree06, lblFree07, lblFree08,
							   lblFree09, lblFree10, lblFree11, lblFree12, lblFree13, lblFree14, lblFree15, lblFree16,
							   lblFree17, lblFree18, lblFree19, lblFree20, lblFree21, lblFree22};
			SeatDao SeatDao = new SeatDao();
			ArrayList<Integer> SeatStatus = SeatDao.getSeatStatus();
			for (int i = 0; i < SeatStatus.size(); i++) {
				if (SeatStatus.get(i) == 0) {
					tbtns[i].setBackground(new Color(255, 160, 122));
					tbtns[i].setEnabled(false);
					tbtns[i].setOpaque(true);
				}else {
					JLabel l= tbtns[i];
					tbtns[i].addMouseListener(new MouseAdapter() {
		                @Override
		                public void mouseClicked(MouseEvent e) {
		                	System.out.println(1);
		                	setLabelText(l);
		                }
		            });
		        }
		    }
		}
	
	
	private JLabel getLblPriceTagIcon() {
		if (lblPriceTagIcon == null) {
			lblPriceTagIcon = new JLabel("");
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
	private JLabel getLblTop() {
		if (lblTop == null) {
			lblTop = new JLabel("New label");
			lblTop.setBounds(0, 0, 585, 150);
			ImageResize image = new ImageResize(584, 133, "Top.jpg");
			lblTop.setIcon(image.resizeImage());
		}
		return lblTop;
	}
	private JLabel getLblBody() {
		if (lblBody == null) {
			lblBody = new JLabel("New label");
			lblBody.setBounds(0, 150, 585, 658);
			ImageResize image = new ImageResize(584, 699, "body.jpg");
			lblBody.setIcon(image.resizeImage());
		}
		return lblBody;
	}
	private JLabel getLblBottom() {
		if (lblBottom == null) {
			lblBottom = new JLabel("New label");
			lblBottom.setBounds(0, 809, 585, 150);
			ImageResize image = new ImageResize(584, 103, "Bottom.png");
			lblBottom.setIcon(image.resizeImage());
		}
		return lblBottom;
	}
}//End


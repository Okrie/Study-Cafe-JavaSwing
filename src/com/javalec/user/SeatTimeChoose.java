package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.javalec.dao.ReservedSeatDao;
import com.javalec.dao.SeatDao;
import com.javalec.dto.ReservedSeatDto;
import com.javalec.dto.SeatDto;
import com.javalec.function.ButtonColorChanger;
import com.javalec.function.ImageResize;
import com.javalec.util.ShareVar;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeatTimeChoose extends JFrame {

	private JPanel contentPane;

	private JButton btnProductPurchase;
	private JLabel lblTableImageWhite;
	private JLabel lblTableImageOrange;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblSeatId;
	private JLabel lblPriceCategory;
	private JLabel lblPurchaseDuration;
	private JLabel lblNewLabel;
	private JLabel lblPrice;
	
	
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton tglbtn01;
	private JToggleButton tglbtn02;
	private JToggleButton tglbtn03;
	private JToggleButton tglbtn04;
	private JToggleButton tglbtn05;
	private JToggleButton tglbtn06;

	ButtonColorChanger colorChanger = new ButtonColorChanger(Color.LIGHT_GRAY, Color.BLACK, Color.ORANGE, Color.WHITE);
	
	ArrayList<Boolean> SeatStatus = new ArrayList<>();
	JToggleButton tbtns[] = { tglbtn01, tglbtn02, tglbtn03, tglbtn04, tglbtn05, tglbtn06 };
	private JLabel lblTop;
	private JLabel lblbody;
	private JLabel lblBottom;
	private JLabel lblPriceTagIcon;
	private JLabel lblLogOut;
	private JLabel lblGoBackIcon;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatTimeChoose frame = new SeatTimeChoose();
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
	public SeatTimeChoose() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblPriceCategory.setVisible(false);
				lblSeatId.setVisible(false);
				btnProductPurchase.setVisible(false);
				buttonText();
				updateButtonVisibility();
				 
			}
			@Override
			public void windowClosed(WindowEvent e) {
				String current = ShareVar.labelText;
				int current1 = ShareVar.pPrice;
				String current2 = ShareVar.priceCategory;
				System.out.println(current);
				System.out.println(current1);
				System.out.println(current2);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTglbtn01());
		contentPane.add(getTglbtn04());
		contentPane.add(getTglbtn03());
		contentPane.add(getTglbtn05());
		contentPane.add(getTglbtn06());
		contentPane.add(getTglbtn02());
		contentPane.add(getBtnProductPurchase());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblPrice());
		contentPane.add(getLblPurchaseDuration());
		contentPane.add(getLblPriceCategory());
		contentPane.add(getLblSeatId());
		contentPane.add(getLblNewLabel_2_1_1());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblTableImageWhite());
		contentPane.add(getLblTableImageOrange());
		contentPane.add(getLblPriceTagIcon());
		contentPane.add(getLblLogOut());
		contentPane.add(getLblGoBackIcon());
		contentPane.add(getLblTop());
		contentPane.add(getLblbody());
		contentPane.add(getLblBottom());
		
		/*
		
		// ActionListener 등록 6개
	    tglbtn01.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn01.getText();
	           
	        }
	    });
	    tglbtn02.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn02.getText();
	        }
	    });
	    tglbtn03.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn03.getText();
	        }
	    });
	    tglbtn04.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn04.getText();
	        }
	    });
	    tglbtn05.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn05.getText();
	        }
	    });
	    tglbtn06.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn06.getText();
	        }
	    });
	    */
	}
	private JToggleButton getTglbtn01() {
		if (tglbtn01 == null) {
			tglbtn01 = new JToggleButton("");
			tglbtn01.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnProductPurchase.setVisible(true);
					whenButtonClicked(tglbtn01);
				}
			});
			buttonGroup.add(tglbtn01);
			tglbtn01.setBounds(41, 270, 150, 50);
		}
		return tglbtn01;
	}
	private JToggleButton getTglbtn02() {
		if (tglbtn02 == null) {
			tglbtn02 = new JToggleButton("");
			tglbtn02.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnProductPurchase.setVisible(true);
					whenButtonClicked(tglbtn02);
				}
			});
			buttonGroup.add(tglbtn02);
			tglbtn02.setBounds(219, 270, 150, 50);
		}
		return tglbtn02;
	}
	private JToggleButton getTglbtn03() {
		if (tglbtn03 == null) {
			tglbtn03 = new JToggleButton("");
			tglbtn03.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnProductPurchase.setVisible(true);
					whenButtonClicked(tglbtn03);
				}
			});
			buttonGroup.add(tglbtn03);
			tglbtn03.setBounds(395, 270, 150, 50);
		}
		return tglbtn03;
	}
	private JToggleButton getTglbtn04() {
		if (tglbtn04 == null) {
			tglbtn04 = new JToggleButton("");
			tglbtn04.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnProductPurchase.setVisible(true);
					whenButtonClicked(tglbtn04);
				}
			});
			buttonGroup.add(tglbtn04);
			tglbtn04.setBounds(41, 332, 150, 50);
		}
		return tglbtn04;
	}
	private JToggleButton getTglbtn05() {
		if (tglbtn05 == null) {
			tglbtn05 = new JToggleButton("");
			tglbtn05.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnProductPurchase.setVisible(true);
					whenButtonClicked(tglbtn05);
				}
			});
			buttonGroup.add(tglbtn05);
			tglbtn05.setBounds(219, 332, 150, 50);
		}
		return tglbtn05;
	}
	private JToggleButton getTglbtn06() {
		if (tglbtn06 == null) {
			tglbtn06 = new JToggleButton("");
			tglbtn06.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnProductPurchase.setVisible(true);
					whenButtonClicked(tglbtn06);
				}
			});
			buttonGroup.add(tglbtn06);
			tglbtn06.setBounds(395, 332, 150, 50);
		}
		return tglbtn06;
	}
	
	private JButton getBtnProductPurchase() {
		if (btnProductPurchase == null) {
			btnProductPurchase = new JButton("상품구매");
			btnProductPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Payment().setVisible(true);;
				}
			});
			btnProductPurchase.setForeground(Color.BLACK);
			btnProductPurchase.setBackground(new Color(111, 114, 112));
			btnProductPurchase.setBounds(211, 679, 150, 50);
			btnProductPurchase.setOpaque(true);
		}
		return btnProductPurchase;
	}
	private JLabel getLblTableImageWhite() {
		if (lblTableImageWhite == null) {
			lblTableImageWhite = new JLabel("");
			lblTableImageWhite.setBackground(new Color(255, 255, 254));
			lblTableImageWhite.setIcon(null);
			lblTableImageWhite.setBounds(41, 411, 521, 179);
			lblTableImageWhite.setOpaque(true);
		}
		return lblTableImageWhite;
	}
	private JLabel getLblTableImageOrange() {
		if (lblTableImageOrange == null) {
			lblTableImageOrange = new JLabel("");
			lblTableImageOrange.setBackground(Color.DARK_GRAY);
			lblTableImageOrange.setBounds(41, 589, 521, 44);
			lblTableImageOrange.setOpaque(true);
		}
		return lblTableImageOrange;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("좌석타입 :");
			lblNewLabel_2.setBounds(62, 440, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("상품종류 :");
			lblNewLabel_2_1.setBounds(62, 475, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("이용시간 :");
			lblNewLabel_2_1_1.setBounds(62, 510, 61, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblSeatId() {
		if (lblSeatId == null) {
			lblSeatId = new JLabel("자유석");
			lblSeatId.setBounds(155, 440, 61, 16);
		}
		return lblSeatId;
	}
	private JLabel getLblPriceCategory() {
		if (lblPriceCategory == null) {
			lblPriceCategory = new JLabel("시간권");
			lblPriceCategory.setBounds(155, 475, 61, 16);
		}
		return lblPriceCategory;
	}
	private JLabel getLblPurchaseDuration() {
		if (lblPurchaseDuration == null) {
			lblPurchaseDuration = new JLabel("");
			lblPurchaseDuration.setBounds(155, 510, 61, 16);
		}
		return lblPurchaseDuration;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("결제금액 :");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(62, 602, 134, 22);
		}
		return lblNewLabel;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("");
			lblPrice.setForeground(Color.WHITE);
			lblPrice.setBounds(155, 603, 134, 22);
		}
		return lblPrice;
	}
	
	
	// Function
	
	
	private void updateButtonVisibility() {
		if (tglbtn01 != null) {
		 if (tglbtn01.getText().isEmpty()) {
			 tglbtn01.setVisible(false);
         } else {
        	 tglbtn01.setVisible(true);
         }
		}
		if (tglbtn02 != null) { 
		 if (tglbtn02.getText().isEmpty()) {
			 tglbtn02.setVisible(false);
			 } else {
				 tglbtn02.setVisible(true);
            }
		}
		if (tglbtn03 != null) { 
		 if (tglbtn03.getText().isEmpty()) {
			 tglbtn03.setVisible(false);
            } else {
            tglbtn03.setVisible(true);
            }
		}
		if (tglbtn04 != null) {
		 if (tglbtn04.getText().isEmpty()) {
			 tglbtn04.setVisible(false);
         } else {
        	 tglbtn04.setVisible(true);
         }
		}
		if (tglbtn05 != null) {
		 if (tglbtn05.getText().isEmpty()) {
			 tglbtn05.setVisible(false);
         } else {
        	 tglbtn05.setVisible(true);
         }
		}
		if (tglbtn06 != null) { 
		 if (tglbtn06.getText().isEmpty()) {
			 tglbtn06.setVisible(false);
         } else {
        	 tglbtn06.setVisible(true);
         }
		}
	}
	
	
	// lbl을 초기화
	
	private void clearColumn() {
		lblPrice.setText("");
		lblSeatId.setText("");
		lblPurchaseDuration.setText("");
		lblPriceCategory.setText("");
		}

	
	 
	private void buttonText() {        
	    SeatDao SeatDao = new SeatDao();
	    ArrayList<SeatDto> dtoList = SeatDao.getButtonData();
	    int buttonCount = dtoList.size();
	    
	    for (int i = 0; i < buttonCount; i++) {
	    	SeatDto dto = dtoList.get(i);
	        int priceCategory = Integer.parseInt(dto.getPriceCategory());
	        int dividedPriceCategory = priceCategory;
	        String buttonText = dividedPriceCategory + "시간 (" + dto.getTimeprice() + "원)";
	        JToggleButton button = getToggleButtonByIndex(i);
	        if (button != null) {
	            button.setText(buttonText);
	        }
	    }
	}
	private JToggleButton getToggleButtonByIndex(int index) {
	    switch (index) {
	        case 0:
	            return tglbtn01;
	        case 1:
	            return tglbtn02;
	        case 2:
	            return tglbtn03;
	        case 3:
	            return tglbtn04;
	        case 4:
	            return tglbtn05;
	        case 5:
	            return tglbtn06;
	        // 필요한 버튼 인덱스에 따라 추가적인 case를 작성할 수 있습니다.
	        default:
	            return null;
	    }
	}
	
	
	
	// ~주 앞에 숫자를 가져오는 방법
	private void whenButtonClicked(JToggleButton button) {
		
	    String buttonText = button.getText();
	    String numberString = buttonText.substring(0, buttonText.indexOf("시간")); // '주' 앞에 적힌 숫자 추출
	    int number = Integer.parseInt(numberString); // 추출된 숫자를 정수로 변환
	   
	    // 추출된 숫자를 활용하여 데이터베이스에서 값을 가져오는 작업 수행
	    SeatDao SeatDao = new SeatDao();
	    SeatDto seatDto = SeatDao.getDataByNumber(number, "Free");

	    //라벨 위에 올릴때는 불러온값을 24로 나눠줘야함
	    String priceCategoryString = seatDto.gettime();
	    int priceCategory = Integer.parseInt(priceCategoryString);
	    // 가져온 값으로 라벨 등에 값을 설정
	    lblPurchaseDuration.setText(priceCategory+"시간");
	    ShareVar.priceCategory = "FreeTime"+priceCategory;
	//    ShareVar.PriceCategory = "ReservedDate" +Integer.parseInt(newPriceCategoryString)*7;
	//    ShareVar.WhiceCategory = "ReservedDate";
	//    ShareVar.HowMuchTime = newPriceCategoryString+"주";
	    lblPrice.setText(Integer.toString(seatDto.getTimeprice())+"원");
	    ShareVar.pPrice =seatDto.getTimeprice();
	    lblPriceCategory.setVisible(true);
	    lblSeatId.setVisible(true);
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
	private JLabel getLblbody() {
		if (lblbody == null) {
			lblbody = new JLabel("New label");
			lblbody.setBounds(0, 150, 585, 658);
			ImageResize image = new ImageResize(584, 699, "body.jpg");
			lblbody.setIcon(image.resizeImage());
		}
		return lblbody;
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
	private JLabel getLblLogOut() {
		if (lblLogOut == null) {
			lblLogOut = new JLabel("New label");
			lblLogOut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Login().setVisible(true);
				}
			});
			lblLogOut.setBounds(407, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "LogOutIcon.png");
			lblLogOut.setIcon(image.resizeImage());
		}
		return lblLogOut;
	}
	private JLabel getLblGoBackIcon() {
		if (lblGoBackIcon == null) {
			lblGoBackIcon = new JLabel("New label");
			lblGoBackIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new SeatChoose().setVisible(true);
					dispose();
				}
			});
			lblGoBackIcon.setBounds(476, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "GoBackIcon.png");
			lblGoBackIcon.setIcon(image.resizeImage());
		}
		return lblGoBackIcon;
	}
} // End

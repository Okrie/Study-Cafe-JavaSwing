package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.javalec.dao.ReservedSeatDao;
import com.javalec.dto.ReservedSeatDto;
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

public class ReservedSeatTimeChoose extends JFrame {

	private JPanel contentPane;

	private JButton btnProductPurchase;
	private JLabel lblTableImageWhite;
	private JLabel lblTableImage;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblRsSeatId;
	private JLabel lblPriceCategory;
	private JLabel lblPurchaseDuration;
	private JLabel lblNewLabel;
	private JLabel lblPrice;
	
	
	LocalDateTime dateTime = LocalDateTime.now();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton tglbtn01;
	private JToggleButton tglbtn02;
	private JToggleButton tglbtn03;
	private JToggleButton tglbtn04;
	private JToggleButton tglbtn05;
	private JToggleButton tglbtn06;

	
	ArrayList<Boolean> rsSeatStatus = new ArrayList<>();
	JToggleButton tbtns[] = { tglbtn01, tglbtn02, tglbtn03, tglbtn04, tglbtn05, tglbtn06 };
	private JLabel lblPriceTagIcon;
	private JLabel lblLogOut;
	private JLabel lblGoBackIcon;
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
					ReservedSeatTimeChoose frame = new ReservedSeatTimeChoose();
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
	public ReservedSeatTimeChoose() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblPriceCategory.setVisible(false);
				lblRsSeatId.setVisible(false);
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
		contentPane.setBackground(new Color(249, 255, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnProductPurchase());
		contentPane.add(getLblPriceTagIcon());
		contentPane.add(getLblGoBackIcon());
		contentPane.add(getLblLogOut());
		contentPane.add(getTglbtn01());
		contentPane.add(getTglbtn04());
		contentPane.add(getTglbtn03());
		contentPane.add(getTglbtn05());
		contentPane.add(getTglbtn06());
		contentPane.add(getTglbtn02());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblPrice());
		contentPane.add(getLblPurchaseDuration());
		contentPane.add(getLblPriceCategory());
		contentPane.add(getLblRsSeatId());
		contentPane.add(getLblNewLabel_2_1_1());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblTableImageWhite());
		contentPane.add(getLblTableImage());
		contentPane.add(getLblbody());
		contentPane.add(getLblTop());
		contentPane.add(getLblBottom());
	}
		// ActionListener 등록 6개
		/*
	    tglbtn01.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn01.getText();
	            //System.out.println(ShareVar.rsSeatNum);
	        }
	    });
	    tglbtn02.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn02.getText();
	            //System.out.println(ShareVar.rsSeatNum);
	        }
	    });
	    tglbtn03.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn03.getText();
	            //System.out.println(ShareVar.rsSeatNum);
	        }
	    });
	    tglbtn04.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn04.getText();
	            //System.out.println(ShareVar.rsSeatNum);
	        }
	    });
	    tglbtn05.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn05.getText();
	            //System.out.println(ShareVar.rsSeatNum);
	        }
	    });
	    tglbtn06.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ShareVar.labelText = tglbtn06.getText();
	            //System.out.println(ShareVar.rsSeatNum);
	        }
	    });
	    
	}
	*/
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
					new Payment().main(null);
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
	private JLabel getLblTableImage() {
		if (lblTableImage == null) {
			lblTableImage = new JLabel("");
			lblTableImage.setBackground(Color.DARK_GRAY);
			lblTableImage.setBounds(41, 589, 521, 44);
			lblTableImage.setOpaque(true);
		}
		return lblTableImage;
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
	private JLabel getLblRsSeatId() {
		if (lblRsSeatId == null) {
			lblRsSeatId = new JLabel("지정석");
			lblRsSeatId.setBounds(155, 440, 61, 16);
		}
		return lblRsSeatId;
	}
	private JLabel getLblPriceCategory() {
		if (lblPriceCategory == null) {
			lblPriceCategory = new JLabel("기간권");
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
			lblNewLabel.setBackground(new Color(0, 0, 0));
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
	
	/* 순서부터 정하자
	 * 1.버튼을 누르면 좌석, 상품종류, 이용시간, 결제금액을 DB에서 받아와서 txfield에 옮겨준다.
	 * 2.그리고 밑에 상품구매 버튼이 떠야해 
	 * 3.상품 구매 버튼을 누르면 Payment로 넘어가야하
	 */
	
	//버튼에 글자가 적혀있으면 나오게 해준다
	
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
	
	/*
	private void disableReservedSeat() {
		ReservedSeatDao rsSeatDao = new ReservedSeatDao();
		ArrayList<Boolean> rsSeatStatus = rsSeatDao.getRsSeatStatus();
		
		for(int i=0; i<rsSeatStatus.size(); i++) {
			JToggleButton tbtn = tbtns[i];
			if(rsSeatStatus.get(i) == false) {
				tbtn.setBackground(new Color(239, 143, 52));
				tbtn.disable();
			}
		}
	}
	*/
	
	// lbl을 초기화 시켜주는 녀석
	
	private void clearColumn() {
		lblPrice.setText("");
		lblRsSeatId.setText("");
		lblPurchaseDuration.setText("");
		lblPriceCategory.setText("");
		}

	
	 // 버튼 클릭 했을 때 밑에 Label쪽에 어떤 값인지 정해주는 녀석들
/*	
	private void buttonClick() {
		int i = innerTable.getSelectedRow(); 
		String wkPcode = (String) innerTable.getValueAt(i, 1);
		
		
		ReservedSeatDao dao = new AdminDao(wkPcode);
		ReservedSeatDto dto = dao.tableClick();
		tfCode.setText(dto.getPcode());
		lblRsSeatId.setText(dto.getName());
		lblPriceCategory.setText(dto.getCategory());
		lblPurchaseDuration.setText(Integer.toString(dto.getPstock()));
		lblPrice.setText(Integer.toString(dto.getPrice()));
	}
	
*/	 
	 
	 
	 /* 버튼 안에 데이터 베이스에서 불러와서 글자를 넣어줘야한다.
	  * 어떻게?
	  * from 지성석(productid=reservedSeat)을 골라서, 기간제(pricecategoryid=기간제)
	  *   String query = "SELECT pd.productid, pt.pricecategory, pt.pircecategory, pt.picetable";
	        String query1 = " FROM product pd, pricetabe pt, purchase pur  where pd.productid = pur.productid and pt.productid = pur.productid";
	        String query2 = " GROUP BY pt.pricetable;";
	  */
	private void buttonText() {        
	    ReservedSeatDao reservedSeatDao = new ReservedSeatDao();
	    ArrayList<ReservedSeatDto> dtoList = reservedSeatDao.getButtonData();
	    int buttonCount = dtoList.size();
	    
	    for (int i = 0; i < buttonCount; i++) {
	        ReservedSeatDto dto = dtoList.get(i);
	        int priceCategory = Integer.parseInt(dto.getPriceCategory());
	        int dividedPriceCategory = priceCategory / 7;
	        String buttonText = dividedPriceCategory + "주 (" + dto.getTimeprice() + "원)";
	//        ShareVar.HowMuchIsIt = dto.getTimeprice()+"원";
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
/*		
	private void lblText() {
		
		
		ReservedSeatDao reservedSeatDao = new ReservedSeatDao();
		ReservedSeatDto reservedDto = reservedSeatDao.getLabelData();
		lblRsSeatId.setText(reservedDto.getProductid());
		lblPriceCategory.setText(reservedDto.getPriceCategory());
		lblPurchaseDuration.setText(reservedDto.getPurchaseduration());
		lblPrice.setText(Integer.toString(reservedDto.getTimeprice()));
	}
*/
	
	
	
	// ~주 이런식으로 적힌 글자에서 주 앞에 숫자를 가져오는 방법
	private void whenButtonClicked(JToggleButton button) {
		
	    String buttonText = button.getText();
	    String numberString = buttonText.substring(0, buttonText.indexOf("주")); // '주' 앞에 적힌 숫자 추출
	    int number = Integer.parseInt(numberString); // 추출된 숫자를 정수로 변환

	    // 추출된 숫자를 활용하여 데이터베이스에서 값을 가져오는 작업 수행
	    ReservedSeatDao reservedSeatDao = new ReservedSeatDao();
	    ReservedSeatDto reservedDto = reservedSeatDao.getDataByNumber(number, "Fixed");

	    //라벨 위에 올릴때는 불러온값을 7로 나눠줘야함
	    String priceCategoryString = reservedDto.getPriceCategory();
	    int priceCategory = Integer.parseInt(priceCategoryString);
	    int dividedPriceCategory = priceCategory / 7;
	    String newPriceCategoryString = String.valueOf(dividedPriceCategory);
	    // 가져온 값으로 라벨 등에 값을 설정
	    lblPurchaseDuration.setText(newPriceCategoryString+"주");
	    ShareVar.priceCategory = "FixedDate" +Integer.parseInt(newPriceCategoryString)*7;
	//    ShareVar.WhiceCategory = "ReservedDate";
	//    ShareVar.HowMuchTime = newPriceCategoryString+"주";
	    lblPrice.setText(Integer.toString(reservedDto.getTimeprice())+"원");
	    ShareVar.pPrice = reservedDto.getTimeprice();
	    lblPriceCategory.setVisible(true);
	    lblRsSeatId.setVisible(true);
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
					new Login().main(null);
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
					new ReservedSeatChoose().main(null);
					dispose();
				}
			});
			lblGoBackIcon.setBounds(476, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "GoBackIcon.png");
			lblGoBackIcon.setIcon(image.resizeImage());
		}
		return lblGoBackIcon;
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
} // End

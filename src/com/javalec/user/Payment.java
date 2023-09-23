package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.CabinetDao;
import com.javalec.dao.PaymentDao;
import com.javalec.dto.CabinetDto;
import com.javalec.function.ImageResize;
import com.javalec.util.ShareVar;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Font;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnLogout;
	private JLabel lbLogout;
	private JLabel lbSeatImage;
	private JLabel lbBack;
	private JLabel lblTableImageOrange;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2;
	private JLabel lblTableImageWhite;
	private JButton btnProductPurchase;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lbCustomerID;
	private JLabel lbProductID;
	private JLabel lbPurchaseTime;
	private JLabel lbDuration;
	private JLabel lbPprice;
	private static Payment instance;
	private JLabel lbTop;
	private JLabel lbBody;
	private JLabel lbBottom;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		instance = this;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setPurchaseInfo();
			}
		});
		setTitle("결제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbBack());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2_1_1());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getBtnProductPurchase());
		contentPane.add(getLblNewLabel_2_1_1_1());
		contentPane.add(getLbCustomerID());
		contentPane.add(getLbProductID());
		contentPane.add(getLbPurchaseTime());
		contentPane.add(getLbDuration());
		contentPane.add(getLblTableImageWhite());
		contentPane.add(getLbPprice());
		contentPane.add(getLblTableImageOrange());
		contentPane.add(getLbSeatImage());
		contentPane.add(getLbLogout());
		contentPane.add(getLbTop());
		contentPane.add(getLbBody());
		contentPane.add(getLbBottom());
	}
	private JLabel getLbLogout() {
		if (lbLogout == null) {
			lbLogout = new JLabel("");
			ImageResize icon = new ImageResize(70,60,"LogoutIcon.png");
			lbLogout.setIcon(icon.resizeImage());
			lbLogout.setBounds(407, 187, 70, 60);
			lbLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Login().main(null);
				}
			});
			lbLogout.setBackground(Color.LIGHT_GRAY);
			lbLogout.setHorizontalAlignment(SwingConstants.CENTER);
			lbLogout.setOpaque(true);
		}
		return lbLogout;
	}
	private JLabel getLbSeatImage() {
		if (lbSeatImage == null) {
			lbSeatImage = new JLabel("");
			ImageResize icon = new ImageResize(70,60,"PriceTagIcon.png");
			lbSeatImage.setIcon(icon.resizeImage());
			lbSeatImage.setBounds(336, 187, 70, 60);
			lbSeatImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new SeatPriceTag().main(null);
				}
			});
			lbSeatImage.setHorizontalAlignment(SwingConstants.CENTER);
			lbSeatImage.setBackground(Color.LIGHT_GRAY);
			lbSeatImage.setOpaque(true);
		}
		return lbSeatImage;
	}
	private JLabel getLbBack() {
		if (lbBack == null) {
			lbBack = new JLabel("");
			ImageResize icon = new ImageResize(70,60,"GoBackIcon.png");
			lbBack.setIcon(icon.resizeImage());
			lbBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					String whatProduct = ShareVar.labelText;
					if(whatProduct.contains("Cabinet")) {
						new CabinetTimeChoose().main(null);
					}else if(whatProduct.contains("Free")){
						new SeatTimeChoose().main(null);
					}else if(whatProduct.contains("Fixed")) {
						new ReservedSeatTimeChoose().main(null);
					}else {
						new RoomTimeChoose().main(null);
					}
				}
			});
			lbBack.setOpaque(true);
			lbBack.setHorizontalAlignment(SwingConstants.CENTER);
			lbBack.setBackground(Color.LIGHT_GRAY);
			lbBack.setBounds(476, 187, 70, 60);
			
		}
		return lbBack;
	}
	private JLabel getLblTableImageOrange() {
		if (lblTableImageOrange == null) {
			lblTableImageOrange = new JLabel("");
			lblTableImageOrange.setOpaque(true);
			lblTableImageOrange.setBackground(Color.DARK_GRAY);
			lblTableImageOrange.setBounds(33, 555, 521, 44);
		}
		return lblTableImageOrange;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("결제 금액 :");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(54, 568, 61, 22);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("구매 기간 :");
			lblNewLabel_2_1_1.setBounds(54, 476, 61, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("좌석 번호 :");
			lblNewLabel_2_1.setBounds(54, 441, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("사용자 ID :");
			lblNewLabel_2.setBounds(54, 406, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblTableImageWhite() {
		if (lblTableImageWhite == null) {
			lblTableImageWhite = new JLabel("");
			lblTableImageWhite.setOpaque(true);
			lblTableImageWhite.setBackground(new Color(255, 255, 254));
			lblTableImageWhite.setBounds(33, 377, 521, 179);
		}
		return lblTableImageWhite;
	}
	private JButton getBtnProductPurchase() {
		if (btnProductPurchase == null) {
			btnProductPurchase = new JButton("결제");
			btnProductPurchase.setFont(new Font("굴림", Font.PLAIN, 20));
			btnProductPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertOrder();
//					dispose();
					updateStatus();
					new Last().setVisible(true);
				}
			});
			btnProductPurchase.setForeground(Color.WHITE);
			btnProductPurchase.setBackground(Color.BLACK);
			btnProductPurchase.setBounds(208, 678, 150, 50);
		}
		return btnProductPurchase;
	}
	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("이용 기간 :");
			lblNewLabel_2_1_1_1.setBounds(54, 514, 61, 16);
		}
		return lblNewLabel_2_1_1_1;
	}
	private JLabel getLbCustomerID() {
		if (lbCustomerID == null) {
			lbCustomerID = new JLabel("New label");
			lbCustomerID.setBounds(155, 407, 141, 15);
		}
		return lbCustomerID;
	}
	private JLabel getLbProductID() {
		if (lbProductID == null) {
			lbProductID = new JLabel("New label");
			lbProductID.setBounds(155, 442, 150, 15);
		}
		return lbProductID;
	}
	private JLabel getLbPurchaseTime() {
		if (lbPurchaseTime == null) {
			lbPurchaseTime = new JLabel("New label");
			lbPurchaseTime.setBounds(155, 477, 162, 15);
		}
		return lbPurchaseTime;
	}
	private JLabel getLbDuration() {
		if (lbDuration == null) {
			lbDuration = new JLabel("New label");
			lbDuration.setBounds(155, 515, 268, 15);
		}
		return lbDuration;
	}
	private JLabel getLbPprice() {
		if (lbPprice == null) {
			lbPprice = new JLabel("New label");
			lbPprice.setForeground(new Color(255, 255, 255));
			lbPprice.setBounds(155, 572, 217, 15);
		}
		return lbPprice;
	}
	
	// ------- Function -------
//	private void setPurchaseInfo() {
//		ArrayList<CabinetDto> list = new ArrayList<>();
//		CabinetDao cabinetDao = new CabinetDao();
//		list = cabinetDao.getCabinetPriceTable();
//		
//		int calctime = 0;
//		
//		for(int i=0; i<list.size(); i++) { // 현재 저장된 카테고리의 calctime 컬럼 데이터를 가져오기 위함.
//			if(ShareVar.priceCategory.equals(list.get(i).getPricecategory())) {
//				calctime = list.get(i).getCalctime();
//			}
//		}
//		
//		if(calctime < 24) {
//			lbPurchaseTime.setText(Integer.toString(calctime) + "시간");
//		}else {
//			lbPurchaseTime.setText(Integer.toString(calctime/24) + "일");
//		}
//		
//		lbCustomerID.setText(ShareVar.id);
//		lbProductID.setText(ShareVar.labelText);
//		lbPprice.setText(Integer.toString(ShareVar.pPrice) + "원");
//		lbDuration.setText(usingDuration(calctime));
//	}
	
	private void setPurchaseInfo() {
		PaymentDao paymentDao = new PaymentDao();
		
		int calctime = paymentDao.getCalcTime();
		
		if(calctime < 24) {
			lbPurchaseTime.setText(Integer.toString(calctime) + "시간");
		}else {
			lbPurchaseTime.setText(Integer.toString(calctime/24) + "일");
		}
		
		lbCustomerID.setText(ShareVar.id);
		lbProductID.setText(ShareVar.labelText);
		lbPprice.setText(Integer.toString(ShareVar.pPrice) + "원");
		lbDuration.setText(usingDuration(calctime));
	}
	
	private void insertOrder() {
		PaymentDao dao = new PaymentDao(ShareVar.labelText, Integer.parseInt(ShareVar.id), ShareVar.pPrice, ShareVar.priceCategory);
		Boolean isSuccess = dao.insertOrder();
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.", "결제", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "결제 중 오류가 발생했습니다.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	private String usingDuration(int hours) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime targetDateTime = currentDateTime.plusHours(hours);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String dateTimeRange = currentDateTime.format(formatter) + " ~ " + targetDateTime.format(formatter);

		return dateTimeRange;
	}
	
	
	public static void closeWindow() {
        // 인스턴스가 null이 아니라면 창을 닫음
        if (instance != null) {
            instance.dispose();
        }
    }
	
	private void updateStatus() {
		PaymentDao dao = new PaymentDao(ShareVar.labelText, Integer.parseInt(ShareVar.id));
		dao.updateStatus();
	}
	
	
	
	
	
	private JLabel getLbTop() {
		if (lbTop == null) {
			lbTop = new JLabel("");
			ImageResize icon = new ImageResize(585, 150, "Top.jpg");
			lbTop.setIcon(icon.resizeImage());
			
			lbTop.setBounds(0, 0, 585, 150);
		}
		return lbTop;
	}
	private JLabel getLbBody() {
		if (lbBody == null) {
			lbBody = new JLabel("");
			ImageResize icon = new ImageResize(585, 658, "Body.jpg");
			lbBody.setIcon(icon.resizeImage());
			lbBody.setBounds(0, 150, 585, 658);
		}
		return lbBody;
	}
	private JLabel getLbBottom() {
		if (lbBottom == null) {
			lbBottom = new JLabel("");
			ImageResize icon = new ImageResize(585, 150, "Bottom.png");
			lbBottom.setIcon(icon.resizeImage());
			lbBottom.setBounds(0, 809, 585, 150);
		}
		return lbBottom;
	}
} // End

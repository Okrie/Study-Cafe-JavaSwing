 package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.CabinetDao;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class CabinetTimeChoose extends JFrame {

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
	private JLabel lbCabinetNum;
	private JLabel lbCabinetPurchaseDate;
	LocalDateTime dateTime = LocalDateTime.now();
	private JLabel lblNewLabel_2_1_1_2;
	private JLabel lbCabinetDuration;
	private JLabel lbCabinetPrice;
	private JToggleButton tbtnDate30;
	private JToggleButton tbtnDate60;
	private JToggleButton tbtnDate90;
	private JToggleButton tbtnDate120;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
					CabinetTimeChoose frame = new CabinetTimeChoose();
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
	public CabinetTimeChoose() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lbCabinetNum.setText(ShareVar.labelText);
				setTbtnText();
			}
		});
		setTitle("사물함 기간 선택");
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
		contentPane.add(getLbCabinetNum());
		contentPane.add(getLbCabinetPurchaseDate());
		contentPane.add(getLblNewLabel_2_1_1_2());
		contentPane.add(getLbCabinetDuration());
		contentPane.add(getLblTableImageWhite());
		contentPane.add(getLbCabinetPrice());
		contentPane.add(getLblTableImageOrange());
		contentPane.add(getTbtnDate30());
		contentPane.add(getTbtnDate60());
		contentPane.add(getTbtnDate90());
		contentPane.add(getTbtnDate120());
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
					new Payment().main(null);
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
					new CabinetChoose().main(null);
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
			lblNewLabel = new JLabel("결제금액 :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(54, 568, 79, 22);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("구매 기간 :");
			lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2_1_1.setBounds(54, 441, 79, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setBounds(54, 441, 79, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("사물함 번호 :");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(54, 406, 79, 16);
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
			btnProductPurchase = new JButton("선택");
			btnProductPurchase.setFont(new Font("굴림", Font.BOLD, 20));
			btnProductPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tbtnDate30.isSelected() || tbtnDate60.isSelected() || tbtnDate90.isSelected() || tbtnDate120.isSelected()) {
						setShareVar();
						dispose();
						new Payment().main(null);
					}else {
						JOptionPane.showMessageDialog(null, "구매할 기간을 선택해주세요.", "사물함 기간 선택", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnProductPurchase.setForeground(Color.WHITE);
			btnProductPurchase.setBackground(Color.BLACK);
			btnProductPurchase.setBounds(210, 677, 150, 50);
		}
		return btnProductPurchase;
	}
	private JLabel getLbCabinetNum() {
		if (lbCabinetNum == null) {
			lbCabinetNum = new JLabel("");
			lbCabinetNum.setBounds(155, 407, 90, 15);
		}
		return lbCabinetNum;
	}
	private JLabel getLbCabinetPurchaseDate() {
		if (lbCabinetPurchaseDate == null) {
			lbCabinetPurchaseDate = new JLabel("");
			lbCabinetPurchaseDate.setBounds(155, 442, 337, 15);
		}
		return lbCabinetPurchaseDate;
	}
	private JLabel getLblNewLabel_2_1_1_2() {
		if (lblNewLabel_2_1_1_2 == null) {
			lblNewLabel_2_1_1_2 = new JLabel("사용 기간 :");
			lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2_1_1_2.setBounds(54, 475, 79, 16);
		}
		return lblNewLabel_2_1_1_2;
	}
	private JLabel getLbCabinetDuration() {
		if (lbCabinetDuration == null) {
			lbCabinetDuration = new JLabel("");
			lbCabinetDuration.setBounds(155, 476, 337, 15);
		}
		return lbCabinetDuration;
	}
	private JLabel getLbCabinetPrice() {
		if (lbCabinetPrice == null) {
			lbCabinetPrice = new JLabel("");
			lbCabinetPrice.setForeground(new Color(255, 255, 255));
			lbCabinetPrice.setBounds(155, 572, 337, 15);
		}
		return lbCabinetPrice;
	}
	private JToggleButton getTbtnDate30() {
		if (tbtnDate30 == null) {
			tbtnDate30 = new JToggleButton("");
			tbtnDate30.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(0);
				}
			});
			buttonGroup.add(tbtnDate30);
			tbtnDate30.setBounds(46, 298, 116, 50);
		}
		return tbtnDate30;
	}
	private JToggleButton getTbtnDate60() {
		if (tbtnDate60 == null) {
			tbtnDate60 = new JToggleButton("");
			tbtnDate60.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(1);
				}
			});
			buttonGroup.add(tbtnDate60);
			tbtnDate60.setBounds(174, 298, 116, 50);
		}
		return tbtnDate60;
	}
	private JToggleButton getTbtnDate90() {
		if (tbtnDate90 == null) {
			tbtnDate90 = new JToggleButton("");
			tbtnDate90.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(2);
				}
			});
			buttonGroup.add(tbtnDate90);
			tbtnDate90.setBounds(302, 298, 116, 50);
		}
		return tbtnDate90;
	}
	private JToggleButton getTbtnDate120() {
		if (tbtnDate120 == null) {
			tbtnDate120 = new JToggleButton("");
			tbtnDate120.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(3);
				}
			});
			buttonGroup.add(tbtnDate120);
			tbtnDate120.setBounds(430, 298, 116, 50);
			tbtnDate120.setVisible(false);
		}
		return tbtnDate120;
	}
	// ------- Function -------

	
	private String usingDuration(int date) { // date를 넘겨주면 현재일자부터 +date일자까지 string으로 반환해줌.
		
		LocalDate currentDate = LocalDate.now();
        LocalDate targetDate = currentDate.plusDays(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateRange = currentDate.format(formatter) + " ~ " + targetDate.format(formatter);
        
        return dateRange;
	}

	private ArrayList<CabinetDto> setTbtnText() { // pricetable의 정보를 받아와 토글버튼에 일자 및 가격 정보 뿌려줌.
		JToggleButton tbtns[] = {tbtnDate30, tbtnDate60, tbtnDate90, tbtnDate120};
		ArrayList<CabinetDto> dtolist = new ArrayList<>();
		CabinetDao cabinetDao = new CabinetDao();
		dtolist = cabinetDao.getCabinetPriceTable();
		
		for(int i=0; i<dtolist.size(); i++) {
			String priceInfo = (dtolist.get(i).getCalctime()/24) + "일" + "(" + dtolist.get(i).getTimeprice() + "원)";
			tbtns[i].setText(priceInfo);
		}
		
		return dtolist;
	}
	
	private void setLableInfo(int index) { // 선택된 결제 정보를 받아와 label에 set해줌.
		ArrayList<CabinetDto> list = setTbtnText();
		String labelPrice = Integer.toString(list.get(index).getTimeprice());
		String labelDuration = usingDuration(list.get(index).getCalctime()/24); // 시간을 날짜로 계산
		String labelPurchaseDate = Integer.toString(list.get(index).getCalctime()/24);
		
		lbCabinetDuration.setText(labelDuration);
		lbCabinetPurchaseDate.setText(labelPurchaseDate + "일");
		lbCabinetPrice.setText(labelPrice + "원");
	}
	
	private void setShareVar() {
		ArrayList<CabinetDto> list = new ArrayList<>();
		CabinetDao cabinetDao = new CabinetDao();
		list = cabinetDao.getCabinetPriceTable();

		if (tbtnDate30.isSelected()) {
			ShareVar.pPrice = list.get(0).getTimeprice();
			ShareVar.priceCategory = list.get(0).getPricecategory();
		} else if (tbtnDate60.isSelected()) {
			ShareVar.pPrice = list.get(1).getTimeprice();
			ShareVar.priceCategory = list.get(1).getPricecategory();
		} else if (tbtnDate90.isSelected()) {
			ShareVar.pPrice = list.get(2).getTimeprice();
			ShareVar.priceCategory = list.get(2).getPricecategory();
		} else if (getTbtnDate120().isSelected()) {
			ShareVar.pPrice = list.get(3).getTimeprice();
			ShareVar.priceCategory = list.get(3).getPricecategory();
		}
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

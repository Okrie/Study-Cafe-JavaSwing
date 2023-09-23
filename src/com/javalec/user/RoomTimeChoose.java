package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.CabinetDao;
import com.javalec.dao.RoomDao;
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
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class RoomTimeChoose extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnLogout;
	private JLabel lbLogout;
	private JLabel lblPriceTagIcon;
	private JLabel lblGoBackIcon;
	private JLabel lblTableImageOrange;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lblTableImageWhite;
	private JButton btnProductPurchase;
	private JLabel lbRoomPurchase;
	LocalDateTime dateTime = LocalDateTime.now();
	private JLabel lblNewLabel_2_1_1_2;
	private JLabel lbRoomDuration;
	private JLabel lbRoomPrice;
	
	 Boolean isEmpty = true; // 스터디룸이 비어있는지 판별하는 변수
	 private JLabel lbtext1231;
	 private JToggleButton tbtnRoomTime01;
	 private JToggleButton tbtnRoomTime02;
	 private JToggleButton tbtnRoomTime03;
	 private JToggleButton tbtnRoomTime04;
	 private JToggleButton tbtnRoomTime05;
	 private JToggleButton tbtnRoomTime06;
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 private JLabel lblNewLabel_2_1_1_1_1;
	 private JLabel lblTop;
	 private JLabel lblBody;
	 private JLabel lblBottom;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomTimeChoose frame = new RoomTimeChoose();
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
	public RoomTimeChoose() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if(getRoomStatus() == 0) {
					JOptionPane.showMessageDialog(null, "현재 이용 가능한 스터디룸이 없습니다.", "스터디룸 선택", 
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new Choose().main(null);
				}else setTbtnText();
			}
		});
		setTitle("스터디룸 기간 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbLogout());
		contentPane.add(getLblPriceTagIcon());
		contentPane.add(getLblGoBackIcon());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2_1_1());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getBtnProductPurchase());
		contentPane.add(getLbRoomPurchase());
		contentPane.add(getLblNewLabel_2_1_1_2());
		contentPane.add(getLbRoomDuration());
		contentPane.add(getLbRoomPrice());
		contentPane.add(getLblTableImageOrange());
		contentPane.add(getLbtext1231());
		contentPane.add(getTbtnRoomTime01());
		contentPane.add(getTbtnRoomTime02());
		contentPane.add(getTbtnRoomTime03());
		contentPane.add(getTbtnRoomTime04());
		contentPane.add(getTbtnRoomTime05());
		contentPane.add(getTbtnRoomTime06());
		contentPane.add(getLblNewLabel_2_1_1_1_1());
		contentPane.add(getLblTableImageWhite());
		contentPane.add(getLblTop());
		contentPane.add(getLblBody());
		contentPane.add(getLblBottom());
	}
	private JLabel getLbLogout() {
		if (lbLogout == null) {
			lbLogout = new JLabel("logout");
			lbLogout.setBounds(407, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "LogOutIcon.png");
			lbLogout.setIcon(image.resizeImage());
			lbLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Login().main(null);
				}
			});
		}
		return lbLogout;
	}
	private JLabel getLblPriceTagIcon() {
		if (lblPriceTagIcon == null) {
			lblPriceTagIcon = new JLabel("상품가격표");
			lblPriceTagIcon.setBounds(336, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "PriceTagIcon.png");
			lblPriceTagIcon.setIcon(image.resizeImage());
			lblPriceTagIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new SeatPriceTag().main(null);
				}
			});
		}
		return lblPriceTagIcon;
	}
	private JLabel getLblGoBackIcon() {
		if (lblGoBackIcon == null) {
			lblGoBackIcon = new JLabel("뒤로가기");
			lblGoBackIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Choose().main(null);
				}
			});
			lblGoBackIcon.setBounds(476, 187, 70, 60);
			ImageResize image = new ImageResize(70, 60, "GoBackIcon.png");
			lblGoBackIcon.setIcon(image.resizeImage());
			
		}
		return lblGoBackIcon;
	}
	private JLabel getLblTableImageOrange() {
		if (lblTableImageOrange == null) {
			lblTableImageOrange = new JLabel("");
			lblTableImageOrange.setOpaque(true);
			lblTableImageOrange.setBackground(Color.DARK_GRAY);
			lblTableImageOrange.setBounds(41, 589, 521, 44);
		}
		return lblTableImageOrange;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("결제금액 :");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(62, 602, 134, 22);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("구매 시간 :");
			lblNewLabel_2_1_1.setBounds(62, 475, 61, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setBounds(54, 441, 142, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblTableImageWhite() {
		if (lblTableImageWhite == null) {
			lblTableImageWhite = new JLabel("");
			lblTableImageWhite.setOpaque(true);
			lblTableImageWhite.setBackground(new Color(255, 255, 254));
			lblTableImageWhite.setBounds(41, 411, 521, 179);
		}
		return lblTableImageWhite;
	}
	private JButton getBtnProductPurchase() {
		if (btnProductPurchase == null) {
			btnProductPurchase = new JButton("상품구매");
			btnProductPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tbtnRoomTime01.isSelected() || tbtnRoomTime02.isSelected() || tbtnRoomTime03.isSelected() || tbtnRoomTime04.isSelected()
							|| tbtnRoomTime05.isSelected() || tbtnRoomTime06.isSelected()) {
						setShareVar();
						dispose();
						new Payment().main(null);
					}else {
						JOptionPane.showMessageDialog(null, "구매할 기간을 선택해주세요.", "스터디룸 시간 선택", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnProductPurchase.setForeground(Color.BLACK);
			btnProductPurchase.setBackground(new Color(113, 113, 113));
			btnProductPurchase.setBounds(211, 679, 150, 50);
		}
		return btnProductPurchase;
	}
	private JLabel getLbRoomPurchase() {
		if (lbRoomPurchase == null) {
			lbRoomPurchase = new JLabel("");
			lbRoomPurchase.setBounds(155, 475, 61, 16);
		}
		return lbRoomPurchase;
	}
	
	private JLabel getLblNewLabel_2_1_1_2() {
		if (lblNewLabel_2_1_1_2 == null) {
			lblNewLabel_2_1_1_2 = new JLabel("사용 기간 :");
			lblNewLabel_2_1_1_2.setBounds(62, 510, 79, 16);
		}
		return lblNewLabel_2_1_1_2;
	}
	private JLabel getLbRoomDuration() {
		if (lbRoomDuration == null) {
			lbRoomDuration = new JLabel("");
			lbRoomDuration.setBounds(155, 511, 337, 15);
		}
		return lbRoomDuration;
	}
	private JLabel getLbRoomPrice() {
		if (lbRoomPrice == null) {
			lbRoomPrice = new JLabel("");
			lbRoomPrice.setForeground(new Color(255, 255, 255));
			lbRoomPrice.setBounds(411, 603, 134, 22);
		}
		return lbRoomPrice;
	}
	private JLabel getLbtext1231() {
		if (lbtext1231 == null) {
			lbtext1231 = new JLabel("스터디룸 번호 :");
			lbtext1231.setBounds(62, 440, 114, 16);
		}
		return lbtext1231;
	}
	private JToggleButton getTbtnRoomTime01() {
		if (tbtnRoomTime01 == null) {
			tbtnRoomTime01 = new JToggleButton("");
			tbtnRoomTime01.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(0);
				}
			});
			buttonGroup.add(tbtnRoomTime01);
			tbtnRoomTime01.setBounds(41, 270, 150, 50);
		}
		return tbtnRoomTime01;
	}
	private JToggleButton getTbtnRoomTime02() {
		if (tbtnRoomTime02 == null) {
			tbtnRoomTime02 = new JToggleButton("");
			tbtnRoomTime02.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(1);
				}
			});
			buttonGroup.add(tbtnRoomTime02);
			tbtnRoomTime02.setBounds(219, 270, 150, 50);
		}
		return tbtnRoomTime02;
	}
	private JToggleButton getTbtnRoomTime03() {
		if (tbtnRoomTime03 == null) {
			tbtnRoomTime03 = new JToggleButton("");
			tbtnRoomTime03.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(2);
				}
			});
			buttonGroup.add(tbtnRoomTime03);
			tbtnRoomTime03.setBounds(395, 270, 150, 50);
		}
		return tbtnRoomTime03;
	}
	private JToggleButton getTbtnRoomTime04() {
		if (tbtnRoomTime04 == null) {
			tbtnRoomTime04 = new JToggleButton("");
			tbtnRoomTime04.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(3);
				}
			});
			buttonGroup.add(tbtnRoomTime04);
			tbtnRoomTime04.setBounds(41, 332, 150, 50);
		}
		return tbtnRoomTime04;
	}
	private JToggleButton getTbtnRoomTime05() {
		if (tbtnRoomTime05 == null) {
			tbtnRoomTime05 = new JToggleButton("");
			tbtnRoomTime05.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(4);
				}
			});
			buttonGroup.add(tbtnRoomTime05);
			tbtnRoomTime05.setBounds(219, 332, 150, 50);
		}
		return tbtnRoomTime05;
	}
	private JToggleButton getTbtnRoomTime06() {
		if (tbtnRoomTime06 == null) {
			tbtnRoomTime06 = new JToggleButton("");
			tbtnRoomTime06.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setLableInfo(5);
				}
			});
			buttonGroup.add(tbtnRoomTime06);
			tbtnRoomTime06.setBounds(395, 332, 150, 50);
		}
		return tbtnRoomTime06;
	}
	
	// ------- Function -------
	
	private String usingDuration(int hours) {
		
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime targetDate = currentDate.plusDays(hours);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateTimeRange = currentDate.format(formatter) + " ~ " + targetDate.format(formatter);
        
        return dateTimeRange;
	}
	
	private ArrayList<CabinetDto> setTbtnText() { // pricetable의 정보를 받아와 토글버튼에 일자 및 가격 정보 뿌려줌.
		JToggleButton tbtns[] = {tbtnRoomTime01, tbtnRoomTime02, tbtnRoomTime03, tbtnRoomTime04,tbtnRoomTime05, tbtnRoomTime06};
		ArrayList<CabinetDto> dtolist = new ArrayList<>();
		RoomDao roomDao = new RoomDao();
		dtolist = roomDao.getRoomPriceTable();
		
		for(int i=0; i<dtolist.size(); i++) {
			String priceInfo = (dtolist.get(i).getCalctime()) + "시간" + " (" + dtolist.get(i).getTimeprice() + "원)";
			tbtns[i].setText(priceInfo);
		}
		
		return dtolist;
	}
	
	private void setLableInfo(int index) { // 선택된 결제 정보를 받아와 label에 set해줌.
		ArrayList<CabinetDto> list = setTbtnText();
		String labelPrice = Integer.toString(list.get(index).getTimeprice());
		String labelDuration = usingDuration(list.get(index).getCalctime());
		String labelPurchaseDate = Integer.toString(list.get(index).getCalctime());
		
		lbRoomDuration.setText(labelDuration);
		lbRoomPurchase.setText(labelPurchaseDate + "시간");
		lbRoomPrice.setText(labelPrice + "원");
	}
	
	private void setShareVar() {
		ArrayList<CabinetDto> list = new ArrayList<>();
		RoomDao roomDao = new RoomDao();
		list = roomDao.getRoomPriceTable();
		ShareVar.labelText = "StudyRoom01";

		if (tbtnRoomTime01.isSelected()) {
			ShareVar.pPrice = list.get(0).getTimeprice();
			ShareVar.priceCategory = list.get(0).getPricecategory();
		} else if (tbtnRoomTime02.isSelected()) {
			ShareVar.pPrice = list.get(1).getTimeprice();
			ShareVar.priceCategory = list.get(1).getPricecategory();
		} else if (tbtnRoomTime03.isSelected()) {
			ShareVar.pPrice = list.get(2).getTimeprice();
			ShareVar.priceCategory = list.get(2).getPricecategory();
		} else if (tbtnRoomTime04.isSelected()) {
			ShareVar.pPrice = list.get(3).getTimeprice();
			ShareVar.priceCategory = list.get(3).getPricecategory();
		} else if (tbtnRoomTime05.isSelected()) {
			ShareVar.pPrice = list.get(4).getTimeprice();
			ShareVar.priceCategory = list.get(4).getPricecategory();
		} else if (tbtnRoomTime06.isSelected()) {
			ShareVar.pPrice = list.get(5).getTimeprice();
			ShareVar.priceCategory = list.get(5).getPricecategory();
		}
	}
	
	private int getRoomStatus(){
		RoomDao roomDao = new RoomDao();
		return roomDao.getRoomStatus();
	}

	private JLabel getLblNewLabel_2_1_1_1_1() {
		if (lblNewLabel_2_1_1_1_1 == null) {
			lblNewLabel_2_1_1_1_1 = new JLabel("스터디룸 1");
			lblNewLabel_2_1_1_1_1.setBounds(155, 440, 61, 16);
		}
		return lblNewLabel_2_1_1_1_1;
	}
	private JLabel getLblTop() {
		if (lblTop == null) {
			lblTop = new JLabel("New label");
			lblTop.setBounds(0, 0, 584, 150);
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

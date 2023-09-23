package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminDao;
import com.javalec.dao.UserDao;
import com.javalec.dto.CustomerDto;
import com.javalec.dto.PurchaseDto;
import com.javalec.dto.SeatDto;
import com.javalec.function.ImageResize;
import com.javalec.function.TimeStampFlow;
import com.javalec.function.UsingPopup;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminUserManage extends JFrame {

	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel infoPanel;
	private JPanel nowPanel;
	private JLabel lblNewLabel_3;
	private JButton btnUserInfo;
	private JButton btnSalesManage;
	private JButton btnAnno;
	private JScrollPane scrollPane;
	private JTable innerTable;
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private final DefaultTableModel userouterTable = new DefaultTableModel();
	private final DefaultTableModel productouterTable = new DefaultTableModel();
	private JLabel lblUsingSeat;
	private JLabel lblEmptySeat;
	private JLabel lblUsingCabinet;
	private JLabel lblEmptyCabinet;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane_1;
	private JTable userTable;
	private JComboBox comboBox;
	private JTextField tfSearchQuery;
	private JButton btnQuery;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_2;
	private JButton btnDeleteUser;
	private JButton btnUserDetailInfo;
	private JTextField tfUser;
	private JTextField tfLastEnter;
	private JLabel lblNewLabel_5;
	private JTable productTable;
	private JLabel lblTotalPrice;
	private JTextField tfSeatNum;
	private JLabel lblSession;
	
	private ArrayList<CustomerDto> cDto;
	private JLabel lblToHome;
	private JLabel lblRefresh;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUserManage frame = new AdminUserManage();
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
	public AdminUserManage() {
		setTitle("사용자 관리 페이지");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				timeSet();
				tableInit();
				usertableInit();
				productTableInit();
				searchTableAction();
				selectNowUse();
				searchUserTableAction();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{220, 0};
		gbl_contentPane.rowHeights = new int[]{50, 500, 170, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 10.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 14.0, 5.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		getTopPanel().setLayout(null);
		GridBagConstraints gbc_topPanel = new GridBagConstraints();
		gbc_topPanel.insets = new Insets(0, 0, 5, 0);
		gbc_topPanel.fill = GridBagConstraints.BOTH;
		gbc_topPanel.gridx = 0;
		gbc_topPanel.gridy = 0;
		gbc_topPanel.gridwidth = 2;
		contentPane.add(getTopPanel(), gbc_topPanel);
		getInfoPanel().setLayout(null);
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 5, 5);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 1;
		contentPane.add(getInfoPanel(), gbc_infoPanel);
		getMainPanel().setLayout(null);
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 1;
		gbc_mainPanel.gridy = 1;
		gbc_mainPanel.gridheight = 2;
		contentPane.add(getMainPanel(), gbc_mainPanel);
		getNowPanel().setLayout(null);
		GridBagConstraints gbc_nowPanel = new GridBagConstraints();
		gbc_nowPanel.insets = new Insets(0, 0, 5, 5);
		gbc_nowPanel.fill = GridBagConstraints.BOTH;
		gbc_nowPanel.gridx = 0;
		gbc_nowPanel.gridy = 2;
		contentPane.add(getNowPanel(), gbc_nowPanel);
		
		setResizable(false);
	}
	private JPanel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setBackground(new Color(247, 248, 228));
			mainPanel.add(getPanel());
		}
		return mainPanel;
	}
	private JPanel getTopPanel() {
		if (topPanel == null) {
			topPanel = new JPanel();
			topPanel.setBackground(new Color(247, 226, 202));
			topPanel.add(getLblNewLabel_3());
			topPanel.add(getBtnUserInfo());
			topPanel.add(getBtnSalesManage());
			topPanel.add(getBtnAnno());
			topPanel.add(getLblToHome());
			topPanel.add(getLblRefresh());
		}
		return topPanel;
	}
	private JPanel getInfoPanel() {
		if (infoPanel == null) {
			infoPanel = new JPanel();
			infoPanel.setBackground(new Color(226, 223, 222));
			infoPanel.add(getScrollPane());
		}
		return infoPanel;
	}
	private JPanel getNowPanel() {
		if (nowPanel == null) {
			nowPanel = new JPanel();
			nowPanel.setBackground(new Color(223, 234, 195));
			nowPanel.add(getLblUsingSeat());
			nowPanel.add(getLblEmptySeat());
			nowPanel.add(getLblUsingCabinet());
			nowPanel.add(getLblEmptyCabinet());
			
		}
		return nowPanel;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBounds(10, 20, 160, 20);
		}
		return lblNewLabel_3;
	}
	
	private void timeSet() {
		TimeStampFlow time = new TimeStampFlow(lblNewLabel_3);
		time.start();
	}
	private JButton getBtnUserInfo() {
		if (btnUserInfo == null) {
			btnUserInfo = new JButton("사용자 정보 확인");
			btnUserInfo.setBounds(220, 7, 200, 35);
			btnUserInfo.setEnabled(false);
		}
		return btnUserInfo;
	}
	private JButton getBtnSalesManage() {
		if (btnSalesManage == null) {
			btnSalesManage = new JButton("매출 정보");
			btnSalesManage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new AdminSalesManage().setVisible(true);
				}
			});
			btnSalesManage.setBounds(440, 7, 200, 35);
		}
		return btnSalesManage;
	}
	private JButton getBtnAnno() {
		if (btnAnno == null) {
			btnAnno = new JButton("공지사항");
			btnAnno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new AdminAnno().setVisible(true);
				}
			});
			btnAnno.setBounds(660, 7, 200, 35);
		}
		return btnAnno;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 6, 208, 469);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	private JLabel getLblUsingSeat() {
		if (lblUsingSeat == null) {
			lblUsingSeat = new JLabel("현재 이용자 : ");
			lblUsingSeat.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblUsingSeat.setBounds(6, 6, 208, 16);
		}
		return lblUsingSeat;
	}
	private JLabel getLblEmptySeat() {
		if (lblEmptySeat == null) {
			lblEmptySeat = new JLabel("비어있는 자리 : ");
			lblEmptySeat.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblEmptySeat.setBounds(6, 36, 208, 16);
		}
		return lblEmptySeat;
	}
	private JLabel getLblUsingCabinet() {
		if (lblUsingCabinet == null) {
			lblUsingCabinet = new JLabel("사물함 이용 : ");
			lblUsingCabinet.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblUsingCabinet.setBounds(6, 66, 208, 16);
		}
		return lblUsingCabinet;
	}
	private JLabel getLblEmptyCabinet() {
		if (lblEmptyCabinet == null) {
			lblEmptyCabinet = new JLabel("사물함 남은 개수 : ");
			lblEmptyCabinet.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblEmptyCabinet.setBounds(6, 96, 208, 16);
		}
		return lblEmptyCabinet;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(30, 23, 1000, 600);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getScrollPane_1());
			panel.add(getComboBox());
			panel.add(getTfSearchQuery());
			panel.add(getBtnQuery());
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel1());
			panel.add(getLblNewLabel_2_1_1());
			panel.add(getLblNewLabel_4());
			panel.add(getScrollPane_2());
			panel.add(getBtnDeleteUser());
			panel.add(getBtnUserDetailInfo());
			panel.add(getTfUser());
			panel.add(getTfLastEnter());
			panel.add(getLblTotalPrice());
			
			JLabel lblNewLabel_2_1_2 = new JLabel("지정 좌석 : ");
			lblNewLabel_2_1_2.setBounds(486, 203, 111, 16);
			panel.add(lblNewLabel_2_1_2);
			
			tfSeatNum = new JTextField();
			tfSeatNum.setColumns(10);
			tfSeatNum.setBounds(610, 199, 299, 26);
			panel.add(tfSeatNum);
			panel.add(getLblNewLabel_5());
			panel.add(getLblSession());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("            사용자 관리");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblNewLabel.setBounds(0, 0, 1000, 87);
			lblNewLabel.setOpaque(true);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(26, 170, 340, 400);
			scrollPane_1.setViewportView(getUserTable());
		}
		return scrollPane_1;
	}
	private JTable getUserTable() {
		if (userTable == null) {
			userTable = new JTable();
			userTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			userTable.setModel(userouterTable);
		}
		return userTable;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"사용자", "좌석"}));
			comboBox.setBounds(26, 142, 92, 27);
		}
		return comboBox;
	}
	private JTextField getTfSearchQuery() {
		if (tfSearchQuery == null) {
			tfSearchQuery = new JTextField();
			tfSearchQuery.setHorizontalAlignment(SwingConstants.TRAILING);
			tfSearchQuery.setBounds(119, 142, 173, 27);
			tfSearchQuery.setColumns(10);
		}
		return tfSearchQuery;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 검색 과정
					queryAction();
				}
			});
			btnQuery.setBounds(287, 141, 82, 29);
		}
		return btnQuery;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("사용자 정보");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblNewLabel_1.setBounds(473, 124, 82, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel1() {
		if (lblNewLabel1 == null) {
			lblNewLabel1 = new JLabel("사용자 : ");
			lblNewLabel1.setBounds(486, 171, 111, 16);
		}
		return lblNewLabel1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("마지막 출입 기록 : ");
			lblNewLabel_2_1_1.setBounds(487, 233, 111, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("상품 구매 내역");
			lblNewLabel_4.setBounds(486, 296, 111, 16);
		}
		return lblNewLabel_4;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(473, 322, 450, 158);
			scrollPane_2.setViewportView(getProductTable());
		}
		return scrollPane_2;
	}
	private JButton getBtnDeleteUser() {
		if (btnDeleteUser == null) {
			btnDeleteUser = new JButton("삭제");
			btnDeleteUser.setEnabled(false);
			btnDeleteUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UsingPopup popuptest = new UsingPopup(cDto.get(0).getCustomerid() + " 유저가 삭제됩니다.\n", "", "유저 정보", 1);
					UserDao dao = new UserDao(cDto.get(0).getCustomerid());
					if(dao.delUser()) {
						UsingPopup succePopup = new UsingPopup(cDto.get(0).getCustomerid() + " 유저가 삭제되었습니다.\n", "", "유저 정보", 0);
						dispose();
					} else {
						UsingPopup succePopup = new UsingPopup("삭제 도중 에러가 발생하였습니다.\n", "0002", "유저 정보", 2);
					}
				}
			});
			btnDeleteUser.setBounds(851, 541, 117, 29);
		}
		return btnDeleteUser;
	}
	private JButton getBtnUserDetailInfo() {
		if (btnUserDetailInfo == null) {
			btnUserDetailInfo = new JButton("상세정보");
			btnUserDetailInfo.setEnabled(false);
			btnUserDetailInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminOnSeatInfo popInfo = new AdminOnSeatInfo();
					popInfo.getUserInfo("유저 정보", cDto);
					popInfo.setVisible(true);
				}
			});
			btnUserDetailInfo.setBounds(722, 541, 117, 29);
		}
		return btnUserDetailInfo;
	}
	private JTextField getTfUser() {
		if (tfUser == null) {
			tfUser = new JTextField();
			tfUser.setBounds(609, 166, 299, 26);
			tfUser.setColumns(10);
		}
		return tfUser;
	}
	private JTextField getTfLastEnter() {
		if (tfLastEnter == null) {
			tfLastEnter = new JTextField();
			tfLastEnter.setEditable(false);
			tfLastEnter.setColumns(10);
			tfLastEnter.setBounds(610, 228, 299, 26);
		}
		return tfLastEnter;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setBounds(473, 161, 443, 100);
			lblNewLabel_5.setOpaque(true);
		}
		return lblNewLabel_5;
	}
	private JTable getProductTable() {
		if (productTable == null) {
			productTable = new JTable();
			productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			productTable.setModel(productouterTable);
		}
		return productTable;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("총 결제 금액 : ");
			lblTotalPrice.setBounds(473, 530, 237, 32);
		}
		return lblTotalPrice;
	}
	private JLabel getLblSession() {
		if (lblSession == null) {
			lblSession = new JLabel("탈퇴한 회원");
			lblSession.setBounds(758, 127, 150, 26);
			lblSession.setVisible(false);
		}
		return lblSession;
	}
	private JLabel getLblToHome() {
		if (lblToHome == null) {
			lblToHome = new JLabel("");
			lblToHome.setBounds(1080, 10, 30, 30);
			ImageResize image = new ImageResize(30, 30, "LogoutIcon.png");
			lblToHome.setIcon(image.resizeImage());
			lblToHome.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					dispose();
					new AdminMain().setVisible(true);
				}
			});
		}
		return lblToHome;
	}
	private JLabel getLblRefresh() {
		if (lblRefresh == null) {
			lblRefresh = new JLabel("");
			lblRefresh.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					selectNowUse();
					searchTableAction();
				}
			});
			lblRefresh.setBounds(170, 5, 40, 40);
			ImageResize image = new ImageResize(40, 40, "ReFresh.png");
			lblRefresh.setIcon(image.resizeImage());
		}
		return lblRefresh;
	}
	
	
	// ------- Function -------
	private void tableInit() {
		// 좌측 중단 테이블
		outerTable.addColumn("No.");
		outerTable.addColumn("사용자");		
		outerTable.addColumn("입실시간");
		outerTable.addColumn("종료예정시간");
		outerTable.addColumn("남은시간");
		outerTable.setColumnCount(5);
		
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 25;
		col.setPreferredWidth(width);
			
		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 55;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);			
		
		int rowCount = outerTable.getRowCount();
		for(int i=0; i<rowCount; i++) {
			outerTable.removeRow(0);
		}
	}
	private void usertableInit() {
		// 메인뷰 검색 테이블
		userouterTable.addColumn("No.");
		userouterTable.addColumn("사용자");		
		userouterTable.addColumn("지정석");
		userouterTable.addColumn("종료예정시간");
		userouterTable.setColumnCount(4);
		
		
		userTable.setAutoResizeMode(userTable.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = userTable.getColumnModel().getColumn(vColIndex);
		int width = 25;
		col.setPreferredWidth(width);
			
		vColIndex = 1;
		col = userTable.getColumnModel().getColumn(vColIndex);
		width = 60;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = userTable.getColumnModel().getColumn(vColIndex);
		width = 60;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = userTable.getColumnModel().getColumn(vColIndex);
		width = 190;
		col.setPreferredWidth(width);
		
		int rowCount = userouterTable.getRowCount();
		for(int i=0; i<rowCount; i++) {
			userouterTable.removeRow(0);
		}
	}
	private void productTableInit() {
		// 구매내역 테이블
		productouterTable.addColumn("No.");
		productouterTable.addColumn("금액");
		productouterTable.addColumn("지정석");
		productouterTable.addColumn("종료시간");
		productouterTable.setColumnCount(4);
		
		
		productTable.setAutoResizeMode(productTable.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = productTable.getColumnModel().getColumn(vColIndex);
		int width = 25;
		col.setPreferredWidth(width);
			
		vColIndex = 1;
		col = productTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = productTable.getColumnModel().getColumn(vColIndex);
		width = 160;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = productTable.getColumnModel().getColumn(vColIndex);
		width = 160;
		col.setPreferredWidth(width);
		
		int rowCount = productouterTable.getRowCount();
		for(int i=0; i<rowCount; i++) {
			productouterTable.removeRow(0);
		}
	}
	
	private void searchTableAction(){

		AdminDao adminDao = new AdminDao();
		ArrayList<PurchaseDto> dtoList = adminDao.selectList();
		TimeStampFlow time = new TimeStampFlow();
		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			String remainTime = time.diffTime(dtoList.get(i).getEnddatetime());
			Object[] qTxt = { dtoList.get(i).getPnum(), dtoList.get(i).getCustomer_customerid(), 
			dtoList.get(i).getStartdatetime(), dtoList.get(i).getEnddatetime(), remainTime};
			outerTable.addRow(qTxt);
		}
	}
	
	private void selectNowUse() {
		ArrayList<Integer> isUse = new ArrayList<Integer>();
		AdminDao dao = new AdminDao();
		isUse = dao.selectSeat();
		lblUsingSeat.setText("현재 이용자 : " + isUse.get(0));
		lblEmptySeat.setText("비어 있는 자리 : " + isUse.get(1));
		lblUsingCabinet.setText("사물함 이용 : " + isUse.get(2));
		lblEmptyCabinet.setText("사물함 남은 개수 : " + isUse.get(3));
	}
	
	// 실행되자마자 보여줄 유저 정보
	private void searchUserTableAction() {
		AdminDao adminDao = new AdminDao();
		ArrayList<PurchaseDto> dtoList = adminDao.searchUserTable();
		int listCount = dtoList.size();
		
		for(int i = 0; i < listCount; i++) {
			Object[] qTxt = {i+1, dtoList.get(i).getCustomer_customerid(), dtoList.get(i).getProduct_productid(), dtoList.get(i).getEnddatetime()};
			userouterTable.addRow(qTxt);
		}
	}
	
	// 선택한 유저의 정보 가져오기
	private void selectUserTableAction() {
		AdminDao adminDao = new AdminDao();
		ArrayList<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
		
		dtoList = adminDao.selectUser(Integer.parseInt(tfUser.getText()));
		
		int listCount = dtoList.size();
		int totPrice = 0;
		for(int i = 0; i < listCount; i++) {
			Object[] qTxt = { i+1, dtoList.get(i).getPprice(), dtoList.get(i).getProduct_productid(), dtoList.get(i).getEnddatetime()};
			productouterTable.addRow(qTxt);
			totPrice += dtoList.get(i).getPprice();
		}
		lblTotalPrice.setText("총 결제금액 : " + Integer.toString(totPrice));
		
		UserDao uDao = new UserDao(dtoList.get(0).getCustomer_customerid());
		ArrayList<CustomerDto> cuDto = new ArrayList<CustomerDto>();
		cuDto = uDao.selectUser();
		cDto = cuDto;
		if(cuDto.get(0).getSession() == 1) {
			// 탈퇴 회원 일 경우
			lblSession.setVisible(true);
			lblSession.setText("탈퇴한 회원");
			btnDeleteUser.setEnabled(false);
		}else {
			btnDeleteUser.setEnabled(true);
			lblSession.setVisible(false);
		}
		btnUserDetailInfo.setEnabled(true);
	}
	
	//조건검색(conditionQuery)
	private void queryAction() {
		int i = comboBox.getSelectedIndex();
		String conditionQueryColumn="";
		switch(i){
		case 0:
			conditionQueryColumn = "c.customerid";
			break;
		case 1:
			conditionQueryColumn = "p.productid";
			break;
		
		}
		usertableInit();
		clearColumn();
		conditionQueryAction(conditionQueryColumn);
	}
	
	// 테이블 클릭시
	private void tableClick() {
		AdminDao adminDao = new AdminDao();
		ArrayList<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
		int i = userTable.getSelectedRow();
		dtoList = adminDao.selectUser(Integer.parseInt(userTable.getValueAt(i, 1).toString()));
		try {
		    tfUser.setText(Integer.toString(dtoList.get(0).getCustomer_customerid()));
		    tfSeatNum.setText(userTable.getValueAt(i, 2).toString());
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		    tfLastEnter.setText(formatter.format(dtoList.get(0).getEnddatetime()));
	    
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		productTableInit();
		selectUserTableAction();
		
	}
	
	//칼럼내용 클리어
	private void clearColumn() {
		tfUser.setText("");
		tfSeatNum.setText("");
		tfLastEnter.setText("");
	}
	
	// 컬럼 내용 기반으로 검색
	private void conditionQueryAction(String conditionQueryColumn) {
		AdminDao adminDao = new AdminDao();
		ArrayList<PurchaseDto> dtoList = adminDao.selectOrder(conditionQueryColumn, tfSearchQuery.getText(), 1);
		int listCount = dtoList.size();
		for(int i = 0; i < listCount; i++) {
			Object[] qTxt = {i+1, dtoList.get(i).getCustomer_customerid(), dtoList.get(i).getProduct_productid(), dtoList.get(i).getEnddatetime()};
			userouterTable.addRow(qTxt);
		}
	}
	
	
}

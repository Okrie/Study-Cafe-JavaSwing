package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminDao;
import com.javalec.dao.AdminSalesDao;
import com.javalec.dto.PurchaseDto;
import com.javalec.dto.TotalCalcDto;
import com.javalec.function.ImageResize;
import com.javalec.function.TimeStampFlow;

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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class AdminSalesManage extends JFrame {

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
	private final DefaultTableModel salesouterTable = new DefaultTableModel();
	private final DefaultTableModel conditionouterTable = new DefaultTableModel();
	private JLabel lblUsingSeat;
	private JLabel lblEmptySeat;
	private JLabel lblUsingCabinet;
	private JLabel lblEmptyCabinet;
	private JLabel lblnnSalesTopMenu;
	private JTable salesinnerTable;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTable conditioninnerTable;
	private JLabel lblCondition;
	private JRadioButton rdDay;
	private JRadioButton rdWeek;
	private JRadioButton rdMonth;
	private JLabel lblToHome;
	
	ArrayList<TotalCalcDto> cList;
	private JLabel lblRefresh;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSalesManage frame = new AdminSalesManage();
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
	public AdminSalesManage() {
		setTitle("매출현황 페이지");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				timeSet();
				tableInit();
				condiTableInit();
				searchTableAction();
				selectNowUse();
				purchaseTotalTable();
				purchaseDayTotalTable(0);
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{220, 0};
		gbl_contentPane.rowHeights = new int[]{50, 500, 170, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 10.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 14.0, 5.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		getTopPanel().setLayout(null);
		GridBagConstraints gbc_topPanel = new GridBagConstraints();
		gbc_topPanel.insets = new Insets(0, 0, 0, 0);
		gbc_topPanel.fill = GridBagConstraints.BOTH;
		gbc_topPanel.gridx = 0;
		gbc_topPanel.gridy = 0;
		gbc_topPanel.gridwidth = 2;
		contentPane.add(getTopPanel(), gbc_topPanel);
		getInfoPanel().setLayout(null);
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 0, 0);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 1;
		contentPane.add(getInfoPanel(), gbc_infoPanel);
		getMainPanel().setLayout(null);
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.insets = new Insets(0, 0, 0, 0);
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 1;
		gbc_mainPanel.gridy = 1;
		gbc_mainPanel.gridheight = 2;
		contentPane.add(getMainPanel(), gbc_mainPanel);
		getNowPanel().setLayout(null);
		GridBagConstraints gbc_nowPanel = new GridBagConstraints();
		gbc_nowPanel.insets = new Insets(0, 0, 0, 0);
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
			mainPanel.add(getLblnnSalesTopMenu());
			
			
			mainPanel.add(getScrollPane_1());
			
			rdDay = new JRadioButton("요일");
			buttonGroup.add(rdDay);
			rdDay.setSelected(true);
			rdDay.setBounds(485, 95, 60, 25);
			mainPanel.add(rdDay);
			
			rdWeek = new JRadioButton("주간");
			buttonGroup.add(rdWeek);
			rdWeek.setBounds(565, 95, 60, 25);
			rdWeek.setEnabled(false);;
			mainPanel.add(rdWeek);
			
			rdMonth = new JRadioButton("월간");
			buttonGroup.add(rdMonth);
			rdMonth.setBounds(645, 95, 60, 25);
			rdMonth.setEnabled(false);
			mainPanel.add(rdMonth);
			mainPanel.add(getScrollPane_2());
			
			lblCondition = new JLabel("n월 n일");
			lblCondition.setVisible(false);
			lblCondition.setFont(new Font("굴림", Font.PLAIN, 15));
			lblCondition.setBounds(440, 150, 80, 30);
			
			rdDay.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					purchaseDayTotalTable(rbCondition());
				}
			});
			rdWeek.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					purchaseDayTotalTable(rbCondition());
				}
			});
			rdMonth.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					purchaseDayTotalTable(rbCondition());
				}
			});
			
			mainPanel.add(lblCondition);
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
	
	
	private JButton getBtnUserInfo() {
		if (btnUserInfo == null) {
			btnUserInfo = new JButton("사용자 정보 확인");
			btnUserInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new AdminUserManage().setVisible(true);
				}
			});
			btnUserInfo.setBounds(220, 7, 200, 35);
		}
		return btnUserInfo;
	}
	private JButton getBtnSalesManage() {
		if (btnSalesManage == null) {
			btnSalesManage = new JButton("매출 정보");
			btnSalesManage.setBounds(440, 7, 200, 35);
			btnSalesManage.setEnabled(false);
		}
		return btnSalesManage;
	}
	private JButton getBtnAnno() {
		if (btnAnno == null) {
			btnAnno = new JButton("공지사항");
			btnAnno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new AdminAnno().setVisible(true);;
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
	private JLabel getLblnnSalesTopMenu() {
		if (lblnnSalesTopMenu == null) {
			lblnnSalesTopMenu = new JLabel("       n월 n일 매출 현황 : xx,xxx원            n월 매출 현황 : x,xxx,xxx 원");
			lblnnSalesTopMenu.setBounds(0, 0, 1000, 87);
			lblnnSalesTopMenu.setOpaque(true);
			lblnnSalesTopMenu.setFont(new Font("Dialog", Font.BOLD, 25));
		}
		return lblnnSalesTopMenu;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 96, 354, 510);
			scrollPane_1.setViewportView(getSalesinnerTable());
		}
		return scrollPane_1;
	}
	private JTable getSalesinnerTable() {
		if (salesinnerTable == null) {
			salesinnerTable = new JTable();
			salesinnerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			salesinnerTable.setModel(salesouterTable);
		}
		return salesinnerTable;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(440, 185, 500, 280);
			scrollPane_2.setViewportView(getConditioninnerTable());
		}
		return scrollPane_2;
	}
	private JTable getConditioninnerTable() {
		if (conditioninnerTable == null) {
			conditioninnerTable = new JTable();
			conditioninnerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			conditioninnerTable.setModel(conditionouterTable);
		}
		return conditioninnerTable;
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
					condiTableInit();
					searchTableAction();
					selectNowUse();
					purchaseTotalTable();
					purchaseDayTotalTable(0);
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

		// 월 매출 표
		salesouterTable.addColumn("날짜");
		salesouterTable.addColumn("시간제");		
		salesouterTable.addColumn("총 판매액");
		salesouterTable.setColumnCount(3);
		
		
		salesinnerTable.setAutoResizeMode(salesinnerTable.AUTO_RESIZE_OFF);
		
		vColIndex = 0;
		col = salesinnerTable.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);
			
		vColIndex = 1;
		col = salesinnerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = salesinnerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		rowCount = salesouterTable.getRowCount();
		for(int i=0; i<rowCount; i++) {
			salesouterTable.removeRow(0);
		}
	}
		
	private void condiTableInit() {	
		// 조건 매출 표
		if(rbCondition() == 0) {
			System.out.println(0);
			conditionouterTable.addColumn("요일");
			conditionouterTable.addColumn("시간제");		
//			conditionouterTable.addColumn("시간적립제");
			conditionouterTable.addColumn("총 판매액");
			conditionouterTable.setColumnCount(3);
		} else if(rbCondition() == 1) {
			System.out.println(1);
			conditionouterTable.addColumn("주간");
			conditionouterTable.addColumn("시간제");		
//			conditionouterTable.addColumn("시간적립제");
			conditionouterTable.addColumn("총 판매액");
			conditionouterTable.setColumnCount(3);
		} else {
			System.out.println(2);
			conditionouterTable.addColumn("월간");
			conditionouterTable.addColumn("시간제");		
//			conditionouterTable.addColumn("시간적립제");
			conditionouterTable.addColumn("총 판매액");
			conditionouterTable.setColumnCount(3);
		}
		
		
		int rowCount = conditionouterTable.getRowCount();
		for(int i=0; i<rowCount; i++) {
			conditionouterTable.removeRow(0);
		}
		conditioninnerTable.setAutoResizeMode(conditioninnerTable.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = conditioninnerTable.getColumnModel().getColumn(vColIndex);
		int width = 80;
		col.setPreferredWidth(width);
			
		vColIndex = 1;
		col = conditioninnerTable.getColumnModel().getColumn(vColIndex);
		width = 180;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = conditioninnerTable.getColumnModel().getColumn(vColIndex);
		width = 220;
		col.setPreferredWidth(width);
		
//		vColIndex = 3;
//		col = conditioninnerTable.getColumnModel().getColumn(vColIndex);
//		width = 155;
//		col.setPreferredWidth(width);		
		
	}
	
	private void timeSet() {
		TimeStampFlow time = new TimeStampFlow(lblNewLabel_3);
		time.start();
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
	
	// 기본 로딩 되는 일별 금액 출력
	private void purchaseTotalTable() {
		AdminSalesDao adminSalesDao = new AdminSalesDao();
		ArrayList<TotalCalcDto> calList = adminSalesDao.selectList();
		cList = calList;
		int listCount = calList.size();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		for (int i = 0; i < listCount; i++) {
			Object[] qTxt = {formatter.format(calList.get(i).getDate()), calList.get(i).getTotalPrice(), calList.get(i).getTotalPrice()};
			salesouterTable.addRow(qTxt);
		}
	}
	
	// 기본 로딩 되는 요일, 주간, 월별 금액 출력
	private void purchaseDayTotalTable(int cond) {
		AdminSalesDao adminSalesDao = new AdminSalesDao();
		ArrayList<TotalCalcDto> calList = new ArrayList<TotalCalcDto>();
		if(cond == 0) {
			calList = adminSalesDao.selectDayList();
			condiTableInit();
		}
		if(cond == 1) {
			calList = adminSalesDao.selectWeekList();
			condiTableInit();
		}
		if(cond == 2){
			calList = adminSalesDao.selectMonthList();
			condiTableInit();
		}
			
		int listCount = calList.size();
		for (int i = 0; i < listCount; i++) {
			Object[] qTxt = {calList.get(i).getDay(), calList.get(i).getTotalPrice(), calList.get(i).getTotalPrice()};
			conditionouterTable.addRow(qTxt);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String convert = formatter.format(cList.get(listCount-1).getDate());
		lblnnSalesTopMenu.setText("       " + convert.substring(5, 7) + "월 " + convert.substring(8, 10) + "일 매출 현황 : " + cList.get(listCount-1).getTotalPrice() + "원            " + convert.substring(5, 7) + "월 매출 현황 : " + cList.get(listCount-1).getTotalPrice() + " 원");
		lblCondition.setText(convert.substring(5, 7) + "월 " + convert.substring(8, 10) + "일");
	}
	
	private int rbCondition() {
		if(rdDay.isSelected()) {
			return 0;
		}
		if(rdWeek.isSelected()) {
			return 1;
		}
		if(rdMonth.isSelected()) {
			return 2;
		}
		return -1;
	}
	
	
}

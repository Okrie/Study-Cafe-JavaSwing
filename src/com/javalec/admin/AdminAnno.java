package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminDao;
import com.javalec.dao.NoticeDao;
import com.javalec.dto.NoticeDto;
import com.javalec.dto.PurchaseDto;
import com.javalec.function.ImageResize;
import com.javalec.function.TimeStampFlow;
import com.javalec.function.UsingPopup;
import com.javalec.util.ShareVar;

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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class AdminAnno extends JFrame {

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
	private final DefaultTableModel annoouterTable = new DefaultTableModel();
	private JLabel lblUsingSeat;
	private JLabel lblEmptySeat;
	private JLabel lblUsingCabinet;
	private JLabel lblEmptyCabinet;
	private JLabel lblNN;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane_1;
	private JTable annoTable;
	private JLabel lblToHome;
	private JLabel lblRefresh;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAnno frame = new AdminAnno();
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
	public AdminAnno() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				timeSet();
				tableInit();
				searchTableAction();
				selectNowUse();
				selectAnnoTableAction();
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
			mainPanel.add(getLblNN());
			mainPanel.add(getLblNewLabel());
			mainPanel.add(getScrollPane_1());
			
			JButton btnNewButton = new JButton("공지사항 등록하기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new AdminAnnoRegister().setVisible(true);
				}
			});
			btnNewButton.setBounds(817, 567, 133, 23);
			mainPanel.add(btnNewButton);
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
			btnAnno.setBounds(660, 7, 200, 35);
			btnAnno.setEnabled(false);
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
	private JLabel getLblNN() {
		if (lblNN == null) {
			lblNN = new JLabel("              공지사항 관리");
			lblNN.setBounds(0, 0, 1060, 87);
			lblNN.setOpaque(true);
			lblNN.setFont(new Font("Dialog", Font.BOLD, 25));
		}
		return lblNN;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("공지사항");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel.setBounds(40, 110, 65, 30);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(40, 177, 900, 300);
			scrollPane_1.setViewportView(getAnnoTable());
		}
		return scrollPane_1;
	}
	private JTable getAnnoTable() {
		if (annoTable == null) {
			annoTable = new JTable();
			annoTable.setEnabled(true);
			annoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			annoTable.setModel(annoouterTable);
			annoTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
		}
		return annoTable;
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
					searchTableAction();
					selectNowUse();
					selectAnnoTableAction();
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
		
		
		// 공지사항 테이블
		annoouterTable.addColumn("No.");
		annoouterTable.addColumn("게시글");		
		annoouterTable.addColumn("등록 날짜");
		annoouterTable.addColumn("노출 유무");
		annoouterTable.setColumnCount(4);
		
		annoTable.setAutoResizeMode(annoTable.AUTO_RESIZE_OFF);
		
		vColIndex = 0;
		col = annoTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
			
		vColIndex = 1;
		col = annoTable.getColumnModel().getColumn(vColIndex);
		width = 220;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = annoTable.getColumnModel().getColumn(vColIndex);
		width = 575;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = annoTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		rowCount = annoouterTable.getRowCount();
		for(int i=0; i<rowCount; i++) {
			annoouterTable.removeRow(0);
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
	
	private void selectAnnoTableAction(){
		
		NoticeDao noticeDao = new NoticeDao();
		ArrayList<NoticeDto> dtoList = noticeDao.selectList();
		int listCount = dtoList.size();
		
		for (int i = 0; i < listCount; i++) {
			Object[] qTxt = { dtoList.get(i).getSeq(), dtoList.get(i).getTitle(), dtoList.get(i).getContents(), dtoList.get(i).getViewon()};
			annoouterTable.addRow(qTxt);
		}
	}
	
	// 테이블 클릭시
	private void tableClick() {
		NoticeDao noticeDao = new NoticeDao();
		ArrayList<NoticeDto> dtoList = new ArrayList<NoticeDto>();
		int i = annoTable.getSelectedRow();
		System.out.println(i);
		dtoList = noticeDao.searchList(Integer.parseInt(annoTable.getValueAt(i, 0).toString()));
		try {
			int result;
			if(dtoList.get(0).getViewon() == 0) {
				result = JOptionPane.showConfirmDialog(this, "공지로 등록하겠습니까?");
		    
			    if(result == JOptionPane.OK_OPTION) {
			    	if(noticeDao.viewOnAnno(1, dtoList.get(0).getSeq())) {
			    		UsingPopup popup = new UsingPopup("공지 등록\n", "", "공지사항", 0);
			    	} else {
			    		UsingPopup popup = new UsingPopup("공지 등록에 실패하였습니다.\n", "0005", "공지사항", 2);
			    	}
			    } else {
			    	UsingPopup popup = new UsingPopup("공지 등록을 취소 하였습니다.", "", "공지사항", 3);
			    }
			} else {
				result = JOptionPane.showConfirmDialog(this, "공지에서 내리겠습니까?");
				
				if(result == JOptionPane.OK_OPTION) {
			    	if(noticeDao.viewOnAnno(0, dtoList.get(0).getSeq())) {
			    		UsingPopup popup = new UsingPopup("공지 내리기\n", "", "공지사항", 0);
			    	} else {
			    		UsingPopup popup = new UsingPopup("공지 내리기에 실패하였습니다.\n", "0005", "공지사항", 2);
			    	}
			    } else {
			    	UsingPopup popup = new UsingPopup("공지 내리기를 취소 하였습니다.", "", "공지사항", 3);
			    }
			}
	    
		}catch (Exception e) {
			e.printStackTrace();
		}
		tableInit();
		selectAnnoTableAction();
		
	}
	
	
}
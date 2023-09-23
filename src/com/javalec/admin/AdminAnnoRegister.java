package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminDao;
import com.javalec.dao.NoticeDao;
import com.javalec.dto.PurchaseDto;
import com.javalec.function.ImageResize;
import com.javalec.function.TimeStampFlow;
import com.javalec.function.UsingPopup;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class AdminAnnoRegister extends JFrame {

	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel infoPanel;
	private JPanel nowPanel;
	private JLabel lblNewLabel_3;
	private JButton btnUserInfo;
	private JButton btnSalesManage;
	private JButton btnAnno;
	private JButton btnAnnoRegister;
	private JScrollPane scrollPane;
	private JTable innerTable;
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblUsingSeat;
	private JLabel lblEmptySeat;
	private JLabel lblUsingCabinet;
	private JLabel lblEmptyCabinet;
	private JLabel lblNN;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1;
	private JTextField tfTitle;
	private JTextField tfTextField;
	JCheckBox chkOnAnno;
	private JLabel lblToHome;
	private JLabel lblRefresh;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAnnoRegister frame = new AdminAnnoRegister();
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
	public AdminAnnoRegister() {
		setTitle("공지사항 등록");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				timeSet();
				tableInit();
				searchTableAction();
				selectNowUse();
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
			mainPanel.add(getLblNewLabel_1());
			mainPanel.add(getLblNewLabel_1_1());
			mainPanel.add(getBtnAnnoRegister());
			mainPanel.add(getTfTitle());
			mainPanel.add(getTfTextField());
			mainPanel.add(getLblNewLabel_2());
			
			chkOnAnno = new JCheckBox("공지로 등록하기");
			chkOnAnno.setBounds(811, 137, 134, 23);
			mainPanel.add(chkOnAnno);
		}
		return mainPanel;
	}
	private JLabel getLblNewLabel_2() {
		if(lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(131, 160, 830, 330);
			lblNewLabel_2.setOpaque(true);
		}		
		return lblNewLabel_2;
	}
	private JButton getBtnAnnoRegister() {
		if(btnAnnoRegister == null) {
			btnAnnoRegister = new JButton("등록하기");
			btnAnnoRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertAnnoAction();
				}
			});
			btnAnnoRegister.setBounds(861, 568, 100, 25);
		}
		return btnAnnoRegister;
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
			lblNN.setOpaque(true);
			lblNN.setFont(new Font("Dialog", Font.BOLD, 25));
			lblNN.setBounds(0, 0, 1044, 87);
		}
		return lblNN;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("공지사항 등록");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel.setBounds(70, 120, 200, 30);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("제목 : ");
			lblNewLabel_1.setBounds(81, 173, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("내용 : ");
			lblNewLabel_1_1.setBounds(81, 205, 57, 15);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setBounds(145, 170, 800, 20);
			tfTitle.setColumns(10);
		}
		return tfTitle;
	}
	private JTextField getTfTextField() {
		if (tfTextField == null) {
			tfTextField = new JTextField();
			tfTextField.setBounds(145, 200, 800, 280);
			tfTextField.setColumns(10);
		}
		return tfTextField;
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
	
	private void insertAnnoAction() {
		String title = tfTitle.getText();
		String contents = tfTextField.getText();
		NoticeDao dao;
		
		if(chkOnAnno.isSelected()) {
			dao = new NoticeDao(title, contents, 1);
		}else {
			dao = new NoticeDao(title, contents, 0);
		}
		
		if(dao.insertAction()) {
			UsingPopup succePopup = new UsingPopup("공지사항이 등록 되었습니다.\n", "", "공지사항", 0);
			dispose();
			new AdminAnno().setVisible(true);
		}else {
			UsingPopup succePopup = new UsingPopup("등록 도중 에러가 발생하였습니다.\n", "0004", "공지사항 등록", 2);
		}
	}
	
	
}

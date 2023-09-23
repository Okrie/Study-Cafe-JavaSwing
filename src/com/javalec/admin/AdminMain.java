package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminDao;
import com.javalec.dao.SeatDao;
import com.javalec.dto.ProductDto;
import com.javalec.dto.PurchaseDto;
import com.javalec.dto.SeatDto;
import com.javalec.function.ImageResize;
import com.javalec.function.TimeStampFlow;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMain extends JFrame{

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
	private JLabel lblUsingFree;
	private JLabel lblEmptyFree;
	private JLabel lblUsingCabinet;
	private JLabel lblEmptyCabinet;
	private JPanel panel;
	private JLabel lblFixed01;
	private JLabel lblFixed02;
	private JLabel lblFixed03;
	private JLabel lblFixed04;
	private JLabel lblFixed05;
	private JLabel lblFixed06;
	private JLabel lblFixed07;
	private JLabel lblFixed08;
	private JLabel lblFixed09;
	private JLabel lblFixed10;
	private JLabel lblFixed11;
	private JLabel lblFixed12;
	private JLabel lblFixed13;
	private JLabel lblFixed14;
	private JLabel lblFixed15;
	private JLabel lblFixed16;
	private JLabel lblStudyRoom;
	private final int initSize = 69;
	private JLabel lblRestRoom;
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
	private JLabel lblCabinet01;
	private JLabel lblCabinet02;
	private JLabel lblCabinet03;
	private JLabel lblCabinet04;
	private JLabel lblCabinet05;
	private JLabel lblCabinet06;
	private JLabel lblCabinet07;
	private JLabel lblCabinet08;
	private JLabel lblCabinet09;
	private JLabel lblCabinet10;
	private JLabel lblCabinet11;
	private JLabel lblCabinet12;
	private JLabel lblToHome;
	private JLabel lblRefresh;
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
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
	public AdminMain() {
		setTitle("스터디카페 관리자 메인화면");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				timeSet();
				tableInit();
				searchTableAction();
				selectNowUse();
				selectTableViewAction();
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
			nowPanel.add(getLblUsingFree());
			nowPanel.add(getLblEmptyFree());
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
	private JLabel getLblUsingFree() {
		if (lblUsingFree == null) {
			lblUsingFree = new JLabel("현재 이용자 : ");
			lblUsingFree.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblUsingFree.setBounds(6, 6, 208, 16);
		}
		return lblUsingFree;
	}
	private JLabel getLblEmptyFree() {
		if (lblEmptyFree == null) {
			lblEmptyFree = new JLabel("비어있는 자리 : ");
			lblEmptyFree.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblEmptyFree.setBounds(6, 36, 208, 16);
		}
		return lblEmptyFree;
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
			panel.add(getLblFixed01());
			panel.add(getLblFixed02());
			panel.add(getLblFixed03());
			panel.add(getLblFixed04());
			panel.add(getLblFixed05());
			panel.add(getLblFixed06());
			panel.add(getLblFixed07());
			panel.add(getLblFixed08());
			panel.add(getLblFixed09());
			panel.add(getLblFixed10());
			panel.add(getLblFixed11());
			panel.add(getLblFixed12());
			panel.add(getLblFixed13());
			panel.add(getLblFixed14());
			panel.add(getLblFixed15());
			panel.add(getLblFixed16());
			panel.add(getLblStudyRoom());
			panel.add(getLblRestRoom());
			panel.add(getLblFree01());
			panel.add(getLblFree02());
			panel.add(getLblFree03());
			panel.add(getLblFree04());
			panel.add(getLblFree05());
			panel.add(getLblFree06());
			panel.add(getLblFree07());
			panel.add(getLblFree08());
			panel.add(getLblFree09());
			panel.add(getLblFree10());
			panel.add(getLblFree11());
			panel.add(getLblFree12());
			panel.add(getLblFree13());
			panel.add(getLblFree14());
			panel.add(getLblFree15());
			panel.add(getLblFree16());
			panel.add(getLblFree17());
			panel.add(getLblFree18());
			panel.add(getLblFree19());
			panel.add(getLblFree20());
			panel.add(getLblFree21());
			panel.add(getLblFree22());
			panel.add(getLblCabinet01());
			panel.add(getLblCabinet02());
			panel.add(getLblCabinet03());
			panel.add(getLblCabinet04());
			panel.add(getLblCabinet05());
			panel.add(getLblCabinet06());
			panel.add(getLblCabinet07());
			panel.add(getLblCabinet08());
			panel.add(getLblCabinet09());
			panel.add(getLblCabinet10());
			panel.add(getLblCabinet11());
			panel.add(getLblCabinet12());
			
			// 마우스 리스너 추가
			addMouseListenerToLabel(getLblFixed01());
			addMouseListenerToLabel(getLblFixed02());
			addMouseListenerToLabel(getLblFixed03());
			addMouseListenerToLabel(getLblFixed04());
			addMouseListenerToLabel(getLblFixed05());
			addMouseListenerToLabel(getLblFixed06());
			addMouseListenerToLabel(getLblFixed07());
			addMouseListenerToLabel(getLblFixed08());
			addMouseListenerToLabel(getLblFixed09());
			addMouseListenerToLabel(getLblFixed10());
			addMouseListenerToLabel(getLblFixed11());
			addMouseListenerToLabel(getLblFixed12());
			addMouseListenerToLabel(getLblFixed13());
			addMouseListenerToLabel(getLblFixed14());
			addMouseListenerToLabel(getLblFixed15());
			addMouseListenerToLabel(getLblFixed16());
			addMouseListenerToLabel(getLblFree01());
			addMouseListenerToLabel(getLblFree02());
			addMouseListenerToLabel(getLblFree03());
			addMouseListenerToLabel(getLblFree04());
			addMouseListenerToLabel(getLblFree05());
			addMouseListenerToLabel(getLblFree06());
			addMouseListenerToLabel(getLblFree07());
			addMouseListenerToLabel(getLblFree08());
			addMouseListenerToLabel(getLblFree09());
			addMouseListenerToLabel(getLblFree10());
			addMouseListenerToLabel(getLblFree11());
			addMouseListenerToLabel(getLblFree12());
			addMouseListenerToLabel(getLblFree13());
			addMouseListenerToLabel(getLblFree14());
			addMouseListenerToLabel(getLblFree15());
			addMouseListenerToLabel(getLblFree16());
			addMouseListenerToLabel(getLblFree17());
			addMouseListenerToLabel(getLblFree18());
			addMouseListenerToLabel(getLblFree19());
			addMouseListenerToLabel(getLblFree20());
			addMouseListenerToLabel(getLblFree21());
			addMouseListenerToLabel(getLblFree22());
			addMouseListenerToLabel(getLblCabinet01());
			addMouseListenerToLabel(getLblCabinet02());
			addMouseListenerToLabel(getLblCabinet03());
			addMouseListenerToLabel(getLblCabinet04());
			addMouseListenerToLabel(getLblCabinet05());
			addMouseListenerToLabel(getLblCabinet06());
			addMouseListenerToLabel(getLblCabinet07());
			addMouseListenerToLabel(getLblCabinet08());
			addMouseListenerToLabel(getLblCabinet09());
			addMouseListenerToLabel(getLblCabinet10());
			addMouseListenerToLabel(getLblCabinet11());
			addMouseListenerToLabel(getLblCabinet12());
			addMouseListenerToLabel(getLblStudyRoom());
			
		}
		return panel;
	}
	
	private JLabel getLblFixed01() {
		if (lblFixed01 == null) {
			lblFixed01 = new JLabel("Fixed01");
			lblFixed01.setVerticalAlignment(SwingConstants.TOP);
			lblFixed01.setBounds(100, 100, initSize, initSize);
			lblFixed01.setOpaque(true);
		}
		return lblFixed01;
	}
	
	private JLabel getLblFixed02() {
		if (lblFixed02 == null) {
			lblFixed02 = new JLabel("Fixed02");
			lblFixed02.setVerticalAlignment(SwingConstants.TOP);
			lblFixed02.setBounds(170, 100, initSize, initSize);
			lblFixed02.setOpaque(true);
		}
		return lblFixed02;
	}
	private JLabel getLblFixed03() {
		if (lblFixed03 == null) {
			lblFixed03 = new JLabel("Fixed03");
			lblFixed03.setVerticalAlignment(SwingConstants.TOP);
			lblFixed03.setBounds(240, 100, initSize, initSize);
			lblFixed03.setOpaque(true);
		}
		return lblFixed03;
	}
	private JLabel getLblFixed04() {
		if (lblFixed04 == null) {
			lblFixed04 = new JLabel("Fixed04");
			lblFixed04.setVerticalAlignment(SwingConstants.TOP);
			lblFixed04.setBounds(310, 100, initSize, initSize);
			lblFixed04.setOpaque(true);
		}
		return lblFixed04;
	}
	private JLabel getLblFixed05() {
		if (lblFixed05 == null) {
			lblFixed05 = new JLabel("Fixed05");
			lblFixed05.setVerticalAlignment(SwingConstants.TOP);
			lblFixed05.setBounds(380, 100, initSize, initSize);
			lblFixed05.setOpaque(true);
		}
		return lblFixed05;
	}
	private JLabel getLblFixed06() {
		if (lblFixed06 == null) {
			lblFixed06 = new JLabel("Fixed06");
			lblFixed06.setVerticalAlignment(SwingConstants.TOP);
			lblFixed06.setBounds(450, 100, initSize, initSize);
			lblFixed06.setOpaque(true);
		}
		return lblFixed06;
	}
	private JLabel getLblFixed07() {
		if (lblFixed07 == null) {
			lblFixed07 = new JLabel("Fixed07");
			lblFixed07.setVerticalAlignment(SwingConstants.TOP);
			lblFixed07.setBounds(520, 100, initSize, initSize);
			lblFixed07.setOpaque(true);
		}
		return lblFixed07;
	}
	private JLabel getLblFixed08() {
		if (lblFixed08 == null) {
			lblFixed08 = new JLabel("Fixed08");
			lblFixed08.setVerticalAlignment(SwingConstants.TOP);
			lblFixed08.setBounds(590, 100, initSize, initSize);
			lblFixed08.setOpaque(true);
		}
		return lblFixed08;
	}
	private JLabel getLblFixed09() {
		if (lblFixed09 == null) {
			lblFixed09 = new JLabel("Fixed09");
			lblFixed09.setVerticalAlignment(SwingConstants.TOP);
			lblFixed09.setBounds(660, 100, initSize, initSize);
			lblFixed09.setOpaque(true);
		}
		return lblFixed09;
	}
	private JLabel getLblFixed10() {
		if (lblFixed10 == null) {
			lblFixed10 = new JLabel("Fixed10");
			lblFixed10.setVerticalAlignment(SwingConstants.TOP);
			lblFixed10.setBounds(730, 100, initSize, initSize);
			lblFixed10.setOpaque(true);
		}
		return lblFixed10;
	}
	private JLabel getLblFixed11() {
		if (lblFixed11 == null) {
			lblFixed11 = new JLabel("Fixed11");
			lblFixed11.setVerticalAlignment(SwingConstants.TOP);
			lblFixed11.setBounds(380, 240, initSize, initSize);
			lblFixed11.setOpaque(true);
		}
		return lblFixed11;
	}
	private JLabel getLblFixed12() {
		if (lblFixed12 == null) {
			lblFixed12 = new JLabel("Fixed12");
			lblFixed12.setVerticalAlignment(SwingConstants.TOP);
			lblFixed12.setBounds(450, 240, initSize, initSize);
			lblFixed12.setOpaque(true);
		}
		return lblFixed12;
	}
	private JLabel getLblFixed13() {
		if (lblFixed13 == null) {
			lblFixed13 = new JLabel("Fixed13");
			lblFixed13.setVerticalAlignment(SwingConstants.TOP);
			lblFixed13.setBounds(520, 240, initSize, initSize);
			lblFixed13.setOpaque(true);
		}
		return lblFixed13;
	}
	private JLabel getLblFixed14() {
		if (lblFixed14 == null) {
			lblFixed14 = new JLabel("Fixed14");
			lblFixed14.setVerticalAlignment(SwingConstants.TOP);
			lblFixed14.setBounds(590, 240, initSize, initSize);
			lblFixed14.setOpaque(true);
		}
		return lblFixed14;
	}
	private JLabel getLblFixed15() {
		if (lblFixed15 == null) {
			lblFixed15 = new JLabel("Fixed15");
			lblFixed15.setVerticalAlignment(SwingConstants.TOP);
			lblFixed15.setBounds(660, 240, initSize, initSize);
			lblFixed15.setOpaque(true);
		}
		return lblFixed15;
	}
	private JLabel getLblFixed16() {
		if (lblFixed16 == null) {
			lblFixed16 = new JLabel("Fixed16");
			lblFixed16.setVerticalAlignment(SwingConstants.TOP);
			lblFixed16.setBounds(730, 240, initSize, initSize);
			lblFixed16.setOpaque(true);
		}
		return lblFixed16;
	}
	private JLabel getLblStudyRoom() {
		if (lblStudyRoom == null) {
			lblStudyRoom = new JLabel("StudyRoom01");
			lblStudyRoom.setVerticalAlignment(SwingConstants.TOP);
			lblStudyRoom.setBounds(100, 248, initSize*2, initSize*2);
			lblStudyRoom.setOpaque(true);
		}
		return lblStudyRoom;
	}
	private JLabel getLblRestRoom() {
		if (lblRestRoom == null) {
			lblRestRoom = new JLabel("RestRoom");
			lblRestRoom.setHorizontalAlignment(SwingConstants.CENTER);
			lblRestRoom.setEnabled(false);
			lblRestRoom.setOpaque(true);
			lblRestRoom.setBounds(101, 387, 138, 138);
		}
		return lblRestRoom;
	}	
	private JLabel getLblFree01() {
		if (lblFree01 == null) {
			lblFree01 = new JLabel("Free01");
			lblFree01.setVerticalAlignment(SwingConstants.TOP);
			lblFree01.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree01.setBounds(380, 310, initSize/2, initSize/2);
			lblFree01.setOpaque(true);
		}
		return lblFree01;
	}
	private JLabel getLblFree02() {
		if (lblFree02 == null) {
			lblFree02 = new JLabel("Free02");
			lblFree02.setVerticalAlignment(SwingConstants.TOP);
			lblFree02.setOpaque(true);
			lblFree02.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree02.setBounds(415, 310, 34, 34);
		}
		return lblFree02;
	}
	private JLabel getLblFree03() {
		if (lblFree03 == null) {
			lblFree03 = new JLabel("Free03");
			lblFree03.setVerticalAlignment(SwingConstants.TOP);
			lblFree03.setOpaque(true);
			lblFree03.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree03.setBounds(450, 310, 34, 34);
		}
		return lblFree03;
	}
	private JLabel getLblFree04() {
		if (lblFree04 == null) {
			lblFree04 = new JLabel("Free04");
			lblFree04.setVerticalAlignment(SwingConstants.TOP);
			lblFree04.setOpaque(true);
			lblFree04.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree04.setBounds(485, 310, 34, 34);
		}
		return lblFree04;
	}
	private JLabel getLblFree05() {
		if (lblFree05 == null) {
			lblFree05 = new JLabel("Free05");
			lblFree05.setVerticalAlignment(SwingConstants.TOP);
			lblFree05.setOpaque(true);
			lblFree05.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree05.setBounds(520, 310, 34, 34);
		}
		return lblFree05;
	}
	private JLabel getLblFree06() {
		if (lblFree06 == null) {
			lblFree06 = new JLabel("Free06");
			lblFree06.setVerticalAlignment(SwingConstants.TOP);
			lblFree06.setOpaque(true);
			lblFree06.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree06.setBounds(555, 310, 34, 34);
		}
		return lblFree06;
	}
	private JLabel getLblFree07() {
		if (lblFree07 == null) {
			lblFree07 = new JLabel("Free07");
			lblFree07.setVerticalAlignment(SwingConstants.TOP);
			lblFree07.setOpaque(true);
			lblFree07.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree07.setBounds(590, 310, 34, 34);
		}
		return lblFree07;
	}
	private JLabel getLblFree08() {
		if (lblFree08 == null) {
			lblFree08 = new JLabel("Free08");
			lblFree08.setVerticalAlignment(SwingConstants.TOP);
			lblFree08.setOpaque(true);
			lblFree08.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree08.setBounds(625, 310, 34, 34);
		}
		return lblFree08;
	}
	private JLabel getLblFree09() {
		if (lblFree09 == null) {
			lblFree09 = new JLabel("Free09");
			lblFree09.setVerticalAlignment(SwingConstants.TOP);
			lblFree09.setOpaque(true);
			lblFree09.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree09.setBounds(660, 310, 34, 34);
		}
		return lblFree09;
	}
	private JLabel getLblFree10() {
		if (lblFree10 == null) {
			lblFree10 = new JLabel("Free10");
			lblFree10.setVerticalAlignment(SwingConstants.TOP);
			lblFree10.setOpaque(true);
			lblFree10.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree10.setBounds(695, 310, 34, 34);
		}
		return lblFree10;
	}
	private JLabel getLblFree11() {
		if (lblFree11 == null) {
			lblFree11 = new JLabel("Free11");
			lblFree11.setVerticalAlignment(SwingConstants.TOP);
			lblFree11.setOpaque(true);
			lblFree11.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree11.setBounds(730, 310, 34, 34);
		}
		return lblFree11;
	}
	private JLabel getLblFree12() {
		if (lblFree12 == null) {
			lblFree12 = new JLabel("Free12");
			lblFree12.setVerticalAlignment(SwingConstants.TOP);
			lblFree12.setOpaque(true);
			lblFree12.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree12.setBounds(765, 310, 34, 34);
		}
		return lblFree12;
	}
	private JLabel getLblFree13() {
		if (lblFree13 == null) {
			lblFree13 = new JLabel("Free13");
			lblFree13.setVerticalAlignment(SwingConstants.TOP);
			lblFree13.setOpaque(true);
			lblFree13.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree13.setBounds(450, 490, 34, 34);
		}
		return lblFree13;
	}
	private JLabel getLblFree14() {
		if (lblFree14 == null) {
			lblFree14 = new JLabel("Free14");
			lblFree14.setVerticalAlignment(SwingConstants.TOP);
			lblFree14.setOpaque(true);
			lblFree14.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree14.setBounds(485, 490, 34, 34);
		}
		return lblFree14;
	}
	private JLabel getLblFree15() {
		if (lblFree15 == null) {
			lblFree15 = new JLabel("Free15");
			lblFree15.setVerticalAlignment(SwingConstants.TOP);
			lblFree15.setOpaque(true);
			lblFree15.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree15.setBounds(520, 490, 34, 34);
		}
		return lblFree15;
	}
	private JLabel getLblFree16() {
		if (lblFree16 == null) {
			lblFree16 = new JLabel("Free16");
			lblFree16.setVerticalAlignment(SwingConstants.TOP);
			lblFree16.setOpaque(true);
			lblFree16.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree16.setBounds(555, 490, 34, 34);
		}
		return lblFree16;
	}
	private JLabel getLblFree17() {
		if (lblFree17 == null) {
			lblFree17 = new JLabel("Free17");
			lblFree17.setVerticalAlignment(SwingConstants.TOP);
			lblFree17.setOpaque(true);
			lblFree17.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree17.setBounds(590, 490, 34, 34);
		}
		return lblFree17;
	}
	private JLabel getLblFree18() {
		if (lblFree18 == null) {
			lblFree18 = new JLabel("Free18");
			lblFree18.setVerticalAlignment(SwingConstants.TOP);
			lblFree18.setOpaque(true);
			lblFree18.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree18.setBounds(625, 490, 34, 34);
		}
		return lblFree18;
	}
	private JLabel getLblFree19() {
		if (lblFree19 == null) {
			lblFree19 = new JLabel("Free19");
			lblFree19.setVerticalAlignment(SwingConstants.TOP);
			lblFree19.setOpaque(true);
			lblFree19.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree19.setBounds(660, 490, 34, 34);
		}
		return lblFree19;
	}
	private JLabel getLblFree20() {
		if (lblFree20 == null) {
			lblFree20 = new JLabel("Free20");
			lblFree20.setVerticalAlignment(SwingConstants.TOP);
			lblFree20.setOpaque(true);
			lblFree20.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree20.setBounds(695, 490, 34, 34);
		}
		return lblFree20;
	}
	private JLabel getLblFree21() {
		if (lblFree21 == null) {
			lblFree21 = new JLabel("Free21");
			lblFree21.setVerticalAlignment(SwingConstants.TOP);
			lblFree21.setOpaque(true);
			lblFree21.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree21.setBounds(730, 490, 34, 34);
		}
		return lblFree21;
	}
	private JLabel getLblFree22() {
		if (lblFree22 == null) {
			lblFree22 = new JLabel("Free22");
			lblFree22.setVerticalAlignment(SwingConstants.TOP);
			lblFree22.setOpaque(true);
			lblFree22.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblFree22.setBounds(765, 490, 34, 34);
		}
		return lblFree22;
	}
	private JLabel getLblCabinet01() {
		if (lblCabinet01 == null) {
			lblCabinet01 = new JLabel("Cabinet01");
			lblCabinet01.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet01.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet01.setOpaque(true);
			lblCabinet01.setBounds(850, 40, 59, 59);
		}
		return lblCabinet01;
	}
	private JLabel getLblCabinet02() {
		if (lblCabinet02 == null) {
			lblCabinet02 = new JLabel("Cabinet02");
			lblCabinet02.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet02.setOpaque(true);
			lblCabinet02.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet02.setBounds(850, 100, 59, 59);
		}
		return lblCabinet02;
	}
	private JLabel getLblCabinet03() {
		if (lblCabinet03 == null) {
			lblCabinet03 = new JLabel("Cabinet03");
			lblCabinet03.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet03.setOpaque(true);
			lblCabinet03.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet03.setBounds(850, 160, 59, 59);
		}
		return lblCabinet03;
	}
	private JLabel getLblCabinet04() {
		if (lblCabinet04 == null) {
			lblCabinet04 = new JLabel("Cabinet04");
			lblCabinet04.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet04.setOpaque(true);
			lblCabinet04.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet04.setBounds(850, 220, 59, 59);
		}
		return lblCabinet04;
	}
	private JLabel getLblCabinet05() {
		if (lblCabinet05 == null) {
			lblCabinet05 = new JLabel("Cabinet05");
			lblCabinet05.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet05.setOpaque(true);
			lblCabinet05.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet05.setBounds(850, 280, 59, 59);
		}
		return lblCabinet05;
	}
	private JLabel getLblCabinet06() {
		if (lblCabinet06 == null) {
			lblCabinet06 = new JLabel("Cabinet06");
			lblCabinet06.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet06.setOpaque(true);
			lblCabinet06.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet06.setBounds(850, 340, 59, 59);
		}
		return lblCabinet06;
	}
	private JLabel getLblCabinet07() {
		if (lblCabinet07 == null) {
			lblCabinet07 = new JLabel("Cabinet07");
			lblCabinet07.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet07.setOpaque(true);
			lblCabinet07.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet07.setBounds(910, 40, 59, 59);
		}
		return lblCabinet07;
	}
	private JLabel getLblCabinet08() {
		if (lblCabinet08 == null) {
			lblCabinet08 = new JLabel("Cabinet08");
			lblCabinet08.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet08.setOpaque(true);
			lblCabinet08.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet08.setBounds(910, 100, 59, 59);
		}
		return lblCabinet08;
	}
	private JLabel getLblCabinet09() {
		if (lblCabinet09 == null) {
			lblCabinet09 = new JLabel("Cabinet09");
			lblCabinet09.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet09.setOpaque(true);
			lblCabinet09.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet09.setBounds(910, 160, 59, 59);
		}
		return lblCabinet09;
	}
	private JLabel getLblCabinet10() {
		if (lblCabinet10 == null) {
			lblCabinet10 = new JLabel("Cabinet10");
			lblCabinet10.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet10.setOpaque(true);
			lblCabinet10.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet10.setBounds(910, 220, 59, 59);
		}
		return lblCabinet10;
	}
	private JLabel getLblCabinet11() {
		if (lblCabinet11 == null) {
			lblCabinet11 = new JLabel("Cabinet11");
			lblCabinet11.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet11.setOpaque(true);
			lblCabinet11.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet11.setBounds(910, 280, 59, 59);
		}
		return lblCabinet11;
	}
	private JLabel getLblCabinet12() {
		if (lblCabinet12 == null) {
			lblCabinet12 = new JLabel("Cabinet12");
			lblCabinet12.setVerticalAlignment(SwingConstants.TOP);
			lblCabinet12.setOpaque(true);
			lblCabinet12.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblCabinet12.setBounds(910, 340, 59, 59);
		}
		return lblCabinet12;
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
					new AdminLogin().setVisible(true);
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
	public void refresh() {
		timeSet();
		tableInit();
		searchTableAction();
		selectNowUse();
		selectTableViewAction();
	}
	
	private void addMouseListenerToLabel(JLabel label) {
//	    label.addMouseListener(new LabelMouseListner());
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component c = e.getComponent();
	            if (c instanceof JLabel) {
	                JLabel label = (JLabel) c;
	                ArrayList<SeatDto> dtoList = new ArrayList<SeatDto>();
	                AdminDao dao = new AdminDao();
	                dtoList = dao.selectSeat("productid", label.getText(), 0);
	                AdminOnSeatInfo seatInfo = new AdminOnSeatInfo();
	                seatInfo.getSeatInfo("좌석 정보", dtoList, 0);
	                seatInfo.addWindowListener(new WindowAdapter() {
	                	public void windowClosed(WindowEvent e) {
	                		refresh();
	                	}
	                });
	                seatInfo.setVisible(true);
	            }
			}
		});
	}
	
	private void timeSet() {
		TimeStampFlow time = new TimeStampFlow(lblNewLabel_3);
		time.start();
	}
	
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
		for(int i = 0; i<rowCount; i++) {
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
	
	private void selectTableViewAction() {
		JLabel[] labelList = {lblCabinet01, lblCabinet02, lblCabinet03, lblCabinet04, lblCabinet05, lblCabinet06, lblCabinet07,
				lblCabinet08, lblCabinet09, lblCabinet10, lblCabinet11, lblCabinet12, lblFixed01, lblFixed02, lblFixed03,
				lblFixed04, lblFixed05, lblFixed06, lblFixed07, lblFixed08, lblFixed09, lblFixed10, lblFixed11, lblFixed12,
				lblFixed13, lblFixed14, lblFixed15, lblFixed16, lblFree01, lblFree02, lblFree03, lblFree04, lblFree05, lblFree06,
				lblFree07, lblFree08, lblFree09, lblFree10, lblFree11, lblFree12, lblFree13, lblFree14, lblFree15, lblFree16,
				lblFree17, lblFree18, lblFree19, lblFree20, lblFree21, lblFree22, lblStudyRoom};
		SeatDao sDao = new SeatDao();
		ArrayList<ProductDto> dtoList = new ArrayList<ProductDto>();
		dtoList = sDao.isOnSeat();
		int listCount = dtoList.size();
		
		for(int i = 0; i < listCount; i++) {
			if(labelList[i].getText().equals(dtoList.get(i).getProductid())){
				if(dtoList.get(i).getStatus() == 1) {
					labelList[i].setBackground(Color.GRAY);
				}else {
					labelList[i].setBackground(Color.ORANGE);
				}
			}
		}
	}
	
	private void selectNowUse() {
		ArrayList<Integer> isUse = new ArrayList<Integer>();
		AdminDao dao = new AdminDao();
		isUse = dao.selectSeat();
		lblUsingFree.setText("현재 이용자 : " + isUse.get(0));
		lblEmptyFree.setText("비어 있는 자리 : " + isUse.get(1));
		lblUsingCabinet.setText("사물함 이용 : " + isUse.get(2));
		lblEmptyCabinet.setText("사물함 남은 개수 : " + isUse.get(3));
	}
	
}

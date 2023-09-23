package com.javalec.user;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminDao;
import com.javalec.dao.SeatDao;
import com.javalec.dto.AdminDto;
import com.javalec.dto.SeatDto;
import com.javalec.util.ShareVar;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeatPriceTag extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable innerTable;
	
	//Tabled
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatPriceTag frame = new SeatPriceTag();
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
	public SeatPriceTag() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
			}
			
			
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnGoBack());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 68, 410, 183);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setEnabled(false);
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
			
		}
		return innerTable;
	}
	private JButton getBtnGoBack() {
		if (btnGoBack == null) {
			btnGoBack = new JButton("닫기");
			btnGoBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
			btnGoBack.setBackground(new Color(94, 178, 234));
			btnGoBack.setBounds(320, 10, 102, 38);
		}
		return btnGoBack;
	}
	
	//--------------------Function------------
	private void tableInit() {
		outerTable.addColumn("타입");
		outerTable.addColumn("상품명");
		outerTable.addColumn("이용시간");
		outerTable.addColumn("금액");
		outerTable.setColumnCount(4);
		
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width =  101;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 101;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 101;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 101;
		col.setPreferredWidth(width);
	
		int i = outerTable.getRowCount();
		System.out.println(i);
		
		for(int j =0; j < i ; j++) {
			outerTable.removeRow(0);
		}
	}
	
	/*
	private void searchAction() {
		SeatDao seatdao = new SeatDao();
	//	System.out.println(Integer.toString(listCount));
		try {
			seatdtoList = dao.selectList();
			
			int listCount = seatdtoList.size();
			for(int i=0; i<listCount; i++) {
				Object[] tempData = {seatdtoList.get(i).getPriceCategory(),
						seatdtoList.get(i).getPriceCategory(),seatdtoList.get(i).getPriceCategory(),seatdtoList.get(i).getTimeprice()};
				
				outerTable.addRow(tempData);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	private void searchAction() {
	    SeatDao seatDao = new SeatDao();

	    try {
	        ArrayList<SeatDto> seatdtoList = seatDao.selectList();
	        int listCount = seatdtoList.size();
	        
	        for (int i = 0; i < listCount; i++) {
	            SeatDto seatDto = seatdtoList.get(i);
	            int timePrice = seatDto.getTimeprice();
	            String convertedPriceCategory = null;
	            // pricecategory 값에 따라 변환
	            
	            if (seatDto.gettime().contains("Cabinet")) {
	                convertedPriceCategory = "캐비닛";
	            } else if (seatDto.gettime().contains("Fixed")) {
	                convertedPriceCategory = "지정석";
	            } else if (seatDto.gettime().contains("Free")) {
	                convertedPriceCategory = "자유석";
	            } else if (seatDto.gettime().contains("Room")) {
	                convertedPriceCategory = "스터디룸";
	            }
	            
	            // 이용시간 추출
	            String usageType;
	            String usageTime;
	            if (seatDto.gettime().contains("Date")) {
	                usageType = "기간권";
	                usageTime = seatDto.gettime().substring(seatDto.gettime().indexOf("Date") + 4);
	            } else if (seatDto.gettime().contains("Time")) {
	                usageType = "시간제";
	                usageTime = seatDto.gettime().substring(seatDto.gettime().indexOf("Time") + 4);
	            } else {
	                usageType = "";
	                usageTime = "";
	            }

	            
	            // 변환된 값을 사용하여 작업 수행
	            System.out.println(convertedPriceCategory);
	            String[] tempData = {convertedPriceCategory, usageType, usageTime, Integer.toString(timePrice) };
	            outerTable.addRow(tempData);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	
	
	
	
}//End

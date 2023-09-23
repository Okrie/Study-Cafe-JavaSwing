package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.AdminDao;
import com.javalec.dao.SeatDao;
import com.javalec.dao.UserDao;
import com.javalec.dto.CustomerDto;
import com.javalec.dto.ProductDto;
import com.javalec.dto.PurchaseDto;
import com.javalec.dto.SeatDto;
import com.javalec.function.UsingPopup;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminOnSeatInfo extends JFrame {

	private JPanel contentPane;
	private JLabel lblInfoLabel1;
	private JLabel lblInfoLabel2;
	private JLabel lblInfoLabel3;
	private JLabel lblInfoLabel4;
	private JLabel lblInfoLabel5;
	private JButton btnInfo0;
	private JButton btnInfo1;
	private JButton btnInfo2;
	private JButton btnInfo3;
	
	// 정보 화면 분리를 위한 전역변수 인자
	private int isInfo = -1;
	ArrayList<SeatDto> seatDto = new ArrayList<SeatDto>();
	ArrayList<CustomerDto> cusDto = new ArrayList<CustomerDto>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOnSeatInfo frame = new AdminOnSeatInfo();
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
	public AdminOnSeatInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInfoLabel1 = new JLabel("정보 1");
		lblInfoLabel1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel1.setBounds(15, 20, 400, 35);
		contentPane.add(lblInfoLabel1);
		
		lblInfoLabel2 = new JLabel("정보 2");
		lblInfoLabel2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel2.setBounds(15, 65, 400, 35);
		contentPane.add(lblInfoLabel2);
		
		lblInfoLabel3 = new JLabel("정보 3");
		lblInfoLabel3.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel3.setBounds(15, 110, 400, 35);
		contentPane.add(lblInfoLabel3);
		
		lblInfoLabel4 = new JLabel("정보 4");
		lblInfoLabel4.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel4.setBounds(15, 155, 400, 35);
		contentPane.add(lblInfoLabel4);
		
		lblInfoLabel5 = new JLabel("정보 5");
		lblInfoLabel5.setFont(new Font("굴림", Font.PLAIN, 15));
		lblInfoLabel5.setBounds(15, 200, 400, 35);
		contentPane.add(lblInfoLabel5);
		
		btnInfo1 = new JButton("버튼 1");
		btnInfo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isInfo == 0) {
					SeatDao dao = new SeatDao();
					dao.isOnOffSeat(isInfo, seatDto.get(0).getProductid());
					UsingPopup popuptest = new UsingPopup("자리가 열렸습니다.\n 이제부터 사용 가능합니다.", "", "좌석 정보", 0);
					isInfo = 1;
					dispose();
					
				} else if(isInfo == 1) {
					UsingPopup popuptest = new UsingPopup(seatDto.get(0).getCustomerid() + " 유저가 삭제됩니다.\n", "", "유저 정보", 1);
					UserDao dao = new UserDao(seatDto.get(0).getCustomerid());
					if(dao.delUser()) {
						UsingPopup succePopup = new UsingPopup(seatDto.get(0).getCustomerid() + " 유저가 삭제되었습니다.\n", "", "유저 정보", 0);
						dispose();
					} else {
						UsingPopup succePopup = new UsingPopup("삭제 도중 에러가 발생하였습니다.\n", "0002", "유저 정보", 2);
					}
				}
				if(isInfo == 2) {
					UsingPopup popuptest = new UsingPopup(cusDto.get(0).getCustomerid() + " 유저가 삭제됩니다.\n", "", "유저 정보", 1);
					UserDao dao = new UserDao(cusDto.get(0).getCustomerid());
					if(dao.delUser()) {
						UsingPopup succePopup = new UsingPopup(cusDto.get(0).getCustomerid() + " 유저가 삭제되었습니다.\n", "", "유저 정보", 0);
						dispose();
					} else {
						UsingPopup succePopup = new UsingPopup("삭제 도중 에러가 발생하였습니다.\n", "0002", "유저 정보", 2);
					}
				}
				
			}
		});
		btnInfo1.setFont(new Font("굴림", Font.PLAIN, 13));
		btnInfo1.setBounds(20, 380, 140, 35);
		contentPane.add(btnInfo1);
		
		btnInfo2 = new JButton("버튼 2"); 
		btnInfo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isInfo == 0) {
					SeatDao dao = new SeatDao();
					if(dao.isOnOffSeat(1, seatDto.get(0).getProductid())) {
						UsingPopup popuptest = new UsingPopup("자리가 닫혔습니다.\n 이제부터 사용 불가능합니다.", "", "좌석 정보", 0);
						dispose();
					} else {
						UsingPopup popuptest = new UsingPopup("자리를 닫는 도중 에러가 발생했습니다.", "0003", "좌석 정보", 2);
						dispose();
					}
				}
			}
		});
		btnInfo2.setFont(new Font("굴림", Font.PLAIN, 13));
		btnInfo2.setBounds(235, 380, 140, 35);
		contentPane.add(btnInfo2);
		
		btnInfo3 = new JButton("버튼 3");
		btnInfo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnInfo3.setFont(new Font("굴림", Font.PLAIN, 13));
		btnInfo3.setBounds(450, 380, 140, 35);
		contentPane.add(btnInfo3);
		
		btnInfo0 = new JButton("버튼 0");
		btnInfo0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isInfo == 0) {
					// 좌석정보 받아 왔을 때
					AdminDao dao = new AdminDao();
					ArrayList<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
					dtoList = dao.selectOrder("c.customerid", Integer.toString(seatDto.get(0).getCustomerid()), 1);
					getSeatInfo("사용자 정보", seatDto, 1);
				}
			}
		});
		btnInfo0.setFont(new Font("굴림", Font.PLAIN, 13));
		btnInfo0.setBounds(20, 315, 140, 35);
		contentPane.add(btnInfo0);
	}
	
	// 전 화면에서 정보를 넘겨 받아 화면 출력하기 위한 함수
	public void getSeatInfo(String title, ArrayList<SeatDto> dto, int isInfo) {
		this.isInfo = isInfo;
		this.setTitle(title);
		seatDto = dto;
		if(isInfo == 0) { 
			lblInfoLabel1.setText("좌석 넘버 : " + dto.get(0).getProductid());
			lblInfoLabel2.setText("사용자 : " + dto.get(0).getCustomerid());
			lblInfoLabel3.setText("이용 시작 시간 : " + dto.get(0).getStartDateT());
			lblInfoLabel4.setText("종료 시간 : " + dto.get(0).getEndDateT());
			lblInfoLabel5.setText("이용권 : " + dto.get(0).getPriceCategory());
			btnInfo0.setText("사용자 확인");
			btnInfo1.setText("자리 열기");
			btnInfo2.setText("자리 닫기");
			if(dto.get(0).getStatus().equals("0")) {
				// 자리가 열려 있을때는 닫기 가능
				btnInfo0.setEnabled(false);
				btnInfo1.setEnabled(false);
				btnInfo2.setEnabled(true);
			}
			if(dto.get(0).getCustomerid() > 0){
				// 사람이 존재 할때는 자리 열기, 닫기 불가
				btnInfo0.setEnabled(true);
				btnInfo1.setEnabled(false);
				btnInfo2.setEnabled(false);
			} 
			if(dto.get(0).getStatus().equals("1")) {
				// 자리가 닫혀 있을때는 열기 가능
				btnInfo0.setEnabled(false);
				btnInfo2.setEnabled(false);
			}
			btnInfo3.setText("확인");
		} else {
			lblInfoLabel1.setText("사용자 : " + dto.get(0).getCustomerid());
			lblInfoLabel2.setText("좌석 넘버 : " + dto.get(0).getProductid());
			lblInfoLabel3.setText("이용 시작 시간 : " + dto.get(0).getStartDateT());
			lblInfoLabel4.setText("종료 시간 : " + dto.get(0).getEndDateT());
			lblInfoLabel5.setText("이용권 : " + dto.get(0).getPriceCategory());
			btnInfo0.setVisible(false);
			btnInfo1.setText("사용자 삭제");
			btnInfo1.setEnabled(true);
			btnInfo2.setVisible(false);
			btnInfo3.setText("확인");
		} 
	}
	
	// 유저 정보 받아 오기
	public void getUserInfo(String title, ArrayList<CustomerDto> dto) {
		this.setTitle(title);
		isInfo = 2;
		cusDto = dto;
		String temp = "";
		btnInfo1.setEnabled(true);
		btnInfo2.setVisible(false);
		lblInfoLabel5.setVisible(false);
		btnInfo0.setVisible(false);
		
		lblInfoLabel1.setText("사용자 : " + dto.get(0).getCustomerid());
		lblInfoLabel2.setText("비밀 번호 : " + Integer.toString(dto.get(0).getPassword()));
		lblInfoLabel3.setText("가입 일자 : " + dto.get(0).getInsertdate());
		if(dto.get(0).getSession() == 1) {
			temp = "O";
			btnInfo1.setEnabled(false);
		} else {
			temp = "X";
		}
		lblInfoLabel4.setText("탈퇴 유무 : " + temp);
		btnInfo1.setText("사용자 삭제");
		btnInfo3.setText("확인");
	}
}

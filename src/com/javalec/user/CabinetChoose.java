package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.CabinetDao;
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
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class CabinetChoose extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnLogout;
	private JLabel lbLogout;
	private JLabel lbSeatImage;
	private JLabel lbBack;
	private JButton btnProductPurchase;
	LocalDateTime dateTime = LocalDateTime.now();

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton tglbtnC01;
	private JToggleButton tglbtnC02;
	private JToggleButton tglbtnC03;
	private JToggleButton tglbtnC04;
	private JToggleButton tglbtnC05;
	private JToggleButton tglbtnC06;
	private JToggleButton tglbtnC07;
	private JToggleButton tglbtnC08;
	private JToggleButton tglbtnC09;
	private JToggleButton tglbtnC10;
	private JToggleButton tglbtnC11;
	private JToggleButton tglbtnC12;
	
	ArrayList<Boolean> cabinetStatus = new ArrayList<>();
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
					CabinetChoose frame = new CabinetChoose();
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
	public CabinetChoose() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				 // 현재 이미 사용중인 좌석 버튼은 비활성화 및 색 변경
				disableCabinetButton();
				//ShareVar.id = "62193539"; //로그인 되었다는 가정하에 Test.
			}
		});
		setTitle("사물함 좌석 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbBack());
		contentPane.add(getBtnProductPurchase());
		contentPane.add(getTglbtnC01());
		contentPane.add(getTglbtnC02());
		contentPane.add(getTglbtnC03());
		contentPane.add(getTglbtnC04());
		contentPane.add(getTglbtnC05());
		contentPane.add(getTglbtnC06());
		contentPane.add(getTglbtnC07());
		contentPane.add(getTglbtnC08());
		contentPane.add(getTglbtnC09());
		contentPane.add(getTglbtnC10());
		contentPane.add(getTglbtnC11());
		contentPane.add(getTglbtnC12());
		contentPane.add(getLbSeatImage());
		contentPane.add(getLbLogout());
		contentPane.add(getLbTop_1());
		contentPane.add(getLbBody());
		contentPane.add(getLbBottom_1());
		
		
		// ActionListener 등록 12개 // 사물함 클릭 시 좌석번호를 ShareVar에 넘겨준다.
        tglbtnC01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC01.getText();
                // System.out.println(ShareVar.cabiNum); // test
            }
        });
        tglbtnC02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC02.getText();
            }
        });
        tglbtnC03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC03.getText();
            }
        });
        tglbtnC04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC04.getText();
            }
        });
        tglbtnC05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC05.getText();
            }
        });
        tglbtnC06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC06.getText();
            }
        });
        tglbtnC07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC07.getText();
            }
        });
        tglbtnC08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC08.getText();
            }
        });
        tglbtnC09.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC09.getText();
            }
        });
        tglbtnC10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC10.getText();
            }
        });
        tglbtnC11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC11.getText();
            }
        });
        tglbtnC12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShareVar.labelText = tglbtnC12 .getText();
            }
        });

        
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
					new Choose().main(null);
				}
			});
			lbBack.setOpaque(true);
			lbBack.setHorizontalAlignment(SwingConstants.CENTER);
			lbBack.setBackground(Color.LIGHT_GRAY);
			lbBack.setBounds(476, 187, 70, 60);
			
		}
		return lbBack;
	}
	private JButton getBtnProductPurchase() {
		if (btnProductPurchase == null) {
			btnProductPurchase = new JButton("선택");
			btnProductPurchase.setFont(new Font("굴림", Font.PLAIN, 20));
			btnProductPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ShareVar.labelText == null) { // 사물함 토글버튼이 클릭되지 않으면
						JOptionPane.showMessageDialog(null, "사물함이 선택되지 않았습니다.", "사물함 선택", JOptionPane.INFORMATION_MESSAGE);
					}else {
						dispose();
						new CabinetTimeChoose().main(null);
					}
				}
			});
			btnProductPurchase.setForeground(Color.WHITE);
			btnProductPurchase.setBackground(Color.BLACK);
			btnProductPurchase.setBounds(211, 679, 150, 50);
		}
		return btnProductPurchase;
	}
	
	private JToggleButton getTglbtnC01() {
		if (tglbtnC01 == null) {
			tglbtnC01 = new JToggleButton("Cabinet01");
			buttonGroup.add(tglbtnC01);
			tglbtnC01.setBounds(47, 315, 115, 95);
		}
		return tglbtnC01;
	}
	private JToggleButton getTglbtnC02() {
		if (tglbtnC02 == null) {
			tglbtnC02 = new JToggleButton("Cabinet02");
			buttonGroup.add(tglbtnC02);
			tglbtnC02.setBounds(174, 315, 115, 95);
		}
		return tglbtnC02;
	}
	private JToggleButton getTglbtnC03() {
		if (tglbtnC03 == null) {
			tglbtnC03 = new JToggleButton("Cabinet03");
			buttonGroup.add(tglbtnC03);
			tglbtnC03.setBounds(301, 315, 115, 95);
		}
		return tglbtnC03;
	}
	private JToggleButton getTglbtnC04() {
		if (tglbtnC04 == null) {
			tglbtnC04 = new JToggleButton("Cabinet04");
			buttonGroup.add(tglbtnC04);
			tglbtnC04.setBounds(428, 315, 115, 95);
		}
		return tglbtnC04;
	}
	private JToggleButton getTglbtnC05() {
		if (tglbtnC05 == null) {
			tglbtnC05 = new JToggleButton("Cabinet05");
			buttonGroup.add(tglbtnC05);
			tglbtnC05.setBounds(47, 420, 115, 95);
		}
		return tglbtnC05;
	}
	private JToggleButton getTglbtnC06() {
		if (tglbtnC06 == null) {
			tglbtnC06 = new JToggleButton("Cabinet06");
			buttonGroup.add(tglbtnC06);
			tglbtnC06.setBounds(174, 420, 115, 95);
		}
		return tglbtnC06;
	}
	private JToggleButton getTglbtnC07() {
		if (tglbtnC07 == null) {
			tglbtnC07 = new JToggleButton("Cabinet07");
			buttonGroup.add(tglbtnC07);
			tglbtnC07.setBounds(301, 420, 115, 95);
		}
		return tglbtnC07;
	}
	private JToggleButton getTglbtnC08() {
		if (tglbtnC08 == null) {
			tglbtnC08 = new JToggleButton("Cabinet08");
			buttonGroup.add(tglbtnC08);
			tglbtnC08.setBounds(428, 420, 115, 95);
		}
		return tglbtnC08;
	}
	private JToggleButton getTglbtnC09() {
		if (tglbtnC09 == null) {
			tglbtnC09 = new JToggleButton("Cabinet09");
			buttonGroup.add(tglbtnC09);
			tglbtnC09.setBounds(47, 525, 115, 95);
		}
		return tglbtnC09;
	}
	private JToggleButton getTglbtnC10() {
		if (tglbtnC10 == null) {
			tglbtnC10 = new JToggleButton("Cabinet10");
			buttonGroup.add(tglbtnC10);
			tglbtnC10.setBounds(174, 525, 115, 95);
		}
		return tglbtnC10;
	}
	private JToggleButton getTglbtnC11() {
		if (tglbtnC11 == null) {
			tglbtnC11 = new JToggleButton("Cabinet11");
			buttonGroup.add(tglbtnC11);
			tglbtnC11.setBounds(301, 525, 115, 95);
		}
		return tglbtnC11;
	}
	private JToggleButton getTglbtnC12() {
		if (tglbtnC12 == null) {
			tglbtnC12 = new JToggleButton("Cabinet12");
			buttonGroup.add(tglbtnC12);
			tglbtnC12.setBounds(428, 525, 115, 95);
		}
		return tglbtnC12;
	}

	// ------- Function -------
	
	// 현재 이미 사용중인 좌석의 버튼 비활성화 및 색 변경
	private void disableCabinetButton() {
		JToggleButton tbtns[]= { tglbtnC01, tglbtnC02, tglbtnC03, tglbtnC04, tglbtnC05, tglbtnC06, tglbtnC07, tglbtnC08
				, tglbtnC09, tglbtnC10, tglbtnC11, tglbtnC12 }; // for문 돌리기 위해 배열로 묶어주었다
		CabinetDao cabinetDao = new CabinetDao();
		ArrayList<Integer> cabinetStatus = cabinetDao.getCabinetStatus(); // 사물함의 status를 db에서 받아온다


		for (int i = 0; i < cabinetStatus.size(); i++) {
			if (cabinetStatus.get(i) == 0) { // status가 0일때는 disabled
				tbtns[i].setEnabled(false);;
			}
		}
	}
	private JLabel getLbTop_1() {
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
	private JLabel getLbBottom_1() {
		if (lbBottom == null) {
			lbBottom = new JLabel("");
			ImageResize icon = new ImageResize(585, 150, "Bottom.png");
			lbBottom.setIcon(icon.resizeImage());
			lbBottom.setBounds(0, 809, 585, 150);
		}
		return lbBottom;
	}
} // End

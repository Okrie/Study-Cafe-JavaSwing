package com.javalec.user;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.Image;

import com.javalec.admin.AdminMain;
import com.javalec.dao.LoginDao;
import com.javalec.dao.NoticeDao;
import com.javalec.dto.NoticeDto;
import com.javalec.function.ImageResize;
import com.javalec.function.UsingPopup;
import com.javalec.util.ShareVar;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;

//push test
public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblPassword;
	private JPasswordField tfPassword;

	String message = "";
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable innertable;
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private final DefaultTableModel outerTable1 = new DefaultTableModel();
	private JLabel lblRegister;
	private JLabel lblFindPW;
	private JLabel lblLogin;
	private JTextArea textArea;
	private JLabel lblTop;
	private JLabel lblbody;
	private JLabel lblBottom;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
//				tableInit1();
			}
		});
		setTitle("로그인화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 100, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblId());
		contentPane.add(getTfId());
		contentPane.add(getLblPassword());
		contentPane.add(getTfPassword());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblRegister());
		contentPane.add(getLblFindPW());
		contentPane.add(getLblLogin());
		contentPane.add(getTextArea());
		contentPane.add(getLblTop());
		contentPane.add(getLblbody());
		contentPane.add(getLblBottom());
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID :");
			lblId.setHorizontalAlignment(SwingConstants.RIGHT);
			lblId.setBounds(121, 590, 57, 15);
		}
		return lblId;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(240, 587, 149, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("password :");
			lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPassword.setBounds(98, 618, 80, 15);
		}
		return lblPassword;
	}
	private JPasswordField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JPasswordField();
			tfPassword.setBounds(190, 612, 199, 26);
		}
		return tfPassword;
	}
	private int insertFieldCheck() {
		int i = 0;
		if(tfId.getText().trim().length() == 0) {
			i++;
			message = "아이디를 ";
			tfId.requestFocus();
		}
		if(tfPassword.getText().trim().length() == 0) {
			i++;
			message = "비밀번호를 ";
			tfPassword.requestFocus();
		}

				
		return i;
	}
	
	private boolean checkAction() { 
		boolean result;
		String id = tfId.getText();
		String password = tfPassword.getText();
		
		LoginDao dao = new LoginDao(id, password); 
		if(id.equals("customer")) {
			result = dao.checkAction(1);
		} else {
			result = dao.checkAction(0);
		}
		
		return result;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("010 - ");
			lblNewLabel.setBounds(197, 589, 57, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(21, 162, 111, 16);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			scrollPane.setBounds(31, 162, 526, 135);
			scrollPane.setViewportView(getInnertable());
			Font font = innertable.getFont();
	        Font newFont = font.deriveFont(font.getSize() + 5f); // 원하는 크기로 조정
	        innertable.setFont(newFont);
		}
		return scrollPane;
	}
	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable();
			innertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//				tableInit1();
				tableClick();
				}
			});
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.setModel(outerTable); 
			
		}
		return innertable;
	}
		


		
		private void searchAction() {
		      NoticeDao noticedao = new NoticeDao();
		      ArrayList<NoticeDto> dtoList = noticedao.viewList();
		      int listCount = dtoList.size();
		      
		      for(int i = 0; i < listCount; i++) {
		    	  String seq = Integer.toString(dtoList.get(i).getSeq());
		         String[] qTxt = {
		        		 seq,
		        	 dtoList.get(i).getTitle(), 
		                  dtoList.get(i).getContents()
		                  };
		         outerTable.addRow(qTxt); // 
		      }
		}
		
		// 화면의 Table 정리
		   private void tableInit() {
			  outerTable.addColumn("순서");
		      outerTable.addColumn("제목");
		      outerTable.setColumnCount(2);
		      
		      int rowCount = outerTable.getRowCount(); // 
		      for(int i=0; i<rowCount; i++) { //
		         outerTable.removeRow(0); // 
		      }
		      
		      innertable.setAutoResizeMode(innertable.AUTO_RESIZE_OFF); // 
		      
		      int vColIndex = 0; //
		      TableColumn col = innertable.getColumnModel().getColumn(vColIndex); // 
		      int width = 30;
		      col.setPreferredWidth(width); //
		            
		      vColIndex = 1;
		      col = innertable.getColumnModel().getColumn(vColIndex); // 
		      width = 500;
		      col.setPreferredWidth(width); //
		     
		   }
		   
//		   private void tableInit1() {
//			      outerTable1.addColumn("내용");
//			      outerTable1.setColumnCount(1);
//			      
//			      int rowCount = outerTable1.getRowCount(); // 
//			      for(int i=0; i<rowCount; i++) { // 
//			         outerTable1.removeRow(0); // 
//			      }
//			      
//			      innertable1.setAutoResizeMode(innertable1.AUTO_RESIZE_OFF); //
//			      
//			      int vColIndex = 0; // 
//			      TableColumn col = innertable1.getColumnModel().getColumn(vColIndex); 
//			      int width = 550;
//			      col.setPreferredWidth(width); // 
//			            
//			     
//			   }
//			   
//		   
		   
		   private int isNewUser() {
	            LoginDao loginDao = new LoginDao();
	            return loginDao.isNewUser();
	         }

		   private void tableClick() {
				int i = innertable.getSelectedRow();//  몇번째 줄을 클릭했는지
				String wkSequence = (String) innertable.getValueAt(i, 0); //i번째 줄에 0번을 가져오겠다
				int wkSeqno = Integer.parseInt(wkSequence);
				
				NoticeDao dao = new NoticeDao();
				NoticeDto dto = dao.tableClick(wkSeqno);
				String qTxt =  dto.getContents() ;
				int maxCharactersPerLine = 20; // 한 줄에 표시할 최대 글자 수
			    StringBuilder sb = new StringBuilder();
			    int count = 0;
			    for (char c : qTxt.toCharArray()) {
			        sb.append(c);
			        count++;
			        if (count >= maxCharactersPerLine && c == ' ') { // 최대 글자 수를 초과하고 공백 문자를 만났을 때
			            sb.append(System.lineSeparator()); // 줄 바꿈 추가
			            count = 0; // 글자 수 초기화
			        }
			    }
			    String formattedText = sb.toString();
			    // TextArea에 값을 설정합니다.
			    textArea.setText(formattedText);
		   }
				
				
				
			
	private JLabel getLblRegister() {
		if (lblRegister == null) {
			lblRegister = new JLabel("");
			ImageResize image = new ImageResize(90,50,"Registericon.png");
			lblRegister.setIcon(image.resizeImage());
			
			// 리사이즈된 이미지를 사용하여 lbBack 아이콘 변경
			lblRegister.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Register().setVisible(true);
				}
			});
			lblRegister.setBounds(169, 670, 116, 50);
		}
		return lblRegister;
	}
	private JLabel getLblFindPW() {
		if (lblFindPW == null) {
			lblFindPW = new JLabel("");
			ImageResize image = new ImageResize(90,50,"FindPW.png");
			lblFindPW.setIcon(image.resizeImage());
			
			lblFindPW.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						JOptionPane.showMessageDialog(null, "관리자에게 문의하세요 \n 010-0000-0000", "비밀번호 찾기", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			lblFindPW.setBounds(297, 670, 116, 50);
		}
		return lblFindPW;
	}
	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("");
			ImageResize image = new ImageResize(95,23,"LogInicon.png");
			lblLogin.setIcon(image.resizeImage());
			lblLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = insertFieldCheck();
					if(i == 0) {
						  boolean result = checkAction();
						  if (result) {
							  	String idElse = ShareVar.id.substring(ShareVar.id.length()-4, ShareVar.id.length()); //id 8자리 중에 뒷 4자리만 보여주기
		                        JOptionPane.showMessageDialog(null, idElse + "님\n" + "환영합니다!");
							dispose();
							if (isNewUser() == 0) {
								new Choose().main(null);
							} else {
								new IfUsingUser().main(null);
							}
						} else {
							JOptionPane.showMessageDialog(null, "ID나 Password를 확인하세요!", "로그인 실패",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "로그인 정보 입력!\nID와 Password를 확인하세요!", "로그인 정보",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			lblLogin.setBounds(413, 612, 107, 26);
		}
		return lblLogin;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(31, 296, 526, 269);
			Font font = textArea.getFont();
	        Font newFont = font.deriveFont(font.getSize() + 7f); // 원하는 크기로 조정
	        textArea.setFont(newFont);
		}
		return textArea;
	}
	private JLabel getLblTop() {
		if (lblTop == null) {
			lblTop = new JLabel("");
			lblTop.setBounds(0, 0, 585, 150);
			ImageResize image = new ImageResize(585, 150, "Top.jpg");
			lblTop.setIcon(image.resizeImage());
		}
		return lblTop;
	}
	private JLabel getLblbody() {
		if (lblbody == null) {
			lblbody = new JLabel("");
			lblbody.setBounds(0, 151, 585, 658);
			ImageResize image = new ImageResize(585, 658, "body.jpg");
			lblbody.setIcon(image.resizeImage());
		}
		return lblbody;
	}
	private JLabel getLblBottom() {
		if (lblBottom == null) {
			lblBottom = new JLabel("");
			lblBottom.setBounds(0, 811, 585, 150);
			ImageResize image = new ImageResize(585, 150, "Bottom.png");
			lblBottom.setIcon(image.resizeImage());
		}
		return lblBottom;
	}
}//END

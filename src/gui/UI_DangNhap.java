package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import connectDB.ConnectDB;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import entity.NhanVien;

public class UI_DangNhap extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnDangNhap;
	private JButton btnHienThiMatKhau;
	private JPanel pnlCenter;
	private JLabel lblDangNhapHeThong;
	private JLabel lblMatKhau;
	private JLabel lblTaiKhoan;
	private JPasswordField txtMatKhau;
	private JTextField txtTaiKhoan;
	public static NhanVien e_NhanVien = null;
	public static DAO_NhanVien dao_nhanVien = new DAO_NhanVien();
	public static DAO_TaiKhoan dao_TaiKhoan = new DAO_TaiKhoan();
	public UI_DangNhap() {
		setResizable(false);
		initComponents();

	}


	private void initComponents() {
		pnlCenter = new JPanel();
		lblDangNhapHeThong = new JLabel();
		lblTaiKhoan = new JLabel();
		lblMatKhau = new JLabel();
		txtTaiKhoan = new JTextField();
		txtMatKhau = new JPasswordField();
		btnHienThiMatKhau = new JButton();
		btnDangNhap = new JButton();

		JLabel lb = new JLabel(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\HeThong.jpg"));
		pnlCenter.add(lb);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		pnlCenter.setBackground(new java.awt.Color(191, 249, 237));


		lblDangNhapHeThong.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
		lblDangNhapHeThong.setForeground(new java.awt.Color(255, 51, 51));
		lblDangNhapHeThong.setText("ĐĂNG NHẬP HỆ THỐNG");

		lblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		lblTaiKhoan.setIcon(new ImageIcon ("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\account.png")); // NOI18N
		lblTaiKhoan.setText("Tài khoản:");

		lblMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		lblMatKhau.setIcon(new ImageIcon ("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\pass.png")); // NOI18N
		lblMatKhau.setText("Mật khẩu:");

		txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTaiKhoanActionPerformed(evt);
			}
		});

		btnHienThiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
		btnHienThiMatKhau.setIcon(new ImageIcon ("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\eye.png")); // NOI18N
		btnHienThiMatKhau.setBorder(null);

		btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btnDangNhap.setForeground(new java.awt.Color(204, 51, 255));
		btnDangNhap.setIcon(new ImageIcon("D:\\icon\\key.png")); // NOI18N
		btnDangNhap.setText("Đăng Nhập");

		GroupLayout pnlCenterLayout = new GroupLayout(pnlCenter);
		pnlCenter.setLayout(pnlCenterLayout);
		pnlCenterLayout.setHorizontalGroup(
				pnlCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlCenterLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnlCenterLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(btnDangNhap)
								.addGroup(pnlCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblDangNhapHeThong)
										.addGroup(pnlCenterLayout.createSequentialGroup()
												.addComponent(lblTaiKhoan, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
										.addGroup(pnlCenterLayout.createSequentialGroup()
												.addComponent(lblMatKhau)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(btnHienThiMatKhau))))
						.addContainerGap(26, Short.MAX_VALUE))
				);
		pnlCenterLayout.setVerticalGroup(
				pnlCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlCenterLayout.createSequentialGroup()
						.addComponent(lblDangNhapHeThong, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlCenterLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblTaiKhoan)
								.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38)
						.addGroup(pnlCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pnlCenterLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblMatKhau)
										.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnHienThiMatKhau, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(24, 24, 24)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(btnDangNhap)
						.addGap(0, 0, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pnlCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pnlCenter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				);

		btnDangNhap.addActionListener(this);
		txtTaiKhoan.setText("21026511");
		txtMatKhau.setText("01012003");


		pack();
		setVisible(true);
		btnHienThiMatKhau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtMatKhau.getEchoChar() == '*') {
					txtMatKhau.setEchoChar((char) 0);
				} else {
					txtMatKhau.setEchoChar('*');
				}
			}
		});
	}
	private void LoginUser() {

		try{
			Connection con = ConnectDB.getInstance().getConnection();
			String sql="SELECT * FROM TaiKhoan where MADANGNHAP =? and MATKHAU = ?";
			PreparedStatement stmt= con.prepareCall(sql);
			stmt.setString(1, txtTaiKhoan.getText());
			stmt.setString(2, String.valueOf(txtMatKhau.getPassword()));
			ResultSet rs= stmt.executeQuery();
			if(rs.next()){
				String maDangNhap = rs.getString("MADANGNHAP"); // Lấy mã đăng nhập từ ResultSet
				e_NhanVien = dao_nhanVien.getTheoMaNV(maDangNhap);// Gọi phương thức truy vấn theo mã đăng nhập
				if (e_NhanVien != null) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					this.setVisible(false);
					new UI_TrangChu(e_NhanVien).setVisible(true);


				} else {
					JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
					txtMatKhau.setText("");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
				txtMatKhau.setText("");
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiKhoanActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtTaiKhoanActionPerformed

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UI_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UI_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UI_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UI_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UI_DangNhap().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			LoginUser();
		}


	}
}


package gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import dao.DAO_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;

import java.awt.BorderLayout;
import java.awt.Color;

public class UI_TrangChu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static  JLabel lblTenCuaHang;
	private static JPanel pnlTrangChu;
	private static JPanel pnlTongQuat;
	private static JScrollPane jScrollPane1;
	private static JLabel lblGio;
	private static JLabel lblNgay;
	private static JPanel pnlBody;
	private static JPanel pnlHeadel;
	private static JPanel pnlMenu;
	private static JPanel pnlMenus;
	private static TaiKhoan TaiKhoanlogin ;
	private static DAO_TaiKhoan dao_TaiKhoan = new DAO_TaiKhoan();
	private static NhanVien e_nhanVien;


	public static NhanVien getE_nhanVien() {
		return e_nhanVien;
	}

	public UI_TrangChu(NhanVien e_nhanVien) {
		this.e_nhanVien = e_nhanVien;
		initComponents();
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		execute();
		execute1();
		phanQuyen();
	}

	private void phanQuyen() {
		TaiKhoan e_TaiKhoan = dao_TaiKhoan.getTheoMaTK(this.e_nhanVien.getMaNV());
		TaiKhoanlogin = e_TaiKhoan;
		if (e_TaiKhoan != null) {
			String phanQuyen = e_TaiKhoan.getPhanQuyen();
			if (phanQuyen.equalsIgnoreCase("NhanVienBanHang")) {
				// Xử lý phân quyền cho nhân viên bán hàng
				UI_QuanLyTaiKhoan quanLyTK = new UI_QuanLyTaiKhoan();
				quanLyTK.setVisible(false);
				UI_QuanLyNhaCungCap quanLyNCC = new UI_QuanLyNhaCungCap();
				quanLyNCC.setVisible(false);
				//                ThonngKe thongke = new ThonngKe();
				//                thongke.setVisible(false);
			} else {
				// Xử lý phân quyền cho quyền khác
				UI_QuanLyKhuyenMai quanlyKM = new UI_QuanLyKhuyenMai();
				quanlyKM.setVisible(false);
			}
		}
	}

	public static void  execute() {
		ImageIcon iconNhanVien = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\staff.png");
		ImageIcon iconQuanAo = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\shirt.png");
		ImageIcon iconManagement = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\management.png");
		ImageIcon iconEmployee = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\employee.png");
		ImageIcon iconSearch = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\search.png");
		ImageIcon iconNhaCungCap = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\cungcap.png");
		ImageIcon iconQuanLyQuanAo = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\clothing.png");
		ImageIcon iconCargo = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\cargo.png");
		ImageIcon iconDescription = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\description.png");
		ImageIcon iconBill = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\bill.png");
		ImageIcon iconPromotion = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\promotion.png");
		ImageIcon iconKhachHang= new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\client.png");
		ImageIcon iconSee = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\see.png");
		ImageIcon iconDangXuat = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\out.jpg");
		ImageIcon iconThanhToan = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\pay.png");
		ImageIcon iconDoiMatKhau = new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\doi.png");

		JLabel label = new JLabel(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\shop.jpg"));
		pnlBody.add(label);

		// Create subMenu
		MenuItem mniQuanLyTaiKhoan = new MenuItem(iconManagement, "Quản Lý Tài Khoản", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_QuanLyTaiKhoan());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});

		MenuItem mniQuanLyNhanVien = new MenuItem(iconEmployee, "Quản Lý Nhân Viên", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				UI_QuanLyNhanVien qlnv = new UI_QuanLyNhanVien();
				pnlBody.add(qlnv);
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniTimKiemNhanVien = new MenuItem(iconSee, "Tìm Kiếm Nhân Viên", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_TimKiemNhanVien());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniDatHang = new MenuItem(iconCargo, "Đặt Hàng", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_DatHang());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniThangToan = new MenuItem(iconThanhToan, "Thanh Toán", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				try {
					pnlBody.add(new UI_ThanhToan());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniThongke = new MenuItem(iconDescription, "Thống Kê", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				try {
					pnlBody.add(new UI_ThongKe());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniLapHoaDon = new MenuItem(iconBill, "Hóa Đơn", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_HoaDon());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});

		MenuItem mniQuanLyKhachHang = new MenuItem(iconEmployee, "Quản Lý Khách Hàng", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_QuanLyKhachHang());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniTimKiemKhachHang = new MenuItem(iconSearch, "Tìm Kiếm Khách Hàng", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_TimKiemKhachHang());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});

		MenuItem mniQuanLyQuanAo;
		mniQuanLyQuanAo = new MenuItem(iconQuanLyQuanAo, "Quản Lý Quần Áo", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_QuanLyQuanAo());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});

		MenuItem mniTimKiemQuanAo = new MenuItem(iconSee, "Tìm Kiếm Quần Áo", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_TimKiemQuanAo());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniThuocTinh = new MenuItem(iconSee, "Thuộc Tính Quần Áo", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_ThuocTinhQuanAo());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniQuanLyKhuyenMai1 = new MenuItem(iconPromotion, "Quản Lý Khuyến Mãi", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_QuanLyKhuyenMai());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniTimKiemKhuyenMai = new MenuItem(iconSearch, "Tìm Kiếm Khuyến Mãi", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_TimKiemKhuyenMai());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});

		MenuItem mniQuanLyNhaCungCap = new MenuItem(iconEmployee, "Quản Lý Nhà Cung Cấp", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_QuanLyNhaCungCap());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniTimKiemNhaCungCap = new MenuItem(iconSearch, "Tìm Kiếm Nhà Cung Cấp", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlBody.removeAll();
				pnlBody.add(new UI_TimNhaCungCap());
				pnlBody.repaint();
				pnlBody.revalidate();
			}
		});
		MenuItem mniDangXuat = new MenuItem(iconDangXuat,"Đăng Xuất", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int tb = JOptionPane.showConfirmDialog(pnlBody, "Xác nhận đăng xuất?", "Thông Báo!!!",
						JOptionPane.OK_CANCEL_OPTION);
				if (tb == JOptionPane.OK_OPTION) {
					System.exit(tb);
				}
			}
		});

		MenuItem mniDoiMatKhau = new MenuItem(iconDoiMatKhau,"Đổi Mật Khẩu", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy đối tượng hiện hành
				Object currentObject = this;
				NhanVien nhanVien = getE_nhanVien();
				TaiKhoan e_TaiKhoan = dao_TaiKhoan.getTheoMaTK(nhanVien.getMaNV());
				// Kiểm tra nếu đối tượng hiện hành là UI_TrangChu
				if (currentObject instanceof UI_TrangChu) {
					// Lấy E_TaiKhoan từ đối tượng hiện hành
				}
				// Tiếp tục xử lý như cũ
				String matKhauCu = JOptionPane.showInputDialog("Nhập mật khẩu hiện tại");
				if (matKhauCu.equals(TaiKhoanlogin.getMatKhau())) {
					String matKhauMoi = JOptionPane.showInputDialog("Nhập mật khẩu mới");
					if (JOptionPane.showConfirmDialog(pnlBody, "Bạn muốn đổi mật khẩu mới", "Thông báo",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						TaiKhoan tkMoi = new TaiKhoan(TaiKhoanlogin.getMaDangNhap(), matKhauMoi, TaiKhoanlogin.getPhanQuyen());
						dao_TaiKhoan.capNhat(tkMoi);
					} else {
						JOptionPane.showMessageDialog(pnlBody, "Cập nhật thất bại");
					}
				} else {
					JOptionPane.showMessageDialog(pnlBody, "Sai mật khẩu!!!");
				}
			}
		});
		MenuItem khoangTrang = new MenuItem(null, null, null);
		khoangTrang.setOpaque(false);

		MenuItem mniNhanVien = new MenuItem(iconNhanVien, "Nhân Viên", null, mniQuanLyTaiKhoan, mniQuanLyTaiKhoan,
				mniQuanLyNhanVien, mniTimKiemNhanVien, mniDatHang ,mniThangToan, mniThongke, mniLapHoaDon);
		MenuItem mniKhachHang = new MenuItem(iconKhachHang, "Khách Hàng", null, mniQuanLyKhachHang, mniQuanLyKhachHang,
				mniTimKiemKhachHang);
		MenuItem mniQuanAo = new MenuItem(iconQuanAo, "Quần Áo", null, mniQuanLyQuanAo, mniQuanLyQuanAo,
				mniTimKiemQuanAo, mniQuanLyKhuyenMai1, mniTimKiemKhuyenMai, mniThuocTinh);
		MenuItem mniNhaCungCap = new MenuItem(iconNhaCungCap, "Nhà Cung Cấp", null, mniQuanLyNhaCungCap,
				mniQuanLyNhaCungCap, mniTimKiemNhaCungCap);

		mniNhanVien.setBackground(new Color(200, 250, 255));
		mniKhachHang.setBackground(new Color(200, 250, 255));
		mniQuanAo.setBackground(new Color(200, 250, 255));
		mniNhaCungCap.setBackground(new Color(200, 250, 255));
		mniDoiMatKhau.setBackground(new Color(120, 200, 0));
		mniDangXuat.setBackground(new Color(255, 0, 0));
		mniQuanLyTaiKhoan.setBackground(Color.pink);
		mniQuanLyNhanVien.setBackground(Color.pink);
		mniTimKiemNhanVien.setBackground(Color.pink);
		mniDatHang.setBackground(Color.pink);
		mniThangToan.setBackground(Color.pink);
		mniThongke.setBackground(Color.pink);
		mniLapHoaDon.setBackground(Color.pink);
		mniQuanLyKhachHang.setBackground(Color.pink);
		mniTimKiemKhachHang.setBackground(Color.pink);
		mniQuanLyQuanAo.setBackground(Color.pink);
		mniTimKiemQuanAo.setBackground(Color.pink);
		mniQuanLyKhuyenMai1.setBackground(Color.pink);
		mniTimKiemKhuyenMai.setBackground(Color.pink);
		mniThuocTinh.setBackground(Color.pink);
		mniQuanLyNhaCungCap.setBackground(Color.pink);
		mniTimKiemNhaCungCap.setBackground(Color.pink);
		pnlMenus.setBackground(new Color(200, 250, 255));

		addMenu(mniNhanVien, mniKhachHang, mniQuanAo, mniNhaCungCap, khoangTrang,mniDoiMatKhau, mniDangXuat);
	}

	private static void addMenu(MenuItem... menu) {
		for (int i = 0; i < menu.length; i++) {
			pnlMenus.add(menu[i]);
			ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
			for (MenuItem m : subMenu) {
				addMenu(m);
			}
		}
		pnlMenus.revalidate();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		pnlHeadel = new JPanel();
		lblTenCuaHang = new JLabel();
		pnlTongQuat = new JPanel();
		lblNgay = new JLabel();
		pnlTrangChu = new JPanel();
		lblGio = new JLabel();
		pnlMenu = new JPanel();
		jScrollPane1 = new JScrollPane();
		pnlMenus = new JPanel();
		pnlBody = new JPanel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		pnlHeadel.setBackground(new java.awt.Color(20, 71, 38));
		pnlHeadel.setPreferredSize(new java.awt.Dimension(909, 60));

		lblTenCuaHang.setFont(new java.awt.Font("Segoe UI", 1, 30)); 
		lblTenCuaHang.setForeground(new java.awt.Color(153, 255, 255));
		lblTenCuaHang.setText("CỬA HÀNG QUẦN ÁO 3 CHÀNG TRAI");

		pnlTongQuat.setBackground(new java.awt.Color(20, 71, 38));
		pnlTongQuat.setForeground(new java.awt.Color(255, 255, 255));

		lblNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
		lblNgay.setForeground(new java.awt.Color(255, 255, 255));

		GroupLayout pnlTongQuatLayout = new GroupLayout(pnlTongQuat);
		pnlTongQuat.setLayout(pnlTongQuatLayout);
		pnlTongQuatLayout.setHorizontalGroup(pnlTongQuatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(lblNgay, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE));
		pnlTongQuatLayout.setVerticalGroup(pnlTongQuatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(lblNgay, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
						22, Short.MAX_VALUE));

		pnlTrangChu.setBackground(new java.awt.Color(20, 71, 38));
		pnlTrangChu.setForeground(new java.awt.Color(255, 255, 255));

		lblGio.setBackground(new java.awt.Color(20, 71, 38));
		lblGio.setFont(new java.awt.Font("Segoe UI", 1, 14));
		lblGio.setForeground(new java.awt.Color(255, 255, 255));

		GroupLayout pnlTrangChuLayout = new GroupLayout(pnlTrangChu);
		pnlTrangChu.setLayout(pnlTrangChuLayout);
		pnlTrangChuLayout.setHorizontalGroup(
				pnlTrangChuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblGio,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pnlTrangChuLayout.setVerticalGroup(pnlTrangChuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(lblGio, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE));

		GroupLayout pnlHeadelLayout = new GroupLayout(pnlHeadel);
		pnlHeadel.setLayout(pnlHeadelLayout);
		pnlHeadelLayout.setHorizontalGroup(pnlHeadelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pnlHeadelLayout.createSequentialGroup()
						.addGroup(pnlHeadelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(pnlTongQuat, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlTrangChu, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
						.addComponent(lblTenCuaHang, GroupLayout.PREFERRED_SIZE, 720,
								GroupLayout.PREFERRED_SIZE)
						.addGap(166, 166, 166)));
		pnlHeadelLayout.setVerticalGroup(pnlHeadelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlHeadelLayout.createSequentialGroup().addContainerGap().addGroup(pnlHeadelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblTenCuaHang, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pnlHeadelLayout.createSequentialGroup()
								.addComponent(pnlTrangChu, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlTongQuat, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));

		getContentPane().add(pnlHeadel, java.awt.BorderLayout.PAGE_START);

		pnlMenu.setBackground(new java.awt.Color(20, 71, 38));
		pnlMenu.setPreferredSize(new java.awt.Dimension(200, 400));

		jScrollPane1.setBorder(null);

		pnlMenus.setLayout(new BoxLayout(pnlMenus, BoxLayout.Y_AXIS));
		jScrollPane1.setViewportView(pnlMenus);

		GroupLayout pnlMenuLayout = new GroupLayout(pnlMenu);
		pnlMenu.setLayout(pnlMenuLayout);
		pnlMenuLayout.setHorizontalGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
		pnlMenuLayout.setVerticalGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE));

		getContentPane().add(pnlMenu, java.awt.BorderLayout.LINE_START);

		pnlBody.setBackground(new java.awt.Color(255, 255, 255));
		pnlBody.setLayout(new java.awt.BorderLayout());
		getContentPane().add(pnlBody, java.awt.BorderLayout.CENTER);

		setBounds(0, 0, 923, 623);
	}
	public static void moQuanLyKhachHang1() {
		pnlBody.removeAll();
		UI_QuanLyKhachHang uI_QuanLyKhachHang = new UI_QuanLyKhachHang();
		pnlBody.setLayout(new BorderLayout());
		pnlBody.add(uI_QuanLyKhachHang, BorderLayout.CENTER);
		pnlBody.revalidate();
		pnlBody.repaint();
	}

	private void execute1() {
		// Tạo một SimpleDateFormat để định dạng thời gian
		SimpleDateFormat sdf = new SimpleDateFormat("	hh:mm:ss       dd/MM/yyyy");
		// Tạo một Timer để chạy code có thời gian hiện tại
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy thời gian hiện tại
				Date now = new Date();
				// Định dạng thời gian
				String time = sdf.format(now);
				// Set text cho jPNgayGio
				lblGio.setText(time);
			}
		});
		// Start Timer
		timer.start();
	}

	public static void main(String args[]) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UI_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UI_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UI_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UI_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}

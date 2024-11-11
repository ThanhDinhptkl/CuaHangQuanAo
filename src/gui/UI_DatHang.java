/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import dao.DAO_ChiTietHoaDon;
import dao.DAO_ChiTietPhieuDatHang;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_KhuyenMai;
import dao.DAO_KichCo;
import dao.DAO_LoaiQuanAo;
import dao.DAO_MauSac;
import dao.DAO_NhanVien;
import dao.DAO_PhieuDatHang;
import dao.DAO_QuanAo;
import dao.DAO_TaiKhoan;
import entity.ChiTietHoaDon;
import entity.ChiTietPhieuDatHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.KichCo;
import entity.LoaiQuanAo;
import entity.MauSac;
import entity.NhanVien;
import entity.PhieuDatHang;
import entity.QuanAo;

/**
 *
 * @author ThanhDinh
 */
public class UI_DatHang extends JPanel {
	private JButton btn_Giam;
	private JButton btn_XoaTatCa;
	private JButton btn_datHang;
	private JButton btn_Tim;
	private JButton btn_them;
	private JButton btn_themKH;
	private JButton btn_xoaQuanAo;
	private static JComboBox<String> cbb_ChatLieu;
	private static JComboBox<String> cbb_KichCo;
	private static JComboBox<String> cbb_MauSac;
	private static JComboBox<String> cbb_ThuongHieu;
	private static JComboBox<String> cbb_loaiQuanAo;
	private JLabel lb_ChatLieu;
	private JLabel lb_Email;
	private static JLabel lb_HinhAnh;
	private JLabel lb_KichCo;
	private JLabel lb_LoaiQuanAo;
	private JLabel lb_MauSac;
	private JLabel lb_SoDienThoai;
	private JLabel lb_TenKhachHang;
	private JLabel lb_TenQuanAo;
	private JLabel lb_ThuongHieu;
	private JLabel lb_TongTien;
	private JLabel lb_gioiTinh;
	private JLabel lb_maQuanAo;
	private JLabel lb_soLuong;
	private JLabel lbl_DatHang;
	private JLabel lbl_danhSachSanPham;
	private JLabel lbl_danhSachSanPham2;
	private JPanel pn_Center;
	private JPanel pn_DanhSachQuanAo;
	private JPanel pn_Form;
	private JPanel pn_GioHang;
	private JPanel pn_HinhAnh;
	private JPanel pn_TTQuanAo;
	private JPanel pn_ThanhToan;
	private JScrollPane scr_DSQA;
	private JScrollPane scr_GioHang;
	private static JTable tbl_GioHang;
	private static JTable tbl_danhSachQuanAo;
	private static JTextField txt_MaQuanAo;
	private static JTextField txt_TenQuanAo;
	private static JTextField txt_TongTien;
	private static JTextField txt_email;
	private static JTextField txt_gioiTinh;
	private static JTextField txt_soDienThoai;
	private static JTextField txt_soLuong;
	private static JTextField txt_tenKhachHang;
	private static DefaultTableModel model1;
	private static DefaultTableModel model2;

	
	
	private static KhachHang e_KhachHang = null;
	private static QuanAo e_QuanAo = null;
	private static ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();
	private static boolean isThemKhachHangActive = false;
	public static boolean isThanhToan = false;
	private static final DAO_PhieuDatHang dao_phieuDat = new DAO_PhieuDatHang();
	private static final DAO_ChiTietPhieuDatHang dao_CTphieuDat = new DAO_ChiTietPhieuDatHang();
	private static final DAO_QuanAo dao_quanAo = new DAO_QuanAo();
	private final DAO_LoaiQuanAo dao_loaiQuanAo = new DAO_LoaiQuanAo();
	private final DAO_MauSac dao_mauSac= new DAO_MauSac();
	private final DAO_KichCo dao_kichThuoc = new DAO_KichCo();
	private final DAO_KhachHang dao_khachHang = new DAO_KhachHang();
	private static final DAO_HoaDon dao_hoaDon = new DAO_HoaDon();
	private static final DAO_ChiTietHoaDon dao_cthd = new DAO_ChiTietHoaDon();
	private final DAO_NhanVien dao_nhanVien = new DAO_NhanVien();
	private DAO_KhuyenMai dao_khuyenMai;
	private  DAO_TaiKhoan dao_taiKhoan = new DAO_TaiKhoan();
	private final NhanVien e_NhanVien = UI_DangNhap.e_NhanVien;
	private static boolean isKhachHang = false;
	public UI_DatHang() {
		initComponents();
		initialValue();
		khoiTaoGiaTri();
		setEvent();
	}

	private void initComponents() {

		pn_Form = new JPanel();
		lbl_DatHang = new JLabel();
		pn_Center = new JPanel();
		pn_DanhSachQuanAo = new JPanel();
		scr_DSQA = new JScrollPane();
		tbl_danhSachQuanAo = new JTable();
		lbl_danhSachSanPham = new JLabel();
		pn_ThanhToan = new JPanel();
		btn_datHang = new JButton();
		btn_themKH = new JButton();
		btn_Tim = new JButton();
		txt_soDienThoai = new JTextField();
		txt_tenKhachHang = new JTextField();
		lb_SoDienThoai = new JLabel();
		lb_TongTien = new JLabel();
		lb_TenKhachHang = new JLabel();
		txt_email = new JTextField();
		lb_gioiTinh = new JLabel();
		lb_Email = new JLabel();
		txt_TongTien = new JTextField();
		txt_gioiTinh = new JTextField();
		pn_TTQuanAo = new JPanel();
		lb_TenQuanAo = new JLabel();
		lb_maQuanAo = new JLabel();
		lb_LoaiQuanAo = new JLabel();
		lb_KichCo = new JLabel();
		cbb_loaiQuanAo = new JComboBox<>();
		cbb_ThuongHieu = new JComboBox<>();
		cbb_MauSac = new JComboBox<>();
		txt_TenQuanAo = new JTextField();
		pn_HinhAnh = new JPanel();
		lb_HinhAnh = new JLabel();
		txt_MaQuanAo = new JTextField();
		lb_MauSac = new JLabel();
		lb_ThuongHieu = new JLabel();
		lb_ChatLieu = new JLabel();
		cbb_ChatLieu = new JComboBox<>();
		cbb_KichCo = new JComboBox<>();
		pn_GioHang = new JPanel();
		scr_GioHang = new JScrollPane();
		tbl_GioHang = new JTable();
		txt_soLuong = new JTextField();
		lb_soLuong = new JLabel();
		lbl_danhSachSanPham2 = new JLabel();
		btn_them = new JButton();
		btn_xoaQuanAo = new JButton();
		btn_XoaTatCa = new JButton();
		btn_Giam = new JButton();

		setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_Form.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_Form.setPreferredSize(new java.awt.Dimension(1304, 746));

		lbl_DatHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lbl_DatHang.setText("Đặt Hàng");

		pn_Center.setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_DanhSachQuanAo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		model1 = new DefaultTableModel();
		tbl_danhSachQuanAo = new JTable(model1);
		tbl_danhSachQuanAo.setRowHeight(25);     
		model1.addColumn("Mã Quần Áo");
		model1.addColumn("Tên Quần Áo");
		model1.addColumn("Loại");
		model1.addColumn("Giá");
		model1.addColumn("Màu Sắc");
		model1.addColumn("Số Lượng");
		model1.addColumn("Thương Hiệu");
		model1.addColumn("Kích Cỡ");
		model1.addColumn("Chất Liệu");

		JScrollPane sp = new JScrollPane(tbl_danhSachQuanAo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(1000, 400));
		pn_DanhSachQuanAo.add(sp);
		scr_DSQA.setViewportView(tbl_danhSachQuanAo);

		lbl_danhSachSanPham.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lbl_danhSachSanPham.setForeground(new java.awt.Color(0, 102, 255));
		lbl_danhSachSanPham.setText("Danh Sách Quần Áo\n");

		GroupLayout pn_DanhSachQuanAoLayout = new GroupLayout(pn_DanhSachQuanAo);
		pn_DanhSachQuanAo.setLayout(pn_DanhSachQuanAoLayout);
		pn_DanhSachQuanAoLayout.setHorizontalGroup(
				pn_DanhSachQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_DanhSachQuanAoLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_DanhSachQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scr_DSQA)
								.addGroup(pn_DanhSachQuanAoLayout.createSequentialGroup()
										.addComponent(lbl_danhSachSanPham, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				);
		pn_DanhSachQuanAoLayout.setVerticalGroup(
				pn_DanhSachQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_DanhSachQuanAoLayout.createSequentialGroup()
						.addComponent(lbl_danhSachSanPham, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scr_DSQA, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		

		pn_ThanhToan.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		btn_datHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		btn_datHang.setText("Đặt Hàng");
		btn_datHang.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_datHangMouseClicked(evt);
			}
		});
		btn_themKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btn_themKH.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\add.png")); // NOI18N
		btn_themKH.setText("Thêm Khách Hàng");
		btn_themKH.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_themKHMouseClicked(evt);
			}
		});
		btn_Tim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btn_Tim.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\find.png")); // NOI18N
		btn_Tim.setText("Tìm");
		btn_Tim.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_TimMouseClicked(evt);
			}
		});

		txt_soDienThoai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				txt_soDienThoaiActionPerformed(evt);
			}
		});

		txt_tenKhachHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				txt_tenKhachHangActionPerformed(evt);
			}
		});

		lb_SoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_SoDienThoai.setText("Số Điện Thoại:");

		lb_TongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_TongTien.setText("Tổng Tiền:");

		lb_TenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_TenKhachHang.setText("Tên Khách Hàng");

		lb_gioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_gioiTinh.setText("Giới Tính:");

		lb_Email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_Email.setText("Email:");

		txt_TongTien.setEditable(false);

		GroupLayout pn_ThanhToanLayout = new GroupLayout(pn_ThanhToan);
		pn_ThanhToan.setLayout(pn_ThanhToanLayout);
		pn_ThanhToanLayout.setHorizontalGroup(
				pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_ThanhToanLayout.createSequentialGroup()
						.addContainerGap(29, Short.MAX_VALUE)
						.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_ThanhToanLayout.createSequentialGroup()
										.addComponent(lb_TongTien)
										.addGap(45, 45, 45)
										.addComponent(txt_TongTien, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING, pn_ThanhToanLayout.createSequentialGroup()
										.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(lb_TenKhachHang)
												.addComponent(lb_SoDienThoai)
												.addComponent(txt_tenKhachHang, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
												.addComponent(txt_soDienThoai))
										.addGap(18, 18, 18)
										.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addGroup(GroupLayout.Alignment.TRAILING, pn_ThanhToanLayout.createSequentialGroup()
														.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(txt_gioiTinh, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
																.addComponent(lb_gioiTinh))
														.addGap(48, 48, 48)
														.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(lb_Email)
																.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
														.addGap(39, 39, 39))
												.addGroup(pn_ThanhToanLayout.createSequentialGroup()
														.addComponent(btn_Tim, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btn_themKH, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
														.addGap(27, 27, 27))))))
				.addGroup(pn_ThanhToanLayout.createSequentialGroup()
						.addGap(146, 146, 146)
						.addComponent(btn_datHang, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		pn_ThanhToanLayout.setVerticalGroup(
				pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_ThanhToanLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_SoDienThoai)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txt_soDienThoai, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Tim)
								.addComponent(btn_themKH))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_TenKhachHang)
								.addComponent(lb_gioiTinh)
								.addComponent(lb_Email))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txt_tenKhachHang, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_gioiTinh, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pn_ThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txt_TongTien, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_TongTien))
						.addGap(36, 36, 36)
						.addComponent(btn_datHang, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		pn_TTQuanAo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lb_TenQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_TenQuanAo.setText("Tên Quần Áo:");

		lb_maQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_maQuanAo.setText("Mã Quần Áo:");

		lb_LoaiQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_LoaiQuanAo.setText("Loại Quần Áo:");

		lb_KichCo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_KichCo.setText("Kích Cỡ:");

		pn_HinhAnh.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		lb_HinhAnh.setMaximumSize(new java.awt.Dimension(159, 143));
		lb_HinhAnh.setMinimumSize(new java.awt.Dimension(159, 143));
		lb_HinhAnh.setPreferredSize(new java.awt.Dimension(159, 143));

		GroupLayout pn_hinhAnhLayout = new javax.swing.GroupLayout(pn_HinhAnh);
		pn_HinhAnh.setLayout(pn_hinhAnhLayout);
		pn_hinhAnhLayout.setHorizontalGroup(
				pn_hinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lb_HinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		pn_hinhAnhLayout.setVerticalGroup(
				pn_hinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lb_HinhAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		txt_TenQuanAo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_TenQuanAoKeyReleased(evt);
			}
		});
		lb_maQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_maQuanAo.setText("Mã Quần Áo:");
		txt_MaQuanAo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_MaQuanAoKeyReleased(evt);
			}

		});
		cbb_loaiQuanAo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
		cbb_loaiQuanAo.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbb_loaiQuanAoItemStateChanged(evt);
			}

			
		});
		cbb_MauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
		cbb_MauSac.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbb_MauSacItemStateChanged(evt);
			}

			
		});
		cbb_KichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
		cbb_KichCo.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbb_KichCoItemStateChanged(evt);
			}
			
		});

		cbb_ChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
		cbb_ChatLieu.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbb_ChatLieuItemStateChanged(evt);
			}
		});
		cbb_ThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
		cbb_ThuongHieu.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbb_ThuongHieuItemStateChanged(evt);
			}
		});
		lb_HinhAnh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_HinhAnh.setText("Hình Ảnh");

		lb_MauSac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_MauSac.setText("Màu Sắc:");

		lb_ThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_ThuongHieu.setText("Thương Hiệu:");

		lb_ChatLieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_ChatLieu.setText("Chất Liệu:");

		GroupLayout pn_TTQuanAoLayout = new GroupLayout(pn_TTQuanAo);
		pn_TTQuanAo.setLayout(pn_TTQuanAoLayout);
		pn_TTQuanAoLayout.setHorizontalGroup(
				pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
						.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
														.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
																		.addGap(6, 6, 6)
																		.addComponent(lb_ChatLieu))
																.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
																		.addComponent(cbb_ChatLieu, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(lb_MauSac, GroupLayout.Alignment.LEADING)
																		.addComponent(txt_MaQuanAo, GroupLayout.Alignment.LEADING)
																		.addComponent(lb_maQuanAo, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(cbb_MauSac, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
														.addGap(38, 38, 38)
														.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(lb_LoaiQuanAo)
																.addComponent(lb_KichCo)
																.addComponent(lb_ThuongHieu)
																.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
																		.addComponent(cbb_ThuongHieu, GroupLayout.Alignment.LEADING, 0, 125, Short.MAX_VALUE)
																		.addComponent(cbb_KichCo, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(cbb_loaiQuanAo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
												.addComponent(txt_TenQuanAo, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
								.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
										.addGap(9, 9, 9)
										.addComponent(lb_TenQuanAo)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, pn_TTQuanAoLayout.createSequentialGroup()
										.addComponent(lb_HinhAnh)
										.addGap(120, 120, 120))
								.addGroup(GroupLayout.Alignment.TRAILING, pn_TTQuanAoLayout.createSequentialGroup()
										.addComponent(pn_HinhAnh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(46, 46, 46))))
				);
		pn_TTQuanAoLayout.setVerticalGroup(
				pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
						.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
										.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
														.addGap(45, 45, 45)
														.addComponent(txt_TenQuanAo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
												.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
														.addGap(14, 14, 14)
														.addComponent(lb_TenQuanAo)))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lb_LoaiQuanAo)
												.addComponent(lb_maQuanAo, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(cbb_loaiQuanAo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_MaQuanAo, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
										.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lb_MauSac)
												.addComponent(lb_KichCo))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(cbb_MauSac, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
												.addComponent(cbb_KichCo)))
								.addGroup(GroupLayout.Alignment.TRAILING, pn_TTQuanAoLayout.createSequentialGroup()
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(pn_HinhAnh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
										.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lb_ChatLieu)
												.addComponent(lb_ThuongHieu))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pn_TTQuanAoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(cbb_ThuongHieu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
												.addComponent(cbb_ChatLieu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
										.addContainerGap())
								.addGroup(pn_TTQuanAoLayout.createSequentialGroup()
										.addGap(18, 18, 18)
										.addComponent(lb_HinhAnh)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				);

		pn_GioHang.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		model2 = new DefaultTableModel();
		tbl_GioHang = new JTable(model2);
		tbl_GioHang.setRowHeight(25);     
		model2.addColumn("Mã Quần Áo");
		model2.addColumn("Tên Quần Áo");
		model2.addColumn("Số Lượng");
		model2.addColumn("Giá");
		model2.addColumn("Loại");
		model2.addColumn("Màu Sắc");
		model2.addColumn("Thương Hiệu");
		model2.addColumn("Kích Cỡ");
		model2.addColumn("Chất Liệu");


		JScrollPane sp1 = new JScrollPane(tbl_GioHang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp1.setPreferredSize(new Dimension(1000, 400));
		pn_GioHang.add(sp1);

		scr_GioHang.setViewportView(tbl_GioHang);

		lb_soLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_soLuong.setText("Số Lượng:");

		lbl_danhSachSanPham2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lbl_danhSachSanPham2.setForeground(new java.awt.Color(0, 102, 255));
		lbl_danhSachSanPham2.setText("Giỏ Hàng");

		btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btn_them.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\add.png")); // NOI18N
		btn_them.setText("Thêm");
		btn_them.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_themMouseClicked(evt);
			}
		});

		btn_xoaQuanAo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btn_xoaQuanAo.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\delete.png")); // NOI18N
		btn_xoaQuanAo.setText("Xóa Quần Áo");
		btn_xoaQuanAo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_xoaQuanAoMouseClicked(evt);
			}
		});

		btn_XoaTatCa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btn_XoaTatCa.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\delete.png")); // NOI18N
		btn_XoaTatCa.setText("Xóa Tất Cả");
		btn_XoaTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_XoaTatCaMouseClicked(evt);
			}
		});

		btn_Giam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btn_Giam.setText("Giảm");
		btn_Giam.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_GiamMouseClicked(evt);
			}
		});

		GroupLayout pn_GioHangLayout = new GroupLayout(pn_GioHang);
		pn_GioHang.setLayout(pn_GioHangLayout);
		pn_GioHangLayout.setHorizontalGroup(
				pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_GioHangLayout.createSequentialGroup()
						.addGap(24, 24, 24)
						.addComponent(lb_soLuong)
						.addGap(18, 18, 18)
						.addComponent(txt_soLuong, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addGap(31, 31, 31)
						.addComponent(btn_them, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btn_Giam, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btn_xoaQuanAo)
						.addGap(51, 51, 51)
						.addComponent(btn_XoaTatCa, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
						.addGap(47, 47, 47))
				.addGroup(pn_GioHangLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lbl_danhSachSanPham2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(scr_GioHang, GroupLayout.PREFERRED_SIZE, 1229, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(26, Short.MAX_VALUE))
				);
		pn_GioHangLayout.setVerticalGroup(
				pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_GioHangLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lbl_danhSachSanPham2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btn_xoaQuanAo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(btn_XoaTatCa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lb_soLuong)
										.addComponent(txt_soLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btn_them, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(btn_Giam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scr_GioHang, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		GroupLayout pn_CenterLayout = new GroupLayout(pn_Center);
		pn_Center.setLayout(pn_CenterLayout);
		pn_CenterLayout.setHorizontalGroup(
				pn_CenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_CenterLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_CenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pn_GioHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pn_CenterLayout.createSequentialGroup()
										.addComponent(pn_TTQuanAo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(pn_ThanhToan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(pn_DanhSachQuanAo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				);
		pn_CenterLayout.setVerticalGroup(
				pn_CenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_CenterLayout.createSequentialGroup()
						.addGroup(pn_CenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(pn_TTQuanAo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pn_ThanhToan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pn_DanhSachQuanAo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pn_GioHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(30, Short.MAX_VALUE))
				);

		GroupLayout pn_FormLayout = new GroupLayout(pn_Form);
		pn_Form.setLayout(pn_FormLayout);
		pn_FormLayout.setHorizontalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pn_Center, GroupLayout.PREFERRED_SIZE, 1269, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(13, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, pn_FormLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbl_DatHang)
						.addGap(577, 577, 577))
				);
		pn_FormLayout.setVerticalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbl_DatHang, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pn_Center, GroupLayout.PREFERRED_SIZE, 642, GroupLayout.PREFERRED_SIZE)
						.addGap(41, 41, 41))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pn_Form, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(33, Short.MAX_VALUE))
				);
		
	}// </editor-fold>//GEN-END:initComponents
	private void initialValue() { 
		ArrayList<MauSac> listMauSac = dao_mauSac.getAllMauSac();//Tạo mảng ArrayList chứa giá trị Màu và gán cho listMauSac

		for (MauSac ms : listMauSac) {
			cbb_MauSac.addItem(ms.getMauSac());//Duyệt vòng lặp for để lấy từng giá trị màu 
		}

		ArrayList<LoaiQuanAo> listLoaiQa = dao_loaiQuanAo.getAllLoai();

		for (LoaiQuanAo loaiQA : listLoaiQa) {
			cbb_loaiQuanAo.addItem(loaiQA.getLoai());
		}

		ArrayList<KichCo> listKichCo = dao_kichThuoc.getAllKichCo();

		for (KichCo kt : listKichCo) {
			cbb_KichCo.addItem(kt.getKichCo());
		}

		tblGioHang_Loc();//gọi phương thức tblDanhSachQuanAo_LocDL() hiển thị bảng ds các giá trị trên,lọc và hiển thị danh sách quần áo dựa trên các tiêu chí
	}
	private static void tblDanhSachQuanAo() {
		xoaChonDSQA();
		lamMoiBangDSQA();
		model1 = (DefaultTableModel) tbl_danhSachQuanAo.getModel();
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		ArrayList<QuanAo> listQA = dao_quanAo.getAllQuanAo();
		for (QuanAo qa : listQA) {
			String giaBan = "";
//			if () {
				giaBan = decimalFormat.format(qa.tinhGiaBanLucSau());
//			} else {
//				giaBan = decimalFormat.format(qa.tinhGiaBanLucDau());
//			}
			Object[] rowData = {qa.getMaQuanAo(), qa.getTenQuanAo(), qa.getLoaiQuanAo().getLoai(), giaBan, qa.getMauSac().getMauSac(), qa.getSoLuong(),qa.getThuongHieu().getThuongHieu(), qa.getKichCo().getKichCo(),qa.getChatLieu().getChatLieu()};
			model1.addRow(rowData);
		}
	}
	private static void tblGioHang() {
		lamMoiGioHang();
		model2 = (DefaultTableModel) tbl_GioHang.getModel();

		for (ChiTietHoaDon cthd : listChiTietHoaDon) {
			double giaBan = 0;
				giaBan = cthd.getQuanAo().tinhGiaBanLucSau();		
			Object[] dataRow = {cthd.getQuanAo().getMaQuanAo(), cthd.getQuanAo().getTenQuanAo(),cthd.getSoLuong(), giaBan};
			model2.addRow(dataRow);
		}
	}
	private static void tblGioHang_Loc() {
		// TODO Auto-generated method stub
		xoaChonDSQA();
		lamMoiBangDSQA();
		model1 = (DefaultTableModel) tbl_danhSachQuanAo.getModel();

		String maQuanAo = txt_MaQuanAo.getText();
		String tenQuanAo = txt_TenQuanAo.getText();
		String loaiQuanAo = (String) cbb_loaiQuanAo.getSelectedItem();
		if (cbb_loaiQuanAo.getSelectedItem().equals("Tất cả")) {
			loaiQuanAo = "";
		}

		String mauSac = (String) cbb_MauSac.getSelectedItem();
		if (cbb_MauSac.getSelectedItem().equals("Tất cả")) {
			mauSac = "";
		}

		String kichCo = (String) cbb_KichCo.getSelectedItem();
		if (cbb_KichCo.getSelectedItem().equals("Tất cả")) {
			kichCo = "";
		}

		ArrayList<QuanAo> listQA = dao_quanAo.getAllQuanAo(maQuanAo, tenQuanAo, loaiQuanAo, mauSac, kichCo);
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		for (QuanAo qa : listQA) {
			String giaBan = "";
//			if (qa.getKhuyenMai().getSoLuong() > 0) {
				giaBan = decimalFormat.format(qa.tinhGiaBanLucSau());
//			} else {
//				giaBan = decimalFormat.format(qa.tinhGiaBanLucDau());
//			}
			Object[] rowData = {qa.getMaQuanAo(), qa.getTenQuanAo(), qa.getLoaiQuanAo().getLoai(), giaBan,qa.getMauSac().getMauSac(),  qa.getSoLuong(),qa.getThuongHieu().getThuongHieu(), qa.getKichCo().getKichCo(), qa.getChatLieu().getChatLieu()};
			model1.addRow(rowData);
		}
	}
	//làm mới quần áo đã chọn
		private static void xoaChonDSQA() {
			// TODO Auto-generated method stub
			tbl_danhSachQuanAo.clearSelection();
		}
		//làm mới lại bảng DSQA về ban đầu
		private static void lamMoiBangDSQA() {
			model1 = (DefaultTableModel) tbl_danhSachQuanAo.getModel();
			model1.setRowCount(0);
		}
		//làm mới giỏ hàng
		private static void lamMoiGioHang() {
			model2 = (DefaultTableModel) tbl_GioHang.getModel();
			model2.setRowCount(0);
		}
	private String auto_IDPhieuDat() {
		// Tự động tạo mã hóa đơn dạng HDXXXXXX
		DAO_PhieuDatHang dao_phieuDat = new DAO_PhieuDatHang();
		String idPrefix = "PDH";
		int length = dao_phieuDat.getAllPhieuDatHang().size();
		String finalId = idPrefix + String.format("%05d", length + 1);
		return finalId; // Trả về mã hóa đơn thay vì thiết lập trực tiếp
	}
	private static void khoiTaoGiaTri() {
		listChiTietHoaDon.clear();

		e_KhachHang = null;
		isThemKhachHangActive = false;
		lb_HinhAnh.setIcon(null);
		tblGioHang_Loc();
		tblGioHang();
		isKhachHang = false;
	}
	//phương thức ràng buộc khi thêm quần áo vào giỏ hàng
		private boolean isThemValid() {
			if (!isKhachHang) {
				JOptionPane.showMessageDialog(null, "Vui lòng lấy thông tin khách hàng");
				return false;
			}
			if (e_QuanAo == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn quần áo để thêm vào giỏ hàng");
				return false;
			}

			if (txt_soLuong.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng");
				return false;
			}

			try {
				int soLuong = Integer.parseInt(txt_soLuong.getText());

				if (soLuong < 1) {
					JOptionPane.showMessageDialog(null, "Số lượng phải từ 1 trở lên");
					return false;
				}

				if (soLuong > e_QuanAo.getSoLuong()) {
					JOptionPane.showMessageDialog(null, "Số lượng phải bé hơn số hàng tồn kho");
					return false;
				}

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Số lượng phải là 1 con số lớn hơn 0");
				return false;
			}
			return true;
		}
		private static void capNhatSLSPKhiThemCTHD(QuanAo qa, int soLuong) {
			qa.setSoLuong(qa.getSoLuong() - soLuong);
			if (dao_quanAo.capNhatSoLuong(qa) == -1) {
				return;
			}
		}
		//Phương thức tính tổng tiền quần áo trong giỏ hàng theo số lượng và đơn giá
		//Cột 2 là số lượng và cộng 3 là giá bán
		private static void xuLyTinhTongTien() {
			double tongTien = 0;

			for (int i = 0; i < tbl_GioHang.getRowCount(); i++) {

				double thanhTien = Double.parseDouble(tbl_GioHang.getValueAt(i, 3).toString()) * Long.parseLong(tbl_GioHang.getValueAt(i, 2).toString());
				tongTien += thanhTien;
			}

			txt_TongTien.setText(tongTien + "");
		}
		//kiểm tra bảng CTHD có trống hay không
		private static boolean tonTaiQuanAoTrongCTHD(QuanAo qa) {

			if (tbl_GioHang.getRowCount() < 1) {
				return false;
			}
			for (int i = 0; i < tbl_GioHang.getRowCount(); i++) {
				if (tbl_GioHang.getValueAt(i, 0).equals(qa.getMaQuanAo())) {
					int soLuong = Integer.parseInt(txt_soLuong.getText());

					int tongSoQA = Integer.parseInt(tbl_GioHang.getValueAt(i, 3).toString()) + soLuong;

					tbl_GioHang.setValueAt(tongSoQA, i, 3);
					return true;
				}
			}
			return false;
		}
		// phương thức xử lý khi thêm vào giỏ hàng
		private static void xuLythemCTHD() {
		    int soLuong = Integer.parseInt(txt_soLuong.getText());

		    String maQA = (String) tbl_danhSachQuanAo.getValueAt(tbl_danhSachQuanAo.getSelectedRow(), 0);
		    QuanAo qa = dao_quanAo.TimKiemQuanAoTheoMa(maQA);

		    Date ngayBD = new java.sql.Date(qa.getKhuyenMai().getNgayBatDau().getTime());
		    Date ngayKT = new java.sql.Date(qa.getKhuyenMai().getNgayKetThuc().getTime());
		    Date ngayHT = new java.sql.Date(System.currentTimeMillis());

		    if (soLuong > 0 && (ngayHT.toString().equals(ngayBD.toString()) || ngayHT.after(ngayBD)) && ngayKT.after(ngayHT)) {
		        capNhatSLSPKhiThemCTHD(qa, soLuong);

		        model2 = (DefaultTableModel) tbl_GioHang.getModel();

		        if (!tonTaiQuanAoTrongCTHD(qa)) {
		            double giaBan = qa.tinhGiaBanLucSau();
		            Object[] rowData = {qa.getMaQuanAo(), qa.getTenQuanAo(), soLuong, giaBan * soLuong, qa.getLoaiQuanAo().getLoai(), qa.getMauSac().getMauSac(), qa.getThuongHieu().getThuongHieu(), qa.getKichCo().getKichCo(), qa.getChatLieu().getChatLieu()};
		            model2.addRow(rowData);
		        }

		        txt_soLuong.setText("");
		        xuLyTinhTongTien();
		        tblGioHang_Loc();
		        e_QuanAo = null;
		    } else {
		        capNhatSLSPKhiThemCTHD(qa, soLuong);

		        model2 = (DefaultTableModel) tbl_GioHang.getModel();

		        if (!tonTaiQuanAoTrongCTHD(qa)) {
		            double giaBan = qa.tinhGiaBanLucDau();
		            Object[] rowData = {qa.getMaQuanAo(), qa.getTenQuanAo(), soLuong, giaBan * soLuong, qa.getLoaiQuanAo().getLoai(), qa.getMauSac().getMauSac(), qa.getThuongHieu().getThuongHieu(), qa.getKichCo().getKichCo(), qa.getChatLieu().getChatLieu()};
		            model2.addRow(rowData);
		        }

		        txt_soLuong.setText("");
		        xuLyTinhTongTien();
		        tblGioHang_Loc();
		        e_QuanAo = null;
		    }
		}

		//phương thức kiểm tra thông tin khách hàng qua số điện thoại
		private boolean isValidInput() {
			if (txt_soDienThoai.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại để tìm kiếm");
				return false;
			}

			return true;
		}
		//Xóa thông tin đã nhập
		private void clearInput() {
			txt_soDienThoai.setText("");
			txt_tenKhachHang.setText("");
			txt_email.setText("");
			txt_TongTien.setText("0");
		}
		//Cập nhật lại số lượng khi xóa quần áo dưới giỏ hàng về lại danh sách quần áo
		private static void capNhatSLSPKhiXoaQuanAo(QuanAo qa, int soLuong) {
			qa.setSoLuong(qa.getSoLuong() + soLuong);
			if (dao_quanAo.capNhatSoLuong(qa) == -1) {
				return;
			}
		}
		//xử lý xóa 1 quần áo nào đó trên bảng CTHD
		private static void xuLyXoaQuanAo() {
			if (tbl_GioHang.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn quần áo muốn xoá");
				return;
			}

			QuanAo qa = dao_quanAo.TimKiemQuanAoTheoMa((String) tbl_GioHang.getValueAt(tbl_GioHang.getSelectedRow(), 0));

			int soLuong = (int) tbl_GioHang.getValueAt(tbl_GioHang.getSelectedRow(), 2);

			capNhatSLSPKhiXoaQuanAo(qa, soLuong);

			DefaultTableModel dtm = (DefaultTableModel) tbl_GioHang.getModel();
			dtm.removeRow(tbl_GioHang.getSelectedRow());


			tblDanhSachQuanAo();
			xuLyTinhTongTien();
		}
		private boolean isSoDienThoaiValid() {
			if (!txt_soDienThoai.getText().matches("^0\\d{9}$")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");

				return false;
			}

			return true;
		}
		private void HienThiTTKhachHang() {
			txt_email.setEnabled(true);
			txt_tenKhachHang.setEnabled(true);
			txt_gioiTinh.setEnabled(true);
		}
		private static void AnTTKhachHang() {
			txt_email.setEnabled(false);
			txt_tenKhachHang.setEnabled(false);
			txt_gioiTinh.setEnabled(false);
		}
		private static void thongTinKhachHang(KhachHang e_KhachHang) {
			txt_soDienThoai.setText(e_KhachHang.getsDT());
			txt_email.setText(e_KhachHang.getEmail());
			txt_tenKhachHang.setText(e_KhachHang.getTenKH());
			txt_gioiTinh.setText(e_KhachHang.isGioiTinh() ? "Nam" : "Nữ");
		}
		private void xuLybtnTim() {
			if (!isSoDienThoaiValid()) {
				return;
			}

			e_KhachHang = dao_khachHang.getTheoSDT(txt_soDienThoai.getText().trim());
			if (e_KhachHang == null) {
				if (JOptionPane.showConfirmDialog(null, "Không tìm thấy khách hàng. Bạn có muốn thêm thông tin khách hàng không?", "Thêm khách hàng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					UI_TrangChu.moQuanLyKhachHang1(); //Chuyen sang quanLyKH de them 1 khach hang moi
				}
				JOptionPane.showMessageDialog(null, "Không tìm thấy số điện thoại vui lòng nhập thông tin khách hàng mới cho số điện thoại này");
				HienThiTTKhachHang();
				txt_tenKhachHang.setText("");
				txt_gioiTinh.setText("");
				txt_email.setText("");
				isThemKhachHangActive = true;
			} else {
				thongTinKhachHang(e_KhachHang);
				isThemKhachHangActive = false;
				isKhachHang = true;
			}
		}
		private void xuLyXoaTatCaQuanAo() {
			if (tbl_GioHang.getRowCount() < 1) {
				return;
			}

			for (int i = 0; i < tbl_GioHang.getRowCount(); i++) {
				QuanAo qa = dao_quanAo.TimKiemQuanAoTheoMa((String) tbl_GioHang.getValueAt(i, 0));
				int soLuong = Integer.parseInt(tbl_GioHang.getValueAt(i, 2).toString());
				capNhatSLSPKhiXoaQuanAo(qa, soLuong);
			}

			DefaultTableModel dtm = (DefaultTableModel) tbl_GioHang.getModel();
			dtm.setRowCount(0);

			tblDanhSachQuanAo();
			xuLyTinhTongTien();

		}
		
	public void setEvent() {
		tbl_danhSachQuanAo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				tbl_danhSachQuanAoMousePressed(evt);
			}
		});
	}
	//Sửa size ảnh khỏi bị tràn khung
		public ImageIcon suaSizeAnh(String imgPath) {
			ImageIcon myImage = new ImageIcon(imgPath);
			Image img = myImage.getImage();
			Image newImg = img.getScaledInstance(pn_HinhAnh.getWidth(), pn_HinhAnh.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(newImg);

			return image;
		}
	//GEN-LAST:event_btn_dateActionPerformed
	private void tbl_danhSachQuanAoMousePressed(java.awt.event.MouseEvent evt) {
		String id = (String) tbl_danhSachQuanAo.getValueAt(tbl_danhSachQuanAo.getSelectedRow(), 0);
		e_QuanAo = dao_quanAo.TimKiemQuanAoTheoMa(id);
		int soLuong = Integer.parseInt(tbl_danhSachQuanAo.getValueAt(tbl_danhSachQuanAo.getSelectedRow(), 5).toString());
		e_QuanAo.setSoLuong(soLuong);
		lb_HinhAnh.setText("");
		File file = new File("");
		String path = file.getAbsolutePath();
		lb_HinhAnh.setIcon(suaSizeAnh(path + "/img/" + e_QuanAo.getHinhAnh()));
	}
	private boolean isThongTinKhachHangValid() {
		if (txt_email.getText().trim().equals("") || txt_tenKhachHang.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin khách hàng");
			return false;
		}

		if (!txt_email.getText().trim().matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			JOptionPane.showMessageDialog(null, "Gmail khách hàng không hợp lệ");
			return false;

		}

		return true;
	}
	private KhachHang layThongTinKhachHang() {
		String tenKhachHang = txt_tenKhachHang.getText();
		String email = txt_email.getText();
		String sdt = txt_soDienThoai.getText();
		boolean gioiTinh = txt_gioiTinh.getText().equals("Nữ") ? true : false;

		return new KhachHang(tenKhachHang, sdt, gioiTinh, email);
	}
	private void xuLyDatHang() {
		if (isThemKhachHangActive) {
			if (!isThongTinKhachHangValid()) {
				return;
			}

			e_KhachHang = layThongTinKhachHang();
			if (!dao_khachHang.themKH(e_KhachHang) ) {
				return;
			}
			isThemKhachHangActive = false;
		} else {
			isThemKhachHangActive = false;
		}	
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
	
		KhachHang kh = dao_khachHang.getTheoSDT(txt_soDienThoai.getText());
		
		PhieuDatHang pdh = new PhieuDatHang(auto_IDPhieuDat(),kh, e_NhanVien, currentDate);
		if (dao_phieuDat.addPhieuDat(pdh) == -1) {
			return;
		}
		
		
		ArrayList<ChiTietPhieuDatHang> listCTPD = new ArrayList<>();

		for (int i = 0; i < tbl_GioHang.getRowCount(); i++) {
			int soLuong = Integer.parseInt(tbl_GioHang.getValueAt(i, 2).toString());
			QuanAo qa = dao_quanAo.TimKiemQuanAoTheoMa(tbl_GioHang.getValueAt(i, 0).toString());
			ChiTietPhieuDatHang ctpd = new ChiTietPhieuDatHang(pdh, qa, soLuong);
			listCTPD.add(ctpd);
			if (dao_CTphieuDat.addChiTietPhieuDatHang(ctpd) == -1) {
				return;
			}
		}

//		capNhatSoLuongKhuyenMai();

		model2 = (DefaultTableModel) tbl_GioHang.getModel();
		model2.setRowCount(0);
		clearInput();
		JOptionPane.showMessageDialog(null, "Đặt hàng thành công");
		khoiTaoGiaTri();
		AnTTKhachHang();
	}
	private boolean isDatHangHopLe() {
		if (tbl_GioHang.getRowCount() < 1) {
			JOptionPane.showMessageDialog(null, "Vui lòng thêm quần áo để thanh toán");
			return false;
		}

		return true;
	}
	private void xuLyGiamSoLuong() {
		try {
			int soLuongCoSan = Integer.parseInt(tbl_GioHang.getValueAt(tbl_GioHang.getSelectedRow(), 2).toString());
			int soLuong = Integer.parseInt(txt_soLuong.getText());
			if (soLuong < 1) {
				JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 1");
				return;
			}
			if (soLuong > soLuongCoSan) {
				JOptionPane.showMessageDialog(null, "Số lượng giảm phải bé hơn số lượng trong CTHD");
				return;
			}
			QuanAo e_QuanAo = dao_quanAo.TimKiemQuanAoTheoMa(tbl_GioHang.getValueAt(tbl_GioHang.getSelectedRow(), 0).toString());
			if (e_QuanAo == null) {
				return;
			}
			e_QuanAo.setSoLuong(e_QuanAo.getSoLuong() + soLuong);
			if (dao_quanAo.capNhatSoLuong(e_QuanAo) != -1) {
				JOptionPane.showMessageDialog(null, "Giảm số lượng thành công");

				tbl_GioHang.setValueAt(soLuongCoSan - soLuong, tbl_GioHang.getSelectedRow(), 2);
				tblGioHang_Loc();
				xuLyTinhTongTien();
				txt_soLuong.setText("");
			}
			if (Integer.parseInt(tbl_GioHang.getValueAt(tbl_GioHang.getSelectedRow(), 2).toString()) == 0) {
				DefaultTableModel model_CTHD = (DefaultTableModel) tbl_GioHang.getModel();
				model_CTHD.removeRow(tbl_GioHang.getSelectedRow());
			
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Số lượng phải là 1 chữ số");
		}
	}

	private void btn_TimMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		if (!isValidInput()) {
			return;
		}
		xuLybtnTim();
	}

	private void btn_themMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub

		if (!isThemValid()) {
			return;
		}

		xuLythemCTHD();
	}

	private void btn_xoaQuanAoMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		xuLyXoaQuanAo();
	}
	private void btn_datHangMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		if (!isDatHangHopLe()) {
			return;
		}

		xuLyDatHang();
	}
	private void btn_GiamMouseClicked(java.awt.event.MouseEvent evt) {

		xuLyGiamSoLuong();
	}
	
	private void btn_themKHMouseClicked(java.awt.event.MouseEvent evt) {

		UI_TrangChu.moQuanLyKhachHang1();	
		}
	private void btn_XoaTatCaMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		xuLyXoaTatCaQuanAo();
	}
	private void txt_TenQuanAoKeyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		tblGioHang_Loc();
	}
	private void txt_MaQuanAoKeyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		tblGioHang_Loc();
	}
	private void cbb_KichCoItemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		tblGioHang_Loc();
	}
	private void cbb_ChatLieuItemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		tblGioHang_Loc();
	}
	private void cbb_MauSacItemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		tblGioHang_Loc();
	}
	private void cbb_loaiQuanAoItemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		tblGioHang_Loc();
	}

	private void cbb_ThuongHieuItemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		tblGioHang_Loc();
	}
			
	// Variables declaration - do not modify//GEN-BEGIN:variables

	// End of variables declaration//GEN-END:variables
}
		

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAO_KhuyenMai;
import dao.DAO_LoaiQuanAo;
import dao.DAO_QuanAo;
import entity.KhuyenMai;
import entity.NhanVien;
import entity.QuanAo;

/**
 *
 * @author ThanhDinh
 */
public class UI_QuanLyKhuyenMai extends javax.swing.JPanel implements ActionListener, MouseListener {
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnXoaTrang;
	private javax.swing.JComboBox<String> cmbMucGiamGia;
	private com.toedter.calendar.JDateChooser dcNgayBatDau;
	private com.toedter.calendar.JDateChooser dcNgayKetThuc;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblChatLieu;
	private javax.swing.JLabel lblDanhSachKhuyenMai;
	private javax.swing.JLabel lblDanhSachQuanAo;
	private javax.swing.JLabel lblGia;
	private javax.swing.JLabel lblKichCo;
	private javax.swing.JLabel lblMaQuanAo;
	private javax.swing.JLabel lblMauSac;
	private javax.swing.JLabel lblMucGiamGia;
	private javax.swing.JLabel lblQuanLyKhuyenMai;
	private javax.swing.JLabel lblQLKM;
	private javax.swing.JLabel lblTenQuanAo;
	private javax.swing.JLabel lblThoiGianBatDau;
	private javax.swing.JLabel lb_thoiGianKetThuc;
	private javax.swing.JLabel lb_thuongHieu;
	private javax.swing.JPanel pn_Form;
	private javax.swing.JPanel pn_Left;
	private javax.swing.JPanel pn_Right;
	private javax.swing.JPanel pn_Top;
	private javax.swing.JTable tblDanhSachKhuyenMai;
	private javax.swing.JTable tblDanhSachQuanAo;
	private javax.swing.JTextField txtChatLieu;
	private javax.swing.JTextField txtGia;
	private javax.swing.JTextField txtKichCo;
	private javax.swing.JTextField txtMaQuanAo;
	private javax.swing.JTextField txtMauSac;
	private javax.swing.JTextField txtTenQuanAo;
	private javax.swing.JTextField txtThuongHieu;

	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private DAO_QuanAo dao_QuanAo = new DAO_QuanAo();
	private DAO_KhuyenMai dao_KhuyenMai = new DAO_KhuyenMai();
	private DAO_LoaiQuanAo dao_LoaiQuanAo = new DAO_LoaiQuanAo();
	private ArrayList<QuanAo> dsQuanAo;

	public UI_QuanLyKhuyenMai() {
		initComponents();
		loadComboBoxKM();
	}

	private void initComponents() {
		pn_Form = new javax.swing.JPanel();
		pn_Right = new javax.swing.JPanel();
		lblMaQuanAo = new javax.swing.JLabel();
		txtMaQuanAo = new javax.swing.JTextField();
		btnThem = new javax.swing.JButton();
		lblMucGiamGia = new javax.swing.JLabel();
		lblThoiGianBatDau = new javax.swing.JLabel();
		lb_thoiGianKetThuc = new javax.swing.JLabel();
		lblQLKM = new javax.swing.JLabel();
		btnXoaTrang = new javax.swing.JButton();
		cmbMucGiamGia = new javax.swing.JComboBox<>();
		lblTenQuanAo = new javax.swing.JLabel();
		txtTenQuanAo = new javax.swing.JTextField();
		lblMauSac = new javax.swing.JLabel();
		lb_thuongHieu = new javax.swing.JLabel();
		lblChatLieu = new javax.swing.JLabel();
		lblKichCo = new javax.swing.JLabel();
		lblGia = new javax.swing.JLabel();
		txtMauSac = new javax.swing.JTextField();
		txtThuongHieu = new javax.swing.JTextField();
		txtChatLieu = new javax.swing.JTextField();
		txtKichCo = new javax.swing.JTextField();
		txtGia = new javax.swing.JTextField();
		dcNgayBatDau = new com.toedter.calendar.JDateChooser();
		dcNgayKetThuc = new com.toedter.calendar.JDateChooser();

		//chuyển định dạng ngày tháng đầu vào thành dd/MM/yyyy
		dcNgayBatDau.setDateFormatString("dd/MM/yyyy");
		dcNgayKetThuc.setDateFormatString("dd/MM/yyyy");

		pn_Top = new javax.swing.JPanel();
		lblQuanLyKhuyenMai = new javax.swing.JLabel();
		pn_Left = new javax.swing.JPanel();
		lblDanhSachQuanAo = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblDanhSachQuanAo = new javax.swing.JTable();
		lblDanhSachKhuyenMai = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblDanhSachKhuyenMai = new javax.swing.JTable();

		setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_Form.setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_Right.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblMaQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lblMaQuanAo.setText("Mã Quần Áo:");

		txtMaQuanAo.setEnabled(false);

		btnThem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnThem.setIcon(new javax.swing.ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\add.png")); // NOI18N
		btnThem.setText("Thêm");

		lblMucGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lblMucGiamGia.setText("Mức Giảm Giá:");

		lblThoiGianBatDau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lblThoiGianBatDau.setText("Thời Gian Bắt Đầu:");

		lb_thoiGianKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lb_thoiGianKetThuc.setText("Thời Gian Kết Thúc:");

		lblQLKM.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lblQLKM.setForeground(new java.awt.Color(102, 102, 0));
		lblQLKM.setText("Thông Tin Khuyến Mãi");

		btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnXoaTrang.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\xoaTrang.png"));
		btnXoaTrang.setText("Xóa Trắng");

		lblTenQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lblTenQuanAo.setText("Tên Quần Áo:");

		txtTenQuanAo.setEnabled(false);

		lblMauSac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lblMauSac.setText("Màu Sắc:");

		lb_thuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lb_thuongHieu.setText("Thương Hiệu:");

		lblChatLieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lblChatLieu.setText("Chất Liệu:");

		lblKichCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lblKichCo.setText("Kích Cỡ:");

		lblGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		lblGia.setText("Giá:");

		txtMauSac.setEnabled(false);

		txtThuongHieu.setEnabled(false);

		txtChatLieu.setEnabled(false);

		txtKichCo.setEnabled(false);

		txtGia.setEnabled(false);

		javax.swing.GroupLayout pn_RightLayout = new javax.swing.GroupLayout(pn_Right);
		pn_Right.setLayout(pn_RightLayout);
		pn_RightLayout.setHorizontalGroup(
				pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addGap(12, 12, 12)
						.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblMauSac)
												.addComponent(lblQLKM))
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
										.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblMaQuanAo)
												.addComponent(lblTenQuanAo)
												.addComponent(lb_thuongHieu)
												.addComponent(lblChatLieu)
												.addComponent(lblKichCo)
												.addComponent(lblGia)
												.addComponent(lblMucGiamGia)
												.addComponent(lblThoiGianBatDau)
												.addComponent(lb_thoiGianKetThuc))
										.addGap(23, 23, 23)
										.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(txtThuongHieu)
												.addComponent(txtChatLieu)
												.addComponent(txtKichCo)
												.addComponent(txtGia)
												.addComponent(txtTenQuanAo, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtMauSac, javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_RightLayout.createSequentialGroup()
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																.addComponent(cmbMucGiamGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(txtMaQuanAo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
																.addComponent(dcNgayBatDau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(dcNgayKetThuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGap(0, 0, Short.MAX_VALUE)))
										.addGap(17, 17, 17))))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(pn_RightLayout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(43, 43, 43))
				);
		pn_RightLayout.setVerticalGroup(
				pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblQLKM)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(pn_RightLayout.createSequentialGroup()
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lblMaQuanAo)
																.addComponent(txtMaQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(14, 14, 14)
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lblTenQuanAo)
																.addComponent(txtTenQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lblMauSac)
																.addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lb_thuongHieu)
																.addComponent(txtThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lblChatLieu)
																.addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lblKichCo)
																.addComponent(txtKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lblGia)
																.addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(28, 28, 28)
														.addGroup(pn_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lblMucGiamGia)
																.addComponent(cmbMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addComponent(lblThoiGianBatDau))
												.addComponent(dcNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lb_thoiGianKetThuc))
								.addComponent(dcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
						.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(52, 52, 52))
				);

		pn_Top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblQuanLyKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lblQuanLyKhuyenMai.setText("QUẢN LÝ KHUYẾN MÃI");

		javax.swing.GroupLayout pn_TopLayout = new javax.swing.GroupLayout(pn_Top);
		pn_Top.setLayout(pn_TopLayout);
		pn_TopLayout.setHorizontalGroup(
				pn_TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_TopLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblQuanLyKhuyenMai)
						.addGap(494, 494, 494))
				);
		pn_TopLayout.setVerticalGroup(
				pn_TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_TopLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblQuanLyKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addContainerGap())
				);

		pn_Left.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblDanhSachQuanAo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lblDanhSachQuanAo.setForeground(new java.awt.Color(51, 0, 204));
		lblDanhSachQuanAo.setText("Danh Sách Quần Áo");

		model1 = new DefaultTableModel();
		tblDanhSachQuanAo= new JTable(model1);
		tblDanhSachQuanAo.setRowHeight(25);  
		//        tblDanhSachQuanAo.addMouseListener(new java.awt.event.MouseAdapter() {
		//            public void mousePressed(java.awt.event.MouseEvent evt) {
		//                tblDanhSachQuanAoMousePressed(evt);
		//            }
		//        });
		//        

		model1.addColumn("Mã Quần Áo");
		model1.addColumn("Tên Quần Áo");
		model1.addColumn("Màu Sắc");
		model1.addColumn("Thương Hiệu");
		model1.addColumn("Chất Liệu");
		model1.addColumn("Kích Cỡ");
		model1.addColumn("Giá Bán");
		model1.addColumn("Số Lượng");
		JScrollPane sp = new JScrollPane(tblDanhSachQuanAo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(1000, 400));
		pn_Left.add(sp);
		jScrollPane1.setViewportView(tblDanhSachQuanAo);

		lblDanhSachKhuyenMai.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lblDanhSachKhuyenMai.setForeground(new java.awt.Color(0, 153, 102));
		lblDanhSachKhuyenMai.setText("Danh Sách Khuyến Mãi");

		model2 = new DefaultTableModel();
		tblDanhSachKhuyenMai= new JTable(model2);
		tblDanhSachKhuyenMai.setRowHeight(25);     
		model2.addColumn("Mã Quần Áo");
		model2.addColumn("Tên Quần Áo");
		model2.addColumn("Số Lượng");
		model2.addColumn("Ngày Bắt Đầu");
		model2.addColumn("Ngày Kết Thúc");
		model2.addColumn("Giá Lúc Đầu");
		model2.addColumn("Giá Lúc Sau");
		model2.addColumn("Mức Giảm Giá");
		JScrollPane sp2 = new JScrollPane(tblDanhSachKhuyenMai, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp2.setPreferredSize(new Dimension(1000, 400));
		pn_Left.add(sp2);
		jScrollPane2.setViewportView(tblDanhSachKhuyenMai);

		javax.swing.GroupLayout pn_LeftLayout = new javax.swing.GroupLayout(pn_Left);
		pn_Left.setLayout(pn_LeftLayout);
		pn_LeftLayout.setHorizontalGroup(
				pn_LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
								.addGroup(pn_LeftLayout.createSequentialGroup()
										.addComponent(lblDanhSachKhuyenMai)
										.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(jScrollPane2))
						.addContainerGap())
				.addGroup(pn_LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_LeftLayout.createSequentialGroup()
								.addGap(8, 8, 8)
								.addComponent(lblDanhSachQuanAo)
								.addContainerGap(762, Short.MAX_VALUE)))
				);
		pn_LeftLayout.setVerticalGroup(
				pn_LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addGap(26, 26, 26)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lblDanhSachKhuyenMai)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(14, 14, 14))
				.addGroup(pn_LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_LeftLayout.createSequentialGroup()
								.addGap(5, 5, 5)
								.addComponent(lblDanhSachQuanAo)
								.addContainerGap(651, Short.MAX_VALUE)))
				);

		javax.swing.GroupLayout pn_FormLayout = new javax.swing.GroupLayout(pn_Form);
		pn_Form.setLayout(pn_FormLayout);
		pn_FormLayout.setHorizontalGroup(
				pn_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(pn_Top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pn_FormLayout.createSequentialGroup()
										.addComponent(pn_Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pn_Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		pn_FormLayout.setVerticalGroup(
				pn_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pn_Top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_FormLayout.createSequentialGroup()
										.addComponent(pn_Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())
								.addComponent(pn_Left, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pn_Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pn_Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		tblDanhSachQuanAo.addMouseListener(this);
		tblDanhSachKhuyenMai.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		napDuLieuCSDLQuanAo(dao_QuanAo.getAllQuanAo());
		napDuLieuCSDLQuanAoKM(dao_QuanAo.getAllQuanAo());
		loadComboBoxKM();
	}
	private void napDuLieuCSDLQuanAo(ArrayList<QuanAo> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		dm.getDataVector().removeAllElements();
		for (QuanAo qa : ds) {
			String giaBanLucDau = decimalFormat.format(qa.tinhGiaBanLucDau());
			model1.addRow(new Object[] { qa.getMaQuanAo(), qa.getTenQuanAo(), qa.getMauSac().getMauSac(),qa.getThuongHieu().getThuongHieu(),qa.getChatLieu().getChatLieu(),qa.getKichCo().getKichCo(),giaBanLucDau,qa.getSoLuong()});
		}
	}
	private void napDuLieuCSDLQuanAoKM(ArrayList<QuanAo> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblDanhSachKhuyenMai.getModel();
		dm.getDataVector().removeAllElements();
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		for (QuanAo qa : ds) {
			if (qa.getKhuyenMai().getMucGiamGia() > 0 ) {
				String giaBanLucDau = decimalFormat.format(qa.tinhGiaBanLucDau());
				String giaBanLucSau = decimalFormat.format(qa.tinhGiaBanLucSau());
				model2.addRow(new Object[] { qa.getMaQuanAo(), qa.getTenQuanAo(),qa.getSoLuong(),new SimpleDateFormat("dd/MM/yyyy").format(qa.getKhuyenMai().getNgayBatDau()),new SimpleDateFormat("dd/MM/yyyy").format(qa.getKhuyenMai().getNgayKetThuc()),giaBanLucDau,giaBanLucSau,qa.getKhuyenMai().getMucGiamGia()});
			}
		}
	}
	private void loadComboBoxKM() {
		cmbMucGiamGia.addItem("0%");
		cmbMucGiamGia.addItem("10%");
		cmbMucGiamGia.addItem("20%");
		cmbMucGiamGia.addItem("30%");
		cmbMucGiamGia.addItem("40%");
		cmbMucGiamGia.addItem("50%");
	}
	public void xoaTrang() {
		txtMaQuanAo.setText("");
		txtTenQuanAo.setText("");
		txtMauSac.setText("");      
		txtThuongHieu.setText("");
		txtChatLieu.setText("");
		txtKichCo.setText("");
		txtGia.setText("");
		cmbMucGiamGia.setSelectedIndex(0);
		dcNgayBatDau.setDate(Calendar.getInstance().getTime());
		dcNgayKetThuc.setDate(Calendar.getInstance().getTime());
	}
	public KhuyenMai loadDataFromTextField() {
		String[] mucGiamGia = cmbMucGiamGia.getSelectedItem().toString().split("%");
		Date ngayBD =  dcNgayBatDau.getDate(); // Lấy ngày được chọn từ JDateChooser
		Date ngayKT =  dcNgayKetThuc.getDate();

		return new KhuyenMai(ngayBD,ngayKT,Double.parseDouble(mucGiamGia[0])) ;
	}

	private void fillFormQA(int row) {

		tblDanhSachKhuyenMai.clearSelection();
		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		if(row>=0) {  
			// Chỉ truy cập dtm nếu chỉ số hợp lệ
			txtMaQuanAo.setText(dtm.getValueAt(row, 0).toString());
			txtTenQuanAo.setText(dtm.getValueAt(row, 1).toString());
			txtMauSac.setText(dtm.getValueAt(row, 2).toString());
			txtThuongHieu.setText(dtm.getValueAt(row, 3).toString());   
			txtChatLieu.setText(dtm.getValueAt(row, 4).toString());
			txtKichCo.setText(dtm.getValueAt(row, 5).toString());        
			txtGia.setText(dtm.getValueAt(row, 6).toString());  
		}   

	}
	private void fillFormKM(int row) {
		if (btnThem.getText().equalsIgnoreCase("Hủy")) {
			JOptionPane.showMessageDialog(this, "Bạn phải chọn trên bảng Quần Áo");
			tblDanhSachKhuyenMai.clearSelection();
			return;
		}
		// System.out.println(row);
		if (row >= 0) {
			tblDanhSachQuanAo.clearSelection();
		}

		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachKhuyenMai.getModel();
		if(row>=0) {
			String maQuanAo = dtm.getValueAt(row, 0).toString();
			QuanAo e_QuanAo = dao_QuanAo.TimKiemQuanAoTheoMa(maQuanAo);

			// Chỉ truy cập dtm nếu chỉ số hợp lệ
			txtMaQuanAo.setText(e_QuanAo.getMaQuanAo());
			txtTenQuanAo.setText(e_QuanAo.getTenQuanAo());
			txtTenQuanAo.setText(dtm.getValueAt(row, 1).toString());
			txtMauSac.setText(e_QuanAo.getMauSac().getMauSac());
			txtThuongHieu.setText(e_QuanAo.getThuongHieu().getThuongHieu());
			txtChatLieu.setText(e_QuanAo.getChatLieu().getChatLieu());
			txtKichCo.setText(e_QuanAo.getKichCo().getKichCo());
			txtGia.setText(dtm.getValueAt(row, 5).toString());
			cmbMucGiamGia.setSelectedItem(dtm.getValueAt(row, 6).toString() + "%");	
			String thoiGianBD = dtm.getValueAt(row, 3).toString(); // Lấy ngày sinh từ tbl_danhSachNV dưới dạng chuỗi

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date thoiGianBDau = dateFormat.parse(thoiGianBD); // Chuyển đổi chuỗi  thành Date
				dcNgayBatDau.setDate(thoiGianBDau); // Đặt giá trị cho JDateChooser
			} catch (ParseException ex) {
				ex.printStackTrace();
			}
			String thoiGianKT = dtm.getValueAt(row, 4).toString();
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date thoiGianKThuc = dateFormat.parse(thoiGianKT); // Chuyển đổi chuỗi ngày sinh thành Date
				dcNgayKetThuc.setDate(thoiGianKThuc);
			} catch (ParseException ex) {
				ex.printStackTrace();
			}

		}
	}
	private void cmbMucGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMucGiamGiaActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_cmbMucGiamGiaActionPerformed

	private void txtMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMauSacActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtMauSacActionPerformed

	private void txtChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChatLieuActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtChatLieuActionPerformed

	private void txtKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKichCoActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtKichCoActionPerformed

	private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtGiaActionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		int row2 = tblDanhSachQuanAo.getSelectedRow();
		fillFormQA(row2);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblDanhSachKhuyenMai.getSelectedRow();
		fillFormKM(row);
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (btnThem.getText().equalsIgnoreCase("Thêm")) {
				// Lấy thông tin từ các trường
//				try {
					if(validData()) {
						KhuyenMai e_KhuyenMai = loadDataFromTextField();
						Date ngayBatDau = e_KhuyenMai.getNgayBatDau();
						Date ngayKetThuc = e_KhuyenMai.getNgayKetThuc();
						QuanAo e_QuanAo = new QuanAo();
						btnThem.setText("Hủy");
						btnXoaTrang.setEnabled(false);
						txtMaQuanAo.setText(e_QuanAo.auto_ID());
						int row = tblDanhSachQuanAo.getSelectedRow();
						DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
						e_QuanAo = dao_QuanAo.TimKiemQuanAoTheoMa(String.valueOf(dtm.getValueAt(row, 0)));
						e_QuanAo.setKhuyenMai(e_KhuyenMai);
						if (dao_KhuyenMai.themKM(e_KhuyenMai) && dao_QuanAo.suaQuanAo(e_QuanAo)) {
							JOptionPane.showMessageDialog(this, "Thêm khuyến mãi thành công");
							DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
							SimpleDateFormat sfm = new SimpleDateFormat("dd/MM/yyyy");
							String ngayBD = sfm.format(e_KhuyenMai.getNgayBatDau());
							String ngayKT = sfm.format(e_KhuyenMai.getNgayKetThuc());
							String giaBanLucDau = decimalFormat.format(e_QuanAo.tinhGiaBanLucDau());
							String giaBanLucSau = decimalFormat.format(e_QuanAo.tinhGiaBanLucSau());
							Object[] rowData = { e_QuanAo.getMaQuanAo(), e_QuanAo.getTenQuanAo(),
									e_QuanAo.getSoLuong(), ngayBD, ngayKT, giaBanLucDau, giaBanLucSau,
									e_QuanAo.getKhuyenMai().getMucGiamGia() };
							model2.addRow(rowData);
							xoaTrang();
							btnXoaTrang.setEnabled(true);
							btnThem.setText("Thêm");
						}
						tblDanhSachQuanAo.clearSelection();
						tblDanhSachKhuyenMai.clearSelection();

					} 
			} else if (btnThem.getText().equalsIgnoreCase("Hủy")) {
				btnThem.setText("Thêm");
				txtMaQuanAo.setText("");
				btnXoaTrang.setEnabled(true);

				tblDanhSachQuanAo.clearSelection();
				tblDanhSachKhuyenMai.clearSelection();
			}
			xoaTrang();
		} else if (o.equals(btnXoaTrang)) {
		    xoaTrang();
		}
	}
	public boolean validData() {
		int row = tblDanhSachQuanAo.getSelectedRow();
		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		String[] phanTramKhuyenMai = String.valueOf(cmbMucGiamGia.getSelectedItem()).split("%");
		if (!(Integer.parseInt(phanTramKhuyenMai[0]) >= 0)) {
			JOptionPane.showMessageDialog(this, "Phần trăm khuyến mãi phải lớn hơn 0");
			return false;
		}
		Date ngayBD = new java.sql.Date(dcNgayBatDau.getDate().getTime());
		Date ngayHT = new java.sql.Date(System.currentTimeMillis()); 
		if (!(ngayBD.toString().equals(ngayHT.toString()) || ngayBD.before(ngayHT))) {
			JOptionPane.showMessageDialog(this, "Thời gian bắt đầu phải <= thời gian hiện tại", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		Date ngayKT = new java.sql.Date(dcNgayKetThuc.getDate().getTime());

		if (ngayKT.before(ngayHT)) {
			JOptionPane.showMessageDialog(this, "Thời gian kết thúc phải >= thời gian hiện tại", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}
	
}

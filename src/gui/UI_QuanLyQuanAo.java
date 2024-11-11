package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import dao.DAO_ChatLieu;
import dao.DAO_KhuyenMai;
import dao.DAO_KichCo;
import dao.DAO_LoaiQuanAo;
import dao.DAO_MauSac;
import dao.DAO_NhaCungCap;
import dao.DAO_QuanAo;
import dao.DAO_ThuongHieu;
import entity.ChatLieu;
import entity.KhuyenMai;
import entity.KichCo;
import entity.LoaiQuanAo;
import entity.MauSac;
import entity.NhaCungCap;
import entity.QuanAo;
import entity.ThuongHieu;

public class UI_QuanLyQuanAo extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnChonAnh;
	private JComboBox<String> cmbChatLieu;
	private JComboBox<String> cmbKichCo;
	private JComboBox<String> cmbLoaiQuanAo;
	private JComboBox<String> cmbMauSac;
	private JComboBox<String> cmbNhaCungCap;
	private JComboBox<String> cmbThuongHieu;
	private JLabel lblChatLieu;
	private JLabel lblGiaBan;
	private JLabel lblGiaNhap;
	private JLabel lblHinhAnh;
	private JLabel lblKichCo;
	private JLabel lblLoaiQuanAo;
	private JLabel lblMaQuanAo;
	private JLabel lblMauSac;
	private JLabel lblNhaCungCap;
	private JLabel lblSoLuong;
	private JLabel lblTenQuanAo;
	private JLabel lblThuongHieu;
	private JLabel lblDanhSachQuanAo;
	private JLabel lblQuanLyQuanAo;
	private JPanel pnlBottom;
	private JPanel pnlForm;
	private JPanel pnlLeft;
	private JPanel pnlRight;
	private JPanel pnlTop;
	private JPanel pnlHinhAnh;
	private JScrollPane scr_DSqa1;
	private JTable tblDanhSachQuanAo;
	private JTextField txtGiaBan;
	private JTextField txtGiaNhap;
	private JTextField txtMaQuanAo;
	private JTextField txtSoLuong;
	private JTextField txtTenQuanAo;
	private DefaultTableModel model;
	private DAO_QuanAo dao_QuanAo = new DAO_QuanAo();
	private DAO_MauSac dao_mauSac = new DAO_MauSac();
	private DAO_KichCo dao_kichCo = new DAO_KichCo();
	private DAO_ChatLieu dao_chatLieu = new DAO_ChatLieu();
	private DAO_LoaiQuanAo dao_loaiQuanAo = new DAO_LoaiQuanAo();
	private DAO_ThuongHieu dao_thuongHieu = new DAO_ThuongHieu();
	private DAO_NhaCungCap dao_nhaCungCap = new DAO_NhaCungCap();
	private DAO_KhuyenMai dao_khuyenMai = new DAO_KhuyenMai();
	private File file = null;

	public UI_QuanLyQuanAo() {
		initComponents();
	}

	private void initComponents() {
		pnlForm = new JPanel();
		pnlRight = new JPanel();
		txtMaQuanAo = new JTextField();
		txtTenQuanAo = new JTextField();
		lblMaQuanAo = new JLabel();
		lblSoLuong = new JLabel();
		lblTenQuanAo = new JLabel();
		txtSoLuong = new JTextField();
		cmbNhaCungCap = new JComboBox<>();
		lblNhaCungCap = new JLabel();
		cmbMauSac = new JComboBox<>();
		lblMauSac = new JLabel();
		lblThuongHieu = new JLabel();
		cmbThuongHieu = new JComboBox<>();
		cmbChatLieu = new JComboBox<>();
		cmbKichCo = new JComboBox<>();
		cmbLoaiQuanAo = new JComboBox<>();
		lblKichCo = new JLabel();
		lblLoaiQuanAo = new JLabel();
		lblChatLieu = new JLabel();
		pnlLeft = new JPanel();
		lblGiaNhap = new JLabel();
		lblGiaBan = new JLabel();
		txtGiaNhap = new JTextField();
		pnlHinhAnh = new JPanel();
		lblHinhAnh = new JLabel();
		txtGiaBan = new JTextField();
		btnThem = new JButton();
		btnSua = new JButton();
		btnLuu = new JButton();
		btnXoaTrang = new JButton();
		btnChonAnh = new JButton();
		pnlBottom = new JPanel();
		scr_DSqa1 = new JScrollPane();
		tblDanhSachQuanAo = new JTable();
		lblDanhSachQuanAo = new JLabel();
		pnlTop = new JPanel();
		lblQuanLyQuanAo = new JLabel();

		setPreferredSize(new java.awt.Dimension(1302, 746));

		pnlForm.setPreferredSize(new java.awt.Dimension(1302, 746));

		pnlRight.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		txtMaQuanAo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMaQuanAoActionPerformed(evt);
			}
		});

		txtTenQuanAo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTenQuanAoActionPerformed(evt);
			}
		});

		lblMaQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18));
		lblMaQuanAo.setText("Mã Quần Áo:");

		lblSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18));
		lblSoLuong.setText("Số Lượng:");

		lblTenQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18));
		lblTenQuanAo.setText("Tên Quần Áo:");

		lblNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18));
		lblNhaCungCap.setText("Nhà Cung Cấp:");

		cmbMauSac.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbMauSacActionPerformed(evt);
			}
		});

		lblMauSac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblMauSac.setText("Màu Sắc:");

		lblThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblThuongHieu.setText("Thương Hiệu:");

		cmbChatLieu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbChatLieuActionPerformed(evt);
			}
		});

		cmbKichCo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbKichCoActionPerformed(evt);
			}
		});

		lblKichCo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblKichCo.setText("Kích Cỡ:");

		lblLoaiQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblLoaiQuanAo.setText("Loại:");

		lblChatLieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblChatLieu.setText("Chất Liệu:");

		GroupLayout pnlRightLayout = new GroupLayout(pnlRight);
		pnlRight.setLayout(pnlRightLayout);
		pnlRightLayout.setHorizontalGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlRightLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(pnlRightLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(pnlRightLayout.createSequentialGroup()
								.addComponent(cmbMauSac, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(pnlRightLayout.createSequentialGroup().addGroup(pnlRightLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblNhaCungCap)
								.addComponent(lblSoLuong).addComponent(lblMauSac).addComponent(lblTenQuanAo)
								.addComponent(lblMaQuanAo)
								.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(cmbNhaCungCap, GroupLayout.Alignment.LEADING, 0,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtTenQuanAo, GroupLayout.Alignment.LEADING)
										.addComponent(txtSoLuong, GroupLayout.Alignment.LEADING)
										.addComponent(txtMaQuanAo, GroupLayout.Alignment.LEADING,
												GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
								.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(cmbKichCo, GroupLayout.PREFERRED_SIZE, 230,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cmbLoaiQuanAo, GroupLayout.PREFERRED_SIZE, 230,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblKichCo)
										.addComponent(cmbChatLieu, GroupLayout.PREFERRED_SIZE, 230,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblChatLieu)
										.addComponent(cmbThuongHieu, GroupLayout.PREFERRED_SIZE, 230,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblThuongHieu).addComponent(lblLoaiQuanAo))
								.addGap(15, 15, 15)))));
		pnlRightLayout.setVerticalGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlRightLayout.createSequentialGroup().addContainerGap().addComponent(lblMaQuanAo)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lblThuongHieu)
								.addGroup(pnlRightLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(
										txtMaQuanAo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblTenQuanAo).addComponent(cmbThuongHieu, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtTenQuanAo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChatLieu))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblSoLuong).addComponent(cmbChatLieu, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblKichCo))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(cmbKichCo, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNhaCungCap))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(cmbNhaCungCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLoaiQuanAo))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblMauSac).addComponent(cmbLoaiQuanAo, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cmbMauSac,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(41, Short.MAX_VALUE)));

		pnlLeft.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblGiaNhap.setFont(new java.awt.Font("Segoe UI", 0, 18));
		lblGiaNhap.setText("Giá Nhập:");

		lblGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 18));
		lblGiaBan.setText("Giá Bán:");

		pnlHinhAnh.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblHinhAnh.setFont(new java.awt.Font("Segoe UI", 0, 18));
		lblHinhAnh.setOpaque(true);
		lblHinhAnh.setOpaque(true);
		lblHinhAnh.setMaximumSize(new java.awt.Dimension(159, 143));
		lblHinhAnh.setMinimumSize(new java.awt.Dimension(159, 143));
		lblHinhAnh.setPreferredSize(new java.awt.Dimension(159, 143));

		javax.swing.GroupLayout pn_chuaAnh = new javax.swing.GroupLayout(pnlHinhAnh);
		pnlHinhAnh.setLayout(pn_chuaAnh);
		pn_chuaAnh.setHorizontalGroup(pn_chuaAnh.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE));
		pn_chuaAnh.setVerticalGroup(pn_chuaAnh.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE));

		btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
		btnThem.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\add.png"));
		btnThem.setText("Thêm");
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12));
		btnSua.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\fix.png"));
		btnSua.setText("Sửa");
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaActionPerformed(evt);
			}
		});

		btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 12));
		btnLuu.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\save2.png"));
		btnLuu.setText("Lưu");
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLuuActionPerformed(evt);
			}
		});

		btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 1, 12));
		btnXoaTrang.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\xoaTrang.png"));
		btnXoaTrang.setText("Xóa Trắng");
		btnXoaTrang.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnXoaTrangMouseClicked(evt);
			}
		});

		btnChonAnh.setFont(new java.awt.Font("Segoe UI", 1, 12));
		btnChonAnh.setText("Chọn Ảnh");
		btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonAnhActionPerformed(evt);
			}
		});

		GroupLayout pnlLeftLayout = new GroupLayout(pnlLeft);
		pnlLeft.setLayout(pnlLeftLayout);
		pnlLeftLayout.setHorizontalGroup(pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlLeftLayout.createSequentialGroup().addGroup(pnlLeftLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(pnlLeftLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(pnlLeftLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiaBan)
								.addComponent(txtGiaBan, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiaNhap)))
						.addGroup(pnlLeftLayout.createSequentialGroup().addGap(34, 34, 34).addGroup(pnlLeftLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(pnlLeftLayout.createSequentialGroup()
										.addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(pnlLeftLayout.createSequentialGroup()
										.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(53, 53, 53).addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)))))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
						.addGroup(pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, pnlLeftLayout.createSequentialGroup()
										.addComponent(pnlHinhAnh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(33, 33, 33))
								.addGroup(GroupLayout.Alignment.TRAILING,
										pnlLeftLayout
										.createSequentialGroup().addComponent(btnChonAnh,
												GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
										.addGap(102, 102, 102)))));
		pnlLeftLayout.setVerticalGroup(pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlLeftLayout.createSequentialGroup().addGroup(pnlLeftLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(pnlLeftLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(lblGiaNhap)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lblGiaBan)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtGiaBan, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(pnlLeftLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(pnlHinhAnh,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChonAnh, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnlBottom.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pnlBottom.setPreferredSize(new java.awt.Dimension(1302, 364));

		model = new DefaultTableModel();
		tblDanhSachQuanAo = new JTable(model);
		tblDanhSachQuanAo.setRowHeight(25);
		model.addColumn("Mã Quần Áo");
		model.addColumn("Tên Quần Áo");
		model.addColumn("Loại");
		model.addColumn("Giá");
		model.addColumn("Kích Cỡ");
		model.addColumn("Màu Sắc");
		model.addColumn("Chất Liệu");
		model.addColumn("Nhà Cung Cấp");
		model.addColumn("Thương Hiệu");
		model.addColumn("Số Lượng");

		JScrollPane qa = new JScrollPane(tblDanhSachQuanAo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		qa.setPreferredSize(new Dimension(1000, 400));
		pnlBottom.add(qa);
		scr_DSqa1.setViewportView(tblDanhSachQuanAo);
		tblDanhSachQuanAo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblDanhSachQuanAoMouseClicked(evt);
			}
			private void tblDanhSachQuanAoMouseClicked(MouseEvent evt) {
			}

		});

		lblDanhSachQuanAo.setFont(new java.awt.Font("Segoe UI", 3, 12));
		lblDanhSachQuanAo.setForeground(new java.awt.Color(0, 102, 255));
		lblDanhSachQuanAo.setText("Danh Sách Quần Áo");

		GroupLayout pnlBottomLayout = new GroupLayout(pnlBottom);
		pnlBottom.setLayout(pnlBottomLayout);
		pnlBottomLayout.setHorizontalGroup(pnlBottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlBottomLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlBottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pnlBottomLayout.createSequentialGroup()
										.addComponent(lblDanhSachQuanAo, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(scr_DSqa1))
						.addContainerGap()));
		pnlBottomLayout.setVerticalGroup(pnlBottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlBottomLayout.createSequentialGroup()
						.addComponent(lblDanhSachQuanAo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scr_DSqa1, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE).addContainerGap()));

		GroupLayout pnlFormLayout = new GroupLayout(pnlForm);
		pnlForm.setLayout(pnlFormLayout);
		pnlFormLayout.setHorizontalGroup(pnlFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlFormLayout.createSequentialGroup().addGroup(pnlFormLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
								.addComponent(pnlLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(pnlRight,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlBottom, GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)).addContainerGap()));
		pnlFormLayout.setVerticalGroup(pnlFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlFormLayout.createSequentialGroup()
						.addGroup(pnlFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(pnlRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(pnlLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnlBottom, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(75, Short.MAX_VALUE)));

		pnlTop.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pnlTop.setPreferredSize(new java.awt.Dimension(808, 72));

		lblQuanLyQuanAo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lblQuanLyQuanAo.setText("QUẢN LÝ QUẦN ÁO");

		GroupLayout pnlTopLayout = new GroupLayout(pnlTop);
		pnlTop.setLayout(pnlTopLayout);
		pnlTopLayout.setHorizontalGroup(pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlTopLayout.createSequentialGroup().addGap(570, 570, 570).addComponent(lblQuanLyQuanAo)
						.addContainerGap(493, Short.MAX_VALUE)));
		pnlTopLayout.setVerticalGroup(pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlTopLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblQuanLyQuanAo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(9, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pnlForm, GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
										.addComponent(pnlTop, GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
										.addContainerGap()))));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
						.addComponent(pnlTop, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(pnlForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		loadComboBoxThuocTinh();
		napDuLieuTuCSDL(dao_QuanAo.getAllQuanAo());
		tblDanhSachQuanAo.addMouseListener(this);
		btnChonAnh.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
	}

	private void napDuLieuTuCSDL(ArrayList<QuanAo> ds) {
		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		dtm.getDataVector().removeAllElements();
		DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
		for (QuanAo quanAo : ds) {
			String giaBan = decimalFormat.format(quanAo.tinhGiaBanLucSau());
			model.addRow(new Object[] { quanAo.getMaQuanAo(), quanAo.getTenQuanAo(), quanAo.getLoaiQuanAo().getLoai(),
					giaBan, quanAo.getKichCo().getKichCo(), quanAo.getMauSac().getMauSac(),
					quanAo.getChatLieu().getChatLieu(), quanAo.getNhaCungCap().getTenNCC(),
					quanAo.getThuongHieu().getThuongHieu(), quanAo.getSoLuong() });
		}
	}

	private void loadComboBoxThuocTinh() {
		dao_mauSac = new DAO_MauSac();
		ArrayList<MauSac> dsMauSac = dao_mauSac.getAllMauSac();
		dsMauSac.forEach(mauSac -> cmbMauSac.addItem(mauSac.getMauSac()));

		dao_kichCo = new DAO_KichCo();
		ArrayList<KichCo> dsKichCo = dao_kichCo.getAllKichCo();
		dsKichCo.forEach(kichCo -> cmbKichCo.addItem(kichCo.getKichCo()));

		dao_thuongHieu = new DAO_ThuongHieu();
		ArrayList<ThuongHieu> dsThuongHieu = dao_thuongHieu.getAllThuongHieu();
		dsThuongHieu.forEach(thuongHieu -> cmbThuongHieu.addItem(thuongHieu.getThuongHieu()));

		dao_chatLieu = new DAO_ChatLieu();
		ArrayList<ChatLieu> dsChatLieu = dao_chatLieu.getAllChatLieu();
		dsChatLieu.forEach(chatLieu -> cmbChatLieu.addItem(chatLieu.getChatLieu()));

		dao_loaiQuanAo = new DAO_LoaiQuanAo();
		ArrayList<LoaiQuanAo> dsLoaiQuanAo = dao_loaiQuanAo.getAllLoai();
		dsLoaiQuanAo.forEach(loaiQA -> cmbLoaiQuanAo.addItem(loaiQA.getLoai()));

		dao_nhaCungCap = new DAO_NhaCungCap();
		ArrayList<NhaCungCap> dsNCC = dao_nhaCungCap.getAllNCC();
		dsNCC.forEach(nhaCungCap -> cmbNhaCungCap.addItem(nhaCungCap.getTenNCC()));

	}

	private void btnXoaTrangMouseClicked(MouseEvent evt) {
	}

	private void txtMaQuanAoActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtTenQuanAoActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {
	}
	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
		// Kiểm tra các trường nhập liệu
		if (this.txtTenQuanAo.getText().trim().isEmpty()) {
			//			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên quần áo!");
			this.txtTenQuanAo.requestFocus(); // nhảy trực tiếp đến txtTenQuanAo để nhập
		} else if (this.txtSoLuong.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng quần áo!");
			this.txtSoLuong.requestFocus(); // nhảy trực tiếp đến txtSoLuong để nhập
		} else if (this.txtGiaNhap.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập giá nhập!");
			this.txtGiaNhap.requestFocus(); // nhảy trực tiếp đến txtGiaNhap để nhập
		} else if (this.txtGiaBan.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập giá bán!");
			this.txtGiaBan.requestFocus(); // nhảy trực tiếp đến txtGiaBan để nhập
		} else {
			if (JOptionPane.showConfirmDialog(null, "Bạn chắn chắn lưu dữ liệu này?", "Xác nhận",
					JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				updateDanhSachQuanAo();
				xoaTrang();
				khoa();
			}
		}
	}

	private void updateDanhSachQuanAo() {
		DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
		model.addRow(new Object[] { txtMaQuanAo.getText().trim(), txtTenQuanAo.getText().trim(),
				cmbLoaiQuanAo.getSelectedItem().toString(), cmbChatLieu.getSelectedItem().toString(),
				cmbMauSac.getSelectedItem().toString(), cmbKichCo.getSelectedItem().toString(),
				Integer.parseInt(txtSoLuong.getText().trim()), Double.parseDouble(txtGiaNhap.getText().trim()),
				Double.parseDouble(txtGiaBan.getText().trim()) });
	}

	private void cmbChatLieuActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void cmbMauSacActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void cmbKichCoActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private boolean validData() {
		String tenQuanAo = txtTenQuanAo.getText().trim();
		String soLuong = txtSoLuong.getText().trim();
		String giaNhap = txtGiaNhap.getText().trim();

		if (file == null) { // kiem tra da co anh chua
			JOptionPane.showMessageDialog(this, "Phải chọn ảnh cho sản phẩm");
			return false;
		}
		if (soLuong.length() > 0) { // khong duoc rong
			try {
				int sl = Integer.parseInt(soLuong);
				if (sl < 0) {
					JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
					txtSoLuong.requestFocus();
					return false;
				}
			} catch (NumberFormatException ex) { // phai la ky tu so
				JOptionPane.showMessageDialog(this, "Số lượng phải là số");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số lượng không được rỗng");
			txtSoLuong.requestFocus();
			return false;
		}

		if (giaNhap.length() > 0) { // khong duoc rong
			try {
				long gn = Long.parseLong(giaNhap);
				if (gn <= 0) {
					JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0");
					txtSoLuong.requestFocus();
					return false;
				}
			} catch (NumberFormatException ex) { // phai la ky tu so
				JOptionPane.showMessageDialog(this, "Giá nhập phải là số");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Giá nhập không được rỗng");
			txtGiaNhap.requestFocus();
			return false;
		}

		return true;
	}

	private void updateValueTable(QuanAo quanAo) {
		int row = tblDanhSachQuanAo.getSelectedRow();
		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		dtm.setValueAt(quanAo.getMaQuanAo(), row, 0);
		dtm.setValueAt(quanAo.getTenQuanAo(), row, 1);
		dtm.setValueAt(quanAo.getLoaiQuanAo().getLoai(), row, 2);
		DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
		String giaBan = decimalFormat.format(quanAo.tinhGiaBanLucSau());
		dtm.setValueAt(giaBan, row, 3);
		dtm.setValueAt(quanAo.getKichCo().getKichCo(), row, 4);
		dtm.setValueAt(quanAo.getMauSac().getMauSac(), row, 5);
		dtm.setValueAt(quanAo.getChatLieu().getChatLieu(), row, 6);
		dtm.setValueAt(quanAo.getNhaCungCap().getTenNCC(), row, 7);
		dtm.setValueAt(quanAo.getThuongHieu().getThuongHieu(), row, 8);
		dtm.setValueAt(quanAo.getSoLuong(), row, 9);
	}

	private QuanAo kiemTraQuanAoTrung(QuanAo quanAo) {
		dao_QuanAo = new DAO_QuanAo();
		ArrayList<QuanAo> dsQuanAo = new ArrayList<QuanAo>();
		dsQuanAo = dao_QuanAo.getAllQuanAo();
		for (QuanAo qa : dsQuanAo) {
			if ((qa.getTenQuanAo()).equals((quanAo.getTenQuanAo()))) {
				if (qa.getKichCo().getKichCo().equals(quanAo.getKichCo().getKichCo())) {
					if ((qa.getMauSac().getMauSac()).equals((quanAo.getMauSac().getMauSac()))) {
						if ((qa.getChatLieu().getChatLieu()).equals((quanAo.getChatLieu().getChatLieu()))) {
							return qa; // tra ve san pham neu trung
						}
					}
				}
			}
		}
		return null;
	}

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_taoHoaDon6ActionPerformed
		if (tblDanhSachQuanAo.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Bạn phải chọn 1 dòng trước khi sửa");
		} else {
			if (btnSua.getText().equalsIgnoreCase("Sửa")) {
				moKhoa();
				btnChonAnh.setEnabled(true);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(false);
				btnXoaTrang.setEnabled(false);
				btnSua.setText("Hủy");
			} else if (btnSua.getText().equalsIgnoreCase("Hủy")) {
				btnSua.setText("Sửa");
				khoa();
				btnThem.setEnabled(true);
				btnXoaTrang.setEnabled(true);
				btnChonAnh.setEnabled(false);
				btnLuu.setEnabled(false);
				xoaTrang();
				tblDanhSachQuanAo.clearSelection();
				lblHinhAnh.setIcon(new ImageIcon());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnChonAnh)) {
			JFileChooser filechoose = new JFileChooser("img");
			FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("hinh anh", "jpg", "png");
			filechoose.setFileFilter(imageFilter);
			filechoose.setMultiSelectionEnabled(false); // chỉ cho phép chọn một file.
			int x = filechoose.showDialog(this, "Chọn Ảnh");
			if (x == JFileChooser.APPROVE_OPTION) {
				file = filechoose.getSelectedFile();
				lblHinhAnh.setText("");
				lblHinhAnh.setIcon(ResizeImage(file.getAbsolutePath()));
			}
		}
		if (o.equals(btnThem)) {
			if (btnThem.getText().equalsIgnoreCase("Thêm")) {
				xoaTrang();
				QuanAo quanAo = new QuanAo();
				moKhoa();
				btnChonAnh.setEnabled(true);
				btnLuu.setEnabled(true);
				btnThem.setText("Huỷ");
				btnSua.setEnabled(false);
				btnXoaTrang.setEnabled(false);
				txtMaQuanAo.setText(quanAo.auto_ID());
			} else if (btnThem.getText().equalsIgnoreCase("Huỷ")) {
				btnThem.setText("Thêm");
				khoa();
				txtMaQuanAo.setText("");
				btnSua.setEnabled(true);
				btnXoaTrang.setEnabled(true);
				btnChonAnh.setEnabled(false);
				btnLuu.setEnabled(false);
				lblHinhAnh.setIcon(null); // Set the icon of "lblHinhAnh" to null to remove the existing icon
			}

		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		} else if (o.equals(btnLuu)) {
			dao_QuanAo = new DAO_QuanAo();
			if (btnThem.getText().equalsIgnoreCase("Huỷ")) {
				if (validData()) {
					QuanAo quanAo = getDataOnTextField();
					QuanAo quanAo_Temp = kiemTraQuanAoTrung(quanAo);
					if (quanAo_Temp == null) { // neu khong trung thi them
						if (dao_QuanAo.themQuanAo(quanAo)) {
							DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
							dtm.getDataVector().removeAllElements();
							DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
							JOptionPane.showMessageDialog(this, "Thêm quần áo thành công");
							String giaBan = decimalFormat.format(quanAo.tinhGiaBanLucSau());
							Object[] rowData = { quanAo.getMaQuanAo(), quanAo.getTenQuanAo(),
									quanAo.getLoaiQuanAo().getLoai(), giaBan, quanAo.getKichCo().getKichCo(),
									quanAo.getMauSac().getMauSac(), quanAo.getChatLieu().getChatLieu(),
									quanAo.getNhaCungCap().getTenNCC(), quanAo.getThuongHieu().getThuongHieu(),
									quanAo.getSoLuong() };
							model.addRow(rowData);
							napDuLieuTuCSDL(dao_QuanAo.getAllQuanAo());
						} else {
							JOptionPane.showMessageDialog(this, "Trùng mã quần áo ");
						}
					} else {
						JOptionPane.showMessageDialog(this, "quần áo đã có cập nhật thêm số lượng");
						quanAo_Temp.setSoLuong(quanAo_Temp.getSoLuong() + quanAo.getSoLuong());
						dao_QuanAo.suaQuanAo(quanAo_Temp);
						napDuLieuTuCSDL(dao_QuanAo.getAllQuanAo());
						;
					}
					btnLuu.setEnabled(false);
					btnChonAnh.setEnabled(false);
					btnXoaTrang.setEnabled(true);
					btnSua.setEnabled(true);
					btnThem.setText("Thêm");
					xoaTrang();
					khoa();
					tblDanhSachQuanAo.clearSelection();
				}

				btnLuuActionPerformed(e);
			} else if (btnSua.getText().equalsIgnoreCase("Hủy")) {
				this.txtGiaNhap.requestFocus();
				dao_QuanAo = new DAO_QuanAo();
				QuanAo quanAo = getDataOnTextField();

				if (quanAo.getHinhAnh().isEmpty()) {
					quanAo.setHinhAnh(dao_QuanAo.TimKiemQuanAoTheoMa(quanAo.getMaQuanAo()).getHinhAnh().toString());
					//					}
					if (dao_QuanAo.suaQuanAo(quanAo)) {
						btnLuu.setEnabled(false);
						btnChonAnh.setEnabled(false);
						JOptionPane.showMessageDialog(this, "Sửa quần áo thành công");
						xoaTrang();
						btnSua.setText("Sửa");
						btnThem.setEnabled(true);
						btnXoaTrang.setEnabled(true);
						updateValueTable(quanAo);
						khoa();
						tblDanhSachQuanAo.clearSelection();
					}
				} else {
					btnLuu.setEnabled(false);
					btnChonAnh.setEnabled(false);
					xoaTrang();
					btnXoaTrang.setEnabled(true);
					btnSua.setText("Sửa");
					btnThem.setEnabled(true);
					khoa();
					tblDanhSachQuanAo.clearSelection();
				}
				btnLuu.setEnabled(false);
			}
		}
	}

	public ImageIcon ResizeImage(String imgPath) {
		ImageIcon myImage = new ImageIcon(imgPath);
		Image img = myImage.getImage();
		// thay đổi kích thước của hình ảnh thành kích thước của panel
		Image newImg = img.getScaledInstance(pnlHinhAnh.getWidth(), pnlHinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		return image;
	}

	private void khoa() {
		// TODO Auto-generated method stub
		txtTenQuanAo.setEnabled(false);
		cmbChatLieu.setEditable(false);
		cmbKichCo.setEditable(false);
		cmbLoaiQuanAo.setEditable(false);
		cmbMauSac.setEditable(false);
		cmbNhaCungCap.setEditable(false);
		cmbThuongHieu.setEditable(false);
		txtSoLuong.setEnabled(false);
		txtGiaNhap.setEnabled(false);
	}

	private void moKhoa() {
		txtTenQuanAo.setEnabled(true);
		cmbChatLieu.setEditable(true);
		cmbKichCo.setEditable(true);
		cmbLoaiQuanAo.setEditable(true);
		cmbMauSac.setEditable(true);
		cmbNhaCungCap.setEditable(true);
		cmbThuongHieu.setEditable(true);
		txtSoLuong.setEnabled(true);
		txtGiaNhap.setEnabled(true);
	}

	private QuanAo getDataOnTextField() {
		dao_thuongHieu = new DAO_ThuongHieu();
		dao_kichCo = new DAO_KichCo();
		dao_mauSac = new DAO_MauSac();
		dao_chatLieu = new DAO_ChatLieu();
		dao_loaiQuanAo = new DAO_LoaiQuanAo();
		dao_nhaCungCap = new DAO_NhaCungCap();
		dao_khuyenMai = new DAO_KhuyenMai();

		String maQA = txtMaQuanAo.getText().toString();
		String tenQA = txtTenQuanAo.getText().toString();
		double giaNhap = Integer.parseInt(txtGiaNhap.getText());
		String hinhAnh = "";
		if (file != null) {
			hinhAnh = file.getName();
		}
		int soLuong = Integer.parseInt(txtSoLuong.getText());

		ChatLieu chatLieu = dao_chatLieu.getChatLieuByName(cmbChatLieu.getSelectedItem().toString());
		KichCo kichco = dao_kichCo.getKichCoByName(cmbKichCo.getSelectedItem().toString());
		MauSac mauSac = dao_mauSac.getMauSacByName(cmbMauSac.getSelectedItem().toString());
		ThuongHieu thuongHieu = dao_thuongHieu.getThuongHieuByName(cmbThuongHieu.getSelectedItem().toString());
		LoaiQuanAo loaiQA = dao_loaiQuanAo.getLoaiByName(cmbLoaiQuanAo.getSelectedItem().toString());
		NhaCungCap nhaCungCap = dao_nhaCungCap.getNhaCungCapByName(cmbNhaCungCap.getSelectedItem().toString());

		KhuyenMai khuyenMai = dao_khuyenMai.getKhuyenMai("KM000000");
		return new QuanAo(maQA, tenQA, hinhAnh, mauSac, soLuong, thuongHieu, chatLieu, kichco, loaiQA, nhaCungCap,
				giaNhap, khuyenMai);
	}

	public void xoaTrang() {
		txtMaQuanAo.setText("");
		txtTenQuanAo.setText("");
		txtSoLuong.setText("");
		cmbNhaCungCap.setSelectedIndex(0);
		cmbMauSac.setSelectedIndex(0);
		cmbThuongHieu.setSelectedIndex(0);
		cmbChatLieu.setSelectedIndex(0);
		cmbKichCo.setSelectedIndex(0);
		cmbLoaiQuanAo.setSelectedIndex(0);
		txtGiaNhap.setText("");
		txtGiaBan.setText("");
		lblHinhAnh.setIcon(new ImageIcon());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = tblDanhSachQuanAo.getSelectedRow();
		fillForm(r);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private void fillForm(int r) {
		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		File file = new File("");
		String path = file.getAbsolutePath();
		String maQuanAo = dtm.getValueAt(r, 0).toString();
		QuanAo quanAo = dao_QuanAo.TimKiemQuanAoTheoMa(maQuanAo);
		lblHinhAnh.setIcon(ResizeImage(path + "/img/" + quanAo.getHinhAnh()));
		DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
		txtMaQuanAo.setText(quanAo.getMaQuanAo());
		txtTenQuanAo.setText(quanAo.getTenQuanAo());
		cmbThuongHieu.setSelectedItem(quanAo.getThuongHieu().getThuongHieu());
		cmbKichCo.setSelectedItem(quanAo.getKichCo().getKichCo());
		cmbLoaiQuanAo.setSelectedItem(quanAo.getLoaiQuanAo().getLoai());
		cmbMauSac.setSelectedItem(quanAo.getMauSac().getMauSac());
		cmbChatLieu.setSelectedItem(quanAo.getChatLieu().getChatLieu());
		cmbNhaCungCap.setSelectedItem(quanAo.getNhaCungCap().getTenNCC());
		txtSoLuong.setText(String.valueOf(quanAo.getSoLuong()));
		txtGiaNhap.setText(String.valueOf(decimalFormat.format(quanAo.getDonGiaBan())));
		txtGiaBan.setText(dtm.getValueAt(r, 3).toString());
	}
}

package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import dao.DAO_KhuyenMai;
import dao.DAO_QuanAo;
import entity.QuanAo;

public class UI_TimKiemKhuyenMai extends JPanel implements ActionListener, MouseListener {
	private JButton btnLamMoi;
    private JButton btnTimKiemKhuyenMai;
    private JComboBox<String> cmbMucGiamGia;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JLabel lblDanhSachKhuyenMai;
    private JLabel lblDanhSachSanPham;
    private JLabel lblChatLieu;
    private JLabel lblGia;
    private JLabel lblKichCo;
    private JLabel lblMaQuanAo;
    private JLabel lblMauSac;
    private JLabel lblMucGiamGia;
    private JLabel lblQuanLyKhuyenMai;
    private JLabel lblSoLuong;
    private JLabel lblTenQuanAo;
    private JLabel lblThoiGianBatDau;
    private JLabel lblThoiGianKetThuc;
    private JLabel lblThuongHieu;
    private JLabel lblTimKiemKhuyenMai;
    private JPanel pn_Form;
    private JPanel pn_Left;
    private JPanel pn_Right;
    private JPanel pn_Top;
    private JTable tblDanhSachKhuyenMai;
    private JTable tblDanhSachQuanAo;
    private JTextField txtChatLieu;
    private JTextField txtGia;
    private JTextField txtKichCo;
    private JTextField txtMaQuanAo;
    private JTextField txtMauSac;
    private JTextField txtSoLuong;
    private JTextField txtTenQuanAo;
    private JTextField txtThuongHieu;
    private JTextField txtNgayKetThuc;
    private JTextField txtNgayBatDau;
    private DefaultTableModel model1;
	private DefaultTableModel model2;
	private DAO_KhuyenMai dao_khuyenMai = new DAO_KhuyenMai();
	private DAO_QuanAo dao_QuanAo = new DAO_QuanAo();
    public UI_TimKiemKhuyenMai() {
        initComponents();
    }
    private void initComponents() {

        pn_Form = new JPanel();
        pn_Right = new JPanel();
        btnTimKiemKhuyenMai = new JButton();
        lblQuanLyKhuyenMai = new JLabel();
        btnLamMoi = new JButton();
        lblMaQuanAo = new JLabel();
        lblTenQuanAo = new JLabel();
        lblMauSac = new JLabel();
        lblThuongHieu = new JLabel();
        lblChatLieu = new JLabel();
        lblKichCo = new JLabel();
        lblGia = new JLabel();
        lblMucGiamGia = new JLabel();
        lblThoiGianBatDau = new JLabel();
        lblThoiGianKetThuc = new JLabel();
        lblSoLuong = new JLabel();
        txtMaQuanAo = new JTextField();
        cmbMucGiamGia = new JComboBox<>();
        txtTenQuanAo = new JTextField();
        txtMauSac = new JTextField();
        txtThuongHieu = new JTextField();
        txtChatLieu = new JTextField();
        txtKichCo = new JTextField();
        txtGia = new JTextField();
        txtSoLuong = new JTextField();
        txtNgayBatDau = new JTextField();
        txtNgayKetThuc = new JTextField();
        pn_Top = new JPanel();
        lblTimKiemKhuyenMai = new JLabel();
        pn_Left = new JPanel();
        lblDanhSachSanPham = new JLabel();
        jScrollPane1 = new JScrollPane();
        tblDanhSachQuanAo = new JTable();
        lblDanhSachKhuyenMai = new JLabel();
        jScrollPane2 = new JScrollPane();
        tblDanhSachKhuyenMai = new JTable();

        pn_Form.setPreferredSize(new java.awt.Dimension(1302, 746));

        pn_Right.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimKiemKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTimKiemKhuyenMai.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\find.png")); // NOI18N
        btnTimKiemKhuyenMai.setText("Tìm Kiếm Khuyến Mãi");

        lblQuanLyKhuyenMai.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblQuanLyKhuyenMai.setForeground(new java.awt.Color(102, 102, 0));
        lblQuanLyKhuyenMai.setText("Quản Lý Khuyến Mãi");

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoi.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\save.png")); // NOI18N
        btnLamMoi.setText("Làm Mới");

        lblMaQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaQuanAo.setText("Mã Quần Áo:");

        lblTenQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenQuanAo.setText("Tên Quần Áo:");

        lblMauSac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMauSac.setText("Màu Sắc:");

        lblThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblThuongHieu.setText("Thương Hiệu:");

        lblChatLieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblChatLieu.setText("Chất Liệu:");

        lblKichCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKichCo.setText("Kích Cỡ:");

        lblGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGia.setText("Giá:");

        lblMucGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMucGiamGia.setText("Mức Giảm Giá:");

        lblThoiGianBatDau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblThoiGianBatDau.setText("Thời Gian Bắt Đầu:");

        lblThoiGianKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblThoiGianKetThuc.setText("Thời Gian Kết Thúc:");

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSoLuong.setText("Số Lượng:");

        cmbMucGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMucGiamGiaActionPerformed(evt);
            }
        });

        txtMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMauSacActionPerformed(evt);
            }
        });

        txtChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatLieuActionPerformed(evt);
            }
        });

        txtKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKichCoActionPerformed(evt);
            }
        });

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        GroupLayout pn_RightLayout = new GroupLayout(pn_Right);
        pn_Right.setLayout(pn_RightLayout);
        pn_RightLayout.setHorizontalGroup(
            pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_RightLayout.createSequentialGroup()
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pn_RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblQuanLyKhuyenMai)
                            .addComponent(lblChatLieu)
                            .addComponent(lblKichCo)
                            .addGroup(pn_RightLayout.createSequentialGroup()
                                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblThoiGianKetThuc)
                                    .addComponent(lblSoLuong))
                                .addGap(18, 18, 18)
                                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong)
                                    .addComponent(txtNgayKetThuc)))
                            .addGroup(pn_RightLayout.createSequentialGroup()
                                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaQuanAo)
                                    .addComponent(lblTenQuanAo)
                                    .addComponent(lblMauSac)
                                    .addComponent(lblThuongHieu)
                                    .addComponent(lblGia)
                                    .addComponent(lblMucGiamGia)
                                    .addComponent(lblThoiGianBatDau))
                                .addGap(23, 23, 23)
                                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaQuanAo)
                                    .addComponent(txtTenQuanAo)
                                    .addComponent(txtMauSac)
                                    .addComponent(txtThuongHieu)
                                    .addComponent(txtChatLieu)
                                    .addComponent(txtKichCo)
                                    .addComponent(txtGia)
                                    .addComponent(cmbMucGiamGia, 0, 213, Short.MAX_VALUE)
                                    .addComponent(txtNgayBatDau)))))
                    .addGroup(pn_RightLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiemKhuyenMai, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pn_RightLayout.setVerticalGroup(
            pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_RightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuanLyKhuyenMai)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaQuanAo)
                    .addComponent(txtMaQuanAo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenQuanAo)
                    .addComponent(txtTenQuanAo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMauSac)
                    .addComponent(txtMauSac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThuongHieu)
                    .addComponent(txtThuongHieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChatLieu)
                    .addComponent(txtChatLieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKichCo)
                    .addComponent(txtKichCo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGia)
                    .addComponent(txtGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMucGiamGia)
                    .addComponent(cmbMucGiamGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThoiGianBatDau)
                    .addComponent(txtNgayBatDau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThoiGianKetThuc)
                    .addComponent(txtNgayKetThuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong)
                    .addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiemKhuyenMai, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        pn_Top.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTimKiemKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTimKiemKhuyenMai.setText("TÌM KIẾM KHUYẾN MÃI");

        GroupLayout pn_TopLayout = new GroupLayout(pn_Top);
        pn_Top.setLayout(pn_TopLayout);
        pn_TopLayout.setHorizontalGroup(
            pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pn_TopLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTimKiemKhuyenMai)
                .addGap(415, 415, 415))
        );
        pn_TopLayout.setVerticalGroup(
            pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTimKiemKhuyenMai, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_Left.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDanhSachSanPham.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblDanhSachSanPham.setForeground(new java.awt.Color(51, 0, 204));
        lblDanhSachSanPham.setText("Danh Sách Quần Áo");

        model1 = new DefaultTableModel();
		tblDanhSachQuanAo = new JTable(model1);
		tblDanhSachQuanAo.setRowHeight(25);
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
		tblDanhSachKhuyenMai = new JTable(model2);
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
		sp.setPreferredSize(new Dimension(1000, 400));
		pn_Left.add(sp2);
		jScrollPane2.setViewportView(tblDanhSachKhuyenMai);

        GroupLayout pn_LeftLayout = new GroupLayout(pn_Left);
        pn_Left.setLayout(pn_LeftLayout);
        pn_LeftLayout.setHorizontalGroup(
            pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pn_LeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(GroupLayout.Alignment.LEADING, pn_LeftLayout.createSequentialGroup()
                        .addComponent(lblDanhSachKhuyenMai)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pn_LeftLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(lblDanhSachSanPham)
                    .addContainerGap(701, Short.MAX_VALUE)))
        );
        pn_LeftLayout.setVerticalGroup(
            pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_LeftLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDanhSachKhuyenMai)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pn_LeftLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(lblDanhSachSanPham)
                    .addContainerGap(540, Short.MAX_VALUE)))
        );

        GroupLayout pn_FormLayout = new GroupLayout(pn_Form);
        pn_Form.setLayout(pn_FormLayout);
        pn_FormLayout.setHorizontalGroup(
            pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pn_FormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_Top, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_FormLayout.createSequentialGroup()
                        .addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_Right, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn_FormLayout.setVerticalGroup(
            pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_FormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_Top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_Right, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tblDanhSachQuanAo.addMouseListener(this);
		tblDanhSachKhuyenMai.addMouseListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiemKhuyenMai.addActionListener(this);
		napDuLieuCSDLQuanAo(dao_QuanAo.getAllQuanAo());
		napDuLieuCSDLQuanAoKM(dao_QuanAo.getAllQuanAo());
		loadComboBoxKM();
    }// </editor-fold>//GEN-END:initComponents
    private void napDuLieuCSDLQuanAo(ArrayList<QuanAo> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
		dm.getDataVector().removeAllElements();
		for (QuanAo khuyenMai : ds) {
			model1.addRow(
					new Object[] { khuyenMai.getMaQuanAo(), khuyenMai.getTenQuanAo(), khuyenMai.getMauSac().getMauSac(),
							khuyenMai.getThuongHieu().getThuongHieu(), khuyenMai.getChatLieu().getChatLieu(),
							khuyenMai.getKichCo().getKichCo(), decimalFormat.format(khuyenMai.tinhGiaBanLucDau()), khuyenMai.getSoLuong() });
		}
	}

	private void napDuLieuCSDLQuanAoKM(ArrayList<QuanAo> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblDanhSachKhuyenMai.getModel();
		dm.getDataVector().removeAllElements();
		DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
		for (QuanAo khuyenMai : ds) {
			if (khuyenMai.getKhuyenMai().getMucGiamGia() > 0 ) {
				model2.addRow(new Object[] { khuyenMai.getMaQuanAo(), khuyenMai.getTenQuanAo(),
						khuyenMai.getSoLuong(), new SimpleDateFormat("dd/MM/yyyy").format(khuyenMai.getKhuyenMai().getNgayBatDau()),
						new SimpleDateFormat("dd/MM/yyyy").format(khuyenMai.getKhuyenMai().getNgayKetThuc()), decimalFormat.format(khuyenMai.tinhGiaBanLucDau()) ,
						decimalFormat.format(khuyenMai.tinhGiaBanLucSau()), khuyenMai.getKhuyenMai().getMucGiamGia() });
			}
		}
	}

	private void loadComboBoxKM() {
		// TODO Auto-generated method stub
		cmbMucGiamGia.addItem("0%");
		cmbMucGiamGia.addItem("10%");
		cmbMucGiamGia.addItem("20%");
		cmbMucGiamGia.addItem("30%");
		cmbMucGiamGia.addItem("40%");
	}

	public void xoaTrang() {
		txtMaQuanAo.setText("");
		txtTenQuanAo.setText("");
		txtMauSac.setText("");
		txtSoLuong.setText("");
		txtThuongHieu.setText("");
		txtChatLieu.setText("");
		txtKichCo.setText("");
		txtGia.setText("");
		cmbMucGiamGia.setSelectedIndex(0);
		txtNgayBatDau.setText("");
		txtNgayKetThuc.setText("");
	}

	private void fillFormkhuyenMai(int row) {
		tblDanhSachKhuyenMai.clearSelection();
		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		if (row >= 0) {
			// Chỉ truy cập dtm nếu chỉ số hợp lệ
			txtMaQuanAo.setText(dtm.getValueAt(row, 0).toString());
			txtTenQuanAo.setText(dtm.getValueAt(row, 1).toString());
			txtMauSac.setText(dtm.getValueAt(row, 2).toString());
			txtThuongHieu.setText(dtm.getValueAt(row, 3).toString());
			txtChatLieu.setText(dtm.getValueAt(row, 4).toString());
			txtKichCo.setText(dtm.getValueAt(row, 5).toString());
			txtGia.setText(dtm.getValueAt(row, 6).toString());
//	            txt_soLuongKM.setText(dtm.getValueAt(row, 3).toString());
		}

	}

	private void fillFormKM(int row) {
		if (row >= 0) {
			tblDanhSachQuanAo.clearSelection();
		}

		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachKhuyenMai.getModel();
		if (row >= 0) {
			String maQuanAo = dtm.getValueAt(row, 0).toString();
			QuanAo quanAo = dao_QuanAo.TimKiemQuanAoTheoMa(maQuanAo);

			// Chỉ truy cập dtm nếu chỉ số hợp lệ
			txtMaQuanAo.setText(quanAo.getMaQuanAo());
			txtTenQuanAo.setText(quanAo.getTenQuanAo());
			txtTenQuanAo.setText(dtm.getValueAt(row, 1).toString());
			txtMauSac.setText(quanAo.getMauSac().getMauSac());
			txtThuongHieu.setText(quanAo.getThuongHieu().getThuongHieu());
			txtChatLieu.setText(quanAo.getChatLieu().getChatLieu());
			txtKichCo.setText(quanAo.getKichCo().getKichCo());
			txtGia.setText(dtm.getValueAt(row, 5).toString());
			cmbMucGiamGia.setSelectedItem(dtm.getValueAt(row, 6).toString() + "%");
			txtNgayBatDau.setText(dtm.getValueAt(row, 3).toString());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			txtNgayKetThuc.setText(dtm.getValueAt(row, 4).toString());
			txtSoLuong.setText(String.valueOf(dtm.getValueAt(row, 2)));

		}
	}
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

    private void cmbMucGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMucGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMucGiamGiaActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed
    @Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			xoaTrang();
			napDuLieuCSDLQuanAo(dao_QuanAo.getAllQuanAo());
//			napDuLieuCSDLQuanAoKM(dao_khuyenMai.getAllKhuyenMai());
		} else if (o.equals(btnTimKiemKhuyenMai)) {
			timKiemKhuyenMaiTheoMaQuanAo();
		}

	}

// còn lỗi
	public void timKiemKhuyenMaiTheoMaQuanAo() {
		String ma = txtMaQuanAo.getText().trim();
		QuanAo quanAo = dao_QuanAo.TimKiemQuanAoTheoMa(ma);
		if (quanAo != null) {
			DefaultTableModel dm = (DefaultTableModel) tblDanhSachKhuyenMai.getModel();
			dm.getDataVector().removeAllElements();
			model2.addRow(new Object[] { quanAo.getMaQuanAo(), quanAo.getTenQuanAo(),
					quanAo.getSoLuong(), quanAo.getKhuyenMai().getNgayBatDau(),
					quanAo.getKhuyenMai().getNgayKetThuc(), quanAo.tinhGiaBanLucDau(), quanAo.tinhGiaBanLucSau(),
					quanAo.getKhuyenMai().getMucGiamGia() });
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Quần Áo, Nhập Lại Mã Quần Áo");
			this.txtMaQuanAo.requestFocus();
		}
		xoaTrang();

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row2 = tblDanhSachQuanAo.getSelectedRow();
		fillFormkhuyenMai(row2);
	}

	@Override
	public void mousePressed(MouseEvent e) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    // End of variables declaration//GEN-END:variables
}

package gui;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
//import java.sql.Date;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import connectDB.ConnectDB;
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
import entity.NhanVien;
import entity.PhieuDatHang;
import entity.QuanAo;
import entity.GioHang;

public class UI_ThanhToan extends JPanel {
	private JButton btn_thanhToan;
    private com.toedter.calendar.JDateChooser dc_NgayDatHang;
    private JLabel lb_MaPDH;
    private JLabel lb_NgayDatHang;
    private JLabel lb_TenKH;
    private JLabel lb_TenLV;
    private JLabel lb_TongTien;
    private JLabel lb_tienKhachDua;
    private JLabel lb_tienThua;
    private JLabel lbl_DatHang;
    private JLabel lbl_GioHang;
    private JLabel lbl_danhSachPhieuDatHang;
    private JPanel pn_Center;
    private JPanel pn_DanhSachPDH;
    private JPanel pn_Form;
    private JPanel pn_GioHang;
    private JPanel pn_ThongTin;
    private JScrollPane scr_DanhSachPDH;
    private JScrollPane scr_GioHang;
    private static JTable tbl_GioHang;
    private static JTable tbl_danhSachPDH;
    private static JTextField txt_TenKH;
    private static JTextField txt_TenNV;
    private static JTextField txt_TongTien;
    private static JTextField txt_maPDH;
    private static JTextField txt_tienKhachDua;
    private static JTextField txt_tienThua;
    private static DefaultTableModel model1;
	private static DefaultTableModel model2;
	private static KhachHang e_KhachHang = null;
	private static QuanAo e_QuanAo = null;
	private static ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();
	private static boolean isThemKhachHangActive = false;
	public static boolean isThanhToan = false;

	private static final DAO_QuanAo dao_quanAo = new DAO_QuanAo();
	private static final DAO_PhieuDatHang dao_pdh = new DAO_PhieuDatHang();
	private static final DAO_ChiTietPhieuDatHang dao_ctpdh = new DAO_ChiTietPhieuDatHang();
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

    public UI_ThanhToan() throws SQLException {
        initComponents();
        initialValue();
        
    }

    private void initComponents() {

        pn_Form = new JPanel();
        lbl_DatHang = new JLabel();
        pn_Center = new JPanel();
        pn_DanhSachPDH = new JPanel();
        scr_DanhSachPDH = new JScrollPane();
        tbl_danhSachPDH = new JTable();
        lbl_danhSachPhieuDatHang = new JLabel();
        pn_ThongTin = new JPanel();
        lb_TenKH = new JLabel();
        lb_TenLV = new JLabel();
        txt_TenKH = new JTextField();
        txt_TenNV = new JTextField();
        lb_MaPDH = new JLabel();
        lb_NgayDatHang = new JLabel();
        txt_maPDH = new JTextField();
        dc_NgayDatHang = new com.toedter.calendar.JDateChooser();
        dc_NgayDatHang.setDateFormatString("dd/MM/yyyy");
        lb_TongTien = new JLabel();
        lb_tienKhachDua = new JLabel();
        lb_tienThua = new JLabel();
        txt_TongTien = new JTextField();
        txt_tienKhachDua = new JTextField();
        txt_tienThua = new JTextField();
        btn_thanhToan = new JButton();
        pn_GioHang = new JPanel();
        scr_GioHang = new JScrollPane();
        tbl_GioHang = new JTable();
        lbl_GioHang = new JLabel();

        setPreferredSize(new java.awt.Dimension(1302, 746));

        pn_Form.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn_Form.setPreferredSize(new java.awt.Dimension(1304, 746));

        lbl_DatHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_DatHang.setText("THANH TOÁN");

        pn_Center.setPreferredSize(new java.awt.Dimension(1302, 746));

        pn_DanhSachPDH.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        model1 = new DefaultTableModel();
		tbl_danhSachPDH = new JTable(model1);
		tbl_danhSachPDH.setRowHeight(25);     
		model1.addColumn("Mã Phiếu Đặt");
		model1.addColumn("Tên Khách Hàng");
		model1.addColumn("Tên Nhân Viên");
		model1.addColumn("Ngày Đặt Hàng");
		JScrollPane sp = new JScrollPane(tbl_danhSachPDH, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(1000, 400));
		pn_DanhSachPDH.add(sp);
        scr_DanhSachPDH.setViewportView(tbl_danhSachPDH);

        lbl_danhSachPhieuDatHang.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbl_danhSachPhieuDatHang.setForeground(new java.awt.Color(0, 102, 255));
        lbl_danhSachPhieuDatHang.setText("Phiếu Đặt Hàng");

        GroupLayout pn_DanhSachPDHLayout = new GroupLayout(pn_DanhSachPDH);
        pn_DanhSachPDH.setLayout(pn_DanhSachPDHLayout);
        pn_DanhSachPDHLayout.setHorizontalGroup(
            pn_DanhSachPDHLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_DanhSachPDHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_DanhSachPDHLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scr_DanhSachPDH)
                    .addGroup(pn_DanhSachPDHLayout.createSequentialGroup()
                        .addComponent(lbl_danhSachPhieuDatHang)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_DanhSachPDHLayout.setVerticalGroup(
            pn_DanhSachPDHLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_DanhSachPDHLayout.createSequentialGroup()
                .addComponent(lbl_danhSachPhieuDatHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_DanhSachPDH, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_ThongTin.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_TenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TenKH.setText("Tên Khách Hàng:");

        lb_TenLV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TenLV.setText("Tên Nhân Viên:");

        lb_MaPDH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_MaPDH.setText("Mã Phiếu Đặt:");

        lb_NgayDatHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_NgayDatHang.setText("Ngày Đặt Hàng:");

        lb_TongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TongTien.setText("Tổng Tiền:");

        lb_tienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_tienKhachDua.setText("Tiền Khách Đưa:");

        lb_tienThua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_tienThua.setText("Tiền Thừa:");

        txt_TongTien.setEditable(false);
        txt_TongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TongTienActionPerformed(evt);
            }
        });

        txt_tienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_tienKhachDuaKeyReleased(evt);
			}
		});

        txt_tienThua.setEditable(false);
        txt_TenNV.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_TenNVKeyReleased(evt);
			}

			
		});
        txt_TenKH.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_TenKHKeyReleased(evt);
			}
		});
        btn_thanhToan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_thanhToan.setText("Thanh Toán");
        btn_thanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_thanhToanMouseClicked(evt);
			}
		});
        GroupLayout pn_ThongTinLayout = new GroupLayout(pn_ThongTin);
        pn_ThongTin.setLayout(pn_ThongTinLayout);
        pn_ThongTinLayout.setHorizontalGroup(
            pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ThongTinLayout.createSequentialGroup()
                        .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lb_MaPDH)
                            .addComponent(txt_maPDH, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lb_NgayDatHang)
                            .addComponent(dc_NgayDatHang, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_ThongTinLayout.createSequentialGroup()
                        .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TenKH, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_ThongTinLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lb_TenKH)))
                        .addGap(63, 63, 63)
                        .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lb_TenLV)
                            .addComponent(txt_TenNV, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(pn_ThongTinLayout.createSequentialGroup()
                                .addComponent(lb_TongTien)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_TongTien, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181))
                            .addGroup(pn_ThongTinLayout.createSequentialGroup()
                                .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_tienKhachDua)
                                    .addComponent(lb_tienThua))
                                .addGap(17, 17, 17)
                                .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tienThua, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pn_ThongTinLayout.createSequentialGroup()
                                        .addComponent(txt_tienKhachDua, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_thanhToan)))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pn_ThongTinLayout.setVerticalGroup(
            pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongTinLayout.createSequentialGroup()
                .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ThongTinLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_TongTien)
                            .addComponent(txt_TongTien, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pn_ThongTinLayout.createSequentialGroup()
                                .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_tienKhachDua, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_tienKhachDua)
                                    .addComponent(btn_thanhToan, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_tienThua, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_tienThua)))
                            .addGroup(pn_ThongTinLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lb_NgayDatHang)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dc_NgayDatHang, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pn_ThongTinLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lb_TenKH)
                            .addGroup(pn_ThongTinLayout.createSequentialGroup()
                                .addComponent(lb_TenLV)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_ThongTinLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_TenKH, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_TenNV, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addComponent(lb_MaPDH)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maPDH, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
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
        lbl_GioHang.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbl_GioHang.setForeground(new java.awt.Color(0, 102, 255));
        lbl_GioHang.setText("Giỏ Hàng");

        GroupLayout pn_GioHangLayout = new GroupLayout(pn_GioHang);
        pn_GioHang.setLayout(pn_GioHangLayout);
        pn_GioHangLayout.setHorizontalGroup(
            pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_GioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scr_GioHang)
                    .addGroup(pn_GioHangLayout.createSequentialGroup()
                        .addComponent(lbl_GioHang, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1175, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_GioHangLayout.setVerticalGroup(
            pn_GioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_GioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_GioHang)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_GioHang, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        GroupLayout pn_CenterLayout = new GroupLayout(pn_Center);
        pn_Center.setLayout(pn_CenterLayout);
        pn_CenterLayout.setHorizontalGroup(
            pn_CenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_CenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_CenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pn_DanhSachPDH, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_ThongTin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_GioHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pn_CenterLayout.setVerticalGroup(
            pn_CenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_CenterLayout.createSequentialGroup()
                .addComponent(pn_ThongTin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_DanhSachPDH, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_GioHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
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
                .addComponent(lbl_DatHang, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                .addGap(524, 524, 524))
        );
        pn_FormLayout.setVerticalGroup(
            pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pn_FormLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_DatHang, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Center, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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
                .addComponent(pn_Form, GroupLayout.PREFERRED_SIZE, 728, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        tbl_danhSachPDH.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	int r = tbl_danhSachPDH.getSelectedRow();
               // 	fillForm(r);
                    hienThiGioHang();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
//    }
    }// </editor-fold>                        

    private void initialValue() throws SQLException { 
    	tblDanhSachPhieuDatHang();
    }
    private void tblDanhSachPhieuDatHang() {
    	xoaChonDSPDH();
		lamMoiBangDSPDH();
		// TODO Auto-generated method stub
		model1 = (DefaultTableModel) tbl_danhSachPDH.getModel();
		String maPDH = txt_maPDH.getText();
		String tenNV = txt_TenNV.getText();
		String tenKH = txt_TenKH.getText();
		Date ngayDatHang = dc_NgayDatHang.getDate();
		 ArrayList<PhieuDatHang> listPhieuDH = dao_pdh.getAllPhieuDatHang(tenKH, tenNV);
		
		 for (PhieuDatHang pdh : listPhieuDH) {
			Object [] rowData = {pdh.getMaPhieuDat(),pdh.getKhachHang().getTenKH(),pdh.getNhanVien().getTenNV(), new SimpleDateFormat("dd/MM/yyyy").format(pdh.getNgayDat())};
			model1.addRow(rowData);
		}
    }
    private void lamMoiBangDSPDH() {
		// TODO Auto-generated method stub
    	model1 = (DefaultTableModel) tbl_danhSachPDH.getModel();
		model1.setRowCount(0);
	}

	private void xoaChonDSPDH() {
		// TODO Auto-generated method stub
		tbl_danhSachPDH.clearSelection();
	}

	private static void hienThiGioHang() throws SQLException {
	    model1 = (DefaultTableModel) tbl_danhSachPDH.getModel();
	    model2.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm dữ liệu mới
	    int selectedRow = tbl_danhSachPDH.getSelectedRow();
	    String maPhieuDat = (String) tbl_danhSachPDH.getValueAt(selectedRow, 0);
	    ArrayList<GioHang> danhSachSanPham = dao_ctpdh.getSanPhamGioHang(maPhieuDat);

	    for (GioHang gioHang : danhSachSanPham) {
//	    	double giaBan = gioHang.layGiaBan();
	            Object[] rowData = {
	                gioHang.getMaQA().getMaQuanAo(),
	                gioHang.getTenQA().getTenQuanAo(),
	                gioHang.getSoLuong().getSoLuong(),
	                gioHang.getDonGiaBan().getDonGiaBan(),
	                gioHang.getLoai().getLoai(),
	                gioHang.getMauSac().getMauSac(),
	                gioHang.getThuongHieu().getThuongHieu(),
	                gioHang.getKichCo().getKichCo(),
	                gioHang.getChatLieu().getChatLieu()
	            };

	            model2.addRow(rowData);
	        }
	    

	    xuLyTinhTongTien();
	}

    private void fillForm(int r) {
    	txt_maPDH.setText(tbl_danhSachPDH.getValueAt(r, 0).toString());
    	txt_TenKH.setText(tbl_danhSachPDH.getValueAt(r, 1).toString());
    	txt_TenNV.setText(tbl_danhSachPDH.getValueAt(r, 2).toString());
    	String ngayDat = tbl_danhSachPDH.getValueAt(r, 3).toString(); // Lấy ngày sinh từ tbl_danhSachNV dưới dạng chuỗi
		try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayDatHang = (Date) dateFormat.parse(ngayDat); // Chuyển đổi chuỗi ngày sinh thành Date
            dc_NgayDatHang.setDate(ngayDatHang); // Đặt giá trị cho JDateChooser
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void xuLyTinhTongTien() {
		double tongTien = 0;

		for (int i = 0; i < tbl_GioHang.getRowCount(); i++) {

			double thanhTien = Double.parseDouble(tbl_GioHang.getValueAt(i, 3).toString()) * Double.parseDouble(tbl_GioHang.getValueAt(i, 2).toString());
			tongTien += thanhTien;
		}

		txt_TongTien.setText(tongTien + "");
	}
    private boolean isThanhToanHopLe() {
//		if (tbl_GioHang.getRowCount() < 1) {
//			JOptionPane.showMessageDialog(null, "Vui lòng thêm quần áo để thanh toán");
//			return false;
//		}

		if (txt_tienKhachDua.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tiền khách hàng đưa");
			return false;
		}

		try {
			double tienKhachDua = Double.parseDouble(txt_tienKhachDua.getText());
			double tongTien = Double.parseDouble(txt_TongTien.getText());

			if (tienKhachDua - tongTien < 0) {
				JOptionPane.showMessageDialog(null, "Không đủ tiền thanh toán.");
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tiền khách hàng đưa phải là chữ số");
			return false;
		}

		return true;
	}
  //Xử lý MaHD tự động
  	private String auto_IDHoaDon() {
  		// Tự động tạo mã hóa đơn dạng HDXXXXXX
  		DAO_HoaDon dao_hoaDon = new DAO_HoaDon();
  		String idPrefix = "HD";
  		int length = dao_hoaDon.getAllHoaDon().size();
  		String finalId = idPrefix + String.format("%06d", length + 1);
  		return finalId; // Trả về mã hóa đơn thay vì thiết lập trực tiếp
  	}
    private void xuLyThanhToan() {
    	
    	int selectedRow = tbl_danhSachPDH.getSelectedRow();
    	xuLyTinhTongTien();
		HoaDon hd = new HoaDon();

		String tenKH = tbl_danhSachPDH.getValueAt(selectedRow, 1).toString();
		KhachHang kh = dao_khachHang.getTheoTenKH(tenKH);
		hd.setMaHD(auto_IDHoaDon());
		hd.setKhachHang(kh);
		hd.setNhanVien(e_NhanVien);
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		hd.setNgayLapHD(sqlDate);
		if (dao_hoaDon.addHoaDon(hd) == -1) {
			return;
		}

		ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();

		for (int i = 0; i < tbl_GioHang.getRowCount(); i++) {
			int soLuong = Integer.parseInt(tbl_GioHang.getValueAt(i, 2).toString());
			double donGia = Double.parseDouble(tbl_GioHang.getValueAt(i, 3).toString());
			QuanAo qa = dao_quanAo.TimKiemQuanAoTheoMa(tbl_GioHang.getValueAt(i, 0).toString());

			double thanhTien = donGia * soLuong;
			ChiTietHoaDon cthd = new ChiTietHoaDon(hd, qa, soLuong, thanhTien);
			listChiTietHoaDon.add(cthd);
			if (dao_cthd.addChiTietHoaDon(cthd) == -1) {
				return;
			}
		}

//		capNhatSoLuongKhuyenMai();

		model2 = (DefaultTableModel) tbl_GioHang.getModel();
		model2.setRowCount(0);

		xuatHoaDon(hd, listChiTietHoaDon, kh, e_NhanVien);
		clearInput();
		JOptionPane.showMessageDialog(null, "Thanh toán thành công");
//		openHoaDon(hd.getMaHD());
	}
    private void clearInput() {
//		txt_tenKH.setText("");
		txt_tienKhachDua.setText("");
		txt_TongTien.setText("0");
		txt_tienThua.setText("0");
	}
    private void xuLyTinhTienThua() {
		try {
			double tongTien = Double.parseDouble(txt_TongTien.getText());
			double tienKh = Double.parseDouble(txt_tienKhachDua.getText());

			double tienThua = tienKh - tongTien;
			txt_tienThua.setText(NumberFormat.getInstance().format(tienThua));
		} catch (Exception e) {
		}

	}
    private void btn_thanhToanMouseClicked(java.awt.event.MouseEvent evt) {

		if (!isThanhToanHopLe()) {
			return;
		}

		xuLyThanhToan();

	}
 
    private void txt_tienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {

		xuLyTinhTienThua();
	}                                               

    private void txt_TongTienActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void txt_TenNVKeyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		tblDanhSachPhieuDatHang();
	}
    private void txt_TenKHKeyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
    	tblDanhSachPhieuDatHang();
	}
    public static void xuatHoaDon(HoaDon hd, ArrayList<ChiTietHoaDon> listCTHD, KhachHang kh, NhanVien nv) {
		try {
			String pathFull = "/Nhom18_PTUD_DoAn/QLThoiTrang/HoaDon/" + hd.getMaHD() + ".pdf";
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(pathFull));
			document.open();


			Font font = FontFactory.getFont("/Nhom18_PTUD_DoAn/QLThoiTrang/Font/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			
			Paragraph paragraph = new Paragraph("CỬA HÀNG QUẦN ÁO 3 CHÀNG TRAI \n"
					+"Địa Chỉ: 12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, Thành Phố Hồ Chí Minh, Việt Nam \n"
					+"Điện Thoại: 0866677276 \n"
					+ "\n"
					+ "\n"
					+ "HÓA ĐƠN BÁN HÀNG", font);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			// Thông tin hóa đơn
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);

			float[] columnWidths = {1f, 1f};
			table.setWidths(columnWidths);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Mã hóa đơn: " + hd.getMaHD(), font));
			cell1.setBorderColor(BaseColor.WHITE);
			table.addCell(cell1);


//			Date arr = hd.getNgayLapHD();
//			
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//			String ngayLap = formatter.format(arr);
//
//			PdfPCell cell2 = new PdfPCell(new Paragraph("Ngày lập: " + ngayLap, font));
//			cell2.setBorderColor(BaseColor.WHITE);
//			table.addCell(cell2);
			Date currentDate = new Date();

			// Định dạng ngày theo "dd/MM/yyyy"
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String ngayLap = formatter.format(currentDate);

			// Tạo PdfPCell và thêm vào bảng
			PdfPCell cell2 = new PdfPCell(new Paragraph("Ngày lập: " + ngayLap, font));
			cell2.setBorderColor(BaseColor.WHITE);
			table.addCell(cell2);


			PdfPCell cell33 = new PdfPCell(new Paragraph("Mã Nhân viên: " + nv.getMaNV(), font));
			cell33.setBorderColor(BaseColor.WHITE);
			table.addCell(cell33);

			PdfPCell cell3 = new PdfPCell(new Paragraph("Nhân viên: " + nv.getTenNV(), font));
			cell3.setBorderColor(BaseColor.WHITE);
			table.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Paragraph("Khách hàng: " + kh.getTenKH(), font));
			cell4.setBorderColor(BaseColor.WHITE);
			table.addCell(cell4);

			document.add(table);

			// Thông tin chi tiết hóa đơn
			PdfPTable table1 = new PdfPTable(5);
			table1.setWidthPercentage(100);
			table1.setSpacingBefore(10f);
			table1.setSpacingAfter(10f);

			float[] columnWidths1 = {1f, 1f, 1f, 1f, 1f};
			table1.setWidths(columnWidths1);

			PdfPCell cell5 = new PdfPCell(new Paragraph("STT", font));
			cell5.setBorderColor(BaseColor.WHITE);
			table1.addCell(cell5);

			PdfPCell cell6 = new PdfPCell(new Paragraph("Tên quần áo", font));
			cell6.setBorderColor(BaseColor.WHITE);
			table1.addCell(cell6);

			PdfPCell cell7 = new PdfPCell(new Paragraph("Số lượng", font));
			cell7.setBorderColor(BaseColor.WHITE);
			table1.addCell(cell7);

			PdfPCell cell8 = new PdfPCell(new Paragraph("Đơn giá", font));
			cell8.setBorderColor(BaseColor.WHITE);
			table1.addCell(cell8);

			PdfPCell cell9 = new PdfPCell(new Paragraph("Thành tiền", font));
			cell9.setBorderColor(BaseColor.WHITE);
			table1.addCell(cell9);

			int i = 1;
			int tongTien = 0;
			int tienKhachTra = 0;

			for (ChiTietHoaDon cthd : listCTHD) {
				PdfPCell cell10 = new PdfPCell(new Paragraph(String.valueOf(i), font));
				cell10.setBorderColor(BaseColor.WHITE);
				table1.addCell(cell10);

				PdfPCell cell11 = new PdfPCell(new Paragraph(cthd.getQuanAo().getTenQuanAo(), font));
				cell11.setBorderColor(BaseColor.WHITE);
				table1.addCell(cell11);

				PdfPCell cell12 = new PdfPCell(new Paragraph(String.valueOf(cthd.getSoLuong()), font));
				cell12.setBorderColor(BaseColor.WHITE);
				table1.addCell(cell12);

				double giaBan = 0;
					giaBan = cthd.getQuanAo().tinhGiaBanLucSau();

				PdfPCell cell13 = new PdfPCell(new Paragraph(String.valueOf(giaBan), font));
				cell13.setBorderColor(BaseColor.WHITE);
				table1.addCell(cell13);

				//tính tổng tiền của quần áo
				double tongTienSP = giaBan * cthd.getSoLuong();

				PdfPCell cell14 = new PdfPCell(new Paragraph(String.valueOf(tongTienSP), font));
				cell14.setBorderColor(BaseColor.WHITE);
				table1.addCell(cell14);

				i++;
			}

			document.add(table1);

			// Thông tin khách hàng
			PdfPTable table2 = new PdfPTable(2);
			table2.setWidthPercentage(100);
			table2.setSpacingBefore(10f);
			table2.setSpacingAfter(10f);

			float[] columnWidths2 = {1f, 1f};
			table2.setWidths(columnWidths2);

			//tính tổng tiền của hóa đơn
			double tongTienHD = 0;
			for (ChiTietHoaDon cthd : listCTHD) {
				double giaBan = 0;
					giaBan = cthd.getQuanAo().tinhGiaBanLucSau();			
				double thanhTien = giaBan * cthd.getSoLuong();
				tongTienHD += thanhTien;
			}
			if (txt_tienKhachDua == null) {
				tienKhachTra = tongTien;
			} else {
				tienKhachTra = Integer.parseInt(txt_tienKhachDua.getText().trim());
			}

			double tienThua = tienKhachTra - tongTienHD;

			PdfPCell cell15 = new PdfPCell(new Paragraph("Tổng tiền: " + tongTienHD, font));
			cell15.setBorderColor(BaseColor.WHITE);
			table2.addCell(cell15);


			PdfPCell cell16 = new PdfPCell(new Paragraph("Khách đưa: " + tienKhachTra, font));
			cell16.setBorderColor(BaseColor.WHITE);
			table2.addCell(cell16);

			PdfPCell cell17 = new PdfPCell(new Paragraph("Tiền thừa: " + tienThua, font));
			cell17.setBorderColor(BaseColor.WHITE);
			table2.addCell(cell17);

			PdfPCell cell18 = new PdfPCell(new Paragraph(" "));
			cell18.setBorderColor(BaseColor.WHITE);
			table2.addCell(cell18);

			document.add(table2);

			//tạo vùng chữ ký ở cuối hóa đơn
			Paragraph paragraph1 = new Paragraph();
			paragraph1.add(new Chunk(new VerticalPositionMark()));
			document.add(paragraph1);

			//tạo chữ ký
			Paragraph paragraph2 = new Paragraph();
			paragraph2.add(new Chunk("Người lập hóa đơn", font));
			paragraph2.add(new Chunk(new VerticalPositionMark()));
			paragraph2.add(new Chunk("Khách hàng", font));
			document.add(paragraph2);
			
			for (int i2 = 0; i2 < 15; i2++) {
			    document.add(new Paragraph(" "));
			}
			//tạo dòng cảm ơn
			Paragraph thankYouParagraph = new Paragraph("(CẢM ƠN QUÝ KHÁCH HÀNG ĐÃ SỬ DỤNG QUẦN ÁO CỦA CHÚNG TÔI.)", font);
			thankYouParagraph.setAlignment(Element.ALIGN_CENTER);
			document.add(thankYouParagraph);

			document.close();

			// mở file pdf
			try {
				File file = new File(pathFull);
				if (file.exists()) {
					if (Desktop.isDesktopSupported()) {
						Desktop.getDesktop().open(file);
					} else {
						System.out.println("Awt Desktop is not supported!");
					}
				} else {
					System.out.println("File is not exists!");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}

	}              
}

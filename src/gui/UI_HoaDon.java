
package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import entity.ChiTietHoaDon;
import entity.HoaDon;


public class UI_HoaDon extends JPanel implements ActionListener, MouseListener {

	private JButton btn_TimKiem;
	private JButton btn_xuatHoaDon;
	private JLabel lb_tuKhoa;
	private JLabel lbl_danhSachHD;
	private JLabel lbl_danhSachQuanAo;
	private JLabel lbl_lapHoaDon;
	private JLabel lbl_maKH;
	private JLabel lbl_maNV;
	private JLabel lbl_ngayLapHD;
	private JLabel lbl_taoHoaDon;
	private JLabel lbl_tongTien;
	private JPanel pn_Form;
	private JPanel pn_Left;
	private JPanel pn_Right;
	private JPanel pn_Top;
	private JScrollPane scr_CTHD;
	private JScrollPane scr_DSSP;
	private JTable tbl_CTHD;
	private JTable table;
	private JTable tbl_danhSachQuanAo;
	private JTextField txt_ngayLapHD;
	private JTextField txt_tenKH;
	private JTextField txt_tenNV;
	private JTextField txt_timKiem;
	private JTextField txt_tongTien;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private DAO_HoaDon dao_hoaDon = new DAO_HoaDon();
	private DAO_ChiTietHoaDon dao_cthd = new DAO_ChiTietHoaDon();
	public UI_HoaDon() {
		initComponents();
		loadTblHoaDon();
	}

	private void initComponents() {

		pn_Form = new JPanel();
		pn_Right = new JPanel();
		lbl_taoHoaDon = new JLabel();
		btn_xuatHoaDon = new JButton();
		lbl_maKH = new JLabel();
		txt_tongTien = new JTextField();
		lbl_maNV = new JLabel();
		lbl_ngayLapHD = new JLabel();
		txt_tenKH = new JTextField();
		txt_tenNV = new JTextField();
		txt_ngayLapHD = new JTextField();
		lbl_tongTien = new JLabel();
		pn_Top = new JPanel();
		lbl_lapHoaDon = new JLabel();
		pn_Left = new JPanel();
		scr_DSSP = new JScrollPane();
		tbl_danhSachQuanAo = new JTable();
		lbl_danhSachHD = new JLabel();
		lbl_danhSachQuanAo = new JLabel();
		lb_tuKhoa = new JLabel();
		txt_timKiem = new JTextField();
		btn_TimKiem = new JButton();
		scr_CTHD = new JScrollPane();
		tbl_CTHD = new JTable();

		setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_Form.setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_Right.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lbl_taoHoaDon.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lbl_taoHoaDon.setForeground(new java.awt.Color(255, 0, 51));
		lbl_taoHoaDon.setText("Thông Tin Hóa Đơn");

		btn_xuatHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		btn_xuatHoaDon.setText("Xuất Hóa Đơn");


		lbl_maKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lbl_maKH.setText("Tên Khách Hàng:");

		txt_tongTien.setEnabled(false);
		txt_tongTien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//                txt_tongTienActionPerformed(evt);
			}
		});

		lbl_maNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lbl_maNV.setText("Tên Nhân Viên:");

		lbl_ngayLapHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lbl_ngayLapHD.setText("Ngày Lập HD:");

		txt_tenKH.setMinimumSize(new java.awt.Dimension(64, 25));
		txt_tenKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//                txt_tenKHActionPerformed(evt);
			}
		});

		txt_tenNV.setMinimumSize(new java.awt.Dimension(64, 25));
		txt_tenNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//                txt_tenNVActionPerformed(evt);
			}
		});

		txt_ngayLapHD.setMinimumSize(new java.awt.Dimension(64, 25));
		txt_ngayLapHD.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//                txt_ngayLapHDActionPerformed(evt);
			}
		});

		lbl_tongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lbl_tongTien.setText("Tổng Tiền:");

		GroupLayout pn_RightLayout = new GroupLayout(pn_Right);
		pn_Right.setLayout(pn_RightLayout);
		pn_RightLayout.setHorizontalGroup(
				pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addGap(15, 15, 15)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lbl_tongTien, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_maKH, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_ngayLapHD, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_taoHoaDon, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_maNV, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(txt_ngayLapHD, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
										.addComponent(txt_tenNV, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txt_tenKH, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txt_tongTien, GroupLayout.Alignment.LEADING))
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGap(51, 51, 51)
										.addComponent(btn_xuatHoaDon, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
										))
						.addContainerGap(58, Short.MAX_VALUE))
				);
		pn_RightLayout.setVerticalGroup(
				pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lbl_taoHoaDon, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addComponent(lbl_ngayLapHD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txt_ngayLapHD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(lbl_maNV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txt_tenNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(10, 10, 10)
						.addComponent(lbl_maKH, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txt_tenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lbl_tongTien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txt_tongTien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(100, 100, 100)
						.addComponent(btn_xuatHoaDon, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(175, Short.MAX_VALUE))
				);

		pn_Top.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_Top.setPreferredSize(new java.awt.Dimension(767, 51));

		lbl_lapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lbl_lapHoaDon.setText("HÓA ĐƠN");

		GroupLayout pn_TopLayout = new GroupLayout(pn_Top);
		pn_Top.setLayout(pn_TopLayout);
		pn_TopLayout.setHorizontalGroup(
				pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_TopLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbl_lapHoaDon)
						.addGap(539, 539, 539))
				);
		pn_TopLayout.setVerticalGroup(
				pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_TopLayout.createSequentialGroup()
						.addContainerGap(11, Short.MAX_VALUE)
						.addComponent(lbl_lapHoaDon)
						.addContainerGap())
				);

		pn_Left.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		model1 = new DefaultTableModel();
		tbl_danhSachQuanAo = new JTable(model1);
		tbl_danhSachQuanAo.setRowHeight(25);     
		model1.addColumn("Mã Quần Áo");
		model1.addColumn("Tên Quần Áo");
		model1.addColumn("Số Lượng");
		model1.addColumn("Giá");
		model1.addColumn("Loại");
		model1.addColumn("Màu Sắc");
		model1.addColumn("Thương Hiệu");
		model1.addColumn("Kích Thước");
		model1.addColumn("Chất Liệu");
		scr_DSSP = new JScrollPane(tbl_danhSachQuanAo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scr_DSSP.setPreferredSize(new Dimension(1000, 400));
		pn_Left.add(scr_DSSP);    
		scr_DSSP.setViewportView(tbl_danhSachQuanAo);
		if (tbl_danhSachQuanAo.getColumnModel().getColumnCount() > 0) {
			tbl_danhSachQuanAo.getColumnModel().getColumn(2).setResizable(false);
			tbl_danhSachQuanAo.getColumnModel().getColumn(5).setResizable(false);
		}

		lbl_danhSachHD.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lbl_danhSachHD.setForeground(new java.awt.Color(0, 102, 255));
		lbl_danhSachHD.setText("Danh Sách Hóa Đơn");

		lbl_danhSachQuanAo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lbl_danhSachQuanAo.setForeground(new java.awt.Color(0, 102, 255));
		lbl_danhSachQuanAo.setText("Danh Sách Quần Áo");

		lb_tuKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		lb_tuKhoa.setText("Từ  Khóa:");

		btn_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btn_TimKiem.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\find.png")); // NOI18N
		btn_TimKiem.setText("Tìm Kiếm");
		btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_TimKiemActionPerformed(evt);
			}
		});
		model2 = new DefaultTableModel();
		tbl_CTHD = new JTable(model2);
		tbl_CTHD.setRowHeight(25);     
		model2.addColumn("Mã Hóa Đơn");
		model2.addColumn("Tên Nhân Viên");
		model2.addColumn("Tên Khách Hàng");
		model2.addColumn("Ngày Lập Hóa Đơn");

		scr_CTHD = new JScrollPane(tbl_CTHD, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scr_CTHD.setPreferredSize(new Dimension(1000, 400));
		pn_Left.add(scr_CTHD);   
		tbl_CTHD.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				tbl_CTHDMousePressed(evt);
			}
		});
		scr_CTHD.setViewportView(tbl_CTHD);

		String[] columnNames = {"Mã Hóa Đơn","Tên Khách Hàng","Tên Nhân Viên","Ngày Lập Hóa Đơn","Tên Quần Áo","Số Lượng","Giá","Loại","Màu Sắc","Thương Hiệu","Kích Cỡ","Tổng Tiền"};
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		DuLieuXuatExcel();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(900, 165));

		GroupLayout pn_LeftLayout = new GroupLayout(pn_Left);
		pn_Left.setLayout(pn_LeftLayout);
		pn_LeftLayout.setHorizontalGroup(
				pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lbl_danhSachQuanAo)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, pn_LeftLayout.createSequentialGroup()
						.addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(GroupLayout.Alignment.LEADING, pn_LeftLayout.createSequentialGroup()
										.addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(pn_LeftLayout.createSequentialGroup()
														.addGap(23, 23, 23)
														.addComponent(lb_tuKhoa, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txt_timKiem, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(btn_TimKiem))
												.addGroup(pn_LeftLayout.createSequentialGroup()
														.addContainerGap()
														.addComponent(lbl_danhSachHD)))
										.addGap(0, 494, Short.MAX_VALUE))
								.addGroup(pn_LeftLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(scr_CTHD)
												.addComponent(scr_DSSP))))
						.addContainerGap())
				);
		pn_LeftLayout.setVerticalGroup(
				pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addGap(24, 24, 24)
						.addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(txt_timKiem, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_tuKhoa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_TimKiem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addComponent(lbl_danhSachHD, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scr_CTHD, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lbl_danhSachQuanAo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scr_DSSP, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		GroupLayout pn_FormLayout = new GroupLayout(pn_Form);
		pn_Form.setLayout(pn_FormLayout);
		pn_FormLayout.setHorizontalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pn_Top, GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
								.addGroup(pn_FormLayout.createSequentialGroup()
										.addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pn_Right, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				);
		pn_FormLayout.setVerticalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pn_Top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pn_Right, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
						.addContainerGap())

				);
		btn_xuatHoaDon.addActionListener(this);
	}// </editor-fold>//GEN-END:initComponents
	private void DuLieuXuatExcel() {
        DAO_ChiTietHoaDon dao = new DAO_ChiTietHoaDon();
        ArrayList<Object[]> dataList = dao.joinWithHD();

        // Clear existing rows in the table
        model.setRowCount(0);

        for (Object[] data : dataList) {
            model.addRow(data);
        }
    }

	//clear table hóa đơn
	public void clearTableHoaDon() {
		model2 = (DefaultTableModel) tbl_CTHD.getModel();
		model2.setRowCount(0);
	}

	//load table hóa đơn
	public void loadTblHoaDon() {
		clearTableHoaDon();
		model2 = (DefaultTableModel) tbl_CTHD.getModel();
		ArrayList<HoaDon> listHoaDon = dao_hoaDon.getAllHoaDon();
		for (HoaDon hoaDon1 : listHoaDon) {

			Object[] rowData = {hoaDon1.getMaHD(), hoaDon1.getNhanVien().getTenNV(), hoaDon1.getKhachHang().getTenKH(), new SimpleDateFormat("dd/MM/yyyy").format(hoaDon1.getNgayLapHD())};
			model2.addRow(rowData);
		}

	}
	//clear table sản phẩm
	public void clearTableQuanAo() {
		model1 = (DefaultTableModel) tbl_danhSachQuanAo.getModel();
		model1.setRowCount(0);
	}

	//load table sản phẩm
	public void loadTblQuanAo(String id) {
		clearTableQuanAo();
		model1 = (DefaultTableModel) tbl_danhSachQuanAo.getModel();
		ArrayList<ChiTietHoaDon> listCTHD = getListChiTietHoaDonByHoaDon(id);
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		for (ChiTietHoaDon e_ChiTietHoaDon : listCTHD) {
			String giaBan = decimalFormat.format(e_ChiTietHoaDon.getDonGia() / e_ChiTietHoaDon.getSoLuong());

			Object[] rowData = {e_ChiTietHoaDon.getQuanAo().getMaQuanAo(), e_ChiTietHoaDon.getQuanAo().getTenQuanAo(), e_ChiTietHoaDon.getSoLuong(), giaBan, e_ChiTietHoaDon.getQuanAo().getLoaiQuanAo().getLoai(), e_ChiTietHoaDon.getQuanAo().getMauSac().getMauSac(),e_ChiTietHoaDon.getQuanAo().getThuongHieu().getThuongHieu(), e_ChiTietHoaDon.getQuanAo().getKichCo().getKichCo(), e_ChiTietHoaDon.getQuanAo().getChatLieu().getChatLieu()};
			model1.addRow(rowData);
		}

	}
	public ArrayList<ChiTietHoaDon> getListChiTietHoaDonByHoaDon(String id) {


		return dao_cthd.getCTHDById(id);
	}
	//tính tổng tiền
	public double tinhTongTien(String id) {
		ArrayList<ChiTietHoaDon> listCTHD = getListChiTietHoaDonByHoaDon(id);
		double tongTien = 0;
		for (ChiTietHoaDon e_ChiTietHoaDon : listCTHD) {
			tongTien += e_ChiTietHoaDon.getDonGia();
		}
		return tongTien;
	}
	//lấy ngày
	public Date getDate(JDateChooser dateChooser) {
		long date = dateChooser.getDate().getTime();
		return new Date(date);
	}
	private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {
		clearTableHoaDon();
		clearTableQuanAo();
		String keyWord = txt_timKiem.getText().trim().toLowerCase();


		ArrayList<HoaDon> listHoaDon = dao_hoaDon.getAllHoaDon();
		model2 = (DefaultTableModel) tbl_CTHD.getModel();
		for(HoaDon e_HoaDon : listHoaDon){
			if(e_HoaDon.getMaHD().toLowerCase().contains(keyWord) ||
					e_HoaDon.getNhanVien().getTenNV().toLowerCase().contains(keyWord) || 
					e_HoaDon.getKhachHang().getTenKH().toLowerCase().contains(keyWord) || 
					e_HoaDon.getKhachHang().getsDT().contains(keyWord) || 
					e_HoaDon.getNhanVien().getMaNV().toLowerCase().contains(keyWord)) {

				Object[] rowdata={e_HoaDon.getMaHD(), e_HoaDon.getNhanVien().getTenNV(), 
						e_HoaDon.getKhachHang().getTenKH(), e_HoaDon.getNgayLapHD()};
				model2.addRow(rowdata);

			}
		}
	}
	private void tbl_CTHDMousePressed(java.awt.event.MouseEvent evt) {
		int row = tbl_CTHD.getSelectedRow();

		model2 = (DefaultTableModel) tbl_CTHD.getModel();
		String id = model2.getValueAt(row, 0).toString().trim();
		String tenNV = model2.getValueAt(row, 1).toString().trim();
		String tenKH = model2.getValueAt(row, 2).toString().trim();
		String date = model2.getValueAt(row, 3).toString().trim();

		txt_tenNV.setText(tenNV);
		txt_tenKH.setText(tenKH);
		txt_ngayLapHD.setText(date);

		String tongTien = NumberFormat.getInstance().format(tinhTongTien(id));
		txt_tongTien.setText(tongTien +" VNĐ");

		loadTblQuanAo(id);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
	    if (o.equals(btn_xuatHoaDon)) {
	    	try {
	            // Tạo tên file mới dựa trên ngày hiện tại
	            LocalDate currentDate = LocalDate.now();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            String uniqueFileName = "report_" + currentDate.format(formatter) + ".xls";

	            JOptionPane.showMessageDialog(null, "Đã xuất dữ liệu ra file excel thành công.");
	            ExcelExporter.exportTable(table, uniqueFileName);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}

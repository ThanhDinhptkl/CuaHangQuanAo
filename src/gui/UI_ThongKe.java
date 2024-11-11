/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;


public class UI_ThongKe extends javax.swing.JPanel implements ActionListener, MouseListener {
	private javax.swing.JButton btn_xuatHoaDon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_TenKhachHang;
    private javax.swing.JComboBox<String> cb_TenNhanVien;
    private javax.swing.JCheckBox cbx_TatCa;
    private com.toedter.calendar.JDateChooser dc_DenNgay;
    private com.toedter.calendar.JDateChooser dc_TuNgay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_DenNgay;
    private javax.swing.JLabel lb_KQTongDoanhthu;
    private javax.swing.JLabel lb_KQTongHD;
    private javax.swing.JLabel lb_TenKhachHang;
    private javax.swing.JLabel lb_TenNhanVien;
    private javax.swing.JLabel lb_TongDoanhThu;
    private javax.swing.JLabel lb_TongSoHoaDon;
    private javax.swing.JLabel lb_TuNgay;
    private javax.swing.JLabel lbl_ThongKeHoaDon;
    private javax.swing.JPanel pn_DanhSachHoaDon;
    private javax.swing.JPanel pn_TongDoanhThu;
    private javax.swing.JPanel pn_TongSoHoaDon;
    private javax.swing.JPanel pn_center;
    private javax.swing.JScrollPane scr_DanhSachHoaDon;
    private javax.swing.JTable tbl_DanhSachHoaDon;
    private JTable table;
    private DefaultTableModel model;
   
    private static final String Calibri = null;
   	private DAO_KhachHang khachHang_DAO = new DAO_KhachHang();
   	private DAO_NhanVien nhanVien_DAO = new DAO_NhanVien();
   	private DAO_ChiTietHoaDon cthd_DAO = new DAO_ChiTietHoaDon();
   	private DAO_HoaDon hoaDon_DAO = new DAO_HoaDon();
       public UI_ThongKe() throws SQLException {
           initComponents();
           designTable();
           tableHoaDon();
           khoiTaoGiaTri();
       }
       private void designTable() {
           tbl_DanhSachHoaDon.getTableHeader().setFont(new java.awt.Font("Calibri", 0, 12));
           tbl_DanhSachHoaDon.getTableHeader().setOpaque(false);
           tbl_DanhSachHoaDon.getTableHeader().setBackground(new Color(255,255,255));
           tbl_DanhSachHoaDon.getTableHeader().setForeground(Color.BLACK);
           tbl_DanhSachHoaDon.setDefaultEditor(Object.class, null); // Không cho phép edit


       }
       private void khoiTaoGiaTri(){
           ArrayList<NhanVien> listNhanVien = nhanVien_DAO.getAllNhanVien();
           
           for(NhanVien nv : listNhanVien){
               cb_TenNhanVien.addItem(nv.getTenNV());
           }
           
           ArrayList<KhachHang> listKhachHang = khachHang_DAO.getALLKhachHang();
           for(KhachHang kh : listKhachHang){
               cb_TenKhachHang.addItem(kh.getTenKH());
           }
           
           cbx_TatCa.setSelected(true);
           dc_TuNgay.setDate(Calendar.getInstance().getTime());
           dc_DenNgay.setDate(Calendar.getInstance().getTime());
       }
       private void clearTable(){
           DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachHoaDon.getModel();
           dtm.setRowCount(0);
        }
        
        private void tableHoaDon() throws SQLException {
            clearTable();
            
            String tenNhanVien = cb_TenNhanVien.getSelectedItem().toString();
            if(tenNhanVien.equals("Tất cả")) tenNhanVien = "";
            
            String tenKhachHang = cb_TenKhachHang.getSelectedItem().toString();
            if(tenKhachHang.equals("Tất cả")) tenKhachHang = "";
            
            ArrayList<HoaDon> listHoaDon = hoaDon_DAO.getAllHoaDon(tenKhachHang, tenNhanVien);
            
            double tongHoaDon = listHoaDon.size();
            double tongThanhTien = 0;
            DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachHoaDon.getModel();
            for(HoaDon hd : listHoaDon){
               double tongTien = cthd_DAO.tongTienHoaDon(hd.getMaHD());
               tongThanhTien += tongTien;
               Object[] rowData = {hd.getMaHD(), hd.getNhanVien().getTenNV(), hd.getKhachHang().getTenKH(), 
                   new SimpleDateFormat("dd/MM/yyyy").format(hd.getNgayLapHD()), NumberFormat.getInstance().format(tongTien)};
               dtm.addRow(rowData);
            }
            
            lb_KQTongDoanhthu.setText(NumberFormat.getInstance().format(tongThanhTien));
            lb_KQTongHD.setText(NumberFormat.getInstance().format(tongHoaDon));
        }
        
        
        private void tableHoaDonTheoTime() throws SQLException {
            clearTable();
            
            String tenNhanVien = cb_TenNhanVien.getSelectedItem().toString();
            if(tenNhanVien.equals("Tất cả")) tenNhanVien = "";
            
            String tenKhachHang = cb_TenKhachHang.getSelectedItem().toString();
            if(tenKhachHang.equals("Tất cả")) tenKhachHang = "";
            
           
            
           
            
            String tuNgay = new SimpleDateFormat("yyyy-MM-dd").format( dc_TuNgay.getDate());
            String denNgay = new SimpleDateFormat("yyyy-MM-dd").format( dc_DenNgay.getDate());

             ArrayList<HoaDon> listHoaDon = hoaDon_DAO.getAllHoaDon(tenKhachHang, tenNhanVien, tuNgay, denNgay);
             
            double tongHoaDon = listHoaDon.size();
            double tongThanhTien = 0;
            
            DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachHoaDon.getModel();
            for(HoaDon hd : listHoaDon){
               double tongTien = cthd_DAO.tongTienHoaDon(hd.getMaHD());
               tongThanhTien += tongTien;
               Object[] rowData = {hd.getMaHD(), hd.getNhanVien().getTenNV(), hd.getKhachHang().getTenKH(), 
                   new SimpleDateFormat("dd/MM/yyyy").format(hd.getNgayLapHD()), NumberFormat.getInstance().format(tongTien)};
               dtm.addRow(rowData);
            }
            
            lb_KQTongDoanhthu.setText(NumberFormat.getInstance().format(tongThanhTien));
            lb_KQTongHD.setText(NumberFormat.getInstance().format(tongHoaDon));
        }
        
        private boolean isTuNgayValid(){
            Date currentDate = Calendar.getInstance().getTime();
            if(dc_TuNgay.getDate().getTime() - currentDate.getTime() > 0){
                JOptionPane.showMessageDialog(null, "Ngày phải bé hơn hoặc bằng ngày hiện tại");
                return false;
            }
            
            return true;
        }
        
        private boolean isDenNgayValid(){
            Date currentDate = Calendar.getInstance().getTime();
            Date tuNgay = dc_TuNgay.getDate();
            Date denNgay = dc_DenNgay.getDate();
            
            if(denNgay.getTime() - currentDate.getTime() > 0){
                JOptionPane.showMessageDialog(null, "Ngày phải bé hơn hoặc bằng ngày hiện tại");
                return false;
            }
            
            if(tuNgay.getTime() - denNgay.getTime() > 0){
                JOptionPane.showMessageDialog(null, "Đến ngày phải có giá trị lớn hơn từ ngày");
                        
                return false;
            }
            return true;
        }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_ThongKeHoaDon = new javax.swing.JLabel();
        pn_center = new javax.swing.JPanel();
        lb_TenNhanVien = new javax.swing.JLabel();
        lb_TenKhachHang = new javax.swing.JLabel();
        pn_TongSoHoaDon = new javax.swing.JPanel();
        lb_TongSoHoaDon = new javax.swing.JLabel();
        lb_KQTongHD = new javax.swing.JLabel();
        pn_TongDoanhThu = new javax.swing.JPanel();
        lb_TongDoanhThu = new javax.swing.JLabel();
        lb_KQTongDoanhthu = new javax.swing.JLabel();
        cb_TenKhachHang = new javax.swing.JComboBox<>();
        cb_TenNhanVien = new javax.swing.JComboBox<>();
        dc_TuNgay = new com.toedter.calendar.JDateChooser();
        dc_DenNgay = new com.toedter.calendar.JDateChooser();
        lb_TuNgay = new javax.swing.JLabel();
        lb_DenNgay = new javax.swing.JLabel();
        cbx_TatCa = new javax.swing.JCheckBox();
        btn_xuatHoaDon = new javax.swing.JButton();
        pn_DanhSachHoaDon = new javax.swing.JPanel();
        scr_DanhSachHoaDon = new javax.swing.JScrollPane();
        tbl_DanhSachHoaDon = new javax.swing.JTable();
      //chuyển định dạng ngày tháng đầu vào thành dd/MM/yyyy
        dc_TuNgay.setDateFormatString("dd/MM/yyyy");
        dc_DenNgay.setDateFormatString("dd/MM/yyyy");
        setPreferredSize(new java.awt.Dimension(1380, 853));

        jPanel1.setPreferredSize(new java.awt.Dimension(1380, 853));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_ThongKeHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_ThongKeHoaDon.setText("THỐNG KÊ DOANH THU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(lbl_ThongKeHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_ThongKeHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pn_center.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_TenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TenNhanVien.setText("Tên Nhân Viên:");

        lb_TenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TenKhachHang.setText("Tên Khách Hàng:");
        cb_TenNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cb_TenNhanVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                try {
					cb_TenNhanVienItemStateChanged(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }); 
        cb_TenKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cb_TenKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                try {
					cb_TenKhachHangItemStateChanged(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
       
        pn_TongSoHoaDon.setBackground(new java.awt.Color(153, 255, 255));
        pn_TongSoHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_TongSoHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TongSoHoaDon.setText("Tổng Số Hóa Đơn");

        lb_KQTongHD.setBackground(new java.awt.Color(153, 255, 255));
        lb_KQTongHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_KQTongHD.setText("0");

        javax.swing.GroupLayout pn_TongSoHoaDonLayout = new javax.swing.GroupLayout(pn_TongSoHoaDon);
        pn_TongSoHoaDon.setLayout(pn_TongSoHoaDonLayout);
        pn_TongSoHoaDonLayout.setHorizontalGroup(
            pn_TongSoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TongSoHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_TongSoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_KQTongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TongSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pn_TongSoHoaDonLayout.setVerticalGroup(
            pn_TongSoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TongSoHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_TongSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lb_KQTongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pn_TongDoanhThu.setBackground(new java.awt.Color(255, 255, 204));
        pn_TongDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_TongDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TongDoanhThu.setText("Tổng Doanh Thu");

        lb_KQTongDoanhthu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_KQTongDoanhthu.setText("0");

        javax.swing.GroupLayout pn_TongDoanhThuLayout = new javax.swing.GroupLayout(pn_TongDoanhThu);
        pn_TongDoanhThu.setLayout(pn_TongDoanhThuLayout);
        pn_TongDoanhThuLayout.setHorizontalGroup(
            pn_TongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_TongDoanhThuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_KQTongDoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(pn_TongDoanhThuLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lb_TongDoanhThu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_TongDoanhThuLayout.setVerticalGroup(
            pn_TongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TongDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_TongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lb_KQTongDoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lb_TuNgay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TuNgay.setText("Từ Ngày:");
        dc_TuNgay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                try {
					dc_TuNgayPropertyChange(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        lb_DenNgay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_DenNgay.setText("Đến Ngày:");
        dc_DenNgay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                try {
					dc_DenNgayPropertyChange(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        cbx_TatCa.setText("Tất Cả");
        cbx_TatCa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                try {
					cb_TatCaItemStateChanged(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btn_xuatHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        btn_xuatHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_xuatHoaDon.setText("Xuất Thống Kê");
        btn_xuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_centerLayout = new javax.swing.GroupLayout(pn_center);
        pn_center.setLayout(pn_centerLayout);
        pn_centerLayout.setHorizontalGroup(
            pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_centerLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pn_TongSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(pn_TongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pn_centerLayout.createSequentialGroup()
                            .addComponent(lb_TenKhachHang)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cb_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pn_centerLayout.createSequentialGroup()
                            .addComponent(lb_TenNhanVien)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_TenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_centerLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btn_xuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_centerLayout.createSequentialGroup()
                        .addComponent(lb_TuNgay)
                        .addGap(18, 18, 18)
                        .addComponent(dc_TuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_centerLayout.createSequentialGroup()
                        .addComponent(lb_DenNgay)
                        .addGap(18, 18, 18)
                        .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_TatCa)
                            .addComponent(dc_DenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        pn_centerLayout.setVerticalGroup(
            pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_centerLayout.createSequentialGroup()
                .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_centerLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cb_TenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_TuNgay)
                                .addComponent(lb_TenNhanVien))
                            .addComponent(dc_TuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_TenKhachHang)
                                .addComponent(cb_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_DenNgay))
                            .addComponent(dc_DenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_TatCa)
                            .addComponent(btn_xuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_centerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pn_TongSoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_TongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pn_DanhSachHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_DanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Tên Nhân Viên", "Tên Khách Hàng", "Ngày Lập ", "Thành Tiền"
            }
        ));
        scr_DanhSachHoaDon.setViewportView(tbl_DanhSachHoaDon);
        
        String[] columnNames = {"Mã Hóa Đơn","Tên Nhân Viên","Tên Khách Hàng","Ngày Lập","Thành Tiền"};
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		DuLieuXuatExcel();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(900, 165));

        javax.swing.GroupLayout pn_DanhSachHoaDonLayout = new javax.swing.GroupLayout(pn_DanhSachHoaDon);
        pn_DanhSachHoaDon.setLayout(pn_DanhSachHoaDonLayout);
        pn_DanhSachHoaDonLayout.setHorizontalGroup(
            pn_DanhSachHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DanhSachHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr_DanhSachHoaDon)
                .addContainerGap())
        );
        pn_DanhSachHoaDonLayout.setVerticalGroup(
            pn_DanhSachHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DanhSachHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr_DanhSachHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_DanhSachHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_DanhSachHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn_xuatHoaDon.addActionListener(this);
    }// </editor-fold>//GEN-END:initComponents

    private void DuLieuXuatExcel() {
        DAO_ChiTietHoaDon dao = new DAO_ChiTietHoaDon();
        ArrayList<Object[]> dataList = dao.ThongKeDoanhThu();

        // Clear existing rows in the table
        model.setRowCount(0);

        for (Object[] data : dataList) {
            model.addRow(data);
        }
    }
    private void btn_xuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xuatHoaDonActionPerformed

    private void cb_TenNhanVienItemStateChanged(java.awt.event.ItemEvent evt) throws SQLException  {//GEN-FIRST:event_cb_TenNhanVienItemStateChanged
        if(cbx_TatCa.isSelected()){
            tableHoaDon();
        }else if(!cbx_TatCa.isSelected()){
            tableHoaDonTheoTime();
        }
    }//GEN-LAST:event_cb_TenNhanVienItemStateChanged

    private void cb_TenKhachHangItemStateChanged(java.awt.event.ItemEvent evt) throws SQLException  {//GEN-FIRST:event_cb_TenKhachHangItemStateChanged
        // TODO add your handling code here:
        if(cbx_TatCa.isSelected()){
            tableHoaDon();
        }else if(!cbx_TatCa.isSelected()){
            tableHoaDonTheoTime();
        }
    }//GEN-LAST:event_cb_TenKhachHangItemStateChanged

    private void cb_TatCaItemStateChanged(java.awt.event.ItemEvent evt) throws SQLException  {//GEN-FIRST:event_cb_TatCaItemStateChanged
        // TODO add your handling code here:
        if(cbx_TatCa.isSelected()){
            tableHoaDon();
        }else if(!cbx_TatCa.isSelected()){
            tableHoaDonTheoTime();
        }
    }//GEN-LAST:event_cb_TatCaItemStateChanged

    private void dc_TuNgayPropertyChange(java.beans.PropertyChangeEvent evt) throws SQLException  {//GEN-FIRST:event_dc_TuNgayPropertyChange
        // TODO add your handling code here:
        if(!isTuNgayValid()) return; 
        
         if(cbx_TatCa.isSelected()){
            tableHoaDon();
        }else if(!cbx_TatCa.isSelected()){
            tableHoaDonTheoTime();
        }
    }//GEN-LAST:event_dc_TuNgayPropertyChange

    private void dc_DenNgayPropertyChange(java.beans.PropertyChangeEvent evt) throws SQLException  {//GEN-FIRST:event_dc_DenNgayPropertyChange
        // TODO add your handling code here:
        if(!isDenNgayValid()) return;
        
         if(cbx_TatCa.isSelected()){
            tableHoaDon();
        }else if(!cbx_TatCa.isSelected()){
            tableHoaDonTheoTime();
        }
    }//GEN-LAST:event_dc_DenNgayPropertyChange

    private void cb_TenKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TenKhachHangActionPerformed
        // TODO add your handling code here:
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
	            String uniqueFileName = "ThongKeDoanhThu_" + currentDate.format(formatter) + ".xls";

	            JOptionPane.showMessageDialog(null, "Đã xuất dữ liệu ra file excel thành công.");
	            ExcelExporter.exportTable(table, uniqueFileName);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}

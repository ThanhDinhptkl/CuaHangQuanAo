/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.DAO_ChatLieu;
import dao.DAO_KichCo;
import dao.DAO_LoaiQuanAo;
import dao.DAO_MauSac;
import dao.DAO_NhaCungCap;
import dao.DAO_QuanAo;
import dao.DAO_ThuongHieu;
import entity.ChatLieu;
import entity.KichCo;
import entity.LoaiQuanAo;
import entity.MauSac;
import entity.NhaCungCap;
import entity.QuanAo;
import entity.ThuongHieu;


public class UI_TimKiemQuanAo extends javax.swing.JPanel implements ActionListener, MouseListener {

	public UI_TimKiemQuanAo() {
		initComponents();
	}

    private void initComponents() {

        pnl = new javax.swing.JPanel();
        pnlThuocTinh = new javax.swing.JPanel();
        txtMaQuanAo = new javax.swing.JTextField();
        txtTenQuanAo = new javax.swing.JTextField();
        lblMaQuanAo = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblTenQuanAo = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cmbNhaCungCap = new javax.swing.JComboBox<>();
        lblNhaCungCap = new javax.swing.JLabel();
        cmbMauSac = new javax.swing.JComboBox<>();
        lblMauSac = new javax.swing.JLabel();
        lblThuongHieu = new javax.swing.JLabel();
        cmbThuongHieu = new javax.swing.JComboBox<>();
        cmbChatLieu = new javax.swing.JComboBox<>();
        cmbKichCo = new javax.swing.JComboBox<>();
        cmbLoai = new javax.swing.JComboBox<>();
        lblKichCo = new javax.swing.JLabel();
        lblLoai = new javax.swing.JLabel();
        lblChatLieu = new javax.swing.JLabel();
        pnlChucNang = new javax.swing.JPanel();
        lblGiaBan = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        pnlChuaAnh = new javax.swing.JPanel();
        lblChuaAnh = new javax.swing.JLabel();
        btnTimKiemQuanAo = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        lblGiaNhap = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        pnlDanhSachQuanAo = new javax.swing.JPanel();
        scr_DSSP1 = new javax.swing.JScrollPane();
        tblDanhSachQuanAo = new javax.swing.JTable();
        lblDanhSachQuanAo = new javax.swing.JLabel();
        pnlTimKiemQuanAo = new javax.swing.JPanel();
        lblTimKiemQuanAo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1308, 758));
        setVerifyInputWhenFocusTarget(false);

        pnl.setPreferredSize(new java.awt.Dimension(1308, 758));

        pnlThuocTinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        lblMaQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaQuanAo.setText("Mã Quần Áo:");

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoLuong.setText("Số Lượng:");

        lblTenQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenQuanAo.setText("Tên Quần Áo:");

        lblNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNhaCungCap.setText("Nhà Cung Cấp:");

        lblMauSac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMauSac.setText("Màu Sắc:");

        lblThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblThuongHieu.setText("Thương Hiệu:");

        lblKichCo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblKichCo.setText("Kích cỡ:");

        lblLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLoai.setText("Loại:");

        lblChatLieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblChatLieu.setText("Chất Liệu:");

        javax.swing.GroupLayout pnlThuocTinhLayout = new javax.swing.GroupLayout(pnlThuocTinh);
        pnlThuocTinh.setLayout(pnlThuocTinhLayout);
        pnlThuocTinhLayout.setHorizontalGroup(
            pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThuocTinhLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNhaCungCap)
                    .addComponent(lblSoLuong)
                    .addComponent(txtSoLuong)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTenQuanAo)
                        .addComponent(lblMaQuanAo)
                        .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenQuanAo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtMaQuanAo, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(cmbNhaCungCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMauSac)
                    .addComponent(cmbMauSac, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblThuongHieu)
                    .addComponent(lblChatLieu)
                    .addComponent(lblKichCo)
                    .addComponent(lblLoai)
                    .addComponent(cmbKichCo, 0, 263, Short.MAX_VALUE)
                    .addComponent(cmbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbThuongHieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThuocTinhLayout.setVerticalGroup(
            pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThuocTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaQuanAo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThuocTinhLayout.createSequentialGroup()
                        .addComponent(txtMaQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenQuanAo)
                            .addComponent(cmbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblThuongHieu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThuocTinhLayout.createSequentialGroup()
                        .addComponent(txtTenQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoLuong)
                            .addComponent(cmbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKichCo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNhaCungCap)
                            .addComponent(cmbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMauSac)
                            .addComponent(cmbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblChatLieu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlChucNang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGiaBan.setText("Giá Bán");

        txtGiaNhap.setEditable(false);

        pnlChuaAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblChuaAnh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblChuaAnh.setOpaque(true);
        lblChuaAnh.setOpaque(true);
        lblChuaAnh.setMaximumSize(new java.awt.Dimension(159, 143));
        lblChuaAnh.setMinimumSize(new java.awt.Dimension(159, 143));
        lblChuaAnh.setPreferredSize(new java.awt.Dimension(159, 143));
        javax.swing.GroupLayout pnlChuaAnhLayout = new javax.swing.GroupLayout(pnlChuaAnh);
        pnlChuaAnh.setLayout(pnlChuaAnhLayout);
        pnlChuaAnhLayout.setHorizontalGroup(
            pnlChuaAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChuaAnhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChuaAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlChuaAnhLayout.setVerticalGroup(
            pnlChuaAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChuaAnhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChuaAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTimKiemQuanAo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiemQuanAo.setIcon(new javax.swing.ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\find.png")); // NOI18N
        btnTimKiemQuanAo.setText("Tìm Kiếm Quần Áo");
        btnTimKiemQuanAo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemQuanAoActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\refresh.png")); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        lblGiaNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGiaNhap.setText("Giá Nhập");

        txtGiaBan.setEditable(false);

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiemQuanAo, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(txtGiaNhap)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(lblGiaBan)
                    .addComponent(lblGiaNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(pnlChuaAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlChucNangLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pnlChuaAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChucNangLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblGiaNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGiaBan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlDanhSachQuanAo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


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
		pnlDanhSachQuanAo.add(qa);
		scr_DSSP1.setViewportView(tblDanhSachQuanAo);

        lblDanhSachQuanAo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblDanhSachQuanAo.setForeground(new java.awt.Color(0, 102, 255));
        lblDanhSachQuanAo.setText("Danh Sách Quần Áo");

        javax.swing.GroupLayout pnlDanhSachQuanAoLayout = new javax.swing.GroupLayout(pnlDanhSachQuanAo);
        pnlDanhSachQuanAo.setLayout(pnlDanhSachQuanAoLayout);
        pnlDanhSachQuanAoLayout.setHorizontalGroup(
            pnlDanhSachQuanAoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachQuanAoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDanhSachQuanAoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDanhSachQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scr_DSSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 1269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pnlDanhSachQuanAoLayout.setVerticalGroup(
            pnlDanhSachQuanAoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachQuanAoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDanhSachQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_DSSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlDanhSachQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDanhSachQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pnlTimKiemQuanAo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTimKiemQuanAo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTimKiemQuanAo.setText("TÌM KIẾM QUẦN ÁO");

        javax.swing.GroupLayout pnlTimKiemQuanAoLayout = new javax.swing.GroupLayout(pnlTimKiemQuanAo);
        pnlTimKiemQuanAo.setLayout(pnlTimKiemQuanAoLayout);
        pnlTimKiemQuanAoLayout.setHorizontalGroup(
            pnlTimKiemQuanAoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemQuanAoLayout.createSequentialGroup()
                .addGap(606, 606, 606)
                .addComponent(lblTimKiemQuanAo)
                .addContainerGap(455, Short.MAX_VALUE))
        );
        pnlTimKiemQuanAoLayout.setVerticalGroup(
            pnlTimKiemQuanAoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemQuanAoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTimKiemQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTimKiemQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTimKiemQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
        
        loadComboBoxThuocTinh();

		napDuLieuTuCSDL(dao_QuanAo.getAllQuanAo());
		tblDanhSachQuanAo.addMouseListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiemQuanAo.addActionListener(this);
    }// </editor-fold>//GEN-END:initComponents

	private void napDuLieuTuCSDL(ArrayList<QuanAo> ds) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		dtm.getDataVector().removeAllElements();
		for (QuanAo e_QuanAo : ds) {
			String giaBan = decimalFormat.format(e_QuanAo.tinhGiaBanLucSau());
			model.addRow(new Object[] { e_QuanAo.getMaQuanAo(), e_QuanAo.getTenQuanAo(), e_QuanAo.getLoaiQuanAo().getLoai(),
					giaBan, e_QuanAo.getKichCo().getKichCo(), e_QuanAo.getMauSac().getMauSac(),
					e_QuanAo.getChatLieu().getChatLieu(), e_QuanAo.getNhaCungCap().getTenNCC(),
					e_QuanAo.getThuongHieu().getThuongHieu(), e_QuanAo.getSoLuong() });
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
		dsLoaiQuanAo.forEach(loaiQA -> cmbLoai.addItem(loaiQA.getLoai()));

		dao_nhaCungCap = new DAO_NhaCungCap();
		ArrayList<NhaCungCap> dsNCC = dao_nhaCungCap.getAllNCC();
		dsNCC.forEach(nhaCungCap -> cmbNhaCungCap.addItem(nhaCungCap.getTenNCC()));

	}

	private void xoaTrang() {
		txtMaQuanAo.setText("");
		txtTenQuanAo.setText("");
		txtSoLuong.setText("");
		cmbNhaCungCap.setSelectedIndex(0);
		cmbMauSac.setSelectedIndex(0);
		cmbThuongHieu.setSelectedIndex(0);
		cmbChatLieu.setSelectedIndex(0);
		cmbKichCo.setSelectedIndex(0);
		cmbLoai.setSelectedIndex(0);
		txtGiaNhap.setText("");
		txtGiaBan.setText("");
		lblChuaAnh.setIcon(new ImageIcon());
	}

	private void txtMaQuanAoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtMaQuanAoActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtMaQuanAoActionPerformed

	private void txtTenQuanAoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTenQuanAoActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTenQuanAoActionPerformed

	private void btnTimKiemQuanAoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimKiemQuanAoActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnTimKiemQuanAoActionPerformed

	private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLamMoiActionPerformed
	}// GEN-LAST:event_btnLamMoiActionPerformed

	public ImageIcon ResizeImage(String imgPath) {
		ImageIcon myImage = new ImageIcon(imgPath);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(pnlChuaAnh.getWidth(), pnlChuaAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		return image;
	}

	private void fillForm(int r) {

		DefaultTableModel dtm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
		File file = new File("");
		String path = file.getAbsolutePath();
		String maQuanAo = dtm.getValueAt(r, 0).toString();
		QuanAo e_QuanAo = dao_QuanAo.TimKiemQuanAoTheoMa(maQuanAo);
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		lblChuaAnh.setIcon(ResizeImage(path + "/img/" + e_QuanAo.getHinhAnh()));

		txtMaQuanAo.setText(e_QuanAo.getMaQuanAo());
		txtTenQuanAo.setText(e_QuanAo.getTenQuanAo());
		cmbThuongHieu.setSelectedItem(e_QuanAo.getThuongHieu().getThuongHieu());
		cmbKichCo.setSelectedItem(e_QuanAo.getKichCo().getKichCo());
		cmbLoai.setSelectedItem(e_QuanAo.getLoaiQuanAo().getLoai());
		cmbMauSac.setSelectedItem(e_QuanAo.getMauSac().getMauSac());
		cmbChatLieu.setSelectedItem(e_QuanAo.getChatLieu().getChatLieu());
		cmbNhaCungCap.setSelectedItem(e_QuanAo.getNhaCungCap().getTenNCC());
		txtSoLuong.setText(String.valueOf(e_QuanAo.getSoLuong()));
		txtGiaNhap.setText(String.valueOf(decimalFormat.format(e_QuanAo.getDonGiaBan())));
		txtGiaBan.setText(dtm.getValueAt(r, 3).toString());
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int r = tblDanhSachQuanAo.getSelectedRow();
		fillForm(r);

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
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTimKiemQuanAo)) {
			timKiemQuanAo();
		} else if (o.equals(btnLamMoi)) {
			xoaTrang();
			napDuLieuTuCSDL(dao_QuanAo.getAllQuanAo());
		}

	}

	public void timKiemQuanAo() {
		String ma = txtMaQuanAo.getText().trim();
		QuanAo e_QuanAo = dao_QuanAo.TimKiemQuanAoTheoMa(ma);
		if (e_QuanAo != null) {
			DefaultTableModel dm = (DefaultTableModel) tblDanhSachQuanAo.getModel();
			dm.getDataVector().removeAllElements();
			String giaBan = NumberFormat.getInstance().format(e_QuanAo.tinhGiaBanLucSau());
			model.addRow(new Object[] { e_QuanAo.getMaQuanAo(), e_QuanAo.getTenQuanAo(), e_QuanAo.getLoaiQuanAo().getLoai(),
					giaBan, e_QuanAo.getKichCo().getKichCo(), e_QuanAo.getMauSac().getMauSac(),
					e_QuanAo.getChatLieu().getChatLieu(), e_QuanAo.getNhaCungCap().getTenNCC(),
					e_QuanAo.getThuongHieu().getThuongHieu(), e_QuanAo.getSoLuong() });
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Quần Áo Có Mã Là " + ma + "!");
		}
		xoaTrang();

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiemQuanAo;
    private javax.swing.JComboBox<String> cmbChatLieu;
    private javax.swing.JComboBox<String> cmbKichCo;
    private javax.swing.JComboBox<String> cmbLoai;
    private javax.swing.JComboBox<String> cmbMauSac;
    private javax.swing.JComboBox<String> cmbNhaCungCap;
    private javax.swing.JComboBox<String> cmbThuongHieu;
    private javax.swing.JLabel lblChatLieu;
    private javax.swing.JLabel lblChuaAnh;
    private javax.swing.JLabel lblDanhSachQuanAo;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblGiaNhap;
    private javax.swing.JLabel lblKichCo;
    private javax.swing.JLabel lblLoai;
    private javax.swing.JLabel lblMaQuanAo;
    private javax.swing.JLabel lblMauSac;
    private javax.swing.JLabel lblNhaCungCap;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenQuanAo;
    private javax.swing.JLabel lblThuongHieu;
    private javax.swing.JLabel lblTimKiemQuanAo;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnlChuaAnh;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlDanhSachQuanAo;
    private javax.swing.JPanel pnlThuocTinh;
    private javax.swing.JPanel pnlTimKiemQuanAo;
    private javax.swing.JScrollPane scr_DSSP1;
    private javax.swing.JTable tblDanhSachQuanAo;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaQuanAo;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenQuanAo;
    private DefaultTableModel model;
	private DAO_QuanAo dao_QuanAo = new DAO_QuanAo();
	private DAO_MauSac dao_mauSac = new DAO_MauSac();
	private DAO_KichCo dao_kichCo = new DAO_KichCo();
	private DAO_ChatLieu dao_chatLieu = new DAO_ChatLieu();
	private DAO_LoaiQuanAo dao_loaiQuanAo = new DAO_LoaiQuanAo();
	private DAO_ThuongHieu dao_thuongHieu = new DAO_ThuongHieu();
	private DAO_NhaCungCap dao_nhaCungCap = new DAO_NhaCungCap();
    // End of variables declaration//GEN-END:variables
}

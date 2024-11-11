package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
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

import dao.DAO_NhanVien;
import entity.NhanVien;

public class UI_TimKiemNhanVien extends JPanel implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	private JButton btnDate;
	private JButton btnLamMoi;
	private JButton btnTimKiemNhanVien;
	private JComboBox<String> cmbGioiTinh;
	private JLabel lblTKNV;
	private JLabel lblDanhSachNhanVien;
	private JLabel lblDiaChi;
	private JLabel lblEmail;
	private JLabel lblGioiTinh;
	private JLabel lblMaNhanVien;
	private JLabel lblNgaySinh;
	private JLabel lblQuanLyNhanVien;
	private JLabel lblSoDienThoai;
	private JLabel lbl_tenNV;
	private JPanel pn_left;
	private JPanel pn_right;
	private JPanel pn_top;
	private JScrollPane scr_DSNV;
	private JTable tblDanhSachNhanVien;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtMaNhanVien;
	private JTextField txtNgaySinh;
	private JTextField txtSoDienThoai;
	private JTextField txtTenNhanVien;

	private DefaultTableModel model;
	private DAO_NhanVien nhanVien_dao = new DAO_NhanVien();

	public UI_TimKiemNhanVien() {
		initComponents();
	}

	private void initComponents() {

		pn_top = new JPanel();
		lblTKNV = new JLabel();
		pn_left = new JPanel();
		scr_DSNV = new JScrollPane();
		tblDanhSachNhanVien = new JTable();
		lblDanhSachNhanVien = new JLabel();
		pn_right = new JPanel();
		txtMaNhanVien = new JTextField();
		txtTenNhanVien = new JTextField();
		txtSoDienThoai = new JTextField();
		txtDiaChi = new JTextField();
		txtEmail = new JTextField();
		txtNgaySinh = new JTextField();
		lblNgaySinh = new JLabel();
		lblSoDienThoai = new JLabel();
		lbl_tenNV = new JLabel();
		lblDiaChi = new JLabel();
		lblGioiTinh = new JLabel();
		lblMaNhanVien = new JLabel();
		lblQuanLyNhanVien = new JLabel();
		lblEmail = new JLabel();
		cmbGioiTinh = new JComboBox<>();
		btnDate = new JButton();
		btnLamMoi = new JButton();
		btnTimKiemNhanVien = new JButton();

		setPreferredSize(new java.awt.Dimension(1302, 758));

		pn_top.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_top.setPreferredSize(new java.awt.Dimension(808, 72));

		lblTKNV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lblTKNV.setText("TÌM KIẾM NHÂN VIÊN");

		GroupLayout pn_topLayout = new GroupLayout(pn_top);
		pn_top.setLayout(pn_topLayout);
		pn_topLayout.setHorizontalGroup(
				pn_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_topLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTKNV, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
						.addGap(515, 515, 515))
				);
		pn_topLayout.setVerticalGroup(
				pn_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_topLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblTKNV, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addContainerGap())
				);

		pn_left.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		model = new DefaultTableModel();
		tblDanhSachNhanVien = new JTable(model);
		tblDanhSachNhanVien.setRowHeight(25);     
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Tên Nhân Viên");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Địa Chí");
		model.addColumn("Giới Tính");
		model.addColumn("Email");
		model.addColumn("Ngày Sinh");
		JScrollPane sp = new JScrollPane(tblDanhSachNhanVien, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(1000, 400));
		pn_left.add(sp);

		scr_DSNV.setViewportView(tblDanhSachNhanVien);

		lblDanhSachNhanVien.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lblDanhSachNhanVien.setForeground(new java.awt.Color(0, 102, 255));
		lblDanhSachNhanVien.setText("Danh Sách Nhân Viên");

		GroupLayout pn_leftLayout = new GroupLayout(pn_left);
		pn_left.setLayout(pn_leftLayout);
		pn_leftLayout.setHorizontalGroup(
				pn_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_leftLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
								.addGroup(pn_leftLayout.createSequentialGroup()
										.addComponent(lblDanhSachNhanVien, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				);
		pn_leftLayout.setVerticalGroup(
				pn_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_leftLayout.createSequentialGroup()
						.addComponent(lblDanhSachNhanVien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scr_DSNV, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		pn_right.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_right.setPreferredSize(new java.awt.Dimension(406, 668));

		txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMaNhanVienActionPerformed(evt);
			}
		});

		txtTenNhanVien.setMinimumSize(new java.awt.Dimension(64, 25));
		txtTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTenNhanVienActionPerformed(evt);
			}
		});

		txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSoDienThoaiActionPerformed(evt);
			}
		});

		txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDiaChiActionPerformed(evt);
			}
		});

		txtEmail.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtEmailActionPerformed(evt);
			}
		});

		txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtNgaySinhActionPerformed(evt);
			}
		});

		lblNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblNgaySinh.setText("Ngày Sinh:");

		lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSoDienThoai.setText("Số Điện Thoại:");

		lbl_tenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lbl_tenNV.setText("Tên Nhân Viên:");

		lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblDiaChi.setText("Địa Chỉ:");

		lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblGioiTinh.setText("Giới Tính:");

		lblMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblMaNhanVien.setText("Mã Nhân Viên:");

		lblQuanLyNhanVien.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lblQuanLyNhanVien.setForeground(new java.awt.Color(255, 0, 51));
		lblQuanLyNhanVien.setText("Quản Lý Nhân Viên");

		lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblEmail.setText("Email:");

		cmbGioiTinh.setModel(new DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

		btnDate.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\date.png")); // NOI18N
		btnDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDateActionPerformed(evt);
			}
		});

		btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		btnLamMoi.setText("Làm Mới ");
		btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLamMoiActionPerformed(evt);
			}
		});

		btnTimKiemNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		btnTimKiemNhanVien.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\find.png")); // NOI18N
		btnTimKiemNhanVien.setText("Tìm Kiếm Nhân Viên");
		btnTimKiemNhanVien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimKiemNhanVienActionPerformed(evt);
			}
		});

		GroupLayout pn_rightLayout = new GroupLayout(pn_right);
		pn_right.setLayout(pn_rightLayout);
		pn_rightLayout.setHorizontalGroup(
				pn_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_rightLayout.createSequentialGroup()
						.addGap(16, 16, 16)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lblSoDienThoai, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_tenNV, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuanLyNhanVien, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaNhanVien, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(txtMaNhanVien)
								.addComponent(txtSoDienThoai)
								.addComponent(txtDiaChi)
								.addComponent(txtEmail)
								.addGroup(pn_rightLayout.createSequentialGroup()
										.addComponent(cmbGioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING, pn_rightLayout.createSequentialGroup()
										.addComponent(txtNgaySinh)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnDate))
								.addComponent(txtTenNhanVien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(22, 22, 22))
				.addGroup(pn_rightLayout.createSequentialGroup()
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_rightLayout.createSequentialGroup()
										.addGap(129, 129, 129)
										.addComponent(btnLamMoi))
								.addGroup(pn_rightLayout.createSequentialGroup()
										.addGap(39, 39, 39)
										.addComponent(btnTimKiemNhanVien, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(37, Short.MAX_VALUE))
				);
		pn_rightLayout.setVerticalGroup(
				pn_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_rightLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblQuanLyNhanVien, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblMaNhanVien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_tenNV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblSoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbGioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(btnDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(pn_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGap(69, 69, 69)
						.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnTimKiemNhanVien, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(pn_left, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pn_right, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
								.addComponent(pn_top, GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pn_top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(pn_left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pn_right, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(21, 21, 21))
				);
		napDuLieuTuCSDL(nhanVien_dao.getAllNhanVien());
		btnTimKiemNhanVien.addActionListener(this);
		tblDanhSachNhanVien.addMouseListener(this);
		btnLamMoi.addActionListener(this);
	}// </editor-fold>//GEN-END:initComponents


	public void napDuLieuTuCSDL(ArrayList<NhanVien> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblDanhSachNhanVien.getModel();
		dm.getDataVector().removeAllElements();
		for (NhanVien nv : ds) {
			model.addRow(new Object[] { nv.getMaNV(), nv.getTenNV(), nv.getsDT(),nv.getDiaChi(), nv.isGioiTinh() ? "Nam" : "Nữ",
					nv.getEmail(), new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgaySinh()) });
		}
	}

	private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtMaNhanVienActionPerformed

	private void txtTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNhanVienActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtTenNhanVienActionPerformed

	private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtSoDienThoaiActionPerformed

	private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtDiaChiActionPerformed

	private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtEmailActionPerformed

	private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtNgaySinhActionPerformed

	private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btnDateActionPerformed

	private void btnTimKiemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhanVienActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btnTimKiemNhanVienActionPerformed
	private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhanVienActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btnTimKiemNhanVienActionPerformed

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTimKiemNhanVien)) {
			String ma = txtMaNhanVien.getText().trim();
			String ten = txtTenNhanVien.getText().trim();
			String sdt = txtSoDienThoai.getText().trim();

			// Thực hiện tìm kiếm theo tiêu chí và hiển thị kết quả
			ArrayList<NhanVien> ketQuaTimKiem = nhanVien_dao.timTheoTieuChi(ma, ten, sdt);
			hienThiKetQuaTimKiem(ketQuaTimKiem);
		}
		if (o.equals(btnLamMoi)) {
			xoaTrang();
			napDuLieuTuCSDL(nhanVien_dao.getAllNhanVien());
		}
	}
	private void hienThiKetQuaTimKiem(ArrayList<NhanVien> ketQua) {
		DefaultTableModel dm = (DefaultTableModel) tblDanhSachNhanVien.getModel();
		dm.getDataVector().removeAllElements();

		if (!ketQua.isEmpty()) {
			for (NhanVien nv : ketQua) {
				dm.addRow(new Object[] {
						nv.getMaNV(), nv.getTenNV(), nv.getsDT(), nv.getDiaChi(),
						nv.isGioiTinh() ? "Nam" : "Nữ", nv.getEmail(),
								new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgaySinh())
				});
			}
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhân Viên!");
		}

		xoaTrang();
	}

	private void xoaTrang() {
		// TODO Auto-generated method stub
		txtMaNhanVien.setText("");
		txtTenNhanVien.setText("");
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtNgaySinh.setText("");
		txtMaNhanVien.requestFocus();
	}

	public void timTheoMaNV() {
		String ma = txtMaNhanVien.getText().trim();
		NhanVien nv = nhanVien_dao.getTheoMaNV(ma);
		if (nv != null) {
			DefaultTableModel dm = (DefaultTableModel) tblDanhSachNhanVien.getModel();
			dm.getDataVector().removeAllElements();
			model.addRow(new Object[] { nv.getMaNV(), nv.getTenNV(), nv.getsDT(),nv.getDiaChi(), nv.isGioiTinh() ? "Nam" : "Nữ",
					nv.getEmail(), new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgaySinh()) });
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhân Viên có mã là "+ ma+"!");
		}
		xoaTrang();
	}
	public void timTheoTenNV() {
		String ten = txtTenNhanVien.getText().trim();
		NhanVien nv = nhanVien_dao.getTheoTenNV(ten);
		if (nv != null) {
			DefaultTableModel dm = (DefaultTableModel) tblDanhSachNhanVien.getModel();
			dm.getDataVector().removeAllElements();
			model.addRow(new Object[] { nv.getMaNV(), nv.getTenNV(), nv.getsDT(),nv.getDiaChi(), nv.isGioiTinh() ? "Nam" : "Nữ",
					nv.getEmail(), new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgaySinh()) });
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhân Viên có mã là "+ ten +"!");
		}
		xoaTrang();
	}
	public void timTheoSDT() {
		String sdt = txtSoDienThoai.getText().trim();
		NhanVien nv = nhanVien_dao.getTheoSDT(sdt);
		if (nv != null) {
			DefaultTableModel dm = (DefaultTableModel) tblDanhSachNhanVien.getModel();
			dm.getDataVector().removeAllElements();
			model.addRow(new Object[] { nv.getMaNV(), nv.getTenNV(), nv.getsDT(),nv.getDiaChi(), nv.isGioiTinh() ? "Nam" : "Nữ",
					nv.getEmail(), new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgaySinh()) });
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhân Viên có mã là "+ sdt +"!");
		}
		xoaTrang();
	}
	private void fillForm(int r) {
		// TODO Auto-generated method stub
		//			txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setText(tblDanhSachNhanVien.getValueAt(r, 0).toString());
		txtTenNhanVien.setText(tblDanhSachNhanVien.getValueAt(r, 1).toString());
		txtSoDienThoai.setText(tblDanhSachNhanVien.getValueAt(r, 2).toString());
		txtDiaChi.setText(tblDanhSachNhanVien.getValueAt(r, 3).toString());
		String gioiTinh = tblDanhSachNhanVien.getValueAt(r, 4).toString();
		if(gioiTinh.equals("Nam")) {
			cmbGioiTinh.setSelectedItem("Nam");
		}else {
			cmbGioiTinh.setSelectedItem("Nữ");
		}
		txtEmail.setText(tblDanhSachNhanVien.getValueAt(r, 5).toString());
		txtNgaySinh.setText(tblDanhSachNhanVien.getValueAt(r, 6).toString());
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int r = tblDanhSachNhanVien.getSelectedRow();
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




	// Variables declaration - do not modify//GEN-BEGIN:variables

	// End of variables declaration//GEN-END:variables
}

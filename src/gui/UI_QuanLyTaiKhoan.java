package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import dao.DAO_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;

public class UI_QuanLyTaiKhoan extends JPanel implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSua;
	private JButton btnThem;
	private JButton btnTimKiem;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JComboBox<String> cmbMaNhanVien;
	private JComboBox<String> cmbQuyen;
	private JLabel lblTaiKhoanNhanVien;
	private JLabel lblDanhSachNhanVien;
	private JLabel lblMaNhanVien;
	private JLabel lblMatkhau;
	private JLabel lblQuanLyNhanVien;
	private JLabel lblQuyen;
	private JPanel pnlLeft;
	private JPanel pnlRight;
	private JPanel pnlTop;
	private JScrollPane scr_DSNV;
	private JTable tblDanhSachNhanVien;
	private JTextField txtTimKiem;
	private JTextField txtMatKhau;
	private DefaultTableModel model;

	private DAO_NhanVien nhanVien_dao = new DAO_NhanVien();
	private DAO_TaiKhoan taiKhoan_dao = new DAO_TaiKhoan();
	public UI_QuanLyTaiKhoan() {
		initComponents();
	}

	private void initComponents() {
		pnlTop = new JPanel();
		lblTaiKhoanNhanVien = new JLabel();
		pnlLeft = new JPanel();
		scr_DSNV = new JScrollPane();
		tblDanhSachNhanVien = new JTable();
		lblDanhSachNhanVien = new JLabel();
		pnlRight = new JPanel();
		txtMatKhau = new JTextField();
		txtTimKiem = new JTextField();
		lblQuyen = new JLabel();
		lblMatkhau = new JLabel();
		lblMaNhanVien = new JLabel();
		lblQuanLyNhanVien = new JLabel();
		cmbQuyen = new JComboBox<>();
		btnThem = new JButton();
		btnXoa = new JButton();
		btnSua = new JButton();
		btnXoaTrang = new JButton();
		cmbMaNhanVien = new JComboBox<>();
		btnTimKiem = new JButton();

		pnlTop.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblTaiKhoanNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lblTaiKhoanNhanVien.setText("QUẢN LÝ TÀI KHOẢN");

		GroupLayout pnlTopLayout = new GroupLayout(pnlTop);
		pnlTop.setLayout(pnlTopLayout);
		pnlTopLayout.setHorizontalGroup(
				pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
						.addContainerGap(541, Short.MAX_VALUE)
						.addComponent(lblTaiKhoanNhanVien, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
						.addGap(518, 518, 518))
				);
		pnlTopLayout.setVerticalGroup(
				pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlTopLayout.createSequentialGroup()
						.addGap(14, 14, 14)
						.addComponent(lblTaiKhoanNhanVien, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(13, Short.MAX_VALUE))
				);

		pnlLeft.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		model = new DefaultTableModel();
		tblDanhSachNhanVien = new JTable(model);
		tblDanhSachNhanVien.setRowHeight(25);     
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Mật Khẩu");
		model.addColumn("Phân Quyền");

		JScrollPane sp = new JScrollPane(tblDanhSachNhanVien, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(1000, 400));
		pnlLeft.add(sp);
		scr_DSNV.setViewportView(tblDanhSachNhanVien);

		lblDanhSachNhanVien.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lblDanhSachNhanVien.setForeground(new java.awt.Color(0, 102, 255));
		lblDanhSachNhanVien.setText("Danh Sách Nhân Viên");

		GroupLayout pnlLeftLayout = new GroupLayout(pnlLeft);
		pnlLeft.setLayout(pnlLeftLayout);
		pnlLeftLayout.setHorizontalGroup(
				pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlLeftLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scr_DSNV)
								.addGroup(pnlLeftLayout.createSequentialGroup()
										.addComponent(lblDanhSachNhanVien)
										.addGap(0, 811, Short.MAX_VALUE)))
						.addContainerGap())
				);
		pnlLeftLayout.setVerticalGroup(
				pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlLeftLayout.createSequentialGroup()
						.addComponent(lblDanhSachNhanVien, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scr_DSNV)
						.addGap(15, 15, 15))
				);

		pnlRight.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		txtMatKhau.setMinimumSize(new java.awt.Dimension(64, 25));
		txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMatKhauActionPerformed(evt);
			}
		});

		txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTimKiemActionPerformed(evt);
			}
		});

		lblQuyen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblQuyen.setText("Quyền:");

		lblMatkhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblMatkhau.setText("Mật Khẩu:");

		lblMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblMaNhanVien.setText("Mã Nhân Viên:");

		lblQuanLyNhanVien.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lblQuanLyNhanVien.setForeground(new java.awt.Color(255, 0, 51));
		lblQuanLyNhanVien.setText("Quản Lý Tài Khoản");

		cmbQuyen.setModel(new DefaultComboBoxModel<>(new String[] { "NhanVienQuanLy", "NhanVienBanHang" }));
		cmbQuyen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbQuyenActionPerformed(evt);
			}
		});

		btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnThem.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\add.png")); // NOI18N
		btnThem.setText("Thêm");
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnXoa.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\delete.png")); // NOI18N
		btnXoa.setText("Xóa");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});

		btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnSua.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\fix.png")); // NOI18N
		btnSua.setText("Sửa");
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaActionPerformed(evt);
			}
		});

		btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnXoaTrang.setText("Xóa Trắng");
		btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaTrangActionPerformed(evt);
			}
		});

		cmbMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbMaNhanVienActionPerformed(evt);
			}
		});

		btnTimKiem.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\find.png")); // NOI18N
		btnTimKiem.setText("Tìm Theo Mã Nhân Viên");
		btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimKiemActionPerformed(evt);
			}
		});

		GroupLayout pnlRightLayout = new GroupLayout(pnlRight);
		pnlRight.setLayout(pnlRightLayout);
		pnlRightLayout.setHorizontalGroup(
				pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlRightLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnTimKiem)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(pnlRightLayout.createSequentialGroup()
						.addGap(15, 15, 15)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pnlRightLayout.createSequentialGroup()
										.addComponent(lblQuanLyNhanVien, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(pnlRightLayout.createSequentialGroup()
										.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lblMatkhau, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMaNhanVien, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblQuyen, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnThem, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnSua, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
										.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(pnlRightLayout.createSequentialGroup()
														.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(pnlRightLayout.createSequentialGroup()
																		.addGap(18, 18, 18)
																		.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																				.addComponent(txtMatKhau, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
																				.addComponent(cmbQuyen, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																.addGroup(GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
																		.addGap(19, 19, 19)
																		.addComponent(cmbMaNhanVien, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
														.addGap(0, 31, Short.MAX_VALUE))
												.addGroup(GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																.addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
																.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
														.addGap(45, 45, 45))))))
				);
		pnlRightLayout.setVerticalGroup(
				pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlRightLayout.createSequentialGroup()
						.addComponent(lblQuanLyNhanVien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(32, 32, 32)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblMaNhanVien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblMatkhau, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lblQuyen, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbQuyen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(113, 113, 113)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addGap(37, 37, 37)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGap(78, 78, 78)
						.addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(80, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pnlTop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(pnlLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pnlRight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pnlTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pnlLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				);
		//        btnReset.addActionListener(this);
		napComboBox(nhanVien_dao.getAllNhanVien());
		napDuLieuTuCSDL(taiKhoan_dao.getAllTaiKhoan());
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		tblDanhSachNhanVien.addMouseListener(this);

	}// </editor-fold>//GEN-END:initComponents
	public void napComboBox(ArrayList<NhanVien> ds) {
		int n = ds.size();
		String items[] = new String[n];
		int i = 0;
		for (NhanVien nv : ds) {
			items[i] = nv.getMaNV();
			i++;
		}
		cmbMaNhanVien.setModel(new DefaultComboBoxModel<String>(items));
	}
	public void napDuLieuTuCSDL(ArrayList<TaiKhoan> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblDanhSachNhanVien.getModel();
		dm.getDataVector().removeAllElements();
		for (TaiKhoan tk : ds) {
			model.addRow(new Object[] { tk.getMaDangNhap(), tk.getMatKhau(), tk.getPhanQuyen() });
		}
	}

	private void cmbMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenNVActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txt_tenNVActionPerformed

	private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaySinhActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txt_ngaySinhActionPerformed

	private void cmbQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_gioiTinhActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_cmb_gioiTinhActionPerformed

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jButton2ActionPerformed

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jButton3ActionPerformed

	private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_gioiTinh1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_cmb_gioiTinh1ActionPerformed

	private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jButton5ActionPerformed

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btnThemActionPerformed

	private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btnXoaTrangActionPerformed
	private void deleteRowSelected() {
		String listMaTK = "";
		String maTK = "";

		if (tblDanhSachNhanVien.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa");
		} else {

			//			lay ra danh sach xoa tren GUI
			int[] listIndex = tblDanhSachNhanVien.getSelectedRows();
			listMaTK += tblDanhSachNhanVien.getValueAt(listIndex[0], 0);
			for (int i = 1; i < tblDanhSachNhanVien.getSelectedRowCount(); i++) {
				listMaTK += ", " + tblDanhSachNhanVien.getValueAt(listIndex[i], 0);
			}

			//			Hien thi thong tin xoa
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tài khoản " + listMaTK + " ?",
					"Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					while (tblDanhSachNhanVien.getSelectedRowCount() > 0) {
						maTK = (String) tblDanhSachNhanVien.getValueAt(tblDanhSachNhanVien.getSelectedRow(), 0);
						if (!taiKhoan_dao.xoa(maTK)) {
							JOptionPane.showMessageDialog(null, "Xóa thất bại, đã xảy ra lỗi");
							tblDanhSachNhanVien.clearSelection();
						} else {
							model.removeRow(tblDanhSachNhanVien.getSelectedRow());
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		}
	}

	public void fillForm(int r) {
		cmbMaNhanVien.setSelectedItem(tblDanhSachNhanVien.getValueAt(r, 0));
		txtMatKhau.setText(tblDanhSachNhanVien.getValueAt(r, 1).toString());
		cmbQuyen.setSelectedItem(tblDanhSachNhanVien.getValueAt(r, 2));
	}


	public TaiKhoan revertTaiKhoanFromFields() {
		String maDangNhap = cmbMaNhanVien.getSelectedItem().toString();
		String matKhau = txtMatKhau.getText().trim();
		String phanQuyen = cmbQuyen.getSelectedItem().toString();
		TaiKhoan tk = new TaiKhoan(maDangNhap, matKhau, phanQuyen);
		return tk;

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {
			txtMatKhau.setText("");
		}
		if (o.equals(btnThem)) {
			//			if (validDate()) {
			TaiKhoan tk = revertTaiKhoanFromFields();
			if (!taiKhoan_dao.them(tk)) {
				JOptionPane.showMessageDialog(this, "Trùng mã");
			} else {
				napDuLieuTuCSDL(taiKhoan_dao.getAllTaiKhoan());
			}
		}
		//		}
		if (o.equals(btnSua)) {
			int r = tblDanhSachNhanVien.getSelectedRow();
			if (r == -1) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa");
			} else {
				//				if (validDate()) {
				TaiKhoan tkMoi = revertTaiKhoanFromFields();
				if (!taiKhoan_dao.sua(tkMoi)) {
					JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
					tblDanhSachNhanVien.clearSelection();
				} else {
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					napDuLieuTuCSDL(taiKhoan_dao.getAllTaiKhoan());
					tblDanhSachNhanVien.clearSelection();
				}
			}
		}
		//		}
		if (o.equals(btnTimKiem)) {
			String ma = txtTimKiem.getText().trim();
			if (ma.equals("")) {
				napDuLieuTuCSDL(taiKhoan_dao.getAllTaiKhoan());
			} else {
				TaiKhoan tk = taiKhoan_dao.getTheoMaTK(ma);
				if (tk != null) {
					DefaultTableModel dm = (DefaultTableModel) tblDanhSachNhanVien.getModel();
					dm.getDataVector().removeAllElements();
					model.addRow(new Object[] { tk.getMaDangNhap(), tk.getMatKhau(), tk.getPhanQuyen() });
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy!");
					napDuLieuTuCSDL(taiKhoan_dao.getAllTaiKhoan());
				}
			}
		}
		if(o.equals(btnXoa)) {
			deleteRowSelected();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		fillForm(tblDanhSachNhanVien.getSelectedRow());

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
}

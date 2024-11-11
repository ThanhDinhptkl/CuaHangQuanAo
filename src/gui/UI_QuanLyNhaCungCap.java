package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import dao.DAO_NhaCungCap;
import entity.NhaCungCap;

public class UI_QuanLyNhaCungCap extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JButton btn_xoaTrang;
	private JButton btn_sapXep;
	private JButton btn_sua;
	private JButton btn_them;
	private JButton btn_xoa;
	private JScrollPane scr_DSNCC;
	private JLabel lb_danhSachNhaCungCap;
	private JLabel lb_diaChi;
	private JLabel lb_email;
	private JLabel lb_maNhaCungCap1;
	private JLabel lb_qLNCC;
	private JLabel lb_quanLyNhaCungCap;
	private JLabel lb_sdt;
	private JLabel lb_tenNhaCungCap;
	private JPanel pn_Form;
	private JPanel pn_Left;
	private JPanel pn_Right;
	private JPanel pn_Top;
	private JTable table_danhSachNhaCungCap;
	private JTextField txt_diaChi;
	private JTextField txt_email;
	private JTextField txt_maNhaCungCap;
	private JTextField txt_sdt;
	private JTextField txt_tenNhaCungCap;
	private DefaultTableModel model;

	private DAO_NhaCungCap dao_NhaCungCap = new DAO_NhaCungCap();
	public UI_QuanLyNhaCungCap() {
		initComponents();
	}

	private void initComponents() {

		pn_Form = new JPanel();
		pn_Top = new JPanel();
		lb_qLNCC = new JLabel();
		pn_Left = new JPanel();
		lb_danhSachNhaCungCap = new JLabel();
		scr_DSNCC = new JScrollPane();
		table_danhSachNhaCungCap = new JTable();
		pn_Right = new JPanel();
		lb_quanLyNhaCungCap = new JLabel();
		lb_sdt = new JLabel();
		lb_maNhaCungCap1 = new JLabel();
		lb_tenNhaCungCap = new JLabel();
		lb_diaChi = new JLabel();
		txt_maNhaCungCap = new JTextField();
		txt_tenNhaCungCap = new JTextField();
		txt_sdt = new JTextField();
		txt_diaChi = new JTextField();
		btn_them = new JButton();
		btn_xoaTrang = new JButton();
		btn_sua = new JButton();
		btn_sapXep = new JButton();
		btn_xoa = new JButton();
		lb_email = new JLabel();
		txt_email = new JTextField();

		setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_Form.setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_Top.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_Top.setPreferredSize(new java.awt.Dimension(808, 72));

		lb_qLNCC.setBackground(new java.awt.Color(204, 255, 204));
		lb_qLNCC.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lb_qLNCC.setText(" QUẢN LÝ NHÀ CUNG CẤP");
		lb_qLNCC.setPreferredSize(new java.awt.Dimension(248, 32));

		GroupLayout pn_TopLayout = new GroupLayout(pn_Top);
		pn_Top.setLayout(pn_TopLayout);
		pn_TopLayout.setHorizontalGroup(
				pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_TopLayout.createSequentialGroup()
						.addGap(438, 438, 438)
						.addComponent(lb_qLNCC, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		pn_TopLayout.setVerticalGroup(
				pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_TopLayout.createSequentialGroup()
						.addGap(19, 19, 19)
						.addComponent(lb_qLNCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(13, Short.MAX_VALUE))
				);

		pn_Left.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_Left.setPreferredSize(new java.awt.Dimension(884, 656));

		lb_danhSachNhaCungCap.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lb_danhSachNhaCungCap.setForeground(new java.awt.Color(51, 0, 204));
		lb_danhSachNhaCungCap.setText("Danh Sách Nhà Cung Cấp");

		model = new DefaultTableModel();
		table_danhSachNhaCungCap = new JTable(model);
		table_danhSachNhaCungCap.setRowHeight(25);     
		model.addColumn("Mã Nhà Cung Cấp");
		model.addColumn("Tên Nhà Cung Cấp");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Địa Chỉ");
		model.addColumn("Email");
		JScrollPane sp = new JScrollPane(table_danhSachNhaCungCap, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(1000, 400));
		pn_Left.add(sp);
		scr_DSNCC.setViewportView(table_danhSachNhaCungCap);

		GroupLayout pn_LeftLayout = new GroupLayout(pn_Left);
		pn_Left.setLayout(pn_LeftLayout);
		pn_LeftLayout.setHorizontalGroup(
				pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scr_DSNCC, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
								.addGroup(pn_LeftLayout.createSequentialGroup()
										.addComponent(lb_danhSachNhaCungCap)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				);
		pn_LeftLayout.setVerticalGroup(
				pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_danhSachNhaCungCap)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scr_DSNCC)
						.addContainerGap())
				);

		pn_Right.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_Right.setPreferredSize(new java.awt.Dimension(400, 734));

		lb_quanLyNhaCungCap.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lb_quanLyNhaCungCap.setForeground(new java.awt.Color(255, 0, 0));
		lb_quanLyNhaCungCap.setText("Quản Lý Nhà Cung Cấp");

		lb_sdt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_sdt.setText("Số Điện Thoại:");

		lb_maNhaCungCap1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_maNhaCungCap1.setText("Mã Nhà Cung Cấp:");

		lb_tenNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_tenNhaCungCap.setText("Tên Cung Cấp:");

		lb_diaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_diaChi.setText("Địa Chỉ:");

		txt_maNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_maNhaCungCapActionPerformed(evt);
			}
		});

		txt_diaChi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_diaChiActionPerformed(evt);
			}
		});

		btn_them.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btn_them.setForeground(new java.awt.Color(102, 102, 0));
		btn_them.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\add.png")); // NOI18N
		btn_them.setText("Thêm");

		btn_xoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btn_xoaTrang.setForeground(new java.awt.Color(102, 102, 0));
		btn_xoaTrang.setText("Xóa Trắng");
		btn_xoaTrang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_xoaTrangActionPerformed(evt);
			}
		});

		btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btn_sua.setForeground(new java.awt.Color(102, 102, 0));
		btn_sua.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\support.png")); // NOI18N
		btn_sua.setText("Sửa");

		btn_sapXep.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btn_sapXep.setForeground(new java.awt.Color(102, 102, 0));
		btn_sapXep.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\sort.png")); // NOI18N
		btn_sapXep.setText("Sắp Xếp Theo Tên");

		btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btn_xoa.setForeground(new java.awt.Color(102, 102, 0));
		btn_xoa.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\delete.png")); // NOI18N
		btn_xoa.setText("Xóa");
		btn_xoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_xoaActionPerformed(evt);
			}
		});

		lb_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_email.setText("Email:");

		txt_email.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_emailActionPerformed(evt);
			}
		});

		GroupLayout pn_RightLayout = new GroupLayout(pn_Right);
		pn_Right.setLayout(pn_RightLayout);
		pn_RightLayout.setHorizontalGroup(
				pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(lb_quanLyNhaCungCap))
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGap(18, 18, 18)
										.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(pn_RightLayout.createSequentialGroup()
														.addGap(51, 51, 51)
														.addComponent(btn_sua, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addGap(50, 50, 50)
														.addComponent(btn_xoa, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
												.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
														.addGroup(GroupLayout.Alignment.LEADING, pn_RightLayout.createSequentialGroup()
																.addComponent(lb_diaChi)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(txt_diaChi, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
														.addGroup(GroupLayout.Alignment.LEADING, pn_RightLayout.createSequentialGroup()
																.addComponent(lb_sdt)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
														.addGroup(GroupLayout.Alignment.LEADING, pn_RightLayout.createSequentialGroup()
																.addComponent(lb_tenNhaCungCap)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(txt_tenNhaCungCap, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
														.addGroup(GroupLayout.Alignment.LEADING, pn_RightLayout.createSequentialGroup()
																.addGap(167, 167, 167)
																.addComponent(txt_maNhaCungCap, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
												.addGroup(pn_RightLayout.createSequentialGroup()
														.addComponent(lb_email)
														.addGap(118, 118, 118)
														.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(btn_them, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_xoaTrang, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addGap(106, 106, 106)
						.addComponent(btn_sapXep)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(pn_RightLayout.createSequentialGroup()
								.addGap(16, 16, 16)
								.addComponent(lb_maNhaCungCap1)
								.addContainerGap(228, Short.MAX_VALUE)))
				);
		pn_RightLayout.setVerticalGroup(
				pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_quanLyNhaCungCap)
						.addGap(24, 24, 24)
						.addComponent(txt_maNhaCungCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_tenNhaCungCap)
								.addComponent(txt_tenNhaCungCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_sdt)
								.addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_diaChi)
								.addComponent(txt_diaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_email)
								.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(137, 137, 137)
						.addComponent(btn_them)
						.addGap(18, 18, 18)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btn_sua)
								.addComponent(btn_xoa))
						.addGap(18, 18, 18)
						.addComponent(btn_xoaTrang)
						.addGap(18, 18, 18)
						.addComponent(btn_sapXep)
						.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(pn_RightLayout.createSequentialGroup()
								.addGap(44, 44, 44)
								.addComponent(lb_maNhaCungCap1)
								.addContainerGap(585, Short.MAX_VALUE)))
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
										.addComponent(pn_Right, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		pn_FormLayout.setVerticalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pn_Top, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pn_Right, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
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
		napDuLieuTuCSDL(dao_NhaCungCap.getAllNCC());
		btn_them.addActionListener(this);
		btn_xoa.addActionListener(this);
		btn_sua.addActionListener(this);
		btn_xoaTrang.addActionListener(this);
		btn_sapXep.addActionListener(this);
		table_danhSachNhaCungCap.addMouseListener(this);
	}// </editor-fold>//GEN-END:initComponents

	public void napDuLieuTuCSDL(ArrayList<NhaCungCap> ds) {
		DefaultTableModel dm = (DefaultTableModel) table_danhSachNhaCungCap.getModel();
		dm.getDataVector().removeAllElements();
		for (NhaCungCap ncc : ds) {
			model.addRow(new Object[] { ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSoDienThoai(), ncc.getDiaChi(), ncc.getEmail() });
		}
	}
	private void txt_diaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diaChiActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txt_diaChiActionPerformed

	private void btn_xoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaTrangActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btn_xoaTrangActionPerformed

	private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btn_xoaActionPerformed

	private void txt_maNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maNhaCungCapActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txt_maNhaCungCapActionPerformed
	private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maNhaCungCapActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txt_maNhaCungCapActionPerformed

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if (o.equals(btn_them)) {
			if (!valiData()) {
				return;
			}
			NhaCungCap ncc = revertNCCFromFields();
			if (!dao_NhaCungCap.themNCC(ncc)) {
				JOptionPane.showMessageDialog(this, "Trùng mã");
			} else {
				napDuLieuTuCSDL(dao_NhaCungCap.getAllNCC());

				table_danhSachNhaCungCap.clearSelection();


			}
		}
		if (o.equals(btn_xoaTrang)) {
			xoaTrang();
		}
		if(o.equals(btn_sua)) {
			sua();
			napDuLieuTuCSDL(dao_NhaCungCap.getAllNCC());
		}
		if(o.equals(btn_xoa)) {
			deleteRowSelected();
			napDuLieuTuCSDL(dao_NhaCungCap.getAllNCC());
		}
	}

	private void deleteRowSelected() {
		// TODO Auto-generated method stub
		String listMaNCC = "";
		String maNCC = "";

		if (table_danhSachNhaCungCap.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa");
		} else {

			//			lay ra danh sach xoa tren GUI
			int[] listIndex = table_danhSachNhaCungCap.getSelectedRows();
			listMaNCC += table_danhSachNhaCungCap.getValueAt(listIndex[0], 0);
			for (int i = 1; i < table_danhSachNhaCungCap.getSelectedRowCount(); i++) {
				listMaNCC += ", " + table_danhSachNhaCungCap.getValueAt(listIndex[i], 0);
			}

			//			Hien thi thong tin xoa
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên " + listMaNCC + " ?",
					"Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					while (table_danhSachNhaCungCap.getSelectedRowCount() > 0) {
						maNCC = (String) table_danhSachNhaCungCap.getValueAt(table_danhSachNhaCungCap.getSelectedRow(), 0);
						if (!dao_NhaCungCap.xoa(maNCC)) {
							JOptionPane.showMessageDialog(null, "Xóa thất bại, đã xảy ra lỗi");
							table_danhSachNhaCungCap.clearSelection();
						} else {
							model.removeRow(table_danhSachNhaCungCap.getSelectedRow());
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		}
	}
	private void sua() {
		// TODO Auto-generated method stub
		int r = table_danhSachNhaCungCap.getSelectedRow();
		if (!valiData()) {
			return;
		}
		if(r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa");
		}else {
			NhaCungCap ncc = FixNCCFromFields();
			if(!dao_NhaCungCap.suaNCC(ncc)) {
				JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
				table_danhSachNhaCungCap.clearSelection();
			}else {
				JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công !");
			}
			//			}
		}
	}
	private boolean valiData() {
		String maNcc = txt_maNhaCungCap.getText().trim();
		String sdt = txt_sdt.getText().trim();
		String email = txt_email.getText().trim();
		if (txt_email.getText().equals("") || txt_sdt.getText().equals("") || txt_tenNhaCungCap.getText().equals("")
				) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		//        if (maKh.length() != 8 || !maKh.matches("[0-9]+")) {
		//            JOptionPane.showMessageDialog(txt_maKhachHang, "Mã khách hàng phải là 8 ký tự số.");
		//            txt_maKhachHang.requestFocus();
		//            return false;
		//        }
		if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}"))) {
			JOptionPane.showMessageDialog(txt_sdt, "Số điện thoại sai định dạng");
			txt_sdt.requestFocus();
			return false;
		}

		if (!(email.length() > 0 && email.matches("[a-zA-Z0-9._%-]+(@){1}[a-zA-Z]+(.){1}[a-zA-Z]{2,4}"))) {
			JOptionPane.showMessageDialog(this, "Email sai định dạng");
			txt_email.requestFocus();
			return false;
		}
		return true;
	}
	private void xoaTrang() {
		// TODO Auto-generated method stub
		txt_maNhaCungCap.setText("");
		txt_tenNhaCungCap.setText("");
		txt_sdt.setText("");
		txt_diaChi.setText("");
		txt_email.setText("");
	}
	private NhaCungCap revertNCCFromFields() {
		// TODO Auto-generated method stub
		NhaCungCap ncc= new NhaCungCap();
		String maNCC = ncc.auto_ID();
		txt_maNhaCungCap.setText(maNCC);
		String tenNCC = txt_tenNhaCungCap.getText().trim();
		String soDienThoai = txt_sdt.getText().trim();
		String diaChi = txt_diaChi.getText().trim();
		String email = txt_email.getText().trim();
		ncc = new NhaCungCap(maNCC, tenNCC, soDienThoai, diaChi,email);
		return ncc;
	}
	private NhaCungCap FixNCCFromFields() {
		// TODO Auto-generated method stub
		NhaCungCap ncc= new NhaCungCap();
		String maNCC = txt_maNhaCungCap.getText().trim();
		String tenNCC = txt_tenNhaCungCap.getText().trim();
		String soDienThoai = txt_sdt.getText().trim();
		String diaChi = txt_diaChi.getText().trim();
		String email = txt_email.getText().trim();
		ncc = new NhaCungCap(maNCC, tenNCC, soDienThoai, diaChi,email);
		return ncc;
	}
	private void fillForm(int r) {
		// TODO Auto-generated method stub
		txt_maNhaCungCap.setEditable(false);
		txt_maNhaCungCap.setText(table_danhSachNhaCungCap.getValueAt(r, 0).toString());
		txt_tenNhaCungCap.setText(table_danhSachNhaCungCap.getValueAt(r, 1).toString());
		txt_sdt.setText(table_danhSachNhaCungCap.getValueAt(r, 2).toString());
		txt_diaChi.setText(table_danhSachNhaCungCap.getValueAt(r, 3).toString());
		txt_email.setText(table_danhSachNhaCungCap.getValueAt(r, 4).toString());
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int r = table_danhSachNhaCungCap.getSelectedRow();
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

}

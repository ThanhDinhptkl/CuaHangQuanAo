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
import dao.DAO_KhachHang;
import entity.KhachHang;

public class UI_QuanLyKhachHang extends JPanel implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	private JButton btn_sua;
	private JButton btn_them;
	private JButton btn_xoa;
	private JButton btn_xoaTrang;
	private JComboBox<String> cb_gioiTinh;
	private JScrollPane jScrollPane1;
	private JLabel lb_danhSachKhachHang;
	private JLabel lb_email;
	private JLabel lb_gioiTinh;
	private JLabel lb_maKhachHang;
	private JLabel lb_qLKH;
	private JLabel lb_quanLyKhachHang;
	private JLabel lb_soDienThoai;
	private JLabel lb_tenKhachHang;
	private JPanel pn_Form;
	private JPanel pn_Left;
	private JPanel pn_Right;
	private JPanel pn_Top;
	private JTable table_danhSachKhachHang;
	private JTextField txt_email;
	private JTextField txt_maKhachHang;
	private JTextField txt_soDienThoai;
	private JTextField txt_tenKhachHang;
	private DefaultTableModel model;
	private final DAO_KhachHang dao_KhachHang = new DAO_KhachHang();

	public UI_QuanLyKhachHang() {
		initComponents();
	}


	private void initComponents() {

		pn_Form = new JPanel();
		pn_Top = new JPanel();
		lb_qLKH = new JLabel();
		pn_Right = new JPanel();
		lb_quanLyKhachHang = new JLabel();
		lb_soDienThoai = new JLabel();
		lb_maKhachHang = new JLabel();
		lb_email = new JLabel();
		lb_tenKhachHang = new JLabel();
		lb_gioiTinh = new JLabel();
		txt_maKhachHang = new JTextField();
		txt_tenKhachHang = new JTextField();
		txt_soDienThoai = new JTextField();
		txt_email = new JTextField();
		cb_gioiTinh = new JComboBox<>();
		btn_them = new JButton();
		btn_xoaTrang = new JButton();
		btn_sua = new JButton();
		btn_xoa = new JButton();
		pn_Left = new JPanel();
		lb_danhSachKhachHang = new JLabel();
		jScrollPane1 = new JScrollPane();
		table_danhSachKhachHang = new JTable();

		setPreferredSize(new java.awt.Dimension(1302, 746));

		pn_Form.setPreferredSize(new java.awt.Dimension(1302, 756));

		pn_Top.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_Top.setPreferredSize(new java.awt.Dimension(808, 72));

		lb_qLKH.setBackground(new java.awt.Color(204, 255, 204));
		lb_qLKH.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lb_qLKH.setText(" QUẢN LÝ KHÁCH HÀNG");

		GroupLayout pn_TopLayout = new GroupLayout(pn_Top);
		pn_Top.setLayout(pn_TopLayout);
		pn_TopLayout.setHorizontalGroup(
				pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_TopLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lb_qLKH)
						.addGap(460, 460, 460))
				);
		pn_TopLayout.setVerticalGroup(
				pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_TopLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_qLKH, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE))
				);

		pn_Right.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lb_quanLyKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lb_quanLyKhachHang.setForeground(new java.awt.Color(255, 0, 0));
		lb_quanLyKhachHang.setText("Quản Lý Khách Hàng");

		lb_soDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_soDienThoai.setText("Số Điện Thoại:");

		lb_maKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_maKhachHang.setText("Mã Khách Hàng:");

		lb_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_email.setText("Email:");

		lb_tenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_tenKhachHang.setText("Tên Khách Hàng:");

		lb_gioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_gioiTinh.setText("Giới Tính:");

		txt_maKhachHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_maKhachHangActionPerformed(evt);
			}
		});

		txt_email.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_emailActionPerformed(evt);
			}
		});

		cb_gioiTinh.setModel(new DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

		btn_them.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btn_them.setForeground(new java.awt.Color(102, 102, 0));
		btn_them.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\add.png")); // NOI18N
		btn_them.setText("Thêm");

		btn_xoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btn_xoaTrang.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\xoaTrang.png")); // NOI18N
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

		btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btn_xoa.setForeground(new java.awt.Color(102, 102, 0));
		btn_xoa.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\delete.png")); // NOI18N
		btn_xoa.setText("Xóa");
		btn_xoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_xoaActionPerformed(evt);
			}
		});

		GroupLayout pn_RightLayout = new GroupLayout(pn_Right);
		pn_Right.setLayout(pn_RightLayout);
		pn_RightLayout.setHorizontalGroup(
				pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
						.addGap(10, 10, 10)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
														.addComponent(lb_maKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(24, 24, 24)
														.addComponent(txt_maKhachHang, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
												.addGroup(GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
														.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(lb_soDienThoai)
																.addComponent(lb_tenKhachHang))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addComponent(txt_tenKhachHang, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
																.addComponent(txt_soDienThoai)
																.addComponent(cb_gioiTinh, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
																.addComponent(txt_email))))
										.addGap(72, 72, 72))
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lb_email)
												.addComponent(lb_gioiTinh)
												.addComponent(lb_quanLyKhachHang))
										.addGap(0, 0, Short.MAX_VALUE))))
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGap(44, 44, 44)
										.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(btn_them, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
												.addComponent(btn_xoaTrang, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
												.addGroup(pn_RightLayout.createSequentialGroup()
														.addGap(34, 34, 34)
														.addComponent(btn_sua)
														.addGap(70, 70, 70)
														.addComponent(btn_xoa))))
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGap(111, 111, 111)
										))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		pn_RightLayout.setVerticalGroup(
				pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_quanLyKhachHang)
						.addGap(18, 18, 18)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_maKhachHang)
								.addComponent(txt_maKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(14, 14, 14)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_tenKhachHang)
								.addComponent(txt_tenKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(11, 11, 11)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_soDienThoai)
								.addComponent(txt_soDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_gioiTinh)
								.addComponent(cb_gioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_email))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
						.addComponent(btn_them)
						.addGap(18, 18, 18)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btn_sua)
								.addComponent(btn_xoa))
						.addGap(18, 18, 18)
						.addComponent(btn_xoaTrang)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGap(194, 194, 194))
				);

		pn_Left.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_Left.setPreferredSize(new java.awt.Dimension(884, 656));

		lb_danhSachKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lb_danhSachKhachHang.setForeground(new java.awt.Color(51, 0, 204));
		lb_danhSachKhachHang.setText("Danh Sách Khách Hàng");
		lb_danhSachKhachHang.setMaximumSize(new java.awt.Dimension(179, 25));
		lb_danhSachKhachHang.setMinimumSize(new java.awt.Dimension(179, 25));
		lb_danhSachKhachHang.setPreferredSize(new java.awt.Dimension(179, 25));

		model = new DefaultTableModel();
		table_danhSachKhachHang = new JTable(model);
		table_danhSachKhachHang.setRowHeight(25);     
		model.addColumn("Mã Khách Hàng");
		model.addColumn("Tên Khách Hàng");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Giới Tính");
		model.addColumn("Email");
		JScrollPane sp = new JScrollPane(table_danhSachKhachHang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(1000, 400));
		pn_Left.add(sp);
		jScrollPane1.setViewportView(table_danhSachKhachHang);

		GroupLayout pn_LeftLayout = new GroupLayout(pn_Left);
		pn_Left.setLayout(pn_LeftLayout);
		pn_LeftLayout.setHorizontalGroup(
				pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_LeftLayout.createSequentialGroup()
										.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(pn_LeftLayout.createSequentialGroup()
										.addComponent(lb_danhSachKhachHang, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))))
				);
		pn_LeftLayout.setVerticalGroup(
				pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_danhSachKhachHang, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1)
						.addContainerGap())
				);

		GroupLayout pn_FormLayout = new GroupLayout(pn_Form);
		pn_Form.setLayout(pn_FormLayout);
		pn_FormLayout.setHorizontalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(pn_Top, GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
								.addGroup(pn_FormLayout.createSequentialGroup()
										.addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pn_Right, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		pn_FormLayout.setVerticalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pn_Top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(5, 5, 5)
						.addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
								.addComponent(pn_Right, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				);

		getAccessibleContext().setAccessibleName("1302");
		getAccessibleContext().setAccessibleDescription("746");


		napDuLieuTuCSDL(dao_KhachHang.getALLKhachHang());
		btn_them.addActionListener(this);
		btn_xoa.addActionListener(this);
		btn_sua.addActionListener(this);
		btn_xoaTrang.addActionListener(this);
		table_danhSachKhachHang.addMouseListener(this);
	}// </editor-fold>//GEN-END:initComponents
	public void napDuLieuTuCSDL(ArrayList<KhachHang> ds) {
		DefaultTableModel dm = (DefaultTableModel) table_danhSachKhachHang.getModel();
		dm.getDataVector().removeAllElements();
		for (KhachHang kh : ds) {
			model.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getsDT(), kh.isGioiTinh() ? "Nam" : "Nữ",
					kh.getEmail() });
		}
	}

	private void btn_xoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaTrangActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btn_xoaTrangActionPerformed

	private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btn_xoaActionPerformed
	private void txt_maKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
		// TODO add your handling code here:
	}
	private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
		// TODO add your handling code here:
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if (o.equals(btn_them)) {
			if (!valiData()) {
				return;
			}
			KhachHang kh = revertKhachHangFromFields();

			if (!dao_KhachHang.themKH(kh)) {
				JOptionPane.showMessageDialog(this, "Trùng mã");
			} else {
				napDuLieuTuCSDL(dao_KhachHang.getALLKhachHang());

				table_danhSachKhachHang.clearSelection();
			}

		}
		if (o.equals(btn_xoa)) {
			deleteRowSelected();
			napDuLieuTuCSDL(dao_KhachHang.getALLKhachHang());
		}
		if (o.equals(btn_xoaTrang)) {
			xoaTrang();
		}
		if(o.equals(btn_sua)) {
			sua();
			napDuLieuTuCSDL(dao_KhachHang.getALLKhachHang());
		}
	}
	public KhachHang FixKhachHangFromFields() {
		KhachHang kh = new KhachHang();
		String maKhachHang = txt_maKhachHang.getText().trim();
		String tenKH = txt_tenKhachHang.getText().trim();
		String sDT = txt_soDienThoai.getText().trim();
		String email = txt_email.getText().trim();

		// Lấy giới tính từ ComboBox
		String gioiTinhStr = cb_gioiTinh.getSelectedItem().toString();
		boolean gioiTinh = gioiTinhStr.equals("Nam"); // Sử dụng giá trị chọn trong ComboBox

		kh = new KhachHang(maKhachHang, tenKH, sDT, gioiTinh, email);

		return kh;
	}
	public KhachHang revertKhachHangFromFields() {
		KhachHang kh = new KhachHang();
		String maKhachHang = kh.auto_ID();
		txt_maKhachHang.setText(maKhachHang);
		String tenKH = txt_tenKhachHang.getText().trim();
		String sDT = txt_soDienThoai.getText().trim();
		String email = txt_email.getText().trim();

		// Lấy giới tính từ ComboBox
		String gioiTinhStr = cb_gioiTinh.getSelectedItem().toString();
		boolean gioiTinh = gioiTinhStr.equals("Nam"); // Sử dụng giá trị chọn trong ComboBox

		kh = new KhachHang(maKhachHang, tenKH, sDT, gioiTinh, email);

		return kh;
	}
	private void deleteRowSelected() {
		// TODO Auto-generated method stub
		String listMaKh = "";
		String maKh = "";

		if (table_danhSachKhachHang.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa");
		} else {

			//			lay ra danh sach xoa tren GUI
			int[] listIndex = table_danhSachKhachHang.getSelectedRows();
			listMaKh += table_danhSachKhachHang.getValueAt(listIndex[0], 0);
			for (int i = 1; i < table_danhSachKhachHang.getSelectedRowCount(); i++) {
				listMaKh += ", " + table_danhSachKhachHang.getValueAt(listIndex[i], 0);
			}

			//			Hien thi thong tin xoa
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên " + listMaKh + " ?",
					"Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					while (table_danhSachKhachHang.getSelectedRowCount() > 0) {
						maKh = (String) table_danhSachKhachHang.getValueAt(table_danhSachKhachHang.getSelectedRow(), 0);
						if (!dao_KhachHang.xoa(maKh)) {
							JOptionPane.showMessageDialog(null, "Xóa thất bại, đã xảy ra lỗi");
							table_danhSachKhachHang.clearSelection();
						} else {
							model.removeRow(table_danhSachKhachHang.getSelectedRow());
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
		int r = table_danhSachKhachHang.getSelectedRow();
		if (!valiData()) {
			return;
		}
		if(r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa");
		}else {
			KhachHang khMoi = FixKhachHangFromFields();
			if(!dao_KhachHang.suaKH(khMoi)) {
				JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
				table_danhSachKhachHang.clearSelection();
			}else {
				JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công !");
			}

		}

	}
	private boolean valiData() {
		String tenKh = txt_tenKhachHang.getText().trim();
		String sdt = txt_soDienThoai.getText().trim();
		String email = txt_email.getText().trim();
		if (txt_email.getText().equals("") || txt_soDienThoai.getText().equals("") || txt_tenKhachHang.getText().equals("")
				) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}

		if (!tenKh.matches("^[\\p{L}\\p{M} .'-]+$")) {
			JOptionPane.showMessageDialog(txt_tenKhachHang, "Tên Khách Hàng phải là các ký tự chữ cái.");
			txt_tenKhachHang.requestFocus();
			return false;
		}

		if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}"))) {
			JOptionPane.showMessageDialog(txt_soDienThoai, "Số điện thoại sai định dạng");
			txt_soDienThoai.requestFocus();
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
		txt_maKhachHang.setText("");
		txt_tenKhachHang.setText("");
		txt_soDienThoai.setText("");
		txt_email.setText("");

	}
	private void fillForm(int r) {
		// TODO Auto-generated method stub
		txt_maKhachHang.setEditable(false);
		txt_maKhachHang.setText(table_danhSachKhachHang.getValueAt(r, 0).toString());
		txt_tenKhachHang.setText(table_danhSachKhachHang.getValueAt(r, 1).toString());
		txt_soDienThoai.setText(table_danhSachKhachHang.getValueAt(r, 2).toString());
		String gioiTinh = table_danhSachKhachHang.getValueAt(r, 3).toString();
		if(gioiTinh.equals("Nam")) {
			cb_gioiTinh.setSelectedItem("Nam");
		}else {
			cb_gioiTinh.setSelectedItem("Nữ");
		}
		txt_email.setText(table_danhSachKhachHang.getValueAt(r, 4).toString());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int r = table_danhSachKhachHang.getSelectedRow();
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

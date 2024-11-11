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

import dao.DAO_KhachHang;
import entity.KhachHang;


public class UI_TimKiemKhachHang extends JPanel implements ActionListener, MouseListener {

	private JButton btn_lamMoi;
	private JButton btn_timKiemKhachHang;
	private JComboBox<String> cb_gioiTinh;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JScrollPane jScrollPane1;
	private JLabel lb_TKKH;
	private JLabel lb_danhSachKhachHang;
	private JLabel lb_email;
	private JLabel lb_gioiTinh;
	private JLabel lb_maKhachHang;
	private JLabel lb_quanLyKhachHang;
	private JLabel lb_soDienThoai;
	private JLabel lb_tenKhachHang;
	private JTable table_danhSachKhachHang;
	private JTextField txt_email;
	private JTextField txt_maKhachHang;
	private JTextField txt_soDienThoai;
	private JTextField txt_tenKhachHang;
	private DefaultTableModel model;
	private DAO_KhachHang khachHang_dao = new  DAO_KhachHang();
	public UI_TimKiemKhachHang() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		lb_TKKH = new JLabel();
		jPanel3 = new JPanel();
		lb_danhSachKhachHang = new JLabel();
		jScrollPane1 = new JScrollPane();
		table_danhSachKhachHang = new JTable();
		jPanel4 = new JPanel();
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
		btn_timKiemKhachHang = new JButton();
		btn_lamMoi = new JButton();

		setPreferredSize(new java.awt.Dimension(1302, 746));

		jPanel1.setPreferredSize(new java.awt.Dimension(1302, 746));

		jPanel2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lb_TKKH.setBackground(new java.awt.Color(204, 255, 204));
		lb_TKKH.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lb_TKKH.setText("TÌM KIẾM KHÁCH HÀNG");

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(449, 449, 449)
						.addComponent(lb_TKKH)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addContainerGap(9, Short.MAX_VALUE)
						.addComponent(lb_TKKH)
						.addContainerGap())
				);

		jPanel3.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel3.setPreferredSize(new java.awt.Dimension(884, 659));

		lb_danhSachKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lb_danhSachKhachHang.setForeground(new java.awt.Color(51, 0, 204));
		lb_danhSachKhachHang.setText("Danh Sách Khách Hàng");

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
		jPanel3.add(sp);
		jScrollPane1.setViewportView(table_danhSachKhachHang);

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(lb_danhSachKhachHang)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_danhSachKhachHang)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
						.addContainerGap())
				);

		jPanel4.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lb_quanLyKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lb_quanLyKhachHang.setForeground(new java.awt.Color(255, 0, 0));
		lb_quanLyKhachHang.setText("Quản Lý Khách Hàng");

		lb_soDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_soDienThoai.setText("Số Điện Thoại:");

		lb_maKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_maKhachHang.setText("Mã Khách Hàng: ");

		lb_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_email.setText("Email:");

		lb_tenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_tenKhachHang.setText("Tên Khách Hàng:");

		lb_gioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_gioiTinh.setText("Giới Tính:");

		cb_gioiTinh.setModel(new DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

		btn_timKiemKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
		btn_timKiemKhachHang.setForeground(new java.awt.Color(153, 102, 0));
		btn_timKiemKhachHang.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\find.png")); // NOI18N
		btn_timKiemKhachHang.setText("Tìm Kiếm Khách Hàng");
		btn_timKiemKhachHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_timKiemKhachHangActionPerformed(evt);
			}
		});

		btn_lamMoi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
		btn_lamMoi.setForeground(new java.awt.Color(153, 102, 0));
		btn_lamMoi.setText("Làm Mới");
		btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_lamMoiActionPerformed(evt);
			}
		});

		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addGap(91, 91, 91)
										.addComponent(btn_lamMoi, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addGap(41, 41, 41)
										.addComponent(btn_timKiemKhachHang, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lb_quanLyKhachHang)
												.addGroup(jPanel4Layout.createSequentialGroup()
														.addGap(6, 6, 6)
														.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addGroup(jPanel4Layout.createSequentialGroup()
																		.addComponent(lb_maKhachHang)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(txt_maKhachHang, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
																.addGroup(jPanel4Layout.createSequentialGroup()
																		.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addComponent(lb_tenKhachHang)
																				.addComponent(lb_soDienThoai)
																				.addComponent(lb_gioiTinh)
																				.addComponent(lb_email))
																		.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addComponent(txt_tenKhachHang)
																				.addComponent(txt_soDienThoai)
																				.addGroup(jPanel4Layout.createSequentialGroup()
																						.addComponent(cb_gioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																						.addGap(0, 0, Short.MAX_VALUE))
																				.addComponent(txt_email))))))))
						.addContainerGap(62, Short.MAX_VALUE))
				);
		jPanel4Layout.setVerticalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_quanLyKhachHang)
						.addGap(13, 13, 13)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txt_maKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_maKhachHang))
						.addGap(5, 5, 5)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txt_tenKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_tenKhachHang))
						.addGap(9, 9, 9)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_soDienThoai)
								.addComponent(txt_soDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_gioiTinh)
								.addComponent(cb_gioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_email))
						.addGap(139, 139, 139)
						.addComponent(btn_lamMoi, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btn_timKiemKhachHang, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
						.addContainerGap())
				);
		napDuLieuTuCSDL(khachHang_dao.getALLKhachHang());
		btn_timKiemKhachHang.addActionListener(this);
		table_danhSachKhachHang.addMouseListener(this);
		btn_lamMoi.addActionListener(this);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
	}// </editor-fold>//GEN-END:initComponents

	private void napDuLieuTuCSDL(ArrayList<KhachHang> ds) {
		DefaultTableModel dm = (DefaultTableModel) table_danhSachKhachHang.getModel();
		dm.getDataVector().removeAllElements();
		for (KhachHang kh : ds) {
			model.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getsDT(), kh.isGioiTinh() ? "Nam" : "Nữ",
					kh.getEmail() });
		}

	}

	private void btn_timKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemKhachHangActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btn_timKiemKhachHangActionPerformed

	private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btn_lamMoiActionPerformed
	private void xoaTrang() {
		// TODO Auto-generated method stub
		txt_maKhachHang.setText("");
		txt_tenKhachHang.setText("");
		txt_soDienThoai.setText("");
		txt_email.setText("");
		txt_maKhachHang.requestFocus();
	}
	public void timTheoMakh() {
		String ma = txt_maKhachHang.getText().trim();
		KhachHang kh = khachHang_dao.getTheoMaKH(ma);
		if (kh != null) {
			DefaultTableModel dm = (DefaultTableModel) table_danhSachKhachHang.getModel();
			dm.getDataVector().removeAllElements();
			model.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getsDT(), kh.isGioiTinh() ? "Nam" : "Nữ",
					kh.getEmail() });
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhân Viên có mã là "+ ma+"!");
		}
		xoaTrang();
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

	private void hienThiKetQuaTimKiem(ArrayList<KhachHang> ketQua) {
		DefaultTableModel dm = (DefaultTableModel) table_danhSachKhachHang.getModel();
		dm.getDataVector().removeAllElements();

		if (!ketQua.isEmpty()) {
			for (KhachHang nv : ketQua) {
				dm.addRow(new Object[] {
						nv.getMaKH(), nv.getTenKH(), nv.getsDT(),nv.isGioiTinh() ? "Nam" : "Nữ", nv.getEmail(),
				});
			}
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhân Viên!");
		}

		xoaTrang();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_timKiemKhachHang)) {
			String ma = txt_maKhachHang.getText().trim();
			String ten = txt_tenKhachHang.getText().trim();
			String sdt = txt_soDienThoai.getText().trim();

			// Thực hiện tìm kiếm theo tiêu chí và hiển thị kết quả
			ArrayList<KhachHang> ketQuaTimKiem = khachHang_dao.timTheoTieuChi(ma, ten, sdt);
			hienThiKetQuaTimKiem(ketQuaTimKiem);
		}
		if (o.equals(btn_lamMoi)) {
			xoaTrang();
			napDuLieuTuCSDL(khachHang_dao.getALLKhachHang());
		}

	}



	// Variables declaration - do not modify//GEN-BEGIN:variables

	// End of variables declaration//GEN-END:variables
}
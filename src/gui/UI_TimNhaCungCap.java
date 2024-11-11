package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import entity.KhachHang;
import entity.NhaCungCap;
import entity.PhieuDatHang;

public class UI_TimNhaCungCap extends JPanel implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	private JButton btn_lamMoi;
	private JButton btn_timKiemNhaCungCap1;
	private JScrollPane jScrollPane1;
	private JLabel lb_TKNCC;
	private JLabel lb_danhSachNhaCungCap;
	private JLabel lb_diaChi;
	private JLabel lb_email;
	private JLabel lb_maNhaCungCap1;
	private JLabel lb_quanLyNhaCungCap;
	private JLabel lb_sDT;
	private JLabel lb_tenNhaCungCap;
	private JPanel pn_Form;
	private JPanel pn_Left;
	private JPanel pn_Right;
	private JPanel pn_Top;
	private JTable table_danhSachNhaCungCap;
	private JTextField txt_diaChi;
	private JTextField txt_email;
	private JTextField txt_maNhaCungCap;
	private JTextField txt_sDT;
	private JTextField txt_tenNhaCungCap;

	private DefaultTableModel model;
	private DefaultTableModel model2;
	private DAO_NhaCungCap dao_NhaCungCap = new DAO_NhaCungCap();
	public UI_TimNhaCungCap() {
		initComponents();
	}

	private void initComponents() {

		pn_Form = new JPanel();
		pn_Left = new JPanel();
		lb_danhSachNhaCungCap = new JLabel();
		jScrollPane1 = new JScrollPane();
		table_danhSachNhaCungCap = new JTable();
		pn_Right = new JPanel();
		lb_quanLyNhaCungCap = new JLabel();
		lb_sDT = new JLabel();
		lb_maNhaCungCap1 = new JLabel();
		lb_tenNhaCungCap = new JLabel();
		lb_diaChi = new JLabel();
		txt_maNhaCungCap = new JTextField();
		txt_tenNhaCungCap = new JTextField();
		txt_sDT = new JTextField();
		txt_diaChi = new JTextField();
		btn_lamMoi = new JButton();
		lb_email = new JLabel();
		txt_email = new JTextField();
		btn_timKiemNhaCungCap1 = new JButton();
		pn_Top = new JPanel();
		lb_TKNCC = new JLabel();

		setPreferredSize(new java.awt.Dimension(1308, 758));

		pn_Form.setPreferredSize(new java.awt.Dimension(1308, 758));

		pn_Left.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
		jScrollPane1.setViewportView(table_danhSachNhaCungCap);

		GroupLayout pn_LeftLayout = new GroupLayout(pn_Left);
		pn_Left.setLayout(pn_LeftLayout);
		pn_LeftLayout.setHorizontalGroup(
				pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_LeftLayout.createSequentialGroup()
										.addComponent(lb_danhSachNhaCungCap)
										.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE))
						.addContainerGap())
				);
		pn_LeftLayout.setVerticalGroup(
				pn_LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_LeftLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lb_danhSachNhaCungCap)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1)
						.addContainerGap())
				);

		pn_Right.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lb_quanLyNhaCungCap.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		lb_quanLyNhaCungCap.setForeground(new java.awt.Color(255, 0, 0));
		lb_quanLyNhaCungCap.setText("Quản Lý Nhà Cung Cấp");

		lb_sDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_sDT.setText("Số Điện Thoại:");

		lb_maNhaCungCap1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_maNhaCungCap1.setText("Mã Nhà Cung Cấp:");

		lb_tenNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_tenNhaCungCap.setText("Tên Cung Cấp:");

		lb_diaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_diaChi.setText("Địa Chỉ:");

		txt_tenNhaCungCap.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				//				txt_tenNhaCungCapKeyReleased(evt);
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

		lb_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lb_email.setText("Email:");

		txt_email.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_emailActionPerformed(evt);
			}
		});

		btn_timKiemNhaCungCap1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
		btn_timKiemNhaCungCap1.setForeground(new java.awt.Color(153, 102, 0));
		btn_timKiemNhaCungCap1.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\find.png")); // NOI18N
		btn_timKiemNhaCungCap1.setText("Tìm Kiếm Nhà Cung Cấp");
		btn_timKiemNhaCungCap1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_timKiemNhaCungCap1ActionPerformed(evt);
			}
		});

		GroupLayout pn_RightLayout = new GroupLayout(pn_Right);
		pn_Right.setLayout(pn_RightLayout);
		pn_RightLayout.setHorizontalGroup(
				pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
						.addGap(0, 78, Short.MAX_VALUE)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
										.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(txt_maNhaCungCap, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
												.addComponent(txt_tenNhaCungCap)
												.addComponent(txt_sDT)
												.addComponent(txt_diaChi)
												.addComponent(txt_email))
										.addGap(36, 36, 36))
								.addGroup(GroupLayout.Alignment.TRAILING, pn_RightLayout.createSequentialGroup()
										.addComponent(btn_timKiemNhaCungCap1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
										.addGap(74, 74, 74))))
				.addGroup(pn_RightLayout.createSequentialGroup()
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(lb_quanLyNhaCungCap))
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGap(18, 18, 18)
										.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lb_tenNhaCungCap)
												.addComponent(lb_sDT)
												.addComponent(lb_diaChi)
												.addComponent(lb_email)))
								.addGroup(pn_RightLayout.createSequentialGroup()
										.addGap(104, 104, 104)
										.addComponent(btn_lamMoi, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(pn_RightLayout.createSequentialGroup()
								.addGap(16, 16, 16)
								.addComponent(lb_maNhaCungCap1)
								.addContainerGap(232, Short.MAX_VALUE)))
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
								.addComponent(lb_sDT)
								.addComponent(txt_sDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_diaChi)
								.addComponent(txt_diaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lb_email)
								.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(168, 168, 168)
						.addComponent(btn_lamMoi, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btn_timKiemNhaCungCap1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(172, Short.MAX_VALUE))
				.addGroup(pn_RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(pn_RightLayout.createSequentialGroup()
								.addGap(44, 44, 44)
								.addComponent(lb_maNhaCungCap1)
								.addContainerGap(597, Short.MAX_VALUE)))
				);

		pn_Top.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		pn_Top.setPreferredSize(new java.awt.Dimension(808, 72));

		lb_TKNCC.setBackground(new java.awt.Color(204, 255, 204));
		lb_TKNCC.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lb_TKNCC.setText("TÌM KIẾM NHÀ CUNG CẤP");

		GroupLayout pn_TopLayout = new GroupLayout(pn_Top);
		pn_Top.setLayout(pn_TopLayout);
		pn_TopLayout.setHorizontalGroup(
				pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_TopLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lb_TKNCC)
						.addGap(442, 442, 442))
				);
		pn_TopLayout.setVerticalGroup(
				pn_TopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, pn_TopLayout.createSequentialGroup()
						.addContainerGap(15, Short.MAX_VALUE)
						.addComponent(lb_TKNCC)
						.addGap(17, 17, 17))
				);

		GroupLayout pn_FormLayout = new GroupLayout(pn_Form);
		pn_Form.setLayout(pn_FormLayout);
		pn_FormLayout.setHorizontalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pn_Top, GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
								.addGroup(pn_FormLayout.createSequentialGroup()
										.addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pn_Right, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		pn_FormLayout.setVerticalGroup(
				pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pn_FormLayout.createSequentialGroup()
						.addComponent(pn_Top, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_FormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pn_Left, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pn_Right, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pn_Form, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
						.addContainerGap())
				);
		napDuLieuTuCSDL(dao_NhaCungCap.getAllNCC());
		btn_timKiemNhaCungCap1.addActionListener(this);
		btn_lamMoi.addActionListener(this);     
		table_danhSachNhaCungCap.addMouseListener(this);
	}// </editor-fold>//GEN-END:initComponents
	public void napDuLieuTuCSDL(ArrayList<NhaCungCap> ds) {
		DefaultTableModel dm = (DefaultTableModel) table_danhSachNhaCungCap.getModel();
		dm.getDataVector().removeAllElements();
		for (NhaCungCap ncc : ds) {
			model.addRow(new Object[] { ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSoDienThoai(), ncc.getDiaChi(), ncc.getEmail() });
		}
	}

	private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btn_lamMoiActionPerformed

	private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txt_emailActionPerformed

	private void btn_timKiemNhaCungCap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemNhaCungCap1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btn_timKiemNhaCungCap1ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_timKiemNhaCungCap1)) {
			String ma = txt_maNhaCungCap.getText().trim();	      
			String sdt = txt_sDT.getText().trim();

			// Thực hiện tìm kiếm theo tiêu chí và hiển thị kết quả
			ArrayList<NhaCungCap> ketQuaTimKiem = dao_NhaCungCap.timTheoTieuChi(ma, sdt);
			hienThiKetQuaTimKiem(ketQuaTimKiem);
		}
		if (o.equals(btn_lamMoi)) {
			xoaTrang();
			napDuLieuTuCSDL(dao_NhaCungCap.getAllNCC());
		}
	}
	private void xoaTrang() {
		// TODO Auto-generated method stub
		txt_maNhaCungCap.setText("");
		txt_tenNhaCungCap.setText("");
		txt_sDT.setText("");
		txt_diaChi.setText("");
		txt_email.setText("");
		txt_maNhaCungCap.requestFocus();
	}
	private void hienThiKetQuaTimKiem(ArrayList<NhaCungCap> ketQua) {
		DefaultTableModel dm = (DefaultTableModel) table_danhSachNhaCungCap.getModel();
		dm.getDataVector().removeAllElements();

		if (!ketQua.isEmpty()) {
			for (NhaCungCap nv : ketQua) {
				dm.addRow(new Object[] {
						nv.getMaNCC(), nv.getTenNCC(), nv.getSoDienThoai(),nv.getDiaChi(), nv.getEmail(),
				});
			}
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhân Viên!");
		}

		xoaTrang();
	}
	public void timTheoMaNCC() {
		String ma = txt_maNhaCungCap.getText().trim();
		NhaCungCap ncc = dao_NhaCungCap.getNhaCungCap(ma);
		if (ncc != null) {
			DefaultTableModel dm = (DefaultTableModel) table_danhSachNhaCungCap.getModel();
			dm.getDataVector().removeAllElements();
			model.addRow(new Object[] { ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSoDienThoai(), ncc.getDiaChi(),
					ncc.getEmail() });
		} else {
			JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhà Cung Cấp có mã là "+ ma +"!");
		}
		xoaTrang();
	}
	private void fillForm(int r) {
		// TODO Auto-generated method stub
		//			txt_maNhaCungCap.setEditable(false);
		txt_maNhaCungCap.setText(table_danhSachNhaCungCap.getValueAt(r, 0).toString());
		txt_tenNhaCungCap.setText(table_danhSachNhaCungCap.getValueAt(r, 1).toString());
		txt_sDT.setText(table_danhSachNhaCungCap.getValueAt(r, 2).toString());
		txt_diaChi.setText(table_danhSachNhaCungCap.getValueAt(r, 3).toString());
		txt_email.setText(table_danhSachNhaCungCap.getValueAt(r, 4).toString());
	}


	@Override
	public void mouseClicked(MouseEvent e) {
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

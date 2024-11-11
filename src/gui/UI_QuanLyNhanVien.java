package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

public class UI_QuanLyNhanVien extends JPanel implements ActionListener, MouseListener{

    private static final long serialVersionUID = 1L;
    private JButton btnSua;
    private JButton btnThem;
    private JButton btnXoa;
    private JButton btnXoaTrang;
    private JComboBox<String> cmbGioiTinh;
    private com.toedter.calendar.JDateChooser dc_NgaySinh;
    private JLabel lbl_QLNV;
    private JLabel lblDanhSachNhanVien;
    private JLabel lblDiaChi;
    private JLabel lblEmail;
    private JLabel lblGioiTinh;
    private JLabel lbl_maNV;
    private JLabel lblNgaySinh;
    private JLabel lbl_qLNV;
    private JLabel lblSoDienThoai;
    private JLabel lblTenNhanVien;
    private JPanel pnlLeft;
    private JPanel pnlRight;
    private JPanel pnlTop;
    private JScrollPane scr_DSNV;
    private JTable tblDanhSachNhanVien;
    private JTextField txtDiaChi;
    private JTextField txtEmail;
    private JTextField txtMaNhanVien;
    private JTextField txtSoDienThoai;
    private JTextField txtTenNhanVien;
    private DefaultTableModel model;
    
    
    private DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
    public UI_QuanLyNhanVien() {
        initComponents();
    }

    private void initComponents() {

        pnlTop = new JPanel();
        lbl_QLNV = new JLabel();
        pnlLeft = new JPanel();
        scr_DSNV = new JScrollPane();
        tblDanhSachNhanVien = new JTable();
        lblDanhSachNhanVien = new JLabel();
        pnlRight = new JPanel();
        txtMaNhanVien = new JTextField();
        txtTenNhanVien = new JTextField();
        txtSoDienThoai = new JTextField();
        txtDiaChi = new JTextField();
        txtEmail = new JTextField();
        lblNgaySinh = new JLabel();
        lblSoDienThoai = new JLabel();
        lblTenNhanVien = new JLabel();
        lblDiaChi = new JLabel();
        lblGioiTinh = new JLabel();
        lbl_maNV = new JLabel();
        lbl_qLNV = new JLabel();
        lblEmail = new JLabel();
        cmbGioiTinh = new JComboBox<>();
        btnThem = new JButton();
        btnSua = new JButton();
        btnXoa = new JButton();
        btnXoaTrang = new JButton();
        dc_NgaySinh = new com.toedter.calendar.JDateChooser();
      //chuyển định dạng ngày tháng đầu vào thành dd/MM/yyyy
        dc_NgaySinh.setDateFormatString("dd/MM/yyyy");

        pnlTop.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_QLNV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_QLNV.setText("QUẢN LÝ NHÂN VIÊN");

        GroupLayout pnlTopLayout = new GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_QLNV, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                .addGap(521, 521, 521))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl_QLNV, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pnlLeft.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        model = new DefaultTableModel();
		tblDanhSachNhanVien = new JTable(model);
		tblDanhSachNhanVien.setRowHeight(25);     
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Tên Nhân Viên");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Địa Chỉ");
		model.addColumn("Giới Tính");
		model.addColumn("Email");
		model.addColumn("Ngày Sinh");
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
                    .addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addComponent(lblDanhSachNhanVien, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addComponent(lblDanhSachNhanVien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_DSNV)
                .addGap(15, 15, 15))
        );

        pnlRight.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txtMaNhanVienActionPerformed(evt);
            }
        });

        txtTenNhanVien.setMinimumSize(new java.awt.Dimension(64, 25));
        txtTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txtTenNhanVienActionPerformed(evt);
            }
        });

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txtSoDienThoaiActionPerformed(evt);
            }
        });

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txtDiaChiActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txtEmailActionPerformed(evt);
            }
        });

        lblNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgaySinh.setText("Ngày Sinh:");

        lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoDienThoai.setText("Số Điện Thoại:");

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenNhanVien.setText("Tên Nhân Viên:");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDiaChi.setText("Địa Chỉ:");

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGioiTinh.setText("Giới Tính:");

        lbl_maNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_maNV.setText("Mã Nhân Viên:");

        lbl_qLNV.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbl_qLNV.setForeground(new java.awt.Color(255, 0, 51));
        lbl_qLNV.setText("Quản Lý Nhân Viên");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setText("Email:");

        cmbGioiTinh.setModel(new DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnThem.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\add.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                actionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSua.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\fix.png")); // NOI18N
        btnSua.setText("Sửa");

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXoa.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\delete.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnXoaActionPerformed(evt);
            }
        });

        btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXoaTrang.setIcon(new ImageIcon("D:\\Nhom18_PTUD_DoAn\\QLThoiTrang\\icon\\xoaTrang.png")); // NOI18N
        btnXoaTrang.setText("Xóa Trắng");

        GroupLayout pnlRightLayout = new GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(txtEmail))
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(dc_NgaySinh, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72))
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenNhanVien, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_maNV, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoDienThoai, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMaNhanVien, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(txtTenNhanVien, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoDienThoai, GroupLayout.Alignment.LEADING)
                                .addComponent(txtDiaChi, GroupLayout.Alignment.LEADING))
                            .addComponent(cmbGioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 72, Short.MAX_VALUE))))
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(btnXoaTrang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_qLNV, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addComponent(lbl_qLNV, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_maNV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNhanVien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dc_NgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnSua, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
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
        napDuLieuTuCSDL(dao_NhanVien.getAllNhanVien());
        btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
//		btn_date.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tblDanhSachNhanVien.addMouseListener(this);
    }// </editor-fold>//GEN-END:initComponents
    public void napDuLieuTuCSDL(ArrayList<NhanVien> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblDanhSachNhanVien.getModel();
		dm.getDataVector().removeAllElements();
		for (NhanVien nv : ds) {
			model.addRow(new Object[] { nv.getMaNV(), nv.getTenNV(), nv.getsDT(),nv.getDiaChi(), nv.isGioiTinh() ? "Nam" : "Nữ",
					nv.getEmail(), new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgaySinh()) });
		}
	}
    

    public NhanVien revertNhanVienFromFields() {
        String maNV = txtMaNhanVien.getText().trim();
        String tenNV = txtTenNhanVien.getText().trim();
        
        Date ngaySinh =  dc_NgaySinh.getDate(); // Lấy ngày được chọn từ JDateChooser
        
        String sDT = txtSoDienThoai.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String email = txtEmail.getText().trim();

        // Lấy giới tính từ ComboBox
        String gioiTinhStr = cmbGioiTinh.getSelectedItem().toString();
        boolean gioiTinh = gioiTinhStr.equals("Nam"); // Sử dụng giá trị chọn trong ComboBox

        NhanVien nv = new NhanVien(maNV, tenNV,ngaySinh, gioiTinh, sDT, diaChi, email);
        return nv;
    }

    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if (o.equals(btnThem)) {
			if(!valiData()) {
			return;
			}
			NhanVien nv = revertNhanVienFromFields();
			if (!dao_NhanVien.themNV(nv)) {
				JOptionPane.showMessageDialog(this, "Trùng mã");
			} else {
				napDuLieuTuCSDL(dao_NhanVien.getAllNhanVien());

				tblDanhSachNhanVien.clearSelection();		
			}
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if(o.equals(btnSua)) {
			sua();
			napDuLieuTuCSDL(dao_NhanVien.getAllNhanVien());
		}
		if(o.equals(btnXoa)) {
			deleteRowSelected();
			napDuLieuTuCSDL(dao_NhanVien.getAllNhanVien());
		}

	}

	private void deleteRowSelected() {
		// TODO Auto-generated method stub
		String listMaNV = "";
		String maNV = "";

		if (tblDanhSachNhanVien.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa");
		} else {

			//			lay ra danh sach xoa tren GUI
			int[] listIndex = tblDanhSachNhanVien.getSelectedRows();
			listMaNV += tblDanhSachNhanVien.getValueAt(listIndex[0], 0);
			for (int i = 1; i < tblDanhSachNhanVien.getSelectedRowCount(); i++) {
				listMaNV += ", " + tblDanhSachNhanVien.getValueAt(listIndex[i], 0);
			}

			//			Hien thi thong tin xoa
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên " + listMaNV + " ?",
					"Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					while (tblDanhSachNhanVien.getSelectedRowCount() > 0) {
						maNV = (String) tblDanhSachNhanVien.getValueAt(tblDanhSachNhanVien.getSelectedRow(), 0);
						if (!dao_NhanVien.xoa(maNV)) {
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

	private void sua() {
		// TODO Auto-generated method stub
		int r = tblDanhSachNhanVien.getSelectedRow();
		if(!valiData()) {
			return;
		}
		if(r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa");
		}else {
			//			if(valiData()) {
			NhanVien nvMoi = revertNhanVienFromFields();
			if(!dao_NhanVien.suaNV(nvMoi)) {
				JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
				tblDanhSachNhanVien.clearSelection();
			}else {
				JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công !");
			}
			//			}
		}

	}

	@SuppressWarnings("deprecation")
	private boolean valiData() {
		// TODO Auto-generated method stub
		String maNv = txtMaNhanVien.getText().trim();
		String tenNv = txtTenNhanVien.getText().trim();
		String sdt = txtSoDienThoai.getText().trim();
        String email = txtEmail.getText().trim();
        if (txtEmail.getText().equals("") || txtSoDienThoai.getText().equals("") || txtTenNhanVien.getText().equals("")
                || txtMaNhanVien.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        if (!tenNv.matches("^[\\p{L}\\p{M} .'-]+$")) {
            JOptionPane.showMessageDialog(txtTenNhanVien, "Tên nhân viên phải là các ký tự chữ cái.");
            txtTenNhanVien.requestFocus();
            return false;
        }
        if (maNv.length() != 8 || !maNv.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(txtMaNhanVien, "Mã nhân viên phải là 8 ký tự số.");
            txtMaNhanVien.requestFocus();
            return false;
        }
        if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}"))) {
            JOptionPane.showMessageDialog(txtSoDienThoai, "Số điện thoại sai định dạng");
            txtSoDienThoai.requestFocus();
            return false;
        }

        if (!(email.length() > 0 && email.matches("[a-zA-Z0-9._%-]+(@){1}[a-zA-Z]+(.){1}[a-zA-Z]{2,4}"))) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            txtEmail.requestFocus();
            return false;
        }
        Date ngaySinh = dc_NgaySinh.getDate();
        Date ngayHienTai = new Date(); // Lấy ngày hiện tại
        int tuoi = ngayHienTai.getYear() - ngaySinh.getYear(); // Tính tuổi
        if (tuoi < 18) {
            JOptionPane.showMessageDialog(dc_NgaySinh, "Tuổi phải lớn hơn hoặc bằng 18");
            return false;
        }
		return true;
	}

	private void xoaTrang() {
		// TODO Auto-generated method stub
		txtMaNhanVien.setText("");
		txtTenNhanVien.setText("");
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		dc_NgaySinh.setDate(Calendar.getInstance().getTime());

	}
	private void fillForm(int r) {
		// TODO Auto-generated method stub
		txtMaNhanVien.setEditable(false);
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
		String ngaySinhStr = tblDanhSachNhanVien.getValueAt(r, 6).toString(); // Lấy ngày sinh từ tblDanhSachNhanVien dưới dạng chuỗi
		try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date ngaySinh = dateFormat.parse(ngaySinhStr); // Chuyển đổi chuỗi ngày sinh thành Date
            dc_NgaySinh.setDate(ngaySinh); // Đặt giá trị cho JDateChooser
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

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

	
}

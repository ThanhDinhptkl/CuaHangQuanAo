package entity;

import java.sql.Date;
import dao.DAO_PhieuDatHang;

public class PhieuDatHang {
	private String maPhieuDat;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Date ngayDat;
	
	private String auto_IDPhieuDatHang(){
        //auto gen id hóa đơn dạng HDXXXXXX
        DAO_PhieuDatHang dao_phieuDatHang = new DAO_PhieuDatHang();
        String idPrefix = "PDH";
        int length = dao_phieuDatHang.getAllPhieuDatHang().size();
        String finalId = idPrefix + String.format("%05d", length + 1);
        return finalId;
    }
	public PhieuDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuDatHang(String maPhieuDat, KhachHang khachHang, NhanVien nhanVien, Date ngayDat) {
		super();
		this.maPhieuDat = maPhieuDat;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayDat = ngayDat;
	}
	public PhieuDatHang(KhachHang khachHang, NhanVien nhanVien, Date ngayDat) {
		super();
		this.maPhieuDat = auto_IDPhieuDatHang();
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayDat = ngayDat;
	}

	public String getMaPhieuDat() {
		return maPhieuDat;
	}

	public 	void setMaPhieuDat(String maPhieuDat) {
		this.maPhieuDat = maPhieuDat;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}


	public 	void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	@Override
	public String toString() {
		return "E_PhieuDatHang [maPhieuDat=" + maPhieuDat + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien
				+ ", ngayDat=" + ngayDat + "]";
	}
	
}

package entity;

import java.sql.Date;
import java.util.ArrayList;

import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;


public class HoaDon {
	private String maHD;
	private KhachHang e_KhachHang;
	private NhanVien e_NhanVien;
	private Date ngayLapHD;
	
	private String auto_IDHoaDon(){
        //auto gen id hóa đơn dạng HDXXXXXX
        DAO_HoaDon dao_hoaDon = new DAO_HoaDon();
        String idPrefix = "HD";
        int length = dao_hoaDon.getAllHoaDon().size();
        String finalId = idPrefix + String.format("%06d", length + 1);
        return finalId;
    }
	public HoaDon() {
        this.maHD = auto_IDHoaDon();
    }
	public HoaDon( KhachHang e_KhachHang, NhanVien e_NhanVien, Date ngayLapHD) {
		super();
		this.maHD = auto_IDHoaDon();
		this.e_KhachHang = e_KhachHang;
		this.e_NhanVien = e_NhanVien;
		this.ngayLapHD = ngayLapHD;
	}
	public HoaDon(String maHD, KhachHang e_KhachHang, NhanVien e_NhanVien, Date ngayLapHD) {
		super();
		this.maHD = maHD;
		this.e_KhachHang = e_KhachHang;
		this.e_NhanVien = e_NhanVien;
		this.ngayLapHD = ngayLapHD;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public KhachHang getKhachHang() {
		return e_KhachHang;
	}
	public void setKhachHang(KhachHang e_KhachHang) {
		this.e_KhachHang = e_KhachHang;
	}
	public NhanVien getNhanVien() {
		return e_NhanVien;
	}
	public void setNhanVien(NhanVien e_NhanVien) {
		this.e_NhanVien = e_NhanVien;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public void setThanhHoaDon(){
        this.maHD = auto_IDHoaDon();
    }
	public double tongTien(){
        long tongTien = 0;
       DAO_ChiTietHoaDon dao_ChiTietHoaDon = new DAO_ChiTietHoaDon();
        ArrayList<ChiTietHoaDon>listChiTietHoaDon = dao_ChiTietHoaDon.getAllCTHDByHoaDon(this);
        
        for(ChiTietHoaDon cthd : listChiTietHoaDon){
            tongTien += cthd.getSoLuong();
        }
        
        return tongTien;
    }
	
	
    
   
    
	
}

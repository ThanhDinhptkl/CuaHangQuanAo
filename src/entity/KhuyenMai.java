package entity;

import java.util.Date;

import dao.DAO_KhuyenMai;


public class KhuyenMai {
	private String maKM;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private Double mucGiamGia;
	
	private String auto_ID(){
       DAO_KhuyenMai dao_khuyenMai = new DAO_KhuyenMai();
       String idPrefix = "KM";
       int length = dao_khuyenMai.getAllKhuyenMai().size();
       String finalId = idPrefix + String.format("%06d", length + 1);
       return finalId;
   }
	

	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}


	public KhuyenMai( Date ngayBatDau, Date ngayKetThuc, Double mucGiamGia) {
		super();
		this.maKM = auto_ID();
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.mucGiamGia = mucGiamGia;
	}
	public KhuyenMai(String maKM, Date ngayBatDau, Date ngayKetThuc, Double mucGiamGia) {
		super();
		this.maKM = maKM;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.mucGiamGia = mucGiamGia;
	}
	
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public Double getMucGiamGia() {
		return mucGiamGia;
	}
	public void setMucGiamGia(Double mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}

	public double tinhTienKhuyenMai(double giaBan){
		double giaTienKM = 0;
        
        giaTienKM = giaBan * this.mucGiamGia / 100;
        
        return giaTienKM;
    }
	@Override
	public String toString() {
		return "KhuyenMai [maKM=" + maKM + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc
				+ ", mucGiamGia=" + mucGiamGia + ", soLuong="  + "]";
	}
	
}
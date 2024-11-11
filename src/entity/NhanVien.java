package entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String sDT;
	private String diaChi;
	private String email;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV, String tenNV, Date ngaySinh, boolean gioiTinh, String sDT, String diaChi,
			String email) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.diaChi = diaChi;
		this.email = email;
	}
	public	String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFormattedNgaySinh() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(ngaySinh);
    }
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + getFormattedNgaySinh() + ", gioiTinh=" + gioiTinh
				+ ", sDT=" + sDT + ", diaChi=" + diaChi + ", email=" + email + "]";
	}
	
	
	
}

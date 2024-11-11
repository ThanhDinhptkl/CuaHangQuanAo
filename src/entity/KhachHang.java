package entity;

import java.util.Objects;

import dao.DAO_KhachHang;
import dao.DAO_MauSac;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String sDT;
	private boolean gioiTinh;
	private String email;
	
	public String auto_ID(){
	    DAO_KhachHang khachHang_DAO = new DAO_KhachHang();
	     String idPrefix = "KH";
	    int length = khachHang_DAO.getALLKhachHang().size();
	    String finalId = idPrefix + String.format("%06d", length + 1);
	    return finalId;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String tenKH, String sDT, boolean gioiTinh, String email) {
		super();
		this.maKH = auto_ID();
		this.tenKH = tenKH;
		this.sDT = sDT;
		this.gioiTinh = gioiTinh;
		this.email = email;
	}
	public KhachHang(String maKH, String tenKH, String sDT, boolean gioiTinh, String email) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sDT = sDT;
		this.gioiTinh = gioiTinh;
		this.email = email;
	}
//	public KhachHang(String tenKH, String sDT, boolean gioiTinh, String email) {
//		super();
//		this.tenKH = tenKH;
//		this.sDT = sDT;
//		this.gioiTinh = gioiTinh;
//		this.email = email;
//	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public	String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sDT=" + sDT + ", gioiTinh=" + gioiTinh + ", email="
				+ email + "]";
	}

	
}
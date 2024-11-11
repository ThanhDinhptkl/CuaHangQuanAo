package entity;

public class ChiTietHoaDon {
	private HoaDon e_HoaDon;
	private QuanAo e_QuanAo;
	private int soLuong;
	private double donGia;
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(HoaDon e_HoaDon, QuanAo e_QuanAo, int soLuong, double donGia) {
		super();
		this.e_HoaDon = e_HoaDon;
		this.e_QuanAo = e_QuanAo;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public HoaDon getHoaDon() {
		return e_HoaDon;
	}
	public void setHoaDon(HoaDon e_HoaDon) {
		this.e_HoaDon = e_HoaDon;
	}
	public QuanAo getQuanAo() {
		return e_QuanAo;
	}
	public void setQuanAo(QuanAo e_QuanAo) {
		this.e_QuanAo = e_QuanAo;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + e_HoaDon + ", quanAo=" + e_QuanAo + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ "]";
	}
	
	
	
}

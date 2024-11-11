package entity;

public class ChiTietPhieuDatHang {
	private PhieuDatHang phieuDatHang;
	private QuanAo quanAo;
	private int soLuong;
	public ChiTietPhieuDatHang(PhieuDatHang phieuDatHang, QuanAo quanAo, int soLuong) {
		super();
		this.phieuDatHang = phieuDatHang;
		this.quanAo = quanAo;
		this.soLuong = soLuong;
	}
	public ChiTietPhieuDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuDatHang getPhieuDatHang() {
		return phieuDatHang;
	}
	public void setPhieuDatHang(PhieuDatHang phieuDatHang) {
		this.phieuDatHang = phieuDatHang;
	}
	public QuanAo getQuanAo() {
		return quanAo;
	}
	public void setQuanAo(QuanAo quanAo) {
		this.quanAo = quanAo;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "E_ChiTietPhieuDatHang [phieuDatHang=" + phieuDatHang + ", quanAo=" + quanAo + ", soLuong=" + soLuong
				+ "]";
	}
	
}

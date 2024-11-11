package entity;

import java.util.Date;

import dao.DAO_QuanAo;

public class QuanAo {
	private String maQuanAo;
	private String tenQuanAo;
	private String hinhAnh;
	private MauSac e_MauSac;
	private int soLuong;
	private ThuongHieu e_ThuongHieu;
	private ChatLieu e_ChatLieu;
	private KichCo e_KichCo;
	private LoaiQuanAo e_LoaiQuanAo;
	private NhaCungCap e_NhaCungCap;
	private double donGiaBan;
	private KhuyenMai e_KhuyenMai;

	public QuanAo() {
		super();
	}
	public String auto_ID(){
		DAO_QuanAo DAO_quanAo = new DAO_QuanAo();
		String idPrefix = "QA";
		int length = DAO_quanAo.getAllQuanAo().size();
		String finalId = idPrefix + String.format("%06d", length + 1);
		return finalId;
	}
	public QuanAo(String tenQuanAo, String hinhAnh, MauSac e_MauSac, int soLuong, ThuongHieu e_ThuongHieu,
			ChatLieu e_ChatLieu, KichCo e_KichCo, LoaiQuanAo e_LoaiQuanAo, NhaCungCap e_NhaCungCap, double donGiaBan,
			KhuyenMai e_KhuyenMai) {
		super();
		this.maQuanAo = auto_ID();
		this.tenQuanAo = tenQuanAo;
		this.hinhAnh = hinhAnh;
		this.e_MauSac = e_MauSac;
		this.soLuong = soLuong;
		this.e_ThuongHieu = e_ThuongHieu;
		this.e_ChatLieu = e_ChatLieu;
		this.e_KichCo = e_KichCo;
		this.e_LoaiQuanAo = e_LoaiQuanAo;
		this.e_NhaCungCap = e_NhaCungCap;
		this.donGiaBan = donGiaBan;
		this.e_KhuyenMai = e_KhuyenMai;
	}
	public QuanAo(String maQuanAo, String tenQuanAo, String hinhAnh, MauSac e_MauSac, int soLuong, ThuongHieu e_ThuongHieu,
			ChatLieu e_ChatLieu, KichCo e_KichCo, LoaiQuanAo e_LoaiQuanAo, NhaCungCap e_NhaCungCap, double donGiaBan,
			KhuyenMai e_KhuyenMai) {
		super();
		this.maQuanAo = maQuanAo;
		this.tenQuanAo = tenQuanAo;
		this.hinhAnh = hinhAnh;
		this.e_MauSac = e_MauSac;
		this.soLuong = soLuong;
		this.e_ThuongHieu = e_ThuongHieu;
		this.e_ChatLieu = e_ChatLieu;
		this.e_KichCo = e_KichCo;
		this.e_LoaiQuanAo = e_LoaiQuanAo;
		this.e_NhaCungCap = e_NhaCungCap;
		this.donGiaBan = donGiaBan;
		this.e_KhuyenMai = e_KhuyenMai;
	}

	public String getMaQuanAo() {
		return maQuanAo;
	}
	public void setMaQuanAo(String maQuanAo) {
		this.maQuanAo = maQuanAo;
	}
	public String getTenQuanAo() {
		return tenQuanAo;
	}
	public void setTenQuanAo(String tenQuanAo) {
		this.tenQuanAo = tenQuanAo;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public MauSac getMauSac() {
		return e_MauSac;
	}
	public void setMauSac(MauSac e_MauSac) {
		this.e_MauSac = e_MauSac;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public ThuongHieu getThuongHieu() {
		return e_ThuongHieu;
	}
	public void setThuongHieu(ThuongHieu e_ThuongHieu) {
		this.e_ThuongHieu = e_ThuongHieu;
	}
	public ChatLieu getChatLieu() {
		return e_ChatLieu;
	}
	public void setChatLieu(ChatLieu e_ChatLieu) {
		this.e_ChatLieu = e_ChatLieu;
	}
	public KichCo getKichCo() {
		return e_KichCo;
	}
	public void setKichCo(KichCo e_KichCo) {
		this.e_KichCo = e_KichCo;
	}
	public LoaiQuanAo getLoaiQuanAo() {
		return e_LoaiQuanAo;
	}
	public void setLoaiQuanAo(LoaiQuanAo e_LoaiQuanAo) {
		this.e_LoaiQuanAo = e_LoaiQuanAo;
	}
	public NhaCungCap getNhaCungCap() {
		return e_NhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap e_NhaCungCap) {
		this.e_NhaCungCap = e_NhaCungCap;
	}
	public double getDonGiaBan() {
		return donGiaBan;
	}
	public void setDonGiaBan(double donGiaBan) {
		this.donGiaBan = donGiaBan;
	}
	public KhuyenMai getKhuyenMai() {
		return e_KhuyenMai;
	}
	public void setKhuyenMai(KhuyenMai e_KhuyenMai) {
		this.e_KhuyenMai = e_KhuyenMai;
	}
	public double tinhGiaBanLucDau(){
		double giaBanLucDau = 0;
		giaBanLucDau = this.donGiaBan + this.donGiaBan/10;
		return giaBanLucDau;
	}
	public double tinhGiaBanLucSau() {
		double giaBanLucSau = 0;
		if (this.getKhuyenMai() != null) {
			Date ngayBD = this.getKhuyenMai().getNgayBatDau();
			Date ngayKT = this.getKhuyenMai().getNgayKetThuc();
			Date ngayHT = new Date();  // Lấy ngày hiện tại
			if (!ngayHT.before(ngayBD) && !ngayHT.after(ngayKT)) {
				// Ngày hiện tại nằm trong khoảng khuyến mãi
				giaBanLucSau = this.tinhGiaBanLucDau() - this.getKhuyenMai().tinhTienKhuyenMai(tinhGiaBanLucDau());
			} else {
				giaBanLucSau = this.tinhGiaBanLucDau();
			}
			return giaBanLucSau;
		} else {
			giaBanLucSau = this.tinhGiaBanLucDau();
		}
		return giaBanLucSau;
	}
	public double layGiaBan() {
		// Logic để lấy giá bán, có thể dựa trên tinhGiaBanLucSau() hoặc tùy thuộc vào logic của bạn
		if (this.getKhuyenMai() != null) {
			return this.tinhGiaBanLucSau();
		} else {
			return this.tinhGiaBanLucDau();
		}
	}
	@Override
	public String toString() {
		return "QuanAo [maQuanAo=" + maQuanAo + ", tenQuanAo=" + tenQuanAo + ", hinhAnh=" + hinhAnh + ", mauSac="
				+ e_MauSac + ", soLuong=" + soLuong + ", thuongHieu=" + e_ThuongHieu + ", chatLieu=" + e_ChatLieu
				+ ", kichCo=" + e_KichCo + ", loaiQuanAo=" + e_LoaiQuanAo + ", nhaCungCap=" + e_NhaCungCap + ", donGiaBan="
				+ donGiaBan + ", khuyenMai=" + e_KhuyenMai + "]";
	}
}

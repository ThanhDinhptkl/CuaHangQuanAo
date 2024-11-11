package entity;

public class GioHang {
	private QuanAo maQA;
	private QuanAo tenQA;
	private QuanAo donGiaBan;
	private ChiTietPhieuDatHang soLuong;
	private LoaiQuanAo loai;
	private MauSac mauSac;
	private ThuongHieu thuongHieu;
	private KichCo kichCo;
	private ChatLieu chatLieu;
	public GioHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GioHang(QuanAo maQA, QuanAo tenQA, QuanAo donGiaBan, ChiTietPhieuDatHang soLuong, LoaiQuanAo loai,
			MauSac mauSac, ThuongHieu thuongHieu, KichCo kichCo, ChatLieu chatLieu) {
		super();
		this.maQA = maQA;
		this.tenQA = tenQA;
		this.donGiaBan = donGiaBan;
		this.soLuong = soLuong;
		this.loai = loai;
		this.mauSac = mauSac;
		this.thuongHieu = thuongHieu;
		this.kichCo = kichCo;
		this.chatLieu = chatLieu;
	}
	public QuanAo getMaQA() {
		return maQA;
	}
	public void setMaQA(QuanAo maQA) {
		this.maQA = maQA;
	}
	public QuanAo getTenQA() {
		return tenQA;
	}
	public void setTenQA(QuanAo tenQA) {
		this.tenQA = tenQA;
	}
	public QuanAo getDonGiaBan() {
		return donGiaBan;
	}
	public void setDonGiaBan(QuanAo donGiaBan) {
		this.donGiaBan = donGiaBan;
	}
	public ChiTietPhieuDatHang getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(ChiTietPhieuDatHang soLuong) {
		this.soLuong = soLuong;
	}
	public LoaiQuanAo getLoai() {
		return loai;
	}
	public void setLoai(LoaiQuanAo loai) {
		this.loai = loai;
	}
	public MauSac getMauSac() {
		return mauSac;
	}
	public void setMauSac(MauSac mauSac) {
		this.mauSac = mauSac;
	}
	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public KichCo getKichCo() {
		return kichCo;
	}
	public void setKichCo(KichCo kichCo) {
		this.kichCo = kichCo;
	}
	public ChatLieu getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(ChatLieu chatLieu) {
		this.chatLieu = chatLieu;
	}
	public double layGiaBan() {
        if (donGiaBan != null) {
            return donGiaBan.layGiaBan();
        } else {
            // Xử lý trường hợp không có đối tượng DonGiaBan, nếu cần
            return 0.0; // hoặc giá trị mặc định phù hợp với ứng dụng của bạn
        }
    }
	
	
	@Override
	public String toString() {
		return "GioHang [maQA=" + maQA + ", tenQA=" + tenQA + ", donGiaBan=" + donGiaBan + ", soLuong=" + soLuong
				+ ", loai=" + loai + ", mauSac=" + mauSac + ", thuongHieu=" + thuongHieu + ", kichCo=" + kichCo
				+ ", chatLieu=" + chatLieu + "]";
	}
	
}

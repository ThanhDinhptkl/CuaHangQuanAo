package entity;

import dao.DAO_ThuongHieu;

public class ThuongHieu {
private String maThuongHieu;
private String thuongHieu;
public ThuongHieu() {
}
private String auto_ID(){
    DAO_ThuongHieu thuongHieu_DAO = new DAO_ThuongHieu();
    String idPrefix = "TH";
   int length = thuongHieu_DAO.getAllThuongHieu().size();
   String finalId = idPrefix + String.format("%06d", length + 1);
   return finalId;
}

public ThuongHieu(String thuongHieu) {
	super();
	this.maThuongHieu = auto_ID();
	this.thuongHieu = thuongHieu;
}
public ThuongHieu(String maThuongHieu, String thuongHieu) {
	super();
	this.maThuongHieu = maThuongHieu;
	this.thuongHieu = thuongHieu;
}
public String getMaThuongHieu() {
	return maThuongHieu;
}
public void setMaThuongHieu(String maThuongHieu) {
	this.maThuongHieu = maThuongHieu;
}
public String getThuongHieu() {
	return thuongHieu;
}
public void setThuongHieu(String thuongHieu) {
	this.thuongHieu = thuongHieu;
}

}

package entity;

import dao.DAO_LoaiQuanAo;

public class LoaiQuanAo {
private String maLoai;
private String loai;
public LoaiQuanAo() {
}
private String auto_ID(){
    DAO_LoaiQuanAo LoaiQuanAo_DAO = new DAO_LoaiQuanAo();
    String idPrefix = "LQA";
   int length = LoaiQuanAo_DAO.getAllLoai().size();
   String finalId = idPrefix + String.format("%05d", length + 1);
   return finalId;
}
public LoaiQuanAo( String loai) {
	super();
	this.maLoai = auto_ID();
	this.loai = loai;
}
public LoaiQuanAo(String maLoai, String loai) {
	super();
	this.maLoai = maLoai;
	this.loai = loai;
}

public String getMaLoai() {
	return maLoai;
}
public void setMaLoai(String maLoai) {
	this.maLoai = maLoai;
}
public String getLoai() {
	return loai;
}
public void setLoai(String loai) {
	this.loai = loai;
} 

}

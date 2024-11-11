package entity;

import dao.DAO_KichCo;

public class KichCo {
private String maKichCo;
private String kichCo;
public KichCo() {
}
private String auto_ID(){
    DAO_KichCo kichCo_DAO = new DAO_KichCo();
    String idPrefix = "KC";
   int length = kichCo_DAO.getAllKichCo().size();
   String finalId = idPrefix + String.format("%06d", length + 1);
   return finalId;
}

public KichCo( String kichCo) {
	super();
	this.maKichCo = auto_ID();
	this.kichCo = kichCo;
}
public KichCo(String maKichCo, String kichCo) {
	super();
	this.maKichCo = maKichCo;
	this.kichCo = kichCo;
}
public String getMaKichCo() {
	return maKichCo;
}
public void setMaKichCo(String maKichCo) {
	this.maKichCo = maKichCo;
}
public String getKichCo() {
	return kichCo;
}
public void setKichCo(String kichCo) {
	this.kichCo = kichCo;
}	

}

package entity;

import dao.DAO_MauSac;
import dao.DAO_MauSac;

public class MauSac {
private String maMauSac;
private String mauSac;
public MauSac() {
}
private String auto_ID(){
    DAO_MauSac mauSac_DAO = new DAO_MauSac();
     String idPrefix = "MS";
    int length = mauSac_DAO.getAllMauSac().size();
    String finalId = idPrefix + String.format("%06d", length + 1);
    return finalId;
}

	public MauSac(String maMauSac, String mauSac) {
	super();
	this.maMauSac = maMauSac;
	this.mauSac = mauSac;
}
	public MauSac(String mauSac) {
		super();
		this.maMauSac = auto_ID();
		this.mauSac = mauSac;
	}
	public String getMaMauSac() {
		return maMauSac;
	}
	public void setMaMauSac(String maMauSac) {
		this.maMauSac = maMauSac;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	} 
	

}

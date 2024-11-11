package entity;

import dao.DAO_ChatLieu;

public class ChatLieu {
private String maChatLieu;
private String chatLieu;

public ChatLieu() {
}
private String auto_ID(){
    DAO_ChatLieu chatLieu_DAO = new DAO_ChatLieu();
     String idPrefix = "CL";
    int length = chatLieu_DAO.getAllChatLieu().size();
    String finalId = idPrefix + String.format("%06d", length + 1);
    return finalId;
}
public ChatLieu(String chatLieu) {
	super();
	this.maChatLieu = auto_ID();
	this.chatLieu = chatLieu;
}
public ChatLieu(String maChatLieu, String chatLieu) {
	super();
	this.maChatLieu = maChatLieu;
	this.chatLieu = chatLieu;
}


public String getMaChatLieu() {
	return maChatLieu;
}

public void setMaChatLieu(String maChatLieu) {
	this.maChatLieu = maChatLieu;
}

public String getChatLieu() {
	return chatLieu;
}

public void setChatLieu(String chatLieu) {
	this.chatLieu = chatLieu;
}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChatLieu;

public class DAO_ChatLieu  {
	public DAO_ChatLieu() {
    }
    
    public ArrayList<ChatLieu> getAllChatLieu(){
        ArrayList<ChatLieu>listChatLieu = new ArrayList<>();
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from ChatLieu";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String maChatLieu = rs.getString(1);
                String ChatLieu =  rs.getString(2);
                ChatLieu cl = new ChatLieu(maChatLieu, ChatLieu);
                listChatLieu.add(cl);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listChatLieu;
    }
    
    public ChatLieu getChatLieu(String maChatLieu){
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from ChatLieu where maChatLieu = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maChatLieu);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ChatLieu E_ChatLieu = new ChatLieu();
                E_ChatLieu.setMaChatLieu(rs.getString(1));
                E_ChatLieu.setChatLieu(rs.getString(2));
                return E_ChatLieu;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean suaChatLieu(ChatLieu E_ChatLieu){ 
    	PreparedStatement sta =  null;
    	int n = 0;
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "update ChatLieu set ChatLieu = (?) where maChatLieu = ?";
            sta = con.prepareStatement(sql);
            sta.setString(1, E_ChatLieu.getChatLieu());
            sta.setString(2, E_ChatLieu.getMaChatLieu());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    }
    
    public boolean themChatLieu(ChatLieu E_ChatLieu){
    	PreparedStatement sta =  null;
    	int n = 0; 
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "insert into ChatLieu(maChatLieu, ChatLieu) values (?, ?)";
            sta = con.prepareStatement(sql);
            sta.setString(1, E_ChatLieu.getMaChatLieu());
            sta.setString(2, E_ChatLieu.getChatLieu());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    } 
    
    public ChatLieu getChatLieuByName(String name){
        
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from ChatLieu where ChatLieu = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setString(1, name);
            ResultSet rs = sta.executeQuery();
            while(rs.next()){
                ChatLieu E_ChatLieu = new ChatLieu();
                E_ChatLieu.setMaChatLieu(rs.getString(1));
                E_ChatLieu.setChatLieu(rs.getString(2));
                return E_ChatLieu;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
}

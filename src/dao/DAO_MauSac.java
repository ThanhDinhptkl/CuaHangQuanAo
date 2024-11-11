package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectDB.ConnectDB;
import entity.MauSac;


public class DAO_MauSac {
	public DAO_MauSac() {
    }
    
    public ArrayList<MauSac> getAllMauSac(){
        ArrayList<MauSac>listMauSac = new ArrayList<>();
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from MauSac";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String maMauSac = rs.getString("MAMAUSAC");
                String mauSac=  rs.getString("MAUSAC");
                MauSac ms = new MauSac(maMauSac, mauSac);
                listMauSac.add(ms);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listMauSac;
    }
    
    public MauSac getMauSac(String maMauSac){
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from MauSac where MAMAUSAC = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maMauSac);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                MauSac e_MauSac = new MauSac();
                e_MauSac.setMaMauSac(rs.getString("MAMAUSAC"));
                e_MauSac.setMauSac(rs.getString("MAUSAC"));
                return e_MauSac;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean suaMauSac(MauSac e_MauSac){ 
    	PreparedStatement sta =  null;
    	int n = 0;
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "update MauSac set mauSac = (?) where maMauSac = ?";
            sta = con.prepareStatement(sql);
            sta.setString(1, e_MauSac.getMauSac());
            sta.setString(2, e_MauSac.getMaMauSac());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    }
    
    public boolean themMauSac(MauSac e_MauSac){
    	PreparedStatement sta =  null;
    	int n = 0; 
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "insert into MauSac(maMauSac, mauSac) values (?, ?)";
            sta = con.prepareStatement(sql);
            sta.setString(1, e_MauSac.getMaMauSac());
            sta.setString(2, e_MauSac.getMauSac());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    } 
    
    public MauSac getMauSacByName(String name){
        
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from MauSac where mauSac = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setString(1, name);
            ResultSet rs = sta.executeQuery();
            while(rs.next()){
                MauSac e_MauSac = new MauSac();
                e_MauSac.setMaMauSac(rs.getString(1));
                e_MauSac.setMauSac(rs.getString(2));
                return e_MauSac;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }

}

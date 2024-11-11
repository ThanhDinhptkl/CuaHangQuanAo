package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiQuanAo;


public class DAO_LoaiQuanAo {
	public DAO_LoaiQuanAo() {
    }
    
    public ArrayList<LoaiQuanAo> getAllLoai(){
        ArrayList<LoaiQuanAo>listLoai = new ArrayList<>();
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from LoaiQuanAo";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String maLoai = rs.getString("MALOAI");
                String Loai =  rs.getString("LOAI");
                LoaiQuanAo loai = new LoaiQuanAo(maLoai, Loai);
                listLoai.add(loai);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listLoai;
    }
    
    public LoaiQuanAo getLoai(String maLoai){
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from LoaiQuanAo where MALOAI = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maLoai);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                LoaiQuanAo Loai = new LoaiQuanAo();
                Loai.setMaLoai(rs.getString("MALOAI"));
                Loai.setLoai(rs.getString("LOAI"));
                return Loai;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean suaLoai(LoaiQuanAo Loai){ 
    	PreparedStatement sta =  null;
    	int n = 0;
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "update LoaiQuanAo set LOAI = (?) where MALOAI = ?";
            sta = con.prepareStatement(sql);
            sta.setString(1, Loai.getLoai());
            sta.setString(2, Loai.getMaLoai());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    }
    
    public boolean themLoai(LoaiQuanAo Loai){
    	PreparedStatement sta =  null;
    	int n = 0; 
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "insert into LOAIQUANAO(MALOAI, LOAI) values (?, ?)";
            sta = con.prepareStatement(sql);
            sta.setString(1, Loai.getMaLoai());
            sta.setString(2, Loai.getLoai());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    } 
    
    public LoaiQuanAo getLoaiByName(String name){
        
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from LOAIQUANAO where LOAI = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setString(1, name);
            ResultSet rs = sta.executeQuery();
            while(rs.next()){
                LoaiQuanAo Loai = new LoaiQuanAo();
                Loai.setMaLoai(rs.getString(1));
                Loai.setLoai(rs.getString(2));
                return Loai;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ThuongHieu;

public class DAO_ThuongHieu {
	public DAO_ThuongHieu() {
    }
    
    public ArrayList<ThuongHieu> getAllThuongHieu(){
        ArrayList<ThuongHieu>listThuongHieu = new ArrayList<>();
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from ThuongHieu";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String maThuongHieu = rs.getString("MATHUONGHIEU");
                String ThuongHieu =  rs.getString("THUONGHIEU");
                ThuongHieu th = new ThuongHieu(maThuongHieu, ThuongHieu);
                listThuongHieu.add(th);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listThuongHieu;
    }
    
    public ThuongHieu getThuongHieu(String maThuongHieu){
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from ThuongHieu where MATHUONGHIEU = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maThuongHieu);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ThuongHieu E_ThuongHieu = new ThuongHieu();
                E_ThuongHieu.setMaThuongHieu(rs.getString(1));
                E_ThuongHieu.setThuongHieu(rs.getString(2));
                return E_ThuongHieu;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean suaThuongHieu(ThuongHieu E_ThuongHieu){ 
    	PreparedStatement sta =  null;
    	int n = 0;
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "update ThuongHieu set ThuongHieu = (?) where maThuongHieu = ?";
            sta = con.prepareStatement(sql);
            sta.setString(1, E_ThuongHieu.getThuongHieu());
            sta.setString(2, E_ThuongHieu.getMaThuongHieu());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    }
    
    public boolean themThuongHieu(ThuongHieu E_ThuongHieu){
    	PreparedStatement sta =  null;
    	int n = 0; 
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "insert into ThuongHieu(maThuongHieu, ThuongHieu) values (?, ?)";
            sta = con.prepareStatement(sql);
            sta.setString(1, E_ThuongHieu.getMaThuongHieu());
            sta.setString(2, E_ThuongHieu.getThuongHieu());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    } 
    
    public ThuongHieu getThuongHieuByName(String name){
        
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from ThuongHieu where ThuongHieu = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setString(1, name);
            ResultSet rs = sta.executeQuery();
            while(rs.next()){
                ThuongHieu E_ThuongHieu = new ThuongHieu();
                E_ThuongHieu.setMaThuongHieu(rs.getString(1));
                E_ThuongHieu.setThuongHieu(rs.getString(2));
                return E_ThuongHieu;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
}

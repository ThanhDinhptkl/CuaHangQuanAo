package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KichCo;


public class DAO_KichCo {

	public DAO_KichCo() {
    }
    
    public ArrayList<KichCo> getAllKichCo(){
        ArrayList<KichCo>listKichCo = new ArrayList<>();
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from KichCo";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String maKichCo = rs.getString(1);
                String KichCo =  rs.getString(2);
                KichCo kc = new KichCo(maKichCo, KichCo);
                listKichCo.add(kc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKichCo;
    }
    
    public KichCo getKichCo(String maKichCo){
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from KichCo where maKichCo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maKichCo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                KichCo E_KichCo = new KichCo();
                E_KichCo.setMaKichCo(rs.getString(1));
                E_KichCo.setKichCo(rs.getString(2));
                return E_KichCo;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean suaKichCo(KichCo E_KichCo){ 
    	PreparedStatement sta =  null;
    	int n = 0;
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "update KichCo set KichCo = (?) where maKichCo = ?";
            sta = con.prepareStatement(sql);
            sta.setString(1, E_KichCo.getKichCo());
            sta.setString(2, E_KichCo.getMaKichCo());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    }
    
    public boolean themKichCo(KichCo E_KichCo){
    	PreparedStatement sta =  null;
    	int n = 0; 
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "insert into KichCo(maKichCo, KichCo) values (?, ?)";
            sta = con.prepareStatement(sql);
            sta.setString(1, E_KichCo.getMaKichCo());
            sta.setString(2, E_KichCo.getKichCo());
            n = sta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n>0;
    } 
    
    public KichCo getKichCoByName(String name){
        
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from KichCo where KichCo = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setString(1, name);
            ResultSet rs = sta.executeQuery();
            while(rs.next()){
                KichCo E_KichCo = new KichCo();
                E_KichCo.setMaKichCo(rs.getString(1));
                E_KichCo.setKichCo(rs.getString(2));
                return E_KichCo;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
}

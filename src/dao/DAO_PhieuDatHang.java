package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatHang;

public class DAO_PhieuDatHang {
	private DAO_NhanVien dao_nhanVien = new DAO_NhanVien();
    private DAO_KhachHang dao_khachHang = new DAO_KhachHang();
	public DAO_PhieuDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	 public ArrayList<PhieuDatHang> getAllPhieuDatHang() {
	        ArrayList<PhieuDatHang> listPhieuDat = new ArrayList<>();
	        try {
	        	Connection con = ConnectDB.getInstance().getConnection();		            
	            String sql = "Select * from PhieuDatHang where MAPHIEUDAT not like 'PDHC%'";
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	                String maPhieuDat = rs.getString(1);
	               KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
	                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
	                Date ngayDat = rs.getDate(4);		                 
	                PhieuDatHang e_PhieuDat = new PhieuDatHang(maPhieuDat, e_KhachHang, e_NhanVien, ngayDat);
	                listPhieuDat.add(e_PhieuDat);
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	        return listPhieuDat;
	    }
	 
	 public ArrayList<PhieuDatHang> getAllPhieuDatHang(String tenKhachHang, String tenNhanVien) {
	        ArrayList<PhieuDatHang> listPhieuDat = new ArrayList<>();
	        try {
	        	Connection con = ConnectDB.getInstance().getConnection();		            
	            
	            String sql = "SELECT         PhieuDatHang.*\n"
	                    + "FROM            PhieuDatHang INNER JOIN\n"
	                    + "                         KhachHang ON PhieuDatHang.MAKH = KhachHang.MAKH INNER JOIN\n"
	                    + "                         NhanVien ON PhieuDatHang.MANV = NhanVien.MANV\n"
	                    + "where NhanVien.TENNV like ? and KhachHang.TENKH like ? and MAPHIEUDAT not like 'PDHC%'";
	            PreparedStatement stmt = con.prepareCall(sql);
	            stmt.setString(1, "%" + tenNhanVien + "%");
	            stmt.setString(2, "%" + tenKhachHang + "%");

	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                String maPhieuDat = rs.getString(1);
	                Date ngayDat = rs.getDate(4);
	                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
	                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
	                PhieuDatHang e_PhieuDat = new PhieuDatHang(maPhieuDat, e_KhachHang, e_NhanVien, ngayDat);
	                listPhieuDat.add(e_PhieuDat);
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return listPhieuDat;
	    }
	 
	 public int addPhieuDat(PhieuDatHang e_PhieuDat) {
	        try {
	        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
	            
	            String sql = "insert into PhieuDatHang(MAPHIEUDAT, MAKH, MANV, NGAYDAT) values (?, ?, ?, ?)";
	            PreparedStatement stmt = con.prepareCall(sql);
	            stmt.setString(1, e_PhieuDat.getMaPhieuDat());
	            stmt.setString(2, e_PhieuDat.getKhachHang().getMaKH());
	            stmt.setString(3, e_PhieuDat.getNhanVien().getMaNV());
	            stmt.setDate(4, e_PhieuDat.getNgayDat());         
	            return stmt.executeUpdate();
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	        return -1;
	    }
}

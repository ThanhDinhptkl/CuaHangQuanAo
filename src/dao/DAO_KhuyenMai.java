package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.KhuyenMai;


public class DAO_KhuyenMai  {

	public DAO_KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 public ArrayList<KhuyenMai> getAllKhuyenMai() {
	        ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
	        try {
	        	Connection con = ConnectDB.getInstance().getConnection();
	            String sql = "Select * from KhuyenMai";
	            PreparedStatement stmt = con.prepareCall(sql);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	KhuyenMai km = new KhuyenMai();
	            	km.setMaKM(rs.getString("MAKM"));
	            	km.setNgayBatDau(rs.getDate("NGAYBATDAU"));
	            	km.setNgayKetThuc(rs.getDate("NGAYKETTHUC"));
	            	km.setMucGiamGia(rs.getDouble("MUCGIAMGIA"));
	                
	                 dsKM.add(km);
	            }
	        } catch (SQLException ex) {
	        	// TODO: handle exception
	        	ex.printStackTrace();
	        }
	        return dsKM;
	    }
	 
	 public KhuyenMai getKhuyenMai (String maKm) {
		 KhuyenMai km = null;
		 PreparedStatement sta = null;
	         try {
	        	ConnectDB.getInstance();
	 			Connection con = ConnectDB.getConnection();
	        	String sql = "select * from KhuyenMai where MAKM = ?";
	            sta = con.prepareStatement(sql);
	        	
	            sta.setString(1, maKm);
	            ResultSet rs = sta.executeQuery();
	   
	            while (rs.next()) {
	                String maKM = rs.getString("MAKM");
	                Date ngayBatDau = rs.getDate("NGAYBATDAU");
	                Date ngayKetThuc = rs.getDate("NGAYKETTHUC");
	                Double mucGiamGia = rs.getDouble("MUCGIAMGIA");
	                km = new KhuyenMai(maKM, ngayBatDau, ngayKetThuc, mucGiamGia);
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	         finally {
	 			try {
	 				sta.close();
	 			} catch (SQLException e) {
	 				// TODO: handle exception
	 				e.printStackTrace();
	 			}
	 		}
	 		return km;
	    }
	//themKM
		
		public boolean themKM(KhuyenMai kM) {
			PreparedStatement sta = null;
			int n = 0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "insert into KhuyenMai values (?,?,?,?) ";
				sta = con.prepareStatement(sql);
				
				sta.setString(1, kM.getMaKM());
				Date ngayBatDauSql = new Date(kM.getNgayBatDau().getTime());
				sta.setDate(2, ngayBatDauSql);
				Date ngayKetThucSql = new Date(kM.getNgayKetThuc().getTime());
				sta.setDate(3, ngayKetThucSql);
				sta.setDouble(4, kM.getMucGiamGia());

				n = sta.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				try {
					sta.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return n > 0;
		}
		
		 public int updateKhuyenMai(KhuyenMai e_KhuyenMai){
		        
		        try {
		        	ConnectDB.getInstance();
					Connection con = ConnectDB.getConnection();					
		            String sql = "update KhuyenMai set NGAYBATDAU = ?,NGAYKETTHUC = ?,MUCGIAMGIA = ? where MAKM = ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            long dateBD = e_KhuyenMai.getNgayBatDau().getTime();
		            stmt.setDate(1, new Date(dateBD));
		          
		            long dateKT = e_KhuyenMai.getNgayKetThuc().getTime();

		            stmt.setDate(2, new Date(dateKT));
		            stmt.setDouble(3, e_KhuyenMai.getMucGiamGia());
		            stmt.setString(5, e_KhuyenMai.getMaKM());
		            return stmt.executeUpdate();
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return -1;
		    }
		public KhuyenMai getKhuyenMaiByPhanTram(int phanTram) {
	  

	        try {
	        	ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
	            String sql = "select * from KhuyenMai where MUCGIAMGIA = ?";
	            PreparedStatement stmt = con.prepareCall(sql);
	            stmt.setInt(1, phanTram);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                KhuyenMai e_KhuyenMai = new KhuyenMai();
	                e_KhuyenMai.setMaKM(rs.getString(1));
	                e_KhuyenMai.setNgayBatDau(rs.getDate(2));
	                e_KhuyenMai.setNgayKetThuc(rs.getDate(3));
	                e_KhuyenMai.setMucGiamGia(rs.getDouble(4));

	                return e_KhuyenMai;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }
		
}

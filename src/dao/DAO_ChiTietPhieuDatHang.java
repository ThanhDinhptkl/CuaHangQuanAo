package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChatLieu;
import entity.ChiTietPhieuDatHang;
import entity.KichCo;
import entity.LoaiQuanAo;
import entity.MauSac;
import entity.PhieuDatHang;
import entity.QuanAo;
import entity.ThuongHieu;
import entity.GioHang;

public class DAO_ChiTietPhieuDatHang {
	private DAO_QuanAo dao_QuanAo = new DAO_QuanAo();
	private DAO_PhieuDatHang dao_PhieuDat = new DAO_PhieuDatHang();
	private DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	private DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
	private GioHang GioHang;
	public DAO_ChiTietPhieuDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<ChiTietPhieuDatHang> getAllCTPDByPhieuDatHang(PhieuDatHang e_PhieuDat){
		ArrayList<ChiTietPhieuDatHang>listChiTietPhieuDat = new ArrayList<>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();		            

			String sql = "Select * from ChiTietPhieuDatHang where MAPHIEUDAT = ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, e_PhieuDat.getMaPhieuDat());

			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				QuanAo e_QuanAo = dao_QuanAo.TimKiemQuanAoTheoMa(rs.getString(2));               
				int soLuong = rs.getInt(3);          
				ChiTietPhieuDatHang CTPDH = new ChiTietPhieuDatHang(e_PhieuDat, e_QuanAo, soLuong);
				listChiTietPhieuDat.add(CTPDH);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listChiTietPhieuDat;
	}
	public int deleteCTPDH(PhieuDatHang phd){


		try {
			Connection con = ConnectDB.getInstance().getConnection();		            

			String sql = "Delete from ChiTietPhieuDatHang where MAPHIEUDAT = ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, phd.getMaPhieuDat());

			return stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	public int addChiTietPhieuDatHang(ChiTietPhieuDatHang e_ChiTietPhieuDat){
		try {
			Connection con = ConnectDB.getInstance().getConnection();		            

			String sql = "insert into ChiTietPhieuDatHang values (?, ?, ?)";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, e_ChiTietPhieuDat.getPhieuDatHang().getMaPhieuDat());
			stmt.setString(2, e_ChiTietPhieuDat.getQuanAo().getMaQuanAo());
			stmt.setInt(3, e_ChiTietPhieuDat.getSoLuong());

			return stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	 public ArrayList<GioHang> getSanPhamGioHang(String maPhieuDatHang) throws SQLException {
	        ArrayList<GioHang> danhSachSanPham = new ArrayList<>();
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();

	        CallableStatement cstmt = null;
	        try {
	            String sql = "{call GetOrderDetails(?)}";
	            cstmt = con.prepareCall(sql);
	            cstmt.setString(1, maPhieuDatHang);
	            ResultSet rs = cstmt.executeQuery();
	            while (rs.next()) {
	            	GioHang gioHang = new GioHang();
	                QuanAo maQA = new QuanAo();
	                
	                maQA.setMaQuanAo(rs.getString("MAQUANAO"));  
	                gioHang.setMaQA(maQA);
	                
	                QuanAo tenQA = new QuanAo();
	                tenQA.setTenQuanAo(rs.getString("TENQUANAO")); 
	                gioHang.setTenQA(tenQA);
	                
	                QuanAo donGiaBan = new QuanAo();
	                donGiaBan.setDonGiaBan(rs.getDouble("GIA")); 
	                gioHang.setDonGiaBan(donGiaBan);
	                
	                ChiTietPhieuDatHang soLuong = new ChiTietPhieuDatHang();
	                soLuong.setSoLuong(rs.getInt("SOLUONGDAT"));
	                gioHang.setSoLuong(soLuong);
	                
	                LoaiQuanAo loai  = new LoaiQuanAo();
	                loai.setLoai(rs.getString("LOAI"));
	                gioHang.setLoai(loai);
	                
	                MauSac mauSac = new MauSac();
	                mauSac.setMauSac(rs.getString("MAUSAC"));
	                gioHang.setMauSac(mauSac);
	                
	                ChatLieu chatLieu = new ChatLieu();
	                chatLieu.setChatLieu(rs.getString("CHATLIEU"));
	                gioHang.setChatLieu(chatLieu);
	                
	                KichCo kichCo = new KichCo();
	                kichCo.setKichCo(rs.getString("KICHCO"));
	                gioHang.setKichCo(kichCo);
	                
	                ThuongHieu thuongHieu = new ThuongHieu();
	                thuongHieu.setThuongHieu(rs.getString("THUONGHIEU"));
	                gioHang.setThuongHieu(thuongHieu);
	                
	            	danhSachSanPham.add(gioHang);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return danhSachSanPham;
	    }

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;

public class DAO_TaiKhoan {

	public DAO_TaiKhoan() {
	
	}
	
	public ArrayList<TaiKhoan> getAllTaiKhoan(){
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * From TaiKhoan";
			Statement sta = con.createStatement();
			
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				String maDN = rs.getString("MADANGNHAP");
				String matKhau = rs.getString("MATKHAU");
				String quyen = rs.getString("PHANQUYEN");
				
				TaiKhoan tk = new TaiKhoan(maDN, matKhau, quyen);
				dsTK.add(tk);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTK;
	}
	
	public TaiKhoan getTheoMaTK (String maTK) {
		TaiKhoan tk = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * From TaiKhoan where MADANGNHAP = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maTK);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maDN = rs.getString("MADANGNHAP");
				String matKhau = rs.getString("MATKHAU");
				String quyen = rs.getString("PHANQUYEN");
				
				tk = new TaiKhoan(maDN, matKhau, quyen);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				sta.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return tk;
	}
	
	public boolean them(TaiKhoan tk) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into TaiKhoan values (?,?,?)";
			sta = con.prepareStatement(sql);
			
			sta.setString(1, tk.getMaDangNhap());
			sta.setString(2, tk.getMatKhau());
			sta.setString(3, tk.getPhanQuyen());
			n = sta.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public boolean sua(TaiKhoan tk) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update TaiKhoan set MATKHAU = ?, PHANQUYEN = ? where MADANGNHAP = ?";
			sta = con.prepareStatement(sql);
			
			sta.setString(1, tk.getMatKhau());
			sta.setString(2, tk.getPhanQuyen());
			sta.setString(3, tk.getMaDangNhap());
			n = sta.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public boolean xoa(String maTK) {
		PreparedStatement sta = null;
		int n = 0 ;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from TaiKhoan where MADANGNHAP = ?";
			sta = con.prepareStatement(sql);
			
			sta.setString(1, maTK);
			n = sta.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	//public E_TaiKhoan capNhat()
	public boolean capNhat(TaiKhoan tk) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "update TaiKhoan set MATKHAU = ?, PHANQUYEN = ? where MADANGNHAP = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, tk.getMatKhau());
			sta.setString(2, tk.getPhanQuyen());
			sta.setString(3, tk.getMaDangNhap());
			n = sta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}


}

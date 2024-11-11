package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;



public class DAO_KhachHang  {
	public DAO_KhachHang() {

	}

	public ArrayList<KhachHang> getALLKhachHang(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhachHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String maKH = rs.getString("MAKH");
				String tenKH = rs.getString("TENKH");
				String sDT = rs.getString("SDT");
				boolean gioiTinh = rs.getBoolean("GIOITINH");
				String email = rs.getString("EMAIL");

				KhachHang kh = new KhachHang(maKH, tenKH, sDT, gioiTinh, email);
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsKH;
	}
	//themKH

	public boolean themKH(KhachHang kh) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into KhachHang values (?,?,?,?,?) ";
			sta = con.prepareStatement(sql);

			sta.setString(1, kh.getMaKH());
			sta.setString(2, kh.getTenKH());
			sta.setString(3, kh.getsDT());
			sta.setBoolean(4, kh.isGioiTinh());
			sta.setString(5, kh.getEmail());
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
	public boolean suaKH(KhachHang kh) {
		PreparedStatement sta = null;

		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "UPDATE KhachHang SET TENKH = ?, SDT = ?, GIOITINH = ?, EMAIL = ? WHERE MAKH = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, kh.getTenKH());
			sta.setString(2, kh.getsDT());
			sta.setBoolean(3, kh.isGioiTinh());
			sta.setString(4, kh.getEmail());
			sta.setString(5, kh.getMaKH());

			n= sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}

	//tim kiem theo maKH
	public KhachHang getTheoMaKH(String maKh) {
		KhachHang kh = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang where MAKH = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maKh);
			ResultSet rs = sta.executeQuery();
			while(rs.next()) {
				String maKH = rs.getString("MAKH");
				String tenKH = rs.getString("TENKH");
				boolean gioiTinh = rs.getBoolean("GIOITINH");
				String sDT = rs.getString("SDT");
				String email = rs.getString("EMAIL");

				kh = new KhachHang(maKH, tenKH, sDT, gioiTinh, email);

			}
		}catch (SQLException e) {
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
		return kh;
	}
	//tim kiem theo tenKH

	public KhachHang getTheoTenKH(String tenKH) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang where TENKH = ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, tenKH);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				KhachHang e_KhachHang = new KhachHang();
				e_KhachHang.setMaKH(rs.getString(1));
				e_KhachHang.setTenKH(rs.getString(2));
				e_KhachHang.setsDT(rs.getString(3));
				e_KhachHang.setGioiTinh(rs.getBoolean(4));
				e_KhachHang.setEmail(rs.getString(5));
				return e_KhachHang;	
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	//		//tim kiem theo sDT
	//	
	public KhachHang getTheoSDT(String sdt) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang where SDT = ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, sdt);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				KhachHang e_KhachHang = new KhachHang();
				e_KhachHang.setMaKH(rs.getString(1));
				e_KhachHang.setTenKH(rs.getString(2));
				e_KhachHang.setsDT(rs.getString(3));
				e_KhachHang.setGioiTinh(rs.getBoolean(4));
				e_KhachHang.setEmail(rs.getString(5));
				return e_KhachHang;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	//		//suaKH
	//	
	//		public boolean suaKH(KhachHang kh) {
	//			PreparedStatement sta = null;
	//			int n = 0;
	//			try {
	//				ConnectDB.getInstance();
	//				Connection con = ConnectDB.getConnection();
	//				String sql = "update NhaKHien set TENKH = ?,NGAYSINH= ?, GIOITINH = ?, SDT =?, DIACHI = ?, EMAIL = ? where MAKH = ? ";
	//				sta = con.prepareStatement(sql);
	//				
	//				
	//				sta.setString(1, kh.getTenKH());
	//				sta.setDate(2, (Date) kh.getNgaySinh());
	//				sta.setBoolean(3, KH.isGioiTinh());
	//				sta.setString(4, KH.getsDT());
	//				sta.setString(5, KH.getDiaChi());
	//				sta.setString(6, KH.getEmail());
	//				sta.setString(7, KH.getMaKH());
	//				n = sta.executeUpdate();
	//			}catch (Exception e) {
	//				// TODO: handle exception
	//				e.printStackTrace();
	//			} finally {
	//				try {
	//					sta.close();
	//				} catch (SQLException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//			return n > 0;
	//		}
	//		//xoaKH

	public boolean xoa(String maKh) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "delete from KhachHang where MAKH = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, maKh);
			n = sta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public ArrayList<KhachHang> timTheoTieuChi(String ma, String ten, String sdt) {
		ArrayList<KhachHang> dsKh = new ArrayList<>();
		PreparedStatement sta = null;

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			StringBuilder sql = new StringBuilder("SELECT * FROM KhachHang WHERE 1=1");

			if (!ma.isEmpty()) {
				sql.append(" AND MAKH = ?");
			}

			if (!ten.isEmpty()) {
				sql.append(" AND TENKH = ?");
			}

			if (!sdt.isEmpty()) {
				sql.append(" AND SDT = ?");
			} 	

			sta = con.prepareStatement(sql.toString());

			int parameterIndex = 1;
			if (!ma.isEmpty()) {
				sta.setString(parameterIndex++, ma);
			}

			if (!ten.isEmpty()) {
				sta.setString(parameterIndex++, ten);
			}

			if (!sdt.isEmpty()) {
				sta.setString(parameterIndex++, sdt);
			}

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maKH = rs.getString("MAKH");
				String tenKH = rs.getString("TENKH");
				boolean gioiTinh = rs.getBoolean("GIOITINH");
				String sDT = rs.getString("SDT");
				String email = rs.getString("EMAIL");

				KhachHang kh  = new KhachHang(maKH, tenKH,sDT, gioiTinh, email);
				dsKh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsKh;
	}
}
